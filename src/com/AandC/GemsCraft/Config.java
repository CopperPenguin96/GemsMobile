package com.AandC.GemsCraft;

import android.app.*;
import android.os.*;
import android.view.*;
import java.io.*;
import android.widget.*;
import com.AandC.GemsCraft.Constants.*;
import com.AandC.GemsCraft.*;
import android.content.*;
import java.lang.Runnable.*;
public class Config extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
		File file = new File("/sdcard/GemsCraft/Config.gc");
		if (!CheckFiles.check(file)) {
			//unableRead();
		} else {
			file.setReadable(true);
			file.setWritable(true);
			BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) { 
				//The IDE required it
				unableRead();
			} catch (IOException e) {
				//The IDE required it
				//unableRead();
			}
			try
			{
				int[] countsL = new int[]{
					1,
					4
				};
				String[] linesStr = new String[5];
				for (countsL[0] = 1; countsL[0] <= countsL[1]; countsL[0]++) {
					linesStr[countsL[0]] = br.readLine();
				} // This code is ugly
				EditText text1 = (EditText) findViewById(R.id.txtServerName);
				EditText text2 = (EditText) findViewById(R.id.txtM);
				EditText text3 = (EditText) findViewById(R.id.txtPort);
				text1.setText(linesStr[2]);
				text2.setText(linesStr[3]);
				text3.setText(linesStr[4]);
				
			} catch (Exception ex) {
				AlertDialog x = new AlertDialog.Builder(this).create();
				x.setTitle("Sorry...");
				x.setMessage(ex.toString());
				x.show();
			}
		}
    }
	void unableRead() {
		AlertDialog x = new AlertDialog.Builder(this).create();
		x.setTitle("Sorry...");
		x.setMessage("Unable to read the Configuration. Please try again.");
		x.show();
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.config, menu);
		return true;
	}
	public MainActivity xF = new MainActivity();
	public boolean isO = false;
	public Configuration x3 = new Configuration();
	public boolean isGoodPort(String portNumber) {
		int usrPrt = 0; //1025-65535
		int minPort = 1025;
		int maxPort = 65535;
		try {
			usrPrt = Integer.parseInt(portNumber); //Checks for format
		} catch (Exception ex) {
			return false;
		} finally {
			if (usrPrt < minPort) return false;
			else if (usrPrt > maxPort) return false;
			else return true;
		}
	}
	public boolean onOptionsItemSelected(MenuItem item) {
		spp.userTexts = new EditText[]{
			(EditText) this.findViewById(R.id.txtServerName), //Server Name
			(EditText) this.findViewById(R.id.txtM), //MOTD
			(EditText) this.findViewById(R.id.txtPort) //Port
		};
		
		switch (item.getItemId()) {
			case R.id.save:
				try {
					if (isGoodPort(spp.userTexts[2].getText().toString())) {
						saveConfig();
					} else {
						adx("Invalid Port", "The port \"" + 
							spp.userTexts[2].getText().toString() + 
							"\" is invalid!");
					}
				} catch (Exception ex) {
					adx(ex.toString(),ex.toString());
				}
				return true;
			case R.id.saveExit:
				try {
					if (isGoodPort(spp.userTexts[2].getText().toString())) {
						saveConfig();
					} else {
						adx("Invalid Port", "The port \"" + 
							spp.userTexts[2].getText().toString() + 
							"\" is invalid!");
					}
				} catch (Exception ex) {
					adx(ex.toString(),ex.toString());
				}
				this.finish();
				return true;
			case R.id.exit:
				if (!isO) {
					String x = "Doing so will lose all work";
					AlertDialog ad = new AlertDialog.Builder(this).create();
					ad.setTitle("You Derp");
					ad.setMessage(x);
					isO = true;
					ad.show();
					return true;
				} else {
					this.finish();
					return true;
				}
			default:
				return super.onOptionsItemSelected(item);
		}
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
	
	public View getId(int id) {
		return findViewById(id);
	}
	public void adx(String title, String message) {
		AlertDialog ad = new AlertDialog.Builder(this).create();
		ad.setTitle(title);
		ad.setMessage(message);
		ad.show();
	}
	
	public void saveConfig() {
		/*
		 CONFIG FORMAT THUS FAR
		 Server Name
		 Server MOTD
		 Server Port
		 */
		//Currently Only MC.net is supported

		String filename = "Config.gc";
		String finalText = "---GemsCraft Server Config---\n";
		File outputFile;
		File configDirectory;
		try {
			try {
				int x; //For use with the loop
				for (x = 0; x <= spp.userTexts.length; x++) {
					finalText += spp.userTexts[x].getText().toString() + "\n"; //Prepares the String for writing
				}
			} catch (Exception ex) {
				
			}
			try
			{
				configDirectory = new File("/sdcard/GemsCraft/");
				configDirectory.mkdirs();
				outputFile = new File(configDirectory, filename);
				FileOutputStream fos = new FileOutputStream(outputFile);
				byte[] data = new String(finalText).getBytes();
				try {
					fos.write(data);
					fos.flush();
					fos.close();
				} catch (FileNotFoundException e) {
					// handle exception
					adx("Beep", "Beep Beep");
				} catch (IOException e) {
					// handle exception
					adx("IOException", e.toString());
				} catch (Exception ex) {
					adx(ex.toString(), ex.toString());
				}
			} catch (FileNotFoundException ex) {
				adx(ex.toString(), ex.toString());
			} catch (NullPointerException ex) {
				adx(ex.toString(), ex.toString());
			}
		} catch (Exception ex) {
			adx(ex.toString(), ex.toString());
		} finally {
			adx("Operation Success",
				"The Server Configuration was saved successfully.");
		}
	}
	public void checkPort(View v) {
		setD();
		Button myB = (Button) findViewById(R.id.btnPort);
		myB.setText("Checking");
		myB.setEnabled(false);
		
		
	}
	
	void setD() {
		Dialog portDialog = new Dialog(this);
		portDialog.setTitle("Please hold...");
		portDialog.setContentView(R.layout.port);
		ProgressBar pbr = (ProgressBar) portDialog.findViewById(R.id.pgrPort);
		TextView txt = (TextView) portDialog.findViewById(R.id.txtLo);
		portDialog.show();
	}
}
