package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerHome implements Initializable {

    @FXML
    private Pane paneBackground;
    @FXML
    private TableColumn<Task, String> tablecolumnTask;
    @FXML
    private TableView<Task> tableviewTask;
    @FXML
    private TableColumn<Task, String> tablecolumnAccomplished;
    @FXML
    private Pane paneBar;
    @FXML
    private ImageView imageviewClose;
    @FXML
    private ImageView imageviewExpand;
    @FXML
    private ImageView imageviewMinimize;
    @FXML
    private Label labelTitle;
    @FXML
    private TextField textfieldTask;
    @FXML
    private RadioButton radiobuttonTheme;
    @FXML
    private TableView<Task> tableviewTaskAccomplished;
    @FXML
    private TableColumn<Task, String> tablecolumnContentTask;

    int id = 0;

    @FXML
    void addTask(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            Task task = new Task(new CheckBox(""), id, textfieldTask.getText(), "");
            Data.addTask(task);
            textfieldTask.setText("");
            refreshTable();
        }
    }

    public void addTaskButton(javafx.event.ActionEvent event) {
        Task task = new Task(new CheckBox(""), id, textfieldTask.getText(), "");
        Data.addTask(task);
        textfieldTask.setText("");
        refreshTable();
    }

    private void refreshTable() {
        List<Task> listTask = Data.getListTask();
        List<Task> listAccomplishedTask = Data.getListAccomplishedTask();

        listTask.get(id).getAccomplished().setId(Integer.toString(id));
        listTask.get(id).getAccomplished().setOnAction(event -> {
            int id = Integer.parseInt(((CheckBox) event.getSource()).getId());

            for (int i = 0; i < Data.listTask.size(); i++) {
                if (Integer.parseInt(((CheckBox) event.getSource()).getId()) == Data.listTask.get(i).getId()) {
                    Data.listAccomplishedTask.add(Data.getListTask().get(i));
                    Data.listTask.remove(i);
                    this.id--;

                    tableviewTask.setItems(FXCollections.observableArrayList(Data.getListTask()));
                    tableviewTaskAccomplished.setItems(FXCollections.observableArrayList(Data.getListAccomplishedTask()));
                }
            }
        });
        id++;

        tableviewTask.setItems(FXCollections.observableArrayList(listTask));
        tableviewTaskAccomplished.setItems(FXCollections.observableArrayList(listAccomplishedTask));
    }

    @FXML
    void changeTheme() {
        if (radiobuttonTheme.isSelected()) {
            paneBar.setStyle("-fx-background-color: black;");
            labelTitle.setStyle("-fx-text-fill: white;");
            paneBackground.setStyle("-fx-background-color: black;");
        } else {
            paneBar.setStyle("-fx-background-color: white;");
            labelTitle.setStyle("-fx-text-fill: black;");
            paneBackground.setStyle("-fx-background-color: white;");
        }
    }

    @FXML
    void closeWindow() {
        Data.saveData();
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelTitle.setText("To Do List");
        tablecolumnAccomplished.setCellValueFactory(new PropertyValueFactory<>("accomplished"));
        tablecolumnTask.setCellValueFactory(new PropertyValueFactory<>("text"));
        tablecolumnContentTask.setCellValueFactory(new PropertyValueFactory<>("text"));

        List<Task> listTask = Data.getListTask();
        List<Task> listAccomplishedTask = Data.getListAccomplishedTask();

        tableviewTask.setItems(FXCollections.observableArrayList(listTask));
        tableviewTaskAccomplished.setItems(FXCollections.observableArrayList(listAccomplishedTask));
    }
}
