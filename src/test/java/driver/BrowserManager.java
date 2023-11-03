package driver;

public enum BrowserManager {
  BROWSER(System.getProperty("BROWSER")),
  HEADLESS(Boolean.getBoolean("HEADLESS"));
  private String env;
  private boolean bool;

  BrowserManager(String env){
    this.env = env;
  }
  BrowserManager(boolean bool){
    this.bool = bool;
  }

  public String getEnv(){
    return env;
  }

  public boolean getBool(){
    return bool;
  }

}
