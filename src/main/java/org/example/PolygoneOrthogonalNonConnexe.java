package org.example;

import java.util.ArrayList;

public class PolygoneOrthogonalNonConnexe {
    PolygoneOrthogonalSimplementConnexe exterieur ;
    ArrayList<PolygoneOrthogonalSimplementConnexe> trous ;

    int total ;

    enum Type {DEBUT, FIN, SEPARATION, FUSION} ;

    ArrayList<Type> types = new ArrayList<>() ;

    PolygoneOrthogonalNonConnexe(PolygoneOrthogonalSimplementConnexe exterieurInit, ArrayList<PolygoneOrthogonalSimplementConnexe> trousInit) {
        exterieur = new PolygoneOrthogonalSimplementConnexe(exterieurInit) ;
        trous = new ArrayList<>(trousInit) ;
        total = exterieur.getnAretes() ;
        for (PolygoneOrthogonalSimplementConnexe trou: trous) {
            total += trou.getnAretes() ;
        }
        types = new ArrayList<Type>() ;
    }



    public ArrayList<PolygoneOrthogonalSimplementConnexe> decomposerEnRectangles() {
        // Ranger les arêtes verticales en ordre de hauteur dans une file Prioritaire Q
        // Marquer chaque arête de son type: DEBUT, FUSIONNER, SEPARER, FIN
        // Initialiser un ArrayList d'Arraylists d'aretesOrthogonales vide: colonnes
        // Pour chaque arete verticale A dans V
        // Traiter l'arête selon son type
        return new ArrayList<>() ;
    }

    private void marquerLesAretes() {

        // Localiser la plus haute arête horizontale, c'est une arête DEBUT.

        double hauteurMax = - Double.MAX_VALUE ;
        int indexMax = 0 ;
        for (Arete arete: exterieur.getAretes()) {
            if (arete instanceof AreteHorizontale && arete.position() > hauteurMax) {
                hauteurMax = arete.position() ;
                indexMax = exterieur.getAretes().indexOf(arete) ;
            }
        }
        // Passer chaque arête vers la droite, à partir de cette arête
        // Ce qu'il y a à droite est l'intérieur, ce qu'il y a à gauche est l'intérieur
        // Si l'arête est horizontale, de début vers fin, si les arêtes verticales sont à gauche
        // alors les arêtes sont vers l'extérieur
        // Sens absolu des arêtes verticales = U ou N
        // DEBUT: Type N, Polygone extérieur, contenant l'intérieur
        // FIN: Type U, Polygone extérieur, contenant l'intérieur
        // SEPARATION: Type N, trou ou polygone extérieur contenant l'extérieur
        // FUSION: Type U, trou ou polygone extérieur, contenant l'extérieur
    }

    private AreteHorizontale genererExtensionGauche(AreteHorizontale arete) {

    }

    private AreteHorizontale genererExtensionDroite(AreteHorizontale arete) {

    }

    private PolygoneOrthogonalSimplementConnexe fermerLaColonne(AreteHorizontale arete) {

    }

    private void ouvrirUneColonne(AreteHorizontale arete) {

    }



    private void traiterAreteDebut(AreteVerticale arete) {
        // Ajouter l'arête et ses deux voisines à colonnes

    }

    private void traiterAreteFin(AreteVerticale arete) {
        // Trouver la colonne correspondant à l'arete
        // Former un polygone avec la colonne, et retirer la colonne de colonnes
    }

    private void traiterAreteSeparation(AreteVerticale arete) {
        // Générer les arêtes extensions gauche et droite
        // Générer l'arête fusion gauche-arete-droite
        // Fermer la colonner correspondant à l'arête de fusion
        // Ouvrir une colonne pour l'arête gauche et une colonne pour l'arête droite


    }

    private void traiterAreteFusion(AreteVerticale fusion) {
        // Générer les arêtes extensions gauche et droite
        // Générer l'arête de fusion gauche-arete-droite
        // Fermer la colonne corespondant à l'arête gauche
        // Fermer la colonne correspondant à l'arête droite
        // Ouvrir une colonne pour l'arête fusion
    }
}
