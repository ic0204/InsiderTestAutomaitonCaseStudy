import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;


public class MySteps extends BasePage {
    WebSteps websteps;

    @Parameters({"Browser"})
    @Test(priority = 1)
    public void initializeDriver(String browser) {
        websteps = new WebSteps();
        websteps.initializeDriver(browser);
    }

    @Parameters({"URL"})
    @Test(priority = 2)
    public void gotoURL(String url) {
        websteps.openUrl(url);
    }

    @Parameters({"SeePage", "acceptAllForCookies"})
    @Test(priority = 3)
    public void checkHomePage(String page, String acceptAllForCookies) {
        websteps.seePage(page);
        try {
            websteps.clickElement(acceptAllForCookies, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(websteps.driver.getTitle(), "Insider personalization engine for seamless customer experiences");
        System.out.println(" We are at Insider Home Page");
    }

    @Parameters({"moreItem"})
    @Test(priority = 4)
    public void clickAnItemFromMenuForMoreItem(String more) throws InterruptedException {
        websteps.clickElement(more, 5);
        System.out.println("Click " + more + " on Menu Navigation bar");
    }

    @Parameters({"careerItemFromNavigationBar"})
    @Test(priority = 5)
    public void clickCareersFromMenu(String career) throws InterruptedException {
        websteps.clickElement(career, 0);
        System.out.println("Click " + career + " on Menu Navigation bar");
    }

    @Parameters({"careerPage"})
    @Test(priority = 6)
    public void checkCareerPage(String careerPage) {
        websteps.seePage(careerPage);
        Assert.assertEquals(websteps.driver.getTitle(), "Insider Careers");
        System.out.println(" We are at Insider Career Page");
    }

    @Parameters({"locationTitle"})
    @Test(priority = 7)
    public void isOpenedLocationTittleOnTheCareerPage(String locationTitle) {
        Assert.assertTrue(websteps.isDisplayedElement(locationTitle, 0));

    }

    @Parameters({"teamTitle"})
    @Test(priority = 8)
    public void isOpenedTeamTitleOnTheCareerPage(String teamTitle) {
        Assert.assertTrue(websteps.isDisplayedElement(teamTitle, 0));
    }

    @Parameters({"lifeAtInsiderTitle"})
    @Test(priority = 9)
    public void isOpenedLifeAtInsiderTitleOnTheCareerPage(String lifeAtInsiderTitle) {
        Assert.assertTrue(websteps.isDisplayedElement(lifeAtInsiderTitle, 0));
    }

    @Parameters({"seeAllTeamButton", "qAItem", "seeAllQaJobsButton"})
    @Test(priority = 10)
    public void goToQualityAssurancePage(String seeAllTeamButton, String qAItem, String seeAllQaJobsButton) throws InterruptedException {
        websteps.clickElement(seeAllTeamButton, 0);
        Assert.assertTrue(websteps.isEnabledElement(qAItem, 0));
        System.out.println("After it was clicked see all team button, We could see QA item");
        websteps.clickElement(qAItem, 0);
        Assert.assertEquals(websteps.driver.getTitle(), "Insider quality assurance job opportunities");
        System.out.println("Open the Insider Quality Assurance Job Opportunities Page");


    }

    @Parameters({"qaPage", "seeAllQaJobs"})
    @Test(priority = 11)
    public void seeAllQaJobs(String qaPage, String seeAllQaJobs) throws InterruptedException {
        websteps.seePage(qaPage);
        websteps.clickElement(seeAllQaJobs, 0);
        Assert.assertEquals(websteps.driver.getTitle(), "Insider Open Positions | Insider");
        System.out.println("Open the Insider Open Positions | Insider Page");

    }

    @Parameters({"openPosition", "closedLocationDropBox", "openedLocationDropBox"})
    @Test(priority = 12)
    public void filteringQaJobsLocatedInIstanbul(String openPosition, String closedLocationDropBox, String openedLocationDropBox) throws InterruptedException {
        websteps.seePage(openPosition);
        websteps.clickElement(closedLocationDropBox, 0);
        websteps.selectDropDownBoxItem(openedLocationDropBox, 3);
    }


    @Parameters({"qAPosition", "applyButton"})
    @Test(priority = 13)
    public void selectQAPositionLocatedInIstanbul(String qAPosition, String applyButton) throws InterruptedException {
        websteps.clickElement(qAPosition, 0);
        websteps.clickElement(applyButton, 0);
        websteps.goToOtherTab();
        Assert.assertEquals(websteps.driver.getTitle(), "Insider. - Software Quality Assurance Engineer");
        System.out.println("We are in Lever Application Page");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            WebSteps.takeScreenShot(websteps.driver, result.getName());
        }
    }

    @AfterSuite
    public void closeBrowser() throws IOException {
        Runtime.getRuntime().exec("taskkill /F /IM " + websteps.browserExe);
        System.out.println(" All tabs are closed.");

    }

}
