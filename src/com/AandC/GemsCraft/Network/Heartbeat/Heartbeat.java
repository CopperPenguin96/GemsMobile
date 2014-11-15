
package com.AandC.GemsCraft.Network.Heartbeat;
import android.os.*;
import com.AandC.GemsCraft.*;
import java.io.*;
import java.net.*;
import java.util.*;
import com.AandC.GemsCraft.Configuration.*;
import java.security.*;
import com.ashokgelal.samaya.*;
import com.AandC.GemsCraft.System.*;

public class Heartbeat {
	public static String GenerateSalt() {
		System.out.println("Test");
		SecureRandom prng = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		byte[] oneChar = new byte[1];
		while (sb.length() < 32) {
			prng.nextBytes(oneChar);
			if (oneChar[0] >= 48 && oneChar[0] <= 57 ||
				oneChar[0] >= 65 && oneChar[0] <= 90 || 
				oneChar[0] >= 97 && oneChar[0] <= 122) {
				sb.append((char) oneChar[0]);
				System.out.println((char) oneChar[0]);
			}
		}
		return sb.toString();
	}
	static final TimeSpan Timeout = TimeSpan.FromSeconds(10);
	static final TimeSpan Delay = TimeSpan.FromSeconds(25);
	public static final String UrlFileName = Files.mainPath + "externalurl.txt";
	public static final String Salt = GenerateSalt();
	static URI uri;
	public static void Start() {
		Thread heartbeatThread = new Thread(new Beat(Salt, uri));
		heartbeatThread.start();
	}
}



