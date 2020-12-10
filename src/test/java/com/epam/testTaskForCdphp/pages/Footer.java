package com.epam.testTaskForCdphp.pages;

import com.epam.testTaskForCdphp.base.BasePage;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends BasePage {

    @FindBy(css = "[class*=button_fb]")
    WebElement facebookLink;


    public Footer(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void switchToFacebook() {
        facebookLink.click();
        log.info("*** Click Facebook icon");
        switchToWindowWithTitle("Onliner - Home | Facebook");
    }
}
