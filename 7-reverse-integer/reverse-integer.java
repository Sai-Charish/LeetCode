class Solution {
    public int reverse(int x) {
        boolean neg = (x>0) ? false : true;

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        if(neg)
        {
            x = Math.abs(x);
        }

        long res = 0;
        int temp = x;
        int digit;
        
        while(temp > 0)
        {
            digit = temp % 10;
            res = (res * 10 ) + digit ;
            temp = temp /10;
        }

        if(neg)
        {
            res = res * -1;
        }

        // System.out.println(res);

        return (res<= max && res>=min) ? (int) res : 0;



      

    }
}