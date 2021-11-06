#include<iostream>
#include<string>
using namespace std;
#define MAXLEN 100 //定义顺序表的最大长度
/**************顺序表的定义部分*****************/ 
struct DATA
{
 string key; //结点的关键字 
 string  name;
 int age;
};
struct SLType //定义顺序表结构 
{
 DATA ListData[MAXLEN+1];//保存顺序表的结构数组
 int ListLen;   //顺序表已存结点的数量 
}; 
/************顺序表的初始化函数*****************/ 
void SLInit(SLType * SL) //初始化顺序表
{
 SL->ListLen=0; 
} 
/***********计算线性表的长度*******************/
int SLLenght(SLType *SL)
{
 return(SL->ListLen); //返回顺序表的元素数量 
} 
/*********插入结点*******************************/
int SLInsert(SLType *SL,int n,DATA data)
{
 int i;
 if(SL->ListLen>=MAXLEN) //顺序表结点数量已超过最大数量
 {
  cout<<"顺序表已满，不能插入结点！"<<endl;
  return 0;   //返回0表示插入不成功 
 } 
 if(n<1||n>SL->ListLen) //插入结点的序号不合法 
 {
  cout<<"插入序号错误！"<<endl;
  return 0;
 }
 for(i=SL->ListLen;i>=n;i--) //将顺序表中的数据向后移动
 {
  SL->ListData[i+1]=SL->ListData[i];
 }
 SL->ListData[n]=data;
 SL->ListLen++;
 return 1;     //成功插入，返回1 
}
/***********************追加结点*************************/ 
int SLAdd(SLType * SL,DATA data)
{
 if(SL->ListLen>=MAXLEN)
 {
  cout<<"顺序表已满，不能再添加结点了！"<<endl;
  return 0;
 } 
 SL->ListData[++SL->ListLen]=data;
 return 1;
}
/***********************删除结点*************************/ 
int SLDelete(SLType *SL,int n) //删除顺序表中的数据元素
{
 int i;
 if(n<1||n>SL->ListLen) //删除结点的序号不合法 
 {
  cout<<"删除序号错误！"<<endl;
  return 0;
 }
 for(i=n;i<SL->ListLen;i++)//将顺序表中的数据向前移动 
 {
  SL->ListData[i]=SL->ListData[i+1]; 
 } 
 SL->ListLen--;   //顺序表元素数量减1 
 return 1;    //成功删除返回1 
} 
/*******************按照序号查找结点********************/
DATA * SLFindByNum(SLType *SL,int n)//根据序号返回数据元素
{
 if(n<1||n>SL->ListLen)   //查询结点的序号不合法 
 {
  cout<<"查询序号错误！"<<endl;
  return 0;
 }
 return &(SL->ListData[n]); 
} 
/*******************按照关键字查找结点********************/
DATA *SLFindByCont(SLType * SL,string name)//按关键字查询结点 
{
 int i;
 for(i=1;i<=SL->ListLen;i++)
 {
  if(SL->ListData[i].name==name)//如果找到结点 
  {
   return &(SL->ListData[i]);
  }
 }
 return 0;      //在整个表中都没有找到，返回0 
} 
/*******************显示所有的结点********************/
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
 SLType SL; //定义顺序表变量 
 DATA data; //定义结点保存数据类型变量 
 DATA *pdata;//定义指向结点的指针变量
 string name;
 cout<<"顺序表操作演示："<<endl;
 SLInit(&SL);//初始化顺序表
 do
 { //循环添加结点数据 
  cout<<"请输入要添加的结点（学号 姓名 年龄）：";
  cin>>data.key>>data.name>>data.age;
  if(data.age)  //若年龄不为0
  {
   if(!SLAdd(&SL,data))//若添加结点失败 
   {
    break;   //退出循环 
   }
  }else
  {
   break;
  } 
 }while(1);
 cout<<"顺序表中的结点顺序为：" <<endl;
 SLALL(&SL);    //显示所有的结点
 cout<<"请输入要取出的结点序号：";
 cin>>i;
 pdata=SLFindByNum(&SL,i);//按序号查找结点
 if(pdata)
 {
  cout<<"第"<<i<<"个结点为：key:"<<pdata->key<<",name:"<<pdata->name<<",age:"<<pdata->age<<endl;
 } 
 cout<<"请输入要查找的姓名：";
 cin>>name;
 pdata=SLFindByCont(&SL,name);
 if(pdata)
 {
  cout<<"key:"<<pdata->key<<",name:"<<pdata->name<<",age:"<<pdata->age<<endl;
 } 
 cout<<"请输入您要删除的结点的序号：";
 cin>>i;
 if(SLDelete(&SL,i))
 {
  cout<<"数据删除成功"<<endl;
  SLALL(&SL); 
 }
 cout<<"请输入您要插入的结点的序号：";
 cin>>i;
 cout<<"请输入第"<<i<<"号结点的key，name，以及age"<<endl;
 cin>>data.key>>data.name>>data.age;
 if(SLInsert(&SL,i,data))
 {
  cout<<"插入数据成功"<<endl;
  SLALL(&SL); 
 } 
 return 0;
}