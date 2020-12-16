package after;

abstract class ExprNode  {
    abstract void genCode();
}

class CompilerMain {
    public static void main(String[] args) {
        // ((10 * 20) + 30)
        ExprNode tree = new AddNode(
            new MultNode(new Constant(10), new Constant(20)),
            new Constant(30)
        );
        tree.genCode();
    }
}
