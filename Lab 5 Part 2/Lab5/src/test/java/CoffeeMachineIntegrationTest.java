/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CoffeeMachineIntegrationTest {

    @Test
    void testMakeCoffee_Integration_BlackCoffee() {
        // Arrange
        // 1. Create REAL low-level modules
        CoffeeMaker realBlackMaker = new BlackCoffeeMaker();
        CoffeeMaker realMilkMaker = new MilkCoffeeMaker();

        // 2. Create the REAL high-level module and inject real dependencies
        CoffeeMachine integratedMachine = new CoffeeMachine(realBlackMaker, realMilkMaker);
        
        // 3. Set up the initial state
        integratedMachine.setCoffeePowder(100);
        integratedMachine.setWater(5.0);
        integratedMachine.setMilk(2.0);
        
        int choice = 1;

        // Act
        // Call the high-level method
        integratedMachine.makeCoffee(choice);

        // Assert
        // We check the FINAL STATE of the integrated system.
        assertEquals(90.0, integratedMachine.getCoffeePowder());
        assertEquals(4.8, integratedMachine.getWater());
        assertEquals(2.0, integratedMachine.getMilk()); // Unchanged
    }
}