package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {
  public static void main(String[] args) {
    WebDriver driver = new ChromeDriver();
    driver.get(null);
    driver.findElement(By.className("link"));
    driver.findElement(By.id("name")).sendKeys("akk");
    driver.findElement(By.id("password")).sendKeys("12345678aA@");
    driver.findElement(By.className("submit-btn")).click();
  }
}
