
public class Perceptron {
	/* 
	   00 - BACH,  01 - BEETHOVEN,  10 - EINSTEIN,  11 - KEPLER
	   0 - COMPOSITOR (BACH, BEETHOVEN) e  1 - CIENTISTA (EINSTEIN, KEPLER)

	 */
	
	private int W[] = new int[3];
	private int bias=1; //valor positivo
	private int entradas[][]= new int [4][4];
	private int somatorio;
	private int erro;
	private int aprendizagem=1;
	
	//construtor
	Perceptron(int n1,int n2)
	{
		W[0]=0; //bias
		W[1]=0;
		W[2]=0;
		
		/* Matriz de Entradas: valor de entrada + valor esperado
		   BACH 000, BEETHOVEN 010, EINSTEIN 101, KEPLER 111 */ 
	
		//BACH
		this.entradas[0][0]=0;
		this.entradas[0][1]=0;
		this.entradas[0][2]=0; //valor esperado na coluna 2.
		
		//BEETHOVEN
		this.entradas[1][0]=0;
		this.entradas[1][1]=1;
		this.entradas[1][2]=0;  //valor esperado na coluna 2.
		
		//EINSTEIN
		this.entradas[2][0]=1;
		this.entradas[2][1]=0;
		this.entradas[2][2]=1; //valor esperado na coluna 2.
		
		//KEPLER
		this.entradas[3][0]=1;
		this.entradas[3][1]=1;
		this.entradas[3][2]=1; //valor esperado na coluna 2.
		
		
	}
	
	public int fazSomatorio(int n1,int n2){
		somatorio = (bias*W[0])+(n1*W[1])+(n2*W[2]);
		
		//ativação
		if(somatorio>=0){
			return 1;
		}else{
			return 0;
		}
		
		
		
	}
	
	public void novoPeso(int i, int erro){
		
	 //PESO NOVO = PESO ANTERIOR + (ERRO*APRENDIZAGEM*ENTRADA);
		  W[0] = W[0] + (erro * aprendizagem * bias);
		  W[1] = W[1] + (erro * aprendizagem * entradas[i][0]);
		  W[2] = W[2] + (erro * aprendizagem * entradas[i][1]);
	     
	 
		
	      System.out.println("\n");
	      System.out.println("-> PESOS RECALCULADOS => BIAS:"+W[0]+" e ENTRADA I: "+W[1]+"- ENTRADA II: "+W[2]);
	
	}
	
	public void treinaRede(){
		
    
        int saida;
        
        System.out.println("==== TREINANDO REDE ====\n");
      
        for (int i = 0; i < 4; i++) {
           saida = fazSomatorio(entradas[i][0],entradas[i][1]);
           erro=entradas[i][2]-saida; //erro = valor esperado - valor obtido
 
 
            if (erro != 0) {
            	System.out.println("--> RECALCULANDO PESOS");
            	novoPeso(i,erro);
            } else{
            	System.out.println("--> VALOR DESEJADO ENCONTRADO.");
            }
        }
               
        	if((entradas[0][2]== 0)&&(entradas[1][2]==0)&&(entradas[2][2]==1)&&(entradas[3][2]==1)){
        		System.out.println("[REDE TREINADA]");
        		System.out.println("00 - BACH: "+entradas[0][2]);
        		System.out.println("01 - BEETHOVEN:"+entradas[1][2]);
        		System.out.println("10 - EINSTEIN: "+entradas[2][2]);
        		System.out.println("11 - KEPLER"+entradas[3][2]);
        		
        		System.out.println("\n");
        		System.out.println("PESO FINAL - ENTRADA I = "+W[1]);
        		System.out.println("PESO FINAL - ENTRADA II ="+W[2]);
        		System.out.println("PESO FINAL - BIAS = "+W[0]);
        		
        	}else{
        		treinaRede();
        	}
        
   	}
	
	
	

}
