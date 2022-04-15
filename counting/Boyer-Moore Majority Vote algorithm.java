class Solution {
  
  //find majority element > n/2 time
    public int majorityElement(int[] nums) {
        int cnt = 0, maj = 0;
        for(int n : nums){
            
            if(cnt == 0){
                maj = n;
            }
            
            if(n == maj){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        
        return maj;
    }
  
  //find all elements that appear more than ⌊ n/3 ⌋
   public List<Integer> majorityElement(int[] nums) {
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE,  cnt1=0,cnt2=0;
        for(int n : nums){
           
           if(n == n1)cnt1++;
           else if(n == n2)cnt2++;
           else if(cnt1 == 0){
               n1 = n;
               cnt1=1;
           } 
           else if(cnt2 == 0){
               n2 = n;
               cnt2=1;
           }
           else {
               cnt1--;
               cnt2--;
           }
            
        }
        
        cnt1=0;
        cnt2=0;
        
       // System.out.println("n1="+n1+" cnt1="+cnt1+" n2="+n2+" cnt2="+cnt2);
        for(int n : nums){
            if(n == n1)cnt1++;
            if(n == n2)cnt2++;
            
        }
        List<Integer> list = new ArrayList<>();
        if(cnt1 > Math.floor(nums.length/3))list.add(n1);
        if(cnt2 > Math.floor(nums.length/3))list.add(n2);
        
        
        return list;
    }
}
