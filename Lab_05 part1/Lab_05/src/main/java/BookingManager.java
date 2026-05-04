public class BookingManager {
    private BookingService bookingService;
    // Dependency Injection
    public BookingManager(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public boolean checkAvailability() {
        return this.bookingService.getAvailability();
    }

    public void setStatus(int status) {
        this.bookingService.setStatus(status);
    }
}
