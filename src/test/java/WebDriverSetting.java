import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSetting {
    ChromeDriver driver;

    @Before
    public void  setup () {
        System.setProperty("webdriver.chrome.driver", "/Users/savinovin/Documents/chromedriver");
        driver = new ChromeDriver();
    }

    //@After  public void close () {driver.quit();}




}
