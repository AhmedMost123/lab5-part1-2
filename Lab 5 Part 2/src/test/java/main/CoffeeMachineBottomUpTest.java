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

        // low level module under test
        BlackCoffeeMaker realBlackCoffeeMaker = new BlackCoffeeMaker();
        
        // The test drives the low-level module
        boolean success = realBlackCoffeeMaker.make(state);

        // Check that the method reported success
        assertTrue(success);

        // We assert that the expected value (90.0) is equal to the actual value (state.getCoffeePowder()).
        assertEquals(90.0, state.getCoffeePowder());
        // We also check the water
        assertEquals(4.8, state.getWater());
    }
    @Test
    void testBlackCoffeeMaker_Fails_WhenNotEnoughWater() {
        CoffeeMachine state = new CoffeeMachine(null, null);
        state.setCoffeePowder(100.0);
        state.setWater(0.1); // insufficient

        BlackCoffeeMaker maker = new BlackCoffeeMaker();

        boolean success = maker.make(state);

        assertFalse(success);
        assertEquals(100.0, state.getCoffeePowder(), 0.0001); // unchanged
        assertEquals(0.1, state.getWater(), 0.0001);
    }
    @Test
    void testMilkCoffeeMaker_ReducesIngredients() {
        CoffeeMachine state = new CoffeeMachine(null, null);
        state.setCoffeePowder(100.0);
        state.setWater(5.0);
        state.setMilk(2.0);

        MilkCoffeeMaker maker = new MilkCoffeeMaker();

        boolean success = maker.make(state);

        assertTrue(success);
        assertEquals(90.0, state.getCoffeePowder());
        assertEquals(4.8, state.getWater());
        assertEquals(1.6, state.getMilk());
    }

    @Test
    void testMilkCoffeeMaker_Fails_WhenNotEnoughMilk() {
        CoffeeMachine state = new CoffeeMachine(null, null);
        state.setCoffeePowder(100.0);
        state.setWater(5.0);
        state.setMilk(0.1); // insufficient

        MilkCoffeeMaker maker = new MilkCoffeeMaker();

        boolean success = maker.make(state);

        assertFalse(success);
        assertEquals(100.0, state.getCoffeePowder());
        assertEquals(5.0, state.getWater());
        assertEquals(0.1, state.getMilk());
    }
}
