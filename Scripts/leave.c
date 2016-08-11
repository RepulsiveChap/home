#include <stdlib.h>

int main(void){
  int status = system("i3lock -c 000000");
  int status1 = system("systemctl suspend");
  
  return 0;
}
