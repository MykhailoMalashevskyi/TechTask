package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import java.util.List;

public class ReactAppPageAssertions extends BasePage {
    public ReactAppPageAssertions(WebDriver driver) {
        super(driver);
    }
    public void assertTableSize(int expectedTableSize){
        List<WebElement> allRowsFromTable = $$("//tr");
        Assert.assertEquals(allRowsFromTable.size(), expectedTableSize);
        for (int i = 1; i < expectedTableSize; i++) {
            List<WebElement> allCellsFromRow = $$(String.format("//tr[%s]//td", i));
            Assert.assertEquals(allCellsFromRow.size(), expectedTableSize);
        }
    }
    public void assertCellChangeColor(){
        List<WebElement> logger = $$("//div[@class='Logger_logsWrapper__ZmaZS']/p");
        Assert.assertEquals($$("//div[@class='Logger_logsWrapper__ZmaZS']/p").get(logger.size() - 1).getText(), "row 1 col 1");
    }
    public void checkColour(List<List<WebElement>> lists, int row, int column, String color){
        String colorSting = lists.get(--row).get(--column).getCssValue("background-color");
        Assert.assertEquals(Color.fromString(colorSting).asHex(), color);
    }
    public void assertSquaresSecond(){
        List<WebElement> logger = $$("//div[@class='Logger_logsWrapper__ZmaZS']/p");
        Assert.assertEquals($$("//div[@class='Logger_logsWrapper__ZmaZS']/p").get(logger.size() - 1).getText(), "row 1 col 1");
    }
}