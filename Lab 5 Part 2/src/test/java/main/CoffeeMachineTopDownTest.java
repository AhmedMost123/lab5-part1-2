package main;
import org.junit.jupiter.api.BeforeEach; // <-- NEW IMPORT
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CoffeeMachineTopDownTest {

    // These create the MOCKS (the fake low-level objects)
    @Mock
    private CoffeeMaker blackCoffeeMakerMock;

    @Mock
    private CoffeeMaker milkCoffeeMakerMock;

     //This is the high-level object we are testing.   
    private CoffeeMachine coffeeMachine;

    //This method runs before each @Test.
    // It manually creates the CoffeeMachine and passes the mocks directly into its constructor.
    @BeforeEach
    void setUp() 
    {
        // Manually create the class under test and inject the mocks
        coffeeMachine = new CoffeeMachine(blackCoffeeMakerMock, milkCoffeeMakerMock);
    }

    @Test
    void testMakeCoffee_WhenChoiceIs1_CallsBlackCoffeeMaker() {
        int choice = 1;
        when(blackCoffeeMakerMock.make(any(CoffeeMachine.class))).thenReturn(true);
        // Call the method on the object we created in setUp()
        coffeeMachine.makeCoffee(choice);

        // This should now pass, because 'coffeeMachine' is guaranteed to contain our mock.
        verify(blackCoffeeMakerMock, times(1)).make(coffeeMachine);
        verify(milkCoffeeMakerMock, never()).make(any());
    }

    @Test
    void testMakeCoffee_WhenChoiceIs2_CallsMilkCoffeeMaker() {
        // ARRANGE
        int choice = 2;
        when(milkCoffeeMakerMock.make(any(CoffeeMachine.class))).thenReturn(true);
        coffeeMachine.makeCoffee(choice);
        verify(milkCoffeeMakerMock, times(1)).make(coffeeMachine);
        verify(blackCoffeeMakerMock, never()).make(any());
    }
}