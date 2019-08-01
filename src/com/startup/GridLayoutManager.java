package com.startup;

import Chess.Board;
import Chess.Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutManager extends JFrame
{
    private JButton[][] squares = new JButton[8][8];

    private boolean pieceIsSelected = false;
    private int selectedPieceRow = 0;
    private int selectedPieceCol = 0;
    private Icon selectedPieceIcon = null;

    private Icon blackRook = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackRook.png" ), 50, 50 );
    private Icon whiteRook = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whiteRook.png" ), 50, 50 );
    private Icon blackKnight = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackKnight.png" ), 50, 50 );
    private Icon whiteKnight = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whiteKnight.png" ), 50, 50 );
    private Icon blackBishop = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackBishop.png" ), 50, 50 );
    private Icon whiteBishop = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whiteBishop.png" ), 50, 50 );
    private Icon blackKing = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackKing.png" ), 50, 50 );
    private Icon whiteKing = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whiteKing.png" ), 50, 50 );
    private Icon blackQueen = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackQueen.png" ), 50, 50 );
    private Icon whiteQueen = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whiteQueen.png" ), 50, 50 );
    private Icon blackPawn = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/blackPawn.png" ), 40, 40 );
    private Icon whitePawn = resizeIcon( new ImageIcon( "/Users/boyandonchev/Documents/Programming/Java/Chess/untitled folder/whitePawn.png" ), 40, 40 );

    private Icon resizeIcon( ImageIcon icon, int resizedWidth, int resizedHeight )
    {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance( resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( resizedImage );
    }

    private Board board;

    public GridLayoutManager()
    {
        Container contents = getContentPane();
        contents.setLayout( new GridLayout( 8, 8 ) );

        ButtonHandler buttonHandler = new ButtonHandler();

        for ( int i = 0; i < 8; i++ )
        {
            for ( int j = 0; j < 8; j++ )
            {
                squares[i][j] = new JButton();
                contents.add( squares[i][j] );
                squares[i][j].addActionListener( buttonHandler );
            }
        }

        board = new Board();
        board.SetUpBoard();
        board.ShowBoard();


        squares[0][0].setIcon( whiteRook );
        squares[0][7].setIcon( whiteRook );
        squares[7][0].setIcon( blackRook );
        squares[7][7].setIcon( blackRook );

        squares[0][1].setIcon( whiteKnight );
        squares[0][6].setIcon( whiteKnight );
        squares[7][1].setIcon( blackKnight );
        squares[7][6].setIcon( blackKnight );

        squares[0][2].setIcon( whiteBishop );
        squares[0][5].setIcon( whiteBishop );
        squares[7][2].setIcon( blackBishop );
        squares[7][5].setIcon( blackBishop );

        squares[0][3].setIcon( whiteKing );
        squares[7][3].setIcon( blackKing );

        squares[0][4].setIcon( whiteQueen );
        squares[7][4].setIcon( blackQueen );

        squares[1][1].setIcon( whitePawn );
        squares[1][2].setIcon( whitePawn );
        squares[1][3].setIcon( whitePawn );
        squares[1][4].setIcon( whitePawn );
        squares[1][5].setIcon( whitePawn );
        squares[1][6].setIcon( whitePawn );
        squares[1][7].setIcon( whitePawn );
        squares[1][0].setIcon( whitePawn );

        squares[6][0].setIcon( blackPawn );
        squares[6][1].setIcon( blackPawn );
        squares[6][2].setIcon( blackPawn );
        squares[6][3].setIcon( blackPawn );
        squares[6][4].setIcon( blackPawn );
        squares[6][5].setIcon( blackPawn );
        squares[6][6].setIcon( blackPawn );
        squares[6][7].setIcon( blackPawn );

        setSize( 500, 500 );
        setResizable( false );
        setLocationRelativeTo( null );
        setVisible( true );
    }

    private boolean isValidMoove( int i, int j )
    {
        String columnInLetter= "";
        String rowInLetter="";

        String newColumnInLetter = "";
        String newRowInLetter = "";

        switch(selectedPieceCol)
        {
            case 0:
                columnInLetter = "h";
                break;
            case 1:
                columnInLetter = "g";
                break;
            case 2:
                columnInLetter = "f";
                break;
            case 3:
                columnInLetter = "e";
                break;
            case 4:
                columnInLetter = "d";
                break;
            case 5:
                columnInLetter = "c";
                break;
            case 6:
                columnInLetter = "b";
                break;
            case 7:
                columnInLetter = "a";
                break;
        }

        switch(selectedPieceRow)
        {
            case 0:
                rowInLetter = "1";
                break;
            case 1:
                rowInLetter = "2";
                break;
            case 2:
                rowInLetter = "3";
                break;
            case 3:
                rowInLetter = "4";
                break;
            case 4:
                rowInLetter = "5";
                break;
            case 5:
                rowInLetter = "6";
                break;
            case 6:
                rowInLetter = "7";
                break;
            case 7:
                rowInLetter = "8";
                break;
        }
        switch(j)
        {
            case 0:
                newColumnInLetter = "h";
                break;
            case 1:
                newColumnInLetter = "g";
                break;
            case 2:
                newColumnInLetter = "f";
                break;
            case 3:
                newColumnInLetter = "e";
                break;
            case 4:
                newColumnInLetter = "d";
                break;
            case 5:
                newColumnInLetter = "c";
                break;
            case 6:
                newColumnInLetter = "b";
                break;
            case 7:
                newColumnInLetter = "a";
                break;
        }

        switch(i)
        {
            case 0:
                newRowInLetter = "1";
                break;
            case 1:
                newRowInLetter = "2";
                break;
            case 2:
                newRowInLetter = "3";
                break;
            case 3:
                newRowInLetter = "4";
                break;
            case 4:
                newRowInLetter = "5";
                break;
            case 5:
                newRowInLetter = "6";
                break;
            case 6:
                newRowInLetter = "7";
                break;
            case 7:
                newRowInLetter = "8";
                break;
        }

        if (  board.Moove(columnInLetter.concat( rowInLetter ),newColumnInLetter.concat( newRowInLetter )))
        {
            board.ShowBoard();
            return true;
        }else
            return false;
    }

    private void processClick( int i, int j )
    {
        if ( !isValidMoove( i, j ) )
            pieceIsSelected = false;
        else
        {
            squares[selectedPieceRow][selectedPieceCol].setIcon( null );
            squares[i][j].setIcon( selectedPieceIcon );
            pieceIsSelected = false;
        }
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {

            Object source = e.getSource();

            for ( int i = 0; i < 8; i++ )
            {
                for ( int j = 0; j < 8; j++ )
                {
                    if ( source == squares[i][j] && squares[i][j].getIcon() != null && !pieceIsSelected )
                    {
                        pieceIsSelected = true;
                        selectedPieceCol = j;
                        selectedPieceRow = i;
                        selectedPieceIcon = squares[i][j].getIcon();

                    } else if ( source == squares[i][j] && pieceIsSelected )
                    {
                        processClick( i, j );
                        return;
                    }
                }
            }
        }
    }
}
