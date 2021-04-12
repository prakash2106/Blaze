package org.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPage extends BaseClassProject{
	public FirstPage() {
      PageFactory.initElements(driver,this);
}
	@FindBy(name="fromPort")
	private WebElement departfrom;
	
	@FindBy(name="toPort")
    private WebElement destination;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement findflights;

	public WebElement getDepartfrom() {
		return departfrom;
	}

	public WebElement getDestination() {
		return destination;
	}

	public WebElement getFindflights() {
		return findflights;
	}
	
}
