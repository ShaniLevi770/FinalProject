package workflow;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.List;


public class ElectronFlow extends CommonOps {

    @Step(" Business Flow: Add New Task To the List")
    public static void addNewTask(String taskName) {
        UIActions.updateText(todoMainPage.get_txt_craete(), taskName);
        UIActions.insertKey(todoMainPage.get_txt_craete(), Keys.RETURN);
    }

    @Step("Business Flow: Empty Tasks List ")
    public static void EmptyList() {
        for (int i=0; i<=getNumberOfTasks();i++){
            UIActions.click(todoMainPage.get_btn_delete());
        }
    }

    @Step("Business Flow: Count and Return Number Of Tasks ")
    public static int getNumberOfTasks() {
        return todoMainPage.get_general_task_list().size();
    }

    @Step("Business Flow: Check Task is DONE and verifies it moved to the Bottom of the List")
    public static void taskIsDone(int Taskindex) {
        UIActions.click(todoMainPage.get_task_check().get(Taskindex));
    }

    @Step("Business Flow: Check All Tasks are DONE and verify it")
    public static void alltasks_Done() {
        UIActions.click(todoMainPage.get_btn_allCompleted());
    }

    @Step("Business Flow: Get Tasks Name")
    public static List<String> get_tasksName() {
        List<String> tasks =  new ArrayList<String>();
        for (int i=0; i<getNumberOfTasks();i++){
            tasks.add(todoMainPage.get_task_namelist().get(i).getText());
            System.out.println(tasks);
        }
        return tasks;
    }

}


