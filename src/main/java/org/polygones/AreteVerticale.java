package org.polygones;

import java.util.Comparator;

import static org.polygones.Precision.DoubleEquals;

public class AreteVerticale extends Arete implements Comparable<AreteVerticale> {


    public AreteVerticale(double posVal, double hautVal, double basVal) {
        super(posVal, hautVal, basVal) ;

        assert debutVal > finVal ;
    }

    public AreteVerticale(AreteVerticale a) {
        super(a.positionVal, a.debutVal, a.finVal) ;

        assert debutVal > finVal ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true ;
        if (!(o instanceof AreteVerticale)) return false ;
        AreteVerticale a = (AreteVerticale) o ;
        return DoubleEquals(positionVal, a.positionVal) && DoubleEquals(debutVal, a.debutVal) && DoubleEquals(finVal, a.finVal) ;
    }

    @Override
    public int compareTo(AreteVerticale a) {
        if (a == this) return 0 ;

        int comparePosition = Double.compare(this.positionVal, a.positionVal) ;
        if (comparePosition != 0) return comparePosition ;

        int compareDebut = Double.compare(a.debut(), this.debut()) ;
        if (compareDebut != 0) return compareDebut ;

        return Double.compare(a.fin(), this.fin());
    }
}
