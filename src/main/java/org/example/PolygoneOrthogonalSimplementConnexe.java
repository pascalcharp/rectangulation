package org.example;

import java.util.*;

public class PolygoneOrthogonalSimplementConnexe {

    ArrayList<Arete> aretes ;
    int nAretes ;

    public PolygoneOrthogonalSimplementConnexe(ArrayList<Arete> liste) {
        aretes = new ArrayList<>(liste) ;
        nAretes = aretes.size() ;
    }

    public PolygoneOrthogonalSimplementConnexe(PolygoneOrthogonalSimplementConnexe poly) {
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
            if (i % 2 == 0) {
                if (!(aretes.get(i) instanceof AreteVerticale)) return false ;
            }
            else if (!(aretes.get(i) instanceof AreteHorizontale)) return false ;
        }
        return true ;
    }
}
