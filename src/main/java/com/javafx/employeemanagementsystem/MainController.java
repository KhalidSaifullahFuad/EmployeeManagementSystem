package com.javafx.employeemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TextArea inputAddress;

    @FXML
    private TextField inputId;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputPhone;

    @FXML
    private ChoiceBox<String> selectDepartment;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectDepartment.getItems().addAll("Accounts", "HR", "IT");
    }

    @FXML
    void doDelete(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doSave(ActionEvent event) {

    }

    @FXML
    void doUpdate(ActionEvent event) {

    }


}
