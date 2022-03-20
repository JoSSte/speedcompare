package dk.stumph.experiments.speedcomparator;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
    private int stageWidth = 500;
    private int stageHeight = 500;
    private Duration dur800 = Duration.millis(800);
    private int circRadius = 20;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SpeedcomparatorApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Circle circ = new Circle(40, 40, circRadius);
        circ.setFill(Color.BLUE);
        circ.setStroke(Color.BLACK);

        Circle cir = new Circle(50, 100, circRadius);
        cir.setFill(Color.RED);
        cir.setStroke(Color.BLACK);

        // Instantiating TranslateTransition class
        TranslateTransition translate800 = new TranslateTransition();
        translate800.setByX(800);
        translate800.setDuration(this.dur800);
        translate800.setCycleCount(stageWidth);
        // translate800.setAutoReverse(true);
        translate800.setNode(cir);
        translate800.play();



        // Configuring Group and Scene
        Group root = new Group();
        root.getChildren().addAll(cir, circ);
        Scene scene = new Scene(root, this.stageWidth, stageHeight, Color.ALICEBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Translate Transition example");
        primaryStage.show();

    }

}