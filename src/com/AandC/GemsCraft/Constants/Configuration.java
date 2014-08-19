package com.AandC.GemsCraft.Constants;

import android.app.*;
import android.os.*;
import android.widget.*;
import com.AandC.GemsCraft.*;
import java.io.*;
import android.content.*;

public class Configuration extends Activity
{
	public void adx(String title, String message) {
		AlertDialog ad = new AlertDialog.Builder(this).create();
		ad.setTitle(title);
		ad.setMessage(message);
		ad.show();
	}
}
