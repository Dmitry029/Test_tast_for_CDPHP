package com.epam.testTaskForCdphp.pages;

import com.epam.testTaskForCdphp.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AlertWithTip extends BasePage {

    @FindBy(css = ".product-tip__term")
    List<WebElement> tips;

    @FindBy(css = ".product-specs__title")
    WebElement specTitle;


    public AlertWithTip(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getTipTitle(String text) {
        String locator = String.format("//td[contains(text(),'%s')]//p[@class='product-tip__term']", text);
        return driver.findElement(By.xpath(locator)).getText();
    }

    public boolean isAlertWithTipDisplayed() {
        return tips.stream().anyMatch(WebElement::isDisplayed);
    }

    public AlertWithTip closeAlert() {
        specTitle.click();
        return this;
    }
}
