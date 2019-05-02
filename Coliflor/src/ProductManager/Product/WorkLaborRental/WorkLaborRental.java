package ProductManager.Product.WorkLaborRental;

import ProductManager.CommonalityManager.BookWork.BookWork;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class WorkLaborRental extends Rental implements BookWork,WorkPlace, Filter {
    private ArrayList<Employee> topWorkedList;
    private Map<String,Employee> workerOfTheMonth;

    public WorkLaborRental(ArrayList<User> users, ArrayList<Publication> publications, ArrayList<Payment> payments, ArrayList<Contract> contracts,ArrayList<Employee> topWorkedList, Map<String, Employee> workerOfTheMonth) {
        super(users, publications, payments, contracts);
        this.topWorkedList = topWorkedList;
        this.workerOfTheMonth = workerOfTheMonth;
    }

    public void requestDiscount(WorkLaborUser user, Employee worker, double discountAmount){

    }

    @Override
    public ArrayList<Publication> giveRecommendation(User user) {
        return null;
    }

    @Override
    public ArrayList<Publication> listPositivelyRated() {
        return null;
    }

    @Override
    public ArrayList<Publication> listNegativelyRated() {
        return null;
    }

    @Override
    public ArrayList<Date> checkSchedule(Publication publication) {
        return null;
    }

    @Override
    public boolean payDeposit(User user, Publication publication) {
        return false;
    }

    @Override
    public ArrayList<Publication> filter(String filterType, String filterOptions) {
        return null;
    }
}
