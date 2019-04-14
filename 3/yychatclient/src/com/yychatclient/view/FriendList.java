package com.yychatclient.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.*;

public class FriendList extends JFrame implements ActionListener,MouseListener{//��������
	
	public static HashMap hmFriendChat1=new HashMap<String,FriendChat1>();
	
	CardLayout cardLayout;//��Ƭ����
	
	JPanel myFriendPanel;
	JPanel myStrangerBlackJPanel;
	JButton myFriendJButton;
	JButton myStrangerJButton;
	JButton myBlackJButton;
	
	JScrollPane myFriendJScrollPane;
	JPanel myFriendListJPanel;
	static final int FRIENDCOUNT=51;
	JLabel[] myFriendJLabel=new JLabel[FRIENDCOUNT];

	
	JPanel myStrangerPanel;
	JPanel myFriendStrangerPanel;
	JButton myFriendJButton1;
	JButton myStrangerJButton1;
	JButton myBlackJButton1;
	
	JScrollPane myStrangerscrollpane;
	JPanel myStrangerListpanel;
	static final int STRANGERCOUNT=21;
	JLabel[] myStrangerJLabel=new JLabel[STRANGERCOUNT];
	
	JPanel myBlackPanel;
	JPanel myFriendStrangerBlackJPanel;
	JButton myFriendJButton2;
	JButton myStrangerJButton2;
	JButton myBlackJButton2;
	
	JScrollPane myBlackscrollpane;
	JPanel myBlackListpanel;
	static final int BLACKCOUNT=21;
	JLabel[] myBlackJLabel =new JLabel[BLACKCOUNT];
	
	String userName;
	
	public FriendList(String userName){
		this.userName=userName;//�ֲ���������Ա������ֵ
		//��һ�ſ�Ƭ����������
		myFriendPanel=new JPanel(new BorderLayout());//�߽粼��
		myFriendJButton=new JButton("�ҵĺ���");		
		myFriendPanel.add(myFriendJButton,"North");
		
		
		myFriendListJPanel=new JPanel(new GridLayout(FRIENDCOUNT-1,1));
		for(int i=1;i<FRIENDCOUNT;i++){
			myFriendJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);//"1"
			myFriendJLabel[i].addMouseListener(this);//�����������
			myFriendListJPanel.add(myFriendJLabel[i]);
		}
		myFriendJScrollPane =new JScrollPane(myFriendListJPanel);
		myFriendPanel.add(myFriendJScrollPane);
		
		
		myStrangerBlackJPanel=new JPanel(new GridLayout(2,1));//���񲼾�
		myStrangerJButton=new JButton("�ҵ�İ����");
		myStrangerJButton.addActionListener(this);
		
		myBlackJButton=new JButton("������");
		myStrangerBlackJPanel.add(myStrangerJButton);
		myStrangerBlackJPanel.add(myBlackJButton);
		myFriendPanel.add(myStrangerBlackJPanel,"South");
		
		
		//��һ�ſ�Ƭ
		myStrangerPanel = new JPanel(new BorderLayout());
		myFriendStrangerPanel=new JPanel(new GridLayout(2,1));
		myFriendJButton1=new JButton("�ҵĺ���");//��Ӽ�����
		myFriendJButton1.addActionListener(this);
		
		
		myStrangerJButton1=new JButton("�ҵ�İ����");
		myFriendStrangerPanel.add(myFriendJButton1);
		myFriendStrangerPanel.add(myStrangerJButton1);
		myStrangerPanel.add(myFriendStrangerPanel,"North");	
		
		myStrangerListpanel=new JPanel(new GridLayout(STRANGERCOUNT-1,1));
		for(int i=1;i<STRANGERCOUNT;i++){
			myStrangerJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);//"1"
			myStrangerJLabel[i].addMouseListener(this);//�����������
			myStrangerListpanel.add(myStrangerJLabel[i]);
		}
		myStrangerscrollpane =new JScrollPane(myStrangerListpanel);
		myStrangerPanel.add(myStrangerscrollpane);
		
		
		myBlackJButton1=new JButton("������");
		myBlackJButton1.addActionListener(this);
		myStrangerPanel.add(myBlackJButton1,"South");
		
		
		
		//��Ƭ��
		myBlackPanel = new JPanel(new BorderLayout());
		myFriendStrangerBlackJPanel=new JPanel(new GridLayout(3,1));
		myFriendJButton2=new JButton("�ҵĺ���");//��Ӽ�����
		myFriendJButton2.addActionListener(this);
		myStrangerJButton2=new JButton("İ����");
		myStrangerJButton2.addActionListener(this);
		myBlackJButton2=new JButton("������");
		myFriendStrangerBlackJPanel.add(myFriendJButton2);
		myFriendStrangerBlackJPanel.add(myStrangerJButton2);
		myFriendStrangerBlackJPanel.add(myBlackJButton2);
		myBlackPanel.add(myFriendStrangerBlackJPanel,"North");
		
		myBlackListpanel=new JPanel(new GridLayout(BLACKCOUNT-1,1));
		for(int i=1;i<BLACKCOUNT;i++){
			myBlackJLabel[i]=new JLabel(i+"",new ImageIcon("images/YY1.gif"),JLabel.LEFT);//"1"
			myBlackJLabel[i].addMouseListener(this);//�����������
			myBlackListpanel.add(myBlackJLabel[i]);
		}
		myBlackscrollpane =new JScrollPane(myBlackListpanel);
		myBlackPanel.add(myBlackscrollpane);
			
		cardLayout=new CardLayout();
		this.setLayout(cardLayout);
		this.add(myFriendPanel,"1");		 
		this.add(myStrangerPanel,"2");
		this.add(myBlackPanel,"3");
		
		this.setSize(150,500);
		this.setTitle(this.userName+" �ĺ����б�");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		//FriendList friendList=new FriendList();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==myStrangerJButton){
			cardLayout.show(this.getContentPane(), "2");
		}
		if(arg0.getSource()==myFriendJButton1){
			cardLayout.show(this.getContentPane(), "1");
		}
		if(arg0.getSource()==myBlackJButton1){
			cardLayout.show(this.getContentPane(), "3");
		}
		if(arg0.getSource()==myFriendJButton2){
			cardLayout.show(this.getContentPane(), "1");
		}
		if(arg0.getSource()==myStrangerJButton2){
			cardLayout.show(this.getContentPane(), "2");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(arg0.getClickCount()==2){
			JLabel jlbl=(JLabel)arg0.getSource();
			String receiver=jlbl.getText();
			
			//new FriendChat(this.userName,receiver);
			//new FriendChat1(this.userName,receiver);
			FriendChat1 friendChat1=new FriendChat1(this.userName,receiver);
			hmFriendChat1.put(userName+"to"+receiver,friendChat1);
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