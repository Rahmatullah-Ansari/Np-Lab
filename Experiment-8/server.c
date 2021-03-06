#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <string.h>//unix tcp server int main() {
 int sock, connected, bytes_recieved , true = 1; 
char send_data [1024]={"Hello User!!"} , recv_data[1024]; 
struct sockaddr_in server_addr,client_addr; 
int sin_size; 
if ((sock = socket(AF_INET, SOCK_STREAM, 0)) == -1) 
{ 
perror("Socket"); 
exit(1); 
} 
if(setsockopt(sock,SOL_SOCKET,SO_REUSEADDR,&true,sizeof(int)) == -1) 
{ 
perror("Setsockopt"); 
exit(1); 
} 
server_addr.sin_family = AF_INET; server_addr.sin_port = htons(5000);
server_addr.sin_addr.s_addr = INADDR_ANY;
bzero(&(server_addr.sin_zero),8); 
if (bind(sock, (struct sockaddr *)&server_addr, sizeof(struct sockaddr)) == -1) 
{
perror("Unable to bind"); exit(1); 
} 
if (listen(sock, 5) == -1) 
{
perror("Listen"); 
exit(1); 
} 
printf("\nTCPServer Waiting for client on port 5000"); 
fflush(stdout); 
sin_size = sizeof(struct sockaddr_in); 
connected = accept(sock, (struct sockaddr *)&client_addr,&sin_size);
printf("\n I got a connection from (%s , %d)\n", inet_ntoa(client_addr.sin_addr),ntohs(client_addr.sin_port)); 
send(connected, send_data,strlen(send_data), 0); 
close(connected);
close(sock); 
return 0; 
} 