#include<iostream>
#include<string>
using namespace std;
#define MAXLEN 100 //����˳������󳤶�
/**************˳���Ķ��岿��*****************/ 
struct DATA
{
 string key; //���Ĺؼ��� 
 string  name;
 int age;
};
struct SLType //����˳���ṹ 
{
 DATA ListData[MAXLEN+1];//����˳���Ľṹ����
 int ListLen;   //˳����Ѵ�������� 
}; 
/************˳���ĳ�ʼ������*****************/ 
void SLInit(SLType * SL) //��ʼ��˳���
{
 SL->ListLen=0; 
} 
/***********�������Ա�ĳ���*******************/
int SLLenght(SLType *SL)
{
 return(SL->ListLen); //����˳����Ԫ������ 
} 
/*********������*******************************/
int SLInsert(SLType *SL,int n,DATA data)
{
 int i;
 if(SL->ListLen>=MAXLEN) //˳����������ѳ����������
 {
  cout<<"˳������������ܲ����㣡"<<endl;
  return 0;   //����0��ʾ���벻�ɹ� 
 } 
 if(n<1||n>SL->ListLen) //���������Ų��Ϸ� 
 {
  cout<<"������Ŵ���"<<endl;
  return 0;
 }
 for(i=SL->ListLen;i>=n;i--) //��˳����е���������ƶ�
 {
  SL->ListData[i+1]=SL->ListData[i];
 }
 SL->ListData[n]=data;
 SL->ListLen++;
 return 1;     //�ɹ����룬����1 
}
/***********************׷�ӽ��*************************/ 
int SLAdd(SLType * SL,DATA data)
{
 if(SL->ListLen>=MAXLEN)
 {
  cout<<"˳�����������������ӽ���ˣ�"<<endl;
  return 0;
 } 
 SL->ListData[++SL->ListLen]=data;
 return 1;
}
/***********************ɾ�����*************************/ 
int SLDelete(SLType *SL,int n) //ɾ��˳����е�����Ԫ��
{
 int i;
 if(n<1||n>SL->ListLen) //ɾ��������Ų��Ϸ� 
 {
  cout<<"ɾ����Ŵ���"<<endl;
  return 0;
 }
 for(i=n;i<SL->ListLen;i++)//��˳����е�������ǰ�ƶ� 
 {
  SL->ListData[i]=SL->ListData[i+1]; 
 } 
 SL->ListLen--;   //˳���Ԫ��������1 
 return 1;    //�ɹ�ɾ������1 
} 
/*******************������Ų��ҽ��********************/
DATA * SLFindByNum(SLType *SL,int n)//������ŷ�������Ԫ��
{
 if(n<1||n>SL->ListLen)   //��ѯ������Ų��Ϸ� 
 {
  cout<<"��ѯ��Ŵ���"<<endl;
  return 0;
 }
 return &(SL->ListData[n]); 
} 
/*******************���չؼ��ֲ��ҽ��********************/
DATA *SLFindByCont(SLType * SL,string name)//���ؼ��ֲ�ѯ��� 
{
 int i;
 for(i=1;i<=SL->ListLen;i++)
 {
  if(SL->ListData[i].name==name)//����ҵ���� 
  {
   return &(SL->ListData[i]);
  }
 }
 return 0;      //���������ж�û���ҵ�������0 
} 
/*******************��ʾ���еĽ��********************/
void SLALL(SLType *SL)
{
 int i;
 for(i=1;i<=SL->ListLen;i++)
 {
  cout<<"key:"<<SL->ListData[i].key<<",name:"<<SL->ListData[i].name<<",age:"<<SL->ListData[i].age<<endl;
 }
} 
int main()
{
 int i;
 SLType SL; //����˳������ 
 DATA data; //�����㱣���������ͱ��� 
 DATA *pdata;//����ָ�����ָ�����
 string name;
 cout<<"˳��������ʾ��"<<endl;
 SLInit(&SL);//��ʼ��˳���
 do
 { //ѭ����ӽ������ 
  cout<<"������Ҫ��ӵĽ�㣨ѧ�� ���� ���䣩��";
  cin>>data.key>>data.name>>data.age;
  if(data.age)  //�����䲻Ϊ0
  {
   if(!SLAdd(&SL,data))//����ӽ��ʧ�� 
   {
    break;   //�˳�ѭ�� 
   }
  }else
  {
   break;
  } 
 }while(1);
 cout<<"˳����еĽ��˳��Ϊ��" <<endl;
 SLALL(&SL);    //��ʾ���еĽ��
 cout<<"������Ҫȡ���Ľ����ţ�";
 cin>>i;
 pdata=SLFindByNum(&SL,i);//����Ų��ҽ��
 if(pdata)
 {
  cout<<"��"<<i<<"�����Ϊ��key:"<<pdata->key<<",name:"<<pdata->name<<",age:"<<pdata->age<<endl;
 } 
 cout<<"������Ҫ���ҵ�������";
 cin>>name;
 pdata=SLFindByCont(&SL,name);
 if(pdata)
 {
  cout<<"key:"<<pdata->key<<",name:"<<pdata->name<<",age:"<<pdata->age<<endl;
 } 
 cout<<"��������Ҫɾ���Ľ�����ţ�";
 cin>>i;
 if(SLDelete(&SL,i))
 {
  cout<<"����ɾ���ɹ�"<<endl;
  SLALL(&SL); 
 }
 cout<<"��������Ҫ����Ľ�����ţ�";
 cin>>i;
 cout<<"�������"<<i<<"�Ž���key��name���Լ�age"<<endl;
 cin>>data.key>>data.name>>data.age;
 if(SLInsert(&SL,i,data))
 {
  cout<<"�������ݳɹ�"<<endl;
  SLALL(&SL); 
 } 
 return 0;
}