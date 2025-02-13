/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package bridgesbase;

import edu.sxu.cs.geometry.*;

/**
 *
 * @author jv4
 */
public class BridgesBase 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        //Test code for distance formulas
        Point p1 = new Point(0,4);
        Point p2 = new Point(3,0);
        System.out.println(Geometry.distance(p1, p2) + " should be 5");
        
        Line l1 = new Line(new Point(0,0), new Point(10,10));
        System.out.println(Geometry.signedDistanceUnnormalized(p1, l1));
        System.out.println(Geometry.signedDistanceUnnormalized(p2, l1));
        System.out.println(Geometry.signedDistance(p1, l1));
        System.out.println(Geometry.signedDistance(p2, l1));
    }
}
