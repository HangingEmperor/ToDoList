package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public static void saveData() {
        String nameFile = "log.txt";
        File file = new File("log.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            /*
            String aux = "";
            String oldData = "";
            FileReader hoja = new FileReader(file);
            BufferedReader lee = new BufferedReader(hoja);
            while ((aux = lee.readLine()) != null) {
                oldData += aux + "\n";
            }
            lee.close();
            */

            FileWriter archivo = new FileWriter(file);
            //archivo.append(oldData);
            for (int i = 0; i < listTask.size(); i++) {
                archivo.append("\n");
                archivo.append(listTask.get(i).getText());
            }
            archivo.close();
        } catch (IOException ex) {
            System.out.println("Hubo un error");
        }
    }

    public static void setListTask(List<Task> listTask) {
        Data.listTask = listTask;
    }
}
