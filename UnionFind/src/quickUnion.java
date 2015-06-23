/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bpb
 */
public class quickUnion extends UnionFind{
    public quickUnion( int n){
        super(n);
    }

    @Override
    public int find(int p) {
       while(p !=id[p]){
           p = id[p];
       }
       return p;
    }

    @Override
    public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (!(i == j)){
        id[i] = j;
        count--;
    }
    }
    
}
