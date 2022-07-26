package com.example.halschess;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

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
    int count = 0; // Starts at 0




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
        count++;
        if (count % 4 == 1) { // check if white piece is selected (increment count if selected)
            player1before = (ImageButton) v;
        }
        else if (count % 4 == 2){ // check if open space is selected (increment count if selected) then move
            player1after = (ImageButton) v;move(player1before, player1after); }
        else if (count % 4 == 3){  // check if black piece is selected (increment count if selected)
            player2before = (ImageButton) v;
        }
        else if (count % 4 == 0){ // check if open space is selected (increment count if selected) then move
            player2after = (ImageButton) v;
            move(player2before, player2after);
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
        int beforex = Character.toUpperCase(getCharFromString(before.getTag().toString(), 0)) - 'A';
        int beforey = getCharFromString(before.getTag().toString(), 1) - '1';
        int afterx = Character.toUpperCase(getCharFromString(after.getTag().toString(), 0)) - 'A';
        int aftery = getCharFromString(after.getTag().toString(), 1) - '1';
        String status = "Move 1 is " + Integer.toString(beforex) + Integer.toString(beforey) +
                ". Move 2 is " + Integer.toString(afterx) + Integer.toString(aftery);
        Log.d("move", status);
        Log.d("move ", board[beforex][beforey]);
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
        char piece = getCharFromString(board[beforex][beforey], 0);


        // white
        if (Character.isUpperCase(piece)  &&
                (!Character.isUpperCase(getCharFromString(board[afterx][aftery], 0)))){
            // pawns
            if (piece == 'P') {
                // forward
                for (int i = 0; i <= 2; i++) {
                    if (beforex == afterx && aftery == beforey + i) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "P";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.pawnwhite);
                        return true;
                    }
                }
                // diagonal take
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey + 1 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "P";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.pawnwhite);
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
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookwhite);
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookwhite);
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookwhite);
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "C";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookwhite);
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
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightwhite);
                    return true;
                }
                // backward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightwhite);
                    return true;
                }

                // right
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex + 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightwhite);
                    return true;
                }
                // left
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex - 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "N";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightwhite);
                    return true;
                }
            }

            // bishops
            if (board[beforex][beforey].equals("B")) {
                for (int i = 0; i <= 8; i++) {
                    // forward right
                    if (beforey + i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "B";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopwhite);
                        return true;
                    }
                    // forward left
                    if (beforey + i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "B";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopwhite);
                        return true;
                    }
                    // backwards right
                    if (beforey - i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "B";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopwhite);
                        return true;
                    }
                    // backwards left
                    if (beforey - i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "B";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopwhite);
                        return true;
                    }
                }
            }

            // queens
            if (board[beforex][beforey].equals("Q")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // right
                    if (beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // left
                    if (beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // forward right
                    if (beforey + i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // forward left
                    if (beforey + i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // backwards right
                    if (beforey - i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
                        return true;
                    }
                    // backwards left
                    if (beforey - i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "Q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenwhite);
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
                for (int i = 1; i <= 2; i++) {

                    if (beforex == afterx && aftery == beforey - i) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "P";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.pawnblack);
                        return true;
                    }
                }
                // diagonal take
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 1 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "P";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.queenwhite);
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
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookblack);
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookblack);
                        return true;
                    }
                    // right
                    if (beforex + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookblack);
                        return true;
                    }
                    // left
                    if (beforex - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "c";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.rookblack);
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
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightblack);
                    return true;
                }
                // backward
                if ((beforex + 1 == afterx || beforex - 1 == afterx) && beforey - 2 == aftery) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightblack);
                    return true;
                }

                // right
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex + 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightblack);
                    return true;
                }
                // left
                if ((beforey + 1 == aftery || beforey - 1 == aftery) && beforex - 2 == afterx) {
                    board[beforex][beforey] = "0";
                    board[afterx][aftery] = "n";
                    before.setImageResource(R.drawable.nothing);
                    after.setImageResource(R.drawable.knightblack);
                    return true;
                }
            }
            // bishops
            if (board[beforex][beforey].equals("b")) {
                for (int i = 0; i <= 8; i++) {
                    // forward right
                    if (beforey - i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "b";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopblack);
                        return true;
                    }
                    // forward left
                    if (beforey - i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "b";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopblack);
                        return true;
                    }
                    // backwards right
                    if (beforey + i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "b";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopblack);
                        return true;
                    }
                    // backwards left
                    if (beforey + i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "b";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.bishopblack);
                        return true;
                    }
                }
            }

            // queens
            if (board[beforex][beforey].equals("q")) {
                for (int i = 0; i <= 8; i++) {
                    // forward
                    if (beforey + i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // backward
                    if (beforey - i == aftery) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // right
                    if (beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // left
                    if (beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // forward right
                    if (beforey + i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // forward left
                    if (beforey + i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // backwards right
                    if (beforey - i == aftery && beforex + i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
                        return true;
                    }
                    // backwards left
                    if (beforey - i == aftery && beforex - i == afterx) {
                        board[beforex][beforey] = "0";
                        board[afterx][aftery] = "q";
                        before.setImageResource(R.drawable.nothing);
                        after.setImageResource(R.drawable.queenblack);
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