package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class ReactAppPageActions extends BasePage {
    public ReactAppPageActions(WebDriver driver) {
        super(driver);
    }
    public void moveToCellInTable(List<List<WebElement>> lists, int row, int column) {
        Actions actions = new Actions(driver);
        actions.moveToElement(lists.get(--row).get(--column)).perform();
    }
    public List<List<WebElement>> getAllRowWithAllCells(){
        List<WebElement> listField = $$("//tr");
        return listField.stream().map(element -> element.findElements(By.cssSelector("td"))).collect(Collectors.toList());
    }
    public void moveToStartEl(){
        WebElement start =  $("//button[@class='Button_btn__sIYYr']");
        List<WebElement> listField = $$("//tr");
        List<List<WebElement>> lists = listField.stream().map(element -> element.findElements(By.cssSelector("td"))).collect(Collectors.toList());

        Actions actions = new Actions(driver);
        actions.moveToElement(start).moveToElement(lists.get(0).get(0)).perform();
    }
}
