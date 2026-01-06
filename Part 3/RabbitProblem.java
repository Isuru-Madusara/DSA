public class RabbitProblem {

    public static int rabbitPairs(int months) {
        if (months <= 0)
            return 0;
        if (months == 1 || months == 2)
            return 1;

        int a = 1, b = 1;

        for (int i = 3; i <= months; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Month " + i + ": " + rabbitPairs(i) + " rabbit pairs");
        }
    }
}
