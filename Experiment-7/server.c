 #include<stdio.h>
 #include<netinet/in.h> 
#include <sys/type.h>
#include<string.h> 
#include<stdlib.h> 
#include<sys/socket.h> 
#include <sys/select.h>
#include<unistd.h>
#define MAXLINE 20 #define SERV_PORT 7134 main(int argc,char **argv) 
{ 
int i,j,maxi,maxfd,listenfd,connfd,sockfd; 
int nread,client[FD_SETSIZE]; 
ssize_t n; 
fd_set rset,allset; 
char line[MAXLINE]; 
socklen_t clilen; 
struct sockaddr_in cliaddr,servaddr;
listenfd=socket(AF_INET,SOCK_STREAM,0);
bzero(&servaddr,sizeof(servaddr)); 
servaddr.sin_family=AF_INET;
servaddr.sin_port=htons(SERV_PORT); 
bind(listenfd,(struct sockaddr *)&servaddr,sizeof(servaddr)); 
listen(listenfd,1); 
maxfd=listenfd; 
maxi=-1; 
for(i=0;i<FD_SETSIZE;i++) client[i]=-1;
FD_ZERO(&allset);
FD_SET(listenfd,&allset);