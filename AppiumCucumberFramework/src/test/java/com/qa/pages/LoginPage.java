package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends BasePage {
	TestUtils utils = new TestUtils();

	private By usernameTxtFld = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
	private By passwordTxtFld =By.xpath("//android.widget.EditText[@content-desc='test-Password']");
	private By loginBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");
	private By errTxt = By.xpath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView");
	/*@AndroidFindBy (accessibility = "test-Username") 
	@iOSXCUITFindBy (id = "test-Username")
	private MobileElement usernameTxtFld;

	@AndroidFindBy (accessibility = "test-Password") 
	@iOSXCUITFindBy (id = "test-Password")
	private MobileElement passwordTxtFld;
	
	@AndroidFindBy (accessibility = "test-LOGIN") 
	@iOSXCUITFindBy (id = "test-LOGIN")
	private MobileElement loginBtn;
	
	@AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView") 
	@iOSXCUITFindBy (xpath = "//XCUIElementTypeOther[@name=\"test-Error message\"]/child::XCUIElementTypeStaticText")
	private MobileElement errTxt;*/

	public LoginPage(){
	}

public LoginPage enterUserName(String username) throws InterruptedException {
	clear(usernameTxtFld);	
	sendKeys(usernameTxtFld, username);
	return this;
}

public LoginPage enterPassword(String password) {
	clear(passwordTxtFld);
	sendKeys(passwordTxtFld, password);
	return this;
}

public ProductsPage pressLoginBtn() {
	click(loginBtn, "press login button");
	return new ProductsPage();
}

public ProductsPage login(String username, String password) throws InterruptedException {
	enterUserName(username);
	enterPassword(password);
	return pressLoginBtn();
}

public String getErrTxt() {
	String err = getText(errTxt, "error text is - ");
	return err;
}

}
