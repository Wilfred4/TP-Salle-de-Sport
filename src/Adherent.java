import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Adherent {
    private int id;
    private String nom;
    private Abonnement abonnement;
    private List<Reservation> reservations;

    public Adherent(int id, String nom, Abonnement abonnement, List<Reservation> reservations) {
        this.id = id;
        this.nom = nom;
        this.abonnement = abonnement;
        this.reservations = reservations;
    }

    public Reservation reserver(Seance s){
        Reservation r = new Reservation(s);
        reservations.add(r);
        return r;
    }

    public double depensesTotales(){
        double depensesTotal = 0;
        for(Reservation r : reservations){
            if (r.getStatut() == StatutReservation.CONFIRME){
                depensesTotal += r.coutPrestation();
            }
        }
        return depensesTotal;
    }

    public List<Reservation> reservationsFutures() {
        List<Reservation> futures = new ArrayList<>();
        LocalDateTime maintenant =  LocalDateTime.now();
        for(Reservation r : reservations){
            if (r.getSeance().getDateHeure().isAfter(maintenant)){
                futures.add(r);
            }

        }
        return futures;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Abonnement getAbonnement() {
        return abonnement;
    }

    @Override
    public String toString() {
        return "Adhérent : \n \t" +
                "id : " + id +
                " Nom : "+nom +
                " Abonnement : "+ abonnement;
    }
}
