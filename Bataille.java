import java.util.Arrays;

public class Bataille {

    public static void main(String[] args) {

        var joueur1 = new Joueur();

        var joueur2 = new Joueur();

        var paquet = Carte.initialiserPaquet();

        Carte.melangerCartes(paquet);

        //assignation à chaque joueur de la moitié du paquet de cartes
        joueur1.ajouterCartes(
            Arrays.copyOfRange(paquet, 0, (paquet.length + 1)/2)
        );
        
        joueur2.ajouterCartes(
            Arrays.copyOfRange(paquet, (paquet.length + 1)/2, paquet.length)
        );

        //DEBUT PARTIE
        //la partie se termine lorsqu'un joueur n'a plus de cartes ou lorsqu'un des joueurs obtient 1000 points
        while ((joueur1.cartes.length > 0 && joueur2.cartes.length > 0) && (joueur1.points < 1000 && joueur2.points < 1000)) {
            System.out.println("Les deux joueurs jouent une carte.");

            var carteJoueur1 = joueur1.jouerCarte();
            System.out.println("Joueur 1 a joué: " + carteJoueur1.recupererNom());

            var carteJoueur2 = joueur2.jouerCarte();
            System.out.println("Joueur 2 a joué: " + carteJoueur2.recupererNom());

            //si la valeur de la carte du joueur1 est > alors il récupère la carte du joueur 2 et obtient un point
            if(carteJoueur1.aUneValeurPlusGrandeQue(carteJoueur2))
            {
                joueur1.ajouterCarte(carteJoueur2);
                joueur2.retirerCarte(carteJoueur2);
                joueur1.ajouterPoint();
                System.out.println("Le joueur 1 remporte cette manche et récupère la carte du joueur 2.");
                System.out.println("Nombre de cartes joueur 1: " + joueur1.cartes.length);
                System.out.println("Nombre de points joueur 1: " + joueur1.points);
                System.out.println("Nombre de cartes joueur 2: " + joueur2.cartes.length);
                System.out.println("Nombre de points joueur 2: " + joueur2.points);
            }
            
            else if(carteJoueur2.aUneValeurPlusGrandeQue(carteJoueur1))
            {
                joueur2.ajouterCarte(carteJoueur1);
                joueur1.retirerCarte(carteJoueur1);
                joueur2.ajouterPoint();
                System.out.println("Le joueur 2 remporte cette manche et récupère la carte du joueur 1.");
                System.out.println("Nombre de cartes joueur 1: " + joueur1.cartes.length);
                System.out.println("Nombre de points joueur 1: " + joueur1.points);
                System.out.println("Nombre de cartes joueur 2: " + joueur2.cartes.length);
                System.out.println("Nombre de points joueur 2: " + joueur2.points);
            }
            //si la valeur est la même, aucun point n'est ajouté et les joueurs et la carte reste dans leur jeu
            else if(carteJoueur1.valeurIdentique(carteJoueur2.recupererValeur()))
                System.out.println("Egalité, le jeu continue !");
            
        }

        System.out.println("La partie est terminée !");

        if((joueur1.cartes.length > 0 && joueur2.cartes.length == 0) || joueur1.points == 1000) 
            System.out.println("Le joueur 1 remporte la partie.");
        else 
            System.out.println("Le joueur 2 remporte la partie.");
        
    }

}