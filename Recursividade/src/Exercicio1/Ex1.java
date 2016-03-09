package Exercicio1;

public class Ex1 {

	public static int subtrairNumero(int n){
		if(n>0){
			System.out.println(n);
			n=n-1;
			return subtrairNumero(n);
		}else{
			return n;
		}
	}
	
	public static void main(String[] args) {
		int n=100;
		
		subtrairNumero(n);
	}
	
}
