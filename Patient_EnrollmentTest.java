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

public class Patient_EnrollmentTest {

	public static WebDriver driver;

	@Given("^I open chrome browser$")
	public void i_open_chrome_browser() throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ubox0\\Desktop\\Driver(Chrome+Mozilla+ internet)\\Chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://www.copayassistancenow.com/patients");

	}

	@Given("^Type the copayassistancenow site$")
	public void type_the_copayassistancenow_site() throws Throwable {

		driver.get("https://www.copayassistancenow.com/patients");

		// driver.findElement(By.id("enlarger-size-small")).click();

	}

	@When("^I click on apply now$")
	public void i_click_on_apply_now() throws Throwable {

		driver.findElement(By.xpath(".//*[@id='container']/div[2]/a[1]")).click();

	}

	@When("^patient already enrolled in the BioOncology select NO$")
	public void patient_already_enrolled_in_the_BioOncology_select_NO() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@When("^Applying I am a patient$")
	public void applying_I_am_a_patient() throws Throwable {

		driver.findElement(By.id("opt1")).click();

	}

	@When("^Select Alecensa program$")
	public void select_Alecensa_program() throws Throwable {
		
		
		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/button")).click();
		
		List<WebElement> brandmenu =driver.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));
		
		for(int i=0;i<brandmenu.size();i++){
			
			WebElement element=brandmenu.get(i);
			
			String innerhtml = element.getAttribute("innerHTML");
			
			if(innerhtml.contentEquals("ALECENSA"))
			{
				
				
				element.click();
				break;
				
			}
			
	System.out.println("values from dropdown is ====="+ innerhtml);
			
			
			
		}
		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/ul/li[1]/a")).click();
	    
		
	}

	@When("^Press next Button$")
	public void press_next_Button() throws Throwable {

		driver.findElement(By.id("agree")).click();

	}

	@When("^Fillup the Eligibility form$")
	public void fillup_the_Eligibility_form() throws Throwable {
		
		
		driver.findElement(By.name("question-1")).click();
		
		driver.findElement(By.name("question-2")).click();
		
		driver.findElement(By.name("question-3")).click();
		
		
		driver.findElement(By.name("question-4")).click();
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[5]/td[2]/p[3]/input")).click();
		
		WebElement list_by_state = driver.findElement(By.name("state"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("NJ");
		
		
		
		driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/table/tbody/tr[7]/td[2]/p[3]/input")).click();
		
		
		driver.findElement(By.name("question-8")).click();
		
		driver.findElement(By.name("question-9")).click();
		
		
		driver.findElement(By.name("apply-step-one-submit")).click();


	}

	@Then("^I fillup the Patient information form$")
	public void i_fillup_the_Patient_information_form() throws Throwable {
		
		
		
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

	@Then("^I fillup Insurance information form & press next button$")
	public void i_fillup_Insurance_information_form_press_next_button() throws Throwable {
		
		
		
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
		
		
		driver.findElement(By.name("apply-step-one-submit")).click();

	}

	@Then("^I fillup doctor's information form & press next button$")
	public void i_fillup_doctor_s_information_form_press_next_button() throws Throwable {
		
		
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
		
		driver.findElement(By.name("apply-step-two-submit")).click();
		

	}

	@Then("^I verify the Info$")
	public void i_verify_the_Info() throws Throwable {
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());
		
		
		WebElement element2 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[3]/strong"));

		System.out.println(element2.getText());




		
		

	}

	@Then("^I click on check button All information is correct$")
	public void i_click_on_check_button_All_information_is_correct() throws Throwable {
		
	
		
		
		driver.findElement(By.xpath(".//*[@id='allcorrect']")).click();

	}

	@Then("^I click on Confirm button$")
	public void i_click_on_Confirm_button() throws Throwable {
		
		driver.findElement(By.xpath(".//*[@id='submit']")).click();

	}

	@Then("^I vrify the We Are Processing Your Request text$")
	public void i_vrify_the_We_Are_Processing_Your_Request_text() throws Throwable {
		
		
		
		

	}

	@Then("^I verify the Thank You for Enrolling text$")
	public void i_verify_the_Thank_You_for_Enrolling_text() throws Throwable {

	}

}
