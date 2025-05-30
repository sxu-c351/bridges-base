//A point is that which has no length.
//Created by James Vanderhyde, 13 February 2025

package edu.sxu.cs.geometry;

public class Point 
{
    public final float x;
    public final float y;
    
    public Point()
    {
        x = 0;
        y = 0;
    }
    
    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "("+this.x+", "+this.y+")";
    }
}
