package _24058824.Mummunka_Part2;


//Creates logs using the singleton instances
public class Log {
  private static Log instance;

  //Constructor
  private Log() {
  }

  public static Log getInstance() {
      if (instance == null) {
          instance = new Log();
      }
      return instance;
  }

  public void logInfo(String message) {
      System.out.println("[INFO] " + message);
  }

  public void logWarning(String message) {
      System.out.println("[WARNING] " + message);
  }

  public void logError(String message) {
      System.out.println("[ERROR] " + message);
  }
}
