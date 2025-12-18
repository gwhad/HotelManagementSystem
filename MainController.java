package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private MediaView mediaView;
    @FXML
    private ImageView imageView;
    @FXML

     private MediaPlayer mediaPlayer;

    @FXML
    public void initialize() {
        String path = getClass().getResource("video2.mp4").toExternalForm();
        Media media = new Media(path);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // الفيديو يتكرر
        mediaPlayer.setAutoPlay(true);

        mediaView.setMediaPlayer(mediaPlayer);
        mediaView.setPreserveRatio(true);



        imageView.setImage(new Image(getClass().getResource("logo.png").toExternalForm()));


    }

    @FXML


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
            e.printStackTrace();        }
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