import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class TestingCellsoftware {
	
	// [ GLOBALS ]
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl;
	
	boolean liveTest = false;
	String name = "John Smith";
	String email = "";
	String msg = "Hello there!";

	
	// [ Locate Chrome WebDriver ]
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\salav\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
	}

	// [ Instantiate a Chrome WebDriver for each test. ]
	@BeforeEach
	void setUp() throws Exception {
		//wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		driver = new ChromeDriver();
		baseUrl = "https://www.cellsoftware.co.uk/";
		// Add latency between actions
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	void testFillForm_EN() throws Exception {
		driver.get( baseUrl );
		
		System.out.println( driver.getTitle() );
		
		// Click on Name, Email and Message forms, then enter with 
		 
		WebElement nameField = driver.findElement(By.id("name"));
		clearAndType( nameField, name );
		
		WebElement emailField = driver.findElement(By.id("email"));
		clearAndType( emailField, email );
		
		WebElement msgField = driver.findElement(By.id("message"));
		clearAndType( msgField, msg );
		
		// Click Submit
		if (liveTest) {
			driver.findElement(By.xpath("//input[@value='Send Message']")).click();
			Thread.sleep(2000);
			
			WebElement contactForm = driver.findElement(By.className("wpcf7-form"));
			String response = getAttribute( contactForm, "data-status") ;
			
			driver.close();
			
			assertEquals("submitted", response);
		} else {
			assertTrue(true);
			driver.close();
		}

		
	}
	
	@Test
	void testFillForm_SE() throws Exception {
		driver.get( baseUrl + "/se/" );
		
		System.out.println( driver.getTitle() );
		
		// Click on Name, Email and Message forms, then enter with 
		 
		WebElement nameField = driver.findElement(By.id("name"));
		clearAndType( nameField, name );
		
		WebElement emailField = driver.findElement(By.id("email"));
		clearAndType( emailField, email );
		
		WebElement msgField = driver.findElement(By.id("message"));
		clearAndType( msgField, msg );
		
		
		// Click Submit
		if (liveTest) {
			driver.findElement(By.xpath("//input[@value='Skicka meddelande']")).click();
			Thread.sleep(2000);
			
			WebElement contactForm = driver.findElement(By.className("wpcf7-form"));
			String response = getAttribute( contactForm, "data-status") ;
			
			driver.close();
			
			assertEquals("submitted", response);
		} else {
			driver.close();
			assertTrue(true);
		}

		
	}
	
	@Test
	void testCookieAccept() throws Exception {
		driver.get( baseUrl );
		

		// Get cookie element and click.

		WebElement acceptButton = driver.findElement(By.id("patchstack-cn-accept-cookie"));
		acceptButton.click();
		
		// Refresh webpage to see results.
		driver.get( baseUrl );
		Thread.sleep(2000);
		
		WebElement cookieContainer = driver.findElement(By.id("patchstack-cookie-notice"));
		System.out.println( acceptButton.getAttribute("style") );
		
    String response = cookieContainer..getAttribute("style");
		// If cookie is saved, then once you refresh the website the cookie prompt is hidden.
		if (response.contains("hidden")) {
      
			// Close WebDriver and pass test.
			driver.close();
			assertTrue(true);
      
		} else {
      
			driver.close();
			assertTrue(false);
      
		}
		
	}
	

	
	public String getAttribute(WebElement field, String attribute) {
		
		return field.getAttribute(attribute);
	}
	
	
	void clearAndType(WebElement field, String text) {
		field.clear();
		field.sendKeys( text );
	}
	


}
