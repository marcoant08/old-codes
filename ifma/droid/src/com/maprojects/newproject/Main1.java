package com.maprojects.newproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main1 extends Activity {

	Button btcalc, bttelac;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela1);
		
		btcalc = (Button)
				findViewById(R.id.btcalc);
		
		btcalc.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent NewProject = new
				Intent(Main1.this,Main2.class);
				Main1.this.startActivity(NewProject);
				Main1.this.finish();
				
			}
		});
		
		bttelac = (Button)
				findViewById(R.id.bttelac);
		
		bttelac.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent NewProject = new
				Intent(Main1.this,Main3.class);
				Main1.this.startActivity(NewProject);
				Main1.this.finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
