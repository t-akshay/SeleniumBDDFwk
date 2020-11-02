package runnerFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import PICOContainers.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends TestContext{
	private TestContext testContext;
	
	public Hooks(TestContext testContext) 
	{
		this.testContext = testContext;
	}
	
	   @Before
	   public void setUp()
	   { 
	      System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Selenium\\chromedriver_win32\\chromedriver.exe");
	      ChromeOptions options = new ChromeOptions();
	      options.addArguments("start-maximized");
	      WebDriver driver = new ChromeDriver(options);
	      testContext.setDriver(driver);	      
	   } 
	   
	   @After
	   public void cleanUp()
	   { 
		   testContext.getDriver().close();
		   testContext.getDriver().quit();
	   }
}
