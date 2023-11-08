package org.example;

public class Point2D {
    private final double x ;
    private final double y ;

    public Point2D(double xVal, double yVal) {
        x = xVal ;
        y = yVal ;
    }

    public Point2D(Point2D p) {
        x = p.x ;
        y = p.y ;
    }

    public double distanceCarreeVers(Point2D p) {
        double dx = p.x - x ;
        double dy = p.y - y ;
        return dx * dx + dy * dy ;
    }

    public double distanceVers(Point2D p) {
        return Math.sqrt(distanceCarreeVers(p)) ;
    }
}
