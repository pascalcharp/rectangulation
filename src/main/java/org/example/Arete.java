package org.example;

public abstract class Arete {
    public Arete() {

    }

    public abstract boolean contient(double v) ;

    public abstract double position() ;

    public abstract double longueur() ;

    public abstract Arete separer(double v) ;

    public abstract Arete fusionner(Arete a) ;
}
