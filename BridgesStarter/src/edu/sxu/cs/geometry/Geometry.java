//Geometric utility functions
//Created by James Vanderhyde, 13 February 2025

package edu.sxu.cs.geometry;

public final class Geometry 
{
    public static double squareDistance(Point a, Point b)
    {
        return (b.x-a.x)*(b.x-a.x) + (b.y-a.y)*(b.y-a.y);
    }
    
    public static double distance(Point a, Point b)
    {
        return Math.sqrt(squareDistance(a, b));
    }
    
    public static double absoluteDistance(Point p, Line l)
    {
        return Math.abs(signedDistance(p,l));
    }
    
    public static double signedDistance(Point p, Line l)
    {
        return signedDistanceUnnormalized(p,l)/distance(l.a,l.b);
    }
    
    public static double signedDistanceUnnormalized(Point p, Line l)
    {
        return (l.b.y-l.a.y)*p.x - (l.b.x-l.a.x)*p.y + l.b.x*l.a.y - l.b.y*l.a.x;
    }

    public static Point lonLatToMiles(Point p, Point origin)
    {
        //source of formulas: https://gis.stackexchange.com/questions/142326/calculating-longitude-length-in-miles
        double f = 1/298.257223563;
        double a = 6378137;
        double e2 = (2-f)*f;
        
        double phi = origin.y; //latitude
        double d = 1 - e2*Math.sin(phi);
        double m = a*(1-e2)/(d*Math.sqrt(d));
        double r = a*Math.cos(phi)/Math.sqrt(d);
        
        double oneDegLatInMiles = m/180*Math.PI/1609.34;
        double oneDegLonInMiles = r/180*Math.PI/1609.34;
        
        double deltaLat = origin.y-p.y;
        double deltaLon = origin.x-p.x;
        
        return new Point((float)(oneDegLonInMiles*deltaLon), (float)(oneDegLatInMiles*deltaLat));
    }
    
}
