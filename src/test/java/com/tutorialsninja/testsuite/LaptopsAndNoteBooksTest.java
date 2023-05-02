package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.annotations.Test;

public class LaptopsAndNoteBooksTest  extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
    ShoppingCartPage shoppingCartpage = new ShoppingCartPage();
    AccountRegisterPage myAccountRegisterPage = new AccountRegisterPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverOnLaptopsAndNoteBooks();
        //1.2 Click on “Show All Laptops & Notebooks”
        laptopsAndNotebooksPage.clickOnShowAllLaptopAndNoteBooks();
        laptopsAndNotebooksPage.originalProductPrice();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHightoLow();
        laptopsAndNotebooksPage.afterSortByPrice();
        //1.4 Verify the Product price will arrange in High to Low order.
    }

}
