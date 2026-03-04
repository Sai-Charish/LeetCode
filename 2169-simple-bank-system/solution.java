class Bank {
    long [] arr;
    int size;
    public Bank(long[] balance) {
        arr = balance;
        size = arr.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > size || account2 > size){
            return false;
        }
        if(arr[account1-1] < money) {
            return false;
        }

        this.arr[account1-1] = arr[account1-1] - money;
        this.arr[account2-1] = arr[account2-1] + money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > size){
            return false;
        }
        this.arr[account-1] = arr[account-1]+money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > size || arr[account-1] < money){
            return false;
        }

        this.arr[account-1] = arr[account-1] - money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
