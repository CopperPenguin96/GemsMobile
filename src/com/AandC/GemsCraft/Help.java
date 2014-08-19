package com.AandC.GemsCraft;

import android.app.*;
import android.os.*;
import android.widget.*;
import java.util.*;

public class Help extends Activity
{
    /** Called when the activity is first created. */
    @Override
	private ListView mainListView ;
	
	private ArrayAdapter<String> listAdapter ;
	
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
		try {
			mainListView = (ListView) findViewById(R.id.list);
			String[] planets = new String[] { "Configuration", "Player DB", "Running the Server",
				"Commands", "Console", "Moderation", "Plugins"};  
			ArrayList<String> planetList = new ArrayList<String>();
			planetList.addAll( Arrays.asList(planets) );

			// Create ArrayAdapter using the planet list.
			listAdapter = new ArrayAdapter<String>(this, R.layout.listv, planetList);

			// Add more planets. If you passed a String[] instead of a List<String> 
			// into the ArrayAdapter constructor, you must not add more items. 
			// Otherwise an exception will occur.
			
			

			// Set the ArrayAdapter as the ListView's adapter.
			mainListView.setAdapter( listAdapter );  }
		catch (Exception ex) {
			AlertDialog x = new AlertDialog.Builder(this).create();
			x.setMessage(ex.toString());
			x.setTitle(ex.toString());
			x.show();
		}
    }
}
