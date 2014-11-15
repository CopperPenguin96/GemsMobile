package com.AandC.GemsCraft.Console;
import android.app.*;
import android.os.*;
import com.AandC.GemsCraft.*;
import com.AandC.GemsCraft.System.*;
import android.widget.*;
import com.AandC.GemsCraft.Exceptions.*;
import com.AandC.GemsCraft.Console.LogTypes.*;
import com.AandC.GemsCraft.Network.*;
import android.view.*;
import com.AandC.GemsCraft.Commands.*;
import com.AandC.GemsCraft.Players.*;
import android.text.method.*;
import com.AandC.GemsCraft.Network.Heartbeat.*;
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
public class ConsoleActivity extends Activity
{
	@Override
	public void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.server);
		Files.createNeccessary();
		getConsoleInfo();
		Contexts.consoleActivityContext = this;
		Constants.consoleTextView = (TextView) findViewById(R.id.txtConsole);
		try
		{
			Log startLog = new Log("Welcome to GemsCraft! <br>" +
				"Your server is attempting to start!");
				
			//Heartbeat.Start();
			Log serverURL = new Log("Your server is running with URL " +
				Server.URL);
			Constants.consoleTextView.setMovementMethod(new ScrollingMovementMethod());
		} catch (InvalidLogException e) {
			e.printStackTrace();
		}
	}
	
	public void performAction(View v) {
		boolean[] foundGoodAl = new boolean[]{
			false, false
		};
		Command lst = null;
		EditText cmdBox = (EditText) findViewById(R.id.txtCommand);
		String enteredText = cmdBox.getText().toString();
		if (!enteredText.equals(null)) {
			System.out.println(enteredText);
			if (enteredText.substring(0,1).equals("/")) {
				String cmdLower = enteredText.toLowerCase().substring(1);
				System.out.println(cmdLower);
				for (Command list:Commands.cmdList) {
					System.out.println(list.getName());
					if (list.getName().toLowerCase().equals(cmdLower)) {
						list.p = getConsoleInfo();
						getConsoleInfo().performCommand(list);
						foundGoodAl[1] = true;
					} else {
						for (String alis:list.getAlliases()) {
							if (alis.toLowerCase().equals(cmdLower)) {
								System.out.println("Found an allias");
								foundGoodAl[0] = true;
								lst = list;
							}
						}
					}
				}
			}
		}
		if (foundGoodAl[0]) {
			try {
				lst.p = getConsoleInfo();
				getConsoleInfo().performCommand(lst);
			} catch (NullPointerException e) {
				new Logs(e);
			}
		} else {
			if (!foundGoodAl[1]) {
				getConsoleInfo().message("No such command \"" + "/" + enteredText.substring(1) + "\"");
			}
		}
	}
	public Player getConsoleInfo() {
		Player con = new Player();
		con.heldBlock = null;
		con.isAFK = false;
		con.Nick = "Console";
		con.userName = "console";
		return con;
	}
}
