package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class doubleroomController {
    @FXML
    private ImageView doubleroom;
    @FXML
    private ImageView icon;
    @FXML
    public void initialize() {
        doubleroom.setImage(
                new Image(getClass().getResource("doubleroom.jpg").toExternalForm())
        );
        icon.setImage(
                new Image(getClass().getResource("icon.png").toExternalForm())
        );
    }
    public void goToRoom( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Room.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();        }
    }
    public void goToBook( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Book.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
