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

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ffActivity extends Activity {
	private TextView text;
	private String ff;
	private Spinner sp = null;
	private ProgressDialog dialog;
	private EditText edit;
	private Button b;
	private static final String m[]={"全部","洗发水","洗面奶","BB霜","沐浴乳","其他"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ff);
		sp = (Spinner) findViewById(R.id.sp4);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		edit=(EditText) findViewById(R.id.ed9);
		ff=edit.getText().toString();
		b=(Button) findViewById(R.id.bu10);
		text=(TextView) findViewById(R.id.te25);
		b.setOnClickListener(new View.OnClickListener(){
		public void onClick(View v){
	        	 dialog = ProgressDialog.show(ffActivity.this, "搜索中", "请稍后。。。。"); 
	        	 find(ff);
	         	}
		});
	}
	
	public void find(String ff){
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
 		String strUrl = "http://10.21.246.190:8080/makeup/appfind.action?ff="+ff; 
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
         	ProgressDialog.show(ffActivity.this, "protocol error", ""); 
             e.printStackTrace(); 
         } catch (IOException e) { 
         	ProgressDialog.show(ffActivity.this, "IO error", ""); 
             e.printStackTrace(); 
         } 
         
         try {
 			if(new JSONObject(strResult).getString("ans")=="true")
 			{
 				int n=new JSONObject(strResult).getInt("num");
 				for (int i=1;i<=n;i++)
 				{
 					text.setText("方法"+i+":"+new JSONObject(strResult).getString("方法"+i+":")+"\n");
 				}
 			}
 			else
 			{
 				text.setText("not find");
 			}
 		} catch (JSONException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}