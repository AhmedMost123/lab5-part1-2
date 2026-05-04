package main;

public class CoffeeMachine {

// Dependencies
private final CoffeeMaker blackCoffeeMaker;
private final CoffeeMaker milkCoffeeMaker;

private double coffeePowder;
private double milk;
private double water;
private int coffeeCount;

public void incrementCoffeeCount() {
    coffeeCount++;
}

public int getCoffeeCount() {
    return coffeeCount;
}
public void fill() {
    System.out.println("Filling...");
    this.coffeePowder = 500.0;
    this.milk = 1.0;
    this.water = 2.0;
    System.out.println("Filling Completed.");
}
public void printStatus() {
    System.out.println("Available Coffee Power(Gram) " + String.format("%.1f", coffeePowder));
    System.out.println("Available Milk(Liter) " + String.format("%.1f", milk));
    System.out.println("Available Water(Liter) " + String.format("%.1f", water));
}
// This is where we inject the dependencies.
public CoffeeMachine(CoffeeMaker blackCoffeeMaker, CoffeeMaker milkCoffeeMaker) {
    this.blackCoffeeMaker = blackCoffeeMaker;
    this.milkCoffeeMaker = milkCoffeeMaker;
}


// We pass 'choice' in, so the test can control it.
public boolean makeCoffee(int choice) {
    switch (choice) {
        case 1:
            return this.blackCoffeeMaker.make(this);
        case 2:
            return this.milkCoffeeMaker.make(this);
        case 0:
            System.out.println("Exiting...");
            return false;
        default:
            System.out.println("Invalid choice.");
            return false;
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