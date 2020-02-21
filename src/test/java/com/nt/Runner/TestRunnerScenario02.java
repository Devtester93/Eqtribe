package com.nt.Runner;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.nt.tripAdvisor.TripAdvisorPage;
import ReusablePackage.Resubale;

public class TestRunnerScenario02 extends Resubale {


	@Test(priority=0)
	public void review_TripAdvisor() throws IOException, InterruptedException {
		Resubale.helper_Chrome(property_Value("tripAdvisor_url"));
		TripAdvisorPage tripadvisorpage = PageFactory.initElements(driver, TripAdvisorPage.class);
		tripadvisorpage.tripAdvisorReview(property_Value("search_Hotel"));
		driver.quit();
	}
}
