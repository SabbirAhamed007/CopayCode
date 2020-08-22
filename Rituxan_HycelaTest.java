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

public class Rituxan_HycelaTest {
	public static WebDriver driver;

	@Given("^I open biooncology for Rituxan Hycela enrollment$")
	public void i_open_biooncology_for_Rituxan_Hycela_enrollment() throws Throwable {

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

	@Given("^Choose to apply now$")
	public void choose_to_apply_now() throws Throwable {

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@Given("^Choose patient not enrolled yet$")
	public void choose_patient_not_enrolled_yet() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^Apply like a LAP$")
	public void apply_like_a_LAP() throws Throwable {

		driver.findElement(By.id("opt2")).click();

	}

	@Given("^Choose Rituxan Hycela program$")
	public void choose_Rituxan_Hycela_program() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("rituxanhycela")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/ul/li[10]/a")).click();

		driver.findElement(By.id("agree")).click();

	}

	@When("^I fillup complete the eligibility qn$")
	public void i_fillup_complete_the_eligibility_qn() throws Throwable {

		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();

		driver.findElement(By.name("question-3")).click();
		driver.findElement(By.name("question-3a2")).click();

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

	@When("^Enter the Legally Authorized Person information$")
	public void enter_the_Legally_Authorized_Person_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("guardian_first_name")).clear();
		driver.findElement(By.id("guardian_first_name")).sendKeys("Doris" + currentTime);

		driver.findElement(By.id("guardian_last_name")).clear();
		driver.findElement(By.id("guardian_last_name")).sendKeys("Alison" + currentTime);

		driver.findElement(By.id("guardian_address_1")).clear();
		driver.findElement(By.id("guardian_address_1")).sendKeys("35 Clearman Place" + currentTime);

		driver.findElement(By.id("guardian_city")).clear();
		driver.findElement(By.id("guardian_city")).sendKeys("Belleville" + currentTime);

		WebElement list_by_state = driver.findElement(By.name("guardian_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("MN");

		driver.findElement(By.id("guardian_zip")).clear();
		driver.findElement(By.id("guardian_zip")).sendKeys("54109" + currentTime);

		driver.findElement(By.id("guardian_phone_number")).clear();
		driver.findElement(By.id("guardian_phone_number")).sendKeys("9739431212" + currentTime);

	}

	@When("^Enter Patient information$")
	public void enter_Patient_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Kim" + currentTime);

		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Hudson" + currentTime);

		WebElement list_by_gender = driver.findElement(By.name("sex"));
		Select List_by_Gender = new Select(list_by_gender);

		List_by_Gender.selectByValue("F");

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/select/option[8]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/select/option[21]")).click();

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/div/span/a/span[1]")).click();
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/select/option[38]")).click();

		driver.findElement(By.id("same-address")).click();

		driver.findElement(By.id("SocialSecurityNumber")).clear();
		driver.findElement(By.id("SocialSecurityNumber")).sendKeys("3334" + currentTime);

	}

	@When("^Enter Insurance information$")
	public void enter_Insurance_information() throws Throwable {

		WebElement list_by_insuranceCompany = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_InsuranceCompany = new Select(list_by_insuranceCompany);

		List_by_InsuranceCompany.selectByValue("Cox Health");

		WebElement list_by_insurancePlan = driver.findElement(By.name("insurancePlanType"));
		Select List_by_InsurancePlan = new Select(list_by_insurancePlan);

		List_by_InsurancePlan.selectByValue("HSA");

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("insuranceGroupNumber")).clear();
		driver.findElement(By.id("insuranceGroupNumber")).sendKeys("1208567899" + currentTime);

		driver.findElement(By.id("insuranceMemberNumber")).clear();
		driver.findElement(By.id("insuranceMemberNumber")).sendKeys("9936567899" + currentTime);

		driver.findElement(By.id("insuranceBINNumber")).clear();
		driver.findElement(By.id("insuranceBINNumber")).sendKeys("523456" + currentTime);

		driver.findElement(By.id("insurancePCNNumber")).clear();
		driver.findElement(By.id("insurancePCNNumber")).sendKeys("523456" + currentTime);

		driver.findElement(By.name("apply-step-one-submit")).click();

	}

	@When("^Enter the doctor information$")
	public void enter_the_doctor_information() throws Throwable {

		long currentTime = System.currentTimeMillis();

		driver.findElement(By.id("doc_firstName")).clear();
		driver.findElement(By.id("doc_firstName")).sendKeys("Barnie" + currentTime);

		driver.findElement(By.id("doc_lastName")).clear();
		driver.findElement(By.id("doc_lastName")).sendKeys("Sanders" + currentTime);

		driver.findElement(By.id("doc_practiceName")).clear();
		driver.findElement(By.id("doc_practiceName")).sendKeys("Michael Horthon" + currentTime);

		driver.findElement(By.id("doc_address")).clear();
		driver.findElement(By.id("doc_address")).sendKeys("19 Preakness Ave" + currentTime);

		driver.findElement(By.id("doc_city")).sendKeys("Wayne");

		WebElement list_by_state = driver.findElement(By.name("doc_state"));
		Select List_by_State = new Select(list_by_state);

		List_by_State.selectByValue("NJ");

		driver.findElement(By.id("doc_zipCode")).clear();
		driver.findElement(By.id("doc_zipCode")).sendKeys("07524" + currentTime);

		driver.findElement(By.id("doc_phone")).clear();
		driver.findElement(By.id("doc_phone")).sendKeys("8626651222" + currentTime);

		driver.findElement(By.name("apply-step-two-submit")).click();

	}

	@Then("^I varify the Information Is Correct$")
	public void i_varify_the_Information_Is_Correct() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());

		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());

		driver.findElement(By.id("allcorrect")).click();

	}

	@Then("^clicks on confirm$")
	public void clicks_on_confirm() throws Throwable {

		driver.findElement(By.id("submit")).click();

	}

	@Then("^verify the referance is displaying$")
	public void verify_the_referance_is_displaying() throws Throwable {

		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/h1"));

		System.out.println(element.getText());

	}

	@Then("^close the site$")
	public void close_the_site() throws Throwable {

		driver.quit();

	}

}
