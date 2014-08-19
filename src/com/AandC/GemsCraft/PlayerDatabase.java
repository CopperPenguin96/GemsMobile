package com.AandC.GemsCraft;

import android.app.*;
import android.os.*;
import android.widget.*;
import com.AandC.GemsCraft.PlayerDB.*;
import java.util.*;


public class PlayerDatabase extends Activity
{
	@Override
	private ListView mainListView; /*The object used to show the
	PlayerDB */
	private ArrayAdapter<String> listAdapter; /*Used to convert
	For the ListView */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
		try {
			Files.checkFiles();
		} catch (Exception ex) {
			MsgBox("Woops.. ",ex.toString() + " has caused " +
					"me to stop working");
		} finally {
			try {
				mainListView = (ListView) findViewById(R.id.list);
				String[] players = new String[] { "Console"};  
				ArrayList<String> playerList = new ArrayList<String>();
				playerList.addAll( Arrays.asList(players));
				listAdapter = new ArrayAdapter<String>(this, R.layout.listv, playerList);
				
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
	void MsgBox(String Title, String message) {
		AlertDialog x = new AlertDialog.Builder(this).create();
		x.setTitle(Title);
		x.setMessage(message);
		x.show();
	}
	
}
