import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPom
{
       public WebElement firstName(WebDriver driver)
        {
            return driver.findElement(By.id("FirstName"));
        }

        public WebElement lastName(WebDriver driver)
        {
           return driver.findElement(By.id("LastName"));
        }

        public WebElement birthDateDay(WebDriver driver)
        {
            return driver.findElement(By.name("DateOfBirthDay"));
        }

        public WebElement birthDateMonth(WebDriver driver)
        {
            return driver.findElement(By.name("DateOfBirthMonth"));
        }
        public WebElement birthDateYear(WebDriver driver)
        {
            return driver.findElement(By.name("DateOfBirthYear"));
        }

        public WebElement email(WebDriver driver)
        {
            return driver.findElement(By.id("Email"));
        }

        public WebElement password(WebDriver driver)
        {
            return driver.findElement(By.id("Password"));
        }

        public WebElement confirmPassword(WebDriver driver)
        {
           return driver.findElement(By.id("ConfirmPassword"));
        }

        public void registrationSteps(WebDriver driver,String firstName,String lastName,String birthDateDay,
                                      String birthDateMonth, String birthDateYear,String email, String password, String confirmPassword)
        {
            firstName(driver).sendKeys(firstName);
            lastName(driver).sendKeys(lastName);
            birthDateDay(driver).sendKeys(birthDateDay);
            birthDateMonth(driver).sendKeys(birthDateMonth);
            birthDateYear(driver).sendKeys(birthDateYear);
            email(driver).sendKeys(email);
            password(driver).sendKeys(password);
            confirmPassword(driver).sendKeys(confirmPassword);
        }




}
