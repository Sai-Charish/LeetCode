class Solution {
    public int chalkReplacer(int[] chalk, int k) {
       long sum = 0;
       int n = chalk.length;

       System.out.println(n);

       for(int i=0;i<n;i+=1)
       {
            sum+=chalk[i];
       }
        
        System.out.println(sum);

        int div = (int) (k % sum);
        
        System.out.println(div);
       for(int i=0;i<n;i+=1)
       {
            if(chalk[i] > div)
            {
                return i;
            }
            div = div - chalk[i];
       }

       return -1;

    }
}
