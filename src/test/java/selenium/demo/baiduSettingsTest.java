package selenium.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import selenium.util.BrowserType;
import selenium.util.GetBrowser;

//百度首页的设置
public class baiduSettingsTest {
	Logger logger = Logger.getLogger(baiduSettingsTest.class);
	
	@Test
	public void settingsTest() {
		GetBrowser browser = new GetBrowser();
		WebDriver driver = browser.getDriver(BrowserType.CHROME_BROWSER);
		if (driver == null)
			return;
		try {
			// 屏幕最大化
			// driver.manage().window().maximize();
			driver.get("https://www.baidu.com/");
			Thread.sleep(2000);

			// 设置
			WebElement settings = driver.findElement(By.xpath("//*[@id='u1']/a[8]"));
			Thread.sleep(2000);
			// 鼠标悬停，点击高级搜索
			Actions action = new Actions(driver);
			action.moveToElement(settings).perform();
			driver.findElement(By.linkText("高级搜索")).click();
			Thread.sleep(2000);

			// 点击搜索设置
			driver.findElement(By.xpath("//ul[@class='pftab_hd']/li[1]")).click();
			Thread.sleep(2000);

			// 搜索框提示： 不显示
			driver.findElement(By.id("s1_2")).click();
			// 搜索结果显示条数：每页显示20条
			driver.findElement(By.xpath("//select[@id='nr']/option[2]")).click();

			// 点击保存设置
			driver.findElement(By.xpath("//div[@id='gxszButton']/a[1]")).click();
			Thread.sleep(2000);
			// 在alert弹出的框中，点击确定
			driver.switchTo().alert().accept();
			// 浏览器退出
			// driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
}
