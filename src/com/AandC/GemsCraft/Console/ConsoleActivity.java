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
	final Console console = new Console();
	public void onCreate(Bundle b) {
		super.onCreate(b);
		setContentView(R.layout.server);
		Constants.consoleTextView = (TextView) findViewById(R.id.txtConsole);
		try
		{
			Log startLog = new Log("Welcome to GemsCraft! <br>" +
				"Your server is attempting to start!");
			Server.heartBeat = new Heartbeat();
			Server.heartBeat.run();
			Log serverURL = new Log("Your server is running with URL " +
				Server.URL);
		} catch (InvalidLogException e) {
			e.printStackTrace();
		}
	}
	
	public void performAction(View v) {
		EditText cmdBox = (EditText) findViewById(R.id.txtCommand);
		String enteredText = cmdBox.getText().toString();
		if (!enteredText.equals(null)) {
			if (enteredText.substring(0,0).equals("/")) {
				String cmdLower = enteredText.toLowerCase();
				for (Command list:Commands.cmdList) {
					if (list.name.toLowerCase().equals(cmdLower)) {
						console.performCommand(list);
					} else {
						boolean foundGoodAl = false;
						for (String alis:list.alliases) {
							if (alis.toLowerCase().equals(cmdLower)) {
								foundGoodAl = true;
							}
						}
						if (foundGoodAl) {
							console.performCommand(list);
						} else {
							console.message("No such command \"" + enteredText + "\"");
						}
					}
				}
			}
		}
	}
}
