package ReusablePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Resubale {

	public static WebDriver driver;
	protected Properties prop;
	protected FileInputStream file;

	public static void helper_Chrome(String url) {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
	}

	public static void helper_Firefox(String url) {
		System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
	}

	public String property_Value(String proper_Name) throws IOException {
		prop = new Properties();
		file = new FileInputStream("Object.properties");
		prop.load(file);
		return prop.getProperty(proper_Name);
	}
}
