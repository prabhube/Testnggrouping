package org;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Base_Class {

		public static WebDriver driver;

		public static void property() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\prem\\eclipse-workspace\\NewProject\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		public static void launchurl(String url) {
			driver.get(url);
		}

		public static void maximize() {
			driver.manage().window().maximize();

		}

		public static void getTitle(WebDriver a) {
			String title = driver.getTitle();
			System.out.println("Title: " + title);
		}

		public static void CurrentUrl(WebDriver a) {
			String url = driver.getCurrentUrl();
			System.out.println("Currenturl: " + url);
		}

		public static void navigateTo(String url) {
			driver.navigate().to(url);
		}

		public static void navigateBack() {
			driver.navigate().back();
		}

		public static void navigateForward() {
			driver.navigate().forward();
		}

		public static void navigateRefresh() {
			driver.navigate().refresh();
		}

		public static void alertAccept() {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}

		public static void alertDismiss() {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		}

		public static void alertSendkeys(String keys) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys("keys");
		}

		public static void alertGettext() {
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			System.out.println("Text:" + text);
		}

		public static void frameSwitch(WebElement a) {
			driver.switchTo().frame(a);
		}

		public static void frameDefault() {
			driver.switchTo().defaultContent();
		}

		public static void scrolleintoview(WebElement a) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", a);
		}

		public static void scrollbyValue(int value) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0," + value + ");");
		}

		public static void scrollbyClick(WebElement a) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", a);
		}

		public static void actionClick(WebElement a) {
			Actions ax = new Actions(driver);
			ax.click(a).build().perform();
		}

		public static void actionContextclick(WebElement a) {
			Actions ax = new Actions(driver);
			ax.contextClick(a).build().perform();
		}

		public static void actionDoubleclick(WebElement a) {
			Actions ax = new Actions(driver);
			ax.doubleClick(a).build().perform();
		}

		public static void actionMoveToElement(WebElement a) {
			Actions ax = new Actions(driver);
			ax.moveToElement(a).build().perform();
		}

		public static void robotKey(int KeyEvent) throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent);
			r.keyRelease(KeyEvent);
		}

		public static void robotKeypress(int KeyEvent) throws AWTException {
			Robot r = new Robot();
			r.keyPress(KeyEvent);
		}

		public static void robotKeyrelease(int KeyEvent) throws AWTException {
			Robot r = new Robot();
			r.keyRelease(KeyEvent);
		}

		public static void windowHandles() {
			int size = driver.getWindowHandles().size();
			System.out.println("Window size:" + size);
		}

		public static void windowHandle() {
			String wp = driver.getWindowHandle();
			System.out.println(wp);
		}

		public static void getTitle() {
			Set<String> allwin = driver.getWindowHandles();
			for (String cp : allwin) {
				String title = driver.switchTo().window(cp).getTitle();
				System.out.println(title);
			}
		}

		public static void particularWindow(String a) {
			String actualwin = a;
			Set<String> allwin = driver.getWindowHandles();
			for (String cp : allwin) {
				if (driver.switchTo().window(cp).getTitle().equals(actualwin)) {
					break;
				}
			}
		}

		public static void dropdownbyIndex(WebElement a, int b) {
			Select se = new Select(a);
			se.selectByIndex(b);
		}

		public static void dropdownbyValue(WebElement a, String b) {
			Select se = new Select(a);
			se.selectByValue(b);
		}

		public static void dropdownbyVisibleText(WebElement a, String b) {
			Select se = new Select(a);
			se.selectByVisibleText(b);
		}

		public static void dropdownDeSelectbyIndex(WebElement a, int b) {
			Select se = new Select(a);
			se.deselectByIndex(b);
		}

		public static void dropdownDeSelectbyValue(WebElement a, String b) {
			Select se = new Select(a);
			se.deselectByValue(b);
		}

		public static void dropdownDeSelectbyVisibletext(WebElement a, String b) {
			Select se = new Select(a);
			se.deselectByVisibleText(b);
		}

		public static void dropdownDeSelectall(WebElement a) {
			Select se = new Select(a);
			se.deselectAll();
		}

		public static void implicitlyWait(int timevalue, TimeUnit TimeUnit) {
			driver.manage().timeouts().implicitlyWait(timevalue, TimeUnit);
		}

		public static void thread(int value) throws InterruptedException {
			Thread.sleep(value);

		}

		public static void screenShot(String location, String b) throws IOException {
			TakesScreenshot srcs = (TakesScreenshot) driver;
			File screen = srcs.getScreenshotAs(OutputType.FILE);
			File shot = new File(location + "\\" + b + ".png");
			FileUtils.copyFile(screen, shot);
		}

		public static void close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

	}

