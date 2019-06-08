package com.yychatclient.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{
	public static HashMap hmFriendChat1=new HashMap<String,FriendChat1>();
	
	CardLayout cardLayout;
	
	JPanel myFriendPanel;
	JButton myFriendJButton;
	
	JScrollPane myFriendJScrollPanel;
	JPanel myFriendListJPanel;
	static final int FRIENDCOUNT=51;
	JLabel[] myFriendJLabel=new JLabel[FRIENDCOUNT];
	
	
	JPanel myStrangerBlackListJPanel;
	JButton myStrangerJButton;
	JButton blackListJButton;
	
	JPanel myStrangerPanel;
	
	JPanel myFriendStrangerPanel;
	JButton myFriendJButton1;
	JButton myStrangerJButton1;
	
	JButton blackListJButton1;
	
	String userName;

	
	public FriendList(String userName,String friendString) {
		this.userName=userName;
	
		
		myFriendPanel=new JPanel(new BorderLayout());
	
		
		myFriendJButton=new JButton("我的好友");
		myFriendPanel.add(myFriendJButton,"North");
		
		
		/*JScrollPane myFriendJScrollPanel;
		JPanel myFriendListJPanel;
		static final int FRIENDCOUNT=51;
		JLabel[] myFriendJLabel;*/
		
		
		String[] friendName=friendString.split(" ");
		int count=friendName.length;
		
		myFriendListJPanel=new JPanel(new GridLayout(count,1));
		for(int i=0;i<count;i++) {
			myFriendJLabel[i]=new JLabel(friendName[i]+"",new ImageIcon("Images/YY1.gif"),JLabel.LEFT);
			//myFriendJLabel[i].setEnabled(false);
			
			
			
			myFriendJLabel[i].addMouseListener(this);
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		//myFriendJLabel[Integer.parseInt(userName)].setEnabled(true);
		//myFriendJScrollPanel=new JScrollPane();
		//myFriendJScrollPanel.add(myFriendListJPanel);
		myFriendJScrollPanel=new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendJScrollPanel);
		
		myStrangerBlackListJPanel=new JPanel(new GridLayout(2,1));
		myStrangerJButton=new JButton("我的陌生人");
		
		myStrangerJButton.addActionListener(this);
		
		blackListJButton=new JButton("黑名单");
		myStrangerBlackListJPanel.add(myStrangerJButton);
		myStrangerBlackListJPanel.add(blackListJButton);
		myFriendPanel.add(myStrangerBlackListJPanel,"South");
		
		
		myStrangerPanel=new JPanel(new BorderLayout());
		
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
		myFriendJButton1=new JButton("我的好友");
		myFriendJButton1.addActionListener(this);
		myStrangerJButton1=new JButton("我的陌生人");
		myFriendStrangerPanel.add(myFriendJButton1);
		myFriendStrangerPanel.add(myStrangerJButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");
			
		blackListJButton1=new JButton("黑名单");
		myStrangerPanel.add(blackListJButton1,"South");
	
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");
		this.add(myStrangerPanel,"2");
		
		this.setSize(150,500);
		this.setTitle(this.userName+" 的好友列表");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
		
		public static void main(String[] args) {
			//FriendList friendList=new FriendList();
			
		}
		
		
		public void setEnableFriendIcon(String friendString) {
			
			
			String[] friendName=friendString.split(" ");
			int count=friendName.length;
			System.out.println("好友的个数"+count);
			for(int i=1;i<count;i++) {
				
				System.out.println("frendList["+i+"]:"+friendName[i]);
				myFriendJLabel[Integer.parseInt(friendName[i])].setEnabled(true);
			}
		}
		
		public void setEnableNewFriendIcon(String newOnlinefriendString) {
			myFriendJLabel[Integer.parseInt(newOnlinefriendString)].setEnabled(true);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==myStrangerJButton) {
				cardLayout.show(this.getContentPane(),"2");
			}
			if(arg0.getSource()==myFriendJButton1) {
				cardLayout.show(this.getContentPane(),"1");
			}
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(arg0.getClickCount()==2) {
				JLabel jlbl=(JLabel)arg0.getSource();
				String receiver=jlbl.getText();
				//new FriendChat(this.userName,receiver);
				
				
				
				FriendChat1 friendChat1=(FriendChat1)hmFriendChat1.get(userName+"to"+receiver);
				if(friendChat1==null) {
				friendChat1=new FriendChat1(this.userName,receiver);
				hmFriendChat1.put(userName+"to"+receiver,friendChat1);
				}else {
					friendChat1.setVisible(true);
				}
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		   JLabel jLabel=(JLabel)e.getSource();
		   jLabel.setForeground(Color.red);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			JLabel jLabel=(JLabel)e.getSource();
		  jLabel.setForeground(Color.black);
				
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

}