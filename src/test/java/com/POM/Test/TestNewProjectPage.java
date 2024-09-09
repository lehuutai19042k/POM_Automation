package com.POM.Test;

import com.POM.PageManager.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNewProjectPage {
        private SignInPage signInPage;
        private DashboardPage dashboardPage;
        private ProjectsPage projectsPage;
        private NewProjectPage newProjectPage;
        private WebDriver driver;

        @BeforeClass
        public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://crm.anhtester.com/admin/authentication");
        }
        @Test (priority = 1)
        public void SignIn() throws Exception{
            signInPage = new SignInPage(driver);
            dashboardPage = signInPage.actionsSignIn("admin@example.com","123456");
        }
        @Test (priority = 2)
        public void Dashboard(){
            projectsPage = dashboardPage.actionsDashboardWithProjectsPage();
        }
        @Test (priority = 3)
        public void Projects(){
            newProjectPage = projectsPage.actionsProjectsPage();
        }
        @Test (priority = 4)
        public void NewProject(){
            newProjectPage.actionsNewProject();
        }
        @AfterClass
        public void tearDown(){
            driver.quit();
        }
}
