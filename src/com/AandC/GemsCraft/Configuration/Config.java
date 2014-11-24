package com.AandC.GemsCraft.Configuration;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;
public class Config
{
	public static File dir = new File("/sdcard/GemsCraft/");
	public static File configFile = new File("/sdcard/GemsCraft/config.json");
	public static void writeConfig() throws JSONException, IOException {
		//Write to JSON file
		JSONObject configObj = new JSONObject();
        configObj.put("ServerName", ConfigKey.getServerName());
		configObj.put("MOTD", ConfigKey.getMOTD());
        configObj.put("Port", ConfigKey.getPort());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (!configFile.exists()) {
			configFile.createNewFile();
			FileWriter fileWriter = new FileWriter(configFile);
            System.out.println("Writing JSON object to file");
            System.out.println("-----------------------");
            System.out.print(configObj);
            fileWriter.write(configObj.toString());
            fileWriter.flush();
            fileWriter.close();
		} else {
			configFile.delete();
			writeConfig();
		}
	}
	
	
}
