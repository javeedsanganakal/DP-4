//Approach - 2:  Botton Up approach
//Time Complexity : O(mn);
//Space Complexity : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        
        for(int i=0; i<m; i++){
            if(matrix[i][0] == '1') max = 1; 
        }
        
        for(int j=0; j<n; j++){
            if(matrix[0][j] == '1') max = 1; 
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i][j] == '1'){
                    int top = matrix[i-1][j]-'0';
                    int left = matrix[i][j-1]-'0';
                    int diagUp = matrix[i-1][j-1]-'0';
                    int curr = 1 + Math.min(top, Math.min(left, diagUp)); 
                    max = Math.max(max, curr);
                    matrix[i][j] = (char)(curr+'0'); //int to char
                }        
            }
        }
        return max*max;
    }
}



//Approach - 1:  Brute force -> Top Down approach.
//Time Complexity : O((mn)^2); Time Limit exceeded
//Space Complexity : O(1)

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    flag = true;
                    int k=1;
                    
                    while(i+k < m && j+k < n && flag){  
                        
                        //checking columns wise
                        for(int r=i+k; r>=i; r--){
                            if(matrix[r][j+k] == '0'){
                                flag = false;
                                break;
                            }
                        } 
                        
                        //checking row wise
                        for(int c=j+k; c>=j; c--){
                            if(matrix[i+k][c] == '0'){
                                flag = false;
                                break;
                            }
                        }   
                        if(flag){
                            k++;
                             System.out.println(k);
                        } 
                       
                    }

                    max = Math.max(max, k);
                    
                }
            }
        }
        return max*max;
    }
}
