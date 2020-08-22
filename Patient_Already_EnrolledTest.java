package StePDEfinatioN;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Patient_Already_EnrolledTest {

	public static WebDriver driver;

	@Given("^I open Patient portal$")
	public void i_open_Patient_portal() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.copayassistancenow.com/patients");
		driver.findElement(By.id("enlarger-size-small")).click();

	}

	@Given("^I click on apply now tab$")
	public void i_click_on_apply_now_tab() throws Throwable {

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@When("^I select patient already enrolled$")
	public void i_select_patient_already_enrolled() throws Throwable {

		driver.findElement(By.id("enroll-yes")).click();

	}

	@Then("^I Enter valid member ID$")
	public void i_Enter_valid_member_ID() throws Throwable {

		driver.findElement(By.id("short_card_id")).sendKeys("XB0000246275");

	}

	@Then("^I select valid date of birth$")
	public void i_select_valid_date_of_birth() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[3]/span[1]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[3]/span[1]/select/option[7]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[3]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[3]/span[2]/select/option[17]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[7]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[7]/span[3]/select/option[35]")).click();

	}

	@Then("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container']/form[2]/p[9]/button")).click();

	}

}
