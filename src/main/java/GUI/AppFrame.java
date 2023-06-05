/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import comp_decomp.Decompressor;
import comp_decomp.compressor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author LEGION
 */
public class AppFrame implements ActionListener{
	
	JFrame frame;
	JButton compressButton;
	JButton decompressButton;
	JLabel background;
	
	AppFrame()
	{
		frame = new JFrame("Compressor and Decompressor");
		frame.setLayout(null);
		frame.setSize(695,490);
		frame.setVisible(true);
                frame.setLocationRelativeTo(null);
		
		ImageIcon img = new ImageIcon("C:\\Users\\LEGION\\OneDrive\\Documents\\NetBeansProjects\\CompressorDecompressor\\frame.jpg");
		
		background = new JLabel("", img, JLabel.CENTER);
		background.setBounds(0, 0, 695, 490);
		
		compressButton = new JButton("Select");
		compressButton.setBounds(80, 305, 100, 30);
		compressButton.setBackground(Color.gray);
		compressButton.setFont(new Font("Calibri",Font.ITALIC,20));
		compressButton.addActionListener(this);
		
		
		decompressButton = new JButton("Select");
		decompressButton.setBounds(480, 305, 100, 30);
		decompressButton.setBackground(Color.gray);
		decompressButton.setFont(new Font("Calibri",Font.ITALIC,20));
		decompressButton.addActionListener(this);
		
		frame.add(compressButton);
		frame.add(decompressButton);
		frame.add(background);

		frame.getContentPane().setBackground(Color.red);
	}    
    
    
    
    @Override
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==compressButton){
             JFileChooser filechooser= new JFileChooser();
             int responce= filechooser.showSaveDialog(null);
             if(responce==JFileChooser.APPROVE_OPTION){
                 File file= new File(filechooser.getSelectedFile().getAbsolutePath());
                 System.out.print(file);
                 try{
                    compressor.method(file);
                 }
                 catch(Exception ee){
                     JOptionPane.showMessageDialog(null, ee.toString()); 
                 }
             }
         }
         
         if(e.getSource()==decompressButton){
             JFileChooser filechooser= new JFileChooser();
             int responce= filechooser.showSaveDialog(null);
             if(responce==JFileChooser.APPROVE_OPTION){
                 File file= new File(filechooser.getSelectedFile().getAbsolutePath());
                 System.out.print(file);
                 try{
                    Decompressor.method(file);
                 }
                 catch(Exception ee){
                     JOptionPane.showMessageDialog(null, ee.toString()); 
                 }
             }
         }
    }
}
