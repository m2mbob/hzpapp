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
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("NewApi")
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
	     
	     @SuppressLint("NewApi")
		public boolean check(String username,String password){
	    	 System.out.println("check");
	     	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
	 		.detectDiskReads()
	 		.detectDiskWrites()
	 		.detectNetwork() // 这里可以替换为detectAll() 就包括了磁盘读写和网络I/O
	 		.penaltyLog() //打印logcat，当然也可以定位到dropbox，通过文件保存相应的log
	 		.build());
	 		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
	 		.detectLeakedSqlLiteObjects() //探测SQLite数据库操作
	 		//.penaltyLog() //打印logcats
	 		.penaltyDeath()
	 		.build()); 
	 		String strUrl = "http://10.21.246.190:8080/makeup/applogin.action?username="+username+"&password="+password; 
	 		HttpGet httpRequest = new HttpGet(strUrl); 
	 		System.out.println("GET");
	         String strResult = ""; 
	         try { 
	             // HttpClient对象 
	             HttpClient httpClient = new DefaultHttpClient(); 
	             System.out.println("client");
	             // 获得HttpResponse对象 
	             HttpResponse httpResponse = httpClient.execute(httpRequest); 
	             System.out.println("response");
	             if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { 
	                 // 取得返回的数据 
	                 strResult = EntityUtils.toString(httpResponse.getEntity()); 
	             } 
	         } catch (ClientProtocolException e) { 
	         	ProgressDialog.show(LoginActivity.this, "protocol error", ""); 
	             e.printStackTrace(); 
	         } catch (IOException e) { 
	         	ProgressDialog.show(LoginActivity.this, "IO error", ""); 
	             e.printStackTrace(); 
	         } 
	         
	         try {
	 			if(new JSONObject(strResult).getString("ans")=="true")
	 			{
	 				UserInfo userInfo = ((UserInfo)getApplicationContext());    
	 		        userInfo.setUsername(username);
	 				return true;
	 			}
	 			else return false;
	 		} catch (JSONException e) {
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