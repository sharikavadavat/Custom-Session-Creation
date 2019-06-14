package com.test.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author sharikavadavat
 *
 */

public class TestCases extends ClassVariables {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void launchBrowser() {

		try {

			driver = config.driverSetUp();
			wait = new WebDriverWait(driver, 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method logs into the application
	 */
	public void login() throws InterruptedException {

		/* Logging into the application using pop-up url */
		driver.get(ClassVariables.popUpURL);

		/* Hitting the custom session url */
		driver.get(ClassVariables.customURL);

		/* Logging into the custom session with username and password */
		driver.findElement(By.xpath(ClassVariables.userNameSelector)).sendKeys(ClassVariables.userName);
		driver.findElement(By.xpath(ClassVariables.passwordSelector)).sendKeys(ClassVariables.passwrd);
		driver.findElement(By.xpath(ClassVariables.loginSelector)).click();

		/* Re-hitting the custom session url to gain access to the custom session */
		driver.get(ClassVariables.customURL);
		Reporter.log("User has signed in successfully");

	}

	/**
	 * This is the test case method that runs through the test case steps -
	 * Identified through keyword 'Test'
	 */
	@Test
	public void verifySimpleSelection() {

		try {

			login();
			verifySubjectsSelection();
			verifyDiffLevelSelection();
			title();
			showSession();

			Reporter.log("Verification of Simple Selection of Questions was completed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method selects the Organ Systems from the questions section
	 */
	public void verifyOrganSystemSelection() {

		/* Selecting Organ Systems Questions from the list */

		try {

			WebElement orgSystem = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.organQuestion)));
			orgSystem.click();
			Reporter.log("Organ Systems were selected successfully");

			/*
			 * Waiting until the elements are clickable and selecting the questions with
			 * filtering
			 */
			WebElement orgSystemPopUp = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.organPopUp)));
			orgSystemPopUp.click();
			Reporter.log("All options from the pop-up were selected successfully");
			WebElement orgSystemPopUpSelect = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.selectionComplete)));
			orgSystemPopUpSelect.click();
			Reporter.log("Organ Systems Questions selection was complete");
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	public void verifySubjectsSelection() {
		try {

			WebElement subSystem = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.subjectQuestion)));
			subSystem.click();
			Reporter.log("Subjects were selected successfully");

			/*
			 * Waiting until the elements are clickable and selecting the questions with
			 * filtering
			 */
			WebElement subSystemPopUp = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.subjectPopUp)));
			subSystemPopUp.click();
			Reporter.log("All options from the pop-up were selected successfully");
			WebElement subjSystemPopUpSelect = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.selectionComplete)));
			subjSystemPopUpSelect.click();
			Reporter.log("Subjects Questions selection was complete");
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method selects the Dificulty from the filter section
	 */
	public void verifyDiffLevelSelection() {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);

			/* Selecting filter questions */
			WebElement diffLevelFilter = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.diffLevel)));
			diffLevelFilter.click();
			Reporter.log("Difficulty filter was selected successfully");

			/*
			 * Waiting until the elements are clickable and selecting filter questions
			 * pop-up
			 */
			WebElement diffLevelFilterPopUp = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.diffLevelPopup)));
			diffLevelFilterPopUp.click();
			Reporter.log("All options from Difficulty filter pop-up was selected successfully");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ClassVariables.selectionComplete))).click();
			Reporter.log("Difficulty Filter was selected successfully");
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method validates the title
	 */
	public void title() {
		try {
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(ClassVariables.automaticTitleButton)));
	
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method start the session
	 */
	public void showSession() {
		try {
			driver.findElement(By.xpath(ClassVariables.sessionStart)).click();
			WebElement customSessionTitle = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClassVariables.customSessionTitle)));
			if (customSessionTitle.isDisplayed()) {
				System.out.println("Custom session is validated");
				Reporter.log("Custom session is validated");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {

		config.driverTerminate();
	}
}
