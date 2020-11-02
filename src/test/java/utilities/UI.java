package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import PICOContainers.TestContext;

public class UI {
	
	private TestContext testContext;
	private JavascriptExecutor js;
	
	public UI(TestContext testContext)
	{
		this.testContext = testContext;
	}
	
	public WebElement element(String selector)
	{
		WebElement element;
		try 
		{
			element = testContext.getDriver().findElement(By.cssSelector(selector));
			return element;
		}
		catch(Exception a) 
		{
			try {
				element = testContext.getDriver().findElement(By.xpath(selector));
				return element;
			}
			catch(Exception b)
			{
				try {
					element = testContext.getDriver().findElement(By.id(selector));
					return element;
				}
				catch(Exception c)
				{
					try {
						element = testContext.getDriver().findElement(By.name(selector));
						return element;
					}
					catch(Exception d)
					{
						try {
							element = testContext.getDriver().findElement(By.className(selector));
							return element;
						}
						catch(Exception e)
						{
							try {
								element = testContext.getDriver().findElement(By.linkText(selector));
								return element;
							}
							catch(Exception f){
								try {
									element = testContext.getDriver().findElement(By.partialLinkText(selector));
									return element;
								}
								catch(Exception g)
								{
									try {
										element = testContext.getDriver().findElement(By.xpath("//*[text()='"+selector+"']"));
										return element;
									}
									catch(Exception h)
									{
										System.out.println("Element "+selector+" not found"+"\\n"+h);
										return null;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public List<WebElement> elements(String selector)
	{
		List<WebElement> elements;
		try 
		{
			elements = testContext.getDriver().findElements(By.cssSelector(selector));
			return elements;
		}
		catch(Exception a) 
		{
			try {
				elements = testContext.getDriver().findElements(By.xpath(selector));
				return elements;
			}
			catch(Exception b)
			{
				try {
					elements = testContext.getDriver().findElements(By.id(selector));
					return elements;
				}
				catch(Exception c)
				{
					try {
						elements = testContext.getDriver().findElements(By.name(selector));
						return elements;
					}
					catch(Exception d)
					{
						try {
							elements = testContext.getDriver().findElements(By.className(selector));
							return elements;
						}
						catch(Exception e)
						{
							try {
								elements = testContext.getDriver().findElements(By.linkText(selector));
								return elements;
							}
							catch(Exception f){
								try {
									elements = testContext.getDriver().findElements(By.partialLinkText(selector));
									return elements;
								}
								catch(Exception g)
								{
									try {
										elements = testContext.getDriver().findElements(By.xpath("//*[text()='"+selector+"']"));
										return elements;
									}
									catch(Exception h)
									{
										System.out.println("Element "+selector+" not found"+"\\n"+h);
										return null;
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	public void click(String selector) 
	{
		WebElement element = element(selector);
		try 
		{
			element.click();
			sleep(1);
		}
		catch(Exception e1)
		{
			try 
			{
				js = (JavascriptExecutor)testContext.getDriver();
				js.executeScript("arguments[0].click();", element);
				sleep(1);
			}
			catch(Exception e2)
			{
				System.out.println("Exception occured on click event on"+selector+"\n"+e2);
			}
		}
	}
	
	public void scrollToPageBottom() 
	{
		js = (JavascriptExecutor)testContext.getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void sleep(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}
