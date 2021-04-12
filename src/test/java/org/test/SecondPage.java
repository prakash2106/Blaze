package org.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecondPage extends BaseClassProject {
	public SecondPage() {
     PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table//td[6]")
	private List<WebElement> txtprice;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	private WebElement clkflight;

	public List<WebElement> getTxtprice() {
		return txtprice;
	}

	public WebElement getClkflight() {
		return clkflight;
	}
	
	
	

}
