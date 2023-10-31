module com.example.csc311_labweek09 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311_labweek09 to javafx.fxml;
    exports com.example.csc311_labweek09;
}