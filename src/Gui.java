import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui extends Dimentions implements ItemListener, ActionListener, ListSelectionListener
{
	JFrame frame;
	JList<String> list;	
	
	JScrollPane listpanel;
	JPanel basepanel, btnpanel, txtboxpanel;
	JToggleButton btnclickme;
	JButton btnlogin;
	JLabel btnlabel;
	JTextField usrname, txt1, txt2, txt3, txt4;
	JPasswordField pwd;
	
	JButton btn1, btn2, btn3, btn4;
	
	Gui(String title)
	{
		this.frame = new JFrame(title);
	}
	

	
	void showFrame()
	{
		frame.setSize(frame_width, frame_height);		
		JFrame.setDefaultLookAndFeelDecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.pack();
				
		basepanel = new JPanel();
		basepanel.setLayout(null);
		basepanel.setOpaque(true);
		basepanel.setVisible(true);		
		basepanel.setBackground(Color.darkGray);
		frame.setContentPane(basepanel);

//==================================================================================================
		
		btnpanel = new JPanel();
		btnpanel.setLayout(null);
		btnpanel.setOpaque(true);			
		btnpanel.setBackground(Color.darkGray);
		btnpanel.setSize(btnpanel_width, btnpanel_height);
		btnpanel.setLocation(btnpanel_loc_x, btnpanel_loc_y);
		btnpanel.setBackground(Color.lightGray);
		basepanel.add(btnpanel);
		
		btnlabel = new JLabel("click the button below to change the color");
		btnlabel.setLocation(0, 0);
		btnlabel.setSize(btnpanel_width, btnpanel_height / 2);
		btnlabel.setHorizontalAlignment(0);
		btnpanel.add(btnlabel);
		
		btnclickme = new JToggleButton("click");
		btnclickme.setSize(button_clickme_width, button_clickme_height);
		btnclickme.setBackground(Color.white);
		btnclickme.setLocation(button_clickme_loc_x, button_clickme_loc_y);
		btnclickme.addItemListener(this);
		btnpanel.add(btnclickme);
		
//=======================================================================================================
		
		txtboxpanel = new JPanel();
		txtboxpanel.setLayout(null);
		txtboxpanel.setOpaque(true);		
		txtboxpanel.setBackground(Color.lightGray);
		txtboxpanel.setLocation(txtboxpanel_loc_x, txtboxpanel_loc_y);
		txtboxpanel.setSize(txtboxpanel_width, txtboxpanel_height);
		basepanel.add(txtboxpanel);
		
		usrname = new JTextField("enter username");
		usrname.setLocation(usrname_loc_x, usrname_loc_y);
		usrname.setSize(usrname_width, usrname_height);
		usrname.setBackground(Color.white);
		usrname.setVisible(true);
		txtboxpanel.add(usrname);
		
		pwd = new JPasswordField();
		pwd.setSize(pwd_width, pwd_height);
		pwd.setLocation(pwd_loc_x, pwd_loc_y);
		pwd.setBackground(Color.white);
		pwd.setVisible(true);
		pwd.setEchoChar('*');
		txtboxpanel.add(pwd);		
		
		btnlogin = new JButton("login");
		btnlogin.setSize(btnlogin_width, btnlogin_height);		
		btnlogin.setLocation(btnlogin_loc_x, btnlogin_loc_y);
		btnlogin.setBackground(Color.white);
		btnlogin.addActionListener(this);
		txtboxpanel.add(btnlogin);
	
		//to be called in the last
//===========================================================================
		frame.setVisible(true);
//===========================================================================		
		
	}
	
	
	void boxLayoutDemo()
	{
		frame.setSize(frame_width, frame_height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		basepanel = new JPanel();
		basepanel.setBackground(Color.lightGray);
		basepanel.setOpaque(true);
		basepanel.setLayout(new BoxLayout(basepanel, BoxLayout.LINE_AXIS));
		frame.add(basepanel);
		
		btnpanel = new JPanel();
		btnpanel.setLayout(new BoxLayout(btnpanel, BoxLayout.Y_AXIS));
		btnpanel.setBackground(Color.green);
		btnpanel.setMinimumSize(new Dimension(frame.getWidth()/2, frame.getHeight()));
		btnpanel.setPreferredSize(new Dimension(frame.getWidth()/2, frame.getHeight()));		
		basepanel.add(btnpanel);		
		btnpanel.add(Box.createVerticalGlue());
		
		btn1 = new JButton("button1");
		btn1.setMinimumSize(new Dimension(100, 50));
		btn1.setPreferredSize(new Dimension(100, 50));
		btn1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnpanel.add(btn1);	
		btnpanel.add(Box.createVerticalGlue());
				
		btn2 = new JButton("button2");
		btn2.setMinimumSize(new Dimension(100, 50));
		btn2.setPreferredSize(new Dimension(100, 50));
		btn2.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnpanel.add(btn2);		
		btnpanel.add(Box.createVerticalGlue());
				
		btn3 = new JButton("button3");
		btn3.setMinimumSize(new Dimension(100, 50));
		btn3.setPreferredSize(new Dimension(100, 50));
		btn3.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnpanel.add(btn3);		
		btnpanel.add(Box.createVerticalGlue());
				
		btn4 = new JButton("button4");
		btn4.setMinimumSize(new Dimension(100, 50));
		btn4.setPreferredSize(new Dimension(100, 50));
		btn4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnpanel.add(btn4);		
		btnpanel.add(Box.createVerticalGlue());
		
//=====================================================================================
		
		txtboxpanel = new JPanel();
		txtboxpanel.setLayout(new BoxLayout(txtboxpanel, BoxLayout.Y_AXIS));
		txtboxpanel.setBackground(Color.blue);
		txtboxpanel.setMinimumSize(new Dimension(frame.getWidth()/2, frame.getHeight()));
		txtboxpanel.setPreferredSize(new Dimension(frame.getWidth()/2, frame.getHeight()));
		basepanel.add(txtboxpanel);
		txtboxpanel.add(Box.createVerticalGlue());
		//txtboxpanel.add(Box.createRigidArea(new Dimension(0, 50)));
		
		txt1 = new JTextField();
		txt1.setMinimumSize(new Dimension(200, 40));
		txt1.setPreferredSize(new Dimension(200, 40));
		txt1.setMaximumSize(txt1.getPreferredSize());
		txtboxpanel.add(txt1);
		txtboxpanel.add(Box.createVerticalGlue());
		//txtboxpanel.add(Box.createRigidArea(new Dimension(0, 50)));
		
		txt2 = new JTextField();
		txt2.setMinimumSize(new Dimension(200, 40));
		txt2.setPreferredSize(new Dimension(200, 40));
		txt2.setMaximumSize(txt1.getPreferredSize());
		txtboxpanel.add(txt2);
		txtboxpanel.add(Box.createVerticalGlue());
		
		txt3 = new JTextField();
		txt3.setMinimumSize(new Dimension(200, 40));
		txt3.setPreferredSize(new Dimension(200, 40));
		txt3.setMaximumSize(txt3.getPreferredSize());
		txtboxpanel.add(txt3);
		txtboxpanel.add(Box.createVerticalGlue());
		
		txt4 = new JTextField();
		txt4.setMinimumSize(new Dimension(200, 40));
		txt4.setPreferredSize(new Dimension(200, 40));
		txt4.setMaximumSize(txt4.getPreferredSize());
		txtboxpanel.add(txt4);
		txtboxpanel.add(Box.createVerticalGlue());		
		
		
		//frame.pack();
		frame.setVisible(true);
	}
	
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getStateChange() == ItemEvent.SELECTED)
			btnpanel.setBackground(Color.green);
		else
			btnpanel.setBackground(Color.lightGray);
			
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btnlogin)
		{
			String username = "karan";
			char[] password = {'v', 'a', 'i', 'd'};
			
			if(username.contentEquals(usrname.getText()) && Arrays.equals(password, pwd.getPassword()))
			{
				if(txtboxpanel.getBackground() == Color.lightGray)
					txtboxpanel.setBackground(Color.green);
				usrname.setText("");
				pwd.setText("");
			}
			
		}
	}
	
	
	
	public void JListExample()
	{
		String listContents[] = new String[21];
		for(int i=1; i<=20; i++)
		{
			listContents[i] = Integer.toString(i);
		}
		
		
		frame.setSize(frame_width, frame_height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		basepanel = new JPanel();
		basepanel.setLayout(null);
		basepanel.setOpaque(true);
		basepanel.setBackground(Color.DARK_GRAY);
		
		frame.setContentPane(basepanel);
		
		list = new JList<String>(listContents);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		list.addListSelectionListener(this);
		
		listpanel = new JScrollPane(list);
		listpanel.setSize(100, 200);
		//listpanel.add(list);
				
		basepanel.add(listpanel);
		frame.setVisible(true);		
	}



	@Override
	public void valueChanged(ListSelectionEvent e) 
	{		
		if(!e.getValueIsAdjusting())
		{
			System.out.println(list.getSelectedIndex());
			//new BackgroundTask().execute();
			executeBackgroundTask().execute();
		}
		
		
		
	}	

	
	
	public SwingWorker executeBackgroundTask()
	{
		
		SwingWorker<String, String> worker = new SwingWorker<String, String>()
				{
			@Override
			protected String doInBackground()
			{
				System.out.println("in the method");
				try {
					System.out.println("edt:"+SwingUtilities.isEventDispatchThread());
					System.out.println("fetching data");
					
					for(int i=0;i<10;i++)
					{
						System.out.println(i);
						Thread.sleep(1000);
					}
					
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				return "returned value form doInBackground()";
			}
			
			
			@Override
			protected void done()
			{
				System.out.println("done method invoked");
				try {
					System.out.println("get method: "+get());
					} 
				catch (InterruptedException e) {e.printStackTrace();} 
				catch (ExecutionException e) {e.printStackTrace();}
				
			}
			
				};
				return worker;
				//worker.execute();
				
	}
	
	
	
}




















