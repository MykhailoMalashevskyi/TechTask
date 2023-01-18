package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ReactAppPageActions;
import pages.ReactAppPageAssertions;
import pages.ReactAppPageElements;

import java.time.Duration;
import java.util.List;

public class TestReactApp extends BaseTest {

    private final String blue = "#4682b4";
    private final String white = "#000000";

    @Test
    public void checkApp(){
        ReactAppPageElements reactAppPageElements = new ReactAppPageElements(driver);
        ReactAppPageAssertions reactAppPageAssertions = new ReactAppPageAssertions(driver);
        ReactAppPageActions reactAppPageActions = new ReactAppPageActions(driver);

        reactAppPageElements.navigateReact();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        reactAppPageElements.getEasyBTN();
        reactAppPageElements.start();
        reactAppPageAssertions.assertTableSize(5);

        List<List<WebElement>> lists = reactAppPageActions.getAllRowWithAllCells();
        reactAppPageActions.moveToCellInTable(lists, 1, 1);
        reactAppPageAssertions.assertCellChangeColor();
        reactAppPageAssertions.checkColour(lists, 1, 1, blue);
        reactAppPageActions.moveToStartEl();
        reactAppPageAssertions.assertSquaresSecond();
        reactAppPageAssertions.checkColour(lists, 1, 1, white);
    }
}