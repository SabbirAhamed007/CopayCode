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

public class Insurance_validateTest {

	public static WebDriver driver;

	@Given("^I open Biooncology site$")
	public void i_open_Biooncology_site() throws Throwable {

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

	@Given("^select apply now button$")
	public void select_apply_now_button() throws Throwable {

		driver.get("https://www.copayassistancenow.com/enroll-attestation-patient");

	}

	@Given("^select patient not apply before$")
	public void select_patient_not_apply_before() throws Throwable {

		driver.findElement(By.id("enroll-no")).click();

	}

	@Given("^select as a Patient$")
	public void select_as_a_Patient() throws Throwable {

		driver.findElement(By.id("opt1")).click();

	}

	@Given("^select herceptin program$")
	public void select_herceptin_program() throws Throwable {

		driver.findElement(By.xpath("//span[@class='dropdown-label ng-binding' and 1]")).click();

		List<WebElement> brandmenu = driver
				.findElements(By.xpath("//div[@class='btn-group brand-selector']//ul//li/a"));

		for (int i = 0; i < brandmenu.size(); i++) {

			WebElement element = brandmenu.get(i);

			String innerhtml = element.getAttribute("innerHTML");

			if (innerhtml.contentEquals("herceptin")) {

				element.click();
				break;

			}

			System.out.println("values from dropdown is =====" + innerhtml);

		}

		driver.findElement(By.xpath(".//*[@id='hide-patient']/div[1]/ul/li[6]/a")).click();

		driver.findElement(By.id("agree")).click();

	}

	@When("^I select the eligibility qn$")
	public void i_select_the_eligibility_qn() throws Throwable {

		driver.findElement(By.name("question-1")).click();

		driver.findElement(By.name("question-2")).click();
		
		

		driver.findElement(By.name("question-3")).click();
		
		driver.findElement(By.name("question-3a2")).click();
		
		driver.findElement(By.name("question-3b2")).click();
		
		
		
		
		
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

	@When("^complete the Patient information$")
	public void complete_the_Patient_information() throws Throwable {
		
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

	@Then("^I validate the outcomes of insurance options$")
	public void i_validate_the_outcomes_of_insurance_options() throws Throwable {
		
		
		WebElement list_by_insurance = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance = new Select(list_by_insurance);

		List_by_Insurance.selectByValue("Aetna");

		WebElement list_by_plan = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan = new Select(list_by_plan);

		List_by_Plan.selectByValue("CDHP");

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
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1 = new Select(list_by_plan1);

		List_by_Plan1.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan2 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan2 = new Select(list_by_plan2);

		List_by_Plan2.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan3 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan3 = new Select(list_by_plan3);

		List_by_Plan3.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan4 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4 = new Select(list_by_plan4);

		List_by_Plan4.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan5 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan5 = new Select(list_by_plan5);

		List_by_Plan5.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6 = new Select(list_by_plan6);

		List_by_Plan6.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7 = new Select(list_by_plan7);

		List_by_Plan7.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan8 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan8 = new Select(list_by_plan8);

		List_by_Plan8.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan9 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan9 = new Select(list_by_plan9);

		List_by_Plan9.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan10 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan10 = new Select(list_by_plan10);

		List_by_Plan10.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan11 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan11 = new Select(list_by_plan11);

		List_by_Plan11.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		//2nd steps: 
		
		
		WebElement list_by_insurance1 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance1 = new Select(list_by_insurance1);

		List_by_Insurance1.selectByValue("Alliance Health");
		
		
		
		WebElement list_by_plana = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plana = new Select(list_by_plana);

		List_by_Plana.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planb = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planb = new Select(list_by_planb);

		List_by_Planb.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planc = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planc = new Select(list_by_planc);

		List_by_Planc.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_pland = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Pland = new Select(list_by_pland);

		List_by_Pland.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plane = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plane = new Select(list_by_plane);

		List_by_Plane.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planf = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planf = new Select(list_by_planf);

		List_by_Planf.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plang = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plang = new Select(list_by_plang);

		List_by_Plang.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planh = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planh = new Select(list_by_planh);

		List_by_Planh.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plani = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plani = new Select(list_by_plani);

		List_by_Plani.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planj = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planj = new Select(list_by_planj);

		List_by_Planj.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plank = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plank = new Select(list_by_plank);

		List_by_Plank.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		//3rd steps
		
		
		
		WebElement list_by_insurance20 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance20 = new Select(list_by_insurance20);

		List_by_Insurance20.selectByValue("Amerihealth");
		
		
		
		WebElement list_by_plan21 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan21 = new Select(list_by_plan21);

		List_by_Plan21.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan22 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan22 = new Select(list_by_plan22);

		List_by_Plan22.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan23 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan23 = new Select(list_by_plan23);

		List_by_Plan23.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan24 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan24 = new Select(list_by_plan24);

		List_by_Plan24.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan25 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan25 = new Select(list_by_plan25);

		List_by_Plan25.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan26 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan26 = new Select(list_by_plan26);

		List_by_Plan26.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan27 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan27 = new Select(list_by_plan27);

		List_by_Plan27.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan28 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan28 = new Select(list_by_plan28);

		List_by_Plan28.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan29 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan29 = new Select(list_by_plan29);

		List_by_Plan29.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan30 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan30 = new Select(list_by_plan30);

		List_by_Plan30.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan31 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan31 = new Select(list_by_plan31);

		List_by_Plan31.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		//4th steps
		
		
		
		WebElement list_by_insurance40 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance40 = new Select(list_by_insurance40);

		List_by_Insurance40.selectByValue("Anthem");
		
		
		
		WebElement list_by_plan41 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan41 = new Select(list_by_plan41);

		List_by_Plan41.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan42 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan42 = new Select(list_by_plan42);

		List_by_Plan42.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan43 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan43 = new Select(list_by_plan43);

		List_by_Plan43.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan44 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan44 = new Select(list_by_plan44);

		List_by_Plan44.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan45 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan45 = new Select(list_by_plan45);

		List_by_Plan45.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan46 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan46 = new Select(list_by_plan46);

		List_by_Plan46.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan47 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan47 = new Select(list_by_plan47);

		List_by_Plan47.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan48 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan48 = new Select(list_by_plan48);

		List_by_Plan48.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan49 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan49 = new Select(list_by_plan49);

		List_by_Plan49.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan50 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan50 = new Select(list_by_plan50);

		List_by_Plan50.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan51 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan51 = new Select(list_by_plan51);

		List_by_Plan51.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		//5th steps
		
		
		
		WebElement list_by_insurance60 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance60 = new Select(list_by_insurance60);

		List_by_Insurance60.selectByValue("Assurant");
		
		
		
		WebElement list_by_plan61 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan61 = new Select(list_by_plan61);

		List_by_Plan61.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan62 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan62 = new Select(list_by_plan62);

		List_by_Plan62.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan63 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan63 = new Select(list_by_plan63);

		List_by_Plan63.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan64 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan64 = new Select(list_by_plan64);

		List_by_Plan64.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan65 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan65 = new Select(list_by_plan65);

		List_by_Plan65.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan66 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan66 = new Select(list_by_plan66);

		List_by_Plan66.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan67 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan67 = new Select(list_by_plan67);

		List_by_Plan67.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan68 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan68 = new Select(list_by_plan68);

		List_by_Plan68.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan69 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan69 = new Select(list_by_plan69);

		List_by_Plan69.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan70 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan70 = new Select(list_by_plan70);

		List_by_Plan70.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan71 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan71 = new Select(list_by_plan71);

		List_by_Plan71.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		//6th steps
		
		
		
		
		WebElement list_by_insurance22 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance22 = new Select(list_by_insurance22);

		List_by_Insurance22.selectByValue("Blue Cross");
		
		
		
		WebElement list_by_plano = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plano = new Select(list_by_plano);

		List_by_Plano.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planz = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planz = new Select(list_by_planz);

		List_by_Planz.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planx = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planx = new Select(list_by_planx);

		List_by_Planx.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_planv = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planv = new Select(list_by_planv);

		List_by_Planv.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan55 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan55 = new Select(list_by_plan55);

		List_by_Plan55.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planm = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planm = new Select(list_by_planm);

		List_by_Planm.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plans = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plans = new Select(list_by_plans);

		List_by_Plans.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planq = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planq = new Select(list_by_planq);

		List_by_Planq.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planw = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planw = new Select(list_by_planw);

		List_by_Planw.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_planl = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planl = new Select(list_by_planl);

		List_by_Planl.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_planp = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Planp = new Select(list_by_planp);

		List_by_Planp.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		//7th step
		
		
		
		WebElement list_by_insurance61 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance61 = new Select(list_by_insurance61);

		List_by_Insurance61.selectByValue("Blue Shield");
		
		
		
		WebElement list_by_plan100 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan100 = new Select(list_by_plan100);

		List_by_Plan100.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan101 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan101 = new Select(list_by_plan101);

		List_by_Plan101.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan102 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan102 = new Select(list_by_plan102);

		List_by_Plan102.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan103 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan103 = new Select(list_by_plan103);

		List_by_Plan103.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan104 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan104 = new Select(list_by_plan104);

		List_by_Plan104.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan105 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan105 = new Select(list_by_plan105);

		List_by_Plan105.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan106 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan106 = new Select(list_by_plan106);

		List_by_Plan106.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan107 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan107 = new Select(list_by_plan107);

		List_by_Plan107.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan108 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan108 = new Select(list_by_plan108);

		List_by_Plan108.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan109 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan109 = new Select(list_by_plan109);

		List_by_Plan109.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan110 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan110 = new Select(list_by_plan110);

		List_by_Plan110.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		//8th Steps
		
		
		
		WebElement list_by_insurance100 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance100 = new Select(list_by_insurance100);

		List_by_Insurance100.selectByValue("BCBS");
		
		
		
		WebElement list_by_plan120 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan120 = new Select(list_by_plan120);

		List_by_Plan120.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan121 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan121 = new Select(list_by_plan121);

		List_by_Plan121.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan122 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan122 = new Select(list_by_plan122);

		List_by_Plan122.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan123 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan123 = new Select(list_by_plan123);

		List_by_Plan123.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan124 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan124 = new Select(list_by_plan124);

		List_by_Plan124.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan125 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan125 = new Select(list_by_plan125);

		List_by_Plan125.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan126 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan126 = new Select(list_by_plan126);

		List_by_Plan126.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan127 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan127 = new Select(list_by_plan127);

		List_by_Plan127.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan128 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan128 = new Select(list_by_plan128);

		List_by_Plan128.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan129 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan129 = new Select(list_by_plan129);

		List_by_Plan129.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan130 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan130 = new Select(list_by_plan130);

		List_by_Plan130.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		

		
        //9th steps
		
		
		WebElement list_by_insurance200 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance200 = new Select(list_by_insurance200);

		List_by_Insurance200.selectByValue("Cigna");
		
		
		
		WebElement list_by_plan1130 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1130 = new Select(list_by_plan1130);

		List_by_Plan1130.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan131 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan131 = new Select(list_by_plan131);

		List_by_Plan131.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan132 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan132 = new Select(list_by_plan132);

		List_by_Plan132.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan133 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan133 = new Select(list_by_plan133);

		List_by_Plan133.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan134 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan134 = new Select(list_by_plan134);

		List_by_Plan134.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan135 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan135 = new Select(list_by_plan135);

		List_by_Plan135.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan136 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan136 = new Select(list_by_plan136);

		List_by_Plan136.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan137 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan137 = new Select(list_by_plan137);

		List_by_Plan137.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan138 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan138 = new Select(list_by_plan138);

		List_by_Plan138.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan139 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan139 = new Select(list_by_plan139);

		List_by_Plan139.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan1330 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1330 = new Select(list_by_plan1330);

		List_by_Plan1330.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		//10th step
		
		
		
		WebElement list_by_insurance1200 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance1200 = new Select(list_by_insurance1200);

		List_by_Insurance1200.selectByValue("Cox Health");
		
		
		
		WebElement list_by_plan11301 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan11301 = new Select(list_by_plan11301);

		List_by_Plan11301.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1311 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1311 = new Select(list_by_plan1311);

		List_by_Plan1311.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1321 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1321 = new Select(list_by_plan1321);

		List_by_Plan1321.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1331 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1331 = new Select(list_by_plan1331);

		List_by_Plan1331.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1341 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1341 = new Select(list_by_plan1341);

		List_by_Plan1341.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1351 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1351 = new Select(list_by_plan1351);

		List_by_Plan1351.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1361 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1361 = new Select(list_by_plan1361);

		List_by_Plan1361.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1371 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1371 = new Select(list_by_plan1371);

		List_by_Plan1371.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1381 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1381 = new Select(list_by_plan1381);

		List_by_Plan1381.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1391 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1391 = new Select(list_by_plan1391);

		List_by_Plan1391.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan13301 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan13301 = new Select(list_by_plan13301);

		List_by_Plan13301.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		
		
		
		//11th step
		
		
		
		WebElement list_by_insurance400 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance400 = new Select(list_by_insurance400);

		List_by_Insurance400.selectByValue("First Choice");
		
		
		
		WebElement list_by_plan1132 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1132 = new Select(list_by_plan1132);

		List_by_Plan1132.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1312 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1312 = new Select(list_by_plan1312);

		List_by_Plan1312.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1322 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1322 = new Select(list_by_plan1322);

		List_by_Plan1322.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1332 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1332 = new Select(list_by_plan1332);

		List_by_Plan1332.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1342 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1342 = new Select(list_by_plan1342);

		List_by_Plan1342.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1352 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1352 = new Select(list_by_plan1352);

		List_by_Plan1352.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1362 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1362 = new Select(list_by_plan1362);

		List_by_Plan1362.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1372 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1372 = new Select(list_by_plan1372);

		List_by_Plan1372.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1382 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1382 = new Select(list_by_plan1382);

		List_by_Plan1382.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1392 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1392 = new Select(list_by_plan1392);

		List_by_Plan1392.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan230 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan230 = new Select(list_by_plan230);

		List_by_Plan230.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		// 12th steps
		
		
		
		
		
		
		WebElement list_by_insurance1001 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance1001 = new Select(list_by_insurance1001);

		List_by_Insurance1001.selectByValue("Geisinger");
		
		
		
		WebElement list_by_plan1203 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1203 = new Select(list_by_plan1203);

		List_by_Plan1203.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1233 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1233 = new Select(list_by_plan1233);

		List_by_Plan1233.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan12333 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan12333 = new Select(list_by_plan12333);

		List_by_Plan12333.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1234 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1234 = new Select(list_by_plan1234);

		List_by_Plan1234.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1244 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1244 = new Select(list_by_plan1244);

		List_by_Plan1244.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1254 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1254 = new Select(list_by_plan1254);

		List_by_Plan1254.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1264 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1264 = new Select(list_by_plan1264);

		List_by_Plan1264.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1274 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1274 = new Select(list_by_plan1274);

		List_by_Plan1274.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1284 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1284 = new Select(list_by_plan1284);

		List_by_Plan1284.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1294 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1294 = new Select(list_by_plan1294);

		List_by_Plan1294.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan1304 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1304 = new Select(list_by_plan1304);

		List_by_Plan1304.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		

		

       //13th steps		
		
		
		
		
		WebElement list_by_insurance2500 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance2500 = new Select(list_by_insurance2500);

		List_by_Insurance2500.selectByValue("Harvard Pilgrim");
		
		
		
		WebElement list_by_plan301 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan301 = new Select(list_by_plan301);

		List_by_Plan301.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1316 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1316 = new Select(list_by_plan1316);

		List_by_Plan1316.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1326 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1326 = new Select(list_by_plan1326);

		List_by_Plan1326.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1336 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1336 = new Select(list_by_plan1336);

		List_by_Plan1336.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1346 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1346 = new Select(list_by_plan1346);

		List_by_Plan1346.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1356 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1356 = new Select(list_by_plan1356);

		List_by_Plan1356.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1366 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1366 = new Select(list_by_plan1366);

		List_by_Plan1366.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1376 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1376 = new Select(list_by_plan1376);

		List_by_Plan1376.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1386 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1386 = new Select(list_by_plan1386);

		List_by_Plan1386.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1396 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1396 = new Select(list_by_plan1396);

		List_by_Plan1396.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan1230 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1230 = new Select(list_by_plan1230);

		List_by_Plan1230.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		




        //14th steps
		
		
		
		
		
		
		WebElement list_by_insurance600 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance600 = new Select(list_by_insurance600);

		List_by_Insurance600.selectByValue("Healthnet");
		
		
		
		WebElement list_by_plan11307 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan11307 = new Select(list_by_plan11307);

		List_by_Plan11307.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1317 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1317 = new Select(list_by_plan1317);

		List_by_Plan1317.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1327 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1327 = new Select(list_by_plan1327);

		List_by_Plan1327.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1337 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1337 = new Select(list_by_plan1337);

		List_by_Plan1337.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan1347 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1347 = new Select(list_by_plan1347);

		List_by_Plan1347.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1357 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1357 = new Select(list_by_plan1357);

		List_by_Plan1357.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1367 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1367 = new Select(list_by_plan1367);

		List_by_Plan1367.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1377 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1377 = new Select(list_by_plan1377);

		List_by_Plan1377.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1387 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1387 = new Select(list_by_plan1387);

		List_by_Plan1387.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan1397 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1397 = new Select(list_by_plan1397);

		List_by_Plan1397.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan1340 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan1340 = new Select(list_by_plan1340);

		List_by_Plan1340.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		
		
		
		//15th step
		
		
		
		
		WebElement list_by_insurance601 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance601 = new Select(list_by_insurance601);

		List_by_Insurance601.selectByValue("Humana");
		
		
		
		WebElement list_by_plan611 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan611 = new Select(list_by_plan611);

		List_by_Plan611.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan621 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan621 = new Select(list_by_plan621);

		List_by_Plan621.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan631 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan631 = new Select(list_by_plan631);

		List_by_Plan631.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan641 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan641 = new Select(list_by_plan641);

		List_by_Plan641.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan651 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan651 = new Select(list_by_plan651);

		List_by_Plan651.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan661 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan661 = new Select(list_by_plan661);

		List_by_Plan661.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan671 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan671 = new Select(list_by_plan671);

		List_by_Plan671.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan681 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan681 = new Select(list_by_plan681);

		List_by_Plan681.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan691 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan691 = new Select(list_by_plan691);

		List_by_Plan691.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan701 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan701 = new Select(list_by_plan701);

		List_by_Plan701.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan711 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan711 = new Select(list_by_plan711);

		List_by_Plan711.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		
		//16th steps

		
		
		
		
		WebElement list_by_insurance602 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance602 = new Select(list_by_insurance602);

		List_by_Insurance602.selectByValue("Kaiser");
		
		
		
		WebElement list_by_plan6112 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6112 = new Select(list_by_plan6112);

		List_by_Plan6112.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6212 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6212 = new Select(list_by_plan6212);

		List_by_Plan6212.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6312 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6312 = new Select(list_by_plan6312);

		List_by_Plan6312.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6412 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6412 = new Select(list_by_plan6412);

		List_by_Plan6412.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6512 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6512 = new Select(list_by_plan6512);

		List_by_Plan6512.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6612 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6612 = new Select(list_by_plan6612);

		List_by_Plan6612.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6712 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6712 = new Select(list_by_plan6712);

		List_by_Plan6712.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6812 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6812 = new Select(list_by_plan6812);

		List_by_Plan6812.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6912 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6912 = new Select(list_by_plan6912);

		List_by_Plan6912.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7012 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7012 = new Select(list_by_plan7012);

		List_by_Plan7012.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan7112 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7112 = new Select(list_by_plan7112);

		List_by_Plan7112.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();




		
       //17th steps		
		
		
		
		
		
		
		WebElement list_by_insurance603 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance603 = new Select(list_by_insurance603);

		List_by_Insurance603.selectByValue("Medco");
		
		
		
		WebElement list_by_plan612 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan612 = new Select(list_by_plan612);

		List_by_Plan612.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan622 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan622 = new Select(list_by_plan622);

		List_by_Plan622.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan632 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan632 = new Select(list_by_plan632);

		List_by_Plan632.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan642 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan642 = new Select(list_by_plan642);

		List_by_Plan642.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan652 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan652 = new Select(list_by_plan652);

		List_by_Plan652.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan662 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan662 = new Select(list_by_plan662);

		List_by_Plan662.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan672 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan672 = new Select(list_by_plan672);

		List_by_Plan672.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan682 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan682 = new Select(list_by_plan682);

		List_by_Plan682.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan692 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan692 = new Select(list_by_plan692);

		List_by_Plan692.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan702 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan702 = new Select(list_by_plan702);

		List_by_Plan702.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan712 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan712 = new Select(list_by_plan712);

		List_by_Plan712.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();


		
		
		//18th step
		
		
		
		
		
		WebElement list_by_insurance703 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance703 = new Select(list_by_insurance703);

		List_by_Insurance703.selectByValue("Medica");
		
		
		
		WebElement list_by_plan6121 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6121 = new Select(list_by_plan6121);

		List_by_Plan6121.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6221 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6221 = new Select(list_by_plan6221);

		List_by_Plan6221.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6321 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6321 = new Select(list_by_plan6321);

		List_by_Plan6321.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6421 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6421 = new Select(list_by_plan6421);

		List_by_Plan6421.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6521 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6521 = new Select(list_by_plan6521);

		List_by_Plan6521.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6621 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6621 = new Select(list_by_plan6621);

		List_by_Plan6621.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6721 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6721 = new Select(list_by_plan6721);

		List_by_Plan6721.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6821 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6821 = new Select(list_by_plan6821);

		List_by_Plan6821.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6921 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6921 = new Select(list_by_plan6921);

		List_by_Plan6921.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7021 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7021 = new Select(list_by_plan7021);

		List_by_Plan7021.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan7121 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7121 = new Select(list_by_plan7121);

		List_by_Plan7121.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();


		
		//19th steps
	
		
		
		
		WebElement list_by_insurance607 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance607 = new Select(list_by_insurance607);

		List_by_Insurance607.selectByValue("Medical Mutual");
		
		
		
		WebElement list_by_plan614 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan614 = new Select(list_by_plan614);

		List_by_Plan614.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan624 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan624 = new Select(list_by_plan624);

		List_by_Plan624.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan634 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan634 = new Select(list_by_plan634);

		List_by_Plan634.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan644 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan644 = new Select(list_by_plan644);

		List_by_Plan644.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan654 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan654 = new Select(list_by_plan654);

		List_by_Plan654.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan664 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan664 = new Select(list_by_plan664);

		List_by_Plan664.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan674 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan674 = new Select(list_by_plan674);

		List_by_Plan674.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan684 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan684 = new Select(list_by_plan684);

		List_by_Plan684.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan694 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan694 = new Select(list_by_plan694);

		List_by_Plan694.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan704 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan704 = new Select(list_by_plan704);

		List_by_Plan704.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan714 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan714 = new Select(list_by_plan714);

		List_by_Plan714.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		

		
		
		
		
		//20th steps
		
		
		
		
		WebElement list_by_insurance6073 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance6073 = new Select(list_by_insurance6073);

		List_by_Insurance6073.selectByValue("Optima");
		
		
		
		WebElement list_by_plan6143 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6143 = new Select(list_by_plan6143);

		List_by_Plan6143.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6243 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6243 = new Select(list_by_plan6243);

		List_by_Plan6243.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6343 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6343 = new Select(list_by_plan6343);

		List_by_Plan6343.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6443 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6443 = new Select(list_by_plan6443);

		List_by_Plan6443.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6543 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6543 = new Select(list_by_plan6543);

		List_by_Plan6543.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6643 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6643 = new Select(list_by_plan6643);

		List_by_Plan6643.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6743 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6743 = new Select(list_by_plan6743);

		List_by_Plan6743.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6843 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6843 = new Select(list_by_plan6843);

		List_by_Plan6843.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6943 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6943 = new Select(list_by_plan6943);

		List_by_Plan6943.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7043 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7043 = new Select(list_by_plan7043);

		List_by_Plan7043.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan7143 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7143 = new Select(list_by_plan7143);

		List_by_Plan7143.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		
		//21th steps
		
		
		
		
		WebElement list_by_insurance6074 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance6074 = new Select(list_by_insurance6074);

		List_by_Insurance6074.selectByValue("Preferred One");
		
		
		
		WebElement list_by_plan6144 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6144 = new Select(list_by_plan6144);

		List_by_Plan6144.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6244 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6244 = new Select(list_by_plan6244);

		List_by_Plan6244.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6344 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6344 = new Select(list_by_plan6344);

		List_by_Plan6344.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6444 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6444 = new Select(list_by_plan6444);

		List_by_Plan6444.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6544 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6544 = new Select(list_by_plan6544);

		List_by_Plan6544.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6644 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6644 = new Select(list_by_plan6644);

		List_by_Plan6644.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6744 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6744 = new Select(list_by_plan6744);

		List_by_Plan6744.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6844 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6844 = new Select(list_by_plan6844);

		List_by_Plan6844.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6944 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6944 = new Select(list_by_plan6944);

		List_by_Plan6944.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7044 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7044 = new Select(list_by_plan7044);

		List_by_Plan7044.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan7144 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7144 = new Select(list_by_plan7144);

		List_by_Plan7144.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		
		
		 
         //22nd steps
		
		
		

		WebElement list_by_insurance6075 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance6075 = new Select(list_by_insurance6075);

		List_by_Insurance6075.selectByValue("Providence");
		
		
		
		WebElement list_by_plan6145 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6145 = new Select(list_by_plan6145);

		List_by_Plan6145.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6245 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6245 = new Select(list_by_plan6245);

		List_by_Plan6245.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6345 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6345 = new Select(list_by_plan6345);

		List_by_Plan6345.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6445 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6445 = new Select(list_by_plan6445);

		List_by_Plan6445.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan6545 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6545 = new Select(list_by_plan6545);

		List_by_Plan6545.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6645 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6645 = new Select(list_by_plan6645);

		List_by_Plan6645.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6745 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6745 = new Select(list_by_plan6745);

		List_by_Plan6745.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6845 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6845 = new Select(list_by_plan6845);

		List_by_Plan6845.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan6945 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan6945 = new Select(list_by_plan6945);

		List_by_Plan6945.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan7045 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7045 = new Select(list_by_plan7045);

		List_by_Plan7045.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan7145 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan7145 = new Select(list_by_plan7145);

		List_by_Plan7145.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		
		
		//23th steps
		
		
		
		WebElement list_by_insurance60715 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance60715 = new Select(list_by_insurance60715);

		List_by_Insurance60715.selectByValue("Select Health");
		
		
		
		WebElement list_by_plan61451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan61451 = new Select(list_by_plan61451);

		List_by_Plan61451.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan62451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan62451 = new Select(list_by_plan62451);

		List_by_Plan62451.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan63451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan63451 = new Select(list_by_plan63451);

		List_by_Plan63451.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan64451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan64451 = new Select(list_by_plan64451);

		List_by_Plan64451.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan65451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan65451 = new Select(list_by_plan65451);

		List_by_Plan65451.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan66451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan66451 = new Select(list_by_plan66451);

		List_by_Plan66451.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan67451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan67451 = new Select(list_by_plan67451);

		List_by_Plan67451.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan68451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan68451 = new Select(list_by_plan68451);

		List_by_Plan68451.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan69451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan69451 = new Select(list_by_plan69451);

		List_by_Plan69451.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan70451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan70451 = new Select(list_by_plan70451);

		List_by_Plan70451.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan71451 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan71451 = new Select(list_by_plan71451);

		List_by_Plan71451.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();


       
		
		
		
		//24th steps


		WebElement list_by_insurance60731 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance60731 = new Select(list_by_insurance60731);

		List_by_Insurance60731.selectByValue("United Healthcare");
		
		
		
		WebElement list_by_plan61431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan61431 = new Select(list_by_plan61431);

		List_by_Plan61431.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan62431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan62431 = new Select(list_by_plan62431);

		List_by_Plan62431.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan63431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan63431 = new Select(list_by_plan63431);

		List_by_Plan63431.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan64431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan64431 = new Select(list_by_plan64431);

		List_by_Plan64431.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan65431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan65431 = new Select(list_by_plan65431);

		List_by_Plan65431.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan66431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan66431 = new Select(list_by_plan66431);

		List_by_Plan66431.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan67431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan67431 = new Select(list_by_plan67431);

		List_by_Plan67431.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan68431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan68431 = new Select(list_by_plan68431);

		List_by_Plan68431.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan69431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan69431 = new Select(list_by_plan69431);

		List_by_Plan69431.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan70431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan70431 = new Select(list_by_plan70431);

		List_by_Plan70431.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan71431 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan71431 = new Select(list_by_plan71431);

		List_by_Plan71431.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		
		//25th steps
		
		
		
		
		WebElement list_by_insurance403 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance403 = new Select(list_by_insurance403);

		List_by_Insurance403.selectByValue("United Medical Resources");
		
		
		
		WebElement list_by_plan413 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan413 = new Select(list_by_plan413);

		List_by_Plan413.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan423 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan423 = new Select(list_by_plan423);

		List_by_Plan423.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan433 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan433 = new Select(list_by_plan433);

		List_by_Plan433.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan443 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan443 = new Select(list_by_plan443);

		List_by_Plan443.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan453 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan453 = new Select(list_by_plan453);

		List_by_Plan453.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan463 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan463 = new Select(list_by_plan463);

		List_by_Plan463.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan473 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan473 = new Select(list_by_plan473);

		List_by_Plan473.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan483 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan483 = new Select(list_by_plan483);

		List_by_Plan483.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan493 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan493 = new Select(list_by_plan493);

		List_by_Plan493.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan503 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan503 = new Select(list_by_plan503);

		List_by_Plan503.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan513 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan513 = new Select(list_by_plan513);

		List_by_Plan513.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		
		
		//26th step
		
		
		
		
		
		
		WebElement list_by_insurance4013 = driver.findElement(By.name("insuranceCompanyName"));
		Select List_by_Insurance4013 = new Select(list_by_insurance4013);

		List_by_Insurance4013.selectByValue("Other");
		
		
		
		driver.findElement(By.id("insuranceCompanyOther")).clear();
		driver.findElement(By.id("insuranceCompanyOther")).sendKeys("Health choose" + currentTime);

		
		
		WebElement list_by_plan4134 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4134 = new Select(list_by_plan4134);

		List_by_Plan4134.selectByValue("EPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4234 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4234 = new Select(list_by_plan4234);

		List_by_Plan4234.selectByValue("FFS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4334 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4334 = new Select(list_by_plan4334);

		List_by_Plan4334.selectByValue("HDHP");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan4434 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4434 = new Select(list_by_plan4434);

		List_by_Plan4434.selectByValue("HMO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		WebElement list_by_plan4534 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4534 = new Select(list_by_plan4534);

		List_by_Plan4534.selectByValue("HRA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4634 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4634 = new Select(list_by_plan4634);

		List_by_Plan4634.selectByValue("HSA");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4734 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4734 = new Select(list_by_plan4734);

		List_by_Plan4734.selectByValue("Indemnity");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4834 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4834 = new Select(list_by_plan4834);

		List_by_Plan4834.selectByValue("POS");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan4934 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan4934 = new Select(list_by_plan4934);

		List_by_Plan4934.selectByValue("PPO");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();
		
		
		
		WebElement list_by_plan5034 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan5034 = new Select(list_by_plan5034);

		List_by_Plan5034.selectByValue("Union");
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		
		driver.navigate().back();

		
		
		WebElement list_by_plan5134 = driver.findElement(By.name("insurancePlanType"));
		Select List_by_Plan5134 = new Select(list_by_plan5134);

		List_by_Plan5134.selectByValue("Other");
		
		
		driver.findElement(By.id("insurancePlanOther")).clear();
		driver.findElement(By.id("insurancePlanOther")).sendKeys("Gold 2" + currentTime);
		
		
        driver.findElement(By.name("apply-step-one-submit")).click();
		




		

	}

	@Then("^complete the doctor information$")
	public void complete_the_doctor_information() throws Throwable {
		
		
		
		long currentTime = System.currentTimeMillis();
		driver.findElement(By.id("doc_firstName")).clear();
		driver.findElement(By.id("doc_firstName")).sendKeys("Elvin" + currentTime);
		
		driver.findElement(By.id("doc_lastName")).clear();
		driver.findElement(By.id("doc_lastName")).sendKeys("White" + currentTime);
		
		driver.findElement(By.id("doc_practiceName")).clear();
		driver.findElement(By.id("doc_practiceName")).sendKeys("Medela Hudson" + currentTime);
		
		driver.findElement(By.id("doc_address")).clear();
		driver.findElement(By.id("doc_address")).sendKeys("5 Neveda Ave" + currentTime);
		
		driver.findElement(By.id("doc_address2")).clear();
		driver.findElement(By.id("doc_address2")).sendKeys("2nd Fl" + currentTime);
		
		driver.findElement(By.id("doc_city")).clear();
		driver.findElement(By.id("doc_city")).sendKeys("Tumpa" + currentTime);
		
		
		WebElement list_by_state = driver.findElement(By.xpath(".//*[@id='container']/div[1]/form/p[15]/span/select"));
		Select List_by_State = new Select(list_by_state);
		
		List_by_State.selectByValue("IL");
		
		driver.findElement(By.id("doc_zipCode")).clear();
		driver.findElement(By.id("doc_zipCode")).sendKeys("06434");
		
		driver.findElement(By.id("doc_phone")).clear();
		driver.findElement(By.id("doc_phone")).sendKeys("9732452121");
		
		
		
		driver.findElement(By.name("apply-step-two-submit")).click();
		
		

	}

	@Then("^Verify all the information$")
	public void verify_all_the_information() throws Throwable {
		
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[1]"));

		System.out.println(element.getText());
		
		
		WebElement element1 = driver.findElement(By.xpath(".//*[@id='container']/form/div/h2[2]"));

		System.out.println(element1.getText());
		
		
		driver.findElement(By.id("allcorrect")).click();



	}

	@Then("^confirm it for enrollment$")
	public void confirm_it_for_enrollment() throws Throwable {
		
		
		driver.findElement(By.id("submit")).click();
		
		
		driver.quit();

	}

}
