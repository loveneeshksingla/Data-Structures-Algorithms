class Solution {
	
public static int countFractions(int[] numerator, int[] denominator) {

    int n = numerator.length;
    int count = 0;

    HashMap<String, Integer> map = new HashMap<>();

    for (int i = 0; i < n; i++) {

        int num = numerator[i];
        int den = denominator[i];

        // Required fraction = 1 - num/den
        int requiredNum = den - num;
        int requiredDen = den;

        int gcd = gcd(requiredNum, requiredDen);

        requiredNum /= gcd;
        requiredDen /= gcd;

        String required = requiredNum + "/" + requiredDen;

        count += map.getOrDefault(required, 0);

        // Normalize current fraction
        gcd = gcd(num, den);

        num /= gcd;
        den /= gcd;

        String current = num + "/" + den;

        map.put(current, map.getOrDefault(current, 0) + 1);
    }

    return count;
}

private static int gcd(int a, int b) {

    while (b != 0) {
        int temp = a % b;
        a = b;
        b = temp;
    }

    return Math.abs(a);
}
	
}
