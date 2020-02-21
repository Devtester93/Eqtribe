package com.nt.tripAdvisor;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReusablePackage.Resubale;

public class TripAdvisorPage extends Resubale {
	
	@FindBy(xpath = "//div[@title='Search']")
	WebElement btnsearchBox1;
	
	@FindBy(xpath = "//div[@id='MAIN_SEARCH_CONTAINER']/div/div/input")
	WebElement txtSearchBox;
	
	@FindBy(id = "SEARCH_BUTTON_CONTENT")
	WebElement btnsearchBox;

	@FindBy(xpath = "//ul[@class='resultContainer local']/li[1]")
	WebElement hotelfirstList;
	
	@FindBy(xpath = "//a[contains(text(),'Write a review')]")
	WebElement btnwriteReview;
	
	@FindBy(xpath = "//span[@id='bubble_rating']")
	WebElement writeReviewRating;
	
	@FindBy(id = "ReviewTitle")
	WebElement ReviewTitle;
	
	@FindBy(id = "ReviewText")
	WebElement ReviewText;
	
	@FindBy(id = "trip_date_month_year")
	WebElement ReviewDate;

	@FindBy(id = "//div[@id='trip_type_table']/div[1]")
	WebElement tripType;
	
	@FindBy(id = "noFraud")
	WebElement btnaccept;
	
	@FindBy(xpath = "//span[contains(text(),'Submit your review ')]")
	WebElement btnSubmit;

	public void tripAdvisorReview(String content) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		btnsearchBox1.click();
		wait.until(ExpectedConditions.elementToBeClickable(txtSearchBox));
		txtSearchBox.sendKeys(content);
		//wait.until(ExpectedConditions.elementToBeClickable(hotelfirstList));
		Actions ac = new Actions(driver);
		ac.moveToElement(hotelfirstList).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", hotelfirstList);
		js.executeScript("javascript:window.scrollBy(500,0)");
		wait.until(ExpectedConditions.elementToBeClickable(btnwriteReview));
		String mainwin = driver.getWindowHandle();
		btnwriteReview.click();
		Set<String> childwin = driver.getWindowHandles();
		for (String eachwin : childwin) {
			if (!mainwin.equals(eachwin)) {
				driver.switchTo().window(eachwin);
			}
		}
		ac.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='bubble_rating']"))),50,0).click().build().perform();
		ReviewTitle.sendKeys("Your hotel experiences really help other travellers.");
		ReviewText.sendKeys("Your hotel experiences really help other travellers.Your hotel experiences really help other travellers.Your hotel experiences really help other travellers.Your hotel experiences really help other travellers."
				+ "Your hotel experiences really help other travellers.");
		Select traveldate = new Select(ReviewDate);
		traveldate.selectByValue("February 2020");
		tripType.click();
		btnaccept.click();
		btnSubmit.click();
	}
}
