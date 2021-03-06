package after;

import java.util.HashMap;

abstract class ExprNode  {
    abstract void genCode();

    public ExprNode multipliedBy(int arg) {
        return MultNode.make(this, Constant.make(arg));
    }

    public ExprNode plus(int arg) {
        return AddNode.make(this, Constant.make(arg));
    }

}

class Constant extends ExprNode {
    private int value;

    private static HashMap<Integer, Constant> pool = new HashMap<>();
    private Constant(int value) {
        this.value = value;
    }

    public static ExprNode make(int val) {
        if(!pool.containsKey(val))
            pool.put(val, new Constant(val));
        return pool.get(val);
    }

    @Override
    void genCode() {
        System.out.println("iload " + value);
    }
}

class AddNode extends ExprNode {
    ExprNode left, right;

    private AddNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }

    public static ExprNode make(ExprNode left, ExprNode right) {
        return new AddNode(left, right);
    }

    @Override
    void genCode() {
        left.genCode();
        right.genCode();
        System.out.println("iadd");
    }
}

class MultNode extends ExprNode {
    ExprNode left, right;

    private MultNode(ExprNode left, ExprNode right) {
        this.left = left;
        this.right = right;
    }

    public static ExprNode make(ExprNode left, ExprNode right) {
        return new MultNode(left, right);
    }

    @Override
    void genCode() {
        left.genCode();
        right.genCode();
        System.out.println("imul");
    }
}

class CompilerMain {
    public static void main(String[] args) {
        // ((10 * 10) + 10)
        var ten = Constant.make(10);
        var tree = ten.multipliedBy(20).plus(30);
        tree.genCode();
    }
}

