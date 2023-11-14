package org.example;

import java.util.*;

public class PolygoneOrthogonalNonConnexe {
    PolygoneOrthogonalSimplementConnexe exterieur ;
    ArrayList<PolygoneOrthogonalSimplementConnexe> trous ;
    ArrayList<PolygoneOrthogonalSimplementConnexe> quadrilateres = new ArrayList<>() ;
    PriorityQueue<AreteHorizontale> Q = new PriorityQueue<>(new OrdreHauteur()) ;
    Set<AreteVerticale> verticales = new TreeSet<>() ;

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
        PriorityQueue<AreteHorizontale> Q  = new PriorityQueue<>() ;
        ArrayList<Arete> colonnes = new ArrayList<>( ) ;

        // Ranger les arêtes verticales en ordre de hauteur dans une file Prioritaire Q
        mettreLesAretesEnFile () ;

        // Marquer chaque arête de son type: DEBUT, FUSIONNER, SEPARER, FIN
        marquerLesAretes() ;

        // Pour chaque arete verticale A dans V
        AreteHorizontale prochaine = Q.poll() ;
        AreteHorizontale fusion = null ;

        do {
            AreteHorizontale courante = prochaine ;
            switch(courante.type) {
                case DEBUT:
                    break ;
                case FIN:
                    break ;
                case SEPARATION:
                    break ;
                case FUSION:
                    break ;
                default:
                    throw new RuntimeException("Type d'arête non-reconnu.") ;
            }
            prochaine = Q.poll() ;
        } while (prochaine != null) ;

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
        // for a in AretesVerticales:
        //    Trouver a la plus à droite telle arete.croise(a)
    }

    private AreteHorizontale genererExtensionDroite(AreteHorizontale arete) {
        // for a in AretesVerticales:
        //     trouver a la plus à gauche telle que arete.croise(a)
    }

    private PolygoneOrthogonalSimplementConnexe fermerLaColonne(AreteHorizontale arete) {
        // Trouver dans la liste des colonnes la colonne telle que ah.superpose(arete) ;
        // Créer un polygone ah -> arete verticale -> arete -> arete verticale
        // Transférer ce polygone dans la liste des polygones finis
        // Retirer ah des colonnes
    }

    private void ouvrirUneColonne(AreteHorizontale arete) {
        // Mettre l'arête dans la liste des colonnes  (hashmap repéré par gauche-droite)
    }



    private void traiterAreteDebut(AreteHorizontale arete) {
        // Ajouter l'arête  à colonnes

    }

    private void traiterAreteFin(AreteHorizontale arete) {
        // Trouver la colonne correspondant à l'arete
        // Former un polygone avec la colonne, et retirer la colonne de colonnes
    }

    private void traiterAreteSeparation(AreteHorizontale arete) {
        // Générer extension gauche  (gauche = genererExtensionGauche(arete) ; )
        // Générer l'arête fusion gauche-arete et fusionner avec areteFusionN courante
        // Fusionner arete gauche avec fusionU
        // Ouvrir une colonne pour fusionU courante
        // reset fusionU U = null

        // Si prochaine est type ou niveau différent:
        // Générer extension droite
        // FusionN <- FusionN - droite  (N = new AreteHorizontal.merge(N, droite) ;
        // Fermer la colonne correspondant à l'arête de fusionN
        // Reset areteFusionN
        // Ouvrir colonne extension droite


    }

    private void traiterAreteFusion(AreteHorizontale fusion) {
        // Générer extension gauche
        // Générer l'arête de fusion areteFusionU-gauche-arete
        // N <- gauche-N
        // Fermer la colonne corespondant à N
        // reset fusionN

        // Si la prochaine est type ou niveau différent
        // Générer extension droite
        // U <- U - droite
        // Ouvrir une colonne pour l'arête U
        // Reset U
        // Fermer la colonne correspondant à l'arête droite
    }
}
