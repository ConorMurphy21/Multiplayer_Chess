package pieces;

import pieces.graphics.PieceNode;

public class Bishop extends PieceBase {
    Bishop(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
        if(isWhite) {
            node = new PieceNode("Chess_blt60.png");
        }else{
            node = new PieceNode("Chess_bdt60.png");
        }
    }
}
