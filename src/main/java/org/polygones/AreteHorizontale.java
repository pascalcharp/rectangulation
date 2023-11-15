package org.polygones;


import static org.polygones.Precision.DoubleEquals;

public class AreteHorizontale extends Arete implements Comparable<AreteHorizontale> {

    public AreteHorizontale(double yVal, double gVal, double dVal) {
        super(yVal, gVal, dVal) ;
        assert finVal > debutVal ;
    }

    public AreteHorizontale(AreteHorizontale a) {
        super(a.positionVal, a.debutVal, a.finVal) ;
        assert finVal > debutVal ;
    }

    public AreteHorizontale fusionnerVersLaGaucheAvec(AreteHorizontale a) {
        if (a == null) return new AreteHorizontale(this) ;

        assert positionVal == a.positionVal && a.finVal == this.debutVal ;
        return new AreteHorizontale(positionVal, a.debutVal, finVal) ;
    }

    public boolean croise(AreteVerticale v) {
        return v.contient(positionVal) ;
    }

    public AreteHorizontale prolongerVers(AreteVerticale v) {
        assert croise(v) ;
        if (v.position() < debutVal) {
            return new AreteHorizontale(positionVal, v.positionVal, debutVal) ;
        }
        else if (v.position() > debutVal) {
            return new AreteHorizontale(positionVal, finVal, v.positionVal) ;
        }
        else {
            return null ;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (! (o instanceof AreteHorizontale)) return false ;
        AreteHorizontale a = (AreteHorizontale) o ;
        return DoubleEquals(positionVal, a.positionVal) && DoubleEquals(debutVal, a.debutVal) && DoubleEquals(finVal, a.finVal) ;
    }

    @Override
    public int compareTo(AreteHorizontale a) {
        if (a == this) return 0 ;

        int comparePosition = Double.compare(a.positionVal, this.positionVal) ;
        if (comparePosition != 0) return comparePosition ;

        int compareDebut = Double.compare(a.debut(), this.debut()) ;
        if (compareDebut != 0) return compareDebut ;

        return Double.compare(a.fin(), this.fin());
    }

}
