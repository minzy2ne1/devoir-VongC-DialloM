package projet_session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Projet {
    private String projetId;
    private String description;
    private LocalDateTime dateDebut;
    private LocalDateTime dateFin;
    private List<Activité> activités;

    
    public Projet(String projetId, String description, LocalDateTime dateDebut, LocalDateTime dateFin) {
        this.projetId = projetId;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.activités = new ArrayList<>(); // générer liste d'activités
    }

 
    public String getProjetId() {
        return projetId;
    }

    public void setProjetId(String projetId) {
        this.projetId = projetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }

    // ajouter activité au projet
    public void ajouterActivité(Activité activité) {
        this.activités.add(activité);
    }

    // Obtenir détails de l'activité
    public Activité obtenirDétailsActivité(int idActivité) {
        for (Activité activité : activités) {
            if (activité.getEmployéId() == idActivité) {
                return activité;
            }
        }
        return null;
    }
}
