package com.AandC.GemsCraft.Network;
import com.AandC.GemsCraft.Players.*;
import com.AandC.GemsCraft.Console.LogTypes.*;
import com.AandC.GemsCraft.Console.*;
import com.AandC.GemsCraft.Exceptions.*;
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
public class Server
{
	public static Player[] players() {
		return new Player[] {
			
		};
	}
	public static short playerCount() {
		return (short) players().length;
	}
	public static Heartbeat heartBeat;
	public static String URL;
	public static void message(String mes) {
		if (mes.equals(null)) {
			throw new NullPointerException();
		} else {
			try {
				for (Player p:players()) {
					p.message(mes);
				}
				Log l = new Log(mes);
			} catch (Exception e) {
				try
				{
					Log log = new Log(e.getStackTrace().toString());
				} catch (InvalidLogException ec) {
					ec.printStackTrace();
				}
			}
		}
	}
}
