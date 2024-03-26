package com.example.aiproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Game implements Initializable {

    private boolean turnBlack = true;
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private Button back;

    @FXML
    private Label player;
    //-----------------------------
    @FXML
    private ImageView img0_0;
    @FXML
    private ImageView img1_0;
    @FXML
    private ImageView img2_0;
    @FXML
    private ImageView img3_0;
    @FXML
    private ImageView img4_0;
    @FXML
    private ImageView img5_0;
    @FXML
    private ImageView img6_0;
    @FXML
    private ImageView img7_0;
    @FXML
    private ImageView img0_1;
    @FXML
    private ImageView img1_1;
    @FXML
    private ImageView img2_1;
    @FXML
    private ImageView img3_1;
    @FXML
    private ImageView img4_1;
    @FXML
    private ImageView img5_1;
    @FXML
    private ImageView img6_1;
    @FXML
    private ImageView img7_1;
    @FXML
    private ImageView img0_2;
    @FXML
    private ImageView img1_2;
    @FXML
    private ImageView img2_2;
    @FXML
    private ImageView img3_2;
    @FXML
    private ImageView img4_2;
    @FXML
    private ImageView img5_2;
    @FXML
    private ImageView img6_2;
    @FXML
    private ImageView img7_2;
    @FXML
    private ImageView img0_3;
    @FXML
    private ImageView img1_3;
    @FXML
    private ImageView img2_3;
    @FXML
    private ImageView img3_3;
    @FXML
    private ImageView img4_3;
    @FXML
    private ImageView img5_3;
    @FXML
    private ImageView img6_3;
    @FXML
    private ImageView img7_3;
    @FXML
    private ImageView img0_4;
    @FXML
    private ImageView img1_4;
    @FXML
    private ImageView img2_4;
    @FXML
    private ImageView img3_4;
    @FXML
    private ImageView img4_4;
    @FXML
    private ImageView img5_4;
    @FXML
    private ImageView img6_4;
    @FXML
    private ImageView img7_4;
    @FXML
    private ImageView img0_5;
    @FXML
    private ImageView img1_5;
    @FXML
    private ImageView img2_5;
    @FXML
    private ImageView img3_5;
    @FXML
    private ImageView img4_5;
    @FXML
    private ImageView img5_5;
    @FXML
    private ImageView img6_5;
    @FXML
    private ImageView img7_5;
    @FXML
    private ImageView img0_6;
    @FXML
    private ImageView img1_6;
    @FXML
    private ImageView img2_6;
    @FXML
    private ImageView img3_6;
    @FXML
    private ImageView img4_6;
    @FXML
    private ImageView img5_6;
    @FXML
    private ImageView img6_6;
    @FXML
    private ImageView img7_6;
    @FXML
    private ImageView img0_7;
    @FXML
    private ImageView img1_7;
    @FXML
    private ImageView img2_7;
    @FXML
    private ImageView img3_7;
    @FXML
    private ImageView img4_7;
    @FXML
    private ImageView img5_7;
    @FXML
    private ImageView img6_7;
    @FXML
    private ImageView img7_7;

    //-----------------------------

    @FXML
    private ImageView background;

    @FXML
    private ImageView backLogo;

    private Step board[][] = new Step[8][8];

    private ArrayList<int[]> possibleChoices = new ArrayList<>(); // ([1,0], [2,0])

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //------------------------------------------------
        //Initialize images.
        Image image = null;
        Image image3 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/chechersBackground2.JPG"));
            image3 = new Image(new FileInputStream("src/main/resources/Images/BackIcon.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        background.setImage(image);
        backLogo.setImage(image3);
        //-----------------------------------------------
        //
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Step();
            }
        }
    }

    public void SwitchToFirstScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean checkArrayExistence(ArrayList<int[]> arrayList, int[] targetArray) {
        for (int[] array : arrayList) {
            if (Arrays.equals(array, targetArray)) {
                return true;
            }
        }
        return false;
    }

    public void Action0_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_0.setImage(image);
                Step s = new Step(true, "1");
                board[0][0] = s;
            }else{
                img0_0.setImage(image2);
                Step s = new Step(true, "2");
                board[0][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_0.setImage(image);
                Step s = new Step(true, "1");
                board[1][0] = s;
            }else{
                img1_0.setImage(image2);
                Step s = new Step(true, "2");
                board[1][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_0.setImage(image);
                Step s = new Step(true, "1");
                board[2][0] = s;
            }else{
                img2_0.setImage(image2);
                Step s = new Step(true, "2");
                board[2][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_0.setImage(image);
                Step s = new Step(true, "1");
                board[3][0] = s;
            }else{
                img3_0.setImage(image2);
                Step s = new Step(true, "2");
                board[3][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_0.setImage(image);
                Step s = new Step(true, "1");
                board[4][0] = s;
            }else{
                img4_0.setImage(image2);
                Step s = new Step(true, "2");
                board[4][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_0.setImage(image);
                Step s = new Step(true, "1");
                board[5][0] = s;
            }else{
                img5_0.setImage(image2);
                Step s = new Step(true, "2");
                board[5][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,0});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_0.setImage(image);
                Step s = new Step(true, "1");
                board[6][0] = s;
            }else{
                img6_0.setImage(image2);
                Step s = new Step(true, "2");
                board[6][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_0(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7, 0});

        if (exists == false) {
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        } else {
            if (turnBlack) {
                img7_0.setImage(image);
                Step s = new Step(true, "1");
                board[7][0] = s;
            } else {
                img7_0.setImage(image2);
                Step s = new Step(true, "2");
                board[7][0] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }
    public void Action0_1(ActionEvent event) throws IOException {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_1.setImage(image);
                Step s = new Step(true, "1");
                board[0][1] = s;
            }else{
                img0_1.setImage(image2);
                Step s = new Step(true, "2");
                board[0][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_1.setImage(image);
                Step s = new Step(true, "1");
                board[1][1] = s;
            }else{
                img1_1.setImage(image2);
                Step s = new Step(true, "2");
                board[1][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_1.setImage(image);
                Step s = new Step(true, "1");
                board[2][1] = s;
            }else{
                img2_1.setImage(image2);
                Step s = new Step(true, "2");
                board[2][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_1.setImage(image);
                Step s = new Step(true, "1");
                board[3][1] = s;
            }else{
                img3_1.setImage(image2);
                Step s = new Step(true, "2");
                board[3][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_1.setImage(image);
                Step s = new Step(true, "1");
                board[4][1] = s;
            }else{
                img4_1.setImage(image2);
                Step s = new Step(true, "2");
                board[4][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_1.setImage(image);
                Step s = new Step(true, "1");
                board[5][1] = s;
            }else{
                img5_1.setImage(image2);
                Step s = new Step(true, "2");
                board[5][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_1.setImage(image);
                Step s = new Step(true, "1");
                board[6][1] = s;
            }else{
                img6_1.setImage(image2);
                Step s = new Step(true, "2");
                board[6][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_1(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7,1});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img7_1.setImage(image);
                Step s = new Step(true, "1");
                board[7][1] = s;
            }else{
                img7_1.setImage(image2);
                Step s = new Step(true, "2");
                board[7][1] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_2.setImage(image);
                Step s = new Step(true, "1");
                board[0][2] = s;
            }else{
                img0_2.setImage(image2);
                Step s = new Step(true, "2");
                board[0][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_2.setImage(image);
                Step s = new Step(true, "1");
                board[1][2] = s;
            }else{
                img1_2.setImage(image2);
                Step s = new Step(true, "2");
                board[1][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_2.setImage(image);
                Step s = new Step(true, "1");
                board[2][2] = s;
            }else{
                img2_2.setImage(image2);
                Step s = new Step(true, "2");
                board[2][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_2.setImage(image);
                Step s = new Step(true, "1");
                board[3][2] = s;
            }else{
                img3_2.setImage(image2);
                Step s = new Step(true, "2");
                board[3][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_2.setImage(image);
                Step s = new Step(true, "1");
                board[4][2] = s;
            }else{
                img4_2.setImage(image2);
                Step s = new Step(true, "2");
                board[4][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_2.setImage(image);
                Step s = new Step(true, "1");
                board[5][2] = s;
            }else{
                img5_2.setImage(image2);
                Step s = new Step(true, "2");
                board[5][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_2.setImage(image);
                Step s = new Step(true, "1");
                board[6][2] = s;
            }else{
                img6_2.setImage(image2);
                Step s = new Step(true, "2");
                board[6][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_2(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7,2});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img7_2.setImage(image);
                Step s = new Step(true, "1");
                board[7][2] = s;
            }else{
                img7_2.setImage(image2);
                Step s = new Step(true, "2");
                board[7][2] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_3.setImage(image);
                Step s = new Step(true, "1");
                board[0][3] = s;
            }else{
                img0_3.setImage(image2);
                Step s = new Step(true, "2");
                board[0][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_3.setImage(image);
                Step s = new Step(true, "1");
                board[1][3] = s;
            }else{
                img1_3.setImage(image2);
                Step s = new Step(true, "2");
                board[1][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_3.setImage(image);
                Step s = new Step(true, "1");
                board[2][3] = s;
            }else{
                img2_3.setImage(image2);
                Step s = new Step(true, "2");
                board[2][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_3.setImage(image);
                Step s = new Step(true, "1");
                board[3][3] = s;
            }else{
                img3_3.setImage(image2);
                Step s = new Step(true, "2");
                board[3][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_3.setImage(image);
                Step s = new Step(true, "1");
                board[4][3] = s;
            }else{
                img4_3.setImage(image2);
                Step s = new Step(true, "2");
                board[4][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_3.setImage(image);
                Step s = new Step(true, "1");
                board[5][3] = s;
            }else{
                img5_3.setImage(image2);
                Step s = new Step(true, "2");
                board[5][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_3.setImage(image);
                Step s = new Step(true, "1");
                board[6][3] = s;
            }else{
                img6_3.setImage(image2);
                Step s = new Step(true, "2");
                board[6][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_3(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7,3});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img7_3.setImage(image);
                Step s = new Step(true, "1");
                board[7][3] = s;
            }else{
                img7_3.setImage(image2);
                Step s = new Step(true, "2");
                board[7][3] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_4.setImage(image);
                Step s = new Step(true, "1");
                board[0][4] = s;
            }else{
                img0_4.setImage(image2);
                Step s = new Step(true, "2");
                board[0][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_4.setImage(image);
                Step s = new Step(true, "1");
                board[1][4] = s;
            }else{
                img1_4.setImage(image2);
                Step s = new Step(true, "2");
                board[1][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_4.setImage(image);
                Step s = new Step(true, "1");
                board[2][4] = s;
            }else{
                img2_4.setImage(image2);
                Step s = new Step(true, "2");
                board[2][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_4.setImage(image);
                Step s = new Step(true, "1");
                board[3][4] = s;
            }else{
                img3_4.setImage(image2);
                Step s = new Step(true, "2");
                board[3][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_4.setImage(image);
                Step s = new Step(true, "1");
                board[4][4] = s;
            }else{
                img4_4.setImage(image2);
                Step s = new Step(true, "2");
                board[4][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_4.setImage(image);
                Step s = new Step(true, "1");
                board[5][4] = s;
            }else{
                img5_4.setImage(image2);
                Step s = new Step(true, "2");
                board[5][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_4.setImage(image);
                Step s = new Step(true, "1");
                board[6][4] = s;
            }else{
                img6_4.setImage(image2);
                Step s = new Step(true, "2");
                board[6][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_4(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7,4});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img7_4.setImage(image);
                Step s = new Step(true, "1");
                board[7][4] = s;
            }else{
                img7_4.setImage(image2);
                Step s = new Step(true, "2");
                board[7][4] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_5.setImage(image);
                Step s = new Step(true, "1");
                board[0][5] = s;
            }else{
                img0_5.setImage(image2);
                Step s = new Step(true, "2");
                board[0][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_5.setImage(image);
                Step s = new Step(true, "1");
                board[1][5] = s;
            }else{
                img1_5.setImage(image2);
                Step s = new Step(true, "2");
                board[1][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_5.setImage(image);
                Step s = new Step(true, "1");
                board[2][5] = s;
            }else{
                img2_5.setImage(image2);
                Step s = new Step(true, "2");
                board[2][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_5.setImage(image);
                Step s = new Step(true, "1");
                board[3][5] = s;
            }else{
                img3_5.setImage(image2);
                Step s = new Step(true, "2");
                board[3][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_5.setImage(image);
                Step s = new Step(true, "1");
                board[4][5] = s;
            }else{
                img4_5.setImage(image2);
                Step s = new Step(true, "2");
                board[4][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_5.setImage(image);
                Step s = new Step(true, "1");
                board[5][5] = s;
            }else{
                img5_5.setImage(image2);
                Step s = new Step(true, "2");
                board[5][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,5});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_5.setImage(image);
                Step s = new Step(true, "1");
                board[6][5] = s;
            }else{
                img6_5.setImage(image2);
                Step s = new Step(true, "2");
                board[6][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_5(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7, 5});

        if (exists == false) {
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        } else {
            if (turnBlack) {
                img7_5.setImage(image);
                Step s = new Step(true, "1");
                board[7][5] = s;
            } else {
                img7_5.setImage(image2);
                Step s = new Step(true, "2");
                board[7][5] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_6.setImage(image);
                Step s = new Step(true, "1");
                board[0][6] = s;
            }else{
                img0_6.setImage(image2);
                Step s = new Step(true, "2");
                board[0][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_6.setImage(image);
                Step s = new Step(true, "1");
                board[1][6] = s;
            }else{
                img1_6.setImage(image2);
                Step s = new Step(true, "2");
                board[1][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_6.setImage(image);
                Step s = new Step(true, "1");
                board[2][6] = s;
            }else{
                img2_6.setImage(image2);
                Step s = new Step(true, "2");
                board[2][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_6.setImage(image);
                Step s = new Step(true, "1");
                board[3][6] = s;
            }else{
                img3_6.setImage(image2);
                Step s = new Step(true, "2");
                board[3][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_6.setImage(image);
                Step s = new Step(true, "1");
                board[4][6] = s;
            }else{
                img4_6.setImage(image2);
                Step s = new Step(true, "2");
                board[4][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_6.setImage(image);
                Step s = new Step(true, "1");
                board[5][6] = s;
            }else{
                img5_6.setImage(image2);
                Step s = new Step(true, "2");
                board[5][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,6});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_6.setImage(image);
                Step s = new Step(true, "1");
                board[6][6] = s;
            }else{
                img6_6.setImage(image2);
                Step s = new Step(true, "2");
                board[6][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_6(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7, 6});

        if (exists == false) {
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        } else {
            if (turnBlack) {
                img7_6.setImage(image);
                Step s = new Step(true, "1");
                board[7][6] = s;
            } else {
                img7_6.setImage(image2);
                Step s = new Step(true, "2");
                board[7][6] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action0_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{0,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img0_7.setImage(image);
                Step s = new Step(true, "1");
                board[0][7] = s;
            }else{
                img0_7.setImage(image2);
                Step s = new Step(true, "2");
                board[0][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action1_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{1,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img1_7.setImage(image);
                Step s = new Step(true, "1");
                board[1][7] = s;
            }else{
                img1_7.setImage(image2);
                Step s = new Step(true, "2");
                board[1][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action2_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{2,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img2_7.setImage(image);
                Step s = new Step(true, "1");
                board[2][7] = s;
            }else{
                img2_7.setImage(image2);
                Step s = new Step(true, "2");
                board[2][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action3_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{3,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img3_7.setImage(image);
                Step s = new Step(true, "1");
                board[3][7] = s;
            }else{
                img3_7.setImage(image2);
                Step s = new Step(true, "2");
                board[3][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action4_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{4,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img4_7.setImage(image);
                Step s = new Step(true, "1");
                board[4][7] = s;
            }else{
                img4_7.setImage(image2);
                Step s = new Step(true, "2");
                board[4][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action5_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{5,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img5_7.setImage(image);
                Step s = new Step(true, "1");
                board[5][7] = s;
            }else{
                img5_7.setImage(image2);
                Step s = new Step(true, "2");
                board[5][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action6_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{6,7});

        if(exists == false){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        }else{
            if(turnBlack){
                img6_7.setImage(image);
                Step s = new Step(true, "1");
                board[6][7] = s;
            }else{
                img6_7.setImage(image2);
                Step s = new Step(true, "2");
                board[6][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }

    public void Action7_7(ActionEvent event) throws IOException  {
        Image image = null;
        Image image2 = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            image2 = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        get_PossibleChoices();
        boolean exists = checkArrayExistence(possibleChoices, new int[]{7, 7});

        if (exists == false) {
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type, "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setContentText("This action is not possible!");
            alert.getDialogPane().setHeaderText("Insertion error!");
            alert.show();
        } else {
            if (turnBlack) {
                img7_7.setImage(image);
                Step s = new Step(true, "1");
                board[7][7] = s;
            } else {
                img7_7.setImage(image2);
                Step s = new Step(true, "2");
                board[7][7] = s;
            }

            String win = winner();
            if(win != null){
                if(win.equals("1")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("Winner is 1");
                    alert.show();
                }else if(win.equals("2")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("winner is 2");
                    alert.show();
                }
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
            }

            turnBlack = !turnBlack;
            if(turnBlack){
                player.setText("1");
            }else{
                player.setText("2");
            }
        }
    }
    public void get_PossibleChoices(){
        possibleChoices.clear();
        boolean empty = true;

        for (int i=0; i < 8; i++){
            for (int j=0; j < 8; j++){
                if(board[i][j].played == true){
                    empty = false;
                }
            }
        }

        if(empty == true){
            for(int i=0; i < 8; i++){
                possibleChoices.add(new int[]{0, i});
                possibleChoices.add(new int[]{7, i});
            }
        }else{
            for(int i=0; i < 8; i++){
                if(board[0][i].played == false){
                    possibleChoices.add(new int[]{0, i});
                }
                if(board[7][i].played == false){
                    possibleChoices.add(new int[]{7, i});
                }
            }

            for(int i=1; i < 7; i++){
                for (int j=0; j < 8; j++){
                    if(board[i][j].played == false){
                        if(board[i-1][j].played == true){
                            possibleChoices.add(new int[]{i, j});
                            continue;
                        }
                        if(board[i+1][j].played == true){
                            possibleChoices.add(new int[]{i, j});
                        }
                    }
                }
            }
        }
    }

    public String winner(){
        String winnerID = null;

        //--------------------------------------------------
        //Check Vertical win
        for(int i=0; i < 8; i++){
            int consecutive = 0;
            for(int j=0; j < 7; j++){
                if(board[i][j].played == false){
                    consecutive = 0;
                }else{
                    if(board[i][j].player.equals("1") && board[i][j+1].player.equals("1")){
                        consecutive++;

                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if (board[i][j].player.equals("1") && !(board[i][j+1].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[i][j].player.equals("2") && board[i][j+1].player.equals("2")){
                        consecutive++;

                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if (board[i][j].player.equals("2") && !(board[i][j+1].player.equals("2"))){
                        consecutive = 0;
                    }
                }
            }
        }

        //-------------------------------------------------
        //Check Horizontal win
        for(int i=0; i < 8; i++){
            int consecutive = 0;
            for(int j=0; j < 7; j++){
                if(board[j][i].played == false){
                    consecutive = 0;
                    continue;
                }else{
                    if(board[j][i].player.equals("1") && board[j+1][i].player.equals("1")){
                        consecutive++;

                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if(board[j][i].player.equals("1") && !(board[j+1][i].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[j][i].player.equals("2") && board[j+1][i].player.equals("2")){
                        consecutive++;

                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if(board[j][i].player.equals("2") && !(board[j+1][i].player.equals("2"))){
                        consecutive = 0;
                    }
                }
            }
        }


        //--------------------------------------------------
        //check diagonal from left down to right top win

        for(int i=4; i <= 7; i++){
            int consecutive = 0;
            int x = 0;
            int y = i;
            int numOfLoop = i;
            for(int j=0; j < numOfLoop; j++){
                if(board[x][y].played == false){
                    consecutive = 0;
                }else{
                    if(board[x][y].player.equals("1") && board[x+1][y-1].player.equals("1")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("1") && !(board[x+1][y-1].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[x][y].player.equals("2") && board[x+1][y-1].player.equals("2")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("2") && !(board[x+1][y-1].player.equals("2"))){
                        consecutive = 0;
                    }
                }
                x += 1;
                y -= 1;
            }
        }

        for(int i=1; i <= 3; i++){
            int consecutive = 0;
            int x = i;
            int y = 7;
            int numOfLoop = y - x;
            for(int j=0; j < numOfLoop; j++){
                if(board[x][y].played == false){
                    consecutive = 0;
                }else{
                    if(board[x][y].player.equals("1") && board[x+1][y-1].player.equals("1")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("1") && !(board[x+1][y-1].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[x][y].player.equals("2") && board[x+1][y-1].player.equals("2")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("2") && !(board[x+1][y-1].player.equals("2"))){
                        consecutive = 0;
                    }
                }
                x += 1;
                y -= 1;
            }
        }

        //--------------------------------------------------
        //check diagonal from top right down to top left win

        for(int i=4; i <= 7; i++){
            int consecutive = 0;
            int x = 7;
            int y = i;
            int numOfLoop = i;
            for(int j=0; j < numOfLoop; j++){
                if(board[x][y].played == false){
                    consecutive = 0;
                }else{
                    if(board[x][y].player.equals("1") && board[x-1][y-1].player.equals("1")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("1") && !(board[x-1][y-1].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[x][y].player.equals("2") && board[x-1][y-1].player.equals("2")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("2") && !(board[x-1][y-1].player.equals("2"))){
                        consecutive = 0;
                    }
                }
                x -= 1;
                y -= 1;
            }
        }

        for(int i=4; i <= 6; i++){
            int consecutive = 0;
            int x = i;
            int y = 7;
            int numOfLoop = i;
            for(int j=0; j < numOfLoop; j++){
                if(board[x][y].played == false){
                    consecutive = 0;
                }else{
                    if(board[x][y].player.equals("1") && board[x-1][y-1].player.equals("1")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "1";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("1") && !(board[x-1][y-1].player.equals("1"))){
                        consecutive = 0;
                    }

                    if(board[x][y].player.equals("2") && board[x-1][y-1].player.equals("2")){
                        consecutive += 1;
                        if(consecutive == 4){
                            winnerID = "2";
                            return winnerID;
                        }
                    }else if(board[x][y].player.equals("2") && !(board[x-1][y-1].player.equals("2"))){
                        consecutive = 0;
                    }
                }
                x -= 1;
                y -= 1;
            }
        }
        //--------------------------------------------------
        //if no win and full
        boolean full = true;

        for (int i=0; i < 8; i++){
            for(int j=0; j < 8; j++){
                if(board[i][j].played == false){
                    full = false;
                    break;
                }
            }
        }

        if(full && winnerID == null){
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("No winner");
            alert.show();
            return "3";
        }
        //--------------------------------------------------
        //if no win
        return null;
    }
}
