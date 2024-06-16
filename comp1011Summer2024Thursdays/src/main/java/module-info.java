module ca.georgiancollege.comp1011summer2024thursdays {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ca.georgiancollege.comp1011summer2024thursdays to javafx.fxml;
    exports ca.georgiancollege.comp1011summer2024thursdays;
}