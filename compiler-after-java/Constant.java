package after;

public class Constant extends ExprNode {
    private int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    void genCode() {
        System.out.println("iload " + value);
    }
}
