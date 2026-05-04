public class BookingService {

    public boolean getAvailability() {
        checkAvailability();
        return true;
    }

    private void checkAvailability() {
        System.out.println("Checking availability...");
    }

    public void setStatus(int status) {
        System.out.println("Setting status to " + status);
    }
}
