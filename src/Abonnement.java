import java.time.LocalDateTime;

public abstract class Abonnement {
    private String reference;
    private LocalDateTime dateDebut;
    private int dureeMois;
    private double prixMensuel;

    public Abonnement(String reference, LocalDateTime dateDebut, int dureeMois, double prixMensuel) {
        this.reference = reference;
        this.dateDebut = dateDebut;
        this.dureeMois = dureeMois;
        this.prixMensuel = prixMensuel;

    }

    public LocalDateTime dateFin() {
        return dateDebut.plusMonths(dureeMois);
    }

    public double coutTotal(){
        return prixMensuel * dureeMois;
    }

    public abstract boolean permetAccesSauna();

    public abstract int creditsCoachinclus();

    @Override
    public String toString() {
        return "Abonnement : " +
                "reference='" + reference + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin() +
                ", dureeMois=" + dureeMois +
                ", prixMensuel=" + prixMensuel +
                ", coutTotal=" + coutTotal() +
                ", sauna=" + permetAccesSauna() +
                ", creditsCoach=" + creditsCoachinclus();
    }


}
