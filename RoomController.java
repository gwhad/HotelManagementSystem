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

public class RoomController {

    @FXML
    private ImageView singleroom;

    @FXML
    private ImageView doubleroom;

    @FXML
    private ImageView suiteroom;

    @FXML
    public void initialize() {

        singleroom.setImage(
                new Image(getClass().getResource("singleroom.jpg").toExternalForm())
        );

        doubleroom.setImage(
                new Image(getClass().getResource("doubleroom.jpg").toExternalForm())
        );

        suiteroom.setImage(
                new Image(getClass().getResource("suite.jpg").toExternalForm())
        );
    }
    public void goToHome( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToSingleRoom( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("single room.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goTodoubleroom( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("doubleroom.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goTosuite( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("suite.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void goToAbout( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
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