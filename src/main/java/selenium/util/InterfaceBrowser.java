package selenium.util;

import org.openqa.selenium.WebDriver;

public interface InterfaceBrowser {
	//依据浏览器类型获取对应的浏览器
	public WebDriver getDriver(BrowserType browserType);
}
