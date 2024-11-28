package com.maprojects.newproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3 extends Activity {

	Button btvoltar, btcalcular, btlimpar;
	EditText primeirovalor, segundovalor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela3);
		
		btvoltar = (Button)
				findViewById(R.id.btvoltar);
		
		btvoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent NewProject = new
				Intent(Main3.this,Main1.class);
				Main3.this.startActivity(NewProject);
				Main3.this.finish();
				
			}
		});
		
        primeirovalor    = (EditText) findViewById(R.id.primeirovalor);
        segundovalor    = (EditText) findViewById(R.id.segundovalor);

        btcalcular = (Button)   findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {

  			public void onClick(View v) {
  				double a = Double.parseDouble(primeirovalor.getText().toString());
  				double b = Double.parseDouble(segundovalor.getText().toString());	

  				double resultad = a * b;
  				
  				AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main3.this);
  	  			CaixaAlerta.setTitle("Resultado");
  	  			CaixaAlerta.setMessage("O resultado da multiplicação é: "+String.valueOf(resultad));
  	  			CaixaAlerta.setNeutralButton("OK", null);
  	  			CaixaAlerta.show();
  			}
  		});
        
        btlimpar = (Button)   findViewById(R.id.btlimpar);
        
        btlimpar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
  				primeirovalor.setText("");
  				segundovalor.setText("");
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
