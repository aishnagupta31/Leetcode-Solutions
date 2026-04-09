/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct ListNode node;
node *find(node *temp,int k){
    int count =1;
    while(temp!=NULL){
        if(count==k) return temp;
        count++;
        temp=temp->next;
    }
    return temp;
}
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if(head==NULL || k==0) return head;
    node *tail=head;
    int length=1;
    while(tail->next!=NULL){
        tail=tail->next;
        length++;
    }
    if((k % length)==0) return head;
    k= k % length;

    tail->next= head;
    node *lastnode= find(head,length-k);
    head = lastnode->next;
    lastnode->next = NULL;
    return head;
}