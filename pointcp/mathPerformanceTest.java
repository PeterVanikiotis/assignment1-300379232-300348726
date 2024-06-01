import java.util.function.BinaryOperator;

public class mathPerformanceTest {

    private static void test(String desc, BinaryOperator<Double> op, double a, double b, long startIter) {
        System.out.println("Running test: " + desc);
        long maxIter = startIter;
        long start;
        long elapsed;
        int loopCount = 0;
        final long MAX_ELAPSED_TIME_NS = 10_000_000; // 10 milliseconds in nanoseconds

        do {
            loopCount++;
            maxIter *= 2;
            start = System.nanoTime();
            for (long niter = 0; niter < maxIter; ++niter) {
                double res = op.apply(a, b);
            }
            elapsed = System.nanoTime() - start;
            System.out.println("Loop " + loopCount + ": elapsed time = " + elapsed + " ns");
        } while (elapsed < MAX_ELAPSED_TIME_NS && loopCount < 100); // Adjusted loop condition

        System.out.printf("%-15s/sec\t%g\n", desc, (maxIter * 1e9) / elapsed);
    }
	
    public static void main(String[] arg) {
        System.out.println("Starting performance tests...");

        test("Addition (double)", (Double a, Double b) -> a + b, 483902.7743, 42347.775, 10_000_000);
        test("Square", (Double a, Double b) -> a * a, 483902.7743, 42347.775, 10_000_000);
        test("Sine", (Double a, Double b) -> Math.sin(a), 0.5, 0, 1_000_000);
        test("Cosine", (Double a, Double b) -> Math.cos(a), 0.5, 0, 1_000_000);
        test("Arc Tangent", (Double a, Double b) -> Math.atan(a), 0.5, 0, 1_000_000);

        System.out.println("Performance tests completed.");

    }
}
