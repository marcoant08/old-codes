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

public class Main2 extends Activity {

	Button btvoltar, btcalcular, btlimpar;
	EditText peso, altura;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);
		
		btvoltar = (Button)
				findViewById(R.id.btvoltar);
		
		btvoltar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent NewProject = new
				Intent(Main2.this,Main1.class);
				Main2.this.startActivity(NewProject);
				Main2.this.finish();
				
			}
		});
		
        peso    = (EditText) findViewById(R.id.primeirovalor);
        altura    = (EditText) findViewById(R.id.altura);

        btcalcular = (Button)   findViewById(R.id.btcalcular);

        btcalcular.setOnClickListener(new View.OnClickListener() {

  			public void onClick(View v) {
  				double p = Double.parseDouble(peso.getText().toString());
  				double a = Double.parseDouble(altura.getText().toString());	

  				double resultad = p/(a*a);

  				if (resultad < 17) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nMuito abaixo do Peso");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 17 && resultad < 18.5) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nAbaixo do Peso");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 18.5 && resultad < 25) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nPeso normal");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 25 && resultad < 30) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nAcima do Peso");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 30 && resultad < 35) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nObesidade I");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 35 && resultad < 40) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nObesidade II (Severa)");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  				if (resultad >= 40) {
  					AlertDialog.Builder CaixaAlerta = new AlertDialog.Builder(Main2.this);
  	  				CaixaAlerta.setTitle("Resultado");
  	  				CaixaAlerta.setMessage("Seu IMC é: "+String.valueOf(resultad)
  								+"\nObesidade III (Mórbida)");
  	  				CaixaAlerta.setNeutralButton("OK", null);
  	  				CaixaAlerta.show();
				}
  			}
  		});
        
        btlimpar = (Button)   findViewById(R.id.btlimpar);
        
        btlimpar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
  				peso.setText("");
  				altura.setText("");
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
