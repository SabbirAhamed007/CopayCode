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

public class Rituxan_VencleaxtaTest {

	public static WebDriver driver;

	@Given("^I open copayassistancenow site$")
	public void i_open_copayassistancenow_site() throws Throwable {

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

	@Given("^Select Patient_Caregiver option$")
	public void select_Patient_Caregiver_option() throws Throwable {

		driver.get("https://www.copayassistancenow.com/patients");

	}

	@Given("^Click on apply now button$")
	public void click_on_apply_now_button() throws Throwable {

		driver.findElement(By.xpath("//a[@class='button enroll']")).click();

	}

	@Given("^Select patinet is not enrolled before$")
	public void select_patinet_is_not_enrolled_before() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Select the patient$")
	public void select_the_patient() throws Throwable {

		driver.findElement(By.id("opt1")).click();

	}

	@Given("^Selcet medicine Rituxan$")
	public void selcet_medicine_Rituxan() throws Throwable {

		driver.findElement(By.xpath("//span[@class='dropdown-label ng-binding' and 1]")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("rituxan")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}

		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/ul/li[9]/a")).click();

	}

	@Given("^click on next button$")
	public void click_on_next_button() throws Throwable {

		driver.findElement(By.id("agree")).click();

	}

	@When("^I have selected the eligibility questions$")
	public void i_have_selected_the_eligibility_questions() throws Throwable {

		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();

		driver.findElement(By.name("question-3")).click();

		driver.findElement(By.name("question-3a")).click();

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

	@When("^I am fillingup the Patient information$")
	public void i_am_fillingup_the_Patient_information() throws Throwable {

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Mathew" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Hudson" + currentTime);

		WebElement list_by_gender = driver.findElement(By.name("sex"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("M");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[1]/div/span/a/span[1]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[1]/select/option[11]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[2]/select/option[15]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[5]/span[3]/select/option[37]")).click();

		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("12 Ericson Ave" + currentTime);

		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys("Apt 3" + currentTime);

		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Wayne" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("FL");

		driver.findElement(By.id("zipCode")).sendKeys("87612");

		driver.findElement(By.id("homePhone")).sendKeys("8762311212");

		driver.findElement(By.id("SocialSecurityNumber")).sendKeys("3456");

	}

	@When("^Insurance informations$")
	public void insurance_informations() throws Throwable {

		WebElement list_by_insurancecompany = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurancecompany = new Select(list_by_insurancecompany);

		List_by_Insurancecompany.selectByValue("Cigna");

		WebElement list_by_insuranceplan = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Insuranceplan = new Select(list_by_insuranceplan);

		List_by_Insuranceplan.selectByValue("HRA");

		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("insuranceGroupNumber")).clear();
		driver.findElement(By.id("insuranceGroupNumber")).sendKeys("12345678" + currentTime);

		driver.findElement(By.id("insuranceMemberNumber")).clear();
		driver.findElement(By.id("insuranceMemberNumber")).sendKeys("7654321" + currentTime);

		driver.findElement(By.id("insuranceBINNumber")).sendKeys("123456");

		driver.findElement(By.id("insurancePCNNumber")).sendKeys("123456");

	}

	@When("^go to Next$")
	public void go_to_Next() throws Throwable {
		
		
		driver.findElement(By.name("apply-step-one-submit")).click();

	}

	@When("^fillup the doctors information$")
	public void fillup_the_doctors_information() throws Throwable {

		
		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("doc_firstName")).clear();
		driver.findElement(By.id("doc_firstName")).sendKeys("Elvin" + currentTime);
		
		driver.findElement(By.id("doc_lastName")).clear();
		driver.findElement(By.id("doc_lastName")).sendKeys("Presley" + currentTime);
		
		driver.findElement(By.id("doc_practiceName")).clear();
		driver.findElement(By.id("doc_practiceName")).sendKeys("Moley Steven" + currentTime);
		
		driver.findElement(By.id("doc_address")).clear();
		driver.findElement(By.id("doc_address")).sendKeys("11 Edmound Ave" + currentTime);
		
	
		driver.findElement(By.id("doc_city")).sendKeys("Kerney");
		
		
		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("FL");
		
		
		driver.findElement(By.id("doc_zipCode")).sendKeys("87612");
		
		
		driver.findElement(By.id("doc_phone")).clear();
		driver.findElement(By.id("doc_phone")).sendKeys("7891222323" + currentTime);
	
		
	}

	@When("^click on submit$")
	public void click_on_submit() throws Throwable {
		
		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();

	}

	@Then("^I verify Confirm This Information Correct$")
	public void i_verify_Confirm_This_Information_Correct() throws Throwable {
		
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());


	}

	@Then("^click on check box All information correct$")
	public void click_on_check_box_All_information_correct() throws Throwable {
		
		
		driver.findElement(By.id("allcorrect")).click();

	}

	@Then("^click on confirm$")
	public void click_on_confirm() throws Throwable {
		
		driver.findElement(By.id("submit")).click();
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/h1"));
		System.out.println(element1.getText());
		

	}

	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		
		driver.quit();

	}

}
