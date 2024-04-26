

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTestNGdemo {
  @Test
  public void sampleTestMethod() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://demo.automationtesting.in");
    driver.findElement(By.id("email")).sendKeys("email@gmail.com");
    driver.findElement(By.id("enterimg")).click();
    Thread.sleep(3000);
    driver.quit();
  }
}
