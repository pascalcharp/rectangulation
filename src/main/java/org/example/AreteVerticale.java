package org.example;

import java.util.Comparator;

public class AreteVerticale extends Arete implements Comparable<AreteVerticale> {

    private final double  xPos;
    private final double  haut ;
    private double bas ;

    public AreteVerticale(double posVal, double hautVal, double basVal) {
        xPos = posVal ;
        haut = hautVal ;
        bas = basVal ;
    }

    public AreteVerticale(AreteVerticale a) {
        xPos = a.xPos;
        haut = a.haut ;
        bas = a.bas ;
    }

    @Override
    public double position() {
        return xPos ;
    }

    @Override
    public double debut() { return haut ; }

    @Override
    public double fin() { return bas ; }

    @Override
    public Arete separer(double v) {
        assert contient(v) ;

        AreteVerticale fragment = new AreteVerticale(xPos, v, bas) ;
        bas = v ;
        return fragment ;
    }

    @Override
    public Arete fusionner(Arete a) {
        AreteVerticale av = (AreteVerticale) a ;
        assert xPos == av.xPos ;
        AreteVerticale fusion = null ;

        if (bas == av.haut) {
            fusion = new AreteVerticale(xPos, haut, av.bas) ;
        }
        else if (haut == av.bas){
            fusion = new AreteVerticale(xPos, av.haut, bas) ;
        }
        else assert false ;
        return fusion ;
    }

    private boolean invariant() {
        return longueur() > 0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (!(o instanceof AreteVerticale)) return false ;
        AreteVerticale a = (AreteVerticale) o ;
        return xPos == a.xPos && haut == a.haut && bas == a.bas ;
    }

    @Override
    public int compareTo(AreteVerticale a) {
        int comparePosition = Double.compare(a.xPos, this.xPos) ;
        if (comparePosition != 0) return comparePosition ;
        int compareDebut = Double.compare(a.debut(), this.debut()) ;
        if (compareDebut != 0) return compareDebut ;
        return Double.compare(a.fin(), this.fin());
    }
}
