/**
 * A class to implement the DynamicProgramming solver.
 * The attributes of this class (its state) are defined as the state of the DP algorithm.
 * So your dynamic programming solver can provide access afterwards to intermediate values in the table 
 * (e.g to provide the optimal value for other value of W without doing the complete computation again).
 * 
 * @author nicolas et hadrien, refactoring by a.melnikov
 */
  import static java.lang.Math.*;
public class DPSolver {

    /**
     * Reference to the data
     */
    private KnapsackData data;

    /**
     * Value of an optimal solution
     */
    private double optVal;

    /**
     * s[k][y]: the maximum value achievable with items 1..k and a capacity of y
     */
    private double[][] s;

    /**
     * toTake[k][y] = 1 if k-th item is in the optimal solution of subproblem and 0 otherwise.
     */
    private int[][] toTake;

    /**
     * Build a DPSolver
     * @param data
     */
    public DPSolver(KnapsackData data) {
        this.data = data;
    }

    /**
     * @return the optimal value
     */
    public double OptVal() {
        return optVal;
    }

    /**
     * Initialize the data structures needed for the DP
     */
    private void Init() {
        int numOfItems = data.NumOfItems();
        int capacity = data.Capacity();
        this.s = new double[numOfItems+1][capacity+1];
        this.toTake = new int[numOfItems+1][capacity+1];
    }

    /**
     * Solve the knapsack problem:
     */
    public double Solve() {
        Init();
        int numOfItems = data.NumOfItems();
        int capacity = data.Capacity();
       for (int i=0;i<numOfItems+1;i++)
       { s[i][0]=0;                }
          for (int i=0;i<capacity+1;i++)
          {s[0][i]=0     ;          }   
              
          
          
       
       

        
        for (int i=1;i<numOfItems+1;i++)
    {
        for (int j=1;j<capacity+1;j++)
         {
             Item I=data.GetItem(i-1);
            int w=I.Weight();
            double p=I.Value();
            if (j-w>=0) {
             s[i][j]=max(s[i-1][j],s[i-1][j-w]+p);  }
            if (j-w<0)
          {
               s[i][j]=s[i-1][j];
               
              
          }
             //System.out.println(String.format("%.0f",s[i][j]));
         }
         
    }
         optVal=s[numOfItems][capacity];
             
             
              for (int i=numOfItems;i>=1;i--)
    {
        for (int j=capacity;j>=1;j--)
         {
           if (s[i][j]==s[i-1][j])
              { toTake[i][j]=0; }
              else { toTake[i][j]=1; }
              
          }
        
        
    }
    
        return optVal;
    }
    /**
     * Print one optimal solution on the screen
     **/
    public void PrintSolution() {
        String solution = "Solution:\n";
        int yCur    = data.Capacity();
        for(int k=data.NumOfItems(); k>0; k--) {
            if (toTake[k][yCur] == 1) {
                solution += data.GetItem(k-1).ToString() + "\n";
                yCur -= data.GetItem(k-1).Weight();
            }
        }
        solution += "\n";
        System.out.println(solution);
    }

}
