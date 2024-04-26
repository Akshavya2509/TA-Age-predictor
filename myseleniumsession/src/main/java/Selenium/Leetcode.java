package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Leetcode {
  public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://leetcode.com/");
    driver.findElement(By.xpath("//*[@id=\"landing-page-app\"]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/a[5]/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("login")).sendKeys("akshavya2509@gmail.com");
    Thread.sleep(5000);
    driver.findElement(By.className("LC20lb MBeuO DKV0Md")).click();
    driver.quit();
  }
}







