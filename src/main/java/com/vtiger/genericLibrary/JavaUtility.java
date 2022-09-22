package com.vtiger.genericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author sanu
 *
 */
public class JavaUtility {

	/**
	 * this method is used to generate random numbers
	 * 
	 * @return
	 */
	public int randomValue() {
		Random random = new Random();
		return random.nextInt(1000);
	}

	/**
	 * this method is used to generate system date and time
	 * 
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		return date.toString();
	}

	/**
	 * this method is used to generate date in YYYY-MM-DD format
	 * 
	 * @return
	 */
	public String getSystemDateInYYYY_MM_DDFormat() {
		Date date = new Date();
		String YYYY = date.toString().split(" ")[5];
		int MM = date.getMonth() + 1;
		int DD = date.getDate();
		return YYYY + "-" + MM + "-" + DD;
	}

	/**
	 * this method is used to perform keyboard simulation of pressing ENTER key
	 * 
	 * @throws AWTException
	 */
	public void pressEnterButton() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
