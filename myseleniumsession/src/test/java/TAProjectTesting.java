import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.*;

public class TAProjectTesting {
  String s = "";
  int j = 0;
  int k = 5;
  List<String> arr = new ArrayList<>();

  @DataProvider(name = "numbers")
  public Object[][] invalidSizes() {
    return new Object[][] {
        { "Test", "Automation", "1234567", "username1" },
        { "Test", "Automation", "12345678901234567890", "username2" }
    };
  }

  @Test(dataProvider = "numbers", enabled = true, priority = -7, groups = { "login", "1" })
  public void size(String firstName, String lastName, String password, String username) throws InterruptedException {
    s += "size ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(enabled = true, priority = -5, groups = { "login", "3" })
  public void lowercase() throws InterruptedException {
    s += "lowercase ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();

    String firstName = "Test", lastName = "Automation", password = "12345678", username = "akkjk";
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(enabled = true, priority = -4, groups = { "login", "4" }, dependsOnGroups = { "3" })
  public void uppercase() throws InterruptedException {
    s += "uppercase ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();

    String firstName = "Test", lastName = "Automation", password = "12345678a", username = "akkjk";
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(enabled = true, priority = -3, groups = { "login", "5" }, dependsOnGroups = { "4" })
  public void specialCharacters() throws InterruptedException {
    s += "specialCharacters ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();

    String firstName = "Test", lastName = "Automation", password = "12345678aA", username = "akkjk";
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(enabled = true, priority = -2, groups = { "login", "6" }, dependsOnGroups = { "5" })
  public void whitespaceError() throws InterruptedException {
    s += "whiteSpcaseError ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();

    String firstName = "Test", lastName = "Automation", password = "12345678aA$ ", username = "akkjk";
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(enabled = true, priority = -2, groups = { "ValidSignUp", "7" }, dependsOnGroups = { "6" })
  public void validSignUp() throws InterruptedException {
    s += "whiteSpcaseError ";
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/signup");
    driver.manage().window().maximize();

    String firstName = "Raghav", lastName = "Bansal", password = "Raghav2003*", username = "Raghav2003";
    driver.findElement(By.id("Fname")).sendKeys(firstName);
    driver.findElement(By.id("Lname")).sendKeys(lastName);
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.quit();
  }

  @Test(description = "Logs the user into the website", enabled = true, groups = { "Validlogin" }, dependsOnMethods = {
      "validSignUp" }, alwaysRun = true)
  public void ValidLogin() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    driver.get("http://localhost:5001/");
    driver.manage().window().maximize();

    String password = "Raghav2003*", username = "Raghav2003";
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    System.out.println(s + "ValidLogin");
    driver.quit();
  }

  @Test(dependsOnMethods = {
      "ValidLogin" }, invocationTimeOut = 10000, invocationCount = 1, threadPoolSize = 1, timeOut = 80000)
  public void faceDetection() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://localhost:5001/");
    driver.manage().window().maximize();

    String password = "Raghav2003*", username = "Raghav2003";
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("face-detection")).click();
    arr.add("/Users/macbook/Desktop/TA Project Images/Sample image 1.jpg");
    arr.add("/Users/macbook/Desktop/TA Project Images/Sample image 2.jpg");
    arr.add("/Users/macbook/Desktop/TA Project Images/Sample image 3.jpg");
    arr.add("/Users/macbook/Desktop/TA Project Images/Sample image 4.jpg");
    arr.add("/Users/macbook/Desktop/TA Project Images/Sample image 5.jpg");

    for (int i = 0; i < 5; i++) {
      WebElement chooseFile = driver.findElement(By.xpath("/html/body/div[2]/form/input"));
      chooseFile.sendKeys(arr.get(i));
      Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[2]/form/button")).click();
      Thread.sleep(3000);
    }

    driver.quit();
  }

  @Test(dependsOnMethods = { "faceDetection" })
  public void captureImages() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://localhost:5001/");
    driver.manage().window().maximize();

    String password = "Raghav2003*", username = "Raghav2003";
    driver.findElement(By.id("name")).sendKeys(username);
    driver.findElement(By.id("password")).sendKeys(password);
    Thread.sleep(2000);
    driver.findElement(By.className("submit-btn")).click();
    Thread.sleep(2000);

    char array[] = new char[26];
    for (int i = 0; i < 26; i++) {
      array[i] = (char) (97 + i);
    }
    driver.findElement(By.id("capture-image")).click();
    driver.findElement(By.id("startButton")).click();
    for (int i = 0; i < 3; i++) {
      Thread.sleep(5000);
      String s = "/Users/macbook/Downloads/";
      driver.findElement(By.id("captureButton")).click();
      s += array[j++];
      s += ".png";
      arr.add(s);
    }
    System.out.println(arr);
    driver.findElement(By.xpath("/html/body/nav/div/div/ul/li[1]/a")).click();
    driver.findElement(By.id("face-detection")).click();
    for (int i = 0; i < arr.size(); i++) {
      System.out.println(arr.get(i));
      Thread.sleep(7000);
      WebElement chooseFile = driver.findElement(By.xpath("/html/body/div[2]/form/input"));
      chooseFile.sendKeys(arr.get(i));
      Thread.sleep(5000);
      driver.findElement(By.xpath("/html/body/div[2]/form/button")).click();
      Thread.sleep(3000);
    }

    driver.quit();
  }
}
