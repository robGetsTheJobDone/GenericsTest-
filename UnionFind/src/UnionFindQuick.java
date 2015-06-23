/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bpb
 */
public class UnionFindQuick extends UnionFind{
    public UnionFindQuick(int n){
        super(n);
        
    }

    @Override
    public int find(int p) {
      return id[p];
    }

    @Override
    public void union(int p, int q) {
      int pID = p; 
      int qID = q;
      if (!(pID == qID)){
          for (int i = 0; i < id.length; i++){
              if (id[i] == pID){
                  id[i] = qID;
                  count--;
              }
          }
      }
    }
    @Override
    public  boolean connected(int p, int q){
        boolean  Temp =  find(p) == find(q);
        return Temp;
    }
}
