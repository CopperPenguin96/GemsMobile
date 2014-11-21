package com.AandC.GemsCraft.Network;
import java.net.*;
import java.util.*;
import java.io.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.Console.LogTypes.*;

public class Heartbeat
{
	private long update_time = 45000;
	private long timer = System.currentTimeMillis()-this.update_time;
	private boolean already_printed_url = false;
	private boolean stop = false;
	public String salt = "";
	public Random rand = new Random();

	public Heartbeat() {
		this.generateSalt();
	}

	public void stop() {
		this.stop = true;
	}

	public void generateSalt() {
		this.salt = "";
		for(int k=0;k!=12;k++) {
			this.salt = this.salt + Integer.toHexString(this.rand.nextInt(16));
		}
	}

	public void run() {
		String heartbeat_url = "http://www.classicube.net/server/heartbeat?";
		heartbeat_url = heartbeat_url + "port=60001";
		heartbeat_url = heartbeat_url + "&max=20";
		heartbeat_url = heartbeat_url + "&name=GemsMobile Debug";
		heartbeat_url = heartbeat_url + "&public=true";
		heartbeat_url = heartbeat_url + "&version=7";
		heartbeat_url = heartbeat_url + "&salt=" + this.salt;
		heartbeat_url = heartbeat_url + "&users=" + Server.players().length;
		try {
			InputStream connection = (new URL(heartbeat_url)).openStream();
			byte[] b = new byte[connection.available()];
			connection.read(b);
			connection.close();
			Log log = new Log("Sending heartbeat to classicube.net");
			log.Send();
			if(!this.already_printed_url) {
				Log l = new Log("Use this url to play: " + new String(b));
				l.Send();
				FileOutputStream f = new FileOutputStream(new File("externalurl.txt"));
				f.write(b);
				f.close();
				Log mL = new Log("(Also saved in externalurl.txt)");
				mL.Send();
				this.already_printed_url = true;
			}
		} catch(Exception e) {
			try
			{
				Log mK = new Log("" + e.getMessage(), new Warning());
			}
			catch (InvalidLogException e2)
			{}
		}
		this.timer = System.currentTimeMillis();
	}
}
