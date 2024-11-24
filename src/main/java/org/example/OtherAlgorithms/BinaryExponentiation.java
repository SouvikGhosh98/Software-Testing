package org.example.OtherAlgorithms;
public class BinaryExponentiation {
	public static long calculatePower(long x, long y) {
		if (y == 0) {
			return 1;
		}
		long val = calculatePower(x, y / 2);
		if (y % 2 == 0) {
			return val * val;
		}
		return val * val * x;
	}

	public long power(long N, long M) {
		long power = N, sum = 1;
		while (M > 0) {
			if ((M & 1) == 1) {
				sum *= power;
			}
			power = power * power;
			M = M >> 1;
		}
		return sum;
     }
}