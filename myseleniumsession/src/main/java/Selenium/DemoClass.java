package Selenium;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoClass {

	public static void AutomateLogin(WebDriver driver)
	{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tiet@gmail.com");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("tiet@1234#");
		
		WebElement button = driver.findElement(By.name("login"));
		button.click();
		
		WebElement message = driver.findElement(By.linkText("Dashboard"));
		
		if (message.getText().equals("Dashboard"))
			System.out.println("Logged in successfully!");
		else
			System.out.println("Incorrect email or password!");
	}
	
	public static void AutomateShopping(WebDriver driver) throws InterruptedException
	{
		WebElement shop = driver.findElement(By.linkText("Shop"));
		shop.click();
		
		WebElement category = driver.findElement(By.linkText("JavaScript"));
		category.click();
	
		WebElement book = driver.findElement(By.xpath("//a[@href='https://practice.automationtesting.in/product/functional-programming-in-js/']"));
		book.sendKeys(Keys.ENTER);

		WebElement quantity = driver.findElement(By.xpath("//input[@title='Qty']"));
		quantity.clear();
		quantity.sendKeys("2");
		
		WebElement add_basket = driver.findElement(By.xpath("//button[@type='submit']"));
		add_basket.click();
		
		WebElement view_basket = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
		view_basket.click();
		
		WebElement basket_totals = driver.findElement(By.xpath("//h2[normalize-space()='Basket Totals']"));

		if (basket_totals.getText().equals("Basket Totals"))
			System.out.println("Book added successfully!");
		else
			System.out.println("Error!!");
	}
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://practice.automationtesting.in/my-account/");
		
		AutomateLogin(driver);
		AutomateShopping(driver);
		
		driver.quit();
	}

}
