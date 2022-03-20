package dk.stumph.experiments.speedcomparator;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;
    private int stageWidth = 1200;
    private int stageHeight = 500;
    private int circRadius = 20;
    private int duration = 5000;
    public static final int X_OFFSET = 50;
    public static final Color STROKE = Color.BLACK;


    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpeedcomparatorApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Text text130 = new Text();
        text130.setX(X_OFFSET);
        text130.setY(40);
        text130.setFont(Font.font("Abyssinica SIL", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text130.setText("130 km/h");

        Circle cir130 = new Circle(X_OFFSET, 40, circRadius);
        cir130.setFill(Color.RED);
        cir130.setStroke(STROKE);

        Text text110 = new Text();
        text110.setX(X_OFFSET);
        text110.setY(80);
        text110.setFont(Font.font("Abyssinica SIL", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text110.setText("110 km/h");

        Circle cir110 = new Circle(X_OFFSET, 80, circRadius);
        cir110.setFill(Color.BLUE);
        cir110.setStroke(STROKE);

        Text text100 = new Text();
        text100.setX(X_OFFSET);
        text100.setY(120);
        text100.setFont(Font.font("Abyssinica SIL", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text100.setText("100 km/h");

        Circle cir100 = new Circle(X_OFFSET, 120, circRadius);
        cir100.setFill(Color.LIGHTBLUE);
        cir100.setStroke(STROKE);

        
        Text text80 = new Text();
        text80.setX(X_OFFSET);
        text80.setY(160);
        text80.setFont(Font.font("Abyssinica SIL", FontWeight.NORMAL, FontPosture.REGULAR, 20));
        text80.setText("80 km/h");

        Circle cir80 = new Circle(X_OFFSET, 160, circRadius);
        cir80.setFill(Color.GREEN);
        cir80.setStroke(STROKE);

        // Instantiating TranslateTransition class
        TranslateTransition translate800 = new TranslateTransition();
        int t80 = 800;
        translate800.setByX(t80);
        translate800.setDuration(Duration.millis(this.duration));
        translate800.setCycleCount(stageWidth);
        translate800.setNode(cir80);
        translate800.play();

        // Instantiating TranslateTransition class
        TranslateTransition translate1000 = new TranslateTransition();
        int t100 = 1000;
        translate1000.setByX(t100);
        translate1000.setDuration(Duration.millis(this.duration));
        translate1000.setCycleCount(stageWidth);
        translate1000.setNode(cir100);
        translate1000.play();

        // Instantiating TranslateTransition class
        TranslateTransition translate1100 = new TranslateTransition();
        int t110 = 1100;
        translate1100.setByX(t110);
        translate1100.setDuration(Duration.millis(this.duration));
        translate1100.setCycleCount(stageWidth);
        translate1100.setNode(cir110);
        translate1100.play();

        // Instantiating TranslateTransition class
        TranslateTransition translate1300 = new TranslateTransition();
        int t130 = 1300;
        translate1300.setByX(t130);
        translate1300.setDuration(Duration.millis(this.duration));
        translate1300.setCycleCount(stageWidth);
        translate1300.setNode(cir130);
        translate1300.play();

        // Configuring Group and Scene
        Group root = new Group();
        root.getChildren().addAll(cir80, cir110, cir130, cir100, text100, text130, text110, text80);
        Scene scene = new Scene(root, this.stageWidth, stageHeight, Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Translate Transition example");
        primaryStage.show();

    }

}