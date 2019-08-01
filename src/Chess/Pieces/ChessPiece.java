package Chess.Pieces;

import Chess.Board;

public abstract class ChessPiece
{
    protected String letter = " _ ";

    public Boolean isWhite = true;
    public int moveCount;

    protected int column;
    protected int row;
    protected int newColumn;
    protected int newRow;

    public void SetupCAndR(String startLocation, String newLocation)
    {
        column = 0;
        row = Integer.parseInt( Character.toString( startLocation.charAt( 1 ) ) ) - 1;
        switch ( startLocation.charAt( 0 ) )
        {
            case 'a':
                column = 7;
                break;
            case 'b':
                column = 6;
                break;
            case 'c':
                column = 5;
                break;
            case 'd':
                column = 4;
                break;
            case 'e':
                column = 3;
                break;
            case 'f':
                column = 2;
                break;
            case 'g':
                column = 1;
                break;
            case 'h':
                column = 0;
                break;

        }

        newColumn = 0;
        newRow = Integer.parseInt( Character.toString( newLocation.charAt( 1 ) ) ) - 1;
        switch ( newLocation.charAt( 0 ) )
        {
            case 'a':
                newColumn = 7;
                break;
            case 'b':
                newColumn = 6;
                break;
            case 'c':
                newColumn = 5;
                break;
            case 'd':
                newColumn = 4;
                break;
            case 'e':
                newColumn = 3;
                break;
            case 'f':
                newColumn = 2;
                break;
            case 'g':
                newColumn = 1;
                break;
            case 'h':
                newColumn = 0;
        }

    }

    public boolean CheckTakenPieceColor(ChessPiece[][] board)
    {
        return board[newColumn][newRow].isWhite == this.isWhite && board[newColumn][newRow].toString() != " _ ";
    }


    public ChessPiece( Boolean isWhite )
    {
        this.isWhite = isWhite;
    }

    public String FormPieces(String letter)
    {
        /**
         * The black pieces have dots around the letter
         * Example
         *   Black rook -> |.R.|
         *   White rook -> | R |
         */
        if ( !isWhite )
        {
            letter = "." + letter.charAt(letter.length()/2) + ".";
        }else
        {
            letter = " " + letter.charAt(letter.length()/2) + " ";
        }

        return letter;
    }

    public abstract boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board );

    public boolean IsThreathingKing( King king, ChessPiece[][] board, int Sc, int Sr )
    {
        int col = 0;
        int row = 0;

        for ( int c = 0; c < 8; c++ )
            for ( int r = 0; r < 8; r++ )
            {
                if ( board[c][r] == king )
                {
                    col = c;
                    row = r;
                    break;
                }
            }

        String Ncol = "";
        String Nrow = "";


        String newLocation = "";
        switch(col)
        {
            case 0:
                Ncol = "h";
                break;
            case 1:
                Ncol = "g";
                break;
            case 2:
                Ncol = "f";
                break;
            case 3:
                Ncol = "e";
                break;
            case 4:
                Ncol = "d";
                break;
            case 5:
                Ncol = "c";
                break;
            case 6:
                Ncol = "b";
                break;
            case 7:
                Ncol = "a";
                break;
        }

        switch(row)
        {
            case 0:
                Nrow = "1";
                break;
            case 1:
                Nrow = "2";
                break;
            case 2:
                Nrow = "3";
                break;
            case 3:
                Nrow = "4";
                break;
            case 4:
                Nrow = "5";
                break;
            case 5:
                Nrow = "6";
                break;
            case 6:
                Nrow = "7";
                break;
            case 7:
                Nrow = "8";
                break;
        }

        newLocation = Ncol.concat( Nrow );


        String Scol = "";
        String Srow = "";

        switch(Sc)
        {
            case 0:
                Scol = "h";
                break;
            case 1:
                Scol = "g";
                break;
            case 2:
                Scol = "f";
                break;
            case 3:
                Scol = "e";
                break;
            case 4:
                Scol = "d";
                break;
            case 5:
                Scol = "c";
                break;
            case 6:
                Scol = "b";
                break;
            case 7:
                Scol = "a";
                break;
        }

        switch(Sr)
        {
            case 0:
                Srow = "1";
                break;
            case 1:
                Srow = "2";
                break;
            case 2:
                Srow = "3";
                break;
            case 3:
                Srow = "4";
                break;
            case 4:
                Srow = "5";
                break;
            case 5:
                Srow = "6";
                break;
            case 6:
                Srow = "7";
                break;
            case 7:
                Srow = "8";
                break;
        }

        String startLocation = Scol.concat( Srow );


        return CheckMoove( startLocation, newLocation, board );
    }

    @Override
    public String toString()
    {
        return letter;
    }
}
