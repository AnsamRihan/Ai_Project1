package com.example.aiproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class PalyerC implements Initializable {
    @FXML
    private ImageView background;
    @FXML
    private ImageView logo;

    @FXML
    private ImageView backLogo;


    private Scene scene;
    private Stage stage;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = null;
        Image image2 = null;
        Image image3 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/chechersBackground2.JPG"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/ChecIcon.png"));
            image3 = new Image(new FileInputStream("src/main/resources/Images/BackIcon.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        background.setImage(image);
        logo.setImage(image2);
        backLogo.setImage(image3);
    }

    public void SwitchToFirst(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToGmaePlayer1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamePlayer1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SwitchToGmaePlayer2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gamePlayer2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
