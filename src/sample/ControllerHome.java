package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class ControllerHome {

    @FXML
    private Pane paneBackground;

    @FXML
    private TableColumn<?, ?> tablecolumnTask;

    @FXML
    private TableView<?> tableviewTask;

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

    }

    @FXML
    void changeTheme() {

    }

    @FXML
    void closeWindow() {

    }

    @FXML
    void maximizeWindow() {

    }

    @FXML
    void minimizeWindow() {

    }
}
