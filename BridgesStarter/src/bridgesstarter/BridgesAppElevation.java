//Starter code for BRIDGES projects (https://bridgesuncc.github.io)
//Created by James Vanderhyde, 23 May 2025

package bridgesstarter;

import bridges.base.Color;
import bridges.base.ColorGrid;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ElevationData;

public class BridgesAppElevation 
{
    /**
     * Runs all the logic for the BRIDGES assignment. Call from main.
     * @param bridges The initialized Bridges object
     * @throws java.io.IOException when there is a problem communicating
     *   with the BRIDGES server.
     * @throws bridges.validation.RateLimitException if calls to bridges.visualize()
     *   throw this exception.
     */
    public void run(Bridges bridges) throws java.io.IOException, bridges.validation.RateLimitException
    {
        //Set some information for the BRIDGES object
        bridges.setTitle("Title of the project");
	bridges.setDescription("Long description");

        //Create the data connection object
        DataSource ds = bridges.getDataSource();
        
        //Use the DataSource object to download a data set from the server
        //This is the Mississippi river in northern Illinois, Iowa, Wisconsin.
        ElevationData ed = ds.getElevationData(44, -92, 42, -89.5, 0);
        
        //Read the data set into a data structure
        int[][] values = ed.getData();
        
        //Process the data
        System.out.println("Grid size: "+ed.getCols()+" x "+ed.getRows());
        System.out.println("Array size: "+values[0].length+" x "+values.length);
        System.out.println("Value range: "+ed.getMinVal()+" "+ed.getMaxVal());
        
        //Create a color grid (image) object
        ColorGrid image = new ColorGrid(ed.getRows(), ed.getCols());
        bridges.setDataStructure(image);
        
        //Color the pixels using the data
        for (int i=0; i<ed.getRows(); i++)
            for (int j=0; j<ed.getCols(); j++)
            {
                int gray = Math.round((values[i][j]-ed.getMinVal())/(float)(ed.getMaxVal()-ed.getMinVal())*255);
                image.set(i, j, new Color(gray,gray,gray));
            }
    }

}
