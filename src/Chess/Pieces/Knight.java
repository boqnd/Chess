package Chess.Pieces;

import Chess.Board;

public class Knight extends ChessPiece
{
    protected String letter = "N";

    public Knight( Boolean isWhite )
    {
        super( isWhite );


    }


    @Override
    public boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board )
    {
        SetupCAndR( startLocation, newLocation );

        if ( Math.abs( column - newColumn ) + Math.abs( row - newRow ) == 3 && Math.abs(Math.abs( column - newColumn ) - Math.abs(
                row - newRow )) == 1 )
        {
            return !CheckTakenPieceColor( board );
        }
        return false;

    }

    @Override
    public String toString()
    {
        letter = FormPieces( letter );
        return letter;
    }
}
