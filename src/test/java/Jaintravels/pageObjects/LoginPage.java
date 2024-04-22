package Jaintravels.pageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
    
    public LoginPage(WebDriver rdriver)
     {
   	  ldriver=rdriver;
   	  PageFactory.initElements(rdriver, this);
     }
    
    @FindBy(id="login")
    WebElement username;
    
    @FindBy(id="password")
    WebElement password;
    
    @FindBy(id="login_button")
    WebElement login_button;
    
    @FindBy(id="available_3")
	WebElement bookButton;
    
    @FindBy(id="search_widget_form_submit")
    WebElement searchButton;
    
    
    
    public void Login(String uname, String pwd) {
   	 username.sendKeys(uname);
   	 password.sendKeys(pwd);
     login_button.click();
   	 
    }
    public void Book() {
    	try {
    		bookButton.isDisplayed();           
        } 
    	catch (NoSuchElementException e) {
            // Handle the exception by printing an error message and taking alternative actions
    		searchButton.click();
    		bookButton.click();
        }
     
    }
    
    public void setpassword(String pwd) {
   	 password.sendKeys(pwd);
    }
    
    public void clicklogin() 
    {
   	 login_button.click();
    }
}
