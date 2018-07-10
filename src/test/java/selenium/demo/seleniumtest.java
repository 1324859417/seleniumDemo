package selenium.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.util.BrowserType;
import selenium.util.GetBrowser;

public class seleniumtest {

	public static void main(String[] args)  {
		Logger logger = Logger.getLogger(seleniumtest.class);
		logger.error("error测试");
		logger.info("info");
		logger.debug("debug");
	}
	
	@SuppressWarnings("unused")
	private void testselenium() throws InterruptedException {
		GetBrowser kk=new GetBrowser();
		WebDriver driver = kk.getDriver(BrowserType.CHROME360_BROWSER);
		if(driver==null){
			System.err.println("driver is null:return");
			return;
		}
		
		// 屏幕最大化
		// driver.manage().window().maximize();
		driver.get("https://www.baidu.com/");
		Thread.sleep(2000);
	}
}
