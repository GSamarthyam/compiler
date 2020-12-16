package after;

public class MultNode extends ExprNode {
    ExprNode left, right;

    public MultNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    void genCode() {
        left.genCode();
        right.genCode();
        System.out.println("imul");
    }
}
