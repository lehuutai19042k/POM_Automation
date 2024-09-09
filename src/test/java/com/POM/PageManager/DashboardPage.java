package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private WebDriverWait wait;
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By spanDashboard = By.xpath("//*[@id=\"side-menu\"]/li[2]");
    private By spanLeads = By.xpath("//*[@id=\"side-menu\"]/li[11]");
    private By spanProjects = By.xpath("//*[@id=\"side-menu\"]/li[8]");
    private By dashboardOptions = By.xpath("//*[@id=\"wrapper\"]/div[2]/svg");
    public LeadsPage actionsDashboardWithLeadsPage(){
        // Khó để verify waitForPageLoaded do trang DashboardPage có vấn đề
        /*validateHelper.verifyText(dashboardOptions,"Dashboard Options");*/
        validateHelper.verifyHighLight(spanDashboard,"class","active");
        validateHelper.clickElement(spanLeads);
        return new LeadsPage(driver);
    }
    public ProjectsPage actionsDashboardWithProjectsPage(){
        validateHelper.verifyHighLight(spanDashboard,"class","active");
        validateHelper.clickElement(spanProjects);
        return new ProjectsPage(driver);
    }
}
