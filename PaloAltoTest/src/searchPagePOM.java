import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class searchPagePOM {
WebDriver driver;
	
	By listViewResults = By.id("list-view");
	By sortByField = By.id("input-sort");
	By itemsList = By.xpath("/html/body/div[2]/div/div/div[3]/div");
	
	
	
    public searchPagePOM(WebDriver driver) {		
		this.driver = driver;		
	}
    
    public void sortSearchedResults(String sortType) {
    	List<String> itemNameList = new ArrayList<>();
    	
    	driver.findElement(listViewResults).click();
    	
    	Select sortSelect = new Select(driver.findElement(sortByField));
    	sortSelect.selectByVisibleText(sortType);
    	
    	List<WebElement> itemList =driver.findElements(itemsList);    	
    	
       	for (WebElement el : itemList) {			
			itemNameList.add(el.findElement(By.xpath("./div/div[2]/div/h4/a")).getText());						
		}	    		
    	
    	switch(sortType) {		
			case "Name (A - Z)" :				
				Assert.assertTrue("The results are not sorted alphabetically!",isSorted(itemNameList));
				System.out.println("The results are sorted alphabetically!");
				break;
			case "Name (Z - A)" :				
				break;
			case "Price (Low > High)" :			
				break;
			case "Price (High > Low)" :			
				break;
			case "Rating (Highest)" :			
				break;
			case "Rating (Lowest)" :			
				break;
			case "Model (A - Z)" :			
				break;
			case "Model (Z - A)" :			
				break;
			default :
				System.out.println("default");
			}    	
    }
    
    //get the list of string and check the list is sorted alphabetically
    private boolean isSorted(List<String> listOfStrings) {
        if (listOfStrings.size() == 1) {
            return true;
        }

        Iterator<String> iter = listOfStrings.iterator();
        String current, previous = iter.next();
        while (iter.hasNext()) {
            current = iter.next();
            if (previous.compareTo(current) > 0) {
                return false;
            }
            previous = current;
        }
        return true;
    }

}
