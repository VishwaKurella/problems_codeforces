import java.util.*;

class DijkstraPrime {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int N = S.nextInt();

        System.out.println("Primes up to " + N + ": " + sieveOfEratosthenes(N).size());
    }
    static List<Integer> sieveOfEratosthenes(int N) {
        List<Integer> result = new ArrayList<>();
        boolean[] isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
