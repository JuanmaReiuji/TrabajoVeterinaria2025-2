module co.uniquindio.edu.co.trabajoveterinaria20252 {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.uniquindio.edu.co.trabajoveterinaria20252.ViewController to javafx.fxml;

    exports co.uniquindio.edu.co.trabajoveterinaria20252;
}
