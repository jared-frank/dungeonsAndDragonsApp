module com.dungeonsproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens com.dungeonsproject.controller to javafx.fxml;
    opens com.dungeonsproject.characterdata to com.google.gson;
    exports com.dungeonsproject;
}
