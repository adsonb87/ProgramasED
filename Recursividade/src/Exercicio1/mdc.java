package Exercicio1;

public class mdc {
	
	public static int calcularMDC(int x, int y){
		if(x%y==0){
			return y;
		}else{
			return calcularMDC(y,x%y);
		}
	}
	
	public static void main(String[] args) {
	
		
		System.out.println(calcularMDC(48,30));
	}

}
