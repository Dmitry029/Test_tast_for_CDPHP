package com.epam.testTaskForCdphp.tests;

import com.epam.testTaskForCdphp.base.BasePage;
import com.epam.testTaskForCdphp.pages.Footer;
import com.epam.testTaskForCdphp.pages.MainPage;
import com.epam.testTaskForCdphp.utils.TestUtilities;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FacebookConnectionTest extends TestUtilities {

    @Test(description = "Check that after click on Facebook button at the bottom" +
            " of the page the Facebook site opens")

    public void verifyUrlOfFacebookSite() {
        String expectedUrl = "https://www.facebook.com/onlinerby";
        new MainPage(driver, log)
                .openPage()
                .scrollToBottom();
        new Footer(driver, log).switchToFacebook();
        assertEquals(new BasePage(driver, log).getPageUrl(), expectedUrl);
    }
}
