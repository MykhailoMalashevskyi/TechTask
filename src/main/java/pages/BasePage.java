package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement $(String locator) {
        return this.driver.findElement(By.xpath(locator));
    }
    public List<WebElement> $$(String locator) {
        return this.driver.findElements(By.xpath(locator));
    }
}