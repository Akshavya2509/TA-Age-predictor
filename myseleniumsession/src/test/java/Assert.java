import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {
  @Test
  public void add() {
    int a = 3, b = 4;
    SoftAssert sa = new SoftAssert();
    sa.assertEquals(a + b, 5);
    System.out.println("Working");
  }
}
