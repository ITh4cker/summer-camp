package com.socket.client;
//Download by http://www.codefans.net

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	//����������Ҫ�õ���UIԪ��
	private EditText edtmsgcontent;
	private Button btnSend;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        InitView();
    }
    private void InitView()
    {
    	//��ʾ������
    	setContentView(R.layout.main);
    	
    	//ͨ��id��ȡuiԪ�ض���
    	edtmsgcontent=(EditText)findViewById(R.id.msgcontent);
    	btnSend=(Button)findViewById(R.id.btnsend);
    	
    	//Ϊbtnsend���õ���¼�
    	btnSend.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String ip="192.168.1.102";
				int port=1818;
				try 
				{
					String msg=edtmsgcontent.getText().toString();
					if(!TextUtils.isEmpty(msg))
						SendMsg(ip,port,msg);
					else
					{
						Toast.makeText(getApplicationContext(),"��������Ҫ���͵�����", Toast.LENGTH_LONG);
						edtmsgcontent.requestFocus();
					}
				}
			 catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 	}
			}
		});
    }
    
//    public void onClick(View bt)
//    {
//    	
//	 }
    public void SendMsg(String ip,int port,String msg) throws UnknownHostException, IOException
    {
    	try
    	{
    	Socket socket=null;
    	socket=new Socket(ip,port);
    	BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    	writer.write(msg);
    	writer.flush();
    	writer.close();
    	socket.close();
    	}
    	catch(UnknownHostException e)
    	{
    		e.printStackTrace();
    	} catch (IOException e) 
    	{
    	    e.printStackTrace();
        }
    }
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}