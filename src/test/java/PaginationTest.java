import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class PaginationTest {

    WebDriver driver;

    @BeforeEach
    public void Setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
       // options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void PaginationPageTest(){
        Pagination pagination = new Pagination(driver);
        pagination.navigate();
        int actual=0;

        //kattintgatni a gombra amíg tudok
        /*do{
            actual+=pagination.numberOfRows();
            pagination.clickNextLink();
        }
        while(!pagination.isLastPage());*/


        while(true){
            actual+=pagination.numberOfRows();
            if(pagination.isLastPage()){
                break;
            }
            pagination.clickNextLink();
        }

        Assertions.assertEquals(13,actual);

    }

    @Test
    public void PageSearchTest(){

    }
}
