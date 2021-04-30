package wallball;

import java.awt.Graphics2D;

public class Ball
{

    private static final int DIAMETER = 30;

    double x = 0;
    double y = 0;
    private Game wallBall;

    public Ball(Game wallBall)
    {
        this.wallBall = wallBall;
    }

    void move()
    {
        x = x + 1;
        y = y + 1;

    }


    public void paint(Graphics2D g)
    {
        g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
    }


}
