package com.Prowareness;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.MouseDown;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class CompleteTestCase {

	WebDriver driver ;
	public CompleteTestCase() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void name() throws InterruptedException {
		System.setProperty("webdriver.firefox.profile", "default");
		driver = new FirefoxDriver();
		driver.get("https://live.agilecockpit.com/");
		Thread.sleep(5000);
	}
	@Test (priority = 1)
	public void login() {
		
		
	}
	@Test (priority = 2)
	public void NavigateToBackLog() throws InterruptedException {
		driver.findElement(By.id("liAppGallery_6")).click();
		Thread.sleep(5000);
	}
	@Test (priority = 3)
	public void CreateUserStory() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/New/Backlog/Backlog']")));
//		Thread.sleep(2000);
		WebElement AddItem = driver.findElement(By.id("add-product-backlog-item"));
		WebElement UserStory = driver.findElement(By.xpath("//*[@id='backlogtype-container']/div/ul/li/ul/li[3]"));
		
		new Actions(driver).moveToElement(AddItem)
							.moveToElement(UserStory)
							.click().build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("work-item-title")).sendKeys("HemaSundar");
		driver.findElement(By.xpath("//button[span='Save']")).click();
		Thread.sleep(3000);
	}
	@Test (priority = 4)
	public void CheckUser() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='product-backlog-pager']/a[5]")).click();
		Thread.sleep(3000);
		if (driver.findElement(By.xpath("//*[@id='product-backlog-items']/li[last()]/div/div[2]/p")).getAttribute("title").equals("HemaSundar")) {
			System.out.println("User Created Successfully");
		}
		else {
			System.out.println("Failed: "+driver.findElement(By.xpath("//*[@id='product-backlog-items']/li[last()]/div/div[2]/p")).getAttribute("title"));
		}
	}
	@Test (priority = 5)
	public void NavigateToTaskBoard() throws InterruptedException {
		driver.switchTo().defaultContent();
		driver.findElement(By.id("liAppGallery_8")).click();
		Thread.sleep(5000);
	}
	@Test (priority = 6)
	public void DragToInProcess() throws InterruptedException {
		
	}
	@Test (priority = 7)
	public void DragToDone() throws InterruptedException {
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/New/Taskboard']")));
		Thread.sleep(5000);
		

		WebElement InProgress = driver.findElement(By.id("task-48532"));
		WebElement inProgressText = driver.findElement(By.xpath("//li[@id='task-48532']/a"));
		WebElement Done = driver.findElement(By.xpath("//*[@id='row-36851']/td[4]/ul"));
		
		System.out.println("Sourse: "+driver.findElement(By.xpath("//li[@id='task-48532']/a")).getText());
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(InProgress).build().perform();
		Thread.sleep(2000);
		act.release(Done).build().perform();

	}
}