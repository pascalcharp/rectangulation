package org.example;

public abstract class Arete {
    public Arete() {

    }

    public boolean contient(double v) {
        return v <= fin() && v >= debut() ;
    };

    public abstract double position() ;

    public abstract double debut() ;

    public abstract double fin() ;

    public double longueur() {
        return fin() - debut() ;
    } ;

    public abstract Arete separer(double v) ;

    public abstract Arete fusionner(Arete a) ;

}
