package hbm.planner.dataobject;

import hbm.planner.utility.CreateData;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.testng.annotations.DataProvider;

public class SignUpData {

	private String loginId;
	private String password;
	private String emailId;
	private String country;
	private String yourProfile;
	private String fBEmailId;
	private String fBPassword;
	private String gmailId;
	private String gmailPwd;
	
	private Properties properties = new Properties();
	
	public SignUpData() throws IOException{
		properties.load(SignUpData.class.getResourceAsStream("/signupdata.properties"));
//		loginId = properties.getProperty("loginId");
//		password = properties.getProperty("password");
//		emailId = properties.getProperty("emailId");
//		country = properties.getProperty("country");
//		fBEmailId = properties.getProperty("fBEmailId");
//		fBPassword = properties.getProperty("fBPassword");
//		gmailId = properties.getProperty("gmailId");
//		gmailPwd = properties.getProperty("gmailPwd");		
	}
	
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getYourProfile() {
		return yourProfile;
	}

	public void setYourProfile(String yourProfile) {
		this.yourProfile = yourProfile;
	}

	public String getfBEmailId() {
		return fBEmailId;
	}

	public void setfBEmailId(String fBEmailId) {
		this.fBEmailId = fBEmailId;
	}

	public String getfBPassword() {
		return fBPassword;
	}

	public void setfBPassword(String fBPassword) {
		this.fBPassword = fBPassword;
	}

	public String getGmailId() {
		return gmailId;
	}

	public void setGmailId(String gmailId) {
		this.gmailId = gmailId;
	}

	public String getGmailPwd() {
		return gmailPwd;
	}

	public void setGmailPwd(String gmailPwd) {
		this.gmailPwd = gmailPwd;
	}

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("loginId"));	
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("password")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "hbmProdloginData")
	public static Object[][] getHBMProdLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("hbmProdId"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("hbmProdPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "newUserSignUpData")
	public static Object[][] getNewUserSignUpData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("newId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("newId"));
		signUpData.setGmailId(signUpData.properties.getProperty("newId"));
		signUpData.setGmailPwd(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setfBEmailId(signUpData.properties.getProperty("newId"));		
		signUpData.setfBPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "newMDMUserSignUpData")
	public static Object[][] getNewMDMUserSignUpData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("hbm4NewEmailId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("hbm4NewEmailId"));		
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "emailMDMUser")
	public static Object[][] getEmailMDMUser() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("hbm4NewEmailId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));	
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "fBLoginData")
	public static Object[][] getFbLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setfBEmailId(signUpData.properties.getProperty("fBEmailId"));		
		signUpData.setfBPassword(CreateData.get(signUpData.properties.getProperty("fBPassword")));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "gmailLoginData")
	public static Object[][] getGmailLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setGmailId(signUpData.properties.getProperty("gmailId"));	
		signUpData.setGmailPwd(CreateData.get(signUpData.properties.getProperty("gmailPwd")));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("gmailId"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setLoginId(signUpData.properties.getProperty("gmailId"));
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name="emailLogin")
	public static Object[][] getEmailLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("emailId"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "imperialLoginData")
	public static Object[][] getImperialLoginData() throws IOException{				
		SignUpData signUpData = new SignUpData();		
		signUpData.setLoginId(signUpData.properties.getProperty("imperialId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("imperialPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "3DCloudByMeLoginData")
	public static Object[][] get3DCloudByMeLoginData() throws IOException{				
		SignUpData signUpData = new SignUpData();		
		signUpData.setLoginId(signUpData.properties.getProperty("clouldId"));
		signUpData.setPassword(signUpData.properties.getProperty("clouldPwd"));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "idsLoginData")
	public static Object[][] getIDSLoginData() throws IOException{				
		SignUpData signUpData = new SignUpData();		
		signUpData.setLoginId(signUpData.properties.getProperty("idsId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("idsPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name="cloudByMe")
	public static Object[][] getCloudByMeLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();		
		signUpData.setLoginId(signUpData.properties.getProperty("clouldId"));
		signUpData.setPassword(signUpData.properties.getProperty("cloudPwd"));
		signUpData.setEmailId(signUpData.properties.getProperty("hbm4NewEmailId"));	
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name="backOffice")
	public static Object[][] getBackOfficeLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();		
		signUpData.setLoginId("3dviafloorplan@gmail.com");
		signUpData.setPassword("3Dplmfloorplan");
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "hmsLoginData")
	public static Object[][] getHMSLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();	
		signUpData.setLoginId(signUpData.properties.getProperty("hmsId"));	
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("hmsPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "hbmProUserData")
	public static Object[][] getHBMProUserLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("hbmProUserId"));	
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("hbmProUserPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "bryoLogin")
	public static Object[][] getBryoLoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("bryoId"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("bryoPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	@DataProvider(name = "ikeaLogin")
	public static Object[][] getIKEALoginData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("ikeaId"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("ikeaPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	@DataProvider(name = "cloudSupAdmin")
	public static Object[][] getCloudSupAdminData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudSupAdminID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudSupAdminPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("hbm4NewEmailId"));	
		return new SignUpData[][]{{signUpData}};
	}
	
	@DataProvider(name = "cloudAdmin")
	public static Object[][] getCloudAdminData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudAdminID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudAdminPwd")));		
		signUpData.setEmailId(signUpData.properties.getProperty("hbm4NewEmailId"));	
		return new SignUpData[][]{{signUpData}};
	}
	/*
	@DataProvider(name = "cloudOpenIdAdmin")
	public static Object[][] getCloudClassicAdminData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudOpenIdAdminID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudOpenIdAdminPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	*/
	@DataProvider(name = "cloudCont")
	public static Object[][] getCloudContData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudContID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudContPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	/*
	@DataProvider(name = "cloudOpenIdCont")
	public static Object[][] getCloudClassicContData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudOpenIdContID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudOpenIdContPwd")));		
		return new SignUpData[][]{{signUpData}};
	}
	*/
	@DataProvider(name = "cloudReview")
	public static Object[][] getCloudReviewData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("cloudReviewID"));		
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("cloudReviewPwd")));		
		return new SignUpData[][]{{signUpData}};
	}	
	
	
	@DataProvider(name = "newHBMUserSignUpData")
	public static Object[][] getNewHBMUserSignUpData() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("newHBMId"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("newId"));
		signUpData.setGmailId(signUpData.properties.getProperty("newId"));
		signUpData.setGmailPwd(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setfBEmailId(signUpData.properties.getProperty("newId"));		
		signUpData.setfBPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData1")
	public static Object[][] getRewardData1() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId1"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId1"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData2")
	public static Object[][] getRewardData2() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId2"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId2"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData3")
	public static Object[][] getRewardData3() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId3"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId3"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData4")
	public static Object[][] getRewardData4() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId4"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId4"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData5")
	public static Object[][] getRewardData5() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId5"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId5"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData6")
	public static Object[][] getRewardData6() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId6"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId6"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}
	
	@DataProvider(name = "rewardData7")
	public static Object[][] getRewardData7() throws IOException{
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("rewardId7"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("newPwd")));
		signUpData.setEmailId(signUpData.properties.getProperty("rewardId7"));
		signUpData.setCountry(signUpData.properties.getProperty("country"));
		signUpData.setYourProfile(signUpData.properties.getProperty("yourProfile"));
		return new SignUpData[][] {{signUpData}};
	}

	@DataProvider(name = "bathroomUserData")
	public static Object[][] getBathroomUserData() throws IOException {
		SignUpData signUpData = new SignUpData();
		signUpData.setLoginId(signUpData.properties.getProperty("bathroomLoginID"));
		signUpData.setPassword(CreateData.get(signUpData.properties.getProperty("bathroomLoginPwd")));
		return new SignUpData[][]{{signUpData}};
	}

}
