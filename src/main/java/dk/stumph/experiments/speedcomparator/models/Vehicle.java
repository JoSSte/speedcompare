package dk.stumph.experiments.speedcomparator.models;

import javafx.scene.paint.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;


@AllArgsConstructor
public class Vehicle {
    @Getter
    int speed;
    @Getter
    @NonNull
    Color color;


}
