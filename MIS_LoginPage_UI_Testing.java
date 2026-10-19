package login_mis;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

class MIS_LoginPage_UI_Testing {

	static WebDriver driver=new EdgeDriver();
	
	Point point ;
//	//Tc_60 when refresh page checkif welcome back msg is present  and plese wait message with no login button,and email, pasword text fields
//	@Test(priority=60)
//	public  void TC_60()
//	{
//		//1. navigate to page
//		driver.get("http://visualivrmis.simpragma.com/");
//				
//		//2. refresh the page
//		driver.navigate().refresh();
//		
//		//3. verify welcome back message is present  
//		Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equals("Welcome Back!"));
//		
//	   //4. verify wether Please Wait... message is present 
//		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().equals("Please Wait ..."));
//		
//	
//	}
	//TC_61 
	//TC_2 check when refresh the page in  welcome window email id,paswword text fields and login button 
	//is dispalyed after 3 sec
	@Test(priority=2)
	public  void TC_2()
	{


		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(By.id("email")).isDisplayed());
		//after 3 secs
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed());
	}
	
	//TC_03 Check that login box placed  left side of the page
	@Test(priority=3)
	public  void TC_3()
	{

		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				WebElement loginBox=driver.findElement(By.xpath("//div[@class='loginBox']"));
				WebDriverWait wait=new WebDriverWait(driver,4);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						point=loginBox.getLocation();
			
				int xcord = point.getX();
				System.out.println("Position of the webelement from left side is "+xcord +" pixels");
				int ycord = point.getY();
				System.out.println("Position of the webelement from top side is "+ycord +" pixels");
	}
	//Check the size of the login 
	//box
	@Test(priority=4)
	public void checkSizeOfLoginBox()
	{

		Dimension loginBoxsize=driver.findElement(By.xpath("//div[@class='loginBox']")).getSize();
		System.out.println("SizeOfLoginBox   "+loginBoxsize);
	}
	
	//Check the backgroundColorOfLoginBox
	//box
	@Test(priority=5)
	public void backgroundColorOfLoginBox()
	{

		String loginBoxBgColor=driver.findElement(By.xpath("//div[@class='loginBox']")).getCssValue("background-color").toString();
		System.out.println("loginBoxBgColor   "+loginBoxBgColor);
		Assert.assertTrue(loginBoxBgColor.equals("rgba(255, 255, 255, 1)"));
	}
	//Check the size of the login 
	//form

	@Test(priority=6)
	public void checkSizeOfLoginForm()
	{

		Dimension loginfFormSize=driver.findElement(By.xpath("//form[@class='loginForm']")).getSize();
		System.out.println("SizeOfLoginBox   "+loginfFormSize);
		
	}
	//Check the size of the 
	//loginContainer (Screen size)
	
	@Test(priority=7)
	public void checkSizeOfScreen()
	{

		Dimension SizeOfScreen=driver.findElement(By.xpath("//div[@class='loginContainer']")).getSize();
		System.out.println("SizeOfScreen   "+SizeOfScreen);
	}
	//check the size of the login left column
	@Test(priority=8)
	public void checkSizeOfLoginLeftCol()
	{

		Dimension SizeOfLoginLeftCol=driver.findElement(By.xpath("//div[@class='loginLeftColumn']")).getSize();
		System.out.println("SizeOfLoginLeftCol   "+SizeOfLoginLeftCol);
	
	}
	
	//check that background colour of the login left column
	@Test(priority=9)
	public void backgroundColorOfLoginLeftCol()
	{

		String  backgroundColorOfLoginLeftCol=driver.findElement(By.xpath("//div[@class='loginLeftColumn']")).getCssValue("background-color").toString();
		System.out.println("backgroundColorOfLoginLeftCol   "+backgroundColorOfLoginLeftCol);
		Assert.assertTrue(backgroundColorOfLoginLeftCol.toString().equals("rgba(255, 255, 255, 1)"));
	}
	
	//Check the heading of the 
	//login box 
	@Test(priority=10)
	public void headingOfLoginBox()
	{
	Assert.assertTrue(driver.findElement(By.tagName("h4")).getText().equals("Welcome Back!"));
	}
	
	
	//TC_11 Check the font size and font type of the heading
	@Test(priority=11)
	public  void TC_11()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fsize = driver.findElement(By.tagName("h4")).getCssValue("font-size").toString();
		System.out.println(fsize);
		Assert.assertTrue(fsize.contains("23"));
		String ftype = driver.findElement(By.tagName("h4")).getCssValue("font-family").toString();
		System.out.println(ftype);
		Assert.assertTrue(ftype.contains("Nunito"));
	}

	//Check the colour of the 
	//heading 
	@Test(priority=12)
	public void  colourOfHeading()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		System.out.println("colour of the heading " + driver.findElement(By.tagName("h4")).getCssValue("color").toString());
		
		Assert.assertFalse(driver.findElement(By.tagName("h4")).getCssValue("font-color").equals("rgba(52, 52, 52, 1)"));
		
	}
	//check that alignment of the text

	
	@Test(priority=13)
	public
	void  alignmentOfText()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		System.out.println("alignmentOfText" + driver.findElement(By.tagName("body")).getCssValue("text-align").toString());
		
		Assert.assertTrue(driver.findElement(By.tagName("body")).getCssValue("text-align").toString().equals("start"));
		
	}
	
	//check that name of the paragraph Please enter your credentials to login!  should be displayed
	@Test(priority=14)
	public void  textInParagraphTag()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("textInParagraphTag " + driver.findElement(By.tagName("p")).getText());
		Assert.assertTrue(driver.findElement(By.tagName("p")).getText().equals("Please enter your credentials to login!"));
		
	}
	//check that font size and font type of the paragraph
	
	@Test(priority=15)
	public void fontSizeAndFontStyleOfParagraphTag()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("textInParagraphTag " + driver.findElement(By.tagName("p")).getCssValue("font-size").toString());
		System.out.println("textInParagraphTag " + driver.findElement(By.tagName("p")).getCssValue("font-family").toString());
		
		Assert.assertTrue(driver.findElement(By.tagName("p")).getCssValue("font-size").toString().equals("13px"));
		Assert.assertTrue(driver.findElement(By.tagName("p")).getCssValue("font-family").toString().equals("Nunito"));
	}
	//check that colour of the paragraph
	@Test(priority=16)
	public void fontColorOfParagraphTagText()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fontColorOfParagraphTag " + driver.findElement(By.tagName("p")).getCssValue("color").toString());
	
		Assert.assertTrue(driver.findElement(By.tagName("p")).getCssValue("color").toString().equals("rgba(52, 52, 52, 1)"));
	
	}
	//check that size of the email text box
	@Test(priority=19)
	public void sizeOfEmailTextBox()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sizeOfEmailTesBox " + driver.findElement(By.id("email")).getSize().toString());
	
		Assert.assertTrue(driver.findElement(By.id("email")).getSize().toString().equals("(342, 30)"));
	
	}
	//check that font size and font type of the email text box
	
	@Test(priority=20)
	public void fontSizeAndFontStyleOfEmailTextBox()
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("sizeOfEmailTesBox " + driver.findElement(By.id("email")).getCssValue("font-size").toString());
		System.out.println("sizeOfEmailTesBox " + driver.findElement(By.id("email")).getCssValue("font-family").toString());
		Assert.assertTrue(driver.findElement(By.id("email")).getCssValue("font-size").toString().equals("13px"));
		Assert.assertTrue(driver.findElement(By.id("email")).getCssValue("font-family").toString().equals("Nunito"));
		
	}
	//check that writable text in email text box is displayed black colour or not
	
	@Test(priority=21)
	public void writable_text_in_email_text_box_is_displayed_black_colour_or_not()
	{
		//1. navigate to page
				driver.get("http://visualivrmis.simpragma.com/");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
				System.out.println(driver.findElement(By.id("email")).getCssValue("color"));
				Assert.assertTrue(driver.findElement(By.id("email")).getCssValue("color").toString().equals("rgba(0, 0, 0, 1)"));
	}
	//check that email text field is taking the input or not
	@Test(priority=22)
	public void email_text_box_is_enabled_or_not()
	{
		//1. navigate to page
				driver.get("http://visualivrmis.simpragma.com/");
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Assert.assertTrue(driver.findElement(By.id("email")).isEnabled());
	}
	//check if written text is errasable or not in email text box
	@Test(priority=23)
	public void text_in_email_text_box_is_erasable_or_not() throws InterruptedException
	{
		//1. navigate to page
		driver.get("http://visualivrmis.simpragma.com/");
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
		WebElement email=driver.findElement(By.id("email"));
		System.out.println(email.getAttribute("value"));
		//System.out.println("Enterd data in password textfield is: "+enterdText );
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.moveToElement(email).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
		//pwd.clear();
	
		System.out.println(email.getAttribute("value").toString());
		if(email.getAttribute("value").equals(""))
		{
			Assert.assertTrue(true);
		}
	}
	//check the color of the emailerror message
	@Test(priority=25)
		public void validateForEmailFieldForErrormessageColor()
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
			driver.findElement(By.id("email")).sendKeys("<script>@123.com");
			//2.enter password
			driver.findElement(By.id("password")).sendKeys("Password@123");
	
			
	
			//4.check if it error text msg is displayed

			Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("color").equals("rgba(255, 0, 0, 1)"));

	}
	
	//check the font size and font type of the email error message
	@Test(priority=26)
	public void validateFontSizeAndFontStyleForEmailFieldForErrormessage()
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
		driver.findElement(By.id("email")).sendKeys("<script>@123.com");
		//2.enter password
		driver.findElement(By.id("password")).sendKeys("Password@123");

		

		//4.check if it error text msg is displayed
		System.out.println(driver.findElement(By.tagName("ui-error")).getCssValue("font-size"));
		System.out.println(driver.findElement(By.tagName("ui-error")).getCssValue("font-family"));
		Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("font-size").equals("12px"));
		Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("font-family").equals("Nunito"));

	}
	//check that size of the pasword text box
		@Test(priority=28)
		public void sizeOfPasswordTextBox()
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sizeOfPsswordTextBox " + driver.findElement(By.id("password")).getSize().toString());
		
			Assert.assertTrue(driver.findElement(By.id("password")).getSize().toString().equals("(342, 30)"));
		
		}
		
		//check that password text field is taking the input or not
		@Test(priority=30)
		public void password_text_box_is_enabled_or_not()
		{
			//1. navigate to page
					driver.get("http://visualivrmis.simpragma.com/");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Assert.assertTrue(driver.findElement(By.id("password")).isEnabled());
		}
		
		//check that written text is errasable or not in password text field
		@Test(priority=31)
		public void text_in_password_text_box_is_erasable_or_not() throws InterruptedException
		{
			//1. navigate to page
					driver.get("http://visualivrmis.simpragma.com/");
					try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					driver.findElement(By.id("password")).sendKeys("Password@123");
					WebElement pwd=driver.findElement(By.id("password"));
					System.out.println(pwd.getAttribute("value"));
					//System.out.println("Enterd data in password textfield is: "+enterdText );
					Thread.sleep(2000);
					Actions a=new Actions(driver);
					a.moveToElement(pwd).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
					//pwd.clear();
				
					System.out.println(pwd.getAttribute("value").toString());
				if(pwd.getAttribute("value").equals(""))
				{
					Assert.assertTrue(true);
				}
		}
		
		//check that font size and font type of the password text box
		@Test(priority=32)
		public void fontSizeAndFontStyleOfPasswordTextBox()
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("sizeOfPassewordTextBox " + driver.findElement(By.id("password")).getCssValue("font-size").toString());
			System.out.println("sizeOfPassewordTextBox " + driver.findElement(By.id("password")).getCssValue("font-family").toString());
			Assert.assertTrue(driver.findElement(By.id("email")).getCssValue("font-size").toString().equals("13px"));
			Assert.assertTrue(driver.findElement(By.id("email")).getCssValue("font-family").toString().equals("Nunito"));
			
		}
		
		//check that writable text in password text box is displayed block colour or not
		@Test(priority=33)
		public void writable_text_in_passsword_text_box_is_displayed_black_colour_or_not()
		{
			//1. navigate to page
					driver.get("http://visualivrmis.simpragma.com/");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					driver.findElement(By.id("password")).sendKeys("Password@123");
					System.out.println(driver.findElement(By.id("password")).getCssValue("color"));
					Assert.assertTrue(driver.findElement(By.id("password")).getCssValue("color").toString().equals("rgba(0, 0, 0, 1)"));
		}
		
		//check the colour of the password error message
		@Test(priority=38)
		public void validateForPasswordFieldForErrormessageColor()
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
			driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
			
			//3.click on login
			driver.findElement(By.tagName("button")).click();
			
	
			//4.check if it error text msg is displayed

			Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("color").equals("rgba(255, 0, 0, 1)"));

	}
		//check the font size and font type of the password error message
		@Test(priority=39)
		public void validateFontSizeAndFontStyleForPasswordFieldForErrormessage()
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
			driver.findElement(By.id("email")).sendKeys("naveenr@simpragma.com");
			
			//3.click on login
			driver.findElement(By.tagName("button")).click();
			
			

			//4.check if it error text msg is displayed
			System.out.println(driver.findElement(By.tagName("ui-error")).getCssValue("font-size"));
			System.out.println(driver.findElement(By.tagName("ui-error")).getCssValue("font-family"));
			Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("font-size").equals("12px"));
			Assert.assertTrue(driver.findElement(By.tagName("ui-error")).getCssValue("font-family").equals("Nunito"));

		}
		
		//check that button name is Login or not
		@Test(priority=43)
		public void check_that_button_name_is_Login_or_not()
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(driver.findElement(By.tagName("button")).getText().equalsIgnoreCase("login"));
		}
		
		
		//check that margin of the login button
		@Test(priority=44)
		public void check_that_margin_of_the_login_button()
		{
								/*button, input, optgroup, select, textarea {
					    font-family: inherit;
					    font-size: inherit;
					    line-height: inherit;
					    margin: 0;
					    margin-top: 0px;
					    margin-right: 0px;
					    margin-bottom: 0px;
					    margin-left: 0px;
					}*/
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("margin"));
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("margin-top"));
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("margin-right"));
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("margin-bottom"));
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("margin-left"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("margin").toString().equals("0px"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("margin-top").toString().equals("0px"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("margin-right").toString().equals("0px"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("margin-bottom").toString().equals("0px"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("margin-left").toString().equals("0px"));
		}
		
		//check the size of the login button
		@Test(priority=45)
		public void check_the_size_of_the_login_button()
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.tagName("button")).getSize().toString());
			Assert.assertTrue(driver.findElement(By.tagName("button")).getSize().toString().equals("(56, 44)"));
		}
		
		//check the colour of the login button
		@Test(priority=46)
		public void check_the_color_of_the_login_button()
		{
			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("color").toString());
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("color").toString().equals("rgba(52, 52, 52, 1)"));
		}
		
		//check that alignment of the login button
		@Test(priority=47)
		public void check_the_alignment_of_the_login_button()
		{

			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("text-align").toString());
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("text-align").toString().equals("center"));
	
		}
		
		//check that font size and font type of the login button
		@Test(priority=48)
		public void check_the_fontSize_and_fontStyle_of_the_login_button()
		{

			//1. navigate to page
			driver.get("http://visualivrmis.simpragma.com/");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("font-size"));
			System.out.println(driver.findElement(By.tagName("button")).getCssValue("font-family"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("font-size").equals("13px"));
			Assert.assertTrue(driver.findElement(By.tagName("button")).getCssValue("font-family").equals("Nunito"));
	
		}
		//check that login button is clickable or not
		@Test(priority=49)
		public void login_btn_is_enabled_or_not()
		{
			//1. navigate to page
					driver.get("http://visualivrmis.simpragma.com/");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Assert.assertTrue(driver.findElement(By.tagName("button")).isEnabled());
		}
	
}
