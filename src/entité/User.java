/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entité;

/**
 *
 * @author hzaat
 */
public class User {
    
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private int tel;
    private Boolean Isadmin;
    
    
    public User(){
    
    }
    
    public User(int id , String nom , String prenom , String adresse ,int tel ,Boolean Isadmin){
    
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.tel=tel;
        this.Isadmin=Isadmin;
    
    }
    
        public User( String nom , String prenom , String adresse ,int tel ){
    
        
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
        this.tel=tel;
        
    
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Boolean getIsadmin() {
        return Isadmin;
    }

    public void setIsadmin(Boolean Isadmin) {
        this.Isadmin = Isadmin;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", Isadmin=" + Isadmin + '}';
    }
    
    
}

