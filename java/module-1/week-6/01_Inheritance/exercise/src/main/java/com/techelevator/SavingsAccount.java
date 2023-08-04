package com.techelevator;

public class SavingsAccount extends BankAccount{
    public SavingsAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }
    public SavingsAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }
    public int withdraw(int amountToWithdraw){
        if(amountToWithdraw <= getBalance()){
            super.withdraw(amountToWithdraw);
            if(getBalance() < 150){
                if(super.withdraw(2) > 0)
                super.withdraw(2);
                else {
                    return getBalance();
                }
            }
        }return getBalance();
    }
}
