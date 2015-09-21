public class ImageDetect implements DrawListener 
{
    private Draw draw = new Draw();   
    private Stopwatch time = new Stopwatch();
    private static int a, b, N, color;
    public int attempts = 0;
    public int score = 0;
    public boolean state = true;
    
    public static void main(String[] args)  
    {
        int N = 1;     
        int[][] count = new int[N][N];       
        new ImageDetect(count);            
    }
    public ImageDetect(int[][] count)     
    {
        N = count.length;            
        a = (int)(Math.random() * N);     
        b = (int)(Math.random() * N); 
        count[a][b] += 25;  
        //StdOut.printf("%d\t %d\n", a, b);          
        draw.setXscale(-1, N);       
        draw.setYscale(-1, N); 
        color = (int)(Math.random()*3); 
        for (int i = 0; i < N; i++)    
            for (int j = 0; j < N; j++)     
        {           
            if ( color == 0)
                draw.setPenColor(0, 0, 200 - count[i][j]);  
            else if (color == 1)
                draw.setPenColor(0, 200 - count[i][j], 0);
            else 
                draw.setPenColor(200 - count[i][j], 0, 0);
            draw.filledSquare(j, N-i-1, .4);         
        }
        time.reset();
        draw.addListener(this);    
    }

    public void repeat()
    {
        draw.clear(); 
        int[][] count = new int[N][N];   
        a = (int)(Math.random() * N);     
        b = (int)(Math.random() * N);    
        count[a][b] += 25; 
        //StdOut.printf("%d\t %d\n", a, b);                      
        draw.setXscale(-1, N);       
        draw.setYscale(-1, N);   
        color = (color + 1) % 3;
        for (int i = 0; i < N; i++)    
            for (int j = 0; j < N; j++)     
        {           
            if ( color == 0)
                draw.setPenColor(0, 0, 200 - count[i][j]);  
            else if (color == 1)
                draw.setPenColor(0, 200 - count[i][j], 0);
            else 
                draw.setPenColor(200 - count[i][j], 0, 0);
            draw.filledSquare(j, N-i-1, .4);         
        }
        time.reset();
    }
    public void Fn(double x, double y)   
    {
        if (x >= b - 0.4 && x <= b + 0.4 && y >= (N - a - 1) - 0.4 && y <= (N - a - 1) + 0.4)     
        {
            score++;
            attempts = 0;
            N += 1;                
            repeat(); 
        }
        else 
        {
            System.out.println("Nope");
            //time.reset();
        }
    }
    public void mousePressed (double x, double y)    
    {
        double duration = time.ElapsedTime();
        attempts++;
        if (duration > 10.0 || attempts >= 4)
        {
            if( state == true)
            {
                    System.out.println("Your score was " + score);
                    state = false;
                    return;
            }
            else
                return;
        }
        else
        {
            x = draw.mouseX();          
            y = draw.mouseY();          
            Fn(x, y);          
        }
        //StdOut.printf("%f\t %f\n", x, y);   
    }
    public void mouseDragged (double x, double y)   
    {}
    public void mouseReleased(double x, double y)     
    {}     
    public void keyTyped(char c)     
    {}
} 