package com.epam.testTaskForCdphp.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static org.apache.logging.log4j.LogManager.getLogger;

@Listeners({TestListener.class})
public class BaseTest {
    protected WebDriver driver;
    protected Logger log;

    protected String testSuiteName;
    protected String testName;


    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setUp(Method method, @Optional("chrome") String browser,
            ITestContext ctx) {

        String testName = ctx.getCurrentXmlTest().getName();
        log = getLogger(testName);

        BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
        //driver = factory.getDriver();
        driver = factory.createDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        this.testSuiteName = ctx.getSuite().getName();
        this.testName = testName;
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        log.info("*** Close driver");
        // Close browser
        driver.quit();
    }
}
