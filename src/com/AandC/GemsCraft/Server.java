package com.AandC.GemsCraft;

import android.app.*;
import android.os.*;
import com.AandC.GemsCraft.Network.*;
import android.text.*;
import android.widget.*;
import com.AandC.GemsCraft.Constants.*;

public class Server extends Activity
{
	@Override
	
	public void onCreate(Bundle myServ) {
		super.onCreate(myServ);
		Heartbeat heartbeat = new Heartbeat();
		heartbeat.run();
		setContentView(R.layout.server);
		Console.consoleBox = (TextView) findViewById(R.id.txtConsole);
		TextView serverName = (TextView) findViewById(R.id.lblServerName);
		serverName.setText(ConfigKey.ServerName());
		try {
			Console.writeToConsole(new Log("Your GemsCraft is running version " + spp.app_ver));
			if (spp.isCurrentVersion()) {
				Console.writeToConsole(new Log("Your GemsCraft is Up to Date!"));
			} else {
				Console.writeToConsole(new Log("Your GemsCraft is not up to date. There is a new version available! " +
									   " You can get " + TitleExtractor.getPageTitle("http://gemscon.freeiz.com/index.html") +
									   " from the Google Play Store now!"));
			}
			//Log writerLog = new Log(" to create a world that already exists!", "Warning", true);
			//Console.writeToConsole(writerLog);
		} catch (Exception ex) {
			AlertDialog x = new AlertDialog.Builder(this).create();
			x.setTitle(ex.toString());
			x.setMessage(ex.toString());
			x.show();
		}
	}
	
}

