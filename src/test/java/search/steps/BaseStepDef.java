package search.steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import search.selenium.BaseSelenium;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.testng.Assert.assertTrue;

public class BaseStepDef extends BaseSelenium {
	/**
	 * Set search request to search field in Main Search Form
	 * 
	 * @param searchRequest
	 */
	@Given("^I set search request \"([^\"]*)\"$")
	public void iSetSearchRequest(String searchRequest) {
		driver.get("http://www.ebay.com");
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(searchRequest);
	}

	@When("^I perform search")
    public void iPerfomSearch() throws Throwable {    	
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(By.id("gh-btn")));    	
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		assertTrue(true);
    }

	@Then("^click the first \"([^\"]*)\" element in the search result grid$")
	public void ClickTheFirstElementInThSearchResultGrid(String firstElement) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='ListViewInner']/li[1]//a")));  
		driver.findElement(By.xpath("//ul[@id='ListViewInner']/li[1]//a")).click();
		assertTrue(true);
	}

	@Then("^click Add To Cart$")
	public void clickAddtoCart() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Add to cart')]"))); 
		driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		assertTrue(true);
	}
}
