package com.POM.Test;

import com.POM.PageManager.AddNewLeads;
import com.POM.PageManager.DashboardPage;
import com.POM.PageManager.LeadsPage;
import com.POM.PageManager.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestAddNewLeads {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private LeadsPage leadsPage;
    private AddNewLeads addNewLeads;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://crm.anhtester.com/admin/authentication");
    }
    @org.testng.annotations.Test (priority = 1)
    public void SignIn() throws Exception{
        signInPage = new SignInPage(driver);
        dashboardPage = signInPage.actionsSignIn("admin@example.com","123456");
    }
    @org.testng.annotations.Test (priority = 2)
    public void Dashboard(){
        leadsPage = dashboardPage.actionsDashboardWithLeadsPage();
    }
    @org.testng.annotations.Test (priority = 3)
    public void Leads(){
        addNewLeads = leadsPage.actionsLeadsPage();
    }
    @org.testng.annotations.Test (priority = 4)
    public void AddNewLeads() throws Exception{
        addNewLeads.actionsAddNewLeads();
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
