package sample;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Task> listTask = new ArrayList<>();

    public static List<Task> getListTask() {
        return listTask;
    }

    public static void addTask(Task task) {
        listTask.add(task);
    }

    public static void setListTask(List<Task> listTask) {
        Data.listTask = listTask;
    }
}
