module es.masanz.examenut1.examenut1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.masanz.examenut1.examenut1 to javafx.fxml;
    exports es.masanz.examenut1.examenut1;
}