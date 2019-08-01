package Chess;

import Chess.Pieces.*;

import java.lang.invoke.SwitchPoint;

public class Board
{
    private boolean lastPieceIsWhite = false;
    private ChessPiece[][] board = new ChessPiece[8][8];

    private King whiteKing = new King( true );
    private King blackKing = new King( false );

    public Board()
    {
        /**
         * Create new board full of empty fields
         * Empty field looks like this -> | _ |
         */
        for ( int row = 0; row < board.length; row++ )
        {
            for ( int column = 0; column < board.length; column++ )
            {
                board[column][row] = new EmptyPiece();
            }
        }
    }

    public void SetUpBoard()
    {
        board[0][0] = new Rook( true );
        board[7][0] = new Rook( true );
        board[0][7] = new Rook( false );
        board[7][7] = new Rook( false );

        board[1][0] = new Knight( true );
        board[6][0] = new Knight( true );
        board[1][7] = new Knight( false );
        board[6][7] = new Knight( false );

        board[2][0] = new Bishop( true );
        board[5][0] = new Bishop( true );
        board[2][7] = new Bishop( false );
        board[5][7] = new Bishop( false );

        board[3][0] = whiteKing;
        board[3][7] = blackKing;

        board[4][0] = new Queen( true );
        board[4][7] = new Queen( false );

        board[0][1] = new Pawn( true );
        board[1][1] = new Pawn( true );
        board[2][1] = new Pawn( true );
        board[3][1] = new Pawn( true );
        board[4][1] = new Pawn( true );
        board[5][1] = new Pawn( true );
        board[6][1] = new Pawn( true );
        board[7][1] = new Pawn( true );

        board[0][6] = new Pawn( false );
        board[1][6] = new Pawn( false );
        board[2][6] = new Pawn( false );
        board[3][6] = new Pawn( false );
        board[4][6] = new Pawn( false );
        board[5][6] = new Pawn( false );
        board[6][6] = new Pawn( false );
        board[7][6] = new Pawn( false );

    }

    public void ShowBoard()
    {
        System.out.println( "  _________________________________" );
        for ( int row = 0; row < board.length; row++ )
        {
            switch ( row )
            {
                case 0:
                    System.out.print( "1 " );
                    break;
                case 1:
                    System.out.print( "2 " );
                    break;
                case 2:
                    System.out.print( "3 " );
                    break;
                case 3:
                    System.out.print( "4 " );
                    break;
                case 4:
                    System.out.print( "5 " );
                    break;
                case 5:
                    System.out.print( "6 " );
                    break;
                case 6:
                    System.out.print( "7 " );
                    break;
                case 7:
                    System.out.print( "8 " );
                    break;
            }

            for ( int column = 0; column < board.length; column++ )
            {
                System.out.print( "|" + board[column][row] );
            }

            System.out.println( "|" );
        }
        System.out.println( "    h   g   f   e   d   c   b   a" );
    }

    public boolean Moove( String pieceLocation, String moveLocation )
    {

        for ( int c = 0; c < 8; c++ )
            for ( int r = 0; r < 8; r++ )
            {
                if ( board[c][r].toString() != " _ " )
                {
                    if ( board[c][r].isWhite )
                    {
                        if ( board[c][r].IsThreathingKing( blackKing, board, c, r ) )
                        {
                            blackKing.isThreatened = true;
                        }
                    } else
                    {
                        if ( board[c][r].IsThreathingKing( whiteKing, board, c, r ) )
                        {
                            whiteKing.isThreatened = true;
                        }
                    }
                }
            }


        int column = 0;
        int row = Integer.parseInt( Character.toString( pieceLocation.charAt( 1 ) ) ) - 1;
        switch ( pieceLocation.charAt( 0 ) )
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

        int newColumn = 0;
        int newRow = Integer.parseInt( Character.toString( moveLocation.charAt( 1 ) ) ) - 1;
        switch ( moveLocation.charAt( 0 ) )
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

        ChessPiece currPiece = board[column][row];

        if ( currPiece.isWhite != lastPieceIsWhite )
        {
            if ( currPiece.isWhite )
            {
                if ( true )
                {
                    boolean hasMoved = false;
                    ChessPiece p = board[newColumn][newRow];

                    if ( currPiece.CheckMoove( pieceLocation, moveLocation, board ) )
                    {
                        this.board[column][row] = new EmptyPiece();
                        board[newColumn][newRow] = currPiece;

                        lastPieceIsWhite = !lastPieceIsWhite;
                        if ( board[newColumn][newRow].toString().charAt( 1 ) == 'p' )
                            ChangePawn( newColumn, newRow, moveLocation );
                        hasMoved = true;
                    } else
                        return false;

                    for ( int c = 0; c < 8; c++ )
                    {
                        for ( int r = 0; r < 8; r++ )
                        {
                            if ( board[c][r].toString() != " _ " )
                            {
                                if ( !board[c][r].isWhite )
                                {
                                    if ( board[c][r].IsThreathingKing( whiteKing, board, c, r ) )
                                    {
                                        whiteKing.isThreatened = true;
                                        board[newColumn][newRow] = p;
                                        board[column][row] = currPiece;
                                        lastPieceIsWhite = !lastPieceIsWhite;
                                        return false;
                                    } else
                                        whiteKing.isThreatened = false;
                                }
                            }
                        }
                    }

                    if ( hasMoved )
                    {
                        if ( !whiteKing.isThreatened )
                            return true;
                        else
                        {
                            board[newColumn][newRow] = p;
                            board[column][row] = currPiece;
                            lastPieceIsWhite = !lastPieceIsWhite;
                            return false;
                        }
                    }

                }
            } else
            {
                if ( true )
                {
                    boolean hasMoved = false;
                    ChessPiece p = board[newColumn][newRow];

                    if ( currPiece.CheckMoove( pieceLocation, moveLocation, board ) )
                    {
                        this.board[column][row] = new EmptyPiece();
                        board[newColumn][newRow] = currPiece;

                        lastPieceIsWhite = !lastPieceIsWhite;
                        if ( board[newColumn][newRow].toString().charAt( 1 ) == 'p' )
                            ChangePawn( newColumn, newRow, moveLocation );
                        hasMoved = true;
                    } else
                        return false;

                    for ( int c = 0; c < 8; c++ )
                    {
                        for ( int r = 0; r < 8; r++ )
                        {
                            if ( board[c][r].toString() != " _ " )
                            {
                                if ( board[c][r].isWhite )
                                {
                                    if ( board[c][r].IsThreathingKing( blackKing, board, c, r ) )
                                    {
                                        blackKing.isThreatened = true;
                                        board[newColumn][newRow] = p;
                                        board[column][row] = currPiece;
                                        lastPieceIsWhite = !lastPieceIsWhite;
                                        return false;
                                    } else
                                        blackKing.isThreatened = false;
                                }
                            }
                        }
                    }


                    if ( hasMoved )
                    {
                        if ( !blackKing.isThreatened )
                            return true;
                        else
                        {
                            board[newColumn][newRow] = p;
                            board[column][row] = currPiece;
                            lastPieceIsWhite = !lastPieceIsWhite;
                            return false;
                        }
                    }
                }
            }
            ///////
            if ( currPiece.CheckMoove( pieceLocation, moveLocation, board ) )
            {
                this.board[column][row] = new EmptyPiece();
                board[newColumn][newRow] = currPiece;

                lastPieceIsWhite = !lastPieceIsWhite;
                if ( board[newColumn][newRow].toString().charAt( 1 ) == 'p' )
                    ChangePawn( newColumn, newRow, moveLocation );

                return true;
            }else
                return false;

            //            if ( ( moveLocation == "h8" || moveLocation == "h1" || moveLocation == "a8" || moveLocation == "a1" ) && ( pieceLocation == "e8" || pieceLocation == "e1" ) )
            //            {
            //                if ( pieceLocation == "e1" && board[column][row].toString()
            //                                                                .charAt( 1 ) == 'K' && board[column][row].moveCount == 0 )
            //                {
            //
            //                    if ( moveLocation == "a1" && board[0][0].moveCount == 0 && board[0][0].toString()
            //                                                                                          .charAt( 1 ) == 'R' )
            //                    {
            //                        if ( board[1][0].toString() == " _ " && board[2][0].toString() == " _ " && !whiteKing.isThreatened )
            //                        {
            //                            board[1][0] = board[3][0];
            //                            board[2][0] = board[0][0];
            //                            board[0][0] = new EmptyPiece();
            //                            board[3][0] = new EmptyPiece();
            //                            return true;
            //                        }
            //                    } else if ( moveLocation == "h1" && board[7][0].moveCount == 0 && board[7][0].toString()
            //                                                                                                 .charAt( 1 ) == 'R' )
            //                    {
            //                        return true;
            //                    } else
            //                        return true;
            //
            //
            //                    return true;
            //
            //                } else if ( pieceLocation == "e8" && board[column][row].toString()
            //                                                                       .charAt( 1 ) == 'K' && board[column][row].moveCount == 0 )
            //                {
            //
            //                } else
            //                    return false;
            //
            //            }
            //            return false;
            //        }return false;
        }
        return false;
    }


    private void ChangePawn( int column, int row, String moveLocation )
    {

        ChessPiece newPiece = new Queen( true );

        try
        {
            switch ( moveLocation.charAt( 2 ) )
            {
                case 'R':
                    newPiece = new Rook( true );
                    break;
                case 'N':
                    newPiece = new Knight( true );
                    break;
                case 'B':
                    newPiece = new Bishop( true );
                    break;
            }
        }
        catch ( Exception ignored )
        {
        }


        if ( board[column][row].isWhite && row == 7 )
        {
            board[column][row] = newPiece;

        } else if ( !board[column][row].isWhite && row == 0 )
        {
            newPiece.isWhite = false;
            board[column][row] = newPiece;
        }
    }

}
