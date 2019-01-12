package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {

    public void waitForVisibility(WebDriver driver, WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsClickable(WebDriver driver, WebElement element) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementTextEquals(WebDriver driver, WebElement element, String text) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
    }
}
