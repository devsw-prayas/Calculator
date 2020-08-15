package com.calculator.ui;

import com.calculator.annotation.Core;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * The UI class that manages all UI interfacing and multi-threading implementation
 * The thread classes are not implemented here , but gets called through the UI.
 * It is marked as {@code Core} so that only core engine components can use its variables and use it.
 * 
 * @author devsw
 * @see Core
 */
@com.calculator.annotation.Core
public class UI extends javax.swing.JFrame implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3265067527169495517L;
	protected final javax.swing.JPanel contentPane;
	private int pX , pY;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			try {
				UI frame = new UI ();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new javax.swing.JPanel();
		contentPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent me) {
                // Get x,y and store them
                pX = me.getX();
                pY = me.getY();

            }
            public void mouseDragged(java.awt.event.MouseEvent me) {

               setLocation(getLocation().x + me.getX() - pX,
                        getLocation().y + me.getY() - pY);
            }
        });
        contentPane.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent me) {

               setLocation(getLocation().x + me.getX() - pX,
                        getLocation().y + me.getY() - pY);
            }
        });
		contentPane.setBackground(java.awt.Color.WHITE);
		contentPane.setBorder(new javax.swing.border.EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		javax.swing.JLabel close = new javax.swing.JLabel("X");
		close.setToolTipText("Close");
		close.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				System.exit(0);
			}
		});
		close.setForeground(java.awt.Color.RED);
		close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		close.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
		close.setBounds(772, 0, 28, 31);
		contentPane.add(close);
		
		javax.swing.JLabel minimize = new javax.swing.JLabel("_");
		minimize.setToolTipText("Minimize");
		minimize.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				setState(ICONIFIED);
			}
		});
		minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		minimize.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 18));
		minimize.setBounds(747, 0, 28, 31);
		contentPane.add(minimize);
		
		javax.swing.JPanel buttonPanel = new javax.swing.JPanel();
		buttonPanel.setBounds(144, 150, 650, 450);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
		javax.swing.JLabel output = new javax.swing.JLabel("0");
		output.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		output.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 30));
		output.setBounds(10, 74, 780, 56);
		contentPane.add(output);
		
		javax.swing.JPanel panel = new javax.swing.JPanel();
		panel.setBounds(0, 0, 150, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		setUndecorated(true);
	}
}
