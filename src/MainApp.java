import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Button;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mdlaf.MaterialLookAndFeel;

import su.litvak.chromecast.api.v2.ChromeCast;
import su.litvak.chromecast.api.v2.ChromeCasts;
import su.litvak.chromecast.api.v2.Status;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class MainApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public MainApp() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		
		JLabel label = new JLabel("");
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 11));
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 269, 452, 194);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnOpen = new JButton("Open");
		btnOpen.setBorder(null);
		
		btnOpen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					FileDialog fd = new FileDialog( frame, "Open", FileDialog.LOAD); 
				fd.setVisible(true);
				String path = new File(fd.getFile()).getAbsolutePath();
				System.out.println(path);
				label.setText(getFilename(path)); 
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnOpen.setFont(new Font("Yu Gothic UI", btnOpen.getFont().getStyle(), btnOpen.getFont().getSize()));
		btnOpen.setForeground(Color.WHITE);
		btnOpen.setBackground(Color.BLACK);
		btnOpen.setBounds(172, 128, 95, 31);
		panel.add(btnOpen);
		
		JLabel lblSelectAVideo = new JLabel("Select A Video/ Audio");
		lblSelectAVideo.setBackground(Color.BLACK);
		lblSelectAVideo.setForeground(Color.WHITE);
		lblSelectAVideo.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblSelectAVideo.setBounds(49, 34, 179, 14);
		panel.add(lblSelectAVideo);
		
		
		label.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.DARK_GRAY);
		label.setBounds(49, 71, 272, 31);
		panel.add(label);
		
		final DefaultListModel fruitsName = new DefaultListModel();

	      fruitsName.addElement("Living Room TV");
	      fruitsName.addElement("Bedroom TV");
	      fruitsName.addElement("Android TV");
	      
		JList list = new JList(fruitsName);
		list.setSelectionForeground(Color.WHITE);
		list.setSelectionBackground(Color.BLACK);
		list.setBorder(new LineBorder(Color.GRAY));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 13));
		list.setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		list.setBounds(64, 107, 301, 114);
		frame.getContentPane().add(list);
		
		JLabel lblChromecastsTvs = new JLabel("Chromecasts/ TVs:");
		lblChromecastsTvs.setBackground(Color.DARK_GRAY);
		lblChromecastsTvs.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblChromecastsTvs.setForeground(Color.WHITE);
		lblChromecastsTvs.setBounds(43, 69, 154, 27);
		frame.getContentPane().add(lblChromecastsTvs);
		
		JLabel lblStreamx = new JLabel("StreamX");
		lblStreamx.setBackground(Color.DARK_GRAY);
		lblStreamx.setForeground(Color.WHITE);
		lblStreamx.setFont(new Font("Yu Gothic UI", Font.BOLD, 22));
		lblStreamx.setBounds(21, 28, 161, 30);
		frame.getContentPane().add(lblStreamx);
		
		JLabel label_close = new JLabel("X");
		label_close.setBackground(Color.DARK_GRAY);
		label_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		label_close.setForeground(Color.WHITE);
		label_close.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		label_close.setBounds(431, 0, 21, 27);
		frame.getContentPane().add(label_close);
		
		JButton btnNewButton = new JButton("StreamX");
		
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		btnNewButton.setBounds(134, 515, 174, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Select");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(276, 232, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setBounds(100, 100, 452, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private String getFilename(String path) {
	String filename = "";
	for(int i=path.lastIndexOf("\\")+1;i<path.length();i++)
		filename+=path.charAt(i);
	return filename;
	}
	
}
