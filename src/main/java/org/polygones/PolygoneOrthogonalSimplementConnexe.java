package org.polygones;

import java.util.*;


/**
 * Classe représentant des polygones orthogonaux, donc constitués uniquement d'arêtes verticales et horizontales.
 * Ils sont simplement connexes, donc sans aucun trou, et ne se croisent pas.
 * On va supposer que les arêtes verticales alternent avec les arêtes horizontales.
 */

public class PolygoneOrthogonalSimplementConnexe {

    ArrayList<Arete> aretes ;
    int nAretes ;

    public PolygoneOrthogonalSimplementConnexe(ArrayList<Arete> liste) {
        aretes = new ArrayList<>(liste) ;
        nAretes = aretes.size() ;

        assert invariant() ;
    }

    public PolygoneOrthogonalSimplementConnexe(PolygoneOrthogonalSimplementConnexe poly) {
        nAretes = poly.nAretes ;
        aretes = new ArrayList<>(poly.aretes) ;
    }

    public int getnAretes() {
        return nAretes ;
    }

    public ArrayList<Arete> getAretes() {
        return aretes ;
    }

    private boolean invariant() {
        if (aretes.size() % 2 != 0) return false ;
        for (int i = 0; i < aretes.size(); i++) {
            if ((aretes.get(i).fin() != aretes.get((i+1)%nAretes).position()) && (aretes.get(i).debut() != aretes.get((i+1)%nAretes).position())) return false ;
            if (i % 2 == 0) {
                if (!(aretes.get(i) instanceof AreteVerticale)) return false ;
            }
            else if (!(aretes.get(i) instanceof AreteHorizontale)) return false ;
        }
        return true ;
    }
}
