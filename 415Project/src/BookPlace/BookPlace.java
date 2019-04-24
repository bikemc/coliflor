package BookPlace;

import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.security.PublicKey;
import java.util.Date;

public interface BookPlace {
    public void shareInSocialMedia(User user, Publication publication, String socialMedia);
    public boolean checkCurrentAvailability(Publication publication, Date currentDate);
}
