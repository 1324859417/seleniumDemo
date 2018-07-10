package selenium.util;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GetBrowser implements InterfaceBrowser {
	Logger logger = Logger.getLogger(GetBrowser.class);
	// 依据浏览器类型获取对应的浏览器
	public WebDriver getDriver(BrowserType browserType) {
		WebDriver driver = null;
		switch (browserType) {
		case FIREFOX_BROWSER:// 火狐
			driver = getFirefox();
			break;
		case CHROME_BROWSER:// 谷歌
			driver = getChrome();
			break;
		case CHROME360_BROWSER:// 360极速
			driver = getChrome360();
			break;
		case IE_BROWSER:// ie
			driver = getIE();
			break;
		default:
			break;
		}
		return driver;
	}

	// 获取火狐浏览器
	private WebDriver getFirefox() {
		WebDriver driver = null;
		System.out.println("火狐浏览器");
		try {
			// 如果火狐浏览器没有默认安装在系统盘，需要自己确定其路径
			System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			// 设置浏览器驱动：如果没有放入系统的环境变量中,需要加次配置
			// selenium3.0以上的版本，需要使用geckodriver代替firefoxdriver
			System.setProperty("webdriver.gecko.driver", "D:\\soft\\TestTools\\selenium\\geckodriver.exe");

			// 启动本地firefox配置
			ProfilesIni pIni = new ProfilesIni();
			FirefoxProfile profile = pIni.getProfile("default");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);

			// 启动firefox
			driver = new FirefoxDriver(options);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return driver;
	}

	// 获取谷歌浏览器
	private WebDriver getChrome() {
		WebDriver driver = null;
		System.out.println("谷歌浏览器");
		try {
			// 如果谷歌浏览器没有默认安装在系统盘，需要自己确定其路径
			System.setProperty("webdriver.chrome.bin",
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			// 设置chrome浏览器驱动：如果没有放入系统的环境变量中,需要加次配置
			System.setProperty("webdriver.chrome.driver", "D:\\soft\\TestTools\\selenium\\chromedriver.exe");
			// 谷歌浏览器的配置
			ChromeOptions options = new ChromeOptions();
			// 使用本地谷歌的配置
			options.addArguments("user-data-dir=C:\\Users\\sto\\AppData\\Local\\Google\\Chrome\\User Data");
			// options.setExperimentalOption(name, value)

			driver = new ChromeDriver(options);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return driver;
	}

	// 获取360极速浏览器
	private WebDriver getChrome360() {
		WebDriver driver = null;
		System.out.println("360极速浏览器");
		try {
			// 设置chrome浏览器驱动：如果没有放入系统的环境变量中,需要加次配置
			System.setProperty("webdriver.chrome.driver", "D:\\soft\\TestTools\\selenium\\chromedriver360.exe");
			// 设置启动360极速浏览器的路径，只能作为配置项使用；若设置在【webdriver.chrome.bin】，会启动谷歌浏览器
			String browser_url = "D:\\Program Files\\360\\360Chrome\\Chrome\\Application\\360chrome.exe";
			ChromeOptions options = new ChromeOptions();
			options.setBinary(browser_url);
			// 使用本地360极速浏览器的配置
			options.addArguments("user-data-dir=D:\\Program Files\\360\\360Chrome\\Chrome\\User Data");
			driver = new ChromeDriver(options);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return driver;
	}

	// 获取IE浏览器
	private WebDriver getIE() {
		WebDriver driver = null;
		System.out.println("ie浏览器");
		try {
			// 设置ie浏览器驱动：如果没有放入系统的环境变量中,需要加次配置
			System.setProperty("webdriver.ie.driver", "D:\\soft\\TestTools\\selenium\\IEDriverServer.exe");
			
			DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
			dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中加上这一句，即可
			dc.setCapability("ignoreProtectedModeSettings", true);
			driver = new InternetExplorerDriver(dc);
			
			/*
             * case "edge": DesiredCapabilities capEdge = DesiredCapabilities.edge();
             * capEdge.setPlatform(Platform.WIN10); capEdge.acceptInsecureCerts();
             * capEdge.setJavascriptEnabled(true); EdgeOptions options = new EdgeOptions();
             * options.setPageLoadStrategy("eager");
             * System.setProperty("webdriver.edge.driver",
             * ReadConfig.getInstance().getDriverPath().toString() +
             * "MicrosoftWebDriver.exe"); driver = new EdgeDriver(options);
             */
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return driver;
	}

}
