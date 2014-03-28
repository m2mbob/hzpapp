package com.example.login;

import com.example.login.R.id;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android .net.Uri;

public class helpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
		Button bu13 = (Button)findViewById(id.bu13);
		bu13.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 //Uri uri = Uri.parse("http://www.baidu.com"); 
				 Uri uri;
				 Intent it = new Intent(Intent.ACTION_VIEW);
				 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
				 it = Intent.createChooser( it, null );
				 startActivity(it);
			}
		});
	
	Button bu14 = (Button)findViewById(id.bu14);
	bu14.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.pingan.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu15 = (Button)findViewById(id.bu15);
	bu15.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.pingan.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu16 = (Button)findViewById(id.bu16);
	bu16.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.pingan.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu17 = (Button)findViewById(id.bu17);
	bu17.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.pingan.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu18 = (Button)findViewById(id.bu18);
	bu18.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu19 = (Button)findViewById(id.bu19);
	bu19.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu20 = (Button)findViewById(id.bu20);
	bu20.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu21 = (Button)findViewById(id.bu21);
	bu21.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
	Button bu22 = (Button)findViewById(id.bu22);
	bu22.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 //Uri uri = Uri.parse("http://www.baidu.com"); 
			 Uri uri;
			 Intent it = new Intent(Intent.ACTION_VIEW);
			 it.setData( Uri.parse( "http://www.baidu.com/") ); //这里面是需要调转的rul
			 it = Intent.createChooser( it, null );
			 startActivity(it);
		}
	});
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}