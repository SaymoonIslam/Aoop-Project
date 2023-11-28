package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.*;


public class HelloController {
    @FXML
    private AnchorPane ForgotPasswordPage;

    @FXML
    private AnchorPane LoginPage;

    @FXML
    private AnchorPane Registration;

    @FXML
    private TextField for_Ans;

    @FXML
    private TextField for_FirstName;

    @FXML
    private ComboBox<String> for_Qus;

    @FXML
    private TextField for_phone;

    @FXML
    private Hyperlink link_kogin;

    @FXML
    private Button login_Button;

    @FXML
    private Hyperlink login_ForgotPass;

    @FXML
    private PasswordField login_Password;

    @FXML
    private CheckBox login_ShowPassword;

    @FXML
    private TextField login_UserName;

    @FXML
    private TextField login_passwordText;

    @FXML
    private TextField login_passwordText1;

    @FXML
    private TextField login_passwordText11;

    @FXML
    private TextField login_passwordText111;

    @FXML
    private TextField new_coPassword;

    @FXML
    private TextField new_password;

    @FXML
    private AnchorPane new_passwordPage;

    @FXML
    private Button nextBtn;

    @FXML
    private Button nextBtn1;

    @FXML
    private TextField reg_Ans;

    @FXML
    private TextField reg_FirstName;

    @FXML
    private TextField reg_Password;

    @FXML
    private ComboBox<String> reg_Qus;

    @FXML
    private TextField reg_number;

    @FXML
    private Hyperlink register;
    @FXML
    private Parent parent;
    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Button signUp;
    @FXML
    private Button forBackBtn;


    @FXML
    private Connection connect;
    private PreparedStatement prepar;
    private ResultSet result;
    private Statement statement;
    private alertMessage alert;


//DATA BASE CONNECTION

    public Connection connectionDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
    public void switchTOMainPage() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("homepage.fxml")));
        Stage stage = (Stage) login_UserName.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    //LOG IN PAGE
    public void login() throws SQLException {
        alertMessage alert = new alertMessage();


        if (login_UserName.getText().isEmpty() ||login_Password.getText().isEmpty()) {
            alert.errorMessage("Input username or Password");
        } else {
            String selectData = "SELECT username, password FROM signup WHERE " + "username = ? and password = ?";

            connect = connectionDB();

            try {
                prepar = connect.prepareStatement(selectData);
                prepar.setString(1, login_UserName.getText());
               // prepar.setString(2, login_Password.getText());
                prepar.setString(2, login_Password.isVisible() ? login_Password.getText() : login_passwordText.getText());


                result = prepar.executeQuery();

                if (result.next()) {
                    // GO TO MAIN PAGE

                    data.username = login_UserName.getText();
                    alert.successMessage("Successfully login");
                    switchTOMainPage();
                } else {
                    alert.errorMessage("Incorrect Username or Password");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                // Close resources in reverse order of acquisition
                if (result != null) {
                    try {
                        result.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (prepar != null) {
                    try {
                        prepar.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                // You may also want to close 'connect' if it's not a shared connection across methods
            }
        }
    }


            /* REGISTER PAGE */
    public void register(){
        alert = new alertMessage();

        if (reg_FirstName.getText().isEmpty() || reg_number.getText().isEmpty()
                || reg_Password.getText().isEmpty() || reg_Qus.getSelectionModel().getSelectedItem() == null
                || reg_Ans.getText().isEmpty()) {
            alert.errorMessage("Please enter Username,Password or Qus and Answer");
        } else if (reg_Password.getText().length() < 8) {
            alert.errorMessage("Input password at least 8 characters needed");
        } else {
                String checkUsername = "SELECT * FROM signup WHERE username ='" + reg_FirstName.getText() + "'";
                connect = connectionDB();
            try {
                if (connect == null) {
                    alert.errorMessage("Failed to connect to the database");
                    return;
                }

                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    alert.errorMessage(reg_FirstName.getText() + "is already taken");
                } else {
                    String inserData = "INSERT INTO signup" + "(username,phonnumber,password,question,answer,date)" + "VALUES(?,?,?,?,?,?)";
                    prepar = connect.prepareStatement(inserData);
                    prepar.setString(1, reg_FirstName.getText());
                    prepar.setString(2, reg_number.getText());
                    prepar.setString(3, reg_Password.getText());
                    prepar.setString(4, (String) reg_Qus.getSelectionModel().getSelectedItem());
                    prepar.setString(5, reg_Ans.getText());
                    java.util.Date date = new java.util.Date(); // Fix the Date import
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepar.setString(6, String.valueOf(sqlDate));

                    prepar.executeUpdate();

                    alert.successMessage("Registered Successfully!");

                    registerClearField();

                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    //FOR PASS QUS
    public void forgotListQus() {
        List<String> list = new ArrayList<>(Arrays.asList(questionList));
        ObservableList<String> listData = FXCollections.observableArrayList(list);
        for_Qus.setItems(listData);
    }

    //FORGOT PASSWORD PAGE
    public void forgotPass(){
        alertMessage alert = new alertMessage();

        if (for_FirstName.getText().isEmpty()|| for_phone.getText().isEmpty()||
        for_Qus.getSelectionModel().getSelectedItem() == null||for_Ans.getText().isEmpty()){
            alert.errorMessage("Please fill all input file");
        }else{
            String checkData = "SELECT username, phonnumber, question, answer FROM signup " +
                    "WHERE username = ? AND phonnumber = ? AND question = ? AND answer = ?";


            connect = connectionDB();

            try {
                prepar = connect.prepareStatement(checkData);
                prepar.setString(1,for_FirstName.getText());
                prepar.setString(2,for_phone.getText());
                prepar.setString(3,(String)for_Qus.getSelectionModel().getSelectedItem());
                prepar.setString(4,for_Ans.getText());

                result = prepar.executeQuery();
                // IF CORRECT
                if (result.next()){
                    LoginPage.setVisible(false);
                    LoginPage.setVisible(false);
                    Registration.setVisible(false);
                    ForgotPasswordPage.setVisible(false);
                    
                    new_passwordPage.setVisible(true);

                    //forgotListQus();
                }
                else {
                    alert.errorMessage("Incorrect information");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    //CHANGE PASSWORD
    public  void changePass(){
        alert = new alertMessage();
        if ((new_password.getText().isEmpty()||new_coPassword.getText().isEmpty())){
            alert.errorMessage("Please fill all fields");
        }else  if(!new_password.getText().equals(new_coPassword.getText())){
            alert.errorMessage("Password does not match");
        }else if(new_password.getText().length()<8){
            alert.errorMessage("Invalid Password! at least 8 character needed");
        }else {
            String updateData = "UPDATE signup SET password = ?, date = ?"+
                    "WHERE username = '"+ for_FirstName.getText() +"'";

            connect = connectionDB();

            try {
                prepar = connect.prepareStatement(updateData);
                prepar.setString(1,new_password.getText());

                java.util.Date date = new java.util.Date(); // Fix the Date import
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                prepar.setString(2,String.valueOf(sqlDate));
                alert.successMessage("Successfully change Password");

                LoginPage.setVisible(true);
                Registration.setVisible(false);
                ForgotPasswordPage.setVisible(false);
                new_passwordPage.setVisible(false);

                login_UserName.setText("");
                login_Password.setText("");

                //showLoginPage();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //Clear register fields from
    public void registerClearField(){
        reg_FirstName.setText("");
        reg_number.setText("");
        reg_Password.setText("");
        reg_Qus.getSelectionModel().clearSelection();
        reg_Ans.setText("");
    }

    //QUESTIONS
    final String[] questionList = {"What is your favorite food?", "What is your favorite color?", "What is your favorite sport?",
            "What is the name of your place of birth?", "What is the name of your pet?"};
    public void questions () {
        List<String> list = new ArrayList<>(Arrays.asList(questionList));
        ObservableList<String> listData = FXCollections.observableArrayList(list);
        reg_Qus.setItems(listData);
    }


    //PASSWORD SHOW
    public void showPass() {

        if (login_ShowPassword.isSelected()) {
            login_passwordText.setText(login_Password.getText());
            login_passwordText.setVisible(true);
            login_Password.setVisible(false);
        } else {

            login_Password.setText(login_passwordText.getText());
            login_passwordText.setVisible(false);
            login_Password.setVisible(true);

        }
    }

    //SWIPE FIELD

    public void switchFrom(ActionEvent event){

        if (event.getSource() == register){
            Registration.setVisible(true);
            LoginPage.setVisible(false);
            ForgotPasswordPage.setVisible(false);
            new_passwordPage.setVisible(false);
        } else if (event.getSource()==link_kogin) {
            LoginPage.setVisible(true);
            Registration.setVisible(false);
            ForgotPasswordPage.setVisible(false);
            new_passwordPage.setVisible(false);
            
        } else if (event.getSource()==nextBtn) {
            ForgotPasswordPage.setVisible(true);
            LoginPage.setVisible(false);
            Registration.setVisible(false);
            new_passwordPage.setVisible(false);
        } else if (event.getSource() == forBackBtn){
            LoginPage.setVisible(true);
            ForgotPasswordPage.setVisible(false);
        }


    }

    public void showLoginPage () {
        LoginPage.setVisible(true);
        Registration.setVisible(false);
        ForgotPasswordPage.setVisible(false);
        LoginPage.setVisible(false);
        new_passwordPage.setVisible(false);
    }


    public void showRegistrationPage () {
        login_UserName.setText("");
        login_Password.setText("");

        LoginPage.setVisible(false);
        Registration.setVisible(true);
    }
    public void showForgotPage () {
        ForgotPasswordPage.setVisible(true);
        LoginPage.setVisible(false);
        // Registration.setVisible(false);
    }

    public void initialize () {
        questions();
        forgotListQus();
    }





}

