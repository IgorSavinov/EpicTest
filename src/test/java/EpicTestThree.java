import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EpicTestThree extends WebDriverSetting {

    @Test public void EpicTestThree () throws InterruptedException {
        driver.get("https://ng.unitedline.net/");

        Thread.sleep(5000);
        driver.manage().window().maximize();

        WebDriverWait singIn = new WebDriverWait(driver, 20);
        singIn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='sign-in'])"))) ;
        //клик на кнопку логин
        WebElement login = driver.findElement(By.xpath("(//a[@class='sign-in'])"));
        login.click();
        //ожидание полей ввода
        WebDriverWait mail = new WebDriverWait(driver, 20);
        mail.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))) ;
        //ввод логин пароль
        driver.findElement(By.name("email")).sendKeys("savinov@didlogic.com");

        driver.findElement(By.name("password")).sendKeys("simplepass");

        driver.findElement(By.xpath("(//input[@class='submit'])[1]")).click();

        // загрузка старницы выбора стран
        WebDriverWait waitHeaderBuy = new WebDriverWait(driver, 10);
        waitHeaderBuy.until(ExpectedConditions.visibilityOfElementLocated(By.className("header-wrapper"))) ;

        //выбор страны
        driver.findElement(By.id("ng-flag")).click();

        // загрузка городов Нигерии
        WebDriverWait waitNgFlag = new WebDriverWait(driver, 10);
        waitNgFlag.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))) ;

        //клик по нигерии
        driver.findElement(By.xpath("//*[@id=\"new_purchase\"]/div[6]/div/ul[1]/li/a")).click();

        //клик по чекбоксам номеров
        WebDriverWait waitNgNumber = new WebDriverWait(driver, 10);
        waitNgNumber.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"field-checkbox\"]"))) ;

        driver.findElement(By.xpath("(//div[@class=\"field-checkbox\"])[2]")).click();

        driver.findElement(By.xpath("(//div[@class=\"field-checkbox\"])[3]")).click();

        WebElement check3 = driver.findElement(By.xpath("(//div[@class=\"field-checkbox\"])[4]"));
        JavascriptExecutor executorCheck = (JavascriptExecutor)driver;
        executorCheck.executeScript("arguments[0].click();", check3 );

        //клик по кнопке

        WebDriverWait waitNgNumberAddCart = new WebDriverWait(driver, 10);
        waitNgNumberAddCart.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-button-normal buy-number-table-checkout autodisable submit-form']"))) ;

        WebElement addCart = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/form/div[9]/div[1]/div/a/span"));
        JavascriptExecutor executorAddCart = (JavascriptExecutor)driver;
        executorAddCart.executeScript("arguments[0].click();", addCart );

        //Клик по кнопке чекаут
        WebDriverWait waitNgNumberCheckout = new WebDriverWait(driver, 10);
        waitNgNumberCheckout.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-button-normal']"))) ;

        WebElement checkout = driver.findElement(By.xpath("//div[@class='main-button-normal']/a"));
        JavascriptExecutor executorCheckout = (JavascriptExecutor)driver;
        executorCheckout.executeScript("arguments[0].click();", checkout );

        Thread.sleep(10000);
        WebDriverWait waitCard = new WebDriverWait(driver, 10);
        waitCard.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ccnumber']"))) ;
        driver.findElement(By.xpath("//input[@id='ccnumber']")).sendKeys("4012888888881881");

        //клик по чекбоксу
        WebElement dropdown = driver.findElement(By.xpath("(//div[@class='Select-placeholder'])[2]"));
        dropdown.click();

        WebElement eyar = driver.findElement(By.xpath("(//div[@class='Select-option'])[3]"));
        eyar.click();

        //ввод
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/form/div[1]/div[1]/input[2]")).sendKeys("test test");

        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div/div/form/div[1]/div[2]/input")).sendKeys("123");

        //клик по кнопке алл кредит

        WebElement appCard  = driver.findElement(By.xpath("//button[@class='payment-card-submit-button']"));
        JavascriptExecutor appCredit = (JavascriptExecutor)driver;
        appCredit.executeScript("arguments[0].click();", appCard);


        Thread.sleep(10000);


        //driver.get("https://ng.unitedline.net/");

        //клик по вкладке пурчасед
       //Thread.sleep(10000);
       //WebDriverWait waitPurchased = new WebDriverWait(driver, 10);
       //waitPurchased.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"/purchases\"]"))) ;
       //driver.findElement(By.xpath("//a[@href=\"/purchases\"]")).click();








    }
}
