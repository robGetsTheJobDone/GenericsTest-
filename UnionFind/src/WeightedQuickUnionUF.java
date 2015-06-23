/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bpb
 */
public class WeightedQuickUnionUF extends UnionFind{
int[] sz;
    public WeightedQuickUnionUF(int N){
   super(N);
   
    
    sz = new int[N];
   for(int i = 0 ; i < N; i++){
    id[i] = i;
    sz[i] = 1;  // changed to 1 so it indicates the number of nodes for this 'root'
}
}
    @Override
   public int find(int p){
    while(p != id[p])
        p = id[p];
    return p;
}

    @Override
    public void union(int p, int q){
    int i = find(p);
    int j = find(q);
    if(i == j) return;

    if(sz[i] < sz[j]){id[i] = j; sz[j] += sz[i];}
    else             {id[j] = i; sz[i] += sz[j];}
    count--;
}
    
}
