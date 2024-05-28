module edu.cnm.deepdive.counter {

  requires javafx.controls;
  requires javafx.fxml;

  opens edu.cnm.deepdive.counter to javafx.fxml;
  exports edu.cnm.deepdive.counter;

   opens edu.cnm.deepdive.counter.controller to javafx.fxml;
   exports edu.cnm.deepdive.counter.controller;

}
