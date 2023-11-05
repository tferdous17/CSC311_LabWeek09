package com.example.csc311_labweek09;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloController {
    public TextField tfFirstName;
    public TextField tfLastName;
    public TextField tfEmail;
    public TextField tfDOB;
    public TextField tfZipCode;
    public Button btnAdd;
    public Label warningLabel;
    @FXML
    private Label welcomeText;

    boolean flag = false;

    public void initialize() {
        tfFirstName.setOnKeyPressed(event -> {
            if (event.getCode() != KeyCode.TAB && flag){
                tfFirstName.setStyle("-fx-border-color: #12c812 ; -fx-border-width: 1px ;");

                flag = false;
            }
        });

        tfFirstName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("First name is focused");
            } else {
                if (tfFirstName.getText().matches("[a-zA-z]{2,25}")) {
                    tfFirstName.setBorder(null);
                    warningLabel.setText("");
                } else {
                    tfFirstName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                    tfFirstName.setVisible(true);
                    tfFirstName.requestFocus();
                    warningLabel.setText("WARNING: " + tfFirstName.getText() + " is not a valid first name.");
                    flag = true;
                }
            }
        });

    }

    public void onBtnAddClick(ActionEvent actionEvent) {
    }
}