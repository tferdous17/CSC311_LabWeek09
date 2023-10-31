package com.example.csc311_labweek09;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField tfFirstName;
    public TextField tfLastName;
    public TextField tfEmail;
    public TextField tfDOB;
    public TextField tfZipCode;
    public Button btnAdd;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void onBtnAddClick() {

    }
}