package BookPlace;

import java.security.PublicKey;

public interface BookPlace {
    public void shareInSocialMedia(User user, Publication publication, String socialMedia);
    public boolean checkCurrentAvailability(Publication publication, Date currentDate);
}
