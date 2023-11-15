package org.polygones;

public abstract class Arete {

    protected double positionVal ;
    protected double debutVal ;
    protected double finVal ;

    public Arete(double positionInit, double debutInit, double finInit) {
        positionVal = positionInit ;
        debutVal = debutInit ;
        finVal = finInit ;
    }

    public boolean contient(double v) {
        return (v - debutVal) * (finVal - v) >= 0 ;
    }

    public double position() {return positionVal ; }

    public double debut() { return debutVal ; }

    public double fin() {return finVal ; }

    public double longueur() {
        return Math.abs(fin() - debut()) ;
    }

}
