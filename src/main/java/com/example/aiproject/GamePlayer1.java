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

public class GamePlayer1 implements Initializable {
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
            /*Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("No winner");
            alert.show();*/
            return "3";
        }
        //--------------------------------------------------
        //if no win
        return null;
    }

    public void Action0_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_0.setImage(image);
                Step s = new Step(true, "1");
                board[0][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_0.setImage(image);
                Step s = new Step(true, "1");
                board[1][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_0.setImage(image);
                Step s = new Step(true, "1");
                board[2][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_0.setImage(image);
                Step s = new Step(true, "1");
                board[3][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_0.setImage(image);
                Step s = new Step(true, "1");
                board[4][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_0.setImage(image);
                Step s = new Step(true, "1");
                board[5][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_0.setImage(image);
                Step s = new Step(true, "1");
                board[6][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_0(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            get_PossibleChoices();
            boolean exists = checkArrayExistence(possibleChoices, new int[]{7,0});

            if(exists == false){
                Alert.AlertType type = Alert.AlertType.WARNING;
                Alert alert = new Alert(type , "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setContentText("This action is not possible!");
                alert.getDialogPane().setHeaderText("Insertion error!");
                alert.show();
            }else{
                img7_0.setImage(image);
                Step s = new Step(true, "1");
                board[7][0] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_1.setImage(image);
                Step s = new Step(true, "1");
                board[0][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_1.setImage(image);
                Step s = new Step(true, "1");
                board[1][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_1.setImage(image);
                Step s = new Step(true, "1");
                board[2][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_1.setImage(image);
                Step s = new Step(true, "1");
                board[3][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_1.setImage(image);
                Step s = new Step(true, "1");
                board[4][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_1.setImage(image);
                Step s = new Step(true, "1");
                board[5][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_1.setImage(image);
                Step s = new Step(true, "1");
                board[6][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_1(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img7_1.setImage(image);
                Step s = new Step(true, "1");
                board[7][1] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_2.setImage(image);
                Step s = new Step(true, "1");
                board[0][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_2.setImage(image);
                Step s = new Step(true, "1");
                board[1][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_2.setImage(image);
                Step s = new Step(true, "1");
                board[2][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_2.setImage(image);
                Step s = new Step(true, "1");
                board[3][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_2.setImage(image);
                Step s = new Step(true, "1");
                board[4][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
            }else {
                img5_2.setImage(image);
                Step s = new Step(true, "1");
                board[5][2] = s;

                //---------------------------------

                String win = winner();
                if (win != null) {
                    if (win.equals("1")) {
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type, "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("Winner is 1");
                        alert.show();
                    } else if (win.equals("2")) {
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type, "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("winner is 2");
                        alert.show();
                    } else if (win.equals("3")) {
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type, "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    turnBlack = !turnBlack;
                    if (turnBlack) {
                        player.setText("1");
                    } else {
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_2.setImage(image);
                Step s = new Step(true, "1");
                board[6][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_2(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img7_2.setImage(image);
                Step s = new Step(true, "1");
                board[7][2] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_3.setImage(image);
                Step s = new Step(true, "1");
                board[0][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_3.setImage(image);
                Step s = new Step(true, "1");
                board[1][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_3.setImage(image);
                Step s = new Step(true, "1");
                board[2][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_3.setImage(image);
                Step s = new Step(true, "1");
                board[3][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_3.setImage(image);
                Step s = new Step(true, "1");
                board[4][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_3.setImage(image);
                Step s = new Step(true, "1");
                board[5][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_3.setImage(image);
                Step s = new Step(true, "1");
                board[6][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_3(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img7_3.setImage(image);
                Step s = new Step(true, "1");
                board[7][3] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_4.setImage(image);
                Step s = new Step(true, "1");
                board[0][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_4.setImage(image);
                Step s = new Step(true, "1");
                board[1][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_4.setImage(image);
                Step s = new Step(true, "1");
                board[2][4] = s;

                //---------------------------------

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
                }else if(win.equals("3")){
                    Alert.AlertType type = Alert.AlertType.WARNING;
                    Alert alert = new Alert(type , "");
                    alert.initModality(Modality.APPLICATION_MODAL);
                    alert.getDialogPane().setHeaderText("No winner");
                    alert.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_4.setImage(image);
                Step s = new Step(true, "1");
                board[3][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_4.setImage(image);
                Step s = new Step(true, "1");
                board[4][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_4.setImage(image);
                Step s = new Step(true, "1");
                board[5][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_4.setImage(image);
                Step s = new Step(true, "1");
                board[6][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_4(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img7_4.setImage(image);
                Step s = new Step(true, "1");
                board[7][4] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_5.setImage(image);
                Step s = new Step(true, "1");
                board[0][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_5.setImage(image);
                Step s = new Step(true, "1");
                board[1][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_5.setImage(image);
                Step s = new Step(true, "1");
                board[2][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_5.setImage(image);
                Step s = new Step(true, "1");
                board[3][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_5.setImage(image);
                Step s = new Step(true, "1");
                board[4][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_5.setImage(image);
                Step s = new Step(true, "1");
                board[5][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_5.setImage(image);
                Step s = new Step(true, "1");
                board[6][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_5(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            get_PossibleChoices();
            boolean exists = checkArrayExistence(possibleChoices, new int[]{7,5});

            if(exists == false){
                Alert.AlertType type = Alert.AlertType.WARNING;
                Alert alert = new Alert(type , "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setContentText("This action is not possible!");
                alert.getDialogPane().setHeaderText("Insertion error!");
                alert.show();
            }else{
                img7_5.setImage(image);
                Step s = new Step(true, "1");
                board[7][5] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_6.setImage(image);
                Step s = new Step(true, "1");
                board[0][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_6.setImage(image);
                Step s = new Step(true, "1");
                board[1][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_6.setImage(image);
                Step s = new Step(true, "1");
                board[2][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_6.setImage(image);
                Step s = new Step(true, "1");
                board[3][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_6.setImage(image);
                Step s = new Step(true, "1");
                board[4][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_6.setImage(image);
                Step s = new Step(true, "1");
                board[5][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_6.setImage(image);
                Step s = new Step(true, "1");
                board[6][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_6(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            get_PossibleChoices();
            boolean exists = checkArrayExistence(possibleChoices, new int[]{7,6});

            if(exists == false){
                Alert.AlertType type = Alert.AlertType.WARNING;
                Alert alert = new Alert(type , "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setContentText("This action is not possible!");
                alert.getDialogPane().setHeaderText("Insertion error!");
                alert.show();
            }else{
                img7_6.setImage(image);
                Step s = new Step(true, "1");
                board[7][6] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action0_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img0_7.setImage(image);
                Step s = new Step(true, "1");
                board[0][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action1_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img1_7.setImage(image);
                Step s = new Step(true, "1");
                board[1][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action2_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img2_7.setImage(image);
                Step s = new Step(true, "1");
                board[2][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action3_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img3_7.setImage(image);
                Step s = new Step(true, "1");
                board[3][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action4_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img4_7.setImage(image);
                Step s = new Step(true, "1");
                board[4][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action5_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img5_7.setImage(image);
                Step s = new Step(true, "1");
                board[5][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action6_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
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
                img6_7.setImage(image);
                Step s = new Step(true, "1");
                board[6][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void Action7_7(ActionEvent event) throws IOException  {
        if(turnBlack == true){
            Image image = null;
            try {
                image = new Image(new FileInputStream("src/main/resources/Images/black.png"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            get_PossibleChoices();
            boolean exists = checkArrayExistence(possibleChoices, new int[]{7,7});

            if(exists == false){
                Alert.AlertType type = Alert.AlertType.WARNING;
                Alert alert = new Alert(type , "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setContentText("This action is not possible!");
                alert.getDialogPane().setHeaderText("Insertion error!");
                alert.show();
            }else{
                img7_7.setImage(image);
                Step s = new Step(true, "1");
                board[7][7] = s;

                //---------------------------------

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
                    }else if(win.equals("3")){
                        Alert.AlertType type = Alert.AlertType.WARNING;
                        Alert alert = new Alert(type , "");
                        alert.initModality(Modality.APPLICATION_MODAL);
                        alert.getDialogPane().setHeaderText("No winner");
                        alert.show();
                    }
                    root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene= new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    turnBlack = !turnBlack;
                    if(turnBlack){
                        player.setText("1");
                    }else{
                        player.setText("2");
                    }
                    computerMove();
                }
            }
        }else{
            Alert.AlertType type = Alert.AlertType.WARNING;
            Alert alert = new Alert(type , "");
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.getDialogPane().setHeaderText("it's Player 2 turn!!!");
            alert.show();
        }
    }

    public void computerMove(){
        long startTime = System.currentTimeMillis();

        int x = -1;
        int y = -1;
        int score = -2;

        for(int i=0; i < 8; i++){
            for (int j=0; j < 8; j++){
                get_PossibleChoices();
                boolean exists = checkArrayExistence(possibleChoices, new int[]{i,j});

                if(exists){
                    Step s = new Step(true, "2");
                    Step sEmpty = new Step();
                    board[i][j] = s;

                    int tempScore = -1 * minimax(0, -1);
                    board[i][j] = sEmpty;

                    if(tempScore > score){
                        score = tempScore;
                        x = i;
                        y = j;
                    }
                }
            }
        }

        Step s = new Step(true, "2");
        board[x][y] = s;

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
            }else if(win.equals("3")){
                Alert.AlertType type = Alert.AlertType.WARNING;
                Alert alert = new Alert(type , "");
                alert.initModality(Modality.APPLICATION_MODAL);
                alert.getDialogPane().setHeaderText("No winner");
                alert.show();
            }
        }

        Image image = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/Images/white.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        if(x == 0 && y == 0){
            img0_0.setImage(image);
        }else if(x == 1 && y == 0){
            img1_0.setImage(image);
        }else if(x == 2 && y == 0){
            img2_0.setImage(image);
        }else if(x == 3 && y == 0){
            img3_0.setImage(image);
        }else if(x == 4 && y == 0){
            img4_0.setImage(image);
        }else if(x == 5 && y == 0){
            img5_0.setImage(image);
        }else if(x == 6 && y == 0){
            img6_0.setImage(image);
        }else if(x == 7 && y == 0){
            img7_0.setImage(image);
        }else if(x == 0 && y == 1){
            img0_1.setImage(image);
        }else if(x == 1 && y == 1){
            img1_1.setImage(image);
        }else if(x == 2 && y == 1){
            img2_1.setImage(image);
        }else if(x == 3 && y == 1){
            img3_1.setImage(image);
        }else if(x == 4 && y == 1){
            img4_1.setImage(image);
        }else if(x == 5 && y == 1){
            img5_1.setImage(image);
        }else if(x == 6 && y == 1){
            img6_1.setImage(image);
        }else if(x == 7 && y == 1){
            img7_1.setImage(image);
        }else if(x == 0 && y == 2){
            img0_2.setImage(image);
        }else if(x == 1 && y == 2){
            img1_2.setImage(image);
        }else if(x == 2 && y == 2){
            img2_2.setImage(image);
        }else if(x == 3 && y == 2){
            img3_2.setImage(image);
        }else if(x == 4 && y == 2){
            img4_2.setImage(image);
        }else if(x == 5 && y == 2){
            img5_2.setImage(image);
        }else if(x == 6 && y == 2){
            img6_2.setImage(image);
        }else if(x == 7 && y == 2){
            img7_2.setImage(image);
        }else if(x == 0 && y == 3){
            img0_3.setImage(image);
        }else if(x == 1 && y == 3){
            img1_3.setImage(image);
        }else if(x == 2 && y == 3){
            img2_3.setImage(image);
        }else if(x == 3 && y == 3){
            img3_3.setImage(image);
        }else if(x == 4 && y == 3){
            img4_3.setImage(image);
        }else if(x == 5 && y == 3){
            img5_3.setImage(image);
        }else if(x == 6 && y == 3){
            img6_3.setImage(image);
        }else if(x == 7 && y == 3){
            img7_3.setImage(image);
        }else if(x == 0 && y == 4){
            img0_4.setImage(image);
        }else if(x == 1 && y == 4){
            img1_4.setImage(image);
        }else if(x == 2 && y == 4){
            img2_4.setImage(image);
        }else if(x == 3 && y == 4){
            img3_4.setImage(image);
        }else if(x == 4 && y == 4){
            img4_4.setImage(image);
        }else if(x == 5 && y == 4){
            img5_4.setImage(image);
        }else if(x == 6 && y == 4){
            img6_4.setImage(image);
        }else if(x == 7 && y == 4){
            img7_4.setImage(image);
        }else if(x == 0 && y == 5){
            img0_5.setImage(image);
        }else if(x == 1 && y == 5){
            img1_5.setImage(image);
        }else if(x == 2 && y == 5){
            img2_5.setImage(image);
        }else if(x == 3 && y == 5){
            img3_5.setImage(image);
        }else if(x == 4 && y == 5){
            img4_5.setImage(image);
        }else if(x == 5 && y == 5){
            img5_5.setImage(image);
        }else if(x == 6 && y == 5){
            img6_5.setImage(image);
        }else if(x == 7 && y == 5){
            img7_5.setImage(image);
        }else if(x == 0 && y == 6){
            img0_6.setImage(image);
        }else if(x == 1 && y == 6){
            img1_6.setImage(image);
        }else if(x == 2 && y == 6){
            img2_6.setImage(image);
        }else if(x == 3 && y == 6){
            img3_6.setImage(image);
        }else if(x == 4 && y == 6){
            img4_6.setImage(image);
        }else if(x == 5 && y == 6){
            img5_6.setImage(image);
        }else if(x == 6 && y == 6){
            img6_6.setImage(image);
        }else if(x == 7 && y == 6){
            img7_6.setImage(image);
        }else if(x == 0 && y == 7){
            img0_7.setImage(image);
        }else if(x == 1 && y == 7){
            img1_7.setImage(image);
        }else if(x == 2 && y == 7){
            img2_7.setImage(image);
        }else if(x == 3 && y == 7){
            img3_7.setImage(image);
        }else if(x == 4 && y == 7){
            img4_7.setImage(image);
        }else if(x == 5 && y == 7){
            img5_7.setImage(image);
        }else if(x == 6 && y == 7){
            img6_7.setImage(image);
        }else if(x == 7 && y == 7){
            img7_7.setImage(image);
        }

        turnBlack = !turnBlack;
        if(turnBlack){
            player.setText("1");
        }else{
            player.setText("2");
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Execution time: " + executionTime + " milliseconds");
    }

    public int minimax(int depth, int player){
        String winnerOne = winner();
        if(winnerOne != null || depth == 4){
            if((winnerOne != null)){ //null if none won, else if someone won
                if(!(winnerOne.equals("3"))){
                    if(winnerOne.equals("1")){
                        return -1 * player;
                    }else if(winnerOne.equals("2")){
                        return player;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }

        int score = -2;
        for(int i=0; i < 8; i++){
            for(int j=0; j < 8; j++){
                get_PossibleChoices();
                boolean exists = checkArrayExistence(possibleChoices, new int[]{i,j});

                if(exists){
                    Step s;
                    if(player == -1){
                        s = new Step(true, "1");
                    }else{
                        s = new Step(true, "2");
                    }

                    Step sEmpty = new Step();
                    board[i][j] = s;

                    int tempScore = -1 * minimax(depth+1, player*-1);
                    board[i][j] = sEmpty;

                    if(tempScore > score){
                        score = tempScore;
                    }
                }
            }
        }
        return score;
    }
}
