# Testing CellSoftware Website

Testing functionality of the website, including English and Swedish versions. Using selenium server and chrome webdriver.

## Testing
- Contact Forms (English and Swedish versions).
- Accepting Cookies.

## Main Requirement
- Junit 5
- Selenium Server
- Google Webdriver
- Google Chrome with the correct version as the webdriver.

## Steps
- Download [selenium server](https://www.selenium.dev/downloads/).
- Download [google webdriver](https://chromedriver.chromium.org/downloads).
- Download latest chrome.
- Ensure the systemProperty is pointed to the chrome webdriver.
``` Example:
	// [ Locate Chrome WebDriver ]
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\username\\Downloads\\chromedriver_win32\\chromedriver.exe");
	}
```
- Run the Junit test within IDE.
