import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Joueur {

    public Carte[] cartes = {};

    public int points = 0;


    public void ajouterCartes(Carte[] nouvellesCartes) {

        //utilisation d'un arraylist pour modifier les valeurs plus facilement qu'avec un array classique
        List<Carte> jeuCartes = new ArrayList<Carte>(Arrays.asList(cartes));
        // Ajouter les nouveaux éléments
        for (Carte carte : nouvellesCartes) {
            jeuCartes.add(carte);
        }
        // Convertit l'ArrayList en array
        this.cartes = jeuCartes.toArray(cartes);
    }

    public void ajouterCarte(Carte nouvelleCarte) {

        List<Carte> jeuCartes = new ArrayList<Carte>(Arrays.asList(cartes));
        jeuCartes.add(nouvelleCarte);
        this.cartes = jeuCartes.toArray(cartes);
    }

    //renvoie aléatoirement une carte depuis la main du joueur
    public Carte jouerCarte() {
        return cartes[(int)Math.floor(Math.random() * cartes.length)];
    }

    public void retirerCarte(Carte carte) {

        List<Carte> jeuCartes = new ArrayList<Carte>(Arrays.asList(cartes));
        // Supprime element
        jeuCartes.remove(carte);
        // Convertit l'ArrayList en array
        Carte[] nouveauJeu = new Carte[jeuCartes.size()];
        nouveauJeu = jeuCartes.toArray(nouveauJeu);
        this.cartes = nouveauJeu;
    }

    public void ajouterPoint() {
        points = points + 1;
    }
}
