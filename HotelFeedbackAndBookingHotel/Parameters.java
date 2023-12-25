package HotelFeedbackAndBookingHotel;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String WebSite = "https://global.almosafer.com/en/hotel/details/atg/%D9%81%D9%86%D8%AF%D9%82-%D9%83%D8%B1%D8%A7%D9%88%D9%86-%D8%B1%D9%88%D8%B2-1798809";
	String HomePage = "https://global.almosafer.com/en";
	String Cities[] = { "amman", "dubai", "jeddah", "muscat" };
	Random rand = new Random();

	@BeforeTest
	public void SetUpProcess() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement Button = driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/div/div/button[2]"));
		Button.click();
	}
	@Test(priority =1)
	public void GettinTheFeedBackProcess() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		List<WebElement> ListOfFeedBack = driver.findElements(By.xpath("//span[@class=\"sc-gwZsXD krDHOW\"]"));
		System.out.println(ListOfFeedBack.size());
		for (int i = 0; i < ListOfFeedBack.size(); i++) {
			WebElement TheIndexFeedBack = ListOfFeedBack.get(i);
			String TheFeedBack = TheIndexFeedBack.getText();
			System.out.println(TheFeedBack);}
		}
		@Test(priority =2)
		public void SearchingForHotelsProcess() throws InterruptedException {
			driver.get(HomePage);
			WebElement HotelTab = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]/div"));
			HotelTab.click();
			int RandomCityIndex = rand.nextInt(Cities.length);
			WebElement SearchBar = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			SearchBar.sendKeys(Cities[RandomCityIndex]);
			WebElement DrobDownOptionsElement = driver.findElement(By.xpath("//select[@class='tln3e3-1 eFsRGb']"));
			Select DrobDownOptions = new Select(DrobDownOptionsElement);
			DrobDownOptions.selectByIndex(1);
			WebElement CheckDate = driver.findElement(By.xpath("//div[@id='js-hotelsSearchBoxDatePickerCheckInDate']"));
			CheckDate.click();
			WebElement TheFirstDayOfTheMonth = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div[1]/div[5]/span"));
			TheFirstDayOfTheMonth.click();
			WebElement TheLastDayOfTheMonth = driver.findElement(By.xpath(
					"//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[2]/div[2]/div[5]/div[5]"));
			TheLastDayOfTheMonth.click();
			WebElement SearchButton = driver.findElement(
					By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[4]/button"));
			SearchButton.click();
			Thread.sleep(10000);
			WebElement TheFirstItem = driver
					.findElement(By.xpath("//div[@data-testid=\"HotelSearchResult__ResultsList\"]/section[1]"));
			System.out.println(TheFirstItem.getText());
		}

}
