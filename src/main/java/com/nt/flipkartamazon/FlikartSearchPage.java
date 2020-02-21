package com.nt.flipkartamazon;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReusablePackage.Resubale;

public class FlikartSearchPage extends Resubale {
	
	@FindBy(xpath = "//button[@class='_2AkmmA _29YdH8']")
	WebElement btnclosePopup;
	
	@FindBy(xpath = "//input[@name='q']")
	WebElement txtSearchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnsearchBox;

	@FindBy(xpath = "//div[contains(text(),'Apple iPhone XR (Yellow, 64 GB)')]")
	WebElement menuIphone64GB;
	
	@FindBy(xpath = "//div[@class='_1vC4OE _3qQ9m1']")
	WebElement tagprice;

	public float flipkartSearchValue(String content) {
		btnclosePopup.click();
		txtSearchBox.sendKeys(content);
		btnsearchBox.click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(menuIphone64GB));
		String mainwin = driver.getWindowHandle();
		menuIphone64GB.click();
		Set<String> childwin = driver.getWindowHandles();
		for (String eachwin : childwin) {
			if (!mainwin.equals(eachwin)) {
				driver.switchTo().window(eachwin);
			}
		}
		String Price = tagprice.getText();
		String flipkartiphonePrice = Price.replace("₹","");
		String iphoneRealPriceflipkart = flipkartiphonePrice.replace(",","");
		float iphonePriceflipkart = Float.parseFloat(iphoneRealPriceflipkart);
		System.out.println(iphonePriceflipkart);
		driver.switchTo().window(mainwin);
		driver.quit();
		return iphonePriceflipkart;
	}
}
