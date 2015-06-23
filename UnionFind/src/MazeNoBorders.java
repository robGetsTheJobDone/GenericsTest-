
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
public class MazeNoBorders  extends quickUnion{
 int[][] Maze;
 String[][] PacMan;
 int[] xy;

    int Length;
    int Start;
    int End;
  ArrayList Answers4Graph = new ArrayList<int[]>(); 
  ArrayList MazeStart = new ArrayList<int[]>(); 
   
    
    public MazeNoBorders(int n) {
        super(n);
     this.Length = (int) Math.sqrt(n);

        //  System.out.println(x);
     

        int SetUpMaze2D = 0;
        for (int xx = 0; xx < Length; xx++) {

            for (int yy = 0; yy < Length; yy++) {
                Maze[yy][xx] = SetUpMaze2D;
               // PacMan[yy][xx] = "WALL";

                SetUpMaze2D++;
            }
            
        }
        int min = 0;
      
        Start = 1 + (int) (Math.random() * Length-1);
       End = id.length - Length +1   + (int) (Math.random() * Length-1);
      System.out.println(Start + "   " + End);
    }
 
    public void UpDateVisualRep() {
        int z = 0;
        for (int y = 0; y < Length; y++) {
            System.out.println();

            for (int x = 0; x < Length; x++) {
                Maze[x][y] = id[z];
                z++;
            }
        }
    }

    public void Print2D() {

        for (int y = 0; y < Length; y++) {
            System.out.println();

            for (int x = 0; x < Length; x++) {
                System.out.print(Maze[x][y] + " ");
            }
        }

    }

    public void Print1D() {
        int counter = 0;

        for (int w = 0; w < id.length; w++) {

            System.out.println(id[w]);
            counter++;
        }

    }
 
 public int Seed(){
     return  0 +(int) (Math.random()*id.length);
 }
 public boolean IsGoRightSafe(int s){
     boolean c = true;
     
     for(int i = 1; i < Length; i++){
         if ((i* (Length) -1 == s)){
            c = false; 
         }
     }
     if(s <= 0 || s > id.length  - Length -1 ){
         c = false;
     }
     return c;
 }
 public boolean IsGoLeftSafe(int s){
boolean c = true; 
for(int i = 1; i < Length +1; i++){
         if ((i* (Length)  == s)){
            c = false; 
         }
     }
 if(s <= 0){
         c = false;
     }
  if(s <= Length  || s > id.length - Length -1  ){
         c = false;
     }
    return c; 
 }
 public boolean IsGoDownSafe(int s){
     
     boolean c = true; 
for(int i = 1; i < Length +1; i++){
         if ((i* (Length)  == s) ||( (i*(Length) -1 ) == s)){
            c = false; 
         }
     }
if(s > Length*Length -Length){
    c= false;
}
 if(s <= 0){
         c = false;
     }
 if (s == Start){
     c = true;
 }
    return c; 
 }
 public boolean IsGoUpSafe(int s){
     boolean c = true;
    for(int i = 1; i < Length +1 ; i++){
         if ((i* (Length)  == s) ||( (i*(Length) -1 ) == s)){
            c = false; 
         }
     }
    if (s < Length){
        c = false;
    }
     if(s <= 0){
         c = false;
     }
      if (s == End){
     c = true;
 }
    return c; 
 } 
 
 
public void Test (){
  
       
        int s = Pick();
       MoveLogic(s);
        
    
}

public ArrayList SonOfAgun(){
    for (int x = 0; x < id.length; x ++){
        PullXForMazeStart(x);
    }
    return MazeStart;
}
  public void PullXForMazeStart(int s ){
     int countx = 0; 
     for (int x = 0; x < Length; x++){
         
        for (int y =0; y < Length; y++){
           int temp = Maze[x][y]; 
            if (s == temp){
                System.out.println(  "x   " + x + " y    "  + y);
//                PacMan[x][y] = "SPACE";
                int[] u = new int[2]; 
                u[0] =x;
                u[1] =y;
                
                
             MazeStart.add(u);
            }
            countx ++;
            
         
     }
        countx++;
    
     
 }
 }
 
 
 public void PullX(int s ){
    int countx = 0; 
     for (int x = 0; x < Length; x++){
         
        for (int y =0; y < Length; y++){
           int temp = Maze[x][y]; 
            if (s == temp){
                System.out.println(  "x   " + x + " y    "  + y);
//                PacMan[x][y] = "SPACE";
                int[] u = new int[2]; 
                u[0] =x;
                u[1] =y;
                
                
             Answers4Graph.add(u);
            }
            countx ++;
            
         
     }
        countx++;
    
     
 }
 }
 public int Pick(){
    int XorY = 0 +  (int) (Math.random() *4 );
  
    
    return XorY; 
    
    
 }
 public void MoveLogic(int s){
     int seed = Seed();
     
     switch (s){
         case 0:{
            //go right
             if(IsGoRightSafe(seed) == true){
                 if(IsConnected(seed,seed+1) == false){
                     System.out.println("Going Right with " + seed + "  " + (seed+1));
                     NewUnion(seed, seed+1);
                     break;
                 }
             }
             
         }
         case 1:{
             // go left
             if(IsGoLeftSafe(seed) == true){
                
                 if(IsConnected(seed,seed-1) == false){
                       System.out.println("Going Left with " + seed + "  " + (seed - 1));
                     NewUnion(seed, seed-1);
                     break;
                     
                 }
             } 
         }
         case 2:{
            if(IsGoUpSafe(seed) == true){
                //going up
                 if(IsConnected(seed,seed-Length) == false){
                      System.out.println("Going Up with " + seed + "  " + (seed - Length));
                     NewUnion(seed, seed-Length);
                     break;
                     
                 }
             } 
         }
         
         case 3:{
            if(IsGoDownSafe(seed) == true){
                 if(IsConnected(seed,seed+Length) == false){
                        System.out.println("Going Down with " + seed + "  " + (seed  + Length));
                     NewUnion(seed, seed+Length);
                     break;
                     
                     
                 }
             } 
             
         }
     }
         
 }

 public ArrayList PacUpForGraphics(){
     while (count > 4 ){
          int s = Pick();
         MoveLogic(s);
     }
     return Answers4Graph;
 }

    public void NewUnion(int p, int q) {
        super.union(p, q);
        PullX(p);
        PullX(q);
        
    }

    public int Find(int p) {
        return super.find(p);
    }

    public boolean IsConnected(int p, int q) {
        return super.connected(p, q);
    }

}

