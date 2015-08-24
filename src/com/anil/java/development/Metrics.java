/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.anil.java.development;

/**
 *
 * @author Anil Allewar
 */
public class Metrics {

    public Metrics(){
    }
    
    public int[][] multiplyMetrics(int[][] A, int[][] B){
        int[][] M = new int[A.length][B[0].length];

        int m = A.length;
        int n = A[0].length;
        int l = B[0].length;
        
        for (int i=0; i<m;i++){
            for (int j=0; j<l; j++){
                M[i][j]=0;
            }
        }
        
        for (int i=0; i<m;i++){
            for (int j=0; j<l; j++){
                for(int k=0; k<n;k++){
                    System.out.println("i: " + i + " : j: " + j+ " : k: " + k);
                    M[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
        
        for (int i=0; i<m;i++){
            for (int j=0; j<l; j++){
                System.out.println("The result element at[" + i + "][" + j +"] is: " + M[i][j]);
            }
        }
        return M;
    }
    
    public static void main(String[] args){
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] B = {{9,8,7},{6,5,4},{3,2,1}};
        
        Metrics metric = new Metrics();
        metric.multiplyMetrics(A, B);
    }
}

