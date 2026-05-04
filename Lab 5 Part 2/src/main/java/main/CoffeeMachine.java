package main;

public class CoffeeMachine {

// Dependencies
private final CoffeeMaker blackCoffeeMaker;
private final CoffeeMaker milkCoffeeMaker;

private double coffeePowder;
private double milk;
private double water;

// This is where we inject the dependencies.
public CoffeeMachine(CoffeeMaker blackCoffeeMaker, CoffeeMaker milkCoffeeMaker) {
    this.blackCoffeeMaker = blackCoffeeMaker;
    this.milkCoffeeMaker = milkCoffeeMaker;
}


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

// Getters and Setters

public double getCoffeePowder() { return coffeePowder; }
public void setCoffeePowder(double coffeePowder) { this.coffeePowder = coffeePowder; }

public double getMilk() { return milk; }
public void setMilk(double milk) { this.milk = milk; }

public double getWater() { return water; }
public void setWater(double water) { this.water = water; }
}