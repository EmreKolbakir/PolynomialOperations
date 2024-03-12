public class TermNode{
    int coefficient;
    int exponentX;
    int exponentY;
    int exponentZ;
    TermNode next;

    public TermNode(int coefficient, int exponentX, int exponentY, int exponentZ){
        this.coefficient = coefficient;
        this.exponentX = exponentX;
        this.exponentY = exponentY;
        this.exponentZ = exponentZ;
        this.next = null;
    }
}