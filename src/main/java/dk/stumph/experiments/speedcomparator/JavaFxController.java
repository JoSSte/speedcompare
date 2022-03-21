package dk.stumph.experiments.speedcomparator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class JavaFxController {
    @FXML
    private Button mainButton;

    @FXML
    private void buttonClicked() {
        mainButton.setText("Click me again!");
    }

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private void closeMenuItemClicked() {
        System.exit(0);
    }

}
