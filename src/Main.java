import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        Prestation sauna = new Prestation("SAUNA", "Accès sauna", 5);
        Prestation coach = new Prestation("COACH", "Séance coaching", 25);
        Prestation serviette = new Prestation("SERVIETTE", "Location serviette", 2);


        Seance s1 = new Seance(1, "Gym", LocalDateTime.now(), 20);
        Seance s2 = new Seance(2, "Yoga", LocalDateTime.of(2026, 3, 6, 14, 0), 15);
        Seance s3 = new Seance(3, "Vélo", LocalDateTime.of(2026, 3, 10, 18, 0), 25);


        Adherent a1 = new Adherent(1, "Bob",
                new AbonnementBasic("REF1", LocalDateTime.of(2026, 1, 1, 0, 0), 12, 30),
                new ArrayList<>());

        Adherent a2 = new Adherent(2, "Wili",
                new AbonnementPremium("REF2", LocalDateTime.now(), 6, 50, 5),
                new ArrayList<>());




        Reservation r1 = a1.reserver(s1);
        r1.ajouterPrestation(serviette);

        Reservation r2 = a1.reserver(s2);
        r2.ajouterPrestation(sauna);
        r2.ajouterPrestation(serviette);

        Reservation r3 = a2.reserver(s1);
        r3.ajouterPrestation(coach);
        r3.ajouterPrestation(sauna);

        Reservation r4 = a2.reserver(s3);
        r4.ajouterPrestation(serviette);


        r2.annuler();


        SalleDeSport salle = new SalleDeSport();
        salle.ajouterAdherent(a1);
        salle.ajouterAdherent(a2);
        salle.ajouterSeance(s1);
        salle.ajouterSeance(s2);
        salle.ajouterSeance(s3);


        System.out.println("\nLes Adhérents\n");
        System.out.println(a1);
        System.out.println(a2);


        System.out.println("\nRéservations futures de Alice");
        for (Reservation r : a1.reservationsFutures()) {
            System.out.println(r);
        }

        System.out.println("\nAdhérents avec accès sauna");
        for (Adherent a : salle.adherentsAvecSauna()) {
            System.out.println(a.getNom());
        }


        System.out.println("\nChiffre d'affaires prestations");
        System.out.println(salle.chiffreAffairesPrestations() + " €");

        // Test trouverAdherent avec exception
        System.out.println("\nRecherche adhérent");
        try {
            Adherent trouve = salle.trouverAdherent(1);
            System.out.println("Nom : " + trouve.getNom());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            Adherent introuvable = salle.trouverAdherent(3);
            System.out.println("Nom : " + introuvable.getNom());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}