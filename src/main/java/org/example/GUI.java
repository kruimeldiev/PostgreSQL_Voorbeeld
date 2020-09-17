package org.example;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.Database.DatabaseHelper;

public class GUI {

    private Button connectieTestButton, tableMakenButton, namenOphalenButton;
    private TextField tableNaamTextField;

    public GUI(GridPane view) {

        connectieTestButton = new Button("Connectie test");
        connectieTestButton.setOnAction(event -> {
            DatabaseHelper.ConnectieMaken();
        });

        tableNaamTextField = new TextField();

        tableMakenButton = new Button("Table aanmaken");
        tableMakenButton.setOnAction(event -> {
            if (!tableNaamTextField.getText().isEmpty()) {
                DatabaseHelper.TableMaken(tableNaamTextField.getText());
            }
        });

        namenOphalenButton = new Button("Namen printen");
        namenOphalenButton.setOnAction(event -> {
            DatabaseHelper.NamenOphalen();
        });

        view.setPrefSize(480, 360);
        view.add(connectieTestButton, 0, 0);
        view.add(tableNaamTextField, 0,1);
        view.add(tableMakenButton, 1, 1);
        view.add(namenOphalenButton, 0, 2);
        view.setHgap(12);
        view.setVgap(12);
        view.setPadding(new Insets(20, 20, 20, 20));
    }

}
