public class StaticFinal {
    public static int totalCount = 0;
    public int instanceCount = 0;

    public StaticFinal() {
    }

    public static void incrementTotalCount(){
        totalCount += 1;
    }

    public void incrementInstanceCount() {
        instanceCount += 1;
    }

    @Override
    public String toString() {
        return "StaticFinal{" +
                "totalCount=" + totalCount +
                ", instanceCount=" + instanceCount +
                '}';
    }
}
