/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nadam
 */
  public class BlackCoffeeMaker implements CoffeeMaker {
    @Override
    public boolean make(CoffeeMachine machine) {
        if (machine.getCoffeePowder() < 10) {
            System.out.println("Sorry, not enough Coffee Powder.");
            return false;
        }
        if (machine.getWater() < 0.2) {
            System.out.println("Sorry, not enough Water.");
            return false;
        }

        System.out.println("Making Black Coffee...");
        System.out.println("Taking 10.0 gm of Coffee Powder.");
        System.out.println("Taking 0.2 L of Water.");

        machine.setCoffeePowder(machine.getCoffeePowder() - 10);
        machine.setWater(machine.getWater() - 0.2);
        
        System.out.println("Your Black Coffee is Ready.");
        return true;
    }
}  

