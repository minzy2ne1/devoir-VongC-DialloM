package projet_session;


public class Employé {
 private int id;
 private String nom;
 private String poste;
 private double tauxHoraire;
 private double tauxHoraireSupplémentaire;

 public Employé(int id, String nom, String poste, double tauxHoraire, double tauxHoraireSupplémentaire) {
     this.id = id;
     this.nom = nom;
     this.poste = poste;
     this.tauxHoraire = tauxHoraire;
     this.tauxHoraireSupplémentaire = tauxHoraireSupplémentaire;
 }


 public int getId() {
     return id;
 }

 public String getNom() {
     return nom;
 }

 public String getPoste() {
     return poste;
 }

 public double getTauxHoraire() {
     return tauxHoraire;
 }

 public double getTauxHoraireSupplémentaire() {
     return tauxHoraireSupplémentaire;
 }

 //calculer le salaire
 public double calculerSalaire(double heuresTravaillées) {
     return heuresTravaillées * tauxHoraire;
 }

 public double calculerSalaireSupplémentaire(double heuresSupplémentaires) {
     return heuresSupplémentaires * tauxHoraireSupplémentaire;
 }
}
