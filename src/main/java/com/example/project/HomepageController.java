package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
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
    private AnchorPane CPlusProgramBar;

    @FXML
    private AnchorPane CProgramBar;

    @FXML
    private AnchorPane CprogramPage;

    @FXML
    private AnchorPane Css;

    @FXML
    private AnchorPane Html;

    @FXML
    private AnchorPane JavaBar;

    @FXML
    private AnchorPane JavaScript;

    @FXML
    private Button ProgrBtn;

    @FXML
    private Button ProgrBtn1;

    @FXML
    private AnchorPane PythonBar;

    @FXML
    private AnchorPane aboutC;

    @FXML
    private AnchorPane aboutC1;

    @FXML
    private AnchorPane aboutC2;

    @FXML
    private AnchorPane aboutC3;

    @FXML
    private Button cPlus;

    @FXML
    private AnchorPane CPLusPage;

    @FXML
    private AnchorPane htmlPage;


    @FXML
    private Button cProgram;

    @FXML
    private Button css;

    @FXML
    private AnchorPane CssPage;


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
    private Button BackBtn;


    @FXML
    private Button BackBtnTohomes;


    @FXML
    private Button java;
    @FXML
    private Button javascriptToHome;

    @FXML
    private AnchorPane javaPage;
    @FXML
    private Button javaScript;

    @FXML
    private Button logoutBtn;
    @FXML
    private Button CPlusTOHome;

    @FXML
    private Button logoutBtn1;

    @FXML
    private Button nextPageBtn;

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
    @FXML
    private Button JavaTOHOme;
    @FXML
    private Button cssToHome;
    @FXML
    private Button pythonToHome;

    @FXML
    private Button learnJavaScript;
    @FXML
    private Button learnCss;
    @FXML
    private Button learnHtml;
    @FXML
    private Button htmlTOHome;
    @FXML
    private AnchorPane javaScriptPage;
    @FXML
    private Button progressBtn;
    @FXML
    private Button progressToHome;

    @FXML
    private LineChart<?, ?> progressChart;

    @FXML
    private AnchorPane progressPage;

    public HomepageController() {

    }


    public void displayUsername(){
        String user = username;
        user = user.substring(0,1).toUpperCase()+user.substring(1);

        homeUserName.setText(user);
    }

    public void switchPages(ActionEvent event) {

        if (event.getSource() == cProgram) {
            CprogramPage.setVisible(true);
        } else if (event.getSource() == cPlus) {
            CPLusPage.setVisible(true);
        } else if (event.getSource() == java) {
            javaPage.setVisible(true);
        } else if (event.getSource() == python) {
            pythonPage.setVisible(true);
        } else if (event.getSource()==learnJavaScript) {
            pagenoOne.setVisible(false);
            javaScriptPage.setVisible(true);
        } else if (event.getSource()==learnHtml) {
            pagenoOne.setVisible(false);
            htmlPage.setVisible(true);
        } else if (event.getSource()==learnCss) {
            pagenoOne.setVisible(false);
            CssPage.setVisible(true);
        } else if (event.getSource() == nextPageBtn) {
            pagenoOne.setVisible(true);
            nextPageBtn.setVisible(false);
        } else if (event.getSource() == BackBtn) {
            pagenoZero.setVisible(true);
            pagenoOne.setVisible(false);
            nextPageBtn.setVisible(true);
        }else if (event.getSource() == BackBtnTohomes){
            pagenoZero.setVisible(true);
            pagenoOne.setVisible(false);
            CprogramPage.setVisible(false);
        } else if (event.getSource()==CPlusTOHome) {
            pagenoZero.setVisible(true);
            CPLusPage.setVisible(false);
        }else if (event.getSource() == JavaTOHOme){
            pagenoZero.setVisible(true);
            javaPage.setVisible(false);
        } else if (event.getSource() == pythonToHome) {
            pagenoZero.setVisible(true);
            pythonPage.setVisible(false);
        } else if (event.getSource()==javascriptToHome) {
            pagenoOne.setVisible(true);
            javaScriptPage.setVisible(false);
        }else if (event.getSource()==htmlTOHome){
            pagenoOne.setVisible(true);
            htmlPage.setVisible(false);
        } else if (event.getSource()==cssToHome) {
            pagenoOne.setVisible(true);
            CssPage.setVisible(false);
        } else if (event.getSource()==progressBtn) {
            progressPage.setVisible(false);
            pagenoZero.setVisible(true);

        } else if (event.getSource()==progressToHome||event.getSource()==homeBTN) {
            progressPage.setVisible(false);
            pagenoOne.setVisible(false);
            pagenoZero.setVisible(true);
        } else if (event.getSource()==ProgrBtn) {
            pagenoZero.setVisible(false);
            progressPage.setVisible(true);

        }else if (event.getSource()==ProgrBtn1) {
            pagenoZero.setVisible(false);
            progressPage.setVisible(true);
        } else if (event.getSource()==homeBTN) {
            progressPage.setVisible(false);
            pagenoZero.setVisible(true);
        }
    }
    //LOGOUT
    public void switchTOMainPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainPage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchTOCpractice(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CPractice.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //JAVA PAGE
    public void switchTOJavaPractice(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("javapractice.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchTOCPlusPractice(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("CPlusPractice.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayUsername();
    }


}
