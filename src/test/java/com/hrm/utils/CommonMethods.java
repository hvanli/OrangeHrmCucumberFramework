package com.hrm.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * This method sent a String text to the given WebElement
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
//		waitForVisibility(element);
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This method clicks on the given WebElement button
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * This method accepts pop up alerts.
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
	}

	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			System.out.println("No Alert is present");
		}
		return alertText;
	}

	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			waitForVisibility(element);
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}

	public static void jsClick(WebElement element) {
		waitForClickability(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void scrollIntoElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrollDown(WebElement element, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	public static void scrollUp(WebElement element, int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will take screenshot and save it with the given file name
	 * 
	 * @param fileName
	 */
//	public static String takeScreenShot(String fileName) {
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File screen = ts.getScreenshotAs(OutputType.FILE);
//		String scrshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + "_" + getTime() + ".png";
//		try {
//			FileUtils.copyFile(screen, new File(scrshotFile));
//		} catch (IOException e) {
//			System.out.println("Cannot take screenshot");
//		}
//		return scrshotFile;
//	}

	public static byte[] takeScreenShot(String fileName) {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MMdd_HHmmss");
		String timeStamp = sdf.format(date.getTime());

		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] picture = ts.getScreenshotAs(OutputType.BYTES);

		File screen = ts.getScreenshotAs(OutputType.FILE);
		String scrshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + "_" + timeStamp + ".png";
		try {
			FileUtils.copyFile(screen, new File(scrshotFile));
		} catch (IOException e) {
			System.out.println("Cannot take screenshot");
		}
		return picture;
	}

//	/**
//	 * will take screenshot
//	 * @param fileName
//	 */
//	public static void takeScreenshot(String fileName) {
// 		TakesScreenshot ts=(TakesScreenshot)driver;
// 		File file=ts.getScreenshotAs(OutputType.FILE);
// 		try {
// 		FileUtils.copyFile(file, new File("screenshots/"+fileName+".png"));
// 		}catch(IOException e) {
// 			e.printStackTrace();
// 		}
//	}

	/**
	 * This method will create an Object of WebDriverWait
	 * 
	 * @return WebDriverWait
	 */

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	/**
	 * This method will wait until element becomes clickable
	 * 
	 * @param element
	 */
	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait until element becomes visible
	 * 
	 * @param element
	 */
	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait until element becomes invisible
	 * 
	 * @param element
	 */
	public static void waitForInvisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * This method will move the mouse to given element
	 * 
	 * @param target
	 */
	public static void moveTo(WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target);
	}

	/**
	 * This element does an action click to given element
	 * 
	 * @param target
	 */
	public static void actionsClick(WebElement element) {
		Actions action = new Actions(driver);
		waitForClickability(element);
		action.click(element);
	}

	/**
	 * This method submits a form an waits the next page to be loaded
	 * 
	 * @param element
	 */
	public static void submit(WebElement element) {
		waitForClickability(element);
		element.submit();
	}

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		String formattedDate = sdf.format(date.getTime());
		return formattedDate;
	}
	
	
	public static String jsonFile;
	/**
	 * This method receives the filepath of the jSon file and returns it in String format
	 * @param filePath
	 * @return
	 */
	public static String readJson(String filePath) {
		try {
			jsonFile=new String(Files.readAllBytes(Paths.get(filePath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonFile;
	}

}
