package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	 Properties pro;
	
	public ReadConfig() {
		
		File source = new File ("./src/main/resources/config.properties");
		 try 
		 {
			 FileInputStream fis = new FileInputStream(source);			//obj of config file
			 pro = new Properties();
			 pro.load(fis); 
		 }
		 catch(Exception x)
		 {
			 System.out.println("Exception is :" +  x.getMessage());
		 }
		
	}
	
	
	
	
/******************* FOR Q11_PORTAL OPENING **********************/
	
	public String openURL()
	{ 
		String geturl =pro.getProperty("baseUrl");
		return geturl;
	}
	
	public String getadmin_username()
	{
		String Admin_username =pro.getProperty("admin_username");
		return Admin_username;
	}
	
	public String getadmin_password()
	{
		String Admin_password =pro.getProperty("admin_password");
		return Admin_password;
	
	}
	
	public long getImplicitlyWait()
	{		
			
			String implicitlyWait = pro.getProperty("implicitlyWait");
		//	if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		//	else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
			return 0;
	
	}
	
/*********************** END ************************************/
	
	
	
	
/*************** FOR  Q11_PARTNERPORTAL OPENING *****************/
	
	public String openpartnerURL()
	{ 
		String getpartnerurl =pro.getProperty("baseUrl_partner");
		return getpartnerurl;
	}
	
	public String getpartner_username()
	{
		String partner_username =pro.getProperty("partner_username");
		return partner_username;
	}
	
	public String getpartner_password()
	{
		String partner_password =pro.getProperty("partner_password");
		return partner_password;
	
	}
	
/*********************** END ************************************/

	
	
	
/*************** FOR  Q11_MEMBERPORTAL OPENING *****************/
	
	public String openmemberURL()
	{ 
		String getmemberurl =pro.getProperty("baseUrl_member");
		return getmemberurl;
	}
	
/*********************** END ************************************/
	
	
	
	

	
/************************ FOR PAYMENT **************************/
		
	public  String getpaypal_username()
	{
		String paypal_username =pro.getProperty("emailforpayment");
		return paypal_username;
	}
	
	public String getpaypal_password()
	{
		String paypal_password =pro.getProperty("passwordforpayment");
		return paypal_password;
	
	}
	
/*********************** END ************************************/
	
	
	
	
	
	/********************* FOR ACCOUNT CREATION ********************/
	
	//Username
	public String get_username()
	{ 
	String Username =pro.getProperty("username");
	return Username;
	}
	
	//Email
	public String get_email()
	{ 
	String Email =pro.getProperty("email");
	return Email;
	}

	//Firstname
	public String getFirst_name()
	{ 
		String firstname =pro.getProperty("first_name");
		return firstname;
	}
	
	//Lastname
	public String getLast_name()
	{
		String lastname =pro.getProperty("last_name");
		return lastname;
	}
	
	//Company name
	public String getCompany_name()
	{
		String companyname =pro.getProperty("company_name");
		return companyname;
	}
	
	//Address 
	public String getAddress1()
	{
		String Address1 =pro.getProperty("address1");
		return Address1;
	}
	
	//Country
	public String getCountry_name()
	{ 
		String Country =pro.getProperty("country");
		return Country;
	}
	
	//State
	public String getState_name()
	{ 
		String State =pro.getProperty("state");
		return State;
	}
	
	//city
	public String getCity_name()
	{ 
		String City =pro.getProperty("city");
		return City;
	}
	
	//Phone Number
	public String getPhone_number()
	{ 
		String phone =pro.getProperty("phone");
		return phone;
	}
	
	//Pincode
	public String getPincode_number()
	{ 
		String Pincode =pro.getProperty("pincode");
		return Pincode;
	}
	
	//Where Do You Live
	public String getWhere_do_you_live()
	{ 
		String Where_do_you_live =pro.getProperty("where_do_you_live");
		return Where_do_you_live;
	}
	
	//Favourite_palce
	public String getFavourite_place()
	{ 
		String Favourite_palce =pro.getProperty("favourite_palce");
		return Favourite_palce;
	}

/*********************** END ************************************/
		
//////////////////////////////////////////////////////////////
		public String getUsername2()
		{
			String usern = pro.getProperty("Username2");
			return usern;
		}
		
		public String getEmail2()
		{
			String email1 = pro.getProperty("email2");
			return email1;
		}
		
		public String getFirstName2()
		{
			String first2 = pro.getProperty("firstname2");
			return first2;
		}
		
		public String getLastName2()
		{
			String last2 = pro.getProperty("lastname2");
			return last2;
		}
		

		public String getPassword2()
		{
			String pass2 = pro.getProperty("password2");
			return pass2;
		}
		
		public String getConfirmPass2()
		{
			String conf2 = pro.getProperty("confirm2");
			return conf2;
		}
		public String getCompany2()
		{
			String comp2 = pro.getProperty("company2");
			return comp2;
		}
		
		
		public String getWebsite2()
		{
			String web2 = pro.getProperty("website2");
			return web2;
		}
		
		public String getAddress2()
		{
			String add2 = pro.getProperty("address2");
			return add2;
		}
		
		public String getAddress2_()
		{
			String add2_ = pro.getProperty("address2_");
			return add2_;
		}
		
		public String getCountry()
		{
			String con2 = pro.getProperty("country2");
			return con2;
		}
		

		public String getRegion()
		{
			String reg2 = pro.getProperty("region2");
			return reg2;
		}
		
		public String getCity2()
		{
			String city2 = pro.getProperty("city2");
			return city2;
		}
		
		public String getZipcode2()
		{
			String zip2 = pro.getProperty("zipcode");
			return zip2;
		}
		
		public String getContact2()
		{
			String contact2 = pro.getProperty("contact2");
			return contact2;
		}

		public String getEmail3()
		{
			String email3 = pro.getProperty("email3");
			return email3;
		}
		
		public String getPassword3()
		{
			String pass3 = pro.getProperty("password3");
			return pass3;
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
