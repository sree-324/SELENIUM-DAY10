package day9;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class seleniumday9{
	int a,b,c;
  @Test(dataProvider = "dp")
  public void Add(Integer a, Integer b) {
	  c=a+b;
	  System.out.println("sum-"+c);
	  Assert.assertEquals(c,15);
  }
 
  @Test(dataProvider = "dp")
  public void Subtract(Integer a, Integer b) {
	  c=a-b;
	  System.out.println("subtract-"+c);
	  Assert.assertEquals(c,12);

  }
  @Test(dataProvider = "dp")
  public void Multiply(Integer a, Integer b) {
	  c=a*b;
	  System.out.println("multiply-"+c);
	  Assert.assertEquals(c,8);

  }
  
  @Test(dataProvider = "dp")
  public void division(Integer a, Integer b) {
	  c=a/b;
	  System.out.println("division-"+c);
	  Assert.assertEquals(c,2);

  }
  

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 10, 5 },
      new Object[] { 12, 6 },
    };
  }
}
