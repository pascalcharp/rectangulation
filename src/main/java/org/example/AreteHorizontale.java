package org.example;

public class AreteHorizontale extends Arete {

    private final double hauteur ;
    private final double posGauche ;
    private double posDroite ;

    public AreteHorizontale(double yVal, double gVal, double dVal) {
        hauteur = yVal ;
        posGauche = gVal ;
        posDroite = dVal ;

        assert invariant() ;
    }

    public AreteHorizontale(AreteHorizontale a) {
        hauteur = a.hauteur ;
        posGauche = a.posGauche ;
        posDroite = a.posDroite ;
    }

    @Override
    public  double position() {
        return hauteur ;
    }

    @Override
    public  double longueur() {
        return posDroite - posGauche ;
    }

    @Override
    public boolean contient(double v) {
        return v <= posDroite && v >= posGauche ;
    }

    @Override
    public  Arete separer(double xVal) {
        assert contient(xVal) ;

        AreteHorizontale fragment = new AreteHorizontale(hauteur, posGauche, xVal) ;
        posDroite = xVal ;
        return  fragment ;
    }

    @Override
    public  Arete fusionner(Arete a) {
        AreteHorizontale ah = (AreteHorizontale) a ;
        assert hauteur == ah.hauteur ;

        AreteHorizontale fusion = null ;
        if (ah.posDroite == posGauche) {
            fusion = new AreteHorizontale(hauteur, ah.posGauche, posDroite) ;
        }
        else if (ah.posGauche == posDroite) {
            fusion = new AreteHorizontale(hauteur, posGauche, ah.posDroite) ;
        }
        else assert false ;
        return fusion;
    }

    private boolean invariant() {
        return longueur() > 0 ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (! (o instanceof AreteHorizontale)) return false ;
        AreteHorizontale a = (AreteHorizontale) o ;
        return hauteur == a.hauteur && posGauche == a.posGauche && posDroite == a.posDroite ;
    }

}
