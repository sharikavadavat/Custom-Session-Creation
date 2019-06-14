package com.test.tests;


public class ClassVariables {
	
	static ConfigurationSetUp config = new ConfigurationSetUp();

	//Accessing URLs
	public static String popUpURL = "https://" + config.fileRead("popUpUserName") + ":"
			+ config.fileRead("popUpPassword") + "@www.labamboss.com/us/";
	
	public static String customURL = "https://egg-hunt.us.next.medicuja.de/us/customsession";
	
	//Login Credentials
	public static String userNameSelector = "//input[@placeholder='Email']";
	public static String passwordSelector = "//input[@placeholder='Password']";
	public static String loginSelector = "//input[@value='Log in']" ;
	public static String userName = config.fileRead("userName");
	public static String passwrd = config.fileRead("password");
	
	//Include Questions Section
	public static String organQuestion = "//span[text()='Organ systems']";
	public static String symptomQuestion = "//span[text()='Symptoms']";
	public static String subjectQuestion = "//span[text()='Subjects']";
	
	//Questions Filter Pop-Up
	public static String organPopUp = "//div[@class='checkboxContainer-3592618562']//span[text()='Organ systems']";
	public static String symptomPopUp = "//div[@class='checkboxContainer-3592618562']//span[text()='Symptoms']";
	public static String subjectPopUp = "//div[@class='checkboxContainer-3592618562']//span[text()='Subjects']";
	
	
	//Filter Questions Section
	public static String diffLevel = "//span[text()='Difficulty']";
	
	//Filter Questions Pop-Up
	public static String diffLevelPopup = "//div[@class='checkboxContainer-3592618562']//span[text()='Difficulty']";
	
	//Pop-Up selection 
	public static String selectionComplete = "//div[@class='buttonLabel-239617560' and text()='Done']";
	
	//Title
	public static String automaticTitleButton = "//div[@class='subHeaderContainer-1351709479']//input";
	
	public static String sessionStart = "//div[text()='Start']";
	
	public static String customSessionTitle ="//div[contains(text(),'Custom session ')]";
	

}
