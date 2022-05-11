package se.lexicon.exception;

public class MyArgumentException extends Exception {
  private String paramName;
  private String paramValue;

  public MyArgumentException(String message) {
    super(message);
  }

  public MyArgumentException(String message, String paramName, String paramValue) {
    this(message);
    this.paramName = paramName;
    this.paramValue = paramValue;
  }

  public String getParamName() {
    return paramName;
  }

  public String getParamValue() {
    return paramValue;
  }

  public String details() {
    return "ParamName: " + paramName + " ParamValue: " + paramValue;
  }
}
