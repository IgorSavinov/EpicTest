import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class EpicTest extends WebDriverSetting {


    @Test
    public void firstTest() throws InterruptedException {

        driver.get("https://ng.unitedline.net/");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("DID Logic - SIP trunk and DID numbers provider. DID numbers, premium local SIP trunk service - DIDLogic"));

        //клик по кнопке Синг-ап
        WebElement singUp = driver.findElement(By.className("sign-up"));
        singUp.click();

        //ожидание тайтла
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //сощдание юзера
        Random random = new Random();
        int n = random.nextInt(100)+1;
        String email = "testNG"+ n + "@ng.com";
        driver.findElement(By.name("user[email]")).sendKeys(email);
        System.out.println(n);

        //ожидания поля логина
        WebDriverWait waitLogin = new WebDriverWait(driver, 20);
        waitLogin.until(ExpectedConditions.visibilityOfElementLocated(By.name("user[password]")));

        //ввод логина и пароля
        driver.findElement(By.name("user[password]")).sendKeys("1234567");
        driver.findElement(By.name("user[password_confirmation]")).sendKeys("1234567");


        //клик на чекбокс и кнопку креате
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='user_terms']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", checkbox);

        WebElement create = driver.findElement(By.xpath("/html/body/section[4]/div/form/div[3]/input"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", create);

        // ожидаемый результат ( страница с выбором стран)
        String titleBuy = driver.getTitle();
        Assert.assertTrue(titleBuy.equals("DID Logic - SIP trunk and DID numbers provider. DID numbers, premium local SIP trunk service - DIDLogic"));


        //открытие сайта с почтой
        driver.get("https://ng.unitedline.net/mail/#");
        String titleMail = driver.getTitle();
        Assert.assertTrue(titleMail.equals("MailHog"));

        //ожидание письма
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Открытие письма
        WebDriverWait waitMain = new WebDriverWait(driver, 20);
        waitMain.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'message row')])[1]")));

        WebElement divMailReg = driver.findElement(By.xpath("(//div[contains(@class,'message row')])[1]"));
        divMailReg.click();

        //клик по ссылке
        WebDriverWait waitEmailReg = new WebDriverWait(driver, 20);
        waitEmailReg.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navbar-brand']")));

        WebElement linc = driver.findElement(By.xpath("(//a[contains(text(),'https://ng.unitedline.net/profile/activate?key')])[2]"));
        JavascriptExecutor executorLink = (JavascriptExecutor)driver;
        executorLink.executeScript("arguments[0].click();", linc);


        // ожидагие на странице майл
        WebDriverWait mailHog = new WebDriverWait(driver, 20);
        mailHog.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=\"col-md-2 col-sm-3\"])[1]"))) ;

        driver.get("https://ng.unitedline.net/");

        //первая влкадка
        String windows = driver.getWindowHandle();
        driver.switchTo().window(windows);

        //ожидание кнопки логин
        WebDriverWait singIn = new WebDriverWait(driver, 20);
        singIn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='sign-in'])"))) ;

        //клик на кнопку логин
        WebElement login = driver.findElement(By.xpath("(//a[@class='sign-in'])"));
        login.click();

        WebDriverWait waitTitle = new WebDriverWait(driver, 10);
        waitTitle.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));

        //авторизация (заполнение данных)
        driver.findElement(By.name("email")).sendKeys("testNG"+ n + "@ng.com");

        driver.findElement(By.name("password")).sendKeys("1234567");

        WebElement singInAuto = driver.findElement(By.xpath("/html/body/section[1]/div/form/div[3]/input"));
        JavascriptExecutor executorSingInAuto = (JavascriptExecutor)driver;
        executorSingInAuto.executeScript("arguments[0].click();", singInAuto);

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

        //клик по чекбоксу
        WebDriverWait waitNgNumber = new WebDriverWait(driver, 10);
        waitNgNumber.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"field-checkbox\"]"))) ;

        driver.findElement(By.xpath("(//div[@class=\"field-checkbox\"])[2]")).click();

        //клик по кнопке СетАп
        WebDriverWait waitNgNumberSetUp = new WebDriverWait(driver, 10);
        waitNgNumberSetUp.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"main-button-normal buy-number-table-setup-acc\"]"))) ;

        WebElement setUp = driver.findElement(By.xpath("//a[@onclick=\"go_to_plans()\"]"));
        JavascriptExecutor executorSetUp = (JavascriptExecutor)driver;
        executorSetUp.executeScript("arguments[0].click();", setUp );

        //переход на страницу выбора аккаунта
        WebDriverWait waitNgNumberAccount = new WebDriverWait(driver, 10);
        waitNgNumberAccount.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subscription-wizard-root\"]/div/div/div[3]/div[2]/div[2]/div[2]/button"))) ;

        //клик по кнопке выбора аккаунта
        WebElement select = driver.findElement(By.xpath("(//button[@class='submit-rate subscribe-wholesale'])[2]"));
        JavascriptExecutor executorSelect = (JavascriptExecutor)driver;
        executorSelect.executeScript("arguments[0].click();", select );

        //Клик по чекбоксу
        driver.findElement(By.xpath("(//div[@class=\"field-checkbox\"])[2]")).click();

        //клик по кнопке адд карт
        WebElement cart = driver.findElement(By.xpath("//span[text()='ADD TO CART']"));
        JavascriptExecutor executorCart = (JavascriptExecutor)driver;
        executorCart.executeScript("arguments[0].click();", cart );

        //клик по кнопке адд карт
        WebElement card = driver.findElement(By.xpath("//a[text()='Add card and checkout']"));
        JavascriptExecutor executorCard = (JavascriptExecutor)driver;
        executorCard.executeScript("arguments[0].click();", card );

        //ввод номера карты
        driver.findElement(By.xpath("//input[@id='ccnumber']")).sendKeys("4111111111111111");

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

        //клик по кнопке logout
        WebElement logout = driver.findElement(By.xpath("//a[@data-method=\"delete\"]"));
        logout.click();

        //Ожидание елемента кнопки
        WebDriverWait singInResPass = new WebDriverWait(driver, 20);
        singInResPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='sign-in'])"))) ;

        //клик на кнопку логин
        WebElement loginResPass = driver.findElement(By.xpath("(//a[@class='sign-in'])"));
        loginResPass.click();

        //ожидание полей ввода
        WebDriverWait mailResPass = new WebDriverWait(driver, 20);
        mailResPass.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))) ;

        //ввод логин пароль
        driver.findElement(By.name("email")).sendKeys("testNG"+ n + "@ng.com");

        driver.findElement(By.name("password")).sendKeys("12345678");

        //клик по кнопке ресторе пасворд
        WebElement restore = driver.findElement(By.xpath("/html/body/section[1]/div/form/div[3]/a[1]/span"));
        JavascriptExecutor executorRestore = (JavascriptExecutor)driver;
        executorRestore.executeScript("arguments[0].click();", restore);

        //ожидание поля ввода ресторе
        WebDriverWait passReminder = new WebDriverWait(driver, 20);
        passReminder.until(ExpectedConditions.visibilityOfElementLocated(By.name("password_reminder[email]"))) ;

        driver.findElement(By.name("password_reminder[email]")).sendKeys("testNG"+ n + "@ng.com");
        //клик по ресторе
        driver.findElement(By.xpath("(//input[@class='submit'])[3]")).click();

        //переход на почту
        driver.get("https://ng.unitedline.net/mail/#");
        String titleMails = driver.getTitle();
        Assert.assertTrue(titleMails.equals("MailHog"));

        //ожидание письма
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Открытие письма
        WebDriverWait waitMains = new WebDriverWait(driver, 20);
        waitMains.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'message row')])[1]")));

        WebElement divs = driver.findElement(By.xpath("(//div[contains(@class,'message row')])[1]"));
        divs.click();

        //клик по ссылке
        WebDriverWait waitUrl= new WebDriverWait(driver, 20);
        waitUrl.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("(//td[@class='ng-binding'])[2]"))));

        WebElement lincUrl = driver.findElement(By.xpath("(//a[contains(text(),'https://ng.unitedline.net/password_reminder')])[2]"));
        JavascriptExecutor executorLinkUrl = (JavascriptExecutor)driver;
        executorLinkUrl.executeScript("arguments[0].click();", lincUrl);

        //первая влкадка
        String windowsResPass = driver.getWindowHandle();
        driver.switchTo().window(windowsResPass);

        //кнопка возврата
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        //ожидание письма
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Письмо смены пароля
        WebDriverWait waitMainResPass = new WebDriverWait(driver, 20);
        waitMainResPass.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'New password')])[1]")));

        WebElement divResPass = driver.findElement(By.xpath("(//span[contains(text(),'New password')])[1]"));
        divResPass.click();

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
        driver.findElement(By.name("email")).sendKeys("testNG"+ n + "@ng.com");

        driver.findElement(By.name("password")).sendKeys(pass);
        //клик по синг ин
        driver.findElement(By.xpath("(//input[@class='submit'])[1]")).click();

        //клик по май аккаунт
        driver.findElement(By.xpath("//div[text()='My account']")).click();

        //клик по секьюрети сетинг
        driver.findElement(By.xpath("//a[@href=\"/profile/security\"]")).click();

        //ввод текущего пароля
        driver.findElement(By.xpath("//input[@id=\"password_change_old_password\"]")).sendKeys(pass);

        //ввод нового пароля
        driver.findElement(By.xpath("//input[@id=\"password_change_password\"]")).sendKeys("12345678");

        //подтверждение нового пароля
        driver.findElement(By.xpath("//input[@id=\"password_change_password_confirmation\"]")).sendKeys("12345678");

        //клик по кнопке сейв
        WebElement saveButton = driver.findElement(By.xpath("//a[@href='javascript:;']"));
        JavascriptExecutor executorSaveButton = (JavascriptExecutor)driver;
        executorSaveButton.executeScript("arguments[0].click();", saveButton);






    }

}