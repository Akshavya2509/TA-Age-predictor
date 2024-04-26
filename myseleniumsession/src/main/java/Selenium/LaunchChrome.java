package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChrome {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "/Users/macbook/Desktop/Selenium-java/myseleniumsession/src/main/java/Drivers/chromedriver");
    WebDriver driver = new ChromeDriver();
    driver.get("https://practice.automationtesting.in/my-account/");
    System.out.println(driver.getTitle());
  }
}
