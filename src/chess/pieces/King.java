package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(position.getRow(),position.getColumn());


        //below
        p.setValues(p.getRow() + 1 ,p.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below right
        p.setValues(p.getRow(),p.getColumn()+1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(p.getRow()-1,p.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //above right
        p.setValues(p.getRow()-1,p.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //above
        p.setValues(p.getRow(),p.getColumn()-1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //above left
        p.setValues(p.getRow(),p.getColumn()-1);
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(p.getRow()+1,p.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below left
        p.setValues(p.getRow()+1,p.getColumn());
        if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)) ){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }


}
