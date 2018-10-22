package pieces;

import pieces.graphics.PieceNode;

public class Rook extends PieceBase {
    Rook(boolean isWhite, int x, int y) {
        super(isWhite, x, y);
        if(isWhite) {
            node = new PieceNode("Chess_rlt60.png");
        }else{
            node = new PieceNode("Chess_rdt60.png");
        }
    }
}
