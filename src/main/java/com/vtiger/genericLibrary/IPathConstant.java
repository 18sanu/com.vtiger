package com.vtiger.genericLibrary;

public interface IPathConstant {

	int IMPLICIT_WAIT_TIME=20;
	int EXPLICIT_WAIT_TIME=20;
	int FLUENT_WAIT_TIME=20;
	int POLLING_PERIOD=250;
	int THREAD_SLEEP=10000;
	
	String PROPERTY_FILE_PATH="./src/test/resources/propertyFile.properties";
	String EXCEL_FILE_PATH="./src/test/resources/OpportunityExcelData.xlsx";
	String JSON_FILE_PATH="./src/test/resources/jsonFile.json";
	
	String USERNAME_KEY="username";
	String PASSWORD_KEY="password";
	String URL_KEY="url";
	String BROWSER_KEY="browser";
	
	String SHEET_NAME1="Sheet1";
	String SHEET_NAME2="Sheet2";
	String CHROME_BROWSER_KEY="webdriver.chrome.driver";
	String CHROME_BROWSER_VALUE="./chromedriver.exe";
}
