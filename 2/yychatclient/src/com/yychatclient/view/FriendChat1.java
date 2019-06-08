package com.yychatclient.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;
import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import com.yychat.model.Message;
import com.yychatclient.controller.ClientConnect;

public class FriendChat1 extends JFrame implements ActionListener{


	JScrollPane jsp;
	JTextArea jta;
	
	
	JPanel jp;
	JTextField jtf;
	JButton jb;
	
	String sender;
	String receiver;
	
	public FriendChat1(String sender,String receiver){
		this.sender=sender;
		this.receiver=receiver;
		
		jta=new JTextArea();
		jta.setEditable(false);
		jta.setForeground(Color.red);
		jsp=new JScrollPane(jta);
		this.add(jsp,"Center");
		
		jp=new JPanel();
		jtf=new JTextField(15);
		jtf.setForeground(Color.red);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		
		this.setSize(350,240);
		this.setTitle(sender+"���ں�"+receiver+"����");
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);	
	}
	
	public static void main(String[] args) {
		FriendChat1 friendChat=new FriendChat1("1","2");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==jb) {
			jta.append(jtf.getText()+"\r\n");
			
			
			Message mess=new Message();
			mess.setSender(sender);
			mess.setReceiver(receiver);
			mess.setContent(jtf.getText());
			mess.setMessageType(Message.message_Common);
			ObjectOutputStream oos;
			try {
				Socket s=(Socket)ClientConnect.hmSocket.get(sender);
				oos=new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(mess);
				
				
				
				
				
				
				
					
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void appendJta(String showMessage) {
		jta.append(showMessage+"\r\n");
	}
}