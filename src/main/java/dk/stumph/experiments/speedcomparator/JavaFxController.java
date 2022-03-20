package dk.stumph.experiments.speedcomparator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class JavaFxController {
    @FXML
    private Button mainButton;

    @FXML
    private void buttonClicked() {
        mainButton.setText("Click me again!");
    }
}
