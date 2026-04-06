class Solution {
    public int longestValidParentheses(String s) {
        if(s==null) return 0;
        int  max=0,open=0,close=0;
        for(char c:s.toCharArray()){
            if(c=='(') open++;
            else close++;
            if(open==close){
                int len=open+close;
                max=Math.max(max,len);
            }
            else if(close> open) open=close=0;
        }
        open=close=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='(') open++;
            else close++;
            if(open==close){
                int len=open+close;
                max=Math.max(max,len);
            }
            else if(open> close) open=close=0;
        }
        return max;
    }
}