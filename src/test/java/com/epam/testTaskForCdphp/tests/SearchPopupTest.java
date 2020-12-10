package com.epam.testTaskForCdphp.tests;

import com.epam.testTaskForCdphp.pages.MainPage;
import com.epam.testTaskForCdphp.pages.SearchPopup;
import com.epam.testTaskForCdphp.utils.TestUtilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SearchPopupTest extends TestUtilities {

    @Test(priority = 1)
    public void verifyAllResultsContainSearchedText() {
        String searchProduct = "Amazone Дуб Престиж";
        boolean result = new MainPage(driver, log)
                .openPage()
                .enterTextIntoSearchArea(searchProduct)
                .ifAllResultsContainText(searchProduct);
        assertTrue(result);
    }

    @Test(priority = 2)
    public void verifyPopupStatus() {
        SearchPopup searchPopup = new SearchPopup(driver, log);
        assertTrue(searchPopup.isPopUpClosed());
        takeScreenshot("visiblePopup");
        searchPopup.closePopup();
        takeScreenshot("invisiblePopup");
        assertFalse(searchPopup.isPopUpClosed());
    }
}
