class Solution {
    public long countCommas(long n) {

        long commas = 0;

        long start = 1000;
        long commaCount = 1;

        while (start <= n) {

            long end = start * 1000 - 1;

            long last = Math.min(n, end);

            commas += (last - start + 1) * commaCount;

            start *= 1000;
            commaCount++;
        }

        return commas;
    }
}