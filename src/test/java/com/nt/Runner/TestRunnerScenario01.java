package com.nt.Runner;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.nt.flipkartamazon.AmazonSearchPage;
import com.nt.flipkartamazon.FlikartSearchPage;

import ReusablePackage.Resubale;

public class TestRunnerScenario01 extends Resubale {
	float amazoniphoneprice,iphonePriceflipkart;


	@Test(priority=0)
	public void search_Amazon() throws IOException {
		Resubale.helper_Chrome(property_Value("amazon_url"));
		AmazonSearchPage amazonpage = PageFactory.initElements(driver, AmazonSearchPage.class);
		amazoniphoneprice = amazonpage.amazonSearchValue(property_Value("search_Item"));
		driver.quit();
	}

	@Test(priority=1)
	public void search_Flipkart() throws IOException {
		Resubale.helper_Chrome(property_Value("flipkart_url"));
		FlikartSearchPage flipkartpage = PageFactory.initElements(driver, FlikartSearchPage.class);
		iphonePriceflipkart = flipkartpage.flipkartSearchValue(property_Value("search_Item"));
		driver.quit();
	}
	
	@Test(priority=3)
	public void calculate_Price() {
		if(iphonePriceflipkart>amazoniphoneprice)
		{
			System.out.println("Amazon is Having Less Price For iPhone XR with Amount " + amazoniphoneprice);
		}
		else
			System.out.println("Flipkart is Having Less Price For iPhone XR with Amount" + iphonePriceflipkart);
	}
}
