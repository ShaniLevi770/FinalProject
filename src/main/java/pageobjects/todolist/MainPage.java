package pageobjects.todolist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy (how= How.CSS, using= "input[placeholder= 'Create a task']")
    private WebElement txt_craete;
    public WebElement get_txt_craete(){
        return txt_craete;
    }

    //counts all tasks (completed and pending)
    @FindBy (how= How.CLASS_NAME, using= "view_2Ow90")
    private List<WebElement> general_task_list;
    public List<WebElement> get_general_task_list(){
        return general_task_list;
    }

    //counts all tasks (only pending tasks)
    @FindBy (how= How.CLASS_NAME, using= "taskWrapper_2u8dN")
    private List<WebElement> task_list;
    public List<WebElement> get_task_list(){
        return task_list;
    }

    @FindBy (how= How.CLASS_NAME, using= "contentItem_9qJo7")
    private List<WebElement> sort_list;
    public List<WebElement> get_sort_list(){
        return sort_list;
    }

    @FindBy (how= How.CLASS_NAME, using= "label_5i8SP")
    private List<WebElement> task_namelist;
    public List<WebElement> get_task_namelist(){ return task_namelist;}


    @FindBy (how= How.CLASS_NAME, using= "destroy_19w1q")
    private WebElement btn_delete;
    public WebElement get_btn_delete(){
        return btn_delete;
    }

    @FindBy (how= How.CLASS_NAME, using= "allCompletedIconWrapper_2rCqr")
    private WebElement btn_allCompleted;
    public WebElement get_btn_allCompleted(){
        return btn_allCompleted;
    }

    @FindBy (how= How.CSS, using= "label[class='label_5i8SP completed_bHv-Q'")
    public WebElement CompletedTask_name;
    public WebElement get_CompletedTask_name(){
        return CompletedTask_name;
    }

    @FindBy (how= How.CSS, using= "svg[viewBox= '-10 -18 100 135']")
    private List<WebElement> task_check;
    public List<WebElement> get_task_check(){
        return task_check;
    }








}
