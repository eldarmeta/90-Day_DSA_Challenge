public class ChessBoard {

    public static void main(String[] args) {
        String[][] board = new String[8][8];

        // Расставляем фигуры
        initializeBoard(board);

        // Выводим шахматную доску
        printBoard(board);
    }

    public static void initializeBoard(String[][] board) {
        // Расставляем фигуры черных
        board[0][0] = "♜"; board[0][1] = "♞"; board[0][2] = "♝"; board[0][3] = "♛";
        board[0][4] = "♚"; board[0][5] = "♝"; board[0][6] = "♞"; board[0][7] = "♜";
        for (int i = 0; i < 8; i++) {
            board[1][i] = "♟";
        }

        // Пустые клетки
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " ";
            }
        }

        // Расставляем фигуры белых
        board[7][0] = "♖"; board[7][1] = "♘"; board[7][2] = "♗"; board[7][3] = "♕";
        board[7][4] = "♔"; board[7][5] = "♗"; board[7][6] = "♘"; board[7][7] = "♖";
        for (int i = 0; i < 8; i++) {
            board[6][i] = "♙";
        }
    }

    public static void printBoard(String[][] board) {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println((8 - i));
        }
        System.out.println("  a b c d e f g h");
    }
}
