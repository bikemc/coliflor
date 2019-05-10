package ProductManager.CommonalityManager.BookPlace;

import RentalSystemManager.Publication;
import RentalSystemManager.User;

import java.security.PublicKey;
import java.util.Date;

public interface BookPlace {
    public boolean shareInSocialMedia(User user, Publication publication, String socialMedia);
    public boolean checkAvailability(Publication publication, Date date);
}
