/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode *Temp2 = (struct ListNode*)malloc(sizeof(struct ListNode));
    Temp2->next = head;
    struct ListNode *Temp = head;
    struct ListNode *Temp1 = Temp2;
    int count = 0;
    
    
    while(Temp != NULL) {
        Temp = Temp->next;
        count++;
    }
    
    
    count = count - n;
    
    
    Temp = head;
    
    
    for(int i = 0; i < count; i++) {
        Temp1 = Temp;
        Temp = Temp->next;
    }

    
    Temp1->next = Temp->next;
    free(Temp);

    
    struct ListNode *result = Temp2->next;
    free(Temp2);
    return result;
}

