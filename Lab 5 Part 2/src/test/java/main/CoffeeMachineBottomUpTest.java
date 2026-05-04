package main;

// We need this import for assertEquals
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

class CoffeeMachineBottomUpTest {

    @Test
    void testBlackCoffeeMaker_ReducesIngredients() {
        // We need a CoffeeMachine just to hold the state
        CoffeeMachine state = new CoffeeMachine(null, null);
        state.setCoffeePowder(100.0); // Start with 100
        state.setWater(5.0);          // Start with 5.0

        // low-level module under test
        BlackCoffeeMaker realBlackCoffeeMaker = new BlackCoffeeMaker();
        
        // The test "drives" the low-level module
        boolean success = realBlackCoffeeMaker.make(state);

        // Check that the method reported success
        assertTrue(success);

        // We assert that the expected value (90.0) is EQUAL to
        // the actual value (state.getCoffeePowder()).
        assertEquals(90.0, state.getCoffeePowder());
        // We also check the water
        assertEquals(4.8, state.getWater());
    }
}
