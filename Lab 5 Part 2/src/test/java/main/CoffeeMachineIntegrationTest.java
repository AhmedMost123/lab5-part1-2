package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineIntegrationTest {

    @Test
    void testMakeCoffee_Integration_BlackCoffee() {
        // Create real low level modules
        CoffeeMaker realBlackMaker = new BlackCoffeeMaker();
        CoffeeMaker realMilkMaker = new MilkCoffeeMaker();

        // Create the real high level module and inject real dependencies
        CoffeeMachine integratedMachine = new CoffeeMachine(realBlackMaker, realMilkMaker);
        
        // Set up the initial state
        integratedMachine.setCoffeePowder(100);
        integratedMachine.setWater(5.0);
        integratedMachine.setMilk(2.0);
        
        int choice = 1;

        // Call the high level method
        integratedMachine.makeCoffee(choice);
        assertTrue(result);

        // check the final state of the integrated system.
        assertEquals(90.0, integratedMachine.getCoffeePowder());
        assertEquals(4.8, integratedMachine.getWater());
        assertEquals(2.0, integratedMachine.getMilk()); // Unchanged
    }
}