class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        int[] st = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            if (asteroids[i] > 0) {
                st[++top] = asteroids[i];   // push
            } else {
                while (top != -1 && st[top] > 0 && st[top] < Math.abs(asteroids[i])) {
                    top--;   // pop
                }

                if (top != -1 && st[top] == Math.abs(asteroids[i])) {
                    top--;   // both destroy
                } else if (top == -1 || st[top] < 0) {
                    st[++top] = asteroids[i];   // push negative asteroid
                }
                // else: current asteroid gets destroyed, do nothing
            }
        }

        int[] result = new int[top + 1];
        for (int i = 0; i <= top; i++) {
            result[i] = st[i];
        }

        return result;
    }
}