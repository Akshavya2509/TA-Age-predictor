package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
  public static String browser = "Chrome";
  public static WebDriver driver;

  public static void main(String[] args)
      throws InterruptedException {
    if (browser.equals("Firefox")) {
      driver = new FirefoxDriver();
    } else if (browser.equals("Chrome")) {
      driver = new ChromeDriver();
    } else if (browser.equals("Edge")) {
      driver = new EdgeDriver();
    }

    String s = "78aA$ ";
    String password = "123456";
    for (int i = 0; i < s.length(); i++) {

      if (browser.equals("Firefox")) {
        driver = new FirefoxDriver();
      } else if (browser.equals("Chrome")) {
        driver = new ChromeDriver();
      } else if (browser.equals("Edge")) {
        driver = new EdgeDriver();
      }
      password += s.charAt(i);
      driver.manage().window().maximize();
      driver.get("http://localhost:5000/signup");
      Thread.sleep(2000);

      Thread.sleep(2000);

      driver.findElement(By.id("name")).sendKeys("akkjk");
      driver.findElement(By.id("password")).sendKeys(password);
      Thread.sleep(2000);
      driver.findElement(By.className("submit-btn")).click();
      Thread.sleep(2000);
      driver.quit();
    }
    // driver.findElement(By.id("username")).sendKeys("tiet@gmail.com");
    // driver.findElement(By.id("password")).sendKeys("tiet@1234#");
    // driver.findElement(By.name("login")).click();
    // //dashboard
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/nav/ul/li[1]/a")).click();
    // //shop
    // driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")).click();
    // //javascript
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/aside/div[3]/ul/li[3]/a")).click();
    // //book name
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/ul/li[1]/a[1]/h3")).click();
    // //quantity
    // WebElement qty =
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/div/input"));
    // qty.clear();
    // qty.sendKeys("2");
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/button")).click();
    // driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/a")).click();
    Thread.sleep(10000);
    driver.close();
  }
}