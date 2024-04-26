package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class LocatorsConcept {
  @Test
  public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/main/java/Drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("https://practice.automationtesting.in/my-account/");
    
    driver.findElement(By.id("username")).sendKeys("tiet@gmail.com");
    driver.findElement(By.id("password")).sendKeys("tiet@1234#");

    driver.findElement(By.name("login")).click();
    //dashboard
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/nav/ul/li[1]/a")).click();
    //shop
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a")).click();
    //javascript
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/aside/div[3]/ul/li[3]/a")).click();
    //book name
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/ul/li[1]/a[1]/h3")).click();
    //quantity
    WebElement qty = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/div/input"));
    qty.clear();
    qty.sendKeys("2");
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div[2]/form/button")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/a")).click();
    Thread.sleep(10000);
    driver.close();
  }
}
