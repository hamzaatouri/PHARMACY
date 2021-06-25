/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entité.Patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;

/**
 *
 * @author hzaat
 */
public class PatientService implements IsService<Patient>{
    
     private Connection connexion;
    private Statement ste;
    private ResultSet rs;
    
     public PatientService(){
    
        connexion = DataSource.getInstance().getCnx();
    }
     
 @Override
    public void insert(Patient p) {
        
        String requete="insert into patient(patient_name,patient_surname,patient_adresse,patient_tel,patient_email,patient_birthdate) values('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getAdresse()+"','"+p.getTel()+"','"+p.getMail()+"','"+p.getDate_de_naissance()+"')";

        try {
            ste = connexion.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public List readAll() {

         String requet="select * from patient";
        List<Patient> list=new ArrayList<>();
        try {
            ste=connexion.createStatement();
           rs= ste.executeQuery(requet);
           while(rs.next()){
               Patient p = new Patient(rs.getInt("id_patient"),rs.getString(2),rs.getString("patient_surname"),rs.getString("patient_adresse"),rs.getInt("patient_tel"),rs.getString("patient_email"),rs.getString("patient_birthdate"));
               list.add(p);
           }
        
        
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return list;
    }

    @Override
    public Patient readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        String requet = "DELETE FROM patient WHERE id_patient=?";
            
            Connection connection = DataSource.getInstance().getCnx();
        try {
            PreparedStatement pst = connection.prepareStatement(requet);
            pst.setInt(1,id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Patient p) {
        
         String requet = "UPDATE patient SET patient_name = ? , " + "patient_surname = ? " + "WHERE id_patient = ?";
         Connection connection = DataSource.getInstance().getCnx();
        try {
           PreparedStatement pst = connection.prepareStatement(requet);
            ste = connexion.createStatement();
            pst.setString(1,p.getNom());
            pst.setString(2,p.getPrenom() );
            pst.setInt(3,p.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PatientService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

   




    

    
    

   
    
}
