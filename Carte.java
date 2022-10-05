import java.util.ArrayList;
import java.util.Arrays;

public class Carte {
    
    private static String[] couleurs = {"Coeur", "Trèfle", "Pique", "Carreau"};
    private static String[] valeurs = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
    private String couleur;
    private String valeur;

    public Carte(int couleur, int valeur) {
        this.couleur = couleurs[couleur];
        this.valeur = valeurs[valeur];
    }

    //cree un paquet de 52 cartes utilisant les valeurs définies dans les tableaux statiques
    public static Carte[] initialiserPaquet(){
        ArrayList<Carte> jeuCartes = new ArrayList<Carte>();
        for (int couleurIndex = 0; couleurIndex < couleurs.length; couleurIndex++)
        {
            for (int valeurIndex = 0; valeurIndex < valeurs.length; valeurIndex++)
            {
                    jeuCartes.add(new Carte(couleurIndex, valeurIndex));
            }
        }
        Carte[] paquet = new Carte[jeuCartes.size()];
        return jeuCartes.toArray(paquet);
    }

    // Permutte les indexes du tableau en utilisant le mélange de Durstenfeld
    // Collections.shuffle(); aurait également pu être utilisé
    public static Carte[] melangerCartes(Carte[] paquet) {

        for (int i = paquet.length - 1; i > 0; i--) {
            var j = (int)Math.floor(Math.random() * (i + 1));
            var temp = paquet[i];
            paquet[i] = paquet[j];
            paquet[j] = temp;
        }
        return paquet;
    }

    public String recupererCouleur() { return couleur; }
    public String recupererValeur() { return valeur; }
    public String recupererNom() { return valeur + " de " + couleur; }
        
    //comparaison de la valeur des cartes en fonction de la place dans le tableau statique
    //plus la carte se trouve à la fin du tableau, plus sa valeur est grande
    public Boolean aUneValeurPlusGrandeQue(Carte carte) {
        var valeurCarteComparée = Arrays.asList(valeurs).indexOf(carte.recupererValeur());
        var valeurMaCarte = Arrays.asList(valeurs).indexOf(valeur);

        return valeurMaCarte > valeurCarteComparée;
    }

    private void assignerCouleur(int couleur) { this.couleur = couleurs[couleur]; }
    private void assignerValeur(int valeur) { this.valeur = valeurs[valeur]; }

    public Boolean couleurIdentique(String couleur) { return this.couleur == couleur; }
    public Boolean valeurIdentique(String valeur) { return this.valeur == valeur; }

}


    
