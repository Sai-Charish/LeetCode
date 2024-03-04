int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}
int bagOfTokensScore(int* tokens, int tokensSize, int power) {
    qsort(tokens, tokensSize, sizeof(int), compare);
    int left = 0, right = tokensSize - 1;
    int score = 0;
    int max_score = 0;

    while (left <= right) {
        if (power >= tokens[left]) {
            power -= tokens[left];
            score++;
            max_score = score > max_score ? score : max_score;
            left++;
        } else if (score > 0) {
            power += tokens[right];
            score--;
            right--;
        } else {
            break;
        }
    }

    return max_score;
}

