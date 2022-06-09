import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginationSearch {
    WebDriver driver;
    private final String URL ="https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private final By searchBox = By.xpath("//*[@id=\"example_filter\"]/label/input");
    private final By table =By.xpath("//*[@id=\"example\"]/tbody/tr/td[1]");


    public PaginationSearch(WebDriver drv){
        this.driver= drv;
    }

    public void navigate(){
        driver.navigate().to(URL);
    }

    public void searchThis(String something){
        driver.findElement(searchBox).sendKeys(something);

    }


}
