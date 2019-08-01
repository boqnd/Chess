package Chess.Pieces;

import Chess.Board;

public class EmptyPiece extends ChessPiece
{
    public EmptyPiece()
    {
        super(true);
    }


    @Override
    public boolean CheckMoove( String StartLocation, String NewLocation, ChessPiece[][] board )
    {        return false;

    }

}
