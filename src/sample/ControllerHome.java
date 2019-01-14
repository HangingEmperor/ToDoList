package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHome implements Initializable {

    @FXML
    private Pane paneBackground;
    @FXML
    private TableColumn<Task, String> tablecolumnTask;
    @FXML
    private TableView<Task> tableviewTask;
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

    private Boolean theme = false;

    @FXML
    void addTask(KeyEvent event) {

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
        tablecolumnTask.setCellValueFactory(new PropertyValueFactory<>("id"));
    }
}
