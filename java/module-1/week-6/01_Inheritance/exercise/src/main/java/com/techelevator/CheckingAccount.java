package com.techelevator;

public class CheckingAccount extends BankAccount{
    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }
    public int withdraw(int amountToWithdraw){
        int nBalance = getBalance() - amountToWithdraw;
        if(nBalance > -100){
            super.withdraw(amountToWithdraw);
            if(nBalance < 0){
                super.withdraw(10);
            }
        }return getBalance();
    }
}
