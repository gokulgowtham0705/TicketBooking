package JaintTravels.testCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class baseClass {
	
	public String baseurl = "https://jpsb-qa1.ticketsimply.co.in/account";
	public static WebDriver driver;

	
	@BeforeClass
	public void setup() 
	{
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       
	}
	
//	@AfterClass
//	public void teardown() 
//	{
//		
//		
//	}
	
    

}
