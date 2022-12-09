package com.LibraryCt.step_def;

import com.LibraryCt.Pages.BookPage;
import com.LibraryCt.Pages.DashBoardPage;
import com.LibraryCt.Pages.LoginPage;
import com.LibraryCt.utilities.BrowserUtils;
import com.LibraryCt.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.sql.ResultSet;
import java.util.List;


public class Books_Categories_StepDef  {

    LoginPage loginPage= new LoginPage();
    DashBoardPage dashBoardPage= new DashBoardPage();

    BookPage bookPage= new BookPage();

    List<String> actualCategoryList;
    List<String> expectedCategories;




    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
     loginPage.login("librarian");



    }

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String moduleName) {
      dashBoardPage.navigateModule("Books");



    }

    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
       actualCategoryList= BrowserUtils.dropdownOptionsAsString(bookPage.mainCategoryElement);
       actualCategoryList.remove(0);


    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
       expectedCategories=DB_Util.getColumnDataAsList("name");


    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        Assert.assertEquals(expectedCategories,actualCategoryList);


    }


















}
