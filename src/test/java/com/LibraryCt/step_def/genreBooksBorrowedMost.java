package com.LibraryCt.step_def;

import com.LibraryCt.Pages.DashBoardPage;
import com.LibraryCt.Pages.LoginPage;
import com.LibraryCt.utilities.BrowserUtils;
import com.LibraryCt.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class genreBooksBorrowedMost {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    BrowserUtils db_util = new BrowserUtils();
    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        loginPage.login("librarian");

    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        DB_Util.runQuery("select name from book_categories\n" +
                "where name like 'Action and Adventure'");

    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String string) {



        String actual = DB_Util.getCellValue(0,0);

        Assertions.assertEquals(string,actual);
    }

}
