package com.LibraryCt.step_def;

import com.LibraryCt.Pages.DashBoardPage;
import com.LibraryCt.Pages.LoginPage;
import com.LibraryCt.utilities.BrowserUtils;
import com.LibraryCt.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.PageFactory;

import java.sql.*;
import java.util.List;

public class genreBooksBorrowedMost {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    BrowserUtils db_util = new BrowserUtils();

    Statement statement;
    Connection conn;

    ResultSet rs;

    ResultSetMetaData rsmd;
    @Given("Establish the database connection")
    public void establish_the_database_connection() throws SQLException{

        loginPage.login("librarian");



//        conn = DriverManager.getConnection("jdbc:mysql://34.230.35.214:3306/library2", "library2_client", "6s2LQQTjBcGFfDhY");
//
//        //helps us execute queries
//         statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//
//        //resultset will store data after execution. stores only data



    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() throws SQLException {

      DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
              "    inner  join books b on bb.book_id = b.id\n" +
              "    inner join book_categories bc on b.book_category_id=bc.id\n" +
              "group by name\n" +
              "order by 2 desc");
//
//         rs = statement.executeQuery("select bc.name,count(*) from book_borrow bb\n" +
//                 "    inner  join books b on bb.book_id = b.id\n" +
//                 "    inner join book_categories bc on b.book_category_id=bc.id\n" +
//                 "group by name\n" +
//                 "order by 2 desc");
//         rsmd = rs.getMetaData();


    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String string) throws SQLException {

        String  actualGenre = DB_Util.getFirstRowFirstColumn();
        System.out.println(actualGenre);

        Assertions.assertEquals(actualGenre,string);


//        while (rs.next()) {
//
//           for(int i = 1; i<=rsmd.getColumnCount();i++){
//
//               String actual = rsmd.getColumnName(i) + rs.getString(i);
//
//               if(actual.equals(string)){
//                   Assertions.assertEquals(string,actual);
//               }
//
//           }



        }
    }


