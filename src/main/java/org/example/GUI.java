package org.example;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import org.example.Database.DatabaseHelper;

public class GUI {

    private Button knop;

    public GUI(GridPane view) {

        knop = new Button("Klik hier voor connectie");
        knop.setOnAction(event -> {
            DatabaseHelper.ConnectieMaken();
        });

        view.add(knop, 0, 0);
        view.setPrefSize(480, 360);
    }

}
