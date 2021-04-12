package org.test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClassProject {
	public static WebDriver driver;

	public static WebDriver getdriver() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sony\\eclipse-workspace\\PRAKASH\\Junit\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}
	
	public static void getTitle(){
		String title2 = driver.getTitle();
		
	
	}

	public static void closeTab() {
		driver.close();
	}

	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}

	public  static void btnClick(WebElement element) {
		element.click();
	}
	
	public static void dragAndDrop(WebElement element,WebElement source,WebElement target) {
      Actions ac=new Actions(driver);
           ac.dragAndDrop(source,target).perform();
	}
	
	public static void mouseOver(WebElement element,WebElement target) {
		 Actions ac=new Actions(driver);
		 ac.moveToElement(target).perform();;    
	}
	
	public static void quit() {
      driver.quit();
	}
	
	public static void ClickAndHoldAction(WebElement element,WebElement name) {
		 Actions ac=new Actions(driver);
		 ac.clickAndHold(name).release(name).perform();
    	}
	
	public static void rightClick(WebElement element,WebElement button) {
		 Actions ac=new Actions(driver);
		 ac.contextClick(button).perform();
   	}
	
	public static void doubleClick(WebElement text) {
		 Actions ac=new Actions(driver);
		 ac.doubleClick(text).perform();
   	}

	 public static void simplealert() {
     Alert al=driver.switchTo().alert();
     al.accept();
	}
	 
	 public static void confirmalert(String options) {
		 if (options.equalsIgnoreCase("accept")) {
			 Alert al=driver.switchTo().alert();
			 al.accept();
			 driver.switchTo().defaultContent();
		 }
		 else {
			 Alert al=driver.switchTo().alert();
			 al.dismiss();
	         driver.switchTo().defaultContent();
			 }
			 		}

	 public static void promptalert(String options,String Value) {
		 if (options.contains("accept")) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
			driver.switchTo().defaultContent();
		}else
		{
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(Value);
			alert.dismiss();
			driver.switchTo().defaultContent();
		}

	}

	public static void scrollDown(String Value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(Value, element);
	}

	public static void screenShot(String data) throws IOException {
      TakesScreenshot ts=(TakesScreenshot) driver;		
      File sourcefile = ts.getScreenshotAs(OutputType.FILE);
      File destfile=new File(System.getProperty("user.dir")+"\\target\\"+data+".png");
      FileUtils.copyFile(sourcefile, destfile);
	}

	//public void dropDown(WebElement element,String value) {
		//Select s=new Select(element);
	//	s.selectByValue(value);
//}
	public static void dropDown(WebElement element,String option,String value) throws Exception {
		Select sc = new Select(element);
		if (option.equalsIgnoreCase("visibleText")) {
			sc.selectByVisibleText(value);
		}else if (option.equalsIgnoreCase("index")) {
			sc.selectByIndex(Integer.parseInt(value));
		}else if (option.equalsIgnoreCase("value")) {
			sc.selectByValue(value);
		}else{
			throw new Exception("not a valid option");
		}
	}
	 public static String attribute(WebElement element,String value) {
     String attribute = element.getAttribute(value);
     return attribute;
	}
	

// public void getDataFromExcel(String pathname,String sheetName,int rowNo,int cellNo) throws IOException {
//	 File file=new File(pathname);
//	 FileInputStream fileInputStream=new FileInputStream(file);
//	 Workbook workbook=new XSSFWorkbook(fileInputStream);
//	 Sheet sheet = workbook.getSheet(sheetName);
//	 Row row = sheet.getRow(rowNo);
//	 Cell cell = row.getCell(cellNo);
//	 int cellType = cell.getCellType();
//	 String value="";
//	 if(cellType==1) {
//		 value=cell.getStringCellValue();
//	 }
//	 else if(DateUtil.isCellDateFormatted(cell)) {
//	Date dateCellValue=cell.getDateCellValue();	
//	 SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy") ;
//	 value=df.format(dateCellValue);
//	 }
//	 else
//	 {
//	 double numericCellValue = cell.getNumericCellValue();
//	 long l=(long) numericCellValue;
//	 String.valueOf(l);
//	 }
//     return;
// }



}
	
	
	
