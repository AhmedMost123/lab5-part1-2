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
        boolean result = integratedMachine.makeCoffee(choice);
        assertTrue(result);

        // check the final state of the integrated system.
        assertEquals(90.0, integratedMachine.getCoffeePowder());
        assertEquals(4.8, integratedMachine.getWater());
        assertEquals(2.0, integratedMachine.getMilk()); // Unchanged
    }
    @Test
    void testMakeCoffee_Integration_MilkCoffee() {
        CoffeeMachine machine = new CoffeeMachine(
            new BlackCoffeeMaker(),
            new MilkCoffeeMaker()
        );

        machine.setCoffeePowder(100);
        machine.setWater(5.0);
        machine.setMilk(2.0);

        boolean result = machine.makeCoffee(2);

        assertTrue(result);
        assertEquals(90.0, machine.getCoffeePowder());
        assertEquals(4.8, machine.getWater());
        assertEquals(1.6, machine.getMilk());
    }
    @Test
    void testCoffeeCount_Increments() {
        CoffeeMachine machine = new CoffeeMachine(
            new BlackCoffeeMaker(),
            new MilkCoffeeMaker()
        );

        machine.setCoffeePowder(100);
        machine.setWater(5.0);

        machine.makeCoffee(1);
        machine.makeCoffee(1);

        assertEquals(2, machine.getCoffeeCount());
    }
}