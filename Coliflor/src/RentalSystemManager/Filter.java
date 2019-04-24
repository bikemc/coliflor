package RentalSystemManager;

import java.util.ArrayList;

public interface Filter {
    public ArrayList<Publication> filter(String filterType, String filterOptions);
}
