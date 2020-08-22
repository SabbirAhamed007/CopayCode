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

public class Rituxan_RituxanHycelaTest {

	public static WebDriver driver;

	@Given("^I open Copay assistance site$")
	public void i_open_Copay_assistance_site() throws Throwable {

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

	@Given("^select apply now$")
	public void select_apply_now() throws Throwable {
		
		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@Given("^Select patient did not enrolled in the BioOncology$")
	public void select_patient_did_not_enrolled_in_the_BioOncology() throws Throwable {
		
		
		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Select as a patient$")
	public void select_as_a_patient() throws Throwable {
		
		driver.findElement(By.id("opt1")).click();

	}

	@Given("^select program Rituxan$")
	public void select_program_Rituxan() throws Throwable {
		
		
		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("RITUXAN")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}
		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/ul/li[9]/a")).click();


	}

	@Given("^go to next$")
	public void go_to_next() throws Throwable {
		
		
		driver.findElement(By.id("agree")).click();

	}

	@When("^I complete eligibility QN with RituxanHycela$")
	public void i_complete_eligibility_QN_with_RituxanHycela() throws Throwable {

		
		driver.findElement(By.name("question-1")).click();
		
		driver.findElement(By.name("question-2")).click();
		
		driver.findElement(By.name("question-3")).click();
		
		driver.findElement(By.name("question-3a")).click();
		
		driver.findElement(By.name("question-4")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();
		
		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("FL");
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();
		
		driver.findElement(By.name("question-8")).click();
		
		driver.findElement(By.name("question-9")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/p/button")).click();

		
		
		
		
	}

	@When("^Enter the patinet info$")
	public void enter_the_patinet_info() throws Throwable {
		
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

	@When("^Insurance info$")
	public void insurance_info() throws Throwable {
		
		
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

	@When("^select next$")
	public void select_next() throws Throwable {
		
		
		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();

	}

	@When("^enter doctor information$")
	public void enter_doctor_information() throws Throwable {
		
		
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

	@When("^submit$")
	public void submit() throws Throwable {
		
		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();

	}

	@Then("^I verify the information$")
	public void i_verify_the_information() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());



		
		

	}

	@Then("^Select information is correct$")
	public void select_information_is_correct() throws Throwable {
		
		
		driver.findElement(By.id("allcorrect")).click();
		
		
		

	}

	@Then("^select confirm$")
	public void select_confirm() throws Throwable {
		
		
		driver.findElement(By.id("submit")).click();

	}

	@Then("^Verify the refarance number$")
	public void verify_the_refarance_number() throws Throwable {
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/h1"));

		System.out.println(element1.getText());
		
		
		driver.quit();


	}

}
