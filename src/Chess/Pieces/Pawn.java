package Chess.Pieces;

import Chess.Board;

public class Pawn extends ChessPiece
{
    protected String letter = "p";

    private int mooveCount = 0;

    public Pawn( Boolean isWhite )
    {
        super( isWhite );
    }

    @Override
    public boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board )
    {
        SetupCAndR( startLocation, newLocation );


        /**
         * Check if the move location of the pawn is on the same column;
         */
        if ( startLocation.charAt( 0 ) != newLocation.charAt( 0 ) )
        {

            if ( CheckTakenPieceColor( board ) )
                return false;
            else
            {
                if ( column == newColumn + 1 || column == newColumn - 1 )
                {
                    if ( isWhite )
                    {
                        if ( row == newRow - 1 )
                        {
                            return board[newColumn][newRow].toString() != " _ ";
                        } else
                            return false;
                    } else
                    {
                        if ( row == newRow + 1 )
                        {
                            return board[newColumn][newRow].toString() != " _ ";
                        } else
                            return false;
                    }
                } else
                    return false;
            }

        } else
        {
            /**
             * Mark the locations
             * we will use them to check if the pawn can move
             */
            int startNumCoordinate = Integer.parseInt( Character.toString( startLocation.charAt( 1 ) ) );
            int newNumCoordinate = Integer.parseInt( Character.toString( newLocation.charAt( 1 ) ) );

            /**
             * Check if this is the first movement of the pawn
             * if it is it can move two spaces
             */
            int spacesToMove = 1;
            if ( mooveCount == 0 )
            {
                spacesToMove = 2;
            }


            /**
             * Check if the move is valid spaces long
             */
            int result = newNumCoordinate - startNumCoordinate;
            if ( !isWhite )
            {
                result = -result;
            }

            /**
             * Check the path ot the move
             */
            if ( result <= spacesToMove && result > 0 )
            {
                if ( isWhite )
                {
                    if ( board[column][row + 1].toString() == " _ " )
                    {
                        if ( result == 2 )
                        {
                            if ( board[column][row + 2].toString() == " _ " )
                            {
                                mooveCount++;
                                return true;
                            } else
                                return false;
                        } else
                        {
                            mooveCount++;
                            return true;
                        }

                    } else
                        return false;
                } else
                {
                    if ( board[column][row - 1].toString() == " _ " )
                    {
                        if ( result == 2 )
                        {
                            if ( board[column][row - 2].toString() == " _ " )
                            {
                                mooveCount++;
                                return true;
                            } else
                                return false;
                        } else
                        {
                            mooveCount++;
                            return true;
                        }

                    } else
                        return false;
                }
            } else
                return false;
        }
    }

    @Override
    public String toString()
    {
        letter = FormPieces( letter );
        return letter;
    }

}
