package utilities;

import io.qameta.allure.Step;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends  CommonOps{


    @Step("Business Flow: Start Connection ")
    public  static  void startConnection(String dbURL, String user, String pass)  {
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(dbURL, user, pass);
           stat= con.createStatement();
       }catch (Exception e){
           System.out.println("Error Occurred while Connecting to DB, See Details :"+ e);
       }
    }

    @Step("Business Flow: Close Connection")
    public  static void closeConnection(){
        try{
            con.close();
        } catch(Exception e){
            System.out.println(" Error Occured while closing DB , See details : "+ e);
        }

    }
}
