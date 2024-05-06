module com.example.quizclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.quizclient to javafx.fxml;
    exports com.example.quizclient;
}