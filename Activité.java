package projet_session;

import java.time.LocalDateTime;
import java.time.Duration;

public class Activité {
    private int employéId;
    private String projetId;
    private String discipline;
    private LocalDateTime heureDébut;
    private LocalDateTime heureFin;

    
    public Activité(int employéId, String projetId, String discipline, LocalDateTime heureDébut, LocalDateTime heureFin) {
        this.employéId = employéId;
        this.projetId = projetId;
        this.discipline = discipline;
        this.heureDébut = heureDébut;
        this.heureFin = heureFin;
    }

    public int getEmployéId() {
        return employéId;
    }

    public String getProjetId() {
        return projetId;
    }

    public String getDiscipline() {
        return discipline;
    }

    public LocalDateTime getHeureDébut() {
        return heureDébut;
    }

    public LocalDateTime getHeureFin() {
        return heureFin;
    }

    public void setHeureDébut(LocalDateTime heureDébut) {
        this.heureDébut = heureDébut;
    }

    public void setHeureFin(LocalDateTime heureFin) {
        this.heureFin = heureFin;
    }

    public boolean estValide() {
        return heureDébut != null && heureFin != null && heureDébut.isBefore(heureFin);
    }

    public long calculerDurée() {
        if (heureDébut != null && heureFin != null) {
            return Duration.between(heureDébut, heureFin).toHours();
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Employé ID: " + employéId +
               ", Projet ID: " + projetId +
               ", Discipline: " + discipline +
               ", Heure de début: " + heureDébut +
               ", Heure de fin: " + heureFin +
               ", Durée: " + calculerDurée() + " heures";
    }
}
