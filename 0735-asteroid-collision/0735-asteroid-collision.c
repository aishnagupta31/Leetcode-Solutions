/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void push(int st[], int *top, int r){
    st[++(*top)]=r;
}
int pop(int st[],int *top){
    return st[(*top)--];
}
int* asteroidCollision(int* asteroids, int asteroidsSize, int* returnSize) {
    int n= asteroidsSize;
    int top=-1;
    int *st = (int *)malloc(n * sizeof(int));
    for(int i=0;i<n;i++){
        if(asteroids[i]>0){
            push(st,&top,asteroids[i]);
        }
        else{
            while(top!= -1 && st[top] > 0 && st[top] < abs(asteroids[i])){
                pop(st,&top);
            }
            if(top!=-1 && st[top]==abs(asteroids[i])){
                pop(st,&top);
            }
            else if(top==-1 || st[top]<0){
                push(st,&top,asteroids[i]);
            }
            else{
                continue;
            }
        }
    }
    *returnSize= top+1;
    return st;
}