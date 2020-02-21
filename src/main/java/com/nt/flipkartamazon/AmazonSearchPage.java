package com.nt.flipkartamazon;

import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReusablePackage.Resubale;

public class AmazonSearchPage extends Resubale {

	@FindBy(id = "twotabsearchtextbox")
	WebElement txtSearchBox;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnsearchBox;

	@FindBy(xpath = "//span[contains(text(),'Apple iPhone XR (64GB) - Yellow')]")
	WebElement menuIphone64GB;

	@FindBy(id = "priceblock_ourprice")
	WebElement tagprice;

	public float amazonSearchValue(String content) {
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
		String amazonActualPrice[] = Price.split(" ");
		String amazonPrice = amazonActualPrice[1]; 
		String amazoniphonePrice = amazonPrice.replace(",","" );
		float iphonePriceAmazon = Float.parseFloat(amazoniphonePrice.trim());
		System.out.println(amazoniphonePrice);
		driver.switchTo().window(mainwin);
		driver.quit();
		return iphonePriceAmazon;
	}
}
