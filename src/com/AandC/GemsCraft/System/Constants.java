package com.AandC.GemsCraft.System;
import android.text.format.*;
import android.widget.*;
import com.AandC.GemsCraft.Network.*;
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
public class Constants
{
	public static final Time time = new Time();
	public static TextView consoleTextView;
	public static String getTime() {
		String finalReturn = "";
		int[] timeSets = new int[] {
			Constants.time.hour,
			Constants.time.minute,
			Constants.time.second
		};
		String[] timeStick = new String[3];
		int loopCount = 0;
		for (int times:timeSets) {
			if (timeSets[loopCount] < 10) {
				timeStick[loopCount] = "0" + timeSets[loopCount];
			} else {
				timeStick[loopCount] = String.valueOf(timeSets[loopCount]);
			}
			loopCount++;
		}
		for (int x = 0; x <= 2; x++) {
			if (x < 2) {
				finalReturn += timeStick[x] + ":";
			} else if (x == 2) {
				finalReturn += timeStick[x];
			}
		}
		return finalReturn;
	}
	public static String htmlStart = "<html><body>";
}
