import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class Mini_Twitter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DynamicTree treePanel;
	private int User_Total;
	private int Group_Total;
	private int Messages_Total;
	private Open_User_View frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mini_Twitter frame = new Mini_Twitter();
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
	public Mini_Twitter() 
	{
		// Frame 
		setBackground(new Color(30, 33, 36));
		setTitle("Admin Control Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(40, 43, 48));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Add User ID Text
		JTextArea User_ID_Text = new JTextArea();
		User_ID_Text.setText("USER_ID");
		User_ID_Text.setWrapStyleWord(true);
		User_ID_Text.setLineWrap(true);
		User_ID_Text.setBounds(340, 10, 240, 50);
		contentPane.add(User_ID_Text);
		
		// Add User Button
		JButton User_ID_Button = new JButton("Add User");
		User_ID_Button.setBackground(new Color(202, 178, 251));
		User_ID_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				treePanel.addObject(User_ID_Text.getText());
				User_Total++;
			}	
		});
		User_ID_Button.setBounds(590, 10, 240, 50);
		contentPane.add(User_ID_Button);
		
		// Add Group ID Text
		JTextArea Group_ID_Text = new JTextArea();
		Group_ID_Text.setWrapStyleWord(true);
		Group_ID_Text.setText("GROUP_ID");
		Group_ID_Text.setLineWrap(true);
		Group_ID_Text.setBounds(340, 70, 240, 50);
		contentPane.add(Group_ID_Text);
		
		// Add Group Button
		JButton Group_ID_Button = new JButton("Add Group");
		Group_ID_Button.setBackground(new Color(202, 178, 251));
		Group_ID_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				treePanel.addObject(Group_ID_Text.getText());
				Group_Total++;
			}
		});
		Group_ID_Button.setBounds(590, 70, 240, 50);
		contentPane.add(Group_ID_Button);
		
		// Open User View Button
		JButton Open_User_View_Button = new JButton("Open User View");
		Open_User_View_Button.setBackground(new Color(202, 178, 251));
		Open_User_View_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frame = new Open_User_View();
				
				frame.setTitle("User View");
				frame.setVisible(true);
			}
		});
		Open_User_View_Button.setBounds(340, 130, 490, 50);
		contentPane.add(Open_User_View_Button);
		
		// Show User Total Button
		JButton Show_Total_User_Button = new JButton("Show User Total");
		Show_Total_User_Button.setBackground(new Color(202, 178, 251));
		Show_Total_User_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Show_Total_User_Button.setText("Show User Total: " + User_Total);
			}
		});
		Show_Total_User_Button.setBounds(340, 450, 240, 50);
		contentPane.add(Show_Total_User_Button);
		
		// Show Group Total Button
		JButton Show_Group_Total_Button = new JButton("Show Group Total");
		Show_Group_Total_Button.setBackground(new Color(202, 178, 251));
		Show_Group_Total_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Show_Group_Total_Button.setText("Show Group Total: " + Group_Total);
			}
		});
		Show_Group_Total_Button.setBounds(590, 450, 240, 50);
		contentPane.add(Show_Group_Total_Button);
		
		// Show Total Messages
		JButton Show_Total_Messages_Button = new JButton("Show Total Messages");
		Show_Total_Messages_Button.setBackground(new Color(202, 178, 251));
		Show_Total_Messages_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Messages_Total = frame.get_Total();
				Show_Total_Messages_Button.setText("Show Total Messages: " + Messages_Total);
			}
		});
		Show_Total_Messages_Button.setBounds(340, 510, 240, 50);
		contentPane.add(Show_Total_Messages_Button);
		
		// Show Positive Percentage Button
		JButton Show_Positive_Percentage_Button = new JButton("Show Positive Percentage");
		Show_Positive_Percentage_Button.setBackground(new Color(202, 178, 251));
		Show_Positive_Percentage_Button.setBounds(590, 510, 240, 50);
		contentPane.add(Show_Positive_Percentage_Button);
		
		// Tree
		treePanel = new DynamicTree();
		treePanel.setBounds(10, 10, 320, 550);
		contentPane.add(treePanel);
	}
}




//package components;
class DynamicTree extends JPanel {
protected DefaultMutableTreeNode rootNode;
protected DefaultTreeModel treeModel;
public JTree tree;
private Toolkit toolkit = Toolkit.getDefaultToolkit();

public DynamicTree() {
 super(new GridLayout(1, 0));

 rootNode = new DefaultMutableTreeNode("Root Node");
 treeModel = new DefaultTreeModel(rootNode);

 tree = new JTree(treeModel);
 tree.setEditable(true);
 tree.getSelectionModel().setSelectionMode(
     TreeSelectionModel.SINGLE_TREE_SELECTION);
 tree.setShowsRootHandles(true);

 JScrollPane scrollPane = new JScrollPane(tree);
 add(scrollPane);
}


/** Return name of the currently selected node. */
public DefaultMutableTreeNode ObjectName() {
 DefaultMutableTreeNode parentNode = null;
 TreePath parentPath = tree.getSelectionPath();

 if (parentPath == null) {
   parentNode = rootNode;
 } else {
   parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
 }
 DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent(); node.toString();
 return node;
}




/** Add child to the currently selected node. */
public DefaultMutableTreeNode addObject(Object child) {
 DefaultMutableTreeNode parentNode = null;
 TreePath parentPath = tree.getSelectionPath();

 if (parentPath == null) {
   parentNode = rootNode;
 } else {
   parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
 }

 return addObject(parentNode, child, true);
}

public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
   Object child) {
 return addObject(parent, child, false);
}

public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
   Object child, boolean shouldBeVisible) {
 DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

 if (parent == null) {
   parent = rootNode;
 }

 // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
 treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

 // Make sure the user can see the new node.
 if (shouldBeVisible) {
   tree.scrollPathToVisible(new TreePath(childNode.getPath()));
 }
 return childNode;
}

class MyTreeModelListener implements TreeModelListener {
 public void treeNodesChanged(TreeModelEvent e) {
   DefaultMutableTreeNode node;
   node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

   /*
    * If the event lists children, then the changed node is the child of the
    * node we've already gotten. Otherwise, the changed node and the
    * specified node are the same.
    */

   int index = e.getChildIndices()[0];
   node = (DefaultMutableTreeNode) (node.getChildAt(index));

   System.out.println("The user has finished editing the node.");
   System.out.println("New value: " + node.getUserObject());
 }

 public void treeNodesInserted(TreeModelEvent e) {
 }

 public void treeNodesRemoved(TreeModelEvent e) {
 }

 public void treeStructureChanged(TreeModelEvent e) {
 }
}
}