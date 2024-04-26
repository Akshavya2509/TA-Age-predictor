
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemoTest {
  @BeforeMethod
  public void start() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://google.co.in");
    Thread.sleep(3000);
    driver.quit();
  }

  @Test
  public void testing() {
    // Create a new instance of the Chrome driver
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();

    try {
      // Open the demo page
      driver.get("http://172.16.85.43/index.html");
      driver.manage().window().maximize();
      Thread.sleep(2000); // Wait to see the page load

      // Test the input field and greet button
      WebElement nameInput = driver.findElement(By.id("nameInput"));
      nameInput.sendKeys("John Doe");
      Thread.sleep(1000); // Wait to see the text being typed

      WebElement greetButton = driver.findElement(By.id("greetButton"));
      greetButton.click();
      Thread.sleep(1000); // Wait to see the greeting change

      // Verify greeting text
      WebElement greetingText = driver.findElement(By.id("greetingText"));
      Assert.assertTrue(greetingText.getText().contains("Hello, John Doe!"), "Greeting text does not match");
      Thread.sleep(1000); // Wait to observe the assertion effect, if any

      // Test the link (More Info Link)
      WebElement moreInfoLink = driver.findElement(By.id("moreInfoLink"));
      moreInfoLink.click();
      Thread.sleep(10000); // Wait for the alert to appear

      // Handle the alert by accepting it
      // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // wait.until(ExpectedConditions.alertIsPresent());
      Thread.sleep(1000); // Wait after alert is accepted to observe any changes

      // Test the dropdown
      Select dropdown = new Select(driver.findElement(By.id("dropdown")));
      dropdown.selectByVisibleText("Option 2");
      Thread.sleep(1000); // Wait to see the dropdown selection change
      Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 2", "Dropdown selection does not match");

      // Test the checkbox
      WebElement checkbox = driver.findElement(By.id("checkboxExample"));
      checkbox.click();
      Thread.sleep(1000); // Wait to see the checkbox get clicked
      Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      // Close the browser
      driver.quit();
    }
  }
}
