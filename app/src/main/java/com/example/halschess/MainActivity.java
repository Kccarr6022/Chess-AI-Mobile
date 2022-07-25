package com.example.halschess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[][] board = new String[8][8]; // The surrounding contains nullptr/ empty memory


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        resetBoard(board);

    }




    public void resetBoard( String[][] board) {
        /* The board in this model will be 9 by 9 and will have pieces arranged correctly. */

        board =
                new String[][]{ // lowercase = black uppercase = white
                        {"c", "n", "b", "q", "k", "b", "n", "c"}, // 8
                        {"p", "p", "p", "p", "p", "p", "p", "p"}, // 7
                        {"0", "0", "0", "0", "0", "0", "0", "0"}, // 6
                        {"0", "0", "0", "0", "0", "0", "0", "0"}, // 5
                        {"0", "0", "0", "0", "0", "0", "0", "0"}, // 4
                        {"0", "0", "0", "0", "0", "0", "0", "0"}, // 3
                        {"P", "P", "P", "P", "P", "P", "P", "P"}, // 2
                        {"C", "N", "B", "Q", "K", "B", "N", "C"}  // 1
                }; //     A    B    C    D    E    F    G    H


    }

    public boolean move(String before, String after) { // Takes two (A-H)(1-8) strings
        int beforex = Character.toUpperCase(getCharFromString(before, 0)) - 'A';
        int beforey = getCharFromString(before, 1) - '1';
        int afterx = Character.toUpperCase(getCharFromString(after, 0)) - 'A';
        int aftery = getCharFromString(after, 1) - '1';
        char piece = getCharFromString(board[beforex][beforey], 0);

        // white
        if (Character.isUpperCase(piece)  &&
                (!Character.isUpperCase(getCharFromString(board[afterx][aftery], 0)))){

            // pawns
            if (board[beforex][beforey].equals("P")) {
                // forward
                for (int i = 0; i <= 2; i++) {
                    if (beforex == afterx && aftery == beforey + i
                            && board[beforex][beforey].equals("0")) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "P";
                        return true;
                    }
                }
                // diagonal take
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey + 1 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "P";
                    return true;
                }
            }

            // castles
            if (board[beforex][beforey].equals("C")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        return true;
                    }
                }
            }

            // knights
            if (board[beforex][beforey].equals("N")) {
                // forward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey + 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    return true;
                }
                // backward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    return true;
                }

                // right
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex + 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    return true;
                }
                // left
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex - 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    return true;
                }
            }

            // bishops

            // queens
            if (board[beforex][beforey].equals("Q")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        return true;
                    }
                }
            }

            // kings

            // nothing (out of bounds) <- buttons(unlikely)

        // black
        } else if (Character.isLowerCase(piece)  &&
                (!Character.isLowerCase(getCharFromString(board[afterx][aftery], 0)))){

            // pawns
            if (board[beforex][beforey].equals("p")) {
                // forward
                for (int i = 0; i <= 2; i--) {
                    if (Character.isLowerCase(getCharFromString(board[beforex][beforey + i], 0))) {
                        break;
                    }
                    if (beforex == afterx && aftery == beforey + i) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "P";
                        return true;
                    }
                }
                // diagonal take
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 1 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "P";
                    return true;
                }
            }

            // castles
            if (board[beforex][beforey].equals("c")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        return true;
                    }
                }
            }

            // knights
            if (board[beforex][beforey].equals("n")) {
                // forward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey + 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    return true;
                }
                // backward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    return true;
                }

                // right
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex + 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    return true;
                }
                // left
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex - 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    return true;
                }
            }
            // bishops

            // queens
            if (board[beforex][beforey].equals("q")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        return true;
                    }
                }
            }

            // kings

            // nothing (out of bounds) <- buttons(unlikely)
        }
        else {
            "".toString();
        }
        return false;
    }

    public boolean checkWin() {
        return true;
    }

    public boolean gameOver() {
        return true;
    }





    public static char
    getCharFromString(String str, int index)
    {
        return str.charAt(index);
    }


}