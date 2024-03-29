package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement Name;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "login")
	WebElement selectLogin;

	public void getLogin(String name, String pass) {

		Name.sendKeys(name);
		Password.sendKeys(pass);
		selectLogin.click();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
