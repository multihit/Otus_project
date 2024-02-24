package common;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import tools.WaitTools;

public abstract class AbsCommon {

    protected WebDriver driver;
    protected WaitTools waitTools;
    protected Actions actions;
    protected Faker faker;

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        waitTools = new WaitTools(driver);
        this.actions = new Actions(driver);
        this.faker = new Faker();
        PageFactory.initElements(driver, this);
    }

    public WebElement $(By by) {
        return driver.findElement(by);
    }

    public WebElement $(String locator) {
        By by = locator.startsWith("/") ? By.xpath(locator): By.cssSelector(locator);

        return this.$(by);
    }

}
