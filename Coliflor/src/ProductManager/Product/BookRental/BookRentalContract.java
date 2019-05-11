package ProductManager.Product.BookRental;

import RentalSystemManager.Contract;
import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.util.Date;

public class BookRentalContract extends Contract {
    private double penaltyPerDay;
    private boolean cargoDelivery;
    public BookRentalContract(User user, Publication publication, Date startDate, Date endDate, double penaltyPerDay, boolean cargoDelivery) {
        super(user, publication, startDate, endDate);
        this.penaltyPerDay = penaltyPerDay;
        this.cargoDelivery = cargoDelivery;
    }

    public double getPenaltyPerDay() {
        return penaltyPerDay;
    }

    public void setPenaltyPerDay(double penaltyPerDay) {
        this.penaltyPerDay = penaltyPerDay;
    }

    public boolean isCargoDelivery() {
        return cargoDelivery;
    }

    public void setCargoDelivery(boolean cargoDelivery) {
        this.cargoDelivery = cargoDelivery;
    }

}
