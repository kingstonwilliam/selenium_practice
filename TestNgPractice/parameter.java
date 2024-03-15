package TestNgPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameter {
	@Test
	@Parameters ("uName")
public void userName(String name) {
	System.out.println("user name is :"+ name);
}
}
