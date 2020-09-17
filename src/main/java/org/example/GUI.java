package org.example;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.example.Database.DatabaseHelper;

public class GUI {

    private Button connectieTestButton, namenPrintenButton, naamToevoegenButton;
    private TextField naamTextField, leeftijdTextField;
    private Label naamLabel, leeftijdLabel;

    public GUI(GridPane view) {

        connectieTestButton = new Button("Connectie test");
        connectieTestButton.setOnAction(event -> {
            DatabaseHelper.ConnectieMaken();
        });

        namenPrintenButton = new Button("Namen printen");
        namenPrintenButton.setOnAction(event -> {
            DatabaseHelper.NamenOphalen();
        });

        naamLabel = new Label("Vul naam in:");
        naamTextField = new TextField();

        leeftijdLabel = new Label("Vul leeftijd in:");
        leeftijdTextField = new TextField();

        // Deze Listener zorgt ervoor dat alleen nummers kunnen worden ingevoerd in de keyField
        // De listener kijkt naar de nieuwe ingevoerde value (input), wanneer deze geen cijfer is (\\d*), dan wordt de input vervangen door een lege String
        leeftijdTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    leeftijdTextField.setText(newValue.replaceAll("\\D", ""));
                }
            }
        });

        naamToevoegenButton = new Button("Nieuwe persoon opslaan");
        naamToevoegenButton.setOnAction(event -> {
            if (!naamTextField.getText().isEmpty() && !leeftijdTextField.getText().isEmpty()) {
                DatabaseHelper.NaamToevoegen(this.naamTextField.getText(), this.leeftijdTextField.getText());
            }
        });

        view.setPrefSize(480, 360);
        view.add(connectieTestButton, 0, 0);
        view.add(namenPrintenButton, 1, 0);
        view.add(naamLabel, 0, 1);
        view.add(naamTextField, 0, 2);
        view.add(leeftijdLabel, 0,3);
        view.add(leeftijdTextField,0,4);
        view.add(naamToevoegenButton,1,4);
        view.setHgap(12);
        view.setVgap(12);
        view.setPadding(new Insets(20, 20, 20, 20));
    }

}
