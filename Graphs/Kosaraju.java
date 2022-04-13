//Kosaraju => https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    Stack<Integer> stack = new Stack<>();
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //topological sort
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i])
                topologicalSort(adj, visited, i);
                
        }
        
        
        // reverse the graph
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i = 0; i < V; i++)revAdj.add(new ArrayList<Integer>());
        for(int i = 0; i < adj.size(); i++){
            
            for(int j : adj.get(i)){
                revAdj.get(j).add(i);
            }
        }
        
        //System.out.println(adj);
        //System.out.println(stack);
        
        //dfs and find the strongly connected components
        visited = new boolean[V];
        int counter = 0;
        while(!stack.isEmpty()){
            int n = stack.pop();
            if(!visited[n]){
                counter+=1;
                //System.out.print("SCC: "); 
                countStrongConnected(revAdj, visited, n);
                //System.out.println(); 
            }
        }
        return counter;
        
    }
    
    public void topologicalSort(ArrayList<ArrayList<Integer>> adj, boolean visited[], int node){
        
        if(visited[node])return;
        
        visited[node] = true;
        for(int n : adj.get(node)){
            topologicalSort(adj, visited, n);
        }
        
        
        stack.push(node);
        
        
        
    }
    
    public void countStrongConnected(ArrayList<ArrayList<Integer>> revAdj, boolean[] visited, int node){
        
        if(visited[node])return;
        visited[node] = true;
        //System.out.print(node + " "); 
        //System.out.println("neigh : " + revAdj.get(node).size()); 
        for(int n : revAdj.get(node)){
            countStrongConnected(revAdj, visited, n);
        }
        
    }
}
