package com.AandC.GemsCraft.PlayerDB;

import java.io.*;
import org.w3c.dom.*;

public class Files
{
	/*
		These files are the PlayerDB. Each player has a number 
		based on their position in names.gc the line number
		They have the same position in each file
	*/
	public static File[] filesArray = new File[] {
		new File("/sdcard/GemsCraft/PlayerDB/names.gc"), //0
		new File("/sdcard/GemsCraft/PlayerDB/nicks.gc"), //1
		new File("/sdcard/GemsCraft/PlayerDB/bans.gc"), //2
		new File("/sdcard/GemsCraft/PlayerDB/kicks.gc"), //3
		new File("/sdcard/GemsCraft/PlayerDB/donator.gc"), //4
		new File("/sdcard/GemsCraft/PlayerDB/ranks.gc"), //5
		new File("/sdcard/GemsCraft/PlayerDB/warns.gc") //6
	};
	public static Player[] player;
	public static void loadPlayers() {
		int setAmount = 0;
		int changedAmount = lineCount(filesArray[0]);
		for (setAmount = 0; setAmount <= changedAmount; setAmount++) {
			player[setAmount] = new Player();
			player[setAmount].ID = setAmount;
			player[setAmount].isBanned = getPlayerBanStatus(setAmount);
			player[setAmount].isDonator = getPlayerDonatorStatus(setAmount);
			player[setAmount].isWarned = getPlayerWarnStatus(setAmount);
			player[setAmount].kicks = getPlayerKicks(setAmount);
			player[setAmount].name = getPlayerName(setAmount);
			player[setAmount].nick = getPlayerNick(setAmount);
			player[setAmount].rank.title = getPlayerRank(setAmount);
		}
		
	}
	public static int lineCount(File file) {
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) { 
			//The IDE required it
			return 0;
		} catch (IOException e) {
			return 0;
		} finally {
			try
			{
				int myCount = 0;
				while ((br.readLine() != null))
				{
					myCount++;
				}
				return myCount;
			}
			catch (IOException e) {
				return 0;
			}
		}
	}
	static Player tempPlayer;
	public static void getList() {
		
	}
	static Player getPlayer(Player player,int playerID) {
		return tempPlayer;
	}
	public static void checkFiles() {
		for (File file:filesArray) {
			Files.FileParsing(file);
		} //Creates all the files if need be
	}
	public static boolean isGood() {
		boolean c = false;
		for (File file:filesArray) {
			if (!file.exists()) {
				c = true;
				return false;
			}
		}
		if (!c) {
			return true;
		} else {
			return false;
		}
	}
	public static void FileParsing(File file) {
		if (!isGood()) {
			try {
				file.createNewFile();
			}
			catch (IOException e) {
				//Stupid IDE
			}
		}
	}
	public static String getPlayerName(int playerID) {
		return returnString(playerID,Files.filesArray[0]);
	}
	public static String getPlayerNick(int playerID) {
		return returnString(playerID,Files.filesArray[1]);
	}
	public static String getPlayerRank(int playerID) {
		return returnString(playerID,Files.filesArray[5]);
	}
	public static boolean getPlayerBanStatus(int playerID) {
		return returnBoolean(playerID,Files.filesArray[2]);
	}
	public static boolean getPlayerDonatorStatus(int playerID) {
		return returnBoolean(playerID,Files.filesArray[4]);
	}
	public static boolean getPlayerWarnStatus(int playerID) {
		return returnBoolean(playerID,Files.filesArray[6]);
	}
	public static int getPlayerKicks(int playerID) {
		return returnInt(playerID,Files.filesArray[3]);
	}
	static String returnString(int playerID, File file) {
		if (!isGood()) {
			return null;
		} else {
			BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) { 
				//The IDE required it
				return null;
			} catch (IOException e) {
				return null;
			} finally {
				String line;
				int lineCount = 0;
				String[] linesStr = new String[lineCount];
				try
				{
					while ((line = br.readLine()) != null)
					{
						lineCount++;
						linesStr[lineCount] = line;
						System.out.println(line);
					}
					return linesStr[playerID];
				}
				catch (IOException e) {
					return null;
				}
			}
		}
	}
	
	static Boolean returnBoolean(int playerID,File file) {
		if (!isGood()) {
			return false;
		} else {
			BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) { 
				//The IDE required it
				return false;
			} catch (IOException e) {
				return false;
			} finally {
				String line;
				int lineCount = 0;
				Boolean[] linesStr = new Boolean[lineCount];
				try
				{
					while ((line = br.readLine()) != null)
					{
						lineCount++;
						if (line == "true") {
							linesStr[lineCount] = true;
						} else {
							linesStr[lineCount] = false;
						}
						System.out.println(line);
					}
					return linesStr[playerID];
				}
				catch (IOException e) {
					return false;
				}
			}
		}
	}
	static int returnInt(int playerID, File file) {
		if (!isGood()) {
			return 0;
		} else {
			BufferedReader br = null;
			try
			{
				br = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) { 
				//The IDE required it
				return 0;
			} catch (IOException e) {
				return 0;
			} finally {
				String line;
				int lineCount = 0;
				String[] linesStr = new String[lineCount];
				try
				{
					while ((line = br.readLine()) != null)
					{
						lineCount++;
						linesStr[lineCount] = line;
						System.out.println(line);
					}
					return Integer.parseInt(linesStr[playerID]);
				}
				catch (IOException e) {
					return 0;
				}
			}
		}
	}
}
