package extras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class TetrisGame extends JPanel implements ActionListener {

    private final int GRID_WIDTH = 10;
    private final int GRID_HEIGHT = 20;
    private final int BLOCK_SIZE = 30;

    private Timer timer;
    private boolean[][] grid = new boolean[GRID_HEIGHT][GRID_WIDTH];

    private int currentX = 4, currentY = 0;
    private int[][] currentPiece;

    private Random random = new Random();

    public TetrisGame() {
        setPreferredSize(new Dimension(GRID_WIDTH * BLOCK_SIZE, GRID_HEIGHT * BLOCK_SIZE));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new TetrisKeyAdapter());

        spawnNewPiece();

        timer = new Timer(500, this);
        timer.start();
    }

    private void spawnNewPiece() {
        currentPiece = new int[][]{{0, 0}, {1, 0}, {0, 1}, {1, 1}}; // квадрат (O-пьеса)
        currentX = 4;
        currentY = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисуем игровое поле
        for (int row = 0; row < GRID_HEIGHT; row++) {
            for (int col = 0; col < GRID_WIDTH; col++) {
                if (grid[row][col]) {
                    g.setColor(Color.BLUE);
                    g.fillRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(col * BLOCK_SIZE, row * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        // Рисуем текущую фигуру
        g.setColor(Color.RED);
        for (int[] block : currentPiece) {
            int x = (currentX + block[0]) * BLOCK_SIZE;
            int y = (currentY + block[1]) * BLOCK_SIZE;
            g.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
            g.setColor(Color.RED);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (canMove(currentX, currentY + 1)) {
            currentY++;
        } else {
            // фиксируем фигуру
            for (int[] block : currentPiece) {
                int x = currentX + block[0];
                int y = currentY + block[1];
                if (y >= 0 && y < GRID_HEIGHT && x >= 0 && x < GRID_WIDTH) {
                    grid[y][x] = true;
                }
            }
            clearFullRows();
            spawnNewPiece();
            if (!canMove(currentX, currentY)) {
                timer.stop();
                JOptionPane.showMessageDialog(this, "Game Over!");
            }
        }
        repaint();
    }

    private boolean canMove(int newX, int newY) {
        for (int[] block : currentPiece) {
            int x = newX + block[0];
            int y = newY + block[1];

            if (x < 0 || x >= GRID_WIDTH || y >= GRID_HEIGHT || (y >= 0 && grid[y][x])) {
                return false;
            }
        }
        return true;
    }

    private void clearFullRows() {
        for (int row = GRID_HEIGHT - 1; row >= 0; row--) {
            boolean full = true;
            for (int col = 0; col < GRID_WIDTH; col++) {
                if (!grid[row][col]) {
                    full = false;
                    break;
                }
            }

            if (full) {
                for (int y = row; y > 0; y--) {
                    System.arraycopy(grid[y - 1], 0, grid[y], 0, GRID_WIDTH);
                }
                for (int col = 0; col < GRID_WIDTH; col++) {
                    grid[0][col] = false;
                }
                row++; // проверяем снова текущую строку
            }
        }
    }

    private class TetrisKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT && canMove(currentX - 1, currentY)) {
                currentX--;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && canMove(currentX + 1, currentY)) {
                currentX++;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && canMove(currentX, currentY + 1)) {
                currentY++;
            }
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Tetris Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TetrisGame());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
