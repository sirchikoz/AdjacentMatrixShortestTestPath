
package adjacentmatrixshorttestpath;

import java.util.Arrays;

/**
 *This is an implementation of the Dijkstra's algorithm for the shortest path
 * @author sirch
 */
public class Dijkstra {
     private final int[][] graph;
     private final int[] predecessorSubGraph;
     private final int[] distanceEstimates;
     private final int[][] estimatesReference;
     private int source = -1;
    public Dijkstra(int[][] graph, int source){
         this.graph=new int[graph.length][graph[0].length];
         for(int i=0; i < graph.length;i++)
         {
             System.arraycopy(graph[i], 0, this.graph[i], 0, graph.length);
         }
         predecessorSubGraph = new int[graph.length];
         distanceEstimates = new int[graph.length];
         estimatesReference = new int[graph.length][2];
         this.source = source;
         initializeSingleSource();
    }
    public void initializeSingleSource()
     {
         for(int i=0; i < graph.length;i++)
         {
             distanceEstimates[i]= source == i ? 0 : Integer.MAX_VALUE;
             estimatesReference[i][0] = i;
             estimatesReference[i][1] = distanceEstimates[i];
             predecessorSubGraph[i]=Integer.MIN_VALUE;
         }
     }
    public void relax(int u, int v)
    {       
         if( distanceEstimates[v]> (distanceEstimates[u] +graph[u][v])){
            // System.out.println(u+"-------->|||||<---------------"+v);
             distanceEstimates[v] = distanceEstimates[u] +graph[u][v];
             estimatesReference[v][1] = distanceEstimates[v];
             predecessorSubGraph[v] = u;
         }
     }
    public void run(){
        while(true)
        {
            Arrays.sort(estimatesReference,(int[]a, int[]b)->(Integer.valueOf(a[1]).compareTo(b[1])));
            int vertex = estimatesReference[0][0];//get the top most array from the two dimensional. The first column is the vertex index and the second column is the estimated distance
            if(estimatesReference[0][1]==Integer.MAX_VALUE)
                break;// all the vertices have been relaxed.                         
            int[] adjacents = graph[vertex];
            for(int vert=0; vert<adjacents.length;vert++){
               //System.out.println(vertex+" ******* "+vert);
                if(adjacents[vert] > 0)
                relax(vertex,vert);}
             estimatesReference[0][1] = Integer.MAX_VALUE;
             
        }
    }
         public void print(int vertex){

         if(vertex>=0 && vertex<predecessorSubGraph.length )
         {
                 print(predecessorSubGraph[vertex]);
                 System.out.print(" "+vertex);
          }
         //else if( vertex>=graph.length)
        // System.out.println("No path exists.......................... ");
     }
}
