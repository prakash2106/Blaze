package org.test;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Blaze extends BaseClassProject{
	BaseClassProject project;
	@BeforeClass
	private void browserLaunch() {
    getdriver();
    launchUrl("https://blazedemo.com/");
		//test new pull
	}
	@Parameters({"Departure city","Destination City"})
	@Test
	private void tc0(String s,String s1) throws Exception {
		FirstPage fp=new FirstPage();
		dropDown(fp.getDepartfrom(),"visibleText",s);
		dropDown(fp.getDestination(), "visibleText", s1);
		btnClick(fp.getFindflights());
	}
	@Test
	private void tc1() {
		SecondPage sp=new SecondPage();
		//driver.findElement(By.xpath("//table//tr[3]//td[6]"));
		for (int i = 0; i <sp.getTxtprice().size(); i++) {
//			System.out.println(sp.getTxtprice().get(i).getText());
			
			if(sp.getTxtprice().get(i).getText().contains("200")) {
				int indx = i+1;
				System.out.println(driver.findElement(By.xpath("//table//tr["+indx+"]//td[6]")).getText());
				driver.findElement(By.xpath("//table//tr["+indx+"]//td[1]//input[@type='submit']")).click();
				System.out.println(indx);
			}
				
		
//		if (sp.getTxtprice().contains("200.98")) {
//			sp.getClkflight().click();
//			
//		}
		}
     
	}
	

}
