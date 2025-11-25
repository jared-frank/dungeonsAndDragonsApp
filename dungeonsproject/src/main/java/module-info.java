module com.dungeonsproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.dungeonsproject to javafx.fxml;
    exports com.dungeonsproject;
}
