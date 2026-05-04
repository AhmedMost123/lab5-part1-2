package main;


public class MilkCoffeeMaker implements CoffeeMaker {
    @Override
    public boolean make(CoffeeMachine machine) 
    {
        if (machine.getCoffeePowder() >= 10 &&
            machine.getMilk() >= 0.4 &&
            machine.getWater() >= 0.2) {

            System.out.println("\nMaking Milk Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            System.out.println("Taking 0.4 Liter of Milk.");
            System.out.println("Taking 0.2 liter of Water.");

            machine.setCoffeePowder(machine.getCoffeePowder() - 10);
            machine.setMilk(machine.getMilk() - 0.4);
            machine.setWater(machine.getWater() - 0.2);

            System.out.println("\nYour Milk Coffee is Ready.");
            machine.incrementCoffeeCount();
            return true;

        } else {
            machine.printStatus();
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
            return false;
}
    }
}
