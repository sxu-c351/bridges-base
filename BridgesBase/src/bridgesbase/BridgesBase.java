//Starter code for BRIDGES projects (https://bridgesuncc.github.io)
//Created by James Vanderhyde, 13 February 2025

package bridgesbase;

import bridges.base.SymbolCollection;
import bridges.connect.Bridges;
import bridges.connect.DataSource;

public class BridgesBase 
{
    public static void main(String[] args) 
    {
        //Create the BRIDGES object with credentials.
        //  If you are doing a BRIDGES assignment, use the assignment number. 
        //  Otherwise, use any number.
        //  Use your user name and API key from your BRIDGES registation.
        Bridges bridges = new Bridges(ASSIGNMENT, USER_NAME, API_KEY); //do not commit your API key!
        
        //Set some information for the BRIDGES object
        bridges.setTitle("Title of the project");
	bridges.setDescription("Long description");

        //Create the data connection object
        DataSource ds = bridges.getDataSource();
        
        //Use the DataSource object to download a data set from the server
        
        //Read the data set into a data structure
        
        //Process the data
        
        //Create a scene graph (SymbolCollection) object
        SymbolCollection cvh = new SymbolCollection();
        
        //Add shapes to the SymbolCollection for the server to draw

        //Activate the visualization on the server  
        try 
        {
            bridges.visualize();
        } 
        catch (java.io.IOException | bridges.validation.RateLimitException e) 
        {
            System.err.println(e);
        }
    }
}
