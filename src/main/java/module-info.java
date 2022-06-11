module com.javafx.employeemanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.javafx.employeemanagementsystem to javafx.fxml;
    exports com.javafx.employeemanagementsystem;
}