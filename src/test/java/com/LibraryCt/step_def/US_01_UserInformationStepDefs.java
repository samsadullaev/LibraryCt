package com.LibraryCt.step_def;

import com.LibraryCt.Pages.LoginPage;
import com.LibraryCt.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US_01_UserInformationStepDefs {
    String actualResult;
    LoginPage loginPage= new LoginPage();

    //LoginPage login= new LoginPage();
    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        DB_Util.createConnection();
        loginPage.login("student40@library", "ZkFJCgOd");

    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {
        String query1= "select count(id) from users";

        DB_Util.runQuery(query1);

        actualResult= DB_Util.getFirstRowFirstColumn();

        System.out.println("actualResult= "+ actualResult);


    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        String query2="select count(distinct id) from users";

        DB_Util.runQuery(query2);

        String expectedResult= DB_Util.getCellValue(1,1);
        System.out.println("expectedResult= "+ expectedResult);

        Assert.assertEquals(expectedResult, actualResult);


    }

    List<String> actualList;
    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users");
        actualList= DB_Util.getAllColumnNamesAsList();
        //List<String> allColumnNameAsList = DB_Util.getAllColumnNamesAsList();
        System.out.println("actualList= "+ actualList);

    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedList) {
        Assert.assertEquals(expectedList, actualList);

        System.out.println("expectedList= "+expectedList);

    }


}
