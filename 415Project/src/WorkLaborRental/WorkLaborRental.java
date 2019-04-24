package WorkLaborRental;

import java.util.ArrayList;
import java.util.Map;

public class WorkLaborRental {
    private ArrayList<Employee> topWorkedList;
    private Map<String,Employee> workerOfTheMonth;

    public WorkLaborRental(ArrayList<WorkLaborRental.Employee> topWorkedList, Map<String, WorkLaborRental.Employee> workerOfTheMonth) {
        this.topWorkedList = topWorkedList;
        this.workerOfTheMonth = workerOfTheMonth;
    }

    public void requestDiscount(WorkLaborUser user, Employee worker, double discountAmount){

    }
}
