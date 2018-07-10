package selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.util.BrowserType;
import selenium.util.GetBrowser;

public class ly {
	// 使用cookie绕过登录
	public static void main(String[] args) {
		GetBrowser browser = new GetBrowser();
		WebDriver driver = browser.getDriver(BrowserType.CHROME360_BROWSER);
		if (driver == null) {
			System.err.println("driver is null:return");
			return;
		}

		// 最大化
		// driver.manage().window().maximize();
		// 设置隐性等待时间
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		String url = "http://192.168.124.135:9010/Home/Index";
		driver.get(url);

		// 点击 留言管理 菜单
		driver.findElement(By.className("nav-label")).click();
		// 点击 留言交互 菜单
		driver.findElement(By.linkText("留言交互")).click();
		// 点击 发出留言 
		driver.findElement(By.linkText("发出留言")).click();
		// 点击 查询
		driver.findElement(By.xpath("//button[@data-type='Query']")).click();
		
		// 添加留言
		driver.findElement(By.xpath("//button[@data-type='Add']")).click();
		driver.findElement(By.xpath("//div[@class='layui-select-title']/input")).click();
		//费用问题
		driver.findElement(By.xpath("//dd[@lay-value='100004']")).click();
		//运单编号
		driver.findElement(By.name("BillCode")).clear();
		driver.findElement(By.name("BillCode")).sendKeys("3362580102252");
		//目标网点
		driver.findElement(By.name("TargetSite")).clear();
		driver.findElement(By.name("TargetSite")).sendKeys("上海申通");
		//主题
		driver.findElement(By.name("Theme")).clear();
		driver.findElement(By.name("Theme")).sendKeys("费用问题");
		//内容
		driver.findElement(By.name("Describe")).clear();
		driver.findElement(By.name("Describe")).sendKeys("费用问题");
		//上传
		driver.findElement(By.id("attach")).click();
		
		

		driver.quit();
	}
}
