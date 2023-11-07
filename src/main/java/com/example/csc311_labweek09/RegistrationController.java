package com.example.csc311_labweek09;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationController {
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
    int validatedFieldCounter = 0;

    public void initialize() {
        List<TextField> textFieldList = List.of(tfFirstName, tfLastName, tfEmail, tfDOB, tfZipCode);
        btnAdd.setDisable(true);

        textFieldList.forEach(textField -> {
            textField.setOnKeyPressed(event -> {
                if (event.getCode() != KeyCode.TAB && flag) {
                    textField.setStyle("-fx-border-color: #12c812 ; -fx-border-width: 1px ;");
                    flag = false;
                }
            });
        });

        tfFirstName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("First name is focused");
            } else {
                if (tfFirstName.getText().matches("[a-zA-z]{2,25}")) {
                    validatedFieldCounter++;
                    tfFirstName.setBorder(null);
                    tfFirstName.setEditable(false);
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

        tfLastName.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Last name is focused");
            } else {
                if (tfLastName.getText().matches("[a-zA-z]{2,25}")) {
                    validatedFieldCounter++;
                    tfLastName.setBorder(null);
                    tfLastName.setEditable(false);
                    warningLabel.setText("");
                } else {
                    tfLastName.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                    tfLastName.setVisible(true);
                    tfLastName.requestFocus();
                    warningLabel.setText("WARNING: " + tfLastName.getText() + " is not a valid last name.");
                    flag = true;
                }
            }
        });

        tfEmail.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Email is focused");
            } else {
                if (tfEmail.getText().matches("[a-zA-z0-9]{3,15}@farmingdale.edu")) {
                    validatedFieldCounter++;
                    tfEmail.setBorder(null);
                    tfEmail.setEditable(false);
                    warningLabel.setText("");
                } else {
                    tfEmail.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                    tfEmail.setVisible(true);
                    tfEmail.requestFocus();
                    warningLabel.setText("WARNING: " + tfEmail.getText() + " is not a valid email address.");
                    flag = true;
                }
            }
        });

        tfDOB.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("DOB is focused");
            } else {
                if (tfDOB.getText().matches("^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$")) {
                    validatedFieldCounter++;
                    tfDOB.setBorder(null);
                    tfDOB.setEditable(false);
                    warningLabel.setText("");
                } else {
                    tfDOB.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                    tfDOB.setVisible(true);
                    tfDOB.requestFocus();
                    warningLabel.setText("WARNING: " + tfDOB.getText() + " is not a valid date of birth.");
                    flag = true;
                }
            }
        });

        tfZipCode.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                System.out.println("Zip code is focused");
            } else {
                if (tfZipCode.getText().matches("^[0-9]{5}")) {
                    validatedFieldCounter++;
                    tfZipCode.setBorder(null);
                    tfZipCode.setEditable(false);
                    warningLabel.setText("");

                    // Button only gets enabled after pressing tab on the final text field
                    btnAdd.setDisable(false);
                    btnAdd.setStyle("-fx-background-color: #7373df; -fx-border-radius: 4px; -fx-text-fill: white; -fx-cursor: pointer;");
                } else {
                    tfZipCode.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
                    tfZipCode.setVisible(true);
                    tfZipCode.requestFocus();
                    warningLabel.setText("WARNING: " + tfZipCode.getText() + " is not a valid zip code.");
                    flag = true;
                }
            }
        });
        System.out.println(validatedFieldCounter);

    }

    public void onBtnAddClick(ActionEvent actionEvent) throws IOException {
        System.out.println("All fields successfully validated.");
        // load secondary UI after all fields are validated
        loadSecondaryUI(actionEvent);
    }

    public void loadSecondaryUI(Event event) throws IOException {
        // load secondary UI
        FXMLLoader fxmlLoader = new FXMLLoader(RegistrationApplication.class.getResource("secondary-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}