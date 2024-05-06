package com.example.quizclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    public void onSend(ActionEvent event){
        QuizClient.sendPlayerAnswer();
    }
}