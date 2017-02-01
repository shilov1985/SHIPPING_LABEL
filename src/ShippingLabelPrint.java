

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

import java.io.*;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
     
        
		public class ShippingLabelPrint extends JFrame  {
			
		    static Enumeration<?> portList = null;
		 
		    static String messageString = "Hello, world!\n";
		  
		    static OutputStream outputStream;
		    static String comPort = "COM4";
		    
		    private static final long serialVersionUID = 1L;
			JButton exit,print;
			
			
			 
			   JTextField userField,tileField,numberField;
			   
			    JLabel changesLabel,userLabel,tileLabel ,tabLabel,formatBroiki;
			    
			    static  String choseTab;
			    
			    ShippingLabelPrint () {
				 super ("Краен Етикет 'KSK'");
			 
				  setLayout(null);
					setSize(292,330);
					 setResizable(false);
					  setDefaultCloseOperation(EXIT_ON_CLOSE);
					  setLocationRelativeTo(null);
				
				     	 
					   
					    
				
					  print = new JButton("ПРИНТИРАЙ");
					  print.setBounds(10,245,170,45);
					  print.addActionListener(new Printing());				  
				       add(print);
					  exit = new JButton("ИЗХОД");
					    exit.setBounds(190,245,85,45);
					    exit. addActionListener(new Exit()); 
					    add(exit);
					
				     setVisible(true);
			          
			         userField = new JTextField();
				             add(userField);
				              userField.setEditable(true);
				              
				               userField.setBounds(95,40,100,50);
				               
				               userField.setBackground(Color.GREEN);
				               userField.setFont(new Font("SansSerif",Font.BOLD,18));
				               
				                userLabel = new JLabel("Въведи USER номер");
				                
				                 add(userLabel);
				                 
				                  userLabel.setBounds(82,0,275,50);
				            
				                
				                 
				             tileField = new JTextField();
				             add(tileField);
				              tileField.setEditable(true);
				               
				               tileField.setBounds(5,120,275,50);
				               
				               tileField.setBackground(Color.GREEN);
				              tileField.setFont(new Font("SansSerif",Font.BOLD,18));
				               
				               
				                tileLabel = new JLabel("Въведи TAILE  номер");
				                
				                 add(tileLabel);
				                  
				                  tileLabel.setBounds(82,85,275,50);
				                  
				              
				                  
				                  numberField = new JTextField();
				                  
				                  add(numberField);
				                  
				                   numberField.setEditable(true);
				                   
				                    numberField.setBounds(125,195,50,35);
				                    
				                    numberField.setFont(new Font("SansSerif",Font.BOLD,18));
				                    
				                     JLabel labelBroiki = new JLabel("В ъ в е д и                               б р о й к и .");
				                     
				                      add(labelBroiki);
				                      
				                        labelBroiki.setBounds(40,180,280,35);
				                        
				                        formatBroiki = new JLabel ("X X X");
				                        
				                         add(formatBroiki);
				                         formatBroiki.setBounds(134,175,290,25);
				                        
				              	}
			
			
	public class Exit  implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			System.exit(getDefaultCloseOperation());
				
			}
			
			
			
		}
		public class Printing  implements ActionListener{
			
			 Enumeration<?> portList = null;
			    CommPortIdentifier portId;
			   String messageString = "Hello, world!\n";
			 SerialPort serialPort;
			   OutputStream outputStream;
               
               
			
			

			public void actionPerformed(ActionEvent e) {
			
				
				
        String numberPCS  = numberField.getText();
				
			String tileNomer = tileField.getText();
			
			String user = userField.getText();
				
		
                 

	    	  
			String  kraen =
				
            "Na:PICA108/NNK"
        +"FCCN--r00------"
        +"FCDA--r0-------"
	    +"FCCL--r0007000-"
	    +"FCCM--r00300---"
        +"FCCHA-r1-------"
	    +"FCCHB-r705-----"
        +"FCSCA-r+210----"
	    +"FCSDA-r+110----"
        +"FCCD--r+000----"
	    +"FCCE--r+000----"
	    +"FCCG--r+150----"
	    +"FCAA--r010-----"
	    +"FCAB--r020-----"
	    +"FCDD--r0-------"
	    +"FCDC--r0-------"
	    +"FCCF--r+25-----"
	    +"FCDE--r0-------"
        +"FCDB--r00------"
	    +"FCDNA-r1-------"
	    +"FCDNB-r0-------"
	    +"FCDNC-r0002----"
	    +"A01068-001-13011------"    
	    +"C01106030"
	    +"B01B"+tileNomer+""
	    +"A02068-014-13011------"    
	    +"C02106030"
	    +"B02"+tileNomer+""
	    +"A03068-026-13011------"    
	    +"C03106030"
	    +"B03"+numberPCS+"" 
	    +"A04040-029-10401030201"
	    +"B04"+user+""  
	    +"A05040-034-10401030201"
	    +"B05SZ2 SEBN-BG"
	    +"A06020-030-10401030201"
	    +"B06PCS:"+numberPCS+"" 
	    +"A07061-038-10401070330"
	    +"B07"+tileNomer+""
        +"EE020070"
	    +"EA070001"
	    +"EL0000";

	        portList = CommPortIdentifier.getPortIdentifiers();

	        while (portList.hasMoreElements()) {
	            portId = (CommPortIdentifier) portList.nextElement();
	            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
	                 if (portId.getName().equals("COM4")) {
	                //if (portId.getName().equals("/dev/term/a")) {
	                	
	                    try {
	                        serialPort = (SerialPort)
	                        
	                       
	                            portId.open("SimpleWriteApp", 2000);
	                    } catch (PortInUseException a) {}
	                  
	                    try {
	                        outputStream = serialPort.getOutputStream();
	                    } catch (IOException a) {}
	                   
	                    try {
	                        serialPort.setSerialPortParams(9600,
	                            SerialPort.DATABITS_8,
	                            SerialPort.STOPBITS_2,
	                            SerialPort.PARITY_NONE);
	                    } catch (UnsupportedCommOperationException a) {}
	                    
	                    try {
	                    	 outputStream.write(kraen.getBytes());
	                        
	                    } catch (IOException a) {}
	                    System.out.println(serialPort);    
	                 
	                 
	                   
	                    serialPort.close();   
	                    
	                }
	                	 
	            
	                 
	            }
	        }
	    	 try {
				outputStream.close();
			
			} catch (IOException a) {
			
				a.printStackTrace();
			}
	     
	    
		
				
				   
			}
		}
		public static void main (String []args){
new  ShippingLabelPrint ();
		}

		
	}
		