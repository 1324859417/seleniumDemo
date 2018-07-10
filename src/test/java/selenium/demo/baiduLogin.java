package selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import selenium.util.BrowserType;
import selenium.util.GetBrowser;

public class baiduLogin {
	// 百度首页的登录
	public static void main(String[] args) throws InterruptedException {

		GetBrowser browser = new GetBrowser();
		WebDriver driver = browser.getDriver(BrowserType.FIREFOX_BROWSER);
		if (driver == null)
			return;

		// 最大化
		// driver.manage().window().maximize();
		// 设置隐性等待时间
		// driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

		driver.get("https://www.baidu.com/");
		Thread.sleep(3000);

		// 点击百度首页的登录
		// driver.findElement(By.linkText("登录")).click();//次方法会报错，原因：有2个链接登录
		driver.findElement(By.xpath("//div[@id='u1']/a[7]")).click();
		// 切换到弹出的登录框：因为弹出框是个遮挡层，可以隐藏此步骤
		// driver.switchTo();
		// 设置休眠时间：页面未加载完时，页面元素会查找不到
		Thread.sleep(3000);

		// 点击用户登录，切换到用户名、密码登录
		driver.findElement(By.xpath("//*[@title='用户名登录']")).click();
		// 设置休眠时间：页面未加载完时，页面元素会查找不到
		Thread.sleep(3000);

		// 用户名文本框的清除按钮
		WebElement username_clearbtn = driver.findElement(By.id("TANGRAM__PSP_10__userName_clearbtn"));
		// 若用户名文本框的清除按钮可见，清空用户名文本框
		if (username_clearbtn.isDisplayed())
			username_clearbtn.click();
		// 输入用户名
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("1324859417@qq.com");
		// 清空密码框
		driver.findElement(By.id("TANGRAM__PSP_10__password")).clear();
		// 输入密码
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("www136468");
		// 下次自动登录：若未勾选，将其勾选
		boolean isselected = driver.findElement(By.id("TANGRAM__PSP_10__memberPass")).isSelected();
		if (!isselected)
			driver.findElement(By.id("TANGRAM__PSP_10__memberPass")).click();
		// 点击登录
		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
		// 设置休眠时间：页面未加载完时，页面元素会查找不到
		Thread.sleep(3000);

		System.out.println("获取cookies：" + driver.manage().getCookies());

		// 通过fiddler抓包工具，找到Host为“passport.baidu.com”的URL，在右侧窗口查看该请求的Cookie，
		// 找到重要的两个参数“BAIDUID”和“BDUSS”
		// Cookie c1 = new Cookie("BAIDUID", "47474A8644F6C7ECDBFBFA8C62855CAF:FG=1");
		// Cookie c2 = new Cookie("BDUSS",
		// "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAN~e-lnf3vpZc");
		//
		// driver.manage().addCookie(c1);
		// driver.manage().addCookie(c2);
		//
		// driver.navigate().refresh();

		// 获得登录用户名
		// String username = driver.findElement(By.className("user-name")).getText();
		// System.out.println("用户名username = " + username);

		// System.out.println(driver.manage().getCookies());

		// Thread.sleep(3000);
		// driver.quit();
	}
}
