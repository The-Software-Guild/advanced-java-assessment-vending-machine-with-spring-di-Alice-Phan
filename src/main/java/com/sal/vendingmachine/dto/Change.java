
package com.sal.vendingmachine.dto;

import com.sal.vendingmachine.service.VendingMachineInsufficientFundsException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

import static com.sal.vendingmachine.dto.Coins.*;

/**
 *
 * @author salajrawi
 */
public class Change {
    private static final HashMap<Coins,Integer> coinChangeMap=new HashMap<>();

    public Change() {
    }
    
    public static HashMap<Coins,Integer> getChange(BigDecimal funds) throws VendingMachineInsufficientFundsException{
      //implement
      // Throw exception if the balance is zero or below
        if ( funds.compareTo(new BigDecimal("0.00")) < 1)
            throw new VendingMachineInsufficientFundsException("Insufficient funds.");


        int quarters =  funds.divide(Coins.QUARTER.getValue(), RoundingMode.DOWN).intValue();
        // Put the calculated quarters into the map
        coinChangeMap.put(Coins.QUARTER, quarters);
        // Update the funds to subtract the quarters (funds = funds - number of quarters * cash value of a quarter
        funds = funds.subtract(Coins.QUARTER.getValue().multiply(BigDecimal.valueOf(quarters)));

        int dimes = funds.divide(Coins.DIME.getValue(), RoundingMode.DOWN).intValue();
        coinChangeMap.put(Coins.DIME, dimes);
        funds = funds.subtract(Coins.DIME.getValue().multiply(BigDecimal.valueOf(dimes)));

        int nickels = funds.divide(Coins.NICKLE.getValue(), RoundingMode.DOWN).intValue();
        coinChangeMap.put(Coins.NICKLE, nickels);
        funds = funds.subtract(Coins.NICKLE.getValue().multiply(BigDecimal.valueOf(nickels)));

        int pennies = funds.divide(Coins.PENNY.getValue(),RoundingMode.DOWN).intValue();
        coinChangeMap.put(Coins.PENNY, pennies);


        return coinChangeMap;
    }
    
}
