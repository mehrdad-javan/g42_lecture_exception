package se.lexicon.model;

import se.lexicon.exception.InsufficientFoundsException;
import se.lexicon.exception.MyArgumentException;

public class CheckingAccount {

  private double balance;
  private int number;

  public CheckingAccount(int number) {
    this.number = number;
  }

  public void deposit(double amount) throws MyArgumentException{
    //if (amount <= 0) throw new IllegalArgumentException("amount is not valid!");
    if (amount <= 0) throw new MyArgumentException("amount is not valid!", "amount", amount+ "");
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
