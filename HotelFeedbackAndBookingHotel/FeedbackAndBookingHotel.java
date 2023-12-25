package HotelFeedbackAndBookingHotel;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FeedbackAndBookingHotel extends Parameters {
	
	@BeforeTest
	public void SetUp() {
		SetUpProcess();
	}

	@Test()
	public void GettinTheFeedBack() {
		 GettinTheFeedBackProcess() ;
		}
	@Test()
	public void SearchingForHotels() throws InterruptedException {
		SearchingForHotelsProcess();
	}

}
