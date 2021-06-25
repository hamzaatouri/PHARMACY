/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entité.Patient;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import service.PatientService;

/**
 * FXML Controller class
 *
 * @author hzaat
 */
public class ListPatientController implements Initializable {
    
    ObservableList patient=FXCollections.observableArrayList();

    @FXML
    private ListView<String> list;


    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lister();
    }    

    private void lister(){
        
        PatientService ps = new PatientService();
        patient.addAll(ps.readAll());
        list.getItems().addAll(patient);
        
    }



    
}
