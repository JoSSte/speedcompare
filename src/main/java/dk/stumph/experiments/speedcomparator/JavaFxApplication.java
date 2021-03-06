package dk.stumph.experiments.speedcomparator;

import java.net.URL;
import java.text.NumberFormat;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import dk.stumph.experiments.speedcomparator.models.Vehicle;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;
    private int stageWidth = 1200;
    //private int stageHeight = 500;
    private int circRadius = 20;
    private int duration = 5000;

    public static final int BASE_VELOCITY = 130;

    public static final int X_OFFSET = 50;
    public static final int Y_OFFSET_INITIAL = 60;
    public static final int Y_INTERVAL = 40;
    public static final Color STROKE = Color.BLACK;
    public static final Font FONT = Font.font("Abyssinica SIL", FontWeight.NORMAL, FontPosture.REGULAR, 20);

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpeedcomparatorApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Group root = new Group();
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/scene.fxml");
        loader.setLocation(xmlUrl);
        BorderPane root = loader.load();

        Vehicle[] items = {
                new Vehicle(80, Color.RED),
                new Vehicle(100, Color.BLUE),
                new Vehicle(110, Color.BLUEVIOLET),
                new Vehicle(BASE_VELOCITY, Color.GREEN)
        };
        int offset = Y_OFFSET_INITIAL;
        for (Vehicle item : items) {
            Text text = new Text();
            text.setX(X_OFFSET);
            text.setY(offset);
            text.setFont(FONT);
            double percentOfLimit = ((double) item.getVelocity() / BASE_VELOCITY) * 100;
            text.setText(String.format("%03d",item.getVelocity()) + " km/h " + String.format("%.1f", percentOfLimit) + "%");

            Circle circle = new Circle(X_OFFSET, offset, circRadius);
            circle.setFill(item.getColor());
            circle.setStroke(STROKE);
            // Instantiating TranslateTransition class
            TranslateTransition translate = new TranslateTransition();
            translate.setByX(item.getVelocity() * 10);
            translate.setDuration(Duration.millis(this.duration));
            translate.setCycleCount(stageWidth);
            translate.setNode(circle);
            translate.play();
            root.getChildren().addAll(circle, text);
            offset += Y_INTERVAL;
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Speed Comparator");
        primaryStage.show();

    }

}