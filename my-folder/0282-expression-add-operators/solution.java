class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, num, target, 0, 0, 0, "");
        return res;
    }

    private void backtrack(List<String> res, String num, int target,
                           int index, long eval, long prev, String path) {

        // If we consumed entire string
        if (index == num.length()) {
            if (eval == target) {
                res.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Avoid numbers with leading zero
            if (i != index && num.charAt(index) == '0') break;

            long curr = Long.parseLong(num.substring(index, i + 1));

            // First number (no operator)
            if (index == 0) {
                backtrack(res, num, target, i + 1, curr, curr, "" + curr);
            } else {
                // Addition
                backtrack(res, num, target, i + 1,
                        eval + curr, curr, path + "+" + curr);

                // Subtraction
                backtrack(res, num, target, i + 1,
                        eval - curr, -curr, path + "-" + curr);

                // Multiplication
                backtrack(res, num, target, i + 1,
                        eval - prev + prev * curr,
                        prev * curr,
                        path + "*" + curr);
            }
        }
    }
}

