package com.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.abstractComponents.AbstractClass;

public class ProductCataloguePage extends AbstractClass {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div/h5/b")
	List<WebElement> products;

	@FindBy(id = "toast-container")
	WebElement toastMessage;

	By list = By.xpath("//div/h5/b");
	By addToCart = By.xpath("//div/button[2]");

	public List<WebElement> getProductList() {

		getWaitForElementToBeAppear(list);
		return products;

	}

	public WebElement getProductByName(String productName) {
		WebElement select = getProductList().stream().filter(one -> one.getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		return select;
	}

	public void addToCart(String productName) {

		WebElement ele = getProductByName(productName);
		ele.findElement(addToCart).click();
		getWaitForElementToBeDisapper(toastMessage);
		

	}

}
