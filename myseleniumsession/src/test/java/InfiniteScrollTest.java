import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InfiniteScrollTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        // Set the path of the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testInfiniteScroll() throws InterruptedException {
        // Navigate to the page you want to test
        driver.get("https://infinite-scroll.com/demo/full-page/");

        // Use JavaScript to scroll down the page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Assuming you want to scroll down 10 times as an example
        for (int i = 0; i < 10; i++) {
            // Scroll down by 1000 pixels
            js.executeScript("window.scrollBy(0,1000)");

            // Wait for the page to load more content
            Thread.sleep(2000); // It's better to use explicit waits here
        }

        // You can add assertions here to verify the result of the scroll
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}