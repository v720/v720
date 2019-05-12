package com.yychatclient.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.yychat.model.Message;
import com.yychatclient.controller.ClientConnect;

public class FriendChat1 extends JFrame implements ActionListener{//动作监听器
 
	//中间部分
	JScrollPane jsp;//滚动条
	JTextArea jta;//文本域
	
	
	//南部部分
	JPanel jp;//面板
	JTextField jtf;//一行文本
	JButton jb;
	
	String sender;
	String receiver;
	
	public FriendChat1(String sender,String receiver){//自定义构造方法
		this.sender=sender;
		this.receiver=receiver;
		
		jta = new JTextArea();//文本区域
		jta.setEditable(false);//不允许在文本域进行编辑
		jta.setForeground(Color.red);//显体颜色
		jsp = new JScrollPane(jta);//滚动条只可以在构造方法里面定义组件
		this.add(jsp);//加入窗口中
		
		jp = new JPanel();
		jtf = new JTextField(15);//字符长度
		jtf.setForeground(Color.red);;
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp.add(jtf);
		jp.add(jb);
		this.add(jp,"South");
		this.setSize(350, 240);
		this.setTitle(sender+"正在和"+receiver+"聊天");
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);//居中显示窗口
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		//FriendChat friendChat=new FriendChat("1","2");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {//事件处理代码
	 if(arg0.getSource()==jb) {
		 jta.append(jtf.getText()+"\r\n");
		 
		 //向服务器 发送聊天信息
		 Message mess=new Message();
		 mess.setSender(sender);
		 mess.setReceiver(receiver);
		 mess.setContent(jtf.getText());
		 mess.setMessageType(Message.message_Common);
		 ObjectOutputStream oos;
		try {
			Socket s=(Socket)ClientConnect.hsmSocket.get(sender);
			oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(mess);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }
		
	}
	public void appendJta(String showMessage){
	  jta.append(showMessage+"\r\n");
	}

}