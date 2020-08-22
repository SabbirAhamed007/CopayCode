package StePDEfinatioN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountTest {

	public static WebDriver driver;

	@Given("^I open the account create page$")
	public void i_open_the_account_create_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.copayassistancenow.com/patients");

	}

	@Given("^I click on create on here link$")
	public void i_click_on_create_on_here_link() throws Throwable {

		driver.findElement(By.id("enlarger-size-small")).click();

		driver.get("https://www.copayassistancenow.com/create-account");

	}

	@When("^I complete to fillup the info$")
	public void i_complete_to_fillup_the_info() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("firstName")).clear();
		driver.findElement(By.id("firstName")).sendKeys("Adny" + currentTime);

		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("Cole" + currentTime);

		driver.findElement(By.id("member_id")).clear();
		driver.findElement(By.id("member_id")).sendKeys("XB0000246275" + currentTime);

		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[1]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[1]/select/option[10]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[2]/select/option[19]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form/p[5]/span[3]/select/option[49]")).click();

	}

	@Then("^I click the submit button$")
	public void i_click_the_submit_button() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container']/form/p[7]/button")).click();

	}

	@Then("^I verify the message$")
	public void i_verify_the_message() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div[2]/p"));

		System.out.println(element.getText());
		
		driver.quit();

	}

}
