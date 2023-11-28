package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CPlusPractice implements Initializable {


    @FXML
    private AnchorPane Array;

    @FXML
    private Button ArrayArray;

    @FXML
    private Button ArrayBasic;

    @FXML
    private Button ArrayFun;

    @FXML
    private Button ArrayStr;

    @FXML
    private Button BasicArr;

    @FXML
    private Button BasicArr1;

    @FXML
    private Button BasicBasic;

    @FXML
    private Button BasicFun;

    @FXML
    private AnchorPane BasicHome;

    @FXML
    private AnchorPane BasicPageOne;

    @FXML
    private Button BasicStr;

    @FXML
    private Button Basicfun1;

    @FXML
    private Button CPlusArrayBackBtn;

    @FXML
    private Button CPlusArrayNrxtBtn;

    @FXML
    private Button CPlusBackBtn;

    @FXML
    private Button CPlusBasicBackBtn1;

    @FXML
    private Button CPlusBasicNrxtBtn1;

    @FXML
    private Button CPlusFunctionBackBtn;

    @FXML
    private Button CPlusFunctionNrxtBtn;

    @FXML
    private Button CPlusNrxtBtn;

    @FXML
    private Button CPlusStringBackBtn;

    @FXML
    private AnchorPane Function;

    @FXML
    private Button FunctionArr;

    @FXML
    private Button FunctionBasic;

    @FXML
    private Button FunctionFunction;

    @FXML
    private Button FunctionStr;

    @FXML
    private Button StringArr;

    @FXML
    private Button StringBasic;

    @FXML
    private Button StringFun;

    @FXML
    private Button StringString;

    @FXML
    private AnchorPane string;

    //page swiping

    public  void swiping(ActionEvent event){
        if (event.getSource() == CPlusNrxtBtn){
            BasicPageOne.setVisible(true);
            BasicHome.setVisible(false);
        }else if (event.getSource() == CPlusBasicNrxtBtn1){
            BasicPageOne.setVisible(false);
            Array.setVisible(true);
        } else if (event.getSource()==CPlusArrayNrxtBtn) {
            Array.setVisible(false);
            Function.setVisible(true);
        } else if (event.getSource()==CPlusFunctionNrxtBtn) {
            Function.setVisible(false);
            string.setVisible(true);
        }
    }
public void swipBack(ActionEvent event){
        if (event.getSource()==CPlusBasicBackBtn1){
            BasicPageOne.setVisible(false);
            BasicHome.setVisible(true);
        } else if (event.getSource()==CPlusArrayBackBtn) {
            Array.setVisible(false);
            BasicPageOne.setVisible(true);
        }else if (event.getSource()==CPlusFunctionBackBtn){
            Function.setVisible(false);
            Array.setVisible(true);
        } else if (event.getSource()==CPlusStringBackBtn) {
            string.setVisible(false);
            Function.setVisible(true);
        }
}

//public void(ActionEvent event){
//        if (event.getSource()==BasicArray){
//            BasicHome.setVisible(false);
//            Array.setVisible(true);
//        }
//}

    public void switchTOHomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homePage.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
