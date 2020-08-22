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

public class AlecensaTest {

	public static WebDriver driver;

	@Given("^I open biooncology website$")
	public void i_open_biooncology_website() throws Throwable {

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

	@Given("^Click on apply now buttons$")
	public void click_on_apply_now_buttons() throws Throwable {

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@Given("^select patient is not enrolled yet$")
	public void select_patient_is_not_enrolled_yet() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Select patient$")
	public void select_patient() throws Throwable {

		driver.findElement(By.id("opt1")).click();

	}

	@Given("^select Alecensa program$")
	public void select_Alecensa_program() throws Throwable {

		driver.findElement(By.xpath("//span[@class='dropdown-label ng-binding' and 1]")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("alecensa")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}

		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/ul/li[1]/a")).click();

	}

	@Given("^Clicks on next$")
	public void clicks_on_next() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='agree']")).click();

	}

	@When("^I complete eligibility qn$")
	public void i_complete_eligibility_qn() throws Throwable {

		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();

		driver.findElement(By.name("question-3")).click();

		driver.findElement(By.name("question-4")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();

		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("PA");

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();

		driver.findElement(By.name("question-8")).click();

		driver.findElement(By.name("question-9")).click();

		driver.findElement(By.name("apply-step-one-submit")).click();

	}

	@Then("^I enter Patient information$")
	public void i_enter_Patient_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Carla" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Victor" + currentTime);

		WebElement list_by_gender = driver.findElement(By.name("sex"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("F");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[1]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[1]/select/option[9]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[2]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[2]/select/option[18]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[3]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[3]/select/option[43]")).click();

		driver.findElement(By.xpath(".//*[@id='address']")).clear();
		driver.findElement(By.xpath(".//*[@id='address']")).sendKeys("17 Clearman Pl" + currentTime);

		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Belleville" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.id("zipCode")).clear();
		driver.findElement(By.id("zipCode")).sendKeys("07109" + currentTime);

		driver.findElement(By.id("homePhone")).clear();
		driver.findElement(By.id("homePhone")).sendKeys("9731234545" + currentTime);

		driver.findElement(By.id("SocialSecurityNumber")).clear();
		driver.findElement(By.id("SocialSecurityNumber")).sendKeys("1234" + currentTime);

	}

	@Then("^I enter Insurance information$")
	public void i_enter_Insurance_information() throws Throwable {

		WebElement list_by_insurance = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance = new Select(list_by_insurance);

		List_by_Insurance.selectByValue("Aetna");

		WebElement list_by_plan = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan = new Select(list_by_plan);

		List_by_Plan.selectByValue("PPO");

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("insuranceGroupNumber")).clear();
		driver.findElement(By.id("insuranceGroupNumber")).sendKeys("1234567899" + currentTime);

		driver.findElement(By.id("insuranceMemberNumber")).clear();
		driver.findElement(By.id("insuranceMemberNumber")).sendKeys("9876543211" + currentTime);

		driver.findElement(By.id("insuranceBINNumber")).clear();
		driver.findElement(By.id("insuranceBINNumber")).sendKeys("123456" + currentTime);

		driver.findElement(By.id("insurancePCNNumber")).clear();
		driver.findElement(By.id("insurancePCNNumber")).sendKeys("123456" + currentTime);

	}

	@Then("^Click nexts$")
	public void click_nexts() throws Throwable {

		driver.findElement(By.name("apply-step-one-submit")).click();

	}

	@Then("^I enter doctor information$")
	public void i_enter_doctor_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.xpath(".//*[@id='doc_firstName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_firstName']")).sendKeys("James" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_lastName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_lastName']")).sendKeys("Horthon" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_practiceName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_practiceName']")).sendKeys("Alex Cantona" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_address']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_address']")).sendKeys("10 Paterson Ave" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_city']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_city']")).sendKeys("Paterson" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.xpath(".//*[@id='doc_zipCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_zipCode']")).sendKeys("07502" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_phone']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_phone']")).sendKeys("8621234343" + currentTime);

	}

	@Then("^press next(\\d+)$")
	public void press_next(int arg1) throws Throwable {

		driver.findElement(By.name("apply-step-two-submit")).click();

	}

	@Then("^verify infrmation$")
	public void verify_infrmation() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());

		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());

		WebElement element2 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[3]/strong"));

		System.out.println(element2.getText());

		driver.findElement(By.xpath(".//*[@id='allcorrect']")).click();

	}

	@Then("^clicks nexts$")
	public void clicks_nexts() throws Throwable {

		driver.findElement(By.id("submit")).click();

	}

	@Then("^Verify still processing$")
	public void verify_still_processing() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/h1"));

		System.out.println(element.getText());

		driver.quit();

	}

}
