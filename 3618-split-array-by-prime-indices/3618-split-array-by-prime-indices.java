class Solution {
    public boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public long splitArray(int[] nums) {
        int n = nums.length;
        long prime = 0, notPrime = 0;

        for(int i = 0; i < n;i++){
            if(isPrime(i)){
                prime += nums[i];
            }else{
                notPrime += nums[i];
            }
        }
        return (long)Math.abs(prime-notPrime);
    }
}