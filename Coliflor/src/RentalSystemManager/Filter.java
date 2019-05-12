package RentalSystemManager;

import java.util.ArrayList;

public interface Filter <PublicationT>{
    public ArrayList<PublicationT> filter(String filterType, Object... filterOptions);
}
