package com.yychatclient.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

import com.yychat.model.Message;
import com.yychat.model.User;

public class ClientConnect {
	
	public  Socket s;//��̬��Ա�������
	
	public static HashMap hsmSocket=new HashMap<String,Socket>();
	
	public ClientConnect(){
		try {
			s= new Socket("127.0.0.1",3456);//������ַ���ز��ַ
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Message loginValidate(User user){
		//������������󣬷��Ͷ���
		//�ֽ���������� ��װ �������������
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Message mess=null;
		try {
			oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(user);
			
			
			
			//������֤ͨ����mess
			ois=new ObjectInputStream(s.getInputStream());
			mess=(Message)ois.readObject();		
			
			if(mess.getMessageType().equals(Message.message_LoginSuccess)){
				   System.out.println(user.getUserName()+"��¼�ɹ�");
				   hsmSocket.put(user.getUserName(),s);
				   new ClientReceiverThread(s).start();
				}
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return mess;		
	}
}
