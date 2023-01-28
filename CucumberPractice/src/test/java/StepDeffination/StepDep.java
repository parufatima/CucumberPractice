package StepDeffination;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDep {
	static WebDriver driver;
	static String URL = "https://www.paychex.com/login";

	@Given("^User lunch application URL$")
	public void user_lunch_application_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Program Files\\eclipse\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies(); 

	}
	// Paychex window handle

	@Then("^User click on login link$")
	public void user_click_on_login_link() throws Throwable {
		
		 WebElement loginLink = driver.findElement(By.linkText("Paychex Flex login"));
		  loginLink.click();

	}

	@Then("^User in login page and verify$")
	public void user_in_login_page_and_verify() throws Throwable {
		
		 Set<String> window = driver.getWindowHandles();
		    Iterator<String> ite  = window.iterator();
		    
		    String parentWindow = ite.next();
		    String childWindow = ite.next();
		    
		    driver.switchTo().window(childWindow);
		    driver.switchTo().frame("login");
		    
		    WebElement userNameField = driver.findElement(By.id("USER"));
		    userNameField.sendKeys("fatima");
		    
		   String inputValue = driver.findElement(By.id("USER")).getAttribute("value");
		   System.out.println(inputValue); 
		   
		   boolean verifyPage = driver.findElement(By.xpath("//label[text()='Enter Username']")).isDisplayed();
		   Assert.assertTrue(verifyPage);
		   
		   driver.switchTo().window(parentWindow);
		   

	}

	// demoblez login

	@When("^User  click login link$")
	public void user_click_login_link() throws Throwable {

		WebElement loginLink = driver.findElement(By.id("login2"));
		loginLink.click();
		

	}

	@When("^User enter name in username field$")
	public void user_enter_name_in_username_field() throws Throwable {

		WebElement loginField = driver.findElement(By.id("loginusername"));
		loginField.sendKeys("hjhjk");
	}

	@When("^User enter password in password field$")
	public void user_enter_password_in_password_field() throws Throwable {
		WebElement passWord = driver.findElement(By.id("loginpassword"));
		passWord.sendKeys("22224");
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
		WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Log in']"));
		loginBtn.click();
		Thread.sleep(5000);

	}

	@Then("^user login successfully$")
	public void user_login_successfully() throws Throwable {

		// WebDriverWait time = new WebDriverWait(driver, Duration.ofSeconds(30));

		Alert al = driver.switchTo().alert();
		al.accept();

	}

	// Scenario Amazon search

	@When("^User enter Home decor in search field$")
	public void user_enter_Home_decor_in_search_field() {

		WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
		searchField.sendKeys("Home decor");

	}

	@When("^click on search button$")
	public void click_on_search_button() {

		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
		searchBtn.click();

	}

	@Then("^Verify User successfully navigate to the home decor page$")
	public void verify_User_successfully_navigate_to_the_home_decor_page() {

		boolean result = driver.findElement(By.xpath("//span[text()='Shop unique Handmade items']")).isDisplayed();

		Assert.assertTrue(result);

		driver.close();

	}

	@Then("^close the application$")
	public void close_the_application() throws Throwable {

		Thread.sleep(9000);

		driver.quit();
	}

}
