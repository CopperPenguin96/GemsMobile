package com.AandC.GemsCraft.Configuration;
import android.widget.*;
import com.AandC.GemsCraft.*;
import com.AandC.GemsCraft.System.*;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/*
 The MIT License (MIT)

 Copyright (c) 2014 Alex Potter

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
public class ConfigKey
{
	
	public static void prepareConfig() throws IOException, ParseException {
		
	}
	public static boolean isInConfig;
	public static EditText[] configs;
	static boolean isNull(Object o) {
		if (o.equals(null)) {
			return true;
		} else {
			return false;
		}
	}
	//Server Port
	private static int port;
	public static int getPort() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("/sdcard/GemsCraft/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			port = jsonObject.get("Port");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return port;
	}
	public static void setPort() {
		int maxPort = 65535;
		try {
			int enteredPort = Integer.parseInt(configs[1].getText().toString());
			if (enteredPort < 0) {
				MsgBox.show("Error!", "Port is too low!", Contexts.configActivityContext);
			} else if (enteredPort > maxPort) {
				MsgBox.show("Error!", "Port is too high!", Contexts.configActivityContext);
			} else if (0 < enteredPort) {
				if (enteredPort < maxPort) {
					port = enteredPort;
				}
			}
		} catch (NumberFormatException e) {
			MsgBox.show("Error!", "NonNumbers in Port", Contexts.configActivityContext);
		}
	}
	
	//Server Name
	private static String ServerName;
	public static String getServerName() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("/sdcard/GemsCraft/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			ServerName = String.valueOf(jsonObject.get("ServerName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ServerName;
	}
	public static void setServerName() {
		if (!isNull(configs[0].getText().toString())) {
			ServerName = configs[0].getText().toString();
		} else {
			MsgBox.show("Error!", "Your server needs a name!", Contexts.configActivityContext);
		}
	}
	
	//Online Mode
	private static boolean onlineMode;
	public static boolean getOnlineMode() {
		return onlineMode;
	}
	public static void setOnlineMode() {
		onlineMode = true;
	}
	
	//Message of the Day (MOTD)
	private static String MOTD;
	public static String getMOTD() {
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader("/sdcard/GemsCraft/config.json"));
			JSONObject jsonObject = (JSONObject) obj;
			MOTD = String.valueOf(jsonObject.get("MOTD"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return MOTD;
	}
	public static void setMOTD() {
		if (!isNull(configs[2].getText().toString())) {
			ServerName = configs[2].getText().toString();
		} else {
			MsgBox.show("Error!", "You need to enter in a MOTD!", Contexts.configActivityContext);
		}
	}
}
