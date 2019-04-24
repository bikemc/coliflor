package ProductManager.Product.WorkLaborRental;

import ProductManager.CommonalityManager.BookWork.BookWork;
import ProductManager.CommonalityManager.WorkPlace.WorkPlace;
import RentalSystemManager.Filter;
import RentalSystemManager.Publication;
import RentalSystemManager.Rental;
import RentalSystemManager.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class WorkLaborRental extends Rental implements BookWork,WorkPlace, Filter {
    private ArrayList<Employee> topWorkedList;
    private Map<String,Employee> workerOfTheMonth;

    public WorkLaborRental(ArrayList<Employee> topWorkedList, Map<String, Employee> workerOfTheMonth) {
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
