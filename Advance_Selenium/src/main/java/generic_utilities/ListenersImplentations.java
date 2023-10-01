package generic_utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import generic_utilities.BaseClass;

public class ListenersImplentations implements ITestListener{

	
	public void onTestFailure(ITestResult result) {
		String testData = result.getMethod().getMethodName();
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
		
		File src = edriver.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyDirectory(src, new File("./ScreenShots/"+testData+".png"));
		} catch (Exception e) {
			//e.printStackTrace()
		//	
		}
	}}
	


