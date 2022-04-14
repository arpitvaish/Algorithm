class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        
        //for(int i = 0; i < matrix.length; i++)matrix[i][i] = 0;
        
        for(int i = 0; i < matrix.length; i++){
            
            for(int j = 0; j < matrix.length; j++){
                
                
                for(int k = 0; k < matrix.length; k++){
                    
                    if(j == i || k == i || matrix[j][i] == -1 || matrix[i][k] == -1)continue;
                    if(matrix[j][k] == -1)matrix[j][k]=Integer.MAX_VALUE;
                    
                    matrix[j][k] = Math.min(matrix[j][k], matrix[j][i]+matrix[i][k]);
                }
            }
        }
    }
}
