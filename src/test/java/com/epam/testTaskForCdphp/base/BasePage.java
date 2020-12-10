package com.epam.testTaskForCdphp.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.Set;

public class BasePage {
    public WebDriver driver;
    public Logger log;

    public BasePage(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
        PageFactory.initElements(driver, this);
    }

    public void openUrl(String url) {
        driver.get(url);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get title of current page.
     */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }


    /**
     * Switch to iFrame using it's locator.
     */
    protected void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    /**
     * Switch to top (default content).
     */
    protected void switchToTop() {
        driver.switchTo().defaultContent();
    }


    public void switchToWindowWithTitle(String expectedTitle) {
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) {
                    break;
                }
            }
        }
    }


    /**
     * Perform scroll to the bottom.
     */
    public void scrollToBottom() {
        log.info("*** Scrolling to the bottom of the page");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
