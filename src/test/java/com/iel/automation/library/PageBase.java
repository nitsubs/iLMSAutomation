package com.iel.automation.library;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.iel.automation.constants.Constants;
import com.iel.automation.utilities.IelException;

/**
 * This class is for the purpose of defining methods for commonly used actions
 * 
 * @author shahenshaha.mulani
 * @since 14 Feb 2018
 *
 */
public class PageBase extends TestBase {

	public static final String ERROR_EXCELREAD = "Error in reading Test data";

	public PageBase() throws IelException {

	}

	/**
	 * This method is used to scroll down till page end
	 * 
	 * @author shahenshaha.mulani
	 */
	public void scrollDownTillPageEnd() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	/**
	 * This method is used to scroll up till page start
	 * 
	 * @author shahenshaha.mulani
	 */
	public void scrollUpTillPageStart() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");

	}

	/**
	 * This method is used to scroll till the given WebElement of a page
	 * 
	 * @param element
	 * @author shahenshaha.mulani
	 */
	public void scrollingToElementofAPage(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	/**
	 * This method is used to move the position of the mouse to the element
	 * 
	 * @param element
	 * @author shahenshaha.mulani @
	 */
	public void hoverOverElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();

	}

	/**
	 * This method is used to switch to a Frame by using index
	 * 
	 * @param intIndex
	 * @author shahenshaha.mulani
	 */
	public void switchToFrameByIndex(int intIndex) {
		driver.switchTo().frame(intIndex);

	}

	/**
	 * This method is used to switch to a Frame by using Id or Name
	 * 
	 * @param strFrame
	 * @author shahenshaha.mulani
	 */
	public void switchToFrameByIdorName(String strFrame) {
		driver.switchTo().frame(strFrame);

	}

	/**
	 * This method is used to switch to a Frame by using WebElement
	 * 
	 * @param element
	 * @author shahenshaha.mulani
	 */
	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);

	}

	/**
	 * This method is used to navigate to a window by its title
	 * 
	 * @param strTitle
	 * @throws IOException
	 * @author shahenshaha.mulani
	 */
	public void switchToWindowBytitle(String strTitle) throws IelException {
		String strCurrentWindow = driver.getWindowHandle();
		Set<String> availableWindows = driver.getWindowHandles();
		if (!availableWindows.isEmpty()) {
			for (String windowId : availableWindows) {
				if (driver.switchTo().window(windowId).getTitle().equals(strTitle)) {

				} else {
					driver.switchTo().window(strCurrentWindow);
				}
			}
		}

	}

	/**
	 * This method is used to navigate to a window
	 */
	public void switchToWindow() {
		Set<String> availableWindows = driver.getWindowHandles();
		for (String strWinHandle : availableWindows) {
			driver.switchTo().window(strWinHandle);
		}
	}

	/**
	 * This method is used to check the alert and returns boolean value
	 * 
	 * @return true or false depending on alert present or not
	 * @author shahenshaha.mulani
	 */
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	/**
	 * This method is used to accept the alert
	 * 
	 * @author shahenshaha.mulani
	 */
	public void acceptTheAlert() {
		if (isAlertPresent()) {
			do {
				Alert alert = driver.switchTo().alert();
				alert.accept();
			} while (isAlertPresent());
		}
	}

	/**
	 * This method is used to cancel the alert
	 * 
	 * @author shahenshaha.mulani
	 */
	public void cancelTheAlert() {
		if (isAlertPresent()) {
			do {
				Alert alert = driver.switchTo().alert();
				alert.dismiss();
			} while (isAlertPresent());
		}
	}

	/**
	 * This method is used to get the text and then accept the alert
	 * 
	 * @return strAlertText returns text of alert and accept the alert
	 * @author shahenshaha.mulani
	 */
	public String getTheTextAndAcceptTheAlert() {
		String strAlertText = null;
		if (isAlertPresent()) {
			do {
				Alert alert = driver.switchTo().alert();
				strAlertText = alert.getText().trim();
				alert.accept();
			} while (isAlertPresent());
		}
		return strAlertText;
	}

	/**
	 * This method is used to get the text and then cancel the alert
	 * 
	 * @return strAlertText returns text of alert and cancel the alert
	 * 
	 * @author shahenshaha.mulani
	 */
	public String getTheTextAndCancelTheAlert() {
		String strAlertText = null;
		if (isAlertPresent()) {
			do {
				Alert alert = driver.switchTo().alert();
				strAlertText = alert.getText().trim();
				alert.dismiss();
			} while (isAlertPresent());
		}
		return strAlertText;
	}

	/**
	 * This method is used to select the option from dropdown by using index
	 * value
	 * 
	 * @param element
	 * @param intIndex
	 * @author Chandrashekhar.Reddy
	 */
	public void selectDropdownByIndex(WebElement element, int intIndex) {
		Select select = new Select(element);
		select.selectByIndex(intIndex);

	}

	/**
	 * This method is used to select the option from dropdown by using value
	 * 
	 * @param element
	 * @param strOptionvalue
	 * 
	 * @author Chandrashekhar.Reddy
	 */
	public void selectDropdownByValue(WebElement element, String strOptionvalue) {
		Select select = new Select(element);
		select.selectByValue(strOptionvalue);
	}

	/**
	 * This method is used to select the option from dropdown by using actual
	 * text of the option on the application
	 * 
	 * @param element
	 * @param stroptiontext
	 * @author Chandrashekhar.Reddy
	 */
	public void selectDropdownByVisibleText(WebElement element, String stroptiontext) {
		Select select = new Select(element);
		select.selectByVisibleText(stroptiontext);
	}

	/**
	 * This method is used to enter text into input text box
	 * 
	 * @param element
	 * @param strText
	 * @author Chandrashekhar.Reddy
	 */
	public void enterText(WebElement element, String strText) {
		element.sendKeys(strText);

	}

	/**
	 * This method is used to refresh the page
	 * 
	 * @author Chandrashekhar.Reddy
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * This method is used to load the new web page with provided URL
	 * 
	 * @param strUrl
	 * @author Chandrashekhar.Reddy
	 */
	public void navigateToApp(String strUrl) {
		driver.navigate().to(strUrl);
	}

	/**
	 * This method does the same operation as clicking on the Forward Button of
	 * any browser.
	 * 
	 * @author Chandrashekhar.Reddy
	 */
	public void navigateForward() {
		driver.navigate().forward();
	}

	/**
	 * This method does the same operation as clicking on the Back Button of any
	 * browser
	 * 
	 * @author Chandrashekhar.Reddy
	 */
	public void navigateBack() {
		driver.navigate().back();
	}

	/**
	 * This method is used to keep WebDriver wait till specified
	 * 
	 * @author Chandrashekhar.Reddy
	 */
	public void waitImplicitly() {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(appConfig.getProperty(Constants.IMPLICIT_WAIT)),
				TimeUnit.SECONDS);
	}

	/**
	 * This method is used to keep WebDriver wait till expected element is
	 * visible
	 * 
	 * @param element
	 * @author Chandrashekhar.Reddy
	 */
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method is used to keep WebDriver wait till expected title is visible
	 * 
	 * @param strTitle
	 * @author Chandrashekhar.Reddy
	 */
	public void waitForTitle(String strTitle) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.titleContains(strTitle));
	}

	/**
	 * This method is used to keep WebDriver wait till expected alert is visible
	 * 
	 *  @author Chandrashekhar.Reddy
	 * 
	 */
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * This method is used to keep WebDriver wait till expected element is to be
	 * clickable
	 * 
	 * @param element
	 * @author Chandrashekhar.Reddy
	 */
	public void waitForElementClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method is used to keep WebDriver wait till expected element is to be
	 * selected
	 * 
	 * @param element
	 * @author Chandrashekhar.Reddy
	 */
	public void waitForElementSelected(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	/**
	 * This method is used to keep WebDriver wait till expected elements are
	 * visible
	 * 
	 * @param elements
	 * @author Chandrashekhar.Reddy
	 */
	public void waitForAllElements(List<WebElement> elements) {
		WebDriverWait wait = new WebDriverWait(driver,
				Integer.parseInt(appConfig.getProperty(Constants.EXPLICIT_WAIT)));
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}

}
