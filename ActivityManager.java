package projet_session;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class ActivityManager {

    public static void main(String[] args) {
        // Créer des projets
        Projet projet1 = new Projet("projet1", "Développement d'une application",
                LocalDateTime.of(2024, 8, 6, 8, 0), LocalDateTime.of(2024, 8, 31, 17, 0));
        Projet projet2 = new Projet("projet2", "Analyse des données",
                LocalDateTime.of(2024, 8, 6, 8, 0), LocalDateTime.of(2024, 8, 31, 17, 0));
        Projet projet3 = new Projet("projet3", "Tests de fonctionnalité",
                LocalDateTime.of(2024, 8, 6, 8, 0), LocalDateTime.of(2024, 8, 31, 17, 0));

        // Créer les objets système
        Système système1 = new Système(projet1);
        Système système2 = new Système(projet2);
        Système système3 = new Système(projet3);

        // Créer et enregistrer les activités
        List<Activité> activités = créerActivités();
        for (Activité activité : activités) {
            afficherActivité(activité);

            // Enregistrer l'activité dans le système de projet 
            if (activité.getProjetId().equals("projet1")) {
                système1.enregistrerActivité(activité);
            } else if (activité.getProjetId().equals("projet2")) {
                système2.enregistrerActivité(activité);
            } else if (activité.getProjetId().equals("projet3")) {
                système3.enregistrerActivité(activité);
            }
        }
    }

    public static List<Activité> créerActivités() {
        List<Activité> activités = new ArrayList<>();

        // Définir la date de début et de fin pour les activités
        LocalDateTime startDate = LocalDateTime.of(2024, 8, 6, 8, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, 8, 31, 17, 0);

        // Parcourir chaque jour dans la plage
        LocalDateTime currentDate = startDate;
        while (currentDate.isBefore(endDate)) {
            // Vérifier si la date actuelle est un week-end et la sauter
            if (currentDate.getDayOfWeek() != DayOfWeek.SATURDAY && currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                
                // Définir les heures de début et de fin pour chaque projet
                LocalDateTime heureDébutProjet1 = currentDate.withHour(8).withMinute(0); // 8:00
                LocalDateTime heureFinProjet1 = heureDébutProjet1.plusHours(8); // 8 heures de travail
                
                LocalDateTime heureDébutProjet2 = currentDate.withHour(8).withMinute(0); // 8:00
                LocalDateTime heureFinProjet2 = heureDébutProjet2.plusHours(7).plusMinutes(30); // 7.5 heures de travail

                LocalDateTime heureDébutProjet3 = currentDate.withHour(8).withMinute(0); // 8:00
                LocalDateTime heureFinProjet3 = heureDébutProjet3.plusHours(9); // 9 heures de travail

                // Ajouter des heures supplémentaires aléatoires pour chaque projet à des jours différents
                // Projet 1 : Lundi et Mercredi
                if (currentDate.getDayOfWeek() == DayOfWeek.MONDAY || currentDate.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                    heureFinProjet1 = heureFinProjet1.plusHours(2); // 2 heures supplémentaires
                }

                // Projet 2 : Mardi et Jeudi
                if (currentDate.getDayOfWeek() == DayOfWeek.TUESDAY || currentDate.getDayOfWeek() == DayOfWeek.THURSDAY) {
                    heureFinProjet2 = heureFinProjet2.plusHours(1); // 1 heure supplémentaire
                }

                // Projet 3 : Vendredi
                if (currentDate.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    heureFinProjet3 = heureFinProjet3.plusHours(2); // 2 heures supplémentaires
                }

                // Créer des activités pour chaque projet et employé
                activités.add(new Activité(1, "projet1", "développement", heureDébutProjet1, heureFinProjet1));
                activités.add(new Activité(2, "projet2", "analyse", heureDébutProjet2, heureFinProjet2));
                activités.add(new Activité(3, "projet3", "test", heureDébutProjet3, heureFinProjet3));
            }

            // Passer au jour suivant
            currentDate = currentDate.plusDays(1);
        }

        return activités;
    }

    // Méthode pour afficher les détails d'une activité
    public static void afficherActivité(Activité activité) {
        System.out.println("Employé ID: " + activité.getEmployéId());
        System.out.println("Projet ID: " + activité.getProjetId());
        System.out.println("Discipline: " + activité.getDiscipline());
        System.out.println("Heure de début: " + activité.getHeureDébut());
        System.out.println("Heure de fin: " + activité.getHeureFin());
        System.out.println("Durée: " + activité.calculerDurée() + " heures");
        System.out.println();
    }
}
