package org.polygones;

import java.util.*;

import static org.polygones.PolygoneOrthogonalNonConnexe.Type.DEBUT;
import static org.polygones.PolygoneOrthogonalNonConnexe.Type.FIN;
import static org.polygones.Precision.DoubleEquals;

public class PolygoneOrthogonalNonConnexe {
    enum Type {DEBUT, FIN, SEPARATION, FUSION} ;

    PolygoneOrthogonalSimplementConnexe exterieur ;
    ArrayList<PolygoneOrthogonalSimplementConnexe> trous ;

    HashMap<AreteHorizontale, Type> types = new HashMap<>() ;
    ArrayList<AreteHorizontale> enCours = new ArrayList<>() ;
    PriorityQueue<AreteHorizontale> Q = new PriorityQueue<>() ;
    Set<AreteVerticale> verticales = new TreeSet<>() ;

    ArrayList<PolygoneOrthogonalSimplementConnexe> rectangles = new ArrayList<>() ;

    int total ;

    /**
     * Constructeur: initialise strictement les polygones, avec une liste d'arêtes alternées horizontales et verticales.
     * @param exterieurInit PolygoneOrthogonaleSimplementConnexe représentant l'enveloppe extérieure du polygone
     * @param trousInit Liste de polygones orthogonaux simplement connexes qui sont les trous contenus dans le précédent.
     */
    public PolygoneOrthogonalNonConnexe(PolygoneOrthogonalSimplementConnexe exterieurInit, ArrayList<PolygoneOrthogonalSimplementConnexe> trousInit) {
        exterieur = new PolygoneOrthogonalSimplementConnexe(exterieurInit) ;
        if (trousInit == null) {
            trous = new ArrayList<>() ;
        }
        else {
            trous = new ArrayList<>(trousInit) ;
        }

        total = exterieur.getnAretes() ;
        for (PolygoneOrthogonalSimplementConnexe trou: trous) {
            total += trou.getnAretes() ;
        }
    }

    /**
     * On va simplement ranger toutes les arêtes horizontales dans la file prioritaire.  Elles sortiront donc de la file
     * en ordre descendant de hauteur.  Pa définition, la plus haute sera la seule arête de type DEBUT.
     */
    private void mettreLesAretesHorizontalesEnFile() {
        for (Arete arete: exterieur.getAretes()) {
            if (arete instanceof AreteHorizontale) Q.add((AreteHorizontale) arete) ;
        }
        for (PolygoneOrthogonalSimplementConnexe trou: trous) {
            for (Arete arete: trou.getAretes()) {
                if (arete instanceof AreteHorizontale) Q.add((AreteHorizontale) arete) ;
            }
        }
    }

    /**
     * On va aussi ranger les arête verticales dans un arbre de tri.  Cela permettra de retrouver rapidement les
     * arêtes les plus proches de nos arêtes horizontales.
     */
    private void trierLesAretesVerticales() {
        for (Arete arete: exterieur.getAretes()) {
            if (arete instanceof AreteVerticale) verticales.add((AreteVerticale) arete) ;
        }
        for (PolygoneOrthogonalSimplementConnexe trou: trous) {
            for (Arete arete: trou.getAretes()) {
                if (arete instanceof AreteVerticale) verticales.add((AreteVerticale) arete) ;
            }
        }
    }

    private void marquerLesAretesDuPolygone(PolygoneOrthogonalSimplementConnexe pol) {
        ArrayList<Arete> aretes = pol.getAretes() ;
        for (int i = 0; i < aretes.size(); i++) {
            if (aretes.get(i) instanceof AreteVerticale) continue ;
            AreteHorizontale courante = (AreteHorizontale) aretes.get(i) ;
            AreteVerticale suivante = (AreteVerticale) aretes.get((i+1) % aretes.size()) ;
            AreteVerticale precedente = (AreteVerticale) aretes.get((i-1) % aretes.size()) ;

            if ((Double.compare(courante.position(), suivante.fin()) > 0) && (Double.compare(courante.position(), precedente.fin()) > 0)) {
                types.put(courante, Type.SEPARATION) ;
            }
            else if ((Double.compare(courante.position(), suivante.debut()) < 0) && (Double.compare(courante.position(), precedente.debut()) < 0)) {
                types.put(courante, Type.FUSION) ;
            }
            else {
                assert false ;
            }
        }
    }

    private void marquerLesAretes() {
        marquerLesAretesDuPolygone(exterieur) ;
        for (PolygoneOrthogonalSimplementConnexe trou: trous) {
            marquerLesAretesDuPolygone(trou) ;
        }
    }

    private void marquerLesAretesDebutEtFin() {
        double minimum = Double.MAX_VALUE ;
        double maximum = - Double.MAX_VALUE ;
        AreteHorizontale areteMax = null ;

        for (Arete arete: exterieur.getAretes()) {
            if (arete instanceof AreteHorizontale) {
                AreteHorizontale ah = (AreteHorizontale) arete ;
                if (ah.position() > maximum) {
                    maximum = ah.position() ;
                    areteMax = ah ;
                }
                if (ah.position() < minimum) {
                    minimum = ah.position() ;
                }
            }
        }
        types.replace(areteMax, DEBUT) ;

        for (Arete arete: exterieur.getAretes()) {
            if (arete instanceof AreteHorizontale) {
                AreteHorizontale ah = (AreteHorizontale) arete ;
                if (DoubleEquals(ah.position(), minimum)) {
                    types.replace(ah, FIN) ;
                }
            }
        }

    }



    public void decomposerEnRectangles() {

        mettreLesAretesHorizontalesEnFile() ;
        trierLesAretesVerticales() ;
        marquerLesAretes() ;
        marquerLesAretesDebutEtFin() ;


        AreteHorizontale prochaine = Q.poll() ;
        do {
            AreteHorizontale courante = prochaine ;
            switch(types.get(courante)) {
                case DEBUT:
                    traiterAreteDebut(courante) ;
                    break ;
                case FIN:
                    traiterAreteFin(courante) ;
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
    }


/*
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
    }*/



    private void traiterAreteDebut(AreteHorizontale arete) {
        enCours.add(arete) ;
    }

    private void traiterAreteFin(AreteHorizontale arete) {
        for (AreteHorizontale image: enCours) {
            if (DoubleEquals(image.debut(), arete.debut()) && DoubleEquals(image.fin(), arete.fin())) {
                AreteVerticale v1 = new AreteVerticale(arete.debut(), image.position(), arete.position()) ;
                AreteVerticale v2 = new AreteVerticale(arete.fin(), image.position(), arete.position()) ;
                ArrayList<Arete> trace = new ArrayList<>(Arrays.asList(v1, image, v2, arete)) ;
                rectangles.add(new PolygoneOrthogonalSimplementConnexe(trace)) ;
                break ;
            }
        }
    }

/*
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
    }*/
}
