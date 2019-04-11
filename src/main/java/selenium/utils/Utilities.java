package selenium.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {
	
	public static String SSDate;
	public static String SSDateTime;
	public static String file;

	/**
     * Highlights a WebElement
     * @param driver
     * @param element
     */
	public static void fnHighlightMe(WebDriver driver, WebElement element){
		//Creating JavaScriptExecuter Interface
		JavascriptExecutor js = (JavascriptExecutor)driver;
		for (int iCnt = 0; iCnt < 2; iCnt++) {
			//Execute javascript
			try {
				js.executeScript("arguments[0].setAttribute('style','background: #f2a737')", element);
				Thread.sleep(200);
				js.executeScript("arguments[0].setAttribute('style','background:')", element);
			} catch (Exception e) {
				e.printStackTrace();;
			}
		}
	}
	
	public static String takeScreenshot(WebDriver driver, String snapshotTitle) {
		SSDate = new SimpleDateFormat("yyyyMMdd_HH").format(Calendar.getInstance().getTime()).toString();
		SSDateTime = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss").format(Calendar.getInstance().getTime()).toString();
		file = System.getProperty("user.dir") + "\\reports\\" + SSDateTime + " - " + snapshotTitle + ".png";
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		try{ //Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			File DestFile=new File(file);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return file;
	}
	
}
