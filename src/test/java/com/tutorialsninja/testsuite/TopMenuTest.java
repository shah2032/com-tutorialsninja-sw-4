package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectMenu("Show AllDesktops");
        Assert.assertEquals(homePage.getDesktopText(),"Desktops","DeskTop text not found");
    }
        @Test
        public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
            homePage.mouseHoverOnLaptopsAndNoteBooks();
            homePage.selectMenu("Show AllLaptops & Notebooks");
            Assert.assertEquals(homePage.getLaptopsAndNoteBooksText(),"Laptops & Notebooks","Laptop text not found");
        }
           @Test
            public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
            homePage.mouseHoverOnComponentsTabAngClick();
            homePage.selectMenu("Show AllComponents");
            Assert.assertEquals(homePage.getComponentsText(),"Components","Components Text not found");

    }

}
