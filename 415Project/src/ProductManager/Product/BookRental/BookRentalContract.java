package ProductManager.Product.BookRental;

public class BookRentalContract {
    private double penaltyPerDay;
    private boolean cargoDelivery;

    public BookRentalContract(double penaltyPerDay, boolean cargoDelivery) {
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
