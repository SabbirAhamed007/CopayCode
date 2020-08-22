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

public class Cotellic_ZelborafTest {

	public static WebDriver driver;

	@Given("^I open copayassistancenow home page$")
	public void i_open_copayassistancenow_home_page() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.get("https://www.copayassistancenow.com/");
		driver.findElement(By.id("enlarger-size-small")).click();

	}

	@Given("^Select Patient_Caregiver$")
	public void select_Patient_Caregiver() throws Throwable {

		driver.get("https://www.copayassistancenow.com/patients");

	}

	@Given("^Click on apply now$")
	public void click_on_apply_now() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/a[1]")).click();

	}

	@Given("^Select patinet not enrolled before$")
	public void select_patinet_not_enrolled_before() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Select Legally athorized person on behalf of the patient$")
	public void select_Legally_athorized_person_on_behalf_of_the_patient() throws Throwable {

		driver.findElement(By.id("opt2")).click();

	}

	@Given("^Selcet medicine Ctellic$")
	public void selcet_medicine_Ctellic() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("Cotellic")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}
		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/ul/li[3]/a")).click();

	}

	@Given("^Press next button$")
	public void press_next_button() throws Throwable {

		driver.findElement(By.id("agree")).click();

	}

	@When("^I have complete the eligibility questions$")
	public void i_have_complete_the_eligibility_questions() throws Throwable {

		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[3]/td[2]/p[2]/input")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[3]/td[2]/p[8]/input")).click();

		driver.findElement(By.name("question-4")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();

		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();

		driver.findElement(By.name("question-8")).click();

		driver.findElement(By.name("question-9")).click();

		driver.findElement(By.xpath(".//*[@id='container']/p[2]/button")).click();

	}

	@When("^I fillup the Legally Authorized Person information$")
	public void i_fillup_the_Legally_Authorized_Person_information() throws Throwable {

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("guardian_first_name")).clear();
		driver.findElement(By.id("guardian_first_name")).sendKeys("Stacy" + currentTime);

		driver.findElement(By.id("guardian_last_name")).clear();
		driver.findElement(By.id("guardian_last_name")).sendKeys("Adams" + currentTime);

		driver.findElement(By.id("guardian_address_1")).clear();
		driver.findElement(By.id("guardian_address_1")).sendKeys("32 Clearman PL" + currentTime);

		driver.findElement(By.id("guardian_address_2")).clear();
		driver.findElement(By.id("guardian_address_2")).sendKeys("Apt 12" + currentTime);

		driver.findElement(By.id("guardian_city")).clear();
		driver.findElement(By.id("guardian_city")).sendKeys("Belleville" + currentTime);

		WebElement list_by_state = driver.findElement(By.id("guardian_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.id("guardian_zip")).clear();
		driver.findElement(By.id("guardian_zip")).sendKeys("07502" + currentTime);

		driver.findElement(By.id("guardian_phone_number")).clear();
		driver.findElement(By.id("guardian_phone_number")).sendKeys("9723451212" + currentTime);

	}

	@When("^I fillup the Patient information$")
	public void i_fillup_the_Patient_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Andy" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Cole" + currentTime);

		WebElement list_by_gender = driver.findElement(By.name("sex"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("M");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/select/option[6]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/select/option[32]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/select/option[50]")).click();

		driver.findElement(By.id("same-address")).click();

		driver.findElement(By.id("SocialSecurityNumber")).clear();
		driver.findElement(By.id("SocialSecurityNumber")).sendKeys("1234");

	}

	@When("^Insurance information$")
	public void insurance_information() throws Throwable {

		WebElement list_by_insuranceCompany = driver.findElement(By.id("insuranceCompanyName"));
		Select List_by_InsuranceCompany = new Select(list_by_insuranceCompany);

		List_by_InsuranceCompany.selectByValue("Blue Cross");

		WebElement list_by_insurancePlanType = driver.findElement(By.id("insurancePlanType"));
		Select List_by_InsurancePlanType = new Select(list_by_insurancePlanType);

		List_by_InsurancePlanType.selectByValue("HMO");

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

	@When("^Click on Next$")
	public void click_on_Next() throws Throwable {

		boolean isDisplayed = driver.findElement(By.xpath(".//*[@id='container']/p/button")).isDisplayed();

		boolean isEnbled = driver.findElement(By.xpath(".//*[@id='container']/p/button")).isEnabled();

		if (isDisplayed) {
			System.out.println("Button is Displayed");

		} else {
			System.out.println("Button is not Displayed");

		}

		if (isEnbled) {
			System.out.println("Button is Enbled");

		} else {
			System.out.println("Button is not Enbled");

		}

		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();

	}

	@When("^fill in the doctor's information$")
	public void fill_in_the_doctor_s_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("doc_firstName")).clear();
		driver.findElement(By.id("doc_firstName")).sendKeys("Elvin" + currentTime);

		driver.findElement(By.id("doc_lastName")).clear();
		driver.findElement(By.id("doc_lastName")).sendKeys("White" + currentTime);

		driver.findElement(By.id("doc_practiceName")).clear();
		driver.findElement(By.id("doc_practiceName")).sendKeys("Andew Milner" + currentTime);

		driver.findElement(By.id("doc_address")).clear();
		driver.findElement(By.id("doc_address")).sendKeys("13 Clearman Pl" + currentTime);

		driver.findElement(By.id("doc_address2")).clear();
		driver.findElement(By.id("doc_address2")).sendKeys("2nd Fl" + currentTime);

		driver.findElement(By.id("doc_city")).clear();
		driver.findElement(By.id("doc_city")).sendKeys("Paterson" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("IL");

		driver.findElement(By.id("doc_zipCode")).clear();
		driver.findElement(By.id("doc_zipCode")).sendKeys("67887" + currentTime);

		driver.findElement(By.id("doc_phone")).clear();
		driver.findElement(By.id("doc_phone")).sendKeys("8641232323" + currentTime);

	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {

		boolean isDisplayed = driver.findElement(By.xpath(".//*[@id='container']/p/button")).isDisplayed();

		boolean isEnbled = driver.findElement(By.xpath(".//*[@id='container']/p/button")).isEnabled();

		if (isDisplayed) {
			System.out.println("Button is Displayed");

		} else {
			System.out.println("Button is not Displayed");

		}

		if (isEnbled) {
			System.out.println("Button is Enbled");

		} else {
			System.out.println("Button is not Enbled");

		}

		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();

	}

	@Then("^I verify Confirm This Information Is Correct$")
	public void i_verify_Confirm_This_Information_Is_Correct() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());

		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());

		WebElement element2 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[3]"));

		System.out.println(element2.getText());
		
		WebElement element3 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[4]/strong"));

		System.out.println(element3.getText());
		
		
		WebElement element4 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[5]"));

		System.out.println(element4.getText());		
		
		
	
	}

	@Then("^click on check box All information is correct$")
	public void click_on_check_box_All_information_is_correct() throws Throwable {
		
		driver.findElement(By.id("allcorrect")).click();


		

	}

	@Then("^click on confirm button$")
	public void click_on_confirm_button() throws Throwable {
		
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();

	}

	@Then("^Close the browsers$")
	public void close_the_browsers() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/h1"));

		System.out.println(element.getText());


		
		driver.quit();

	}

}
