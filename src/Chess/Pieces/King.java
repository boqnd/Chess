package Chess.Pieces;

import Chess.Board;

public class King extends ChessPiece
{
    protected String letter = "K";

    private int moveCount = 0;
    public boolean isThreatened = false;

    public King( Boolean isWhite )
    {
        super( isWhite );
    }


    @Override
    public boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board )
    {
        SetupCAndR( startLocation, newLocation );

        if ( Math.abs( column - newColumn ) + Math.abs( row - newRow ) <= 2 && Math.abs( Math.abs( column - newColumn ) - Math
                .abs( row - newRow ) ) <= 1 )
            if ( CheckTakenPieceColor( board ) )
                return false;
            else
            {
                moveCount++;
                return true;
            }
        else
            return false;

    }

    @Override
    public String toString()
    {
        letter = FormPieces( letter );
        return letter;
    }
}
