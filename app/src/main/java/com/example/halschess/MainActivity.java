package com.example.halschess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*-------------------------BOARD---------------------------------
            {"c", "n", "b", "q", "k", "b", "n", "c"}, // 8
            {"p", "p", "p", "p", "p", "p", "p", "p"}, // 7
            {"0", "0", "0", "0", "0", "0", "0", "0"}, // 6
            {"0", "0", "0", "0", "0", "0", "0", "0"}, // 5
            {"0", "0", "0", "0", "0", "0", "0", "0"}, // 4
            {"0", "0", "0", "0", "0", "0", "0", "0"}, // 3
            {"P", "P", "P", "P", "P", "P", "P", "P"}, // 2
            {"C", "N", "B", "Q", "K", "B", "N", "C"}  // 1
       //     A    B    C    D    E    F    G    H;   // Letters
     */

    String[][] board =
            new String[][] { // lowercase = black uppercase = white
        {"C", "P", "0", "0", "0", "0", "p", "c"},  // 1
        {"N", "P", "0", "0", "0", "0", "p", "n"}, // 2
        {"B", "P", "0", "0", "0", "0", "p", "b"}, // 3
        {"Q", "P", "0", "0", "0", "0", "p", "q"}, // 4
        {"K", "P", "0", "0", "0", "0", "p", "k"}, // 5
        {"B", "P", "0", "0", "0", "0", "p", "b"}, // 6
        {"N", "P", "0", "0", "0", "0", "p", "n"}, // 7
        {"C", "P", "0", "0", "0", "0", "p", "c"}, // 8

    }; //     A    B    C    D    E    F    G    H

    boolean checkPlayer1 = false;
    boolean checkPlayer2 = false;
    boolean castlePlayer1left = true;
    boolean castlePlayer1right = true;
    boolean castlePlayer2left = true;
    boolean castlePlayer2right = true;
    int beforeX;
    int beforeY;
    int afterX;
    int afterY;
    int moveCount = 1; // Starts at 0




    ImageButton player1before; // "A-H"(x)  + "1-8"(y)
    ImageButton player1after; // "A-H"(x)  + "1-8"(y)
    ImageButton player2before; // "A-H"(x)  + "1-8"(y)
    ImageButton player2after; // "A-H"(x)  + "1-8"(y)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetBoard(board);

        // Instantiates image buttons for board
        ImageButton A1 = findViewById(R.id.A1);
        ImageButton A2 = findViewById(R.id.A2);
        ImageButton A3 = findViewById(R.id.A3);
        ImageButton A4 = findViewById(R.id.A4);
        ImageButton A5 = findViewById(R.id.A5);
        ImageButton A6 = findViewById(R.id.A6);
        ImageButton A7 = findViewById(R.id.A7);
        ImageButton A8 = findViewById(R.id.A8);
        ImageButton B1 = findViewById(R.id.B1);
        ImageButton B2 = findViewById(R.id.B2);
        ImageButton B3 = findViewById(R.id.B3);
        ImageButton B4 = findViewById(R.id.B4);
        ImageButton B5 = findViewById(R.id.B5);
        ImageButton B6 = findViewById(R.id.B6);
        ImageButton B7 = findViewById(R.id.B7);
        ImageButton B8 = findViewById(R.id.B8);
        ImageButton C1 = findViewById(R.id.C1);
        ImageButton C2 = findViewById(R.id.C2);
        ImageButton C3 = findViewById(R.id.C3);
        ImageButton C4 = findViewById(R.id.C4);
        ImageButton C5 = findViewById(R.id.C5);
        ImageButton C6 = findViewById(R.id.C6);
        ImageButton C7 = findViewById(R.id.C7);
        ImageButton C8 = findViewById(R.id.C8);
        ImageButton D1 = findViewById(R.id.D1);
        ImageButton D2 = findViewById(R.id.D2);
        ImageButton D3 = findViewById(R.id.D3);
        ImageButton D4 = findViewById(R.id.D4);
        ImageButton D5 = findViewById(R.id.D5);
        ImageButton D6 = findViewById(R.id.D6);
        ImageButton D7 = findViewById(R.id.D7);
        ImageButton D8 = findViewById(R.id.D8);
        ImageButton E1 = findViewById(R.id.E1);
        ImageButton E2 = findViewById(R.id.E2);
        ImageButton E3 = findViewById(R.id.E3);
        ImageButton E4 = findViewById(R.id.E4);
        ImageButton E5 = findViewById(R.id.E5);
        ImageButton E6 = findViewById(R.id.E6);
        ImageButton E7 = findViewById(R.id.E7);
        ImageButton E8 = findViewById(R.id.E8);
        ImageButton F1 = findViewById(R.id.F1);
        ImageButton F2 = findViewById(R.id.F2);
        ImageButton F3 = findViewById(R.id.F3);
        ImageButton F4 = findViewById(R.id.F4);
        ImageButton F5 = findViewById(R.id.F5);
        ImageButton F6 = findViewById(R.id.F6);
        ImageButton F7 = findViewById(R.id.F7);
        ImageButton F8 = findViewById(R.id.F8);
        ImageButton G1 = findViewById(R.id.G1);
        ImageButton G2 = findViewById(R.id.G2);
        ImageButton G3 = findViewById(R.id.G3);
        ImageButton G4 = findViewById(R.id.G4);
        ImageButton G5 = findViewById(R.id.G5);
        ImageButton G6 = findViewById(R.id.G6);
        ImageButton G7 = findViewById(R.id.G7);
        ImageButton G8 = findViewById(R.id.G8);
        ImageButton H1 = findViewById(R.id.H1);
        ImageButton H2 = findViewById(R.id.H2);
        ImageButton H3 = findViewById(R.id.H3);
        ImageButton H4 = findViewById(R.id.H4);
        ImageButton H5 = findViewById(R.id.H5);
        ImageButton H6 = findViewById(R.id.H6);
        ImageButton H7 = findViewById(R.id.H7);
        ImageButton H8 = findViewById(R.id.H8);


        // Sets on click listeners
        A1.setOnClickListener(this);
        A2.setOnClickListener(this);
        A3.setOnClickListener(this);
        A4.setOnClickListener(this);
        A5.setOnClickListener(this);
        A6.setOnClickListener(this);
        A7.setOnClickListener(this);
        A8.setOnClickListener(this);
        B1.setOnClickListener(this);
        B2.setOnClickListener(this);
        B3.setOnClickListener(this);
        B4.setOnClickListener(this);
        B5.setOnClickListener(this);
        B6.setOnClickListener(this);
        B7.setOnClickListener(this);
        B8.setOnClickListener(this);
        C1.setOnClickListener(this);
        C2.setOnClickListener(this);
        C3.setOnClickListener(this);
        C4.setOnClickListener(this);
        C5.setOnClickListener(this);
        C6.setOnClickListener(this);
        C7.setOnClickListener(this);
        C8.setOnClickListener(this);
        D1.setOnClickListener(this);
        D2.setOnClickListener(this);
        D3.setOnClickListener(this);
        D4.setOnClickListener(this);
        D5.setOnClickListener(this);
        D6.setOnClickListener(this);
        D7.setOnClickListener(this);
        D8.setOnClickListener(this);
        E1.setOnClickListener(this);
        E2.setOnClickListener(this);
        E3.setOnClickListener(this);
        E4.setOnClickListener(this);
        E5.setOnClickListener(this);
        E6.setOnClickListener(this);
        E7.setOnClickListener(this);
        E8.setOnClickListener(this);
        F1.setOnClickListener(this);
        F2.setOnClickListener(this);
        F3.setOnClickListener(this);
        F4.setOnClickListener(this);
        F5.setOnClickListener(this);
        F6.setOnClickListener(this);
        F7.setOnClickListener(this);
        F8.setOnClickListener(this);
        G1.setOnClickListener(this);
        G2.setOnClickListener(this);
        G3.setOnClickListener(this);
        G4.setOnClickListener(this);
        G5.setOnClickListener(this);
        G6.setOnClickListener(this);
        G7.setOnClickListener(this);
        G8.setOnClickListener(this);
        H1.setOnClickListener(this);
        H2.setOnClickListener(this);
        H3.setOnClickListener(this);
        H4.setOnClickListener(this);
        H5.setOnClickListener(this);
        H6.setOnClickListener(this);
        H7.setOnClickListener(this);
        H8.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (moveCount % 4 == 1) { // check if white piece is selected (increment moveCount if selected)
            player1before = (ImageButton) v;
            locationBefore(player1before);
            if (Character.isUpperCase(getCharFromString(board[beforeX][beforeY], 0))) {
                Log.d("move", "Move count is " + Integer.toString(moveCount % 4));
                moveCount++;
            } else {
                "".toString();
            }
        }
        else if (moveCount % 4 == 2){ // check if not capital space is selected (increment moveCount if selected) then move
            player1after = (ImageButton) v;
            locationAfter(player1after);
            if (!Character.isUpperCase(getCharFromString(board[afterX][afterY], 0))) {
                Log.d("move", "Move count is " + Integer.toString(moveCount % 4));
                if (move(player1before, player1after)) {
                    moveCount++;
                } else {
                    moveCount--;
                }
            } else if (Character.isUpperCase(getCharFromString(board[afterX][afterY], 0))) {
                moveCount--;
            }
        }
        else if (moveCount % 4 == 3){  // check if black piece is selected (increment moveCount if selected)
            player2before = (ImageButton) v;
            locationBefore(player2before);
            if (Character.isLowerCase(getCharFromString(board[beforeX][beforeY], 0))) {
                Log.d("move", "Move count is " + Integer.toString(moveCount % 4));
                moveCount++;
            }
        }
        else if (moveCount % 4 == 0){ // check if open space is selected (increment moveCount if selected) then move
            player2after = (ImageButton) v;
            locationAfter(player2after);
            if (!Character.isLowerCase(getCharFromString(board[afterX][afterY], 0))) {
                Log.d("move", "Move count is " + Integer.toString(moveCount % 4));
                 if (move(player2before, player2after)) {
                     moveCount++;
                 } else {
                     moveCount--;
                 }
            } else if(Character.isLowerCase(getCharFromString(board[beforeX][beforeY], 0))) {
                moveCount--;
            }
        }
    }




    public void resetBoard( String[][] board) {
        /* The board in this model will be 8 by 8 and will have pieces arranged correctly. */

        board =
                new String[][] { // lowercase = black uppercase = white
                        {"C", "P", "0", "0", "0", "0", "p", "c"},  // 1
                        {"N", "P", "0", "0", "0", "0", "p", "n"}, // 2
                        {"B", "P", "0", "0", "0", "0", "p", "b"}, // 3
                        {"Q", "P", "0", "0", "0", "0", "p", "q"}, // 4
                        {"K", "P", "0", "0", "0", "0", "p", "k"}, // 5
                        {"B", "P", "0", "0", "0", "0", "p", "b"}, // 6
                        {"N", "P", "p", "p", "p", "p", "p", "n"}, // 7
                        {"C", "P", "b", "q", "k", "b", "p", "c"}, // 8

                }; //     A    B    C    D    E    F    G    H



    }

    public boolean move(ImageButton before, ImageButton after) { // Takes two (A-H)(1-8) strings
        if (before == after) { return false; }

        String status = "Move 1 is " + Integer.toString(beforeX) + Integer.toString(beforeY) +
                ". Move 2 is " + Integer.toString(afterX) + Integer.toString(afterY);
        Log.d("move", status);
        Log.d("move ", board[beforeX][beforeY]);
        String line = "";
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                line = line + board[x][y] + " ";
                if (y == 7) {
                    Log.d("Move", line);
                }
            }
            Log.d("move", "\n");
            line = "";
        }
        char piece = getCharFromString(board[beforeX][beforeY], 0);
        int player = ((moveCount - 1)/2 % 2)+ 1;
        Log.d("move", Integer.toString(player));


        // white
        if ((Character.isUpperCase(piece)  &&
                (!Character.isUpperCase(getCharFromString(board[afterX][afterY], 0)))) ||
        (Character.isLowerCase(piece)  &&
                (!Character.isLowerCase(getCharFromString(board[afterX][afterY], 0))))){

            // pawns
            if (board[beforeX][beforeY].equals("P") || board[beforeX][beforeY].equals("p")) {
                if (movePawn(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }

            // castles
            if (board[beforeX][beforeY].equals("C") || board[beforeX][beforeY].equals("c")) {
                if (moveCastle(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }

            // knights
            if (board[beforeX][beforeY].equals("N") || board[beforeX][beforeY].equals("n")) {
                if (moveKnight(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }
            // bishops
            if (board[beforeX][beforeY].equals("B") || board[beforeX][beforeY].equals("b")) {
                if (moveBishop(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }

            // queens
            if (board[beforeX][beforeY].equals("Q") || board[beforeX][beforeY].equals("q")) {
                if (moveQueen(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }

            // kings
            if (board[beforeX][beforeY].equals("K") || board[beforeX][beforeY].equals("k")) {
                if (moveKing(player)) { // switches between 1 and 2
                    drawPiece(before, after); return true;
                }
            }

            // nothing (out of bounds) <- buttons(unlikely)
        }
        else {
            "".toString();
        }
        return false;
    }

    public boolean movePawn(int player) {

        String piece = (player == 1) ? "P": "p";
        int orientation = (player == 1) ? 1: -1;

        // forward
        for (int i = 1; i <= 2; i++) {
            if (board[beforeX][beforeY + i * orientation] != "0") {
                return false;
            }
            if (beforeX == afterX && afterY == beforeY + i * orientation) {
                Log.d("move", "Loads forward");
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }

        }
        // diagonal take
        if ((beforeX + 1 == afterX || beforeX - 1 == afterX) && beforeY + orientation == afterY) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        return false;
    }

    public boolean moveCastle(int player) {
        String piece;
        if (player == 1) {
            piece = "C";
        } else {
            piece = "c";
        }
        for (int i = 0; i <= 8; i++) {
            // forward
            if (beforeY + i == afterY && beforeX == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backward
            if (beforeY - i == afterY && beforeX == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // right
            if (beforeX + i == afterX && beforeY == afterY) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // left
            if (beforeX - i == afterX && beforeY == afterY) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
        }
        return false;
    }

    public boolean moveKnight(int player) {
        String piece;
        if (player == 1) {
            piece = "N";
        } else {
            piece = "n";
        }
        // forward
        if ((beforeX + 1 == afterX || beforeX - 1 == afterX) && beforeY + 2 == afterY) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        // backward
        if ((beforeX + 1 == afterX || beforeX - 1 == afterX) && beforeY - 2 == afterY) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }

        // right
        if ((beforeY + 1 == afterY || beforeY - 1 == afterY) && beforeX + 2 == afterX) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        // left
        if ((beforeY + 1 == afterY || beforeY - 1 == afterY) && beforeX - 2 == afterX) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        return false;
    }

    public boolean moveBishop(int player) {
        String piece;
        if (player == 1) {
            piece = "B";
        } else {
            piece = "b";
        }
        for (int i = 0; i <= 8; i++) {
            // forward right
            if (beforeY - i == afterY && beforeX + i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // forward left
            if (beforeY - i == afterY && beforeX - i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backwards right
            if (beforeY + i == afterY && beforeX + i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backwards left
            if (beforeY + i == afterY && beforeX - i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
        }
        return false;
    }

    public boolean moveQueen(int player) {
        String piece;
        if (player == 1) {
            piece = "Q";
        } else {
            piece = "q";
        }
        for (int i = 0; i <= 8; i++) {
            // forward
            if (beforeY + i == afterY && beforeX == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backward
            if (beforeY - i == afterY && beforeX == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // right
            if (beforeX + i == afterX && beforeY == afterY) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // left
            if (beforeX - i == afterX && beforeY == afterY) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // forward right
            if (beforeY + i == afterY && beforeX + i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // forward left
            if (beforeY + i == afterY && beforeX - i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backwards right
            if (beforeY - i == afterY && beforeX + i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
            // backwards left
            if (beforeY - i == afterY && beforeX - i == afterX) {
                board[beforeX][beforeY] = "0";
                board[afterX][afterY] = piece;
                return true;
            }
        }
        return false;
    }

    public boolean moveKing(int player) { // player 1 or 2
        String piece, rook;
        if (player == 1) {
            piece = "K";
            rook = "R";
        } else {
            piece = "k";
            rook = "r";
        }
        // castles
        if (castlePlayer2left && castlePlayer2right && (beforeX == 4 && beforeY == 7) // CHANGE =================
                && (afterX == 6 && afterY  == 7 || afterX == 2 && afterY  == 7 )) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            if (afterX == 6) { // right castle
                board[5][7] = rook;
                board[7][7] = "0";
                ((ImageView)findViewById(R.id.F8)).setImageResource(R.drawable.rookblack);
                ((ImageView)findViewById(R.id.H8)).setImageResource(R.drawable.nothing);
            } else { // left castle
                board[3][7] = rook;
                board[0][7] = "0";
                ((ImageView)findViewById(R.id.D8)).setImageResource(R.drawable.rookblack);
                ((ImageView)findViewById(R.id.A8)).setImageResource(R.drawable.nothing);
            }
            return true;

        }
        // forward
        if (beforeY - 1 == afterY) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        // right
        if (beforeX + 1 == afterX) {
            castlePlayer2right = false; // CHANGE ===============================
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        // backward
        if (beforeY + 1 == afterY) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        // left
        if (beforeX - 1 == afterX) {
            board[beforeX][beforeY] = "0";
            board[afterX][afterY] = piece;
            return true;
        }
        if (player == 1) {
            castlePlayer1left = false; // CHANGE ============================
        } else {
            castlePlayer2left = false; // CHANGE ============================
        }
        return false;
    }

    public void locationBefore(ImageButton v) {
        beforeX = Character.toUpperCase(getCharFromString(v.getTag().toString(), 0)) - 'A';
        beforeY = getCharFromString(v.getTag().toString(), 1) - '1';
    }

    public void locationAfter(ImageButton v) {
        afterX = Character.toUpperCase(getCharFromString(v.getTag().toString(), 0)) - 'A';
        afterY = getCharFromString(v.getTag().toString(), 1) - '1';
    }

    public void drawPiece(ImageButton before, ImageButton after) {
        before.setImageResource(R.drawable.nothing);
        switch(board[afterX][afterY]) {
            case "P":
                after.setImageResource(R.drawable.pawnwhite); break;
            case "p":
                after.setImageResource(R.drawable.pawnblack); break;
            case "C":
                after.setImageResource(R.drawable.rookwhite); break;
            case "c":
                after.setImageResource(R.drawable.rookblack); break;
            case "N":
                after.setImageResource(R.drawable.knightwhite); break;
            case "n":
                after.setImageResource(R.drawable.knightblack); break;
            case "B":
                after.setImageResource(R.drawable.bishopwhite); break;
            case "b":
                after.setImageResource(R.drawable.bishopblack); break;
            case "Q":
                after.setImageResource(R.drawable.queenwhite); break;
            case "q":
                after.setImageResource(R.drawable.queenblack); break;
            case "K":
                after.setImageResource(R.drawable.kingwhite); break;
            case "k":
                after.setImageResource(R.drawable.kingblack); break;
            default:
                break;
        }
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