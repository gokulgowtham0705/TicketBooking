package JaintTravels.testCases;


import org.testng.annotations.Test;

import Jaintravels.pageObjects.BookingPage;
import Jaintravels.pageObjects.LoginPage;

public class LoginPageTest extends baseClass{
	
	
	

	@Test
	public void login() {
  	  driver.get(baseurl);
  	  LoginPage lp = new LoginPage(driver);
  	  lp.Login("jpsb-qa1.techmango", "techmango@123");
  	
  	  lp.Book();
  	  }

	@Test(dependsOnMethods = {"login"})
	public void Walkin_Type_Booking()
	{
		BookingPage bp = new BookingPage(driver);
		bp.clickSeat();
		bp.booking_Type_Walkin();
		bp.confirm_Booking("Walkin Booking(AUT)", "1234567");
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=1)
	public void Online_Type_Booking() {
		BookingPage bp = new BookingPage(driver);
		bp.clickSeat();
        bp.booking_Type_Online_Agent(2);
        bp.confirm_Booking("Online Booking(AUT)", "1234567");
        driver.switchTo().alert().accept();
	}
	
	@Test(priority=1)
	public void Offline_Type_Booking() {
		BookingPage bp = new BookingPage(driver);
		bp.clickSeat();
        bp.booking_Type_Offline_Agent(2);
        bp.confirm_Booking("Offline Booking(AUT)", "1234567");
        driver.switchTo().alert().accept();
	}
	
	@Test(priority=1)
	public void Branch_Type_Booking() {
		BookingPage bp = new BookingPage(driver);
		bp.clickSeat();
        bp.booking_Type_Branch_Booking(2, 0);
        bp.confirm_Booking("Branch Booking(AUT)", "1234567");
        driver.switchTo().alert().accept();
	}
	
	
	
}
