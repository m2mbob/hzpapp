package com.example.login;




import org.apache.http.client.methods.HttpGet;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class xgActivity extends Activity{
	private Button xg;
	private String password;
	private String password1;
	private String username;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xg);
		xg=(Button) findViewById(R.id.bu26);
   	 	password=((EditText)findViewById(R.id.ed13)).getText().toString();
   	 	password1=((EditText)findViewById(R.id.ed14)).getText().toString();
   	 	xg.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v){
	        	if (password.equals(password1)){
	        		 UserInfo userInfo = ((UserInfo)getApplicationContext());
		        	 username=userInfo.getUsername();
		             System.out.println(username);
		             System.out.println("onClick");
		             xiugai();
		             Toast.makeText(getApplicationContext(), "�޸ĳɹ���", Toast.LENGTH_SHORT);
	    		}
	    		else
	    		{
	    			Toast.makeText(getApplicationContext(), "�������벻����", Toast.LENGTH_SHORT);
	    		}
	         }
	         });
	}
	
	public void xiugai(){
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
 		String strUrl = "http://10.21.246.190:8080/makeup/appuser.action?username="+username+"&password="+password+"&xg"+true; 
 		HttpGet httpRequest = new HttpGet(strUrl); 
 		}
	}
