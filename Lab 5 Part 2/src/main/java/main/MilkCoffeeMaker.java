package main;


public class MilkCoffeeMaker implements CoffeeMaker {
    @Override
    public boolean make(CoffeeMachine machine) 
    {
        if (machine.getCoffeePowder() < 10) 
        {
            System.out.println("Sorry, not enough Coffee Powder.");
            return false;
        }
        if (machine.getWater() < 0.2)
        {
            System.out.println("Sorry, not enough Water.");
            return false;
        }
        if (machine.getMilk() < 0.1) 
        {
            System.out.println("Sorry, not enough Milk.");
            return false;
        }

        System.out.println("Making Milk Coffee...");
        System.out.println("Taking 10.0 gm of Coffee Powder.");
        System.out.println("Taking 0.2 L of Water.");
        System.out.println("Taking 0.1 L of Milk.");

        machine.setCoffeePowder(machine.getCoffeePowder() - 10);
        machine.setWater(machine.getWater() - 0.2);
        machine.setMilk(machine.getMilk() - 0.1);
        
        System.out.println("Your Milk Coffee is Ready.");
        return true;
    }
}
