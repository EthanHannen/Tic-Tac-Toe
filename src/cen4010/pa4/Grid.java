package cen4010.pa4;

class Line
{
	public final Box box;
    public final String row;
    public final String col;
    public final String diag;
    public final String anti;

    public Line(Box b, String r, String c, String d, String a) 
    {
    	this.box = b;
        this.row = r;
        this.col = c;
        this.diag = d;
        this.anti = a;
    }
}

public class Grid
{
    private Box[][] boxes;
    public int markCount;
    private Box lastMark;
    
    public Grid(Config options)
    {
        boxes = new Box[options.m][options.n];
        markCount = 0;
    }
    
    public void addBox(int r, int c, Box b)
    {
        boxes[r][c] = b;
    }
    
    public void markBox(Box b, String t)
    {
        b.setText(t);
        lastMark = b;
    }
    
    public void markBox(int row, int col, String t)
    {
        boxes[row][col].setText(t);
        lastMark = boxes[row][col];
    }
    
    public Box getBox(int r, int c)
    {
        return boxes[r][c];
    }
    
    public int getMarkCount()
    {
        return markCount;
    }
    
    public int addMarkCount()
    {
        return ++markCount;
    }
    
    public Line getLines(Box b)
    {
    	String mark = "";
    	String diag = "";
    	String anti = "";
    	String row = "";
    	String col = "";
    	
    	int i = b == null ? lastMark.row : b.row;
    	int j = b == null ? lastMark.col : b.col;

        // Check rows and columns
        for (int k = 0; k < Game.options.n; k++)
        {
        	mark = boxes[i][k].getText();
            row += mark == "" ? "_" : mark;
        }

        for (int k = 0; k < Game.options.m; k++)
        {
        	mark = boxes[k][j].getText();
        	col += mark == "" ? "_" : mark;
        }
    	
		// Check diagonal - Walk left and up
        while (i > 0 && j > 0)
        {
            --i;
            --j;
        }
        
        while (i < Game.options.m && j < Game.options.n)
        {
        	mark = boxes[i++][j++].getText();
        	diag += mark == "" ? "_" : mark;
        }

        // Check Anti-diagonal - Walk left and down

        i = b == null ? lastMark.row : b.row;
    	j = b == null ? lastMark.col : b.col;

        while (i < Game.options.m - 1 && j > 0)
        {
            ++i;
            --j;
        }

        while (i >= 0 && j < Game.options.n)
        {
        	mark = boxes[i][j].getText();
        	anti += mark == "" ? "_" : mark;
        	--i;
        	++j;
        }

        return new Line(lastMark, row, col, diag, anti);
    }
}