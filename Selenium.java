package com.selenium.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
	
	WebDriver driver;
	

	
	public void invokeBrowser(String username, String pass)
	{
		try {
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Nandini\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
			driver.get("https://www.edureka.co");
			driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div/a[2]")).click();
			driver.findElement(By.id("si_popup_email")).sendKeys(username);
			driver.findElement(By.id("si_popup_passwd")).sendKeys(pass);
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
	        String username = args[0];
	        String pass = args[1];
	    }
	    catch (ArrayIndexOutOfBoundsException e){
	        System.out.println("ArrayIndexOutOfBoundsException caught");
	    }
	    finally {

	    }
		Test test =new Test();
		test.invokeBrowser(args[0],args[1]);

	}

}
