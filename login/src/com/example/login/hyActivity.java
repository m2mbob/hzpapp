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
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hyActivity extends Activity {
	private Button ck;
	private Button xg;
	private String username;
	private TextView teck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hy);
		ck=(Button) findViewById(R.id.bu23);
		ck.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v){
	        	 UserInfo userInfo = ((UserInfo)getApplicationContext());
	        	 username=userInfo.getUsername();
	             System.out.println(username);
	             System.out.println("onClick");
	             chakan();
	         		 Intent intent = new Intent();
	                 intent.putExtra("username",username);    
	                 /* ָ��intentҪ�������� */
	                 intent.setClass(hyActivity.this, viewActivity.class);
	                 /* ����һ���µ�Activity */
	                 hyActivity.this.startActivity(intent);
	                 /* �رյ�ǰ��Activity */
	                 hyActivity.this.finish();
	         }
	         });
		xg=(Button) findViewById(R.id.bu24);
		xg.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v){
	        	 UserInfo userInfo = ((UserInfo)getApplicationContext());
	        	 username=userInfo.getUsername();
	             System.out.println(username);
	             System.out.println("onClick");
	         		 Intent intent = new Intent();
	                 intent.putExtra("username",username);    
	                 /* ָ��intentҪ�������� */
	                 intent.setClass(hyActivity.this, xgActivity.class);
	                 /* ����һ���µ�Activity */
	                 hyActivity.this.startActivity(intent);
	                 /* �رյ�ǰ��Activity */
	                 hyActivity.this.finish();
	         }
	         });
}
		


	public void chakan(){
     	StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
 		.detectDiskReads()
 		.detectDiskWrites()
 		.detectNetwork() // ��������滻ΪdetectAll() �Ͱ����˴��̶�д������I/O
 		.penaltyLog() //��ӡlogcat����ȻҲ���Զ�λ��dropbox��ͨ���ļ�������Ӧ��log
 		.build());
 		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
 		.detectLeakedSqlLiteObjects() //̽��SQLite���ݿ����
 		//.penaltyLog() //��ӡlogcats
 		.penaltyDeath()
 		.build()); 
 		String strUrl = "http://10.21.246.190:8080/makeup/appuser.action?username="+username+"&ck="+true; 
 		HttpGet httpRequest = new HttpGet(strUrl); 
 		System.out.println("GET");
         String strResult = ""; 
         try { 
             // HttpClient���� 
             HttpClient httpClient = new DefaultHttpClient(); 
             System.out.println("client");
             // ���HttpResponse���� 
             HttpResponse httpResponse = httpClient.execute(httpRequest); 
             System.out.println("response");
             if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { 
                 // ȡ�÷��ص����� 
                 strResult = EntityUtils.toString(httpResponse.getEntity()); 
             } 
         } catch (ClientProtocolException e) { 
         	ProgressDialog.show(hyActivity.this, "protocol error", ""); 
             e.printStackTrace(); 
         } catch (IOException e) { 
         	ProgressDialog.show(hyActivity.this, "IO error", ""); 
             e.printStackTrace(); 
         } 
         
         try {
        	 teck=(TextView) findViewById(R.id.te28);
 			teck.setText("id:"+new JSONObject(strResult).getString("id")+"\n");
 			teck.setText("�˺�:"+new JSONObject(strResult).getString("�˺�")+"\n");
 			teck.setText("����:"+new JSONObject(strResult).getString("����")+"\n");
 			teck.setText("�˺ż���:"+new JSONObject(strResult).getString("�˺ż���")+"\n");
 		} catch (JSONException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}
}
