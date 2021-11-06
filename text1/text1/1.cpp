#include<iostream>
using namespace std;
typedef int datatype;
typedef struct node * pointer;
struct node {      
    datatype data;  
    pointer next;
};
typedef pointer lklist;
lklist creat(lklist head,int i){
 pointer s,rear;
 int x;
 rear=head;
 for(int j=0;j<i;j++){
  cin>>x;
  s=new node;
  s->data=x;
  rear->next=s;
  rear=s;
 }
 rear->next=NULL;
 return head;
}
lklist initlist(){
 pointer head;
 head=new node;
 head->next=NULL;
 return head;
}

void remove(lklist head){
 pointer a,b,c,s;
 for(a=head->next;a!=NULL;a=a->next){
  for(b=a,c=b->next;b->next!=NULL;){
      
   if(a->data==c->data){
   
    {
     b->next=c->next;
     c=c->next;
    }
   }
   else
   {
   b=b->next;
   c=b->next;
   }
  }
  
 }
 s=head->next;
 while(s!=NULL){
  cout<<s->data<<" ";
  s=s->next;
 }
}
int main(){
 int a;
 pointer p;
 p=initlist();
 cin>>a;
 if(a==0){
 printf("illegal length !");
 return 0;
 }
 else{
 creat(p,a);
 remove(p);
 return 0;
}


}

