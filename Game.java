package wallball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel
{

    Ball ball = new Ball(this);
    Paddle paddle = new Paddle(this);
    double speed = 1, paddleSpeed = 5;


    public Game()
    {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {
            }

            @Override
            public void keyReleased(KeyEvent e)
            {
                paddle.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e)
            {
                paddle.keyPressed(e);
            }
        });
        setFocusable(true);

    }

    private void move()
    {
        ball.move();
        paddle.move();
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.MAGENTA);
        ball.paint(g2d);
        g2d.setColor(Color.BLUE);
        paddle.paint(g2d);

    }

    public void gameOver()
    {

    }

    public static void main(String[] args) throws InterruptedException
    {
        JFrame frame = new JFrame("Wall Ball");
        Game wallBall = new Game();
        frame.add(wallBall);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            wallBall.move();
            wallBall.repaint();
            Thread.sleep(10);
        }
    }
}
