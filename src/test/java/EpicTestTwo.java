import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class EpicTestTwo extends WebDriverSetting {

    @Test
    public void SecondTest () throws  InterruptedException {

        driver.get("https://ng.unitedline.net/");
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
        driver.findElement(By.name("email")).sendKeys("testNG"+ 80 + "@ng.com");

        driver.findElement(By.name("password")).sendKeys("12345678");

        //клик по кнопке ресторе пасворд
        WebElement restore = driver.findElement(By.xpath("/html/body/section[1]/div/form/div[3]/a[1]/span"));
        JavascriptExecutor executorRestore = (JavascriptExecutor)driver;
        executorRestore.executeScript("arguments[0].click();", restore);

        //ожидание поля ввода ресторе
        WebDriverWait passReminder = new WebDriverWait(driver, 20);
        passReminder.until(ExpectedConditions.visibilityOfElementLocated(By.name("password_reminder[email]"))) ;

        driver.findElement(By.name("password_reminder[email]")).sendKeys("testNG"+ 80 + "@ng.com");
        //клик по ресторе
        driver.findElement(By.xpath("(//input[@class='submit'])[3]")).click();

        //переход на почту
        Thread.sleep(5000);
        driver.get("https://ng.unitedline.net/mail/#");
        Thread.sleep(5000);
        String titleMail = driver.getTitle();
        Assert.assertTrue(titleMail.equals("MailHog"));

        //ожидание письма
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Открытие письма
        WebDriverWait waitMain = new WebDriverWait(driver, 20);
        waitMain.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'message row')])[1]")));

        WebElement div = driver.findElement(By.xpath("(//div[contains(@class,'message row')])[1]"));
        div.click();


        //клик по ссылке
        WebDriverWait waitUrl= new WebDriverWait(driver, 20);
        waitUrl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//td[@class='ng-binding'])[2]"))));

        WebElement lincUrl = driver.findElement(By.xpath("(//a[contains(text(),'https://ng.unitedline.net/password_reminder')])[2]"));
        JavascriptExecutor executorLinkUrl = (JavascriptExecutor)driver;
        executorLinkUrl.executeScript("arguments[0].click();", lincUrl);

        //первая влкадка
        String windows = driver.getWindowHandle();
        driver.switchTo().window(windows);

        //переход на сайт
        driver.get("https://ng.unitedline.net/mail/#");
        Thread.sleep(5000);
        WebDriverWait waitMainPass = new WebDriverWait(driver, 20);
        waitMainPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'New password')])[1]")));
        //Письмо смены пароля
        WebElement divPass = driver.findElement(By.xpath("(//span[contains(text(),'New password')])[1]"));
        divPass.click();

        //получение нового пароля
        driver.switchTo().frame(0);;
       String pass = driver.findElement(By.xpath("//span[@id='new-password']")).getText();
      System.out.println(pass);

      //переход на сайт
        driver.get("https://ng.unitedline.net/");

        WebDriverWait singInNewPass = new WebDriverWait(driver, 20);
        singInNewPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='sign-in'])"))) ;
        //клик на кнопку логин
        WebElement loginNewPass = driver.findElement(By.xpath("(//a[@class='sign-in'])"));
        loginNewPass.click();
        //ожидание полей ввода
        WebDriverWait mailNewPass = new WebDriverWait(driver, 20);
        mailNewPass.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))) ;
        //ввод логин пароль
        driver.findElement(By.name("email")).sendKeys("testNG"+ 80 + "@ng.com");

        driver.findElement(By.name("password")).sendKeys(pass);
        //клик по синг ин
        driver.findElement(By.xpath("(//input[@class='submit'])[1]")).click();

        //клик по май аккаунт
        driver.findElement(By.xpath("//div[text()='My account']")).click();

        //клик по секьюрети сетинг
        driver.findElement(By.xpath("//a[@href=\"/profile/security\"]")).click();

        //ввод текущего пароля
        driver.findElement(By.xpath("//input[@id=\"password_change_old_password\"]")).sendKeys(pass);

        //Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id=\"password_change_password\"]")).sendKeys("12345678");

        //Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id=\"password_change_password_confirmation\"]")).sendKeys("12345678");

        //Thread.sleep(500);

        WebElement saveButton = driver.findElement(By.xpath("//a[@href='javascript:;']"));
        JavascriptExecutor executorSaveButton = (JavascriptExecutor)driver;
        executorSaveButton.executeScript("arguments[0].click();", saveButton);




    }
}
