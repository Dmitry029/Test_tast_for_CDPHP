package com.epam.testTaskForCdphp.pages;

import com.epam.testTaskForCdphp.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DescriptionPage extends BasePage {

    public DescriptionPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public AlertWithTip openProductTip(String text) {
        String locator = String.format("//td[contains(text(),'%s')]/div/span", text);
        driver.findElement(By.xpath(locator)).click();
        log.info("*** Product tip is opened");
        return new AlertWithTip(driver, log);
    }
}
