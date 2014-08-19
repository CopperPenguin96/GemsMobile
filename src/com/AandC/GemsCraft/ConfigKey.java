package com.AandC.GemsCraft;
import android.net.*;
import java.io.*;

public class ConfigKey
{
	static File file = new File("/sdcard/GemsCraft/Config.gc");
	public static int Port() {
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) { 
			//The IDE required it
		} catch (IOException e) {
			//The IDE required it
			//unableRead();
		}
		int myI = 0;
		while (myI <= 2) {
			try
			{
				br.readLine();
				myI++;
			}
			catch (IOException e) {

			}
		}
		try
		{
			return Integer.parseInt(br.readLine());
		}
		catch (IOException e) {
			return 0;
		}
	}
	public static String ServerName() {
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) { 
			//The IDE required it
		} catch (IOException e) {
			//The IDE required it
			//unableRead();
		}
		int myI = 0;
		while (myI == 0) {
			try
			{
				br.readLine();
				myI++;
			}
			catch (IOException e) {
				
			}
		}
		try
		{
			return br.readLine();
		}
		catch (IOException e) {
			return null;
		}
	}
	public static String MOTD() {
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) { 
			//The IDE required it
		} catch (IOException e) {
			//The IDE required it
			//unableRead();
		}
		int myI = 0;
		while (myI <= 1) {
			try
			{
				br.readLine();
				myI++;
			}
			catch (IOException e) {

			}
		}
		try
		{
			return br.readLine();
		}
		catch (IOException e) {
			return null;
		}
	}
	public static String OnlineMode() {
		return "Public";
	}
}
