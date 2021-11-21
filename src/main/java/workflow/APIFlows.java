package workflow;

import extensions.APIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.ArrayList;
import java.util.List;


public class APIFlows extends CommonOps {
    @Step("Business Flow -Get Student Property")
    public static String getStudentProperty(String get, String jPath) {
        response = APIActions.get(get);
        return APIActions.extractFromJson(response, jPath);
    }

    @Step("Business Flow - Get Id Of Last Student")
    public static String getIdOfLastStudents() {
        response=APIActions.get("/student/");
        String toList= response.asString();
        String [] studentList = toList.split("\\}");
        int lastnumber=(studentList.length)-2;
        String A=studentList[lastnumber].split(":")[1];
        String lastid=A.split(",")[0];
        return lastid;
    }

    @Step("Business Flow - Get No. Of Students")
    public static int getNoOfStudents() {
        response=APIActions.get("/student/");
        String toList= response.asString();
        String [] studentList = toList.split("\\}");
        int sumOfStudents=(studentList.length)-2;
        return sumOfStudents;
    }

    @Step("Business Flow - Post New Student ")
    public static void postNewStudent(String firstName, String lastName, String email, String programme) {

        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("email", email);
        parameters.put("programme", programme);
        APIActions.post(parameters, "/student");

    }


    @Step("Business Flow - Update New Student ")
    public static void updateNewStudent(String firstName, String lastName, String email, String programme,String course1,String course2,String course3, String resource1) {
        parameters.put("firstName", firstName);
        parameters.put("lastName", lastName);
        parameters.put("email", email);
        parameters.put("programme", programme);
        List<String> coursesList = new ArrayList<String>();
        coursesList.add(course1);
        coursesList.add(course2);
        coursesList.add(course3);
        parameters.put("courses", coursesList);
        APIActions.update(parameters, resource1);
    }

    @Step("Business Flow - Delete New Student ")
    public static void deleteStudent( String resource) {
        APIActions.delete(resource);
    }


}
