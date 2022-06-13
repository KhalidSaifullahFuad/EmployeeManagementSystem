package com.javafx.employeemanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    private Connection connection;

    private Statement statement;

    @FXML
    private TextField inputId;

    @FXML
    private TextField inputName;

    @FXML
    private TextArea inputAddress;

    @FXML
    private TextField inputPhone;

    @FXML
    private ChoiceBox<String> selectDepartment;

    @FXML
    private Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectDepartment.getItems().addAll("Accounts", "HR", "IT");

        String DB_URL = "jdbc:mysql://localhost:3306/khalid";
        String DB_USER = "java_test";
        String DB_PASSWORD = "";

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = statement.getConnection().createStatement();
        }
        catch(SQLException err)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(err + "");
            alert.showAndWait();
        }

    }

    @FXML
    void doSave(ActionEvent event) {
        String id = inputId.getText();
        String name = inputName.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String department = selectDepartment.getValue();
        String query = "";

        query = "INSERT INSERT employee VALUES(" + id + ",'" + name + "','" + address + "','" + phone  + "','" + department + "')";

        executeQuery(query);
    }

    @FXML
    void doDelete(ActionEvent event) {
        String id = inputId.getText();
        String query = "";

        query = "DELETE FROM employee WHERE id = " + id;

        executeQuery(query);
    }

    @FXML
    void doUpdate(ActionEvent event) {
        String id = inputId.getText();
        String name = inputName.getText();
        String address = inputAddress.getText();
        String phone = inputPhone.getText();
        String department = selectDepartment.getValue();
        String query = "";

        query = "UPDATE employee SET name = '" + name + "', address = '" + address + "', phone = '" + phone + "', department = '" + department + "' WHERE id = " + id;

        executeQuery(query);
    }

    @FXML
    void doReset(ActionEvent event) {
        inputId.setText("");
        inputName.setText("");
        inputAddress.setText("");
        inputPhone.setText("");
        selectDepartment.setValue("");
    }

    void executeQuery(String query){
        Alert alert;
        try
        {
            if(statement.executeUpdate(query) > 0) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Success");
                alert.setContentText("Successfully executed");

            }else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Error");
                alert.setContentText("Problem Executing Query!!");
            }
        }
        catch (NullPointerException err){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("NullPointer Exception");
            alert.setContentText("" + err);
        }
        catch(SQLException err)
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText(err + "");
        }
        alert.showAndWait();
    }



}
