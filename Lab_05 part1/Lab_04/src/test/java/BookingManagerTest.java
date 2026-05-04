import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {
    private BookingService bookingService;
    private BookingManager bookingManager;
    @BeforeEach
    void setUp() {
        bookingService = mock(BookingService.class);
        bookingManager = new BookingManager(bookingService);

        when(bookingService.getAvailability()).thenReturn(true);
    }

    @Test
    public void testAvailability() {
        assertTrue(bookingManager.checkAvailability());
    }
}
