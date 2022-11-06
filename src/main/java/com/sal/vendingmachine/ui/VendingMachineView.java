
package com.sal.vendingmachine.ui;

import com.sal.vendingmachine.dto.Coins;
import com.sal.vendingmachine.dto.Item;
import com.sal.vendingmachine.ui.UserIOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author salajrawi
 */
@Component
public class VendingMachineView {
    private UserIO io;

    public VendingMachineView() {

        io=new UserIOImpl();
    }

    @Autowired
    public VendingMachineView(UserIO io) {

        this.io = io;
    }

    // Display the Welcome Banner
    public void displayWelcomeBanner() {
        io.print("=====Welcome to Alice's Vending Machine!=====");
    }

    // print main menu
    public void  printMenu() {
        mainMenuBanner();
        io.print("1. Add Money");
        io.print("2. Buy Item");
        io.print("3. Quit");
    }
    
    public String getMenuSelection()
    {

        return io.readString("Please select an operation.");
    }
    
    public int getItemSelection(){

        return io.readInt("Please select an item");
    }
    
    // add money
    public BigDecimal displayAndGetFunds()
    {
        addMoneyBanner();
        BigDecimal funds = io.readBigDecimal("Enter funds to add ($0 - $100): ", new BigDecimal(0), new BigDecimal(100));
        io.print("Funds added");
        io.readString("Please hit enter to continue.");
        return funds;
    }
    
    // display balance
    public void displayBalance(BigDecimal bal){

        io.print("Current balance: $"+bal.setScale(2, RoundingMode.DOWN));
    }
    
    public void displayErrorMessage(String message)
    {
        io.print(message + '\n');
        io.readString("Please hit enter to continue.");
    }
    
    // print all items
    public ArrayList<String> printAllItems(List<Item> itemList)
    {
        allItemsBanner();
        // Items displayed by number
        int j=1;
        ArrayList<String> list=new ArrayList<>();
        list.add(0,"null");
        for(Item i:itemList)
        {
            io.print(j + ". " + i.toString());
            list.add(j, i.getName());
            // Increment the number of item for each time printed
            j++;
        }
        return list;
    }


    public void displayPurchase(Item item, BigDecimal balance) {
        io.print("Purchased: " + item.getName() +
                "\nCost: $" + item.getCost() + "\nRemaining balance: $" + balance);


    }

    // Print the type of coins and the quantity of each type
    public void printChanges(HashMap<Coins,Integer> map){
        io.print("\nDispensing Change:");

        for(Coins c:map.keySet()){
            io.print(c.name()+"($"+c.getValue()+"): "+map.get(c)+"\n");
        }
    }

     public void displayUnknownCommand() {
        io.print("Invalid input. Please input 0, 1 or 2" + "\n");
    }
    

    // banner and message
    public void mainMenuBanner(){

        io.print("======Main Menu========");
    }
    
    public void addMoneyBanner(){

        io.print("====ADD FUNDS====");
    }
    
    public void allItemsBanner(){

        io.print("=======Vending Machine Items==========");
    }
    
    public void purchaseSucceeded(){

        io.print("Purchase Succeeded!");
    }
    
    // goodbye
    public void displayQuitMessage()
    {

        io.print("Goodbye" + "\n");
    }



}
