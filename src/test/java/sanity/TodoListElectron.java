package sanity;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.ElectronFlow;
import java.util.concurrent.TimeUnit;

@Listeners(utilities.Listeners.class)
public class TodoListElectron extends CommonOps {

    @Test(description = " Test01 - Add and Verify New Task")
    @Description("This Test Adds New Task and Verify It")
    public void test01_addNewTask() {
        ElectronFlow.addNewTask("Play");
        ElectronFlow.addNewTask("Love");
        Verifications.verifyNumber(ElectronFlow.getNumberOfTasks(), 2);
    }

    @Test(description = " Test02 - Mark Task is Done and Verify it")
    @Description("This Test Marks a Specific Task is Done and Verify it")
    public void test02_TaskisCompleted() {
        ElectronFlow.addNewTask("Shout");
        ElectronFlow.addNewTask("Jump");
        ElectronFlow.addNewTask("Play");
        ElectronFlow.addNewTask("Love");
        System.out.println(ElectronFlow.get_tasksName());
        ElectronFlow.taskIsDone(1);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        Verifications.verifyTextinElemant(todoMainPage.get_CompletedTask_name(), "Play");

    }

    @Test(description = " Test03 - Mark All Tasks are Done and Verify it")
    @Description("This Test Marks All Tasks are Done and Verify it")
    public void test03_AllTaskAreCompleted() {
        ElectronFlow.addNewTask("Shout");
        ElectronFlow.addNewTask("Jump");
        ElectronFlow.addNewTask("Play");
        ElectronFlow.addNewTask("Love");
        Verifications.verifyNumber(todoMainPage.get_task_list().size(), 4);
        ElectronFlow.alltasks_Done();
        Verifications.verifyNumber(todoMainPage.get_task_list().size(), 0);
    }


}