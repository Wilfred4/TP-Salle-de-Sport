import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private Seance seance;
    private List<Prestation> prestations;
    private StatutReservation statut;


    public Reservation(Seance seance) {
        this.seance = seance;
        this.statut = StatutReservation.CONFIRME;
        this.prestations = new ArrayList<Prestation>();
    }

    public void ajouterPrestation(Prestation p) {
        prestations.add(p);
    }

    public double coutPrestation() {
        double cout = 0;
        for (Prestation p : prestations) {
            cout += p.getPrix();
        }
        return cout;
    }

    public void annuler(){
        this.prestations.clear();
        this.statut=StatutReservation.ANNULLEE;
    }

    public Seance getSeance() {
        return seance;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    @Override
    public String toString() {
        return "Reservation seance=  " + seance + ", prestations=" + prestations + ", cout=" +coutPrestation() + ", statut=" + statut+ '}';
    }


}
