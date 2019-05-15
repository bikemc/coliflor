package ProductManager.Product.WorkLaborRental;

import RentalSystemManager.Contract;
import RentalSystemManager.Publication;
import RentalSystemManager.User;
import java.util.Date;

public class WorkLaborRentalContract extends Contract {
    double deposit;

    public WorkLaborRentalContract(User user, Publication publication, Date startDate, Date endDate, double deposit) {
        super(user, publication, startDate, endDate);
        this.deposit = deposit;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }
}
