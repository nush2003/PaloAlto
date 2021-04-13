import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePagePOM {
	WebDriver driver;
	
	By currencyBtn = By.xpath("/html/body/nav/div/div[1]/form/div/button");
	By searchFiled = By.xpath("/html/body/header/div/div/div[2]/div/input");
	By searchBtn = By.xpath("/html/body/header/div/div/div[2]/div/span");
	By content = By.id("content");
	
	
    public homePagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
    
    public void searchAnItem(String itemName) {
    	//Verify the currency drop-down exists
    	driver.findElement(currencyBtn).isDisplayed();
    	
    	//type the text in the search box and click the button
    	driver.findElement(searchFiled).sendKeys(itemName);
    	driver.findElement(searchBtn).click();
    	
    	//Verify 'itemName' word is appears at search    	
    	Assert.assertTrue("Search for '" + itemName + "' was done wrong!",driver.findElement(content).getText().contains("Search - " + itemName)); 
    }
}
    	
   
    


