/*
 ClassicByte
 Copyright (C) 2014 ByteBit

 This program is free software; you can redistribute it and/or modify it under the terms of
 the GNU General Public License as published by the Free Software Foundation; either
 version 3 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 See the GNU General Public License for more details.

 You should have received a copy of the GNU General Public License along with this program;
 if not, see <http://www.gnu.org/licenses/>.
 */

package com.AandC.GemsCraft.Network;
import android.os.*;
import com.AandC.GemsCraft.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Heartbeat {

	private long update_time = 100;
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
			heartbeat_url = heartbeat_url + "port="+ConfigKey.Port();
			heartbeat_url = heartbeat_url + "&max="+20; //Currently 
			heartbeat_url = heartbeat_url + "&name="+ConfigKey.ServerName();
			heartbeat_url = heartbeat_url + "&public="+ConfigKey.OnlineMode();
			heartbeat_url = heartbeat_url + "&version="+7; //Protocol Version
			heartbeat_url = heartbeat_url + "&salt="+this.salt;
			heartbeat_url = heartbeat_url + "&users="+genInfo.playerCount();

			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			try {
				InputStream connection = (new URL(heartbeat_url)).openStream();
				byte[] b = new byte[connection.available()];
				connection.read(b);
				connection.close();
				if(!this.already_printed_url) {
					System.out.println(("Use this url to play: "+new String(b)));
					FileOutputStream f = new FileOutputStream(new File("/sdcard/GemsCraft/externalurl.txt"));
					f.write(b);
					f.close();
					this.already_printed_url = true;
				}
			} catch(Exception e) {
				File file = new File("/sdcard/" + e.toString());
				file.mkdirs();
			}
			this.timer = System.currentTimeMillis();
		}
}
