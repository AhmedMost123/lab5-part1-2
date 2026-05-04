/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

// We need this import for assertEquals
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test;

class CoffeeMachineBottomUpTest {

    @Test
    void testBlackCoffeeMaker_ReducesIngredients() {
        // ARRANGE
        // We need a CoffeeMachine just to hold the state
        CoffeeMachine state = new CoffeeMachine(null, null);
        state.setCoffeePowder(100.0); // Start with 100
        state.setWater(5.0);          // Start with 5.0

        // This is our low-level module under test
        BlackCoffeeMaker realBlackCoffeeMaker = new BlackCoffeeMaker();
        
        // ACT
        // The test "drives" the low-level module
        boolean success = realBlackCoffeeMaker.make(state);

        // ASSERT
        // Check that the method reported success
        assertTrue(success);
        
        // --- THIS IS THE "ASSERT EQUALS" ---
        // We assert that the expected value (90.0) is EQUAL to
        // the actual value (state.getCoffeePowder()).
        assertEquals(90.0, state.getCoffeePowder());
        
        // We also check the water
        assertEquals(4.8, state.getWater());
    }
}