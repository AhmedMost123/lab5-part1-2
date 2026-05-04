    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nadam
 */
// File: src/main/java/CoffeeMachine.java

public class CoffeeMachine {

    // Dependencies
    private final CoffeeMaker blackCoffeeMaker;
    private final CoffeeMaker milkCoffeeMaker;

    // State
    private double coffeePowder;
    private double milk;
    private double water;

    // 1. The tests DEPEND ON THIS CONSTRUCTOR.
    // This is where we inject the dependencies.
    public CoffeeMachine(CoffeeMaker blackCoffeeMaker, CoffeeMaker milkCoffeeMaker) {
        this.blackCoffeeMaker = blackCoffeeMaker;
        this.milkCoffeeMaker = milkCoffeeMaker;
    }

    // 2. The tests DEPEND ON THIS METHOD SIGNATURE.
    // We pass 'choice' in, so the test can control it.
    public void makeCoffee(int choice) {
        switch (choice) {
            case 1:
                // Delegates the work to the dependency
                this.blackCoffeeMaker.make(this);
                break;
            case 2:
                this.milkCoffeeMaker.make(this);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please select 1, 2, or 0.");
        }
    }

    // --- Getters and Setters (Also needed for tests) ---
    
    public double getCoffeePowder() { return coffeePowder; }
    public void setCoffeePowder(double coffeePowder) { this.coffeePowder = coffeePowder; }

    public double getMilk() { return milk; }
    public void setMilk(double milk) { this.milk = milk; }

    public double getWater() { return water; }
    public void setWater(double water) { this.water = water; }
}