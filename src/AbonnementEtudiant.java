import java.time.LocalDateTime;

public class AbonnementEtudiant extends Abonnement{

    private double reductionPourcent;

    public AbonnementEtudiant(String reference, LocalDateTime dateDebut, int dureeMois, double prixMensuel, double reductionPourcent) {
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.reductionPourcent = reductionPourcent;
    }


    @Override
    public boolean permetAccesSauna() {
        return false;
    }

    @Override
    public int creditsCoachinclus(){return 0;}

    @Override
    public double coutTotal() {

        return super.coutTotal() * (1 - reductionPourcent / 100);
    }
}
