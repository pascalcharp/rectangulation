package org.example;

import java.util.*;

public class PolygoneOrthogonal {
    String nom ;

    HashMap<Arete, HashSet<Arete>> adjacence ;

    public PolygoneOrthogonal(String nom, ArrayList<Arete> liste) {
        this.nom = nom ;
        for (int i = 0; i < liste.size(); i++ ) {
            adjacence.put(liste.get(i), new HashSet<>(Arrays.asList(liste.get((i-1) % liste.size()), liste.get((i+1)% liste.size())))) ;
        }
    }

    public PriorityQueue<AreteHorizontale> mettreEnFileLesAretesHorizontales() {
        PriorityQueue<AreteHorizontale> Q = new PriorityQueue<>(new OrdreHauteur()) ;
        for (Arete a: adjacence.keySet()) if (a instanceof AreteHorizontale) Q.add((AreteHorizontale) a) ;
        return Q ;
    }
}
