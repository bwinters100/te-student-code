package com.techelevator;

public class CreditCardAccount implements Accountable {
    private String accountHolder;
    private String accountNumber;
    private int debt;

    public CreditCardAccount(String accountHolder, String accountNumber){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.debt = 0;
    }
    public int pay(int amountToPay){
        this.debt = this.debt - amountToPay;
        return this.debt;
    }
    public int charge(int amountToCharge){
        this.debt = this.debt + amountToCharge;
        return this.debt;
    }
    public int getBalance(){
        return -this.debt;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getDebt(){
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
