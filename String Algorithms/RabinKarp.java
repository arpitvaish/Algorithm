class Solution {
  
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("hello", "ll"));

    }
    public int strStr(String haystack, String needle) {

       
        int m = haystack.length();
        int n = needle.length();
        if(m < n)return -1;
        int prime = 101;
        long haystackHash = calculateHash(haystack, n-1, prime);
        long needleHash = calculateHash(needle, n-1, prime);

        for(int i = 1; i<= m-n+1; i++){
            if(haystackHash == needleHash && equalsCheck(haystack, i-1, i+n-2, needle, 0, n-1)){
                return i-1;
            }
            if(i < m-n+1){
                haystackHash = recalculateHash(haystack, i-1, i+n-1, haystackHash, n ,prime);
            }
        }

        return -1;

    }

    public long calculateHash(String str, int end, int prime){
        long hash= 0l;
        for(int i = 0; i <= end; i++){
            hash = (long) (hash + (str.charAt(i)* Math.pow(prime,i)));
        }

        return hash;
    }


    public boolean equalsCheck(String str, int start, int end, String str2, int start2, int end2){


        if(end-start != end2-start2)return false;

        while(start <= end && start2 <= end2){
            if(str.charAt(start) != str2.charAt(start2) )return false;
            start++;
            start2++;
        }

        return true;
    }


    public long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLen, int prime){
        long newHash = oldHash - str.charAt(oldIndex);
        newHash = newHash/prime;
        newHash += str.charAt(newIndex)*Math.pow(prime, patternLen-1);
        return newHash;
    }

}
