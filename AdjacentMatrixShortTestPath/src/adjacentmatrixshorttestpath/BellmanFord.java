/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacentmatrixshorttestpath;

/**
 *
 * @author sirch
 */
public class BellmanFord { 
     private final int[][] graph;
     private final int[][] predecessorSubGraph;
      private final int[][] distanceEstimates;
      private int source=-1;
     public BellmanFord(int[][] graph, int source)
     {        
         this.graph=new int[graph.length][graph[0].length];
         for(int i=0; i < graph.length;i++)
         {
             for(int j=0; j < graph.length; j++)
             {
                this.graph[i][j] = graph[i][j];                
             }
         }
         
         predecessorSubGraph=new int[graph.length][graph[0].length];
         distanceEstimates=new int[graph.length][graph[0].length];
         this.source = source;
         initializeSingleSource();
     }
     public void initializeSingleSource()
     {
         for(int i=0; i < graph.length;i++)
         {
             distanceEstimates[i][i]= source == i ? 0 : Integer.MAX_VALUE;
             predecessorSubGraph[i][i]=Integer.MIN_VALUE;
         }
     }
     public void relax(int u, int v){       
         if( distanceEstimates[v][v]> (distanceEstimates[u][u] +graph[u][v])){
             System.out.println(u+"-------->|||||<---------------"+v);
             distanceEstimates[v][v] = distanceEstimates[u][u] +graph[u][v];
             predecessorSubGraph[v][v] = u;
         }
     }
     public boolean run(){
         for(int b=1; b < graph.length;b++)
             for(int i=0; i < graph.length;i++)
             {
             for(int j=0; j < graph.length; j++)
             {
                if(i!=j && graph[i][j]!=0)
                 relax(i,j);
             }
             }
         
         for(int i=0; i < graph.length;i++)
         {
             for(int j=0; j < graph.length; j++)
             {
                 if( graph[i][j]!=0 &&distanceEstimates[j][j]> (distanceEstimates[i][i] +graph[i][j]))
                     return false;
             }
         }
         return true;
     }
     public void print(int vertex){

         if(vertex>=0 && vertex<graph.length )
         {
                 print(predecessorSubGraph[vertex][vertex]);
                 System.out.print(" "+vertex);
          }
         //else if( vertex>=graph.length)
        // System.out.println("No path exists.......................... ");
     }
}
