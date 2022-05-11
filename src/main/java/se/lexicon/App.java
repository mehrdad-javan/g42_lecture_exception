package se.lexicon;


import se.lexicon.exception.InsufficientFoundsException;
import se.lexicon.model.CheckingAccount;

public class App {
  public static void main(String[] args) {

    CheckingAccount account = new CheckingAccount(1234);
    System.out.println("Current Balance: " + account.getBalance());
    account.deposit(500.00);
    System.out.println("Current Balance: " + account.getBalance());
    try {
      account.withdraw(200.00);
    }catch (InsufficientFoundsException e){
      System.out.println("Exception: " + e.getMessage());
    }
    System.out.println("Current Balance: " + account.getBalance());
    try {
      account.withdraw(400.00);
    }catch (InsufficientFoundsException e){
      System.out.println("Exception: " + e.getMessage());
    }

  }

}
