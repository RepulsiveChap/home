#include <stdlib.h>

void main(){
  int status = system("i3locknew -c 000000");
  int status1 = system("systemctl suspend");
}
