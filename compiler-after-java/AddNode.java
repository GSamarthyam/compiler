package after;

public class AddNode extends ExprNode {
    ExprNode left, right;

    public AddNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    void genCode() {
        left.genCode();
        right.genCode();
        System.out.println("iadd");
    }
}
