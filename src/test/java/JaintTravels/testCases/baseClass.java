package JaintTravels.testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class baseClass {
	
	public String baseurl = "https://jpsb-qa1.ticketsimply.co.in/account";
	public static WebDriver driver;
	Logger logger;
	

	
	@BeforeTest  
	public void setup() 
	{
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       logger = LogManager.getLogger(baseClass.class.getName());
      
	}
	
	@AfterTest
	public void teardown() 
	{
		driver.close();;
		
	}
	
    

}
