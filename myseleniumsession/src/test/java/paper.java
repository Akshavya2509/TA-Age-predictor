import org.testng.Assert;
import org.testng.annotations.Test;

public class paper {
  @Test(dependsOnMethods = "m2", alwaysRun = true)
  public void m1() {
    System.out.println("Test method one");
  }

  @Test(priority = -2, enabled = true)
  public void m2() {
    System.out.println("Test method two");
    Assert.fail();
  }

  @Test(dependsOnMethods = "m2")
  public void m3() {
    System.out.println("Test method three");
  }

  @Test(invocationCount = 2, priority = -1)
  public void m4() {
    System.out.println("Test method four");
  }
}
