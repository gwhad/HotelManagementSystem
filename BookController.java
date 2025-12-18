package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class BookController {
    @FXML
    private ImageView photo;

    @FXML
    private ImageView imageView;
    @FXML
    private SplitMenuButton splitMenu;




    @FXML


    public void initialize() {

        photo.setImage(
                new Image(getClass().getResource("Accommodation.jpg").toExternalForm())
        );

        imageView.setImage(
                new Image(getClass().getResource("logo.png").toExternalForm())
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
    public void goToRoom( ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Room.fxml"));
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
            e.printStackTrace();
        }
    }
    @FXML
    private void setSingle() {
        splitMenu.setText("Single");

    }

    @FXML
    private void setDouble() {
        splitMenu.setText("Double");

    }

    @FXML
    private void setSuite() {
        splitMenu.setText("Suite");

    }

}
