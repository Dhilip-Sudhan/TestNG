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

public class CreateContactsValidation extends BaseTest {
	ChromeDriver driver;
	
	@Given("Launch Chrome browser")
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@When("Load URL {string}")
	public void loadUrl(String url) {
		driver.get(url);
	}
	
	@And("Type username as {string}")
	public void typeUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("Type password as {string}")
	public void typepassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	
	@Then("Click Login Button")
	public void clickLogin() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("Verify Login is successful")
	public void isSuccess() throws InterruptedException {
		WebElement eleCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		System.out.println(eleCRMSFA.isDisplayed());
		Thread.sleep(5000);
	}
	
	@Then("Click CRM SFA link")
	public void clickCRM() throws InterruptedException {
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(5000);
	}

	@Then("Click Contacts tab")
	public void clickContacts() throws InterruptedException {
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(5000);
	}
	
	@Then("Click Create Contacts")
	public void clickCreateContacts() throws InterruptedException {
		driver.findElement(By.linkText("Create Contact")).click();
		Thread.sleep(5000);
	}
	
	@And("Type First Name (.*)$")
	public void typeFirstNameContact(String fName) {
		driver.findElement(By.id("firstNameField")).sendKeys(fName);
	}

	@And("Type Last Name (.*)$")
	public void typeLastNameContact(String lName) {
		driver.findElement(By.id("lastNameField")).sendKeys(lName);
	}
	
	@Then("Click Create Contacts button")
	public void clickCreateContactsbutton() throws InterruptedException {
		driver.findElement(By.className("smallSubmit")).click();
		Thread.sleep(5000);
	}
	
	@Then("Verify Created Contact Successful")
	public void isCreateContactSuccess() {
		if(driver.getTitle().contains("View Contact")) {
			System.out.println("Success");
		}
	}
	
	
	
	/*
	@Then("Verify Created Contact Successful (.*)$")
	public void isCreateContactSuccess(String fName, String lName) {
		String eleNameCreated = driver.findElement(By.xpath("//span[text()='Name']//following::span[1]")).getText();
		String eleName = eleNameCreated.replaceAll("[^a-zA-Z]", " ");
		System.out.println(eleName);
		StringBuilder concatName = new StringBuilder().append(fName).append(" ").append(lName);
		if(eleName.equals(concatName)) {
			System.out.println("Created name should be displayed");
		} else {
			System.err.println("Created name should be displayed");
		}
	}*/
	
}