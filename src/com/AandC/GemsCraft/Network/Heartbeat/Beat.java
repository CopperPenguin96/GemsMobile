package com.AandC.GemsCraft.Network.Heartbeat;
import com.AandC.GemsCraft.Configuration.*;
import java.net.*;
import java.io.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
import android.os.*;
import android.app.*;

public class Beat extends Activity implements Runnable
{
	URI uri;
	String salt;
	public Beat(String saltX, URI u) {
		salt = saltX;
		uri = u;
	}
	Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
			final String hb = msg.obj.toString();
            try
			{
				runOnUiThread(new Runnable() {
						@Override
						public void run() {
							try
							{
								Log mLog = new Log(hb);
							}
							catch (InvalidLogException e)
							{}
						}
					});
				
			}
			catch (Exception e)
			{
				
			}
        }
		public void LogIt(String logR) {
		
		}
	};
	@Override
	public void run()
	{
		while (true) {
			try {
				String requestUri = "http://classicube.net/heartbeat.jsp?" +
					"public=true" +
					"&max=20" +
					"&users=1" +
					"&port=60001" +
					"&version=7" +
					"&salt=" + salt +
					"&name=GemsCraft" +
					"&software=GemsMobile";
				InputStream connection = (new URL(requestUri)).openStream();
				byte[] b = new byte[connection.available()];
				connection.read(b);
				connection.close();
				Message mSg = new Message();
				mSg.obj = "Sending heartbeat...";
				
				mHandler.handleMessage(mSg);
				mSg.obj = "Use this URL to play: " + new String(b);
				mHandler.handleMessage(mSg);
				FileOutputStream f = new FileOutputStream(new File(Heartbeat.UrlFileName));
				f.write(b);
				f.close();
				mSg.obj = "Also saved in externalurl.txt";
				mHandler.handleMessage(mSg);
			} catch (Exception ex) {
				try
				{
					ex.printStackTrace();
				}
				catch (Exception e)
				{}
			}
		}
	}

	
}
