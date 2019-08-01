package Chess.Pieces;

import Chess.Board;

public class Queen extends ChessPiece
{
    protected String letter = "Q";

    public Queen( Boolean isWhite )
    {
        super( isWhite );

    }

    @Override
    public boolean CheckMoove( String startLocation, String newLocation, ChessPiece[][] board )
    {
        SetupCAndR( startLocation, newLocation );

        if ( Math.abs( column - newColumn ) == Math.abs( row - newRow ) )
        {
            if ( CheckTakenPieceColor( board ) )
                return false;
            else
            {
                if ( newColumn > column )
                {
                    if ( newRow > row )
                    {
                        int startColumn = column + 1;
                        int startRow = row + 1;

                        while ( startColumn != newColumn && startRow != newRow )
                        {
                            if ( !board[startColumn][startRow].toString().equals( " _ " ) )
                            {
                                return false;
                            }
                            startColumn++;
                            startRow++;
                        }
                        return true;
                    } else
                    {
                        int startColumn = column + 1;
                        int startRow = row - 1;

                        while ( startColumn != newColumn && startRow != newRow )
                        {
                            if ( !board[startColumn][startRow].toString().equals( " _ " ) )
                            {
                                return false;
                            }
                            startColumn++;
                            startRow--;
                        }
                        return true;
                    }
                } else
                {
                    if ( newRow > row )
                    {
                        int startColumn = column - 1;
                        int startRow = row + 1;

                        while ( startColumn != newColumn && startRow != newRow )
                        {
                            if ( !board[startColumn][startRow].toString().equals( " _ " ) )
                            {
                                return false;
                            }
                            startColumn--;
                            startRow++;
                        }
                        return true;
                    } else
                    {
                        int startColumn = column - 1;
                        int startRow = row - 1;

                        while ( startColumn != newColumn && startRow != newRow )
                        {
                            if ( board[startColumn][startRow].toString() != " _ " )
                            {
                                return false;
                            }
                            startColumn--;
                            startRow--;
                        }
                        return true;
                    }
                }
            }
        } else if ( column == newColumn || row == newRow )
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
