/*troca de chaves de Diffie-Hellman */

#include <stdio.h>
#include <math.h>

long long int calculaChave(int chave, int base, int mod){
	long long int t;
	t = pow(base,chave);
	t = t%mod;
	return t;
}

int main(){
int a,b,mod,base,x,y;
 // modulo e base escolhidos pelas duas pessoas
 printf("Digite o valor do modulo e da base: ");
 scanf("%d%d",&mod,&base);
 
 // primeira pessoa escolhe sua chave secreta
 printf("Digite a chave secreta da primeira pessoa: ");
 scanf("%d",&x);
 a = calculaChave(x,base,mod);
 
 // segunda pessoa escolhe sua chave secreta
 printf("Digite a chave secreta da segunda pessoa: ");
 scanf("%d",&y);
 b = calculaChave(y,base,mod);
 
 printf("A chave para a primeira pessoa é : %lld\n",calculaChave(x,b,mod));
 printf("A chave para a segunda pessoa é  : %lld\n",calculaChave(y,a,mod));
 return 0;
}
