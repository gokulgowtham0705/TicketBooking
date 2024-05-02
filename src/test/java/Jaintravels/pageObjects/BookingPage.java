package Jaintravels.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingPage {
WebDriver ldriver;
    
    public BookingPage(WebDriver rdriver)
     {
   	  ldriver=rdriver;
   	  PageFactory.initElements(rdriver, this);
     }
    
    
    @FindBy(css=".available_seat.Seater.unshiftable_seat")
    List<WebElement> availableSeats;
    
    @FindBy(xpath="//*[@id='blockseats-details']/div[1]/span[1]/label")
    WebElement Walkin;
    
    @FindBy(xpath="//*[@id='on_behalf_online']/label")
    WebElement OnlineAgent;
   
    @FindBy(xpath="//*[@id='on_behalf_offline']/label")
    WebElement OfflineAgent;
 
    @FindBy(xpath="//input[@id='onbehalf_branch']//following::label[1]")
    WebElement Branch;
    
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_city_chosen\"]/a/div/b")
    WebElement Branch_Dropdown;
    

    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_branch_chosen\"]/div/ul/li")
    List <WebElement> Branch_List;

    
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_user_chosen\"]/a/div/b")
    WebElement Branch_User_Dropdown;
    

    
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_user_chosen\"]/div/ul/li")
    List<WebElement> Branch_User_List;
    
    //a[@class='chosen-single chosen-default']//following::div[1]/b
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_online_agent_chosen\"]/a/div/b")
    WebElement OnlineAgent_dropdown_arrow;
    
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_chosen\"]/a/div/b")
    WebElement OfflineAgent_dropdown_arrow;
    
 
    @FindBy(xpath="//*[@id=\"searchbus_on_behalf_branch_chosen\"]/a/div/b")
    WebElement Branch_dropdown_arrow;
    
    @FindAll( {@FindBy(xpath = "//*[@id=\"searchbus_on_behalf_online_agent_chosen\"]/div/ul/li")})
    List<WebElement> OnlineAgent_dropdown_option;
    
    

    @FindAll( {@FindBy(xpath = "//*[@id=\"searchbus_on_behalf_chosen\"]/div/ul//li")})
    List<WebElement> OfflineAgent_dropdown_option;
    
    @FindBy(xpath="//input[@class='col-sm-10 form-control input-sm enter-key']")
    WebElement PhoneNumber;
    
    @FindBy(xpath="//input[@data-pasname='name']")
    WebElement Name;
    
    @FindBy(xpath="//*[@id='search_submit_btn_new']")
    WebElement Confirm_Booking_Button;
    
    
    @FindBy(xpath="/html/body/div[15]/div[3]/div/button[2]")
    WebElement confirm_ticket;
    
    
    public void clickSeat() {
    System.out.println("Availables seats is " + availableSeats.size());
    WebElement firstAvailableSeat = availableSeats.get(2);
    firstAvailableSeat.click();
   
   }
    
   public void booking_Type_Walkin() {
    	Walkin.click();
    }
   
   public void booking_Type_Online_Agent(int OnlineAgentNo) {
	   OnlineAgent.click();
	   OnlineAgent_dropdown_arrow.click();
	  System.out.println( "The online agent list is " + OnlineAgent_dropdown_option.size());
	   OnlineAgent_dropdown_option.get(OnlineAgentNo).click();
   }
   
   public void booking_Type_Offline_Agent(int offlineagentNo) {
	   OfflineAgent.click();
	   OfflineAgent_dropdown_arrow.click();
	   System.out.println( "The offline agent list is " + OfflineAgent_dropdown_option.size());
	   OfflineAgent_dropdown_option.get(offlineagentNo).click();
   }
   
   public void booking_Type_Branch_Booking(int bno, int uno) {
	   Branch.click();
	   Branch_dropdown_arrow.click();
	   System.out.println( "The branch list is " + Branch_List.size());
	   Branch_List.get(bno).click();
	   Branch_User_Dropdown.click();
	   System.out.println("The branch user list is " + Branch_User_List.size());
	   Branch_User_List.get(uno).click();
	   
	   
   }
   
   public void confirm_Booking(String FullName,String Number) {
	   Name.sendKeys(FullName);
	   PhoneNumber.sendKeys(Number);
	   Confirm_Booking_Button.click();
	   
	   
	   
   }
   public void confirm_ticket() {
	   confirm_ticket.click();
   }
    
   
    

}
