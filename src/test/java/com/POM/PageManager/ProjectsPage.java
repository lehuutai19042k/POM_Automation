package com.POM.PageManager;

import HelpsPOM.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    private By spanProjects = By.xpath("//*[@id=\"side-menu\"]/li[8]");
    private By buttonNewProject = By.xpath("//*[@id=\"vueApp\"]/div/div/div[1]/a[1]");
    public NewProjectPage actionsProjectsPage(){
        validateHelper.verifyUrl("/projects");
        validateHelper.verifyHighLight(spanProjects,"class","active");
        validateHelper.clickElement(buttonNewProject);
        return new NewProjectPage(driver);
    }
}
