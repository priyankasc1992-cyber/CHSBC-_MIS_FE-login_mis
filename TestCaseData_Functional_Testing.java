package login_mis;

import org.testng.annotations.DataProvider;

public  class TestCaseData_Functional_Testing {
	 @DataProvider
		public String[][]  inValid()
		{
		 int n=1;
			String [][] data=new String[n][2];
		
		
	//Tc_8:enter invalid email id and invalid password 
		data[0][0]="hf@simpragam.com";
		data[0][1]="Password@123";
						
			
	
			return data;
		}
	 
	 @DataProvider
	 public String [][] validateForEmailFieldForInvalidErrormessage()
	 {
		 int n=5;
			String [][] data=new String[n][2];
		//Tc_9 enter only alphabets in email text field
			data[0][0]="hffhgghfufyhuyhufyhuyufyhyhfh";
			data[0][1]="Password@123";
		
		//TC_10 enter only digits in email text field 
		data[1][0]="123456";
		data[1][1]="Password@123";
		
		//TC_11enter alphanumeric in email text field
		data[2][0]="Priyanka123456";
		data[2][1]="Password@123";
			
			//Tc_12 enter other special chars excluding @ in email text field
		data[3][0]="!#$%^&*();:\"'|\\\\?<>,.";
		data[3][1]="Password@123";
		
		//TC_16 enter data given test data <script>@123.com
		//EO Plaese enter valid email  error message must be displayed
		data[4][0]="<script>@123.com";
		data[4][1]="Password@123";
		return data;
	 }
	 @DataProvider
		public String[][]   ValidateForPasswordField()
		{
		 int n=6;
			String [][] data=new String[n][2];
	
			
			
			//Tc_17 enter only alphabets in password text field
			data[0][0]="naveenr@simpragam.com";
			data[0][1]="hffhgghfufyhuyhufyhuyufyhyhfh";
			
			//TC_18 enter only digits in password text field 
			data[1][0]="naveenr@simpragam.com";
			data[1][1]="123456";
			
			//TC_19 enter alphanumeric in password text field
			data[2][0]="naveenr@simpragam.com";
			data[2][1]="Priyanka123456";
			
			//Tc_20 enter other special chars in password
			data[3][0]="naveenr@simpragam.com";
			data[3][1]="!#$%^&*();:\\\"'|\\\\\\\\?<>,.";
			
			
			//Tc_21 enter combination of alphabets, digits and special chars except @  in password text field
			data[4][0]="naveenr@simpragam.com";
			data[4][1]="adshgabu2341sgsvhzznsn#$%%^";
			
			
			//Tc_22 enter other speces in password
			data[5][0]="naveenr@simpragam.com";
			data[5][1]="         ";
			return data;
		}
	 @DataProvider
		public String[][]   getValid()
		{
		 int n=1;
			String [][] data=new String[n][2];
		
			data[0][0]="naveenr@simpragma.com";
			data[0][1]="Password@123";
		
			return data;
		}


}
