import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Pagination {

    WebDriver driver;
    private final String URL ="https://demo.seleniumeasy.com/table-pagination-demo.html";
    private final By nextLink = By.xpath("//*[@class=\"next_link\"]");
    private  final By tableRowVisible = By.xpath("//*[@style=\"display: table-row;\"]");

    public Pagination(WebDriver drv){
        this.driver=drv;
    }

    public void navigate(){
        driver.navigate().to(URL);
    }

    public int numberOfRows(){
        int result=0;

        List <WebElement> row = driver.findElements(tableRowVisible);
        result=row.size();

        return result;
    }

    public boolean isLastPage(){
        String atr = driver.findElement(nextLink).getAttribute("style");
        return atr.equals("display: none;");
    }

    public void clickNextLink(){
        if(!isLastPage()) {
            driver.findElement(nextLink).click();
        }
    }

}
