package pages.weborderpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "Email")
    private WebElement username;
    private @FindBy(id = "Password")
    WebElement password;
    private @FindBy(xpath = "//button[.='Sign In']")
    WebElement signInButton;
    @FindBy(xpath = "//div[contains(text(),'Sign in Failed')]")
    WebElement errorMessage;

    public void login(String username,String password){
        this.username.clear();
        this.password.clear();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.signInButton.submit();
    }
    public boolean validateErrorMessage(String errorMessage){
        return this.errorMessage.getText().trim().equals(errorMessage);
    }
}
