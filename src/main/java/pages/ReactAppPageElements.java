package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ReactAppPageElements extends BasePage {

    public ReactAppPageElements(WebDriver driver) {
        super(driver);
    }

    public void start (){
        $("//button[@class='Button_btn__sIYYr']").click();
    }
    public void navigateReact(){
        driver.get("https://automation-test-starnavi.netlify.app/");
    }
    public void getEasyBTN(){
        new Select($("//select[@class='Select_select__y1CZ9']")).selectByValue("Easy");
    }
}