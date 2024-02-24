package com.tests;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.pageobjects.LandingPage;
import com.pageobjects.ProductCataloguePage;
import com.testcomponents.BaseTest;

public class StandAloneTest extends BaseTest {

	public static void main(String[] args) throws Exception {

		LandingPage lp = getInitialize();
		lp.getLogin("katakatladurgaprasad654@gmail.com", "Chinna5237");

		ProductCataloguePage pc = new ProductCataloguePage(driver);

		List<WebElement> listOfProducts = pc.getProductList();
		WebElement select = pc.getProductByName("ADIDAS ORIGINAL");
		pc.addToCart("ADIDAS ORIGINAL");
		pc.getCartPage();
		
		
		

	}

}
