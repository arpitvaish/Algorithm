class Solution {
  
   public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aabaaabaaac", "aabaaac"));

    }
    public int strStr(String haystack, String needle) {

       
       

        return KMPStringSearch(haystack, needle);

    }

   public int[] createPrefixSufix(String needle){
       int[] arr = new int[needle.length()];
        int i = 0, j = i+1;
        while(j < needle.length()){
            if(needle.charAt(i) == needle.charAt(j)){
                arr[j] = i+1;
                i++;
                j++;
            }else{
                if(i != 0){
                    i = arr[i-1];
                }
                else{
                    arr[i] = 0; 
                    j++;
                }
                
            }

        }

        return arr;
   }
    
    public int KMPStringSearch(String text, String pattern){
        int[] preComputerPattern = createPrefixSufix(pattern);
        int i = 0, j = 0;
        char[] testArr = text.toCharArray();
        char[] patternArr = pattern.toCharArray();
        while(i < testArr.length && j < patternArr.length){

            if(testArr[i] == patternArr[j]){
                i++;
                j++;
            }else{
                if(j != 0){
                    j = preComputerPattern[j-1];
                }else{
                    i++;
                }


            }

            if(j == patternArr.length)return i-pattern.length();


        }

        return -1;
    }

}
