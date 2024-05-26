package page;

import common.Configuration;
import org.openqa.selenium.WebDriver;

import common.TestBase;

public class Page {
    public WebDriver driverWeb;

    public TestBase testBase = new TestBase();

    public Configuration config = new Configuration(System.getProperty("user.dir")+ "/src/main/resources/" + "config.properties");

    public int timeout_Short = Integer.parseInt(config.getConfigValueByKey("timeout_Short"));
    public int timeout_Medium = Integer.parseInt(config.getConfigValueByKey("timeout_Medium"));
    public int timeout_Long = Integer.parseInt(config.getConfigValueByKey("timeout_Long"));
    /*
    public HomePage homePage = new HomePage(driverWeb);
    public AlertFrameWindowPage alertFrameWindowPage = new AlertFrameWindowPage(driverWeb);
    public AlertsPage alertsPage = new AlertsPage(driverWeb);
    //TODO: fix code
    public void goToAlertPages() {
        testBase.scrollToEndPage();
        homePage.clickAlertFrameWindow();
        alertFrameWindowPage.clickAlertsMenu();
        testBase.scrollToEndPage();
    }*/
    public Page(WebDriver dr) {
        testBase.driver = dr;
        this.driverWeb = testBase.driver;

    }
}
