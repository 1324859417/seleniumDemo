package selenium.util;

public enum BrowserType {
	FIREFOX_BROWSER("火狐"),CHROME_BROWSER("谷歌"),CHROME360_BROWSER("360极速浏览器"),IE_BROWSER("ie");
	private String name;

	private BrowserType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	//FIREFOX_BROWSER,CHROME_BROWSER,CHROME360_BROWSER;
}
