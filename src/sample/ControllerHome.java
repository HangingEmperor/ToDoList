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

import java.awt.event.ActionEvent;
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
    void addTask(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            Task task = new Task(new CheckBox(""), textfieldTask.getText(), "");
            Data.addTask(task);
            refreshTable();
        }
    }

    public void addTaskButton(javafx.event.ActionEvent event) {
        Task task = new Task(new CheckBox(""), textfieldTask.getText(), "");
        Data.addTask(task);
        refreshTable();
    }

    private void refreshTable() {
        List<Task> listPersona = Data.getListTask();
        tableviewTask.setItems(FXCollections.observableArrayList(listPersona));
    }

    @FXML
    void changeTheme() {
        if (radiobuttonTheme.isSelected()) {
            paneBackground.setStyle("-fx-background-color: black;");
        } else {
            paneBackground.setStyle("-fx-background-color: white;");
        }
    }

    @FXML
    void closeWindow() {
        System.exit(0);
    }

    @FXML
    void maximizeWindow() {

    }

    @FXML
    void minimizeWindow() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablecolumnAccomplished.setCellValueFactory(new PropertyValueFactory<>("accomplished"));
        tablecolumnTask.setCellValueFactory(new PropertyValueFactory<>("text"));

        List<Task> listPersona = Data.getListTask();

        tableviewTask.setItems(FXCollections.observableArrayList(listPersona));
    }
}
