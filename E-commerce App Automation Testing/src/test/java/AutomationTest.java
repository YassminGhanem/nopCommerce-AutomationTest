import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationTest
{
    WebDriver driver= null;
    SoftAssert soft = new SoftAssert();
    RegistrationPom registration = new RegistrationPom();
    LoginPom login = new LoginPom();

    @BeforeTest
    public void OpenBrowser() throws InterruptedException
    {
        String chromePath = System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe ";
        System.setProperty("webdriver.chrome.driver",chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/?fbclid=IwAR0-uOjk4tMsRPEmEBoWkdbd3rGTP0r5amFTfAQPaVYfinpzqC9tj1u0PAQ");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void Registeration_ValidData() throws InterruptedException
    {
        driver.findElement(By.cssSelector("a[class=\"ico-register\"]")).click();
        driver.findElement(By.id("gender-female")).click();
        registration.registrationSteps(driver,"Yasmine","Ghanem","6",
                "May","1992","yasmine.ghanem@gmail.com","Test@1234","Test@1234" );
        driver.findElement(By.id("register-button")).click();
        Thread.sleep(4000);

        String expectedResult="Your registration completed";
        String actualResult = driver.findElement(By.cssSelector("div[class=\"result\"]")).getText();
        soft.assertEquals(actualResult,expectedResult);
        System.out.println("First Assertion");

        String expected = "Register";
        String actual = driver.findElement(By.cssSelector("div[class=\"page-title\"]")).getText();
        //System.out.println(actual);
        soft.assertTrue(actual.contains(expected));
        System.out.println("Second Assertion");
        Thread.sleep(4000);

    }

    @Test
    public void ResetPassword_ValidEmail_SucessReset() throws InterruptedException
    {
        driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
        driver.findElement(By.cssSelector("a[href=\"/passwordrecovery\"]")).click();
        login.email(driver).sendKeys("yasmine.ghanem@gmail.com");
        driver.findElement(By.name("send-email")).click();

        String expectedResult="Email with instructions has been sent to you.";
        String actualResult=driver.findElement(By.cssSelector("p[class=\"content\"]")).getText();
        System.out.println(actualResult);
        soft.assertTrue(actualResult.contains(expectedResult));
        Thread.sleep(1000);
    }

    @Test
    public void ValidLogin() throws InterruptedException
    {
        driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
        login.loginSteps(driver,"yasmine.ghanem@gmail.com","Test@1234");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(4000);


        soft.assertTrue(driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed());
        System.out.println("FA");

        soft.assertTrue(driver.findElement(By.cssSelector("a[class=\"ico-logout\"]")).isDisplayed());
        System.out.println("SA");
    }


    @Test
    public void SearchProduct() throws InterruptedException {
        driver.findElement(By.id("small-searchterms")).sendKeys("Apple MacBook");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        Thread.sleep(3000);
    }

    @Test
    public void ChangeCurrency() throws InterruptedException
    {
        Select currency = new Select(driver.findElement(By.id("customerCurrency")));
        currency.selectByVisibleText("Euro");
        Thread.sleep(3000);
    }

    @Test
    public void SelectDifferentCategories() throws InterruptedException
    {
        Actions action= new Actions(driver);
        WebElement category = driver.findElement(By.cssSelector("a[href=\"/computers\"]"));
        action.moveToElement(category).perform();
        WebElement subCategory = driver.findElement(By.cssSelector("a[href=\"/notebooks\"]"));
        action.moveToElement(subCategory).perform();
        subCategory.click();
        Thread.sleep(3000);
    }

    @Test
    public void FilterWithColor() throws InterruptedException
    {
        Actions action= new Actions(driver);
        WebElement mainCategory= driver.findElement(By.cssSelector("a[href=\"/apparel\"]"));
        action.moveToElement(mainCategory).perform();
        WebElement sub = driver.findElement(By.cssSelector("a[href=\"/shoes\"]"));
        action.moveToElement(sub).perform();
        sub.click();
        driver.findElement(By.id("attribute-option-15")).click();
        Thread.sleep(3000);
    }


    @AfterTest
    public void CloseBrowser()
    {
        driver.quit();
    }
}
