package common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestBase {
	public WebDriver driver;
	public void openBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver();
		//G� URL
		//driver.get("https://demoqa.com/");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//maximize man hinh
		driver.manage().window().maximize();
	}
	//Scroll to end page
	public void scrollToEndPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	/**
	 *  @param locator
	 * */
	public void clickByLocator(By locator){
		driver.findElement(locator).click();
	}

	/**
	 * Kiem tra element hien thi => click
	 * @param locator
	 * @param timeBySecond
	 */
	public void clickToElement(By locator, int timeBySecond){
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()){
			e.click();
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
	}
	/**
	 * wait for element displayed
	 *@param timeBySecond;
	 */
	public void waitForElementDisplayed(WebElement element, int timeBySecond){
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> element.isDisplayed());
	}

	/**
	 * Input to textbox
	 * @param locator
	 * @param text
	 */

	public void inputText(By locator, String text, int timeBySecond) {
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if(e.isDisplayed()){
			e.sendKeys(text);
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
		// driver.findElement(locator).sendKeys(text);
	}

	public void keysEnter(By locator) {
		driver.findElement(locator).sendKeys(Keys.ENTER);
	}
	public void submitByLocator(By locator) {
		driver.findElement(locator).submit();
	}

	public void zoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom = '50%';");
	}

	public String getText(By locator, int timeBySecond) {
		String result="";
		WebElement e = driver.findElement(locator);
		waitForElementDisplayed(e, timeBySecond);
		if (e.isDisplayed()) {
			result = e.getText();
		} else {
			System.out.println("Element not found after" + timeBySecond + "seconds.");
		}
		return result;
	}


	public void switchNewWindowByClick(By locator, int timeBySecond){
		String originalWindow = driver.getWindowHandle();
		clickToElement(locator,timeBySecond);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeBySecond));
		//TODO: code fail
		for (String windowHandle : driver.getWindowHandles()) {
			System.out.println("windowHandle1: " + windowHandle);
			if(!windowHandle.equalsIgnoreCase(originalWindow)) {
				System.out.println("driver1: " + driver);
				//driver.switchTo().window(windowHandle);
				driver.switchTo().window(windowHandle);
				System.out.println("windowHandle2222: " + windowHandle);

				System.out.println("driver2: " + driver);

				break;
			}
		}

	}

	public void quitBrowser() {
		driver.quit(); // đóng toàn bộ tab
	}

	public void closeBrowser() {
		driver.close();
	}

	public void navigateBrowser(String url) {
		driver.navigate().to(url);
	}

	//hàm lấy giá trị attribute
	public String getValueOfAttribute(By locator,String attributeName) {
		String result="";
		result= driver.findElement(locator).getAttribute(attributeName);
		return result;
	}

	public String getTextByLocator(By locator) {
		String result = driver.findElement(locator).getText();
		return result;
	}

	public String getContentText(By locator) {
		String result = "";
		List<WebElement> lsContent = driver.findElements(locator);
		for (WebElement l : lsContent) {
			if (lsContent.size() > 1) {
				result.concat(result);
				result = result + l.getText() + " ";
			} else {
				result = result + l.getText() + " ";
			}
		}
		return result.trim();
	}

}
