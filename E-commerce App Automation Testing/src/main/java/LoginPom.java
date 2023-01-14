import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPom
{
    public WebElement email(WebDriver driver)
    {
       return driver.findElement(By.id("Email"));
    }

    public WebElement password(WebDriver driver)
    {
        return driver.findElement(By.id("Password"));
    }

    public void loginSteps(WebDriver driver, String email, String password)
    {
        email(driver).click();
        email(driver).sendKeys(email);

        password(driver).sendKeys(password);
        password(driver).sendKeys(Keys.ENTER);
    }





}
