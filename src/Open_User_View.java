import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JLabel;

public class Open_User_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel User_Display;
	private static int Message_Total = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Open_User_View frame = new Open_User_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Open_User_View() {
		setTitle("User_ID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 375);
		User_Display = new JPanel();
		User_Display.setBackground(new Color(40, 43, 48));
		User_Display.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(User_Display);
		User_Display.setLayout(null);
		
		JTextArea UV_UserID = new JTextArea();
		UV_UserID.setWrapStyleWord(true);
		UV_UserID.setLineWrap(true);
		UV_UserID.setText("User ID");
		UV_UserID.setBounds(10, 10, 199, 40);
		User_Display.add(UV_UserID);
		
		
		DefaultListModel<String> model = new DefaultListModel<>();
		JList<String> UV_FollowingList = new JList<>(model);
		UV_FollowingList.setToolTipText("");
		model.addElement("Following:");
		UV_FollowingList.setBounds(10, 61, 414, 63);
		User_Display.add(UV_FollowingList);
		
		JButton UV_FollowUser = new JButton("Follow User");
		UV_FollowUser.setBackground(new Color(202, 178, 251));
		UV_FollowUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//Subject_Follower  followed = new Subject_Follower();
				//Observer_Follower follower = new Observer_Follower(); 
				model.addElement(UV_UserID.getText());
				
			}	
		});
		UV_FollowUser.setBounds(219, 11, 205, 40);
		User_Display.add(UV_FollowUser);
		
		JTextArea UV_PostMessage = new JTextArea();
		UV_PostMessage.setLineWrap(true);
		UV_PostMessage.setWrapStyleWord(true);
		UV_PostMessage.setText("Tweet Message");
		UV_PostMessage.setBounds(10, 135, 199, 40);
		User_Display.add(UV_PostMessage);
		
		JLabel Update_Time = new JLabel("Update Time: " + System.currentTimeMillis());
		Update_Time.setForeground(Color.WHITE);
		Update_Time.setBackground(Color.WHITE);
		Update_Time.setBounds(10, 294, 414, 31);
		User_Display.add(Update_Time);
		
		JButton UV_Post = new JButton("Post Tweet");
		UV_Post.setBackground(new Color(202, 178, 251));
		UV_Post.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Message_Total++;
				Update_Time.setText("Update Time: "+ System.currentTimeMillis());
				
			}	
		});
		UV_Post.setBounds(219, 136, 205, 40);
		User_Display.add(UV_Post);
		
		DefaultListModel<String> model2 = new DefaultListModel<>();
		JList<String> UV_NewsFeed = new JList<>(model2);
		model2.addElement("News Feed:");
		UV_NewsFeed.setBounds(10, 186, 414, 63);
		User_Display.add(UV_NewsFeed);
		
		JLabel Creation_Time = new JLabel("Creation Time: " + System.currentTimeMillis());
		Creation_Time.setBackground(new Color(255, 255, 255));
		Creation_Time.setForeground(new Color(255, 255, 255));
		Creation_Time.setBounds(10, 272, 414, 31);
		User_Display.add(Creation_Time);
		
		
	}


public int get_Total()
{
	return Message_Total;
}
}