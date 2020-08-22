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

public class KadcylaTest {

	public static WebDriver driver;

	@Given("^I open copayassistance home page$")
	public void i_open_copayassistance_home_page() throws Throwable {

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

	@Given("^Click apply now$")
	public void click_apply_now() throws Throwable {

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@Given("^Select patinet not enrolled$")
	public void select_patinet_not_enrolled() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Select Legally athorized person$")
	public void select_Legally_athorized_person() throws Throwable {

		driver.findElement(By.id("opt2")).click();

	}

	@Given("^Selcet medicine Kadcyla$")
	public void selcet_medicine_Kadcyla() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("kadcyla")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/ul/li[7]/a")).click();

	}

	@Given("^Press button$")
	public void press_button() throws Throwable {

		driver.findElement(By.id("agree")).click();

	}

	@When("^I have complete the eligibility question$")
	public void i_have_complete_the_eligibility_question() throws Throwable {

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

	@When("^I fillup Legally Authorized Person information$")
	public void i_fillup_Legally_Authorized_Person_information() throws Throwable {

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("guardian_first_name")).clear();
		driver.findElement(By.id("guardian_first_name")).sendKeys("Elveen" + currentTime);

		driver.findElement(By.id("guardian_last_name")).clear();
		driver.findElement(By.id("guardian_last_name")).sendKeys("Persey" + currentTime);

		driver.findElement(By.id("guardian_address_1")).clear();
		driver.findElement(By.id("guardian_address_1")).sendKeys("26 Clearmna Pl" + currentTime);

		driver.findElement(By.id("guardian_address_2")).clear();
		driver.findElement(By.id("guardian_address_2")).sendKeys("Apt 7" + currentTime);

		driver.findElement(By.id("guardian_city")).clear();
		driver.findElement(By.id("guardian_city")).sendKeys("Wayne" + currentTime);

		WebElement list_by_state = driver.findElement(By.id("guardian_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("FL");

		driver.findElement(By.id("guardian_zip")).clear();
		driver.findElement(By.id("guardian_zip")).sendKeys("87507" + currentTime);

		driver.findElement(By.id("guardian_phone_number")).clear();
		driver.findElement(By.id("guardian_phone_number")).sendKeys("8750343635" + currentTime);

	}

	@When("^I fillup Patient information$")
	public void i_fillup_Patient_information() throws Throwable {

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Enderson" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("James" + currentTime);

		WebElement list_by_gender = driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[12]/span/select"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("M");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/select/option[7]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/select/option[17]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/select/option[35]")).click();

		driver.findElement(By.xpath(".//*[@id='same-address']")).click();

		driver.findElement(By.xpath(".//*[@id='SocialSecurityNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='SocialSecurityNumber']")).sendKeys("7878");

	}

	@When("^fill up Insurance information$")
	public void fill_up_Insurance_information() throws Throwable {

		WebElement list_by_companyName = driver.findElement(By.id("insuranceCompanyName"));
		Select List_by_CompanyName = new Select(list_by_companyName);

		List_by_CompanyName.selectByValue("Cigna");

		WebElement list_by_planType = driver.findElement(By.id("insurancePlanType"));
		Select List_by_PlanType = new Select(list_by_planType);

		List_by_PlanType.selectByValue("HMO");

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("insuranceGroupNumber")).clear();
		driver.findElement(By.id("insuranceGroupNumber")).sendKeys("123456789" + currentTime);

		driver.findElement(By.id("insuranceMemberNumber")).clear();
		driver.findElement(By.id("insuranceMemberNumber")).sendKeys("923456789" + currentTime);

		driver.findElement(By.id("insuranceBINNumber")).clear();
		driver.findElement(By.id("insuranceBINNumber")).sendKeys("123456" + currentTime);

		driver.findElement(By.id("insurancePCNNumber")).clear();
		driver.findElement(By.id("insurancePCNNumber")).sendKeys("123456" + currentTime);

	}

	@When("^press Next$")
	public void press_Next() throws Throwable {

		driver.findElement(By.className("input-submit")).click();

	}

	@When("^fill in the doctor information$")
	public void fill_in_the_doctor_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.xpath(".//*[@id='doc_firstName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_firstName']")).sendKeys("Carla" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_lastName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_lastName']")).sendKeys("McMilan" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_practiceName']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_practiceName']")).sendKeys("Alex Cantona" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_address']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_address']")).sendKeys("19 Paterson Ave" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_city']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_city']")).sendKeys("Paterson" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("FL");

		driver.findElement(By.xpath(".//*[@id='doc_zipCode']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_zipCode']")).sendKeys("37502" + currentTime);

		driver.findElement(By.xpath(".//*[@id='doc_phone']")).clear();
		driver.findElement(By.xpath(".//*[@id='doc_phone']")).sendKeys("8621234383" + currentTime);

	}

	@When("^click submit button$")
	public void click_submit_button() throws Throwable {

		driver.findElement(By.name("apply-step-two-submit")).click();

	}

	@Then("^I verify Confirm Information Is Correct$")
	public void i_verify_Confirm_Information_Is_Correct() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());

		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());

	}

	@Then("^click on check box information is correct$")
	public void click_on_check_box_information_is_correct() throws Throwable {

		driver.findElement(By.id("allcorrect")).click();

	}

	@Then("^click confirms button$")
	public void click_confirms_button() throws Throwable {

		driver.findElement(By.id("submit")).click();

		
	}

	@Then("^Close the website$")
	public void close_the_website() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/h1"));

		System.out.println(element.getText());

		driver.quit();

	}

}
