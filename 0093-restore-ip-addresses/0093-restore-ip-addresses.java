class Solution {
    int n;
    List<String> res;

    public boolean isValid(String str) {
        // Leading zero check
        if (str.charAt(0) == '0') return false;

        int num = Integer.parseInt(str);
        return num >= 0 && num <= 255;
    }

    public void solve(int ind, String s, int parts, String curr) {
        // Base case: exactly 4 parts and string completely used
        if (ind == n && parts == 4) {
            res.add(curr.substring(0, curr.length() - 1)); // remove last dot
            return;
        }

        // Invalid case: more than 4 parts or string ended early
        if (parts > 4) return;

        // Take 1 digit
        if (ind + 1 <= n) {
            solve(ind + 1, s, parts + 1, curr + s.substring(ind, ind + 1) + ".");
        }

        // Take 2 digits
        if (ind + 2 <= n) {
            String part = s.substring(ind, ind + 2);
            if (isValid(part)) {
                solve(ind + 2, s, parts + 1, curr + part + ".");
            }
        }

        // Take 3 digits
        if (ind + 3 <= n) {
            String part = s.substring(ind, ind + 3);
            if (isValid(part)) {
                solve(ind + 3, s, parts + 1, curr + part + ".");
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        res = new ArrayList<>();

        // IP address can have minimum 4 digits and maximum 12 digits
        if (n < 4 || n > 12) return res;

        solve(0, s, 0, "");
        return res;
    }
}
// why backtracking step is not visible ? 

// Tumhare current code me:

// curr me se string manually remove nahi hoti, because har recursive call ko ek nayi string milti hai (curr + part + "."), aur jab call return hota hai to child wali string destroy ho jaati hai. Parent wali curr waise hi rehti hai.