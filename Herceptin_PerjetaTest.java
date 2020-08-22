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

public class Herceptin_PerjetaTest {
	
	public static WebDriver driver;
	
	@Given("^I click on apply now bUtton$")
	public void i_click_on_apply_now_bUtton() throws Throwable {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.copayassistancenow.com/patients");
		driver.findElement(By.id("enlarger-size-small")).click();

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");
		
	}

	@Given("^select patient not enrolled$")
	public void select_patient_not_enrolled() throws Throwable {

    driver.findElement(By.id("enroll-no")).click();
		
	}

	@Given("^Applying As LAP$")
	public void applying_As_LAP() throws Throwable {
		
		driver.findElement(By.id("opt2")).click();


		
		
	}

	@Given("^Select Herceptin from drop down$")
	public void select_Herceptin_from_drop_down() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/button")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("HERCEPTIN")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);
			
			

		}
		
		driver.findElement(By.xpath(".//*[@id='hide-lap']/div[1]/ul/li[6]/a")).click();

		
	}

	@Given("^Press Next$")
	public void press_Next() throws Throwable {
		
		driver.findElement(By.id("agree")).click();


		
		
	}

	@When("^I complete the eligibility QN with Perjeta$")
	public void i_complete_the_eligibility_QN_with_Perjeta() throws Throwable {
	   
		driver.findElement(By.name("question-1")).click();
		
		driver.findElement(By.name("question-2")).click();
		
		driver.findElement(By.id("more-product")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[3]/td[2]/p[26]/input")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[3]/td[2]/p[29]/input")).click();
		
		driver.findElement(By.name("question-4")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();
		
		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("NJ");
		
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();
		
		driver.findElement(By.name("question-8")).click();
		
		driver.findElement(By.name("question-9")).click();

		
	}

	@When("^Click Next buttoni$")
	public void click_Next_buttoni() throws Throwable {


		driver.findElement(By.name("apply-step-one-submit")).click();
		
		
	}

	@Then("^I fillup the Legally Authorized Persons information$")
	public void i_fillup_the_Legally_Authorized_Persons_information() throws Throwable {
		
		
		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("guardian_first_name")).clear();
		driver.findElement(By.id("guardian_first_name")).sendKeys("Cristine" + currentTime);

		driver.findElement(By.id("guardian_last_name")).clear();
		driver.findElement(By.id("guardian_last_name")).sendKeys("Angulo" + currentTime);
		
		driver.findElement(By.id("guardian_address_1")).clear();
		driver.findElement(By.id("guardian_address_1")).sendKeys("21 Clearmna Pl" + currentTime);
		
		driver.findElement(By.id("guardian_address_2")).clear();
		driver.findElement(By.id("guardian_address_2")).sendKeys("Apt 3" + currentTime);
		
		driver.findElement(By.id("guardian_city")).clear();
		driver.findElement(By.id("guardian_city")).sendKeys("Totowa" + currentTime);
		
		WebElement list_by_state = driver.findElement(By.id("guardian_state"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("FL");
		
		driver.findElement(By.id("guardian_zip")).clear();
		driver.findElement(By.id("guardian_zip")).sendKeys("87503" + currentTime);
		
		driver.findElement(By.id("guardian_phone_number")).clear();
		driver.findElement(By.id("guardian_phone_number")).sendKeys("8750343435" + currentTime);
	
		


		
	}

	@Then("^I full up the Patient information$")
	public void i_full_up_the_Patient_information() throws Throwable {


		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("first_name")).clear();
		driver.findElement(By.id("first_name")).sendKeys("Stacy" + currentTime);
		
		driver.findElement(By.id("last_name")).clear();
		driver.findElement(By.id("last_name")).sendKeys("Jones" + currentTime);
		
		WebElement list_by_gender = driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[12]/span/select"));
		Select List_by_Gender = new Select(list_by_gender);
		
		List_by_Gender.selectByValue("F");
		
		
		driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/div/span/a/span[1]")).click();
		
        driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[1]/select/option[7]")).click();
        
        
        driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/div/span/a/span[1]")).click();
		
        driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[2]/select/option[17]")).click();
        
        
        driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/div/span/a/span[1]")).click();
		
        driver.findElement(By.xpath(".//*[@id='container']/div[2]/form/p[13]/span[3]/select/option[35]")).click();
        
        driver.findElement(By.xpath(".//*[@id='same-address']")).click();
        
        
        driver.findElement(By.xpath(".//*[@id='SocialSecurityNumber']")).clear();
		driver.findElement(By.xpath(".//*[@id='SocialSecurityNumber']")).sendKeys("4321");
		

		
		
	}

	@Then("^Choose the right Insurance information$")
	public void choose_the_right_Insurance_information() throws Throwable {
		
		
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

	@Then("^Click Next$")
	public void click_Next() throws Throwable {


		driver.findElement(By.name("apply-step-one-submit")).click();
		
		
	}

	@Then("^Fill up fill in the doctors information$")
	public void fill_up_fill_in_the_doctors_information() throws Throwable {


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

	@Then("^Next butTony$")
	public void next_butTony() throws Throwable {
		
		driver.findElement(By.xpath(".//*[@id='container']/p/button")).click();
		
		
	}

	@Then("^Confirm Information$")
	public void confirm_Information() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());
		
		
		driver.findElement(By.id("allcorrect")).click();

		
		
	}

	@Then("^press Confirm$")
	public void press_Confirm() throws Throwable {

   driver.findElement(By.id("submit")).click();
		
		
	}

	@Then("^Verify the Reference number text$")
	public void verify_the_Reference_number_text() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/p[1]"));

		System.out.println(element.getText());



		
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {

   driver.quit();
		
		
	}



}
