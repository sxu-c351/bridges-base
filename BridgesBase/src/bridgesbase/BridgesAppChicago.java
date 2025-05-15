//Starter code for BRIDGES projects (https://bridgesuncc.github.io)
//Created by James Vanderhyde, 13 February 2025

package bridgesbase;

import bridges.base.Circle;
import bridges.base.SymbolCollection;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.OsmData;
import bridges.data_src_dependent.OsmVertex;
import edu.sxu.cs.geometry.Point;
import java.util.ArrayList;

public class BridgesAppChicago 
{
    /**
     * Runs all the logic for the BRIDGES assignment. Call from main.
     * @param bridges The initialized Bridges object
     * @throws java.io.IOException when there is a problem communicating
     *   with the BRIDGES server.
     */
    public void run(Bridges bridges) throws java.io.IOException
    {
        //Set some information for the BRIDGES object
        bridges.setTitle("Title of the project");
	bridges.setDescription("Long description");

        //Create the data connection object
        DataSource ds = bridges.getDataSource();
        
        //Use the DataSource object to download a data set from the server
        OsmData osm_data = ds.getOsmData("Chicago, Illinois", "secondary");
	OsmVertex[] ov = osm_data.getVertices();
        
        //Read the data set into a data structure
        ArrayList<Point> dataPoints = new ArrayList<>();
        for (OsmVertex v : ov)
            dataPoints.add(new Point(v.getLongitude(), v.getLatitude()));
        
        //Process the data
        System.out.println(dataPoints.size()+" data points.");
        System.out.println(dataPoints.get(0)+" data points.");
        
        //Create a scene graph (SymbolCollection) object
        SymbolCollection scene = new SymbolCollection();
        bridges.setDataStructure(scene);
        
        //Set the window (the visible range of X and Y)
        //  These numbers need to be set to something that works for the data set.
        scene.setViewport(-88.0f, -87.5f, 41.5f, 42.0f);
        
        //Add shapes to the SymbolCollection for the server to draw
        for (Point p : dataPoints)
        {
            Circle c = new Circle((float)p.x, (float)p.y, 0.0005f);
            c.setFillColor("red");
            c.setOpacity(0.6f);
            scene.addSymbol(c);
        }

        
    }

}
