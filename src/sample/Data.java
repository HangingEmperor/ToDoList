package sample;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Task> listTask = new ArrayList<>();
    public static List<Task> listAccomplishedTask = new ArrayList<>();

    public static List<Task> getListTask() {
        return listTask;
    }

    public static void addTask(Task task) {
        listTask.add(task);
    }

    public static List<Task> getListAccomplishedTask() {
        return listAccomplishedTask;
    }

    public static void setListAccomplishedTask(List<Task> listAccomplishedTask) {
        Data.listAccomplishedTask = listAccomplishedTask;
    }

    public static void addAccomplishedTask(Task task) {
        listAccomplishedTask.add(task);
    }

    public static void setListTask(List<Task> listTask) {
        Data.listTask = listTask;
    }
}
