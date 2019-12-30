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
public class AdjacentMatrixShortTestPath {

    /**
     * @param args the command line arguments
     */
      
    public static void main(String[] args) {
        // TODO code application logic here
      int[][] vertices = new int[5][5];
      //graph contains vertices labeled s,t,x,y,z. In this case s=0,t=1 etc
      vertices[0][1]=6;
      vertices[0][3]=7;
      
      vertices[1][2]=5;
      vertices[1][3]=8;
      vertices[1][4]=-4;
      
      vertices[2][1]=-2;
      
      vertices[3][2]=-3;
      vertices[3][4]=9;
      
      vertices[4][2]=7;
      vertices[4][0]=2;
      
      BellmanFord ford = new BellmanFord(vertices,0);
      System.out.println("Result:"+ford.run());
      ford.print(2);
       System.out.println();
       int[][] graph2Vertices = new int[5][5];
       //graph contains vertices labeled s,t,x,y,z. In this case s=0,t=1 etc
       graph2Vertices[0][1]=10;
       graph2Vertices[0][3]=5;
       
       graph2Vertices[1][2]=1;
       graph2Vertices[1][3]=2;
       
       graph2Vertices[2][4]=4;
      
       graph2Vertices[3][1]=3;
       graph2Vertices[3][2]=9;
       graph2Vertices[3][4]=2;
       
       graph2Vertices[4][0]=7;
       graph2Vertices[4][2]=6;
       
      Dijkstra dij = new Dijkstra(graph2Vertices,0);
      dij.run();
      dij.print(4);
    }
    
}
