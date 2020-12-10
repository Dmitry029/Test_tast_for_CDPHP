package com.epam.testTaskForCdphp.tests;

import com.epam.testTaskForCdphp.pages.AlertWithTip;
import com.epam.testTaskForCdphp.pages.MainPage;
import com.epam.testTaskForCdphp.utils.TestUtilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class AlertTest extends TestUtilities {

    @Test(priority = 1)
    public void verifyAlertWithTheGivenTextIsDisplayed() {
        String searchProduct = "Amazone Дуб Престиж";
        String searchTipForDescription = "Класс нагрузки";
        String expectedTipTitle = "Класс нагрузки";

        String actualTipTitle = new MainPage(driver, log)
                .openPage()
                .enterTextIntoSearchArea(searchProduct)
                .selectSearchResultByNumber(1)
                .openProductTip(searchTipForDescription)
                .getTipTitle(searchTipForDescription);
        assertTrue(actualTipTitle.contains(expectedTipTitle));
    }

    @Test(priority = 2)
    public void verifyAlertStatus() {
        AlertWithTip alertWithTip = new AlertWithTip(driver, log);
        assertTrue(alertWithTip.isAlertWithTipDisplayed());
        alertWithTip.scrollToBottom();
        takeScreenshot("visibleAlert");
        alertWithTip.closeAlert();
        takeScreenshot("invisibleAlert");
        assertFalse(alertWithTip.isAlertWithTipDisplayed());
    }
}
