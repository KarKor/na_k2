module pl.umcs.oop.niewiem {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.umcs.oop.niewiem to javafx.fxml;
    exports pl.umcs.oop.niewiem;
}