package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        //special move castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            // kingside rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling((posT1))){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }

            // kingside rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling((posT2))){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if(getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }

        return mat;
    }



}
