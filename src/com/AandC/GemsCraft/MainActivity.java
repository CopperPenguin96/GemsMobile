package com.AandC.GemsCraft;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import com.AandC.GemsCraft.PlayerDB.*;
import com.AandC.GemsCraft.Constants.*;
import com.AandC.GemsCraft.Commands.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		if (Files.isGood()) {
			Files.loadPlayers(); //Readies for future use
		}
		spp.app_ver = getResources().getString(R.string.ver);
    }
	
	public void exit(View v) {
		System.exit(0);
	}
	// Defined Array values to show in ListView
	public void configs(View v) {
		openActivity(new Intent(this, Config.class));
	}
	public void openHelp(View v) {
		openActivity(new Intent(this, Help.class));
	}
	public void getPlayers(View v) {
		openActivity(new Intent(this, PlayerDatabase.class));
	}
	public void openActivity(Intent i) {
		try {
			startActivity(i);
		} catch (Exception ex) {
			AlertDialog ad = new AlertDialog.Builder(this).create();
			ad.setTitle("Failed Operation");
			ad.setMessage("Failed to run activity " + ex.toString());
			ad.show();
		}
	}
	public void startServer(View v) {
		openActivity(new Intent(this, Server.class));
	}
	
}
