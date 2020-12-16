import java.util.Stack;

interface BYTECODES {
    public static final int ILOAD = 0x15;
    public static final int IADD = 0x60;
    public static final int IMUL = 0x68;
}

class Interpreter {
    Stack<Integer> execStack = new Stack<>();

    public Stack<Integer> getExecStack() {
        return execStack;
    }

    public void interpret(byte[] byteCodes) {
        int index = 0;
        while (index < byteCodes.length) {
            switch (byteCodes[index++]) {
                case BYTECODES.ILOAD:
                    execStack.push((int) byteCodes[index++]);
                    break;
                case BYTECODES.IADD:
                    execStack.push(execStack.pop() + execStack.pop());
                    break;
                case BYTECODES.IMUL:
                    execStack.push(execStack.pop() * execStack.pop());
                    break;
                default:
                    System.out.println("not implemented yet");
            }
        }
    }
}

public class InterpretMain {
    public static void main(String[] args) {
        // ((10 * 20) + 30)
        byte[] byteCodes = {BYTECODES.ILOAD, 10, BYTECODES.ILOAD, 20, BYTECODES.IMUL, BYTECODES.ILOAD, 30, BYTECODES.IADD};
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(byteCodes);
        System.out.println(interpreter.getExecStack().pop());
    }
}

