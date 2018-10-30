package highlighters;

import pieces.Piece;
import utils.Vec;

import java.util.ArrayList;
import java.util.List;

public class StraightHL extends HighlighterBase{
    private static StraightHL ourInstance = new StraightHL();

    public static StraightHL getInstance() {
        return ourInstance;
    }

    private StraightHL() {
    }


    @Override
    List<Vec> protectKing(Piece p) {
        return null;
    }

    @Override
    List<Vec> regularHighlight(Piece p) {

        ArrayList<Vec> points = new ArrayList<>();

        for(int i = p.getX()+1; i < 8; i++){
            if(addAndBreakIfEnd(points,p,i,p.getY()))break;
        }
        for(int i = p.getX()-1; i >= 0; i--){
            if(addAndBreakIfEnd(points,p,i,p.getY()))break;
        }
        for(int i = p.getY()+1; i < 8; i++){
            if(addAndBreakIfEnd(points,p,p.getX(),i))break;
        }
        for(int i = p.getY()-1; i >= 0; i--){
            if(addAndBreakIfEnd(points,p,p.getX(),i))break;
        }

        return points;
    }

}
