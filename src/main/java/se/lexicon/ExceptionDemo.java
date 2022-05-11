package se.lexicon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExceptionDemo {

  public static void main(String[] args) {
    /*try {
      ex6();
    }catch (IOException e){
      System.out.println("IOException: " + e);
    }*/

    ex9();
  }

  public static void ex1() {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter a number: ");
      String input = scanner.next();
      try {
        int number = Integer.parseInt(input);
        System.out.println("Addition: " + (number + 5));
      } catch (NumberFormatException e) {
        //e.printStackTrace();
        System.out.println("### Number is not Valid ###");
        System.out.println("Exception reason: " + e);
      }
      System.out.println("DONE");
    }
  }

  public static void ex2() {
    try {
      String firstName = null;
      //firstName = "Mehrdad";
      System.out.println(firstName.charAt(0));
    } catch (NullPointerException e) {
      System.out.println("Exception: " + e);
      System.out.println("First Name is not valid");
    }

  }

  public static void ex3() {
    try {
      String stringDate = "2022-10-40";
      LocalDate localDate = LocalDate.parse(stringDate);
      System.out.println(localDate);
    } catch (DateTimeParseException e) {
      System.out.println("Date is not valid");
      System.out.println("Exception: " + e.getMessage());
    }
    System.out.println("DONE");
  }

  public static void ex4() {
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter your SSN (yyyymmdd-0000): ");
      String input = scanner.next();
      String[] ssnArray = input.split("-");
      LocalDate date = LocalDate.parse(ssnArray[0], DateTimeFormatter.BASIC_ISO_DATE);
      String number = ssnArray[1];
      System.out.println(date);
      System.out.println(number);
    } catch (DateTimeParseException e) {
      System.out.println("Date Exception: " + e);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Array Exception: " + e);
    }

  }

  public static void ex5() {
    try {
      String filePath = "dir/test.txt";
      List<String> fileContent = Files.readAllLines(Paths.get(filePath));
      fileContent.forEach(System.out::println);
    } catch (IOException ex) {
      System.out.println("IOException: " + ex);
    }
  }

  public static void ex6() throws IOException {
    String filePath = "dir/test.txt";
    List<String> fileContent = Files.readAllLines(Paths.get(filePath));
    fileContent.forEach(System.out::println);
  }

  public static void ex7(){
    String filePath = "dir/test.txt";
    List<String> fileContent = null;
    try {
      fileContent = Files.readAllLines(Paths.get(filePath));
      fileContent.forEach(System.out::println);

      String line7= fileContent.get(7);
      System.out.println("line 7: " + line7);

    } catch (IOException | IndexOutOfBoundsException e) {
      System.out.println("Exception: " + e);
    } finally {
      System.out.println("#### Clear file content list ####");
      if (fileContent != null) fileContent.clear();
    }

  }

  public static void ex8(){
    String filePath = "dir/test.txt";
    Stream<String> stringStream = null;
    try {
      stringStream = Files.lines(Paths.get(filePath));
      String result = stringStream.filter(s -> s.equalsIgnoreCase("Line 3")).findFirst().orElse(null);
      System.out.println("result = " + result);
      // got eny exception
      //Integer.parseInt("12abc"); // throws NumberFormatException
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    } finally {
      if (stringStream != null) stringStream.close();
    }

    System.out.println("DONE");

  }

  public static void ex9(){
    String filePath = "dir/test.txt";
    try(
            Stream<String> stringStream = Files.lines(Paths.get(filePath))
    ) {


      String result = stringStream.filter(s -> s.equalsIgnoreCase("Line 3")).findFirst().orElse(null);
      System.out.println("result = " + result);
    } catch (IOException e) {
      System.out.println("Exception: " + e);
    }

    System.out.println("DONE");

  }







}
