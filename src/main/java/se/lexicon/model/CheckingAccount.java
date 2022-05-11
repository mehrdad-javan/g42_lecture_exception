package se.lexicon.model;

import se.lexicon.exception.InsufficientFoundsException;

public class CheckingAccount {

  private double balance;
  private int number;

  public CheckingAccount(int number) {
    this.number = number;
  }

  public void deposit(double amount){
    balance = balance + amount;
    System.out.println("Operation is Done!");
  }

  public void withdraw(double amount) throws InsufficientFoundsException {
    if (amount<= balance){
      balance = balance - amount;
    } else {
      throw new InsufficientFoundsException(amount, " Balance is Insufficient");
    }
  }

  public double getBalance() {
    return balance;
  }

  public int getNumber() {
    return number;
  }

}
