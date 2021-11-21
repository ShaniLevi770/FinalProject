package sanity;

import extensions.APIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.APIFlows;


@Listeners(utilities.Listeners.class)

public class StudentAPI extends CommonOps {


    @Test (description = "Test 01 - Get Student Properties")
    @Description ("This Test Verify Student Property")
    public static void test01_getStudentValues(){
        response=APIActions.get(getData("resourceOfStudent"));
        String back= APIFlows.getStudentProperty("/student/3", "firstName");
        Verifications.verifyTextVsText(back, "Reece" );

    }

    @Test(description = "Test 02 - Add New Students" ,dataProvider = "data-provider-user", dataProviderClass = utilities.ManageDDT_API.class)
    @Description ("This Test Adds Students From DDT File and Verify it")
    public static void test02_addStudent(String firstname, String lastname, String email, String programme) {
        APIFlows.postNewStudent(firstname,lastname,email, programme);
        String massage=response.print();
        Assert.assertTrue(massage.contains("Student added"));

    }

    @Test (description = "Test 03 - Update Last Student on the List and Verify it")
    @Description ("This Test Updates the Last Student and Verify it")
    public static void test03_updateStudent() {

        String lastStudentId=APIFlows.getIdOfLastStudents();
        APIFlows.updateNewStudent("Shani", "levi", "shani.levis@gmail.com", "Earth Science",getData("course1"), getData("course2"),getData("course3"), "/student/"+lastStudentId );
        Verifications.verifyTextVsText(APIFlows.getStudentProperty("/student/"+lastStudentId ,"email"), "shani.levis@gmail.com");
        System.out.println(response.getStatusCode());
        Verifications.verifyTextVsText(String.valueOf(response.getStatusCode()), "200");

    }
    @Test (description = "Test 04 - Delete the Last Student and Verify it")
    @Description ("This Test Deletes the Last Student and Verify it ")
    public static void test04_deleteLastStudent(){
        int studentsB4=APIFlows.getNoOfStudents();
        String lastid=APIFlows.getIdOfLastStudents();
        APIFlows.deleteStudent("/student/"+ lastid);
        int studentsAfter=APIFlows.getNoOfStudents();
        Assert.assertEquals(studentsAfter, (studentsB4-1) );
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}
