package ProductManager.Product.WorkLaborRental;

import ProductManager.CommonalityManager.BookWork.BookWork;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.*;

import java.util.*;

import static ProductManager.Product.BookRental.BookRental.AUTHOR_FILTER;

public class WorkLaborRental extends Rental<Employee, WorkLaborUser, Publication, WorkLaborRentalContract> implements BookWork,WorkPlace<Employee> {
    private ArrayList<Employee> topWorkedList;
    private Employee workerOfTheMonth;

    public static final String EXPERIENCE_YEAR_FILTER= "experience";
    public static final String  OCCUPATION_FILTER = "occupation";
    public static final String RATING_FILTER = "rating";
    public static final String EMPLOYEE_FILTER= "name";

    public WorkLaborRental(ArrayList<WorkLaborUser> users, ArrayList<Publication> publications, ArrayList<Employee> products, ArrayList<Payment> payments, ArrayList<WorkLaborRentalContract> contracts) {
        super(users, publications, products, payments, contracts);
        setTopWorkedList();
        setWorkerOfTheMonth();
    }

    public boolean requestDiscount(WorkLaborUser user, Employee worker, double discountAmount){
       if(new Random().nextBoolean()){
           worker.setPrice(worker.getPrice()- discountAmount);
           return true;
       }
       return false;
    }

    @Override
    public ArrayList<Publication> giveRecommendation() {
        Random rand = new Random();
        ArrayList<Publication> recomendationList = new ArrayList<>();
        int randomIndex = rand.nextInt(publications.size());
        for (int i = 0; i < randomIndex; i++) {
            recomendationList.add(publications.get(rand.nextInt(publications.size())));
        }
        return recomendationList;
    }
    @Override
    public String meetingLocation (Product employee){
        if(currentUser.getAddress().equals(((Employee)employee).getAddress()))  {
            return currentUser.getAddress();
        }
        return null;
    }
    @Override
    public boolean signup(String username, String email, String address, String password, Date birth, String name, long phoneNo) {
        if(super.signup(username, email, address, password, birth, name, phoneNo)) {
            WorkLaborUser newUser = new WorkLaborUser(name,email, address,username, phoneNo, password, birth, null, null, null, null, null);
            users.add(newUser);
            currentUser = newUser; // konuşalım grupça
            return true;
        }
        return false;
    }
    @Override
    public ArrayList<Employee> listPositivelyRated() {
        ArrayList<Employee> positivelyRated = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            positivelyRated.add((Employee) products.get(i));
        }
        Collections.sort(positivelyRated);
        return positivelyRated;
    }

    @Override
    public ArrayList<Employee> listNegativelyRated() {
        ArrayList<Employee> negativelyRated = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            negativelyRated.add((Employee) products.get(i));
        }
        Collections.sort( negativelyRated);
        Collections.reverse( negativelyRated);
     return  negativelyRated;
    }

    @Override
    public ArrayList<Date> checkSchedule(Publication publication) {
        return ((Employee)publication.getProduct()).getSchedule() ;
    }

    @Override
    public boolean payDeposit(User user, Publication publication) {
        if(currentUser != null) {
            if(checkCreaditCardInformation(8,null,null,0,0,0)) {
                publication.getProduct().setPrice(publication.getProduct().getPrice()- ((WorkLaborRentalContract)publication.getContract()).getDeposit());
                return true;
            }
        }
        return false;
    }

    public ArrayList<Employee> getTopWorkedList() {
        return topWorkedList;
    }

    @Override
    public ArrayList<Employee> searchProduct(String searchKey) {
        ArrayList<Employee> searchResult = new ArrayList<>();
        for(int i=0; i<publications.size(); i++){
            if(((Employee)publications.get(i).getProduct()).getEmployeeName().contains(searchKey)){
                searchResult.add(products.get(i));
                if(currentUser.getSearchHistory()== null) currentUser.setSearchHistory(new ArrayList<Publication>());
                currentUser.getSearchHistory().add(publications.get(i));
            }
        }
        return searchResult;
    }

    public void setTopWorkedList() {
        Collections.sort(products);
        this.topWorkedList = products;
    }

    public Employee getWorkerOfTheMonth() {
        return workerOfTheMonth;
    }

    public void setWorkerOfTheMonth() {
        Collections.sort(products);
        this.workerOfTheMonth = products.get(0);
    }

    @Override
    public ArrayList<Publication> filter(String filterType, Object... filterOptions) {

        ArrayList<Publication> searchResult = new ArrayList<Publication>();
        switch (filterType){
            case FILTER_DESCRPTION:
                searchResult =  super.searchPublication((String)filterOptions[0]);
                break;
            case EXPERIENCE_YEAR_FILTER:
                int lowerBound = (int)filterOptions[0];
                int upperBound = (int)filterOptions[1];
                for (int i = 0; i < publications.size(); i++){
                    if(((Employee)publications.get(i).getProduct()).getExperiencedYears() > lowerBound && ((Employee)publications.get(i).getProduct()).getExperiencedYears()< upperBound) {
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case OCCUPATION_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Employee)publications.get(i).getProduct()).getOccupation().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case RATING_FILTER:
                int lowerBoundRate = (int)filterOptions[0];
                int upperBoundRate = (int)filterOptions[1];
                for (int i = 0; i < publications.size(); i++){
                    if(((Employee)publications.get(i).getProduct()).getRating()> lowerBoundRate && ((Employee)publications.get(i).getProduct()).getRating()< upperBoundRate) {
                        searchResult.add(publications.get(i));
                    }
                }
                break;
            case EMPLOYEE_FILTER:
                for(int i=0; i<publications.size(); i++){
                    if(((Employee)publications.get(i).getProduct()).getEmployeeName().contains((String)filterOptions[0])){
                        searchResult.add(publications.get(i));
                    }
                }
                break;

        }
        return searchResult;
    }

    @Override
    public Contract makeContract(Publication publication, Date startDate, Date endDate, Object... contractTypes) {
        WorkLaborRentalContract contract= new WorkLaborRentalContract(currentUser,publication, startDate,endDate,(int)contractTypes[0]);
        return contract;
    }
}
