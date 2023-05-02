package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DesktopsTest extends BaseTest {
    DesktopPage desktopPage = new DesktopPage();

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        desktopPage.mousehoverOnDeskTops();
        desktopPage.clickOnShowAllDesktops();
        desktopPage.selectSortByPosition();


    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        desktopPage.mousehoverOnDeskTops();
        desktopPage.clickOnShowAllDesktops();
        desktopPage.selectSortByPositionAtoZ();
        desktopPage.selectHpProduct();

        desktopPage.deliveryDate();
        waitUntilVisibilityOfElementLocated(By.id("input-option225"),5);
        desktopPage.addToCart();
        desktopPage.clickOnShoppingCartMessage();



    }
}