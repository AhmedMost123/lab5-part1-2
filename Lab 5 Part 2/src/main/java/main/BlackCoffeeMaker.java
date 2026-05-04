package main;

  public class BlackCoffeeMaker implements CoffeeMaker {
    @Override
    public boolean make(CoffeeMachine machine) {
        if (machine.getCoffeePowder() >= 10 &&
            machine.getWater() >= 0.2) {

            System.out.println("\nMaking Black Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            System.out.println("Taking 0.2 liter of Water.");

            machine.setCoffeePowder(machine.getCoffeePowder() - 10);
            machine.setWater(machine.getWater() - 0.2);

            System.out.println("\nYour Black Coffee is Ready.");
            machine.incrementCoffeeCount();
            return true;

        } else {
            System.out.println("\nAvailable Coffee Power(Gram) " + String.format("%.1f", machine.getCoffeePowder()));
            System.out.println("Available Water(Liter) " + String.format("%.1f", machine.getWater()));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
            return false;
        }
    }
}  

