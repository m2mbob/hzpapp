package com.example.login;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private ProgressDialog dialog=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bu1=(Button) findViewById(R.id.bu1);
		Button bu2=(Button) findViewById(R.id.bu2);
		Button bu3=(Button) findViewById(R.id.bu3);
		Button bu4=(Button) findViewById(R.id.bu4);		
		Button bu5=(Button) findViewById(R.id.bu5);
		Button bu6=(Button) findViewById(R.id.bu6);
		Button bu7=(Button) findViewById(R.id.bu7);
		Button bu8=(Button) findViewById(R.id.bu8);		
	    bu1.setOnClickListener(new View.OnClickListener(){
	            public void onClick(View v){
	            	Intent intent = new Intent();  
	                /* 指定intent要启动的类 */
	                intent.setClass(MainActivity.this, zxActivity.class);
	                /* 启动一个新的Activity */
	                MainActivity.this.startActivity(intent);
	                /* 关闭当前的Activity */
	              //  MainActivity.this.finish();
	            	
	            }
	        });
	    bu2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, jgActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    
	    bu3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, bzActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    bu4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, hyActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    bu5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, cxActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    bu6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, sbActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    bu7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, ffActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	    bu8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
            	Intent intent = new Intent();  
                /* 指定intent要启动的类 */
                intent.setClass(MainActivity.this, aboutActivity.class);
                /* 启动一个新的Activity */
                MainActivity.this.startActivity(intent);
                /* 关闭当前的Activity */
              //  MainActivity.this.finish();
            	
            }
        });
	}
	
	protected void onResume(){
		super.onResume();
		if(dialog!=null)
	  	  dialog.dismiss();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
