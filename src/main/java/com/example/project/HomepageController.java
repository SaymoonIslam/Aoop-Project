package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.example.project.data.username;

public class HomepageController implements Initializable {
    @FXML
    private AnchorPane CprogramPage;

    @FXML
    private Button ProgrBtn;

    @FXML
    private Button ProgrBtn1;

    @FXML
    private AnchorPane aboutC;

    @FXML
    private AnchorPane aboutC1;

    @FXML
    private AnchorPane aboutC2;

    @FXML
    private AnchorPane aboutC3;

    @FXML
    private AnchorPane aboutC31;

    @FXML
    private Button cPlus;

    @FXML
    private AnchorPane cPlusPage;

    @FXML
    private Button cProgram;

    @FXML
    private Button css;

    @FXML
    private Button homeBTN;

    @FXML
    private Button homeBtn;

    @FXML
    private Label homeUserName;

    @FXML
    private Label homeUserName1;

    @FXML
    private StackPane homepage;

    @FXML
    private Button html;

    @FXML
    private Button java;

    @FXML
    private AnchorPane javaPage;

    @FXML
    private Button javaScript;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button logoutBtn1;

    @FXML
    private AnchorPane pagenoOne;

    @FXML
    private AnchorPane pagenoZero;

    @FXML
    private Button python;

    @FXML
    private AnchorPane pythonPage;

    @FXML
    private Button settingBtn;

    @FXML
    private Button settingBtn1;

    @FXML
    private Button taskBtn;

    @FXML
    private Button taskBtn1;


    public void displayUsername(){
        String user = username;
        user = user.substring(0,1).toUpperCase()+user.substring(1);

        homeUserName.setText(user);
    }

    public void switchPages(ActionEvent event){

        if (event.getSource() == cProgram ){
            CprogramPage.setVisible(true);
            cPlusPage.setVisible(false);
            pagenoZero.setVisible(false);
            pagenoOne.setVisible(false);
            javaPage.setVisible(false);
            pythonPage.setVisible(false);
        } else if (event.getSource()==cPlus) {
            cPlusPage.setVisible(true);
            CprogramPage.setVisible(false);
            pagenoZero.setVisible(false);
            pagenoOne.setVisible(false);
            javaPage.setVisible(false);
            pythonPage.setVisible(false);

        } else if (event.getSource()==java) {
            javaPage.setVisible(true);
            CprogramPage.setVisible(false);
            cPlusPage.setVisible(false);
            pagenoZero.setVisible(false);
            pagenoOne.setVisible(false);
            pythonPage.setVisible(false);
        }
        else if (event.getSource()==python) {
            javaPage.setVisible(false);
            CprogramPage.setVisible(false);
            cPlusPage.setVisible(false);
            pagenoZero.setVisible(false);
            pagenoOne.setVisible(false);
            pythonPage.setVisible(true);
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
    }
}
