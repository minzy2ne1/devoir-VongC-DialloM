package projet_session;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;



public class Système {
    private Projet projet;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public Système(Projet projet) {
        this.projet = projet;
    }

    public void débuterActivité(int idActivité) {
        Activité activité = projet.obtenirDétailsActivité(idActivité);
        if (activité != null) {
            LocalDateTime heureDébut = LocalDateTime.now().withHour(9).withMinute(0).withSecond(0);
            activité.setHeureDébut(heureDébut);
            System.out.println("Activité débutée pour l'employé ID: " + activité.getEmployéId());
            enregistrerActivité(activité);
        } else {
            System.out.println("Activité non trouvée pour l'ID: " + idActivité);
        }
    }

    public void terminerActivité(int idActivité) {
        Activité activité = projet.obtenirDétailsActivité(idActivité);
        if (activité != null) {
            LocalDateTime heureFin = LocalDateTime.now().withHour(17).withMinute(0).withSecond(0);
            activité.setHeureFin(heureFin);
            System.out.println("Activité terminée pour l'employé ID: " + activité.getEmployéId());
            enregistrerActivité(activité);
        } else {
            System.out.println("Activité non trouvée pour l'ID: " + idActivité);
        }
    }

    public void enregistrerActivité(Activité activité) {
        if (!activité.estValide()) {
            System.out.println("Impossible d'enregistrer une activité invalide.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("activité.txt", true))) {
            writer.write(activité.toString());
            writer.newLine();
            System.out.println("Activité enregistrée : " + activité.toString());
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement de l'activité : " + e.getMessage());
        }
    }
}
