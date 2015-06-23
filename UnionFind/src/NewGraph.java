
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bpb
 */
public class NewGraph extends Frame {

    ArrayList Answers4Graph = new ArrayList<SmartMazeo.XY>();
    ArrayList MazeStart = new ArrayList<SmartMazeo.XY>();
    SmartMazeo Floop;
    boolean update = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new NewGraph();

    }

    public NewGraph() {
        super("DONT WAST YOUR OPPERTUNITY SON");
        setSize(1500, 1000);
        setVisible(true);
        ;

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        }
        );

    }

    public void paint(Graphics g) {
        boolean SolidMaze = false;
        int[] q1;
        int[] p1;
        int add = 100;
        int modx;
        int s = 3;
        modx = s;
        while (SolidMaze == false) {
            Floop = new SmartMazeo(200 * 200);
            Floop.SeprateBreakAble();
            Floop.Num();

            Floop.BreakThemAll();
            MazeStart = Floop.SetUpMaze();
            if (Floop.connected(Floop.Start, Floop.End)) {
                SolidMaze = true;
            }
        }
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.black);
        int xx = 20;
        g2d.drawLine(0, 0 + add, Floop.Length * modx - Floop.Length, 0 + add);
        g2d.drawLine(0, Floop.size * modx + add, Floop.Length * modx - Floop.Length, Floop.size * modx + add);

        for (int t = 0; t < MazeStart.size(); t++) {
            SmartMazeo.XY d = (SmartMazeo.XY) MazeStart.get(t);
            p1 = d.p1;
            q1 = d.q1;

//System.out.println("Point p x :" + p1[0] + " Y " + p1[1] );
//System.out.println("Point q x :" + q1[0] + " Y " + q1[1] );
            g2d.drawLine(p1[0] * modx, p1[1] * s + add, q1[0] * modx, q1[1] * s + add);
// art g.drawOval(p1[0]*s+add,p1[0]*+add, q1[0]*s+add, q1[1]*s+add);
// g.drawOval(q1[0] *modx  +add, q1[1] *modx , p1[0], p1[1] );

        }
        for (int x = 0; x < Floop.BrokenWalls.size(); x++) {

            g.setColor(Color.white);
            SmartMazeo.XY d = Floop.BrokenWalls.get(x);

            p1 = d.p1;
            q1 = d.q1;

//System.out.println("Point p x :" + p1[0] + " Y " + p1[1] );
//System.out.println("Point q x :" + q1[0] + " Y " + q1[1] );
            g2d.drawLine(p1[0] * modx, p1[1] * s + add, q1[0] * modx, q1[1] * s + add);
//g.drawRect(p1[0] *modx , p1[1]*modx , q1[0]*modx , q1[1]*modx );
//g.drawLine(q1[0] *modx  +add, q1[1] *modx , p1[0], p1[1] );
//add = add + add;
        }
        System.out.println(Floop.connected(Floop.Start, Floop.End));
        update = true;
    }

}
