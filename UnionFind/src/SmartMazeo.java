
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
public class SmartMazeo extends  WeightedQuickUnionUF {
int Length;
int Start = 1000;
int End = 10000;
int size;
public ArrayList<XY> BreakAbleWalls = new ArrayList<XY>();
public ArrayList<XY> BrokenWalls = new ArrayList<XY>();
public ArrayList<XY> AllWalls = new ArrayList<XY>();
 public int[][] Maze;


        
    public SmartMazeo(int n) {
        super(n);
       size = n;
       Length = (int) Math.sqrt(n);   
       Maze = new int[Length][Length];
        
        
        Start = 1 + (int) (Math.random() * Length-1);
       End = id.length - Length +1   + (int) (Math.random() * Length-1);
        
        
    }
    
    public void SeprateBreakAble(){
        for(int x = 0; x < size; x++){
            if(IsGoRightSafe(x) == true){
                BreakAbleWalls.add(new XY(x,x+1));
                
            }
            if(IsGoLeftSafe(x) == true){
                BreakAbleWalls.add(new XY(x,x-1));
                
            }
             if(IsGoUpSafe(x) == true){
                BreakAbleWalls.add(new XY(x,x-Length));
                
            }
              if(IsGoDownSafe(x) == true){
                BreakAbleWalls.add(new XY(x,x+Length));
                
            }
        }
    }
    
    
     public boolean IsGoRightSafe(int s){
     boolean c = true;
     
     for(int i = 1; i < Length; i++){
         if ((i* (Length) -1 == s)){
            c = false; 
         }
          if(i == 1 || i > Length*Length -Length){
                    if  ((i* (Length)  > s +1)){
            c = false; 
         }  
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
for(int i = 0; i < Length +1; i++){
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
 public void BreakThemAll(){
    
     
     while ( BreakAbleWalls.isEmpty() == false ){
     int min =0;
     int max = BreakAbleWalls.size();
   int Pick = min + (int)(Math.random()*max); 
  System.out.println("Pick  "   +Pick + "Set Size of " + BreakAbleWalls.size());
     int tryP = BreakAbleWalls.get(Pick).p;
     int tryQ = BreakAbleWalls.get(Pick).q;
     if(this.connected(tryP, tryQ) == false){
     System.out.println("connecting "    + tryP +  "  " + tryQ);
         this.union(tryP, tryQ);
         BrokenWalls.add(new XY(tryP,tryQ));
         System.out.println(count);
        BreakAbleWalls.remove(Pick);
        
     }
     else if (this.connected(tryP, tryQ) == true){
         BreakAbleWalls.remove(Pick);
         
     }
     //System.out.println("NUMBER OF COMPONETS " + this.count);
 }
  
 }
 public void PrintOutAllBreakAbleWalls(){
 for(int x =0; x < BreakAbleWalls.size(); x ++){
     System.out.println("p = : " + (BreakAbleWalls.get(x).p) + "q = : " + (BreakAbleWalls.get(x).q));
 }
 }
 public ArrayList<XY> SetUpMaze(){
 
  
     for (int x = 0; x < size; x ++){
   int temp;
   if(IsGoLeft(x) == true ){
       temp = x;
       AllWalls.add(new XY(x,temp-1));
   }
   //if(IsGoRight(x) == true ){
    temp = x;
   // AllWalls.add(new XY(x, (temp +1)));
  // }
   if(IsGoUp(x) == true ){
         temp = x;
         //good line
         AllWalls.add(new XY(x,temp-Length));
   }
   if(IsGoDown(x) == true ){
   // AllWalls.add(new XY(x+Length,x));
   
   }
    
    
}
     return AllWalls;
 }
 
 
public void Num(){       
 int SetUpMaze2D = 0;
        for (int xx = 0; xx < Length; xx++) {

            for (int yy = 0; yy < Length; yy++) {
                
       //         System.out.println("TRying to set up with " + xx + "   " + yy);
                Maze[xx][yy] = SetUpMaze2D;
               // PacMan[yy][xx] = "WALL";

                SetUpMaze2D++;
            }
            
        }
 }
      public boolean IsGoRight(int s){
     boolean c = true;
     
     for(int i = 1; i < Length; i++){
         if ((i* (Length) -1 == s)){
            c = false; 
         }
          
     }
     return c;
 }
 public boolean IsGoLeft(int s){
boolean c = true; 
for(int i = 1; i < Length +1; i++){
         if ((i* (Length)  == s)){
            c = false; 
         }
     }
if (s<1){
    c = false;
}

    return c; 
 }
 public boolean IsGoDown(int s){
     
     boolean c = true; 
for(int i = 0; i < Length +1; i++){
         if ((i* (Length)  == s) ||( (i*(Length) -1 ) == s)){
            c = false; 
         }
     }

    return c; 
 }
 public boolean IsGoUp(int s){
     boolean c = true;
    for(int i = 1; i < Length +1 ; i++){
         if ((i* (Length)  == s) ||( (i*(Length) -1 ) == s)){
            c = false; 
         }
    }
    return c; 
    
 }

     public int[] PullXY (int s ){
    int countx = 0; 
    int[] temp  = new int [2];
     for (int x = 0; x < Length; x++){
         
        for (int y =0; y < Length; y++){
         
            if (s == Maze[x][y]){
               temp[0] = x;
               temp[1] = y;
             //  System.out.println("MATCH s: " + s + " x  " + x + "y " +y );
               
            }
             countx++;
            
         
     }
     
    
     
 }
     return temp;
 }
 
 class XY {
    int p;

     int q;
     int[] xy = new int[2];
     int[]p1;
     int []q1;
     ArrayList<int[] > pp = new ArrayList<int[]>();  
      
       
       ArrayList<ArrayList> Pxy2Q;
     XY(int r1, int r2){
           q = r2;
            p = r1;
           
       p1 = PullXY(q);
         q1 = PullXY(p);
          
      
          
     
   
     }
     public  int[] point1(){
        return p1;
         
     }
    public int[] point2(){
        return q1;
    }

 int getQ(){
         
         return q; 
     }
    int  getP(){
         return p;

}
 }



}
 



   
