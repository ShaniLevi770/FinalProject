package utilities;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {

    @DataProvider(name = "data-provider-user")
    public Object[][] getDataObject(){
        return getDataFromCSV(getData("DDTFileWeb"));
    }


    @Step("Business Flow: Read CSV File")
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Step("Business Flow: Get Data From CSV")
    public static Object[][] getDataFromCSV (String filePath){
        Object[][] data= new Object[3][2];
        List<String>csvData=readCSV(filePath);
        for (int i=0;i<csvData.size();i++){
            data[i][0]=csvData.get(i).split(",")[0];
            data[i][1]=csvData.get(i).split(",")[1];
        }
        return data;
    }
}