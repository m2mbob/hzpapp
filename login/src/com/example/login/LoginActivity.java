package com.example.login;


import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.login.LoginActivity;
import com.example.login.UserInfo;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
	private ProgressDialog dialog;
	private TextView error;
	private String username;
	private String password;
	private Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		b=(Button) findViewById(R.id.bu);
		System.out.println("onCreate");
		b.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v){
	        	 dialog = ProgressDialog.show(LoginActivity.this, "登陆中", "请稍后。。。。"); 
	        	 username=((EditText)findViewById(R.id.ed1)).getText().toString();
	             password=((EditText)findViewById(R.id.ed2)).getText().toString();
	             System.out.println(username);
	             System.out.println(password);
	             System.out.println("onClick");
	        	if(check(username,password)){
	        		System.out.println("true");
	        		Intent intent = new Intent();
	                intent.putExtra("username",username);    
	                /* 指定intent要启动的类 */
	                intent.setClass(LoginActivity.this, MainActivity.class);
	                /* 启动一个新的Activity */
	                LoginActivity.this.startActivity(intent);
	                /* 关闭当前的Activity */
	                LoginActivity.this.finish();
	        	}
	        	else {
	        		dialog.dismiss();
	        		error.setText("用户名或密码错误！");
	        	}

	        }
	        });
	}
	
	public boolean check(String username,String password){
        try {
        	System.out.println("onCheck");
			if(username.equals("zsc")&&password.equals("123456"))
			{
				return true;
			}
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}