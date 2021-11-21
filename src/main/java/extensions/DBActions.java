package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step ("Get Credentials from DataBase")
    public  static  List<String> getCrdentials (String query){
    List<String> credentials = new ArrayList<String>();
    try {
        rs= stat.executeQuery(query);
        rs.next();
        credentials.add(rs.getString(1));
        credentials.add(rs.getString(2));


    } catch (Exception e) {
        System.out.println("Error Occurred while Connecting to DB, See Details :"+ e);
    }
    return credentials;
}


    @Step ("Extract E- mail Adress from DataBase")
    public  static  String get_email (String query){
        String email = "";
        try {
            rs= stat.executeQuery(query);
            rs.next();
            email=rs.getString(1);


        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details :"+ e);
        }
        return email;
    }
}
