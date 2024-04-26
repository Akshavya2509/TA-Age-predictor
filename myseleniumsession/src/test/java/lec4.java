import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.asserts.*;

public class lec4 {
  @Test(priority = -1, dependsOnMethods = "m7", alwaysRun = true)
  public void m1() {
    System.out.println("Test method one");
  }

  @Test(priority = -2)
  public void m2() {
    System.out.println("Test method two");
  }

  @Test(priority = -3, dependsOnMethods = "m4")
  public void m3() {
    System.out.println("Test method three");
  }

  @Test(priority = -4)
  public void m4() {
    System.out.println("Test method four");
  }

  @Test(priority = -5, dependsOnMethods = "m3")
  public void m5() {
    System.out.println("Test method five");
  }

  @Test(priority = -6)
  public void m6() {
    System.out.println("Test method six");
  }

  @Test(priority = -7)
  public void m7() {
    System.out.println("Test method seven");
    Assert.fail();
  }

  @Test(priority = -8)
  public void m8() {
    System.out.println("Test method eight");
  }

  @Test(priority = -9, dependsOnMethods = "m1")
  public void m9() {
    System.out.println("Test method nine");
  }

  @Test(priority = -10, dependsOnMethods = "m3")
  public void m10() {
    System.out.println("Test method ten");
  }

  @Test(priority = -11, dependsOnMethods = "m3")
  public void m11() {
    System.out.println("Test method eleven");
  }
}
