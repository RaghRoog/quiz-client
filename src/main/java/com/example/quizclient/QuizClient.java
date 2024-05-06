package com.example.quizclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class QuizClient extends Application {

    static Scene scene;
    static String playerAnswer = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizClient.class.getResource("quiz-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 350, 350);
        stage.setTitle("Quiz");
        stage.setScene(scene);
        stage.show();
    }

    public static void clientAnswer(){
        TextField answerField = (TextField) scene.lookup("#answerField");
        TextField nickField = (TextField) scene.lookup("#nickField");
        playerAnswer = nickField.getText() + "|" + answerField.getText();
        answerField.setText("");
    }

    public static void sendPlayerAnswer(){
        try{
            clientAnswer();
            Socket socket = new Socket("localhost", 999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(playerAnswer);
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}