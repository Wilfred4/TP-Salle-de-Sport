import java.time.LocalDateTime;
import java.util.ArrayList;

public class AbonnementBasic extends Abonnement{
    public AbonnementBasic(String reference, LocalDateTime dateDebut, int dureeMois, double prixMensuel) {
        super(reference, dateDebut, dureeMois, prixMensuel);
    }



    @Override
    public boolean permetAccesSauna() {
        return false;
    }

    @Override
    public int creditsCoachinclus() {
        return 0;
    }
}
