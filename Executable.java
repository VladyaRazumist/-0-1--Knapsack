/**
 * @author nicolas et hadrien
 */
public class Executable {


    /**
     * An example of how to use the program.
     * It is up to you to create your own tests for the various instances.
     * @param args
     */
    public static void main(String[] args) {
        KnapsackData example = new KnapsackData(new int[]{6,3,2,2},new double[]{30,14,16,9},10);
        
        long time = System.currentTimeMillis();
        DPSolver solver = new DPSolver(example);
        solver.Solve();
        solver.PrintSolution();
        time = (System.currentTimeMillis()-time);

        System.out.println(String.format("OPT: %.3f CPUTime: %.3f s", solver.OptVal(),  (time/1000d)));
    }
}