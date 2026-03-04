import java.time.LocalDateTime;

public class AbonnementPremium extends Abonnement{
    private int creditsCoach;

    public AbonnementPremium(String reference, LocalDateTime dateDebut, int dureeMois, double prixMensuel, int creditsCoach) {
        super(reference, dateDebut, dureeMois, prixMensuel);
        this.creditsCoach = creditsCoach;
    }


    @Override
    public boolean permetAccesSauna() {
        return true;
    }

    @Override
    public int creditsCoachinclus() {
        return creditsCoach;
    }
}
