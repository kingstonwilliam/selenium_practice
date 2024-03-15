package TestNgPractice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class AssertEqualPractice {
	String name= "king";
	
//	@Test
//	public void Method() {
//		if(name.equals("King")) {
//			System.out.println("correct name");
//			
//		}
//		else {
//			System.out.println("wrong name");
//		}
//	}
	@Test
	public void AssertEquals() {
		Assert.assertEquals("name","name");
	}
	
}
