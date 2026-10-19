package login_mis;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MIS_Login_Page_Functional_Testing {

		WebDriver driver=new EdgeDriver();
		

//		 @Test(dataProvider="getDataTC_1")
//		 public void disp(String un, String pw)
//		 {
//			 System.out.println(un+" "+pw);
//		 }
		
		//Tc_1
		//steps: naviagte to visualivrmis.simpragma.com 
		// expected result:  should open login  page with welcome message  with email id and password textfield and login button
		@Test(priority=1)
		public  void TC_1()
		{
		
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		//2.check if email , password   text field and login btn are present with Welcome text
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement email=driver.findElement(By.id("email"));
		WebElement password=driver.findElement(By.id("password"));
		WebElement loginBtn=driver.findElement(By.tagName("button"));
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(password.isDisplayed());
		Assert.assertTrue(loginBtn.isDisplayed());
		
		}
		@Test(priority=2)
		public void BothFieldsBlank()
		{
		
		
			driver.get("http://visualivrmis.simpragma.com/");
	
			//4.check if it error text msg is displayed
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("email")).click();
			driver.findElement(By.id("password")).click();
	
				Assert.assertTrue(driver.findElement(By.xpath("(//ui-error)[1]")).getText().equals("Please enter your Email"));
			
				driver.findElement(By.id("email")).click();
				Assert.assertTrue(driver.findElement(By.xpath("(//ui-error)[2]")).getText().equals("Please enter a Password"));
			
		
		
		}
		//Tc_2----------->true
		// steps leave email id empty and enter pwd 
		@Test(priority=2)
		public void LeaveEmailEmpty()
		{
			driver.get("http://visualivrmis.simpragma.com/");
			//4.check if it error text msg is displayed
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("password")).sendKeys("Password@123");
			driver.findElement(By.tagName("button")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getText().equals("Please enter your Email"));
				
		}
		@Test(priority=2)
		public void LeavePasswordEmpty()
		{
		
		
		
			driver.get("http://visualivrmis.simpragma.com/");
			//4.check if it error text msg is displayed
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id("email")).sendKeys("naveenr@simpragam.com");
			driver.findElement(By.tagName("button")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getText().equals("Please enter a Password"));
				
		
		}
		//Tc_8:enter invalid email id and invalid password 

		@Test(priority=8,dataProvider="inValid", dataProviderClass=TestCaseData_Functional_Testing.class)
		public void Invalid(String un, String pw)
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//1.enter email id
			driver.findElement(By.id("email")).sendKeys(un);
			//2.enter password
			driver.findElement(By.id("password")).sendKeys(pw);
			driver.findElement(By.tagName("button")).click();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			///go3958317564
	System.out.println(driver.findElement(By.className("go3958317564")).getAriaRole());
		}
		
		public void logout()
		{
			driver.findElement(By.xpath("(//button)[1]")).click();
			driver.findElement(By.xpath("(//li[@class='sc-jtRlXQ crMelM'])[3]")).click();
		}
		@Test(priority=4,dataProvider="validateForEmailFieldForInvalidErrormessage", dataProviderClass=TestCaseData_Functional_Testing.class)
		public void negativeTestScenariosForvalidateForEmailFieldForInvalidErrormessage(String un, String pw)
		{
		
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			//1.enter email id
			driver.findElement(By.id("email")).sendKeys(un);
			//2.enter password
			driver.findElement(By.id("password")).sendKeys(pw);
	
			
	
			//4.check if it error text msg is displayed

		System.out.println(driver.findElement(By.tagName("ui-error")).getText().equals("Please enter a valid email"));
				Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getText().equals("Please enter a valid email"));
				
				System.out.println(driver.findElement(By.tagName("ui-error")).getText()+"---");
			
		
			driver.navigate().refresh();
		}
		
		//tc5
		//check wether email id text field place holder value is 'Email'
		@Test(priority=5)
		public void TC_5()
		{
					//clear  previous  data eneterd
					driver.navigate().refresh();
				
					Assert.assertTrue(driver.findElement(By.id("email")).getAttribute("placeholder").equals("Email"));
		}
		//tc6
		//check wether password id text field place holder value is 'Password'
		@Test(priority=6)
		public void TC6() 
		{
			//clear  previous  data eneterd
			driver.navigate().refresh();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					System.out.println(driver.findElement(By.id("password")).getAttribute("placeholder"));
				Assert.assertTrue(driver.findElement(By.id("password")).getAttribute("placeholder").equals("Password"));
		}
		
		//TC_07enter valid email id and pwd and  click on login btn
		@Test(priority=7,dataProvider="getValid", dataProviderClass=TestCaseData_Functional_Testing.class, enabled =false)
		public void Positive(String un, String pw) {
			driver.navigate().refresh();
			//1.enter email id
			driver.findElement(By.id("email")).sendKeys(un);
			//2.enter password
			driver.findElement(By.id("password")).sendKeys(pw);
			//3.click on login
			driver.findElement(By.tagName("button")).click();
			//4.check if logout option is present or not
			WebDriverWait wait = new WebDriverWait(driver,150);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sc-gqjmRU hNubjF']"))).click();
			String logoutText=driver.findElement(By.xpath("(//li[@role='menuitem'])[2]")).getText();
			//5.Verify for logout text
			Assert.assertTrue(logoutText.equalsIgnoreCase("logout"));
			//6.click on logout
			driver.findElement(By.xpath("(//li[@role='menuitem'])[2]")).click();
	
		}
		//Tc_13:once you are logged in and on dashboard page navigate back 
				//Expected result:we should be naviagting to same dashoard page 
				@Test(priority=14)
				public void Tc_14()
				{

					driver.get("http://visualivrmis.simpragma.com/");
					driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
					//1.login with valid credentials
					driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
					driver.findElement(By.id("password")).sendKeys("Password@123");
					driver.findElement(By.tagName("button")).click();
					
					
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//2.navigate back
					driver.navigate().back();
					
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//3. verify if your are on dashboard page
					Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equalsIgnoreCase("Dashboard"));
					//5.click on logout avatar
					driver.findElement(By.xpath("//span[@class='sc-gqjmRU hNubjF']")).click();
					//click on logout button
					driver.findElement(By.xpath("(//li[@role='menuitem'])[2]")).click();
				}
				
				//Tc_15:once you are logged in and on dashboard page open in new tab login page
				//expected resultshould automatically navigate to dashboard page
				@Test(priority=15)
				public void TC_15()
				{

					driver.get("http://visualivrmis.simpragma.com/");
					driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
					//1.login with valid credentials
					driver.findElement(By.id("email")).sendKeys("krishna@rao.com");
					driver.findElement(By.id("password")).sendKeys("Password@123");
					driver.findElement(By.className("btnLogin")).click();
					
					
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//2.open new tab by holding control+t keys in keyboard for chrome browser
							driver.switchTo().newWindow(WindowType.TAB);
					//3. enter url of MIS login page
							driver.get("https://visualivrmis.simpragma.com/");
							
							try {
								Thread.sleep(8000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
				@Test(priority=3,dataProvider="ValidateForPasswordField", dataProviderClass=TestCaseData_Functional_Testing.class)
			public void negativeTestScenarioForPasswordTextField(String un, String pw)
				{
					driver.get("http://visualivrmis.simpragma.com/");
					//1.enter email id
				driver.findElement(By.id("email")).sendKeys(un);
					//2.enter password
				driver.findElement(By.id("password")).sendKeys(pw);
					//3.click on login
					driver.findElement(By.tagName("button")).click();	
					//4.check if it error text msg is displayed
				System.out.println(driver.findElement(By.tagName("ui-error")).getText()+"----->Password eror msg");		
					
						Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getText().equals("Invalid Password"));
				

					driver.navigate().refresh();
			}
					
				@AfterSuite
				public void close()
				{
					driver.quit();
				}
}
