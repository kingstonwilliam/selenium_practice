package TestNgPractice;

import org.testng.annotations.Test;

public class howToOpenEclipse {
	
	 @Test(priority=(0))
public void cfirstTestCase() {
	System.out.println("switch on the computer");
	//enable=false is used to skip the test case
}@Test(priority=(1),enabled=false)
public void asecondTestCase() {
	System.out.println("Enter the correct the password");
	
}@Test(priority=(2))
public void bthirdTestCase() {
	System.out.println("navigate to eclipse and double click");
	
}

}

