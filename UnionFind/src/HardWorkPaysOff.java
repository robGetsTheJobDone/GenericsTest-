/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bpb
 */

 import java.awt.*;
 import java.awt.event.*;
import java.util.ArrayList;

 public class HardWorkPaysOff extends Frame {
    static  ArrayList<int []> AG = new ArrayList<int[]>();   
     static  ArrayList<int []> MazeStart = new ArrayList<int[]>(); 
    
 static int Square;
  
   public static void main(String args[]) {
          MazeNoBorders Love = new MazeNoBorders(1024); 
      Square = 10;
          AG = Love.PacUpForGraphics();
          MazeStart = Love.SonOfAgun();
         
   
       new HardWorkPaysOff();
       
   }
 

   public HardWorkPaysOff() {
  
       
     super("DONT WAST YOUR OPPERTUNITY SON");
 
     //Set the size for the frame.
     setSize(1000,600);
    


     setVisible(true);

   
    addWindowListener(new WindowAdapter()
       {public void windowClosing(WindowEvent e)
          {dispose(); System.exit(0);}
      }
     );
   }


   public void paint(Graphics g) {
    
     g.setColor(Color.BLACK);
      
       Graphics2D g2d = (Graphics2D)g;

 for(int x = 0; x < MazeStart.size(); x = x +2){
     int [] box = MazeStart.get(x);
     int [] box2 = MazeStart.get(x+1);
     int x1;
     int y1;
     
     x1 = box[0] * 50 ;
     y1 = box[1] * 50;
    int x2 = box2[0] * 50;
   int  y2 = box2[1] * 50; 
 // g2d.drawLine(x1, y1, x2 +100, y2 );
 //  g2d.drawLine(y2, x1, y1 , x2 +100 );
 //  g2d.drawLine(x1, x1, y2, y2 );
  // g2d.drawLine(x1, y2, x1, y2+100);
 }

     
    g.setColor(Color.black);
    for(int x = 0; x < AG.size(); x = x +2){
     int [] box = AG.get(x);
     int [] box2 = AG.get(x+1);
     int x1;
     int y1;
     
     x1 = box[0] * 50 ;
     y1 = box[1] * 50;
    int x2 = box2[0] * 50;
   int  y2 = box2[1] * 50; 
 g2d.drawLine(x1, y1, x2, y2);
 }
 
    g2d.setColor(Color.blue);
  
   }
 }

