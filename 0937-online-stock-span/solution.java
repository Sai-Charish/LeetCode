class StockSpanner {

    Stack<Pair> st;
    int size;
    public StockSpanner() {
        st = new Stack<>();
        size = -1;
    }
    
    public int next(int price) {
        size+=1;
        while(!st.isEmpty() && st.peek().val <= price){
            st.pop();
        }
        int ans = size - (st.isEmpty() ? -1 : st.peek().ind);
        st.push(new Pair(price,size));
        return ans;
    }

    class Pair{
        int val;
        int ind;
        public Pair(int val,int ind){
            this.val = val;
            this.ind = ind;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
