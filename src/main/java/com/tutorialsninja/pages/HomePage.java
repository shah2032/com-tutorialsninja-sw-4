package com.tutorialsninja.pages;

import com.tutorialsninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {
    By topMenu = By.xpath("//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*");
    By desktopsTab = By.linkText("Desktops");
    By laptopsAndNoteBooks = By.xpath("//a[text()='Laptops & Notebooks']");
    By components = By.xpath("//a[text()='Components']");
    By desktopText = By.xpath("//h2[contains(text(),'Desktops')]");
    By laptopsAndNotebooksText = By.xpath("//a[text()='Laptops & Notebooks']");
    By componentsText = By.xpath("//h2[contains(text(),'Components')])");
    public void selectMenu(String menu) {
        try {
            List<WebElement> list = driver.findElements(topMenu);
            for (WebElement listOfElement : list) {
                if (listOfElement.getText().equals(menu)) {
                    listOfElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> list = driver.findElements(topMenu);
        }

    }

    // 1.1 Mouse hover on “Desktops” Tab and click
    public void mouseHoverOnDesktopsTabAndClick() {
        mouseHoverToElementAndClick(desktopsTab);
    }

    //1.2 call selectMenu method and pass the menu = “Show All Desktops”

    // 1.3 Verify the text ‘Desktops’
    //  public void verifyDesktops(){


    public void mouseHoverOnLaptopsAndNoteBooks(){
        mouseHoverToElementAndClick(laptopsAndNoteBooks);
    }
    public void mouseHoverOnComponentsTabAngClick(){
        mouseHoverToElementAndClick(components);
    }

    public String getDesktopText(){
        return getTextFromElement(desktopText);
    }
    public  String getLaptopsAndNoteBooksText(){
        return getTextFromElement(laptopsAndNoteBooks);
    }
    public  String getComponentsText(){
        return getTextFromElement(componentsText);
    }


}