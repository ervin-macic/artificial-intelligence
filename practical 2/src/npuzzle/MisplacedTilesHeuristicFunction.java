package npuzzle;
import search.Node; 
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    public float nodeFunction(Node n) {
        Tiles s = (Tiles) n.state;
        int width = s.getWidth();
        int misplaced = 0;
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < width; col++) {
                int tile = s.getTile(row, col);
                int expected = row * width + col + 1;
                if (row == width - 1 && col == width - 1) {
                    expected = 0;
                }
                if (tile != 0 && tile != expected) {
                    misplaced++;
                }
            }
        }
        return misplaced;
    }
}

