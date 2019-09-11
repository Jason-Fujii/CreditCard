/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project1;
import java.util.Calendar;
import java.util.*;
/**
 *
 * @author jasonfujii
 */
public class CreditCard {
    private String name;
    private int accountNum;
    private Calendar dueDate;
    private double rewardPts;
    //We're going to give our clients a 1% cash back rewards rate
    private double accBalance;
    private static int numCards = 0;
    
    public CreditCard()
    {
        name = "CardHolder " + numCards;
        accountNum = numCards;
        rewardPts = 0.0;
        accBalance = 0.0;
        numCards++;
        dueDate = Calendar.getInstance();
        dueDate.add(Calendar.MONTH, 1);
        
    }
    
    public CreditCard(String n)
    {
        name = n;
        accountNum = numCards;
        rewardPts = 0.0;
        accBalance = 0.0;
        dueDate = Calendar.getInstance();
        dueDate.add(Calendar.MONTH, 1);
        numCards++;
    }
    
    public CreditCard(String n, double balance)
    {
        name = n;
        accountNum = numCards;
        rewardPts = 0.0;
        accBalance = balance;
        dueDate = Calendar.getInstance();
        dueDate.add(Calendar.MONTH, 1);
        numCards++;
    }

    //charge() takes a double val and adds it to the account balance. 
    //Then it adds 1% of value to the rewards points
    public void charge(double val)
    {
        accBalance += val;
        rewardPts += val*.01;
        System.out.println("Your new balance is: $" +getAccBalance());
    }
    
    //payment() subtracts however much money the user inputs from the balance
    public void payment(double val)
    {
        accBalance -= val;
    }
    
    //cashAdvance() allows the user to pull out cash for a fee of 5% the total cash advance
    //the max amount of money the user is allowed to withdraw is $500
    public void cashAdvance()
    {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("There is a 5% fee on the total withdrawl. Is this ok?");
        if(sc.nextLine().equals("yes") || sc.nextLine().equals("Yes"))
        {
            System.out.println("Please enter the amount of cash you would like to withdraw.");
            System.out.println("There is a maximum of $500");
            double amt = sc.nextDouble();
            charge(amt);
            charge(amt*.05);
        }
    }
    
    //toString() prints out all of the statistics of the credit card
    public String toString()
    {
        
        String str = getName() +"'s Credit Card Information: \n";
        str += "Account Number: " +getAccountNum() + "\n"; 
        str += "Account Balance: $" +getAccBalance() + "\n";
        str += "Reward Point Balance: $" +getRewardPts()+ "\n";
        str += "Next Due Date: " +getDueDate();
        return str;
    }
    //addInterest() charges 22.57% of the total account Balance to the card owner as an interest charge 
    public void addInterest()
    {
        charge(accBalance*.2257);
        System.out.println("Interest added: $" +accBalance*.2257);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public Date getDueDate() {
        //System.out.println(dueDate.getTime()) ;
        Date date = dueDate.getTime();
        return date;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public double getRewardPts() {
        int x = (int)(rewardPts*100);
        double x2 = x/100.0;
        return x2;
    }

    public void setRewardPts(double rewardPts) {
        this.rewardPts = rewardPts;
    }

    public double getAccBalance() {
        int x = (int)(accBalance*100);
        double y = x/100.0;
        return y;
    }

    public void setAccBalance(double accBalance) {
        this.accBalance = accBalance;
    }

    public static int getNumCards() {
        return numCards;
    }

    public static void setNumCards(int numCards) {
        CreditCard.numCards = numCards;
    }
    
    
}
