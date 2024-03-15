package TestNgPractice;

import org.testng.annotations.Test;

public class TestDependency {
	// dependency method helps to stop executing if the
	// parent method doesn't work.
	// trip to velankanni
	// 1.book a ticket
	// 2.get in the correct train
	// 3.search for your seat and sit
	@Test //(enabled = false)
	public void bookTrainTicket() {
		System.out.println("book a ticket to velakanni");
	}

	@Test(dependsOnMethods = "bookTrainTicket")
	public void getTheTrain() {
		System.out.println("get in the corrrect train");
	}

	@Test(dependsOnMethods = "getTheTrain")
	public void searchForSeat() {
		System.out.println("search for your seat");
	}
}
