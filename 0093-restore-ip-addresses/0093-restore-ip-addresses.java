class Solution {
    List<String> res = new ArrayList<>();
    int n;

    public boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        int num = Integer.parseInt(part);
        return num <= 255;
    }

    public void solve(int ind, String s, int parts, StringBuilder sb) {
        if (ind == n && parts == 4) {
            res.add(sb.substring(0, sb.length() - 1)); // remove last dot in answer
            return;
        }

        if (parts >= 4) return;

        for (int len = 1; len <= 3; len++) {
            if (ind + len <= n) {
                String part = s.substring(ind, ind + len);

                if (isValid(part)) {
                    int oldLen = sb.length();   // save old state

                    sb.append(part);
                    sb.append(".");

                    solve(ind + len, s, parts + 1, sb);

                    sb.setLength(oldLen);   // BACKTRACK (undo)
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        if (n < 4 || n > 12) return res;

        solve(0, s, 0, new StringBuilder());
        return res;
    }
}

// why in stringbuilder backtracking step is visible?

// Because StringBuilder mutable hota hai, aur same object sab recursive calls share karte hain.
// Isliye jab ek call append() karta hai, woh change parent + child dono ko same object me dikh raha hota hai — so return ke baad hume undo karna padta hai (setLength(oldLen) / delete(...)).
// Isi undo step ko hi tum visible backtracking bol rahi ho 👀✨