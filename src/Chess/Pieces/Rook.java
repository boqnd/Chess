package Chess.Pieces;

import Chess.Board;

public class Rook extends ChessPiece
{
    protected String letter = "R";
    public int moveCount = 0;

    public Rook( Boolean isWhite )
    {
        super( isWhite );

    }


    @Override
    public boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board )
    {
        SetupCAndR( startLocation, newLocation );

        if ( column == newColumn || row == newRow )
        {
            if ( CheckTakenPieceColor( board ) )
                return false;
            else
            {
                if ( column == newColumn )
                {
                    int startRow = Math.min( row, newRow );

                    while ( startRow != Math.max( newRow, row ) - 1 )
                    {
                        startRow++;
                        if ( board[column][startRow].toString() != " _ " )
                            return false;
                    }
                    moveCount++;
                    return true;
                } else
                {
                    int startColumn = Math.min( column, newColumn );

                    while ( startColumn != Math.max( newColumn, column ) - 1 )
                    {
                        startColumn++;
                        if ( board[startColumn][row].toString() != " _ " )
                            return false;
                    }
                    moveCount++;
                    return true;
                }
            }

        } else
            return false;
    }

    @Override
    public String toString()
    {
        letter = FormPieces( letter );
        return letter;
    }
}
