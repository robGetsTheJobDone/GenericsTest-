
public class MazeStart extends UnionFindQuick {

    int[][] Maze;
    int Length;
    int Start  = 2;
    int End = 15;

    public MazeStart(int n) {
        super(n);
        this.Length = (int) Math.sqrt(n);

        //  System.out.println(x);
        Maze = new int[n][n];

        int SetUpMaze2D = 0;
        for (int xx = 0; xx < Length; xx++) {

            for (int yy = 0; yy < Length; yy++) {
                Maze[yy][xx] = SetUpMaze2D;

                SetUpMaze2D++;
            }
            
        }
        int min = 0;
      
        Start = 1 + (int) (Math.random() * Length-1);
       End = id.length - Length + 2  + (int) (Math.random() * Length-1);
      System.out.println(Start + "   " + End);
       
      
        
    }

    public int TestRandom() {
        int min = 0;

        int max = id.length;
        int Choice = min + (int) (Math.random() * max);
        return Choice;

    }

    public boolean SafePick(int n) {
       
        
        
        
        int nn = n;
        boolean safe = true;

       
            if (nn == 0) {
                safe = false;
            } else {

                for (int x = 0; x < Length; x++) {
                    // check (nn > (Length * Length - Length) & nn < Length * Length))
                    if (nn == Length * x - 1 || nn == Length * x) {

                        safe = false;
                    }

                }
            }
        
        if (n < 0 || n +1 >  id.length){
            safe = false;
        }
     

        return safe;
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

    public void GamePad() {
        // n- length up
        // n + length up
        // n - 1 left 
        // n + 1 right 
        int min = 0;
        int max = 9;
       
        int Pick;
        final int Seed = min +(int) (Math.random()*id.length);
        Pick = Seed;
        
        
        int XorY = min + (int) (Math.random() * max);
        int MoveChoice = min + (int) (Math.random() * max);
        boolean Move = false;  
        boolean Moved = false;
        // if true move n+1 or n- length else mover n-1 or n + length;
        // first if picks movment on x 
        // else picks movment on y 

        if (MoveChoice > 4) {
            Move = true;
        }
        
        
        
        if (XorY > 4) {
            // movement on x 
            if (Move == true){ 
                 int temp = (1+ Seed); 
                if (SafePick(temp) == true){
              System.out.println("Going Right");
              Pick = temp;
                }
            }
        
        
            
            
            else if (SafePick(Pick-1) == true) {
                //going left
                System.out.println("Going Left");
                int temp = Pick -1;
                Pick = temp;
            }
        }

         
        else  {
            //movmement on Y 
            if (Move == true && SafePick(Pick - Length) == true){
               //going up
                Pick = Pick - Length; 
                System.out.println("Going Up");
            }
            else if (SafePick(Pick+Length) == true) {
                // going down
                 Pick = Pick + Length; 
                 System.out.println("Going Down");
                
            }
        }
        
         
        if(Seed != Pick && IsConnected(Seed,Pick) == false  ){
            NewUnion(Seed,Pick);   
            System.out.println("Seed of " + Seed + " Pick of " +  Pick);
            
           
        }
        
        
        
      //  if (SafePick(answer) == true && (SafePick(Pick)) == true){
        //    super.connected(answer, Pick);
        //}
        
      

    }

    public void NewUnion(int p, int q) {
        super.union(p, q);
    }

    public int Find(int p) {
        return super.find(p);
    }

    public boolean IsConnected(int p, int q) {
        return super.connected(p, q);
    }
}
