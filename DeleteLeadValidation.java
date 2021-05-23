package stepDefintion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLeadValidation extends BaseTest {

ChromeDriver driver;
String LeadID;
String NoRecText;

	
	@Given("Launch Chrome browser for Delete Lead")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@When("Load URL for Delete Lead {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	@And("Type username for Delete Lead as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("Type password for Delete Lead as {string}")
	public void typepassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@And("Click Login Button for Delete Lead")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Verify Login is successful for Delete")
	public void isSuccessforDelete() throws InterruptedException {
		WebElement eleCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		System.out.println(eleCRMSFA.isDisplayed());
		Thread.sleep(5000);
	}
	
	@And("Click CRM SFA for Delete")
	public void clickCRMforDelete() throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
	}
	
	
	@And("Click Leads Tab for Delete")
	public void clickLeads() throws InterruptedException {
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(5000);
	}
	
	@Then("To Click on the Find Leads for Delete")
	public void findLeadstoDelete()
	{
		driver.findElement(By.linkText("Find Leads")).click();
	}
	
	 @And("To click on phone number tab for Delete")
	 public void clickPhoneNumberforDelete()
	 {
	  	driver.findElement(By.linkText("Phone")).click();
	 }
	 
	 @And("Enter phone number for Delete as (.*)$")
	 public void typePhone(String phoneNumber)
	 {
	   	driver.findElement(By.name("phoneNumber")).sendKeys(phoneNumber);
	 }
	 
	 @And("Submit Find Leads button for Delete")
	 public void clickFinLeadsForDelete() throws InterruptedException
	 {
		Thread.sleep(2000);
	  	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
	 }
	 
	 @And("Capture LeadId for Delete")
	 public void captureLead() 
	  {
		  LeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).getText();
		  System.out.println(LeadID);
	  }
	 
	 @And("Click first matching Result for Delete")
	  public void clickfirstMatch() throws InterruptedException
	  {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
		  Thread.sleep(2000);
	  }
	 
	 @And("Click Delete Button")
	  public void deleteClick() throws InterruptedException
	  {
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[text()='Delete']")).click();
		  Thread.sleep(3000);
	  }
	 
	  @And("Click Find Leads for Delete")
	  public void findClick()
	  {
		  driver.findElement(By.linkText("Find Leads")).click();
	  }
	  
	  @And("Send LeadId button")
	  public void sendLeadid()
	  {
		  driver.findElement(By.name("id")).sendKeys(LeadID);
	  }
	  
	  @And("Click Find Leads Button for Delete")
	  public void clickFind()
	  {
		  driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	  }
	  
	  @Then("Verify No Records Display Message")
	  public void verifyMessage()
	  {
		  NoRecText = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
			System.out.println(NoRecText);
			if(NoRecText.contains("No records to display")) 
			{
				System.out.println("Lead is deleted");
			} else {
				System.out.println("Lead is not deleted");
			}
	  }
	 
}
