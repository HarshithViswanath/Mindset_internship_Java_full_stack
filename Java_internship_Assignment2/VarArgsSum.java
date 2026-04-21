public class VarArgsSum {

    static int sum(int... nums) {
        int total = 0;
        for (int n : nums)
            total += n;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(10, 20, 30));
    }
}
