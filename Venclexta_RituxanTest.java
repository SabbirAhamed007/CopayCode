package StePDEfinatioN;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Venclexta_RituxanTest {

	public static WebDriver driver;

	@Given("^I open Copayassistance site$")
	public void i_open_Copayassistance_site() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.copayassistancenow.com/");
		driver.findElement(By.id("enlarger-size-small")).click();

	}

	@Given("^click apply now$")
	public void click_apply_now() throws Throwable {

		driver.get("https://www.copayassistancenow.com/patients");

		driver.findElement(By.xpath("//a[@class='button enroll']")).click();

	}

	@Given("^select user never user never enrolled$")
	public void select_user_never_user_never_enrolled() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^select LAP$")
	public void select_LAP() throws Throwable {

		driver.findElement(By.id("opt2")).click();

	}

	@Given("^select Venclexta$")
	public void select_Venclexta() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("VENCLEXTA")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}
		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/ul/li[14]/a")).click();

		driver.findElement(By.id("agree")).click();

	}

	@When("^I complete the eligibility qn with Rituxan$")
	public void i_complete_the_eligibility_qn_with_Rituxan() throws Throwable {
		
		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();

		driver.findElement(By.name("question-3")).click();
		
		driver.findElement(By.name("question-3a")).click();
		driver.findElement(By.name("question-3b")).click();
		driver.findElement(By.name("question-3c")).click();
		

		driver.findElement(By.name("question-4")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();

		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NY");

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();

		driver.findElement(By.name("question-8")).click();

		driver.findElement(By.name("question-9")).click();

		driver.findElement(By.name("apply-step-one-submit")).click();

		

	}

	@When("^fillup lap info$")
	public void fillup_lap_info() throws Throwable {
		
		
		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("guardian_first_name")).clear();
		driver.findElement(By.id("guardian_first_name")).sendKeys("Marei" + currentTime);

		driver.findElement(By.id("guardian_last_name")).clear();
		driver.findElement(By.id("guardian_last_name")).sendKeys("John" + currentTime);

		driver.findElement(By.id("guardian_address_1")).clear();
		driver.findElement(By.id("guardian_address_1")).sendKeys("19 Clearman Place" + currentTime);

		driver.findElement(By.id("guardian_city")).clear();
		driver.findElement(By.id("guardian_city")).sendKeys("Belleville" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("guardian_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NY");

		driver.findElement(By.id("guardian_zip")).clear();
		driver.findElement(By.id("guardian_zip")).sendKeys("07109" + currentTime);

		driver.findElement(By.id("guardian_phone_number")).clear();
		driver.findElement(By.id("guardian_phone_number")).sendKeys("9735431212" + currentTime);

		

	}

	@When("^Fillup Patient info$")
	public void fillup_Patient_info() throws Throwable {
		
		
		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Eleena" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Peter" + currentTime);

		WebElement list_by_gender = driver.findElement(By.name("sex"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("M");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/select/option[8]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/select/option[21]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/select/option[38]")).click();

		driver.findElement(By.id("same-address")).click();

		driver.findElement(By.id("SocialSecurityNumber")).clear();
		driver.findElement(By.id("SocialSecurityNumber")).sendKeys("1234" + currentTime);


	}

	@When("^fillup insurance info$")
	public void fillup_insurance_info() throws Throwable {
		
		WebElement list_by_insuranceCompany = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_InsuranceCompany = new Select(list_by_insuranceCompany);

		List_by_InsuranceCompany.selectByValue("Blue Shield");

		WebElement list_by_insurancePlan = driver.findElement(By.name("insurancePlanType"));
		Select List_by_InsurancePlan = new Select(list_by_insurancePlan);

		List_by_InsurancePlan.selectByValue("PPO");

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("insuranceGroupNumber")).clear();
		driver.findElement(By.id("insuranceGroupNumber")).sendKeys("1234567899" + currentTime);

		driver.findElement(By.id("insuranceMemberNumber")).clear();
		driver.findElement(By.id("insuranceMemberNumber")).sendKeys("2234567899" + currentTime);

		driver.findElement(By.id("insuranceBINNumber")).clear();
		driver.findElement(By.id("insuranceBINNumber")).sendKeys("123456" + currentTime);

		driver.findElement(By.id("insurancePCNNumber")).clear();
		driver.findElement(By.id("insurancePCNNumber")).sendKeys("123456" + currentTime);

		driver.findElement(By.name("apply-step-one-submit")).click();


	}

	@Then("^I fillup the doctor info$")
	public void i_fillup_the_doctor_info() throws Throwable {
		
		
		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("doc_firstName")).clear();
		driver.findElement(By.id("doc_firstName")).sendKeys("John" + currentTime);

		driver.findElement(By.id("doc_lastName")).clear();
		driver.findElement(By.id("doc_lastName")).sendKeys("Adams" + currentTime);

		driver.findElement(By.id("doc_practiceName")).clear();
		driver.findElement(By.id("doc_practiceName")).sendKeys("Michael Tims" + currentTime);

		driver.findElement(By.id("doc_address")).clear();
		driver.findElement(By.id("doc_address")).sendKeys("10 Edmound Ave" + currentTime);

		driver.findElement(By.id("doc_city")).sendKeys("Totowa");

		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.id("doc_zipCode")).clear();
		driver.findElement(By.id("doc_zipCode")).sendKeys("07511" + currentTime);

		driver.findElement(By.id("doc_phone")).clear();
		driver.findElement(By.id("doc_phone")).sendKeys("8623451212" + currentTime);

		

		
	

	}

	@Then("^click the submit button$")
	public void click_the_submit_button() throws Throwable {
		
		driver.findElement(By.name("apply-step-two-submit")).click();

	}

	@Then("^verify the info$")
	public void verify_the_info() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());

		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());


	}

	@Then("^confirm info$")
	public void confirm_info() throws Throwable {
		
		driver.findElement(By.id("allcorrect")).click();

	}

	@Then("^close the website$")
	public void close_the_website() throws Throwable {
		
		driver.quit();

	}

}
