package se.lexicon;


import se.lexicon.exception.InsufficientFoundsException;
import se.lexicon.exception.MyArgumentException;
import se.lexicon.model.CheckingAccount;

public class App {
  public static void main(String[] args) {
    try {
      CheckingAccount account = new CheckingAccount(1234);
      System.out.println("Current Balance: " + account.getBalance());

      account.deposit(500.00);
      System.out.println("Current Balance: " + account.getBalance());

      account.withdraw(200.00);
      System.out.println("Current Balance: " + account.getBalance());

      //account.withdraw(400.00); // throws InsufficientFoundsException

      account.deposit(-100); // throws MyArgumentException

    } catch (InsufficientFoundsException e) {
      System.out.println("InsufficientFoundsException: " + e.getMessage());
    } catch (MyArgumentException e) {
      System.out.println("ArgumentException: " + e.getMessage());
      System.out.println(e.details());
    }


  }

}
