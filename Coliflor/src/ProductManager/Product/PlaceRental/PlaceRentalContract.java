package ProductManager.Product.PlaceRental;

import RentalSystemManager.Contract;
import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.util.Date;

/**
 * Created by pc on 24.04.2019.
 */
public class PlaceRentalContract extends Contract{

    double deposit;

    public PlaceRentalContract(User user, Publication publication, Date startDate, Date endDate, double deposit) {
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
