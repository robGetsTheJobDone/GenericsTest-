/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bpb
 */
public  abstract class UnionFind {
    public int []id;
    public int count; 
    public UnionFind(int n){
        count = n; 
        id = new int[n];
        for (int i = 0; i < n; i++ ){
            id[i] = i; 
        }
    }
    public   int count(){
        return count;
    }
    public  boolean connected(int p, int q){
        boolean  Temp =  find(p) == find(q);
        return Temp;
    }
 

    public abstract int find(int p);
    public abstract void union (int p, int q);
    
          
    
}
