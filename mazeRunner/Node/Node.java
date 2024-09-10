package Node;

public class Node {
        public int row;
        public int column;
        public int steps=0;
        public Node previNode;
        public Node(int row,int column,int steps,Node previNode){
            this.row = row;
            this.column = column;
            this.steps = steps;
            this.previNode = previNode;
        }
}
