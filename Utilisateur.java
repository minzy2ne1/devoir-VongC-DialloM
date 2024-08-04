package projet_session;

public class Utilisateur {
    private String id;
    private String motDePasse;
    private String nom;
    private String email;

    public Utilisateur() {
    }

    public Utilisateur(String id, String motDePasse, String nom, String email) {
        this.id = id;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //authentification
    public boolean authentifier(String id, String motDePasse) {
        return this.id.equals(id) && this.motDePasse.equals(motDePasse);
    }

    //valider l'utilisateur
    public void validerUtilisateur() {
       
    }

    //obtenir les détails du projet
    public Projet obtenirDétailsProjet(int idProjet) {
        
        return null;
    }

    //débuter une activité
    public Activité débuterActivité(int idProjet) {
        
        return null;
    }

    // Méthode pour terminer une activité
    public void terminerActivité(int idActivité) {
        // Implémentez ici la logique pour terminer une activité
    }
}
