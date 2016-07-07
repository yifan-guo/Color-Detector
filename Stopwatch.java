public class Stopwatch
{
    private long t;
    private double count;
    
    public Stopwatch()
    {
        t = System.currentTimeMillis(); 
        //count = 0;
    }
    
    public double ElapsedTime()
    {
        return (System.currentTimeMillis() - t) / 1000.0;
    }
    
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        
        double totalMath = 0.0;
        double totalNewton = 0.0;
        
        Stopwatch swMath = new Stopwatch();
        for (int i = 0; i < N; i++)
            totalMath += Math.sqrt(i);
        swMath.lap();
        
        for( int i = 0; i < N; i++)
            totalNewton += Newton.sqrt(i);
        swMath.lap();
        swMath.show();
    }
    public void reset()
    {
        t = System.currentTimeMillis();
    }
    public void lap()
    {
        double timeComputation = ElapsedTime();
        StdOut.printf("%8.6f\n", timeComputation);
        count += timeComputation;
        t = System.currentTimeMillis();
    }
    public void show()
    {
        StdOut.printf("total: %8.6f\n ", count);
    }
}