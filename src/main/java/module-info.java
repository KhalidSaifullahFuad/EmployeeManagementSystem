module com.javafx.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.javafx.employeemanagementsystem to javafx.fxml;
    exports com.javafx.employeemanagementsystem;
}