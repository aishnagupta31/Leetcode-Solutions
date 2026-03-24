class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b) -> {
           if(a[0]!=b[0]){
            return b[0]-a[0];
           } 
           return a[1]-b[1];
        });
        List<int[]> queue=new ArrayList<>();
        for(int[] i:people){
            queue.add(i[1],i);
        }
        return queue.toArray(new int[queue.size()][]);
    }
}

// Summary (Ek line mein):

// Sabse pehle sab logon ko tallest → shortest sort karo.
// Ek empty list lo.
// Har person ko uske k value ke index par insert karte jao.
// Kyunki taller log pehle insert hue hain, chhote log insert karte time automatically sahi position par aa jaate hain.