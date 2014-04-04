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

public class sbActivity extends Activity {
	private TextView text;
	private String sb;
	private Spinner sp = null;
	private ProgressDialog dialog;
	private EditText edit;
	private Button b;
	private static final String m[]={"ȫ��","ϴ��ˮ","ϴ����","BB˪","��ԡ��","����"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sb);
		sp = (Spinner) findViewById(R.id.sp6);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		sp.setAdapter(adapter);
		edit=(EditText) findViewById(R.id.ed11);
		sb=edit.getText().toString();
		b=(Button) findViewById(R.id.bu12);
		text=(TextView) findViewById(R.id.te27);
		b.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
	        	 dialog = ProgressDialog.show(sbActivity.this, "������", "���Ժ󡣡�����"); 
	        	 find(sb);
	         	}
		});
	}

	public void find(String sb){
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
 		String strUrl = "http://10.21.246.190:8080/makeup/appfind.action?sb="+sb; 
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
         	ProgressDialog.show(sbActivity.this, "protocol error", ""); 
             e.printStackTrace(); 
         } catch (IOException e) { 
         	ProgressDialog.show(sbActivity.this, "IO error", ""); 
             e.printStackTrace(); 
         } 
         
         try {
 			if(new JSONObject(strResult).getString("ans")=="true")
 			{
 				int n=new JSONObject(strResult).getInt("num");
 				for (int i=1;i<=n;i++)
 				{
 					text.setText("�豸"+i+":"+new JSONObject(strResult).getString("�豸"+i+":")+"\n");
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