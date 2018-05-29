/* 
 * Tabuleiro.java
 * 
 * Created on 07 de outubro de 2005, 23:30
 */
   
 /*
  * Classe que cont�m os m�todos para montar o tabuleiro na tela
  *
  * @author Angelina Costa / Diego Silveira / Leones Filho / Orleans Mota
  */
public class Tabuleiro{
   
   /** N�mero de linhas do tabuleiro */
   private Integer linhas;  
   /** N�mero de colunas do tabuleiro */
   private Integer colunas; 
   /** Matriz com que cont�m os elementos que forma o campo minado */   
   private String valTabuleiro[][];
   
   
   /**
    * Contrutor Tabuleiro
    *
    * @param Integer lin N�mero de linhas Ex.: 3
    * @param Integer col N�mero de colunas Ex.: 4
    */
   public Tabuleiro(Integer lin, Integer col){
      this.linhas       = lin;
      this.colunas      = col;
   }
         
   /**
    * M�todo que imprime o tabuleiro
    *
    * @param String[][] tab Matriz com os resultados
    * @see formataNumero()
    */
   public void imprimirTabuleiro(String[][] tab){
      this.valTabuleiro = tab; 
              
       /** Imprime a numerera��o do topo **********************************************/
       System.out.print("    ");
       for(int i=0;i <= (this.colunas - 1);i++){
          System.out.print(" "+this.formataNumero(Integer.valueOf((i+1)).toString()));
       }
       /*******************************************************************************/
       
       /**Imprime a barra do topo *****************************************************/
       for(int i=0;i <= (this.colunas - 1);i++){
          if(i==0){
            System.out.print("\n   |-");
          }
          System.out.print("---");
          if(i== (this.colunas - 1)){
            System.out.print("|");
          }
       }
       /******************************************************************************/
       
       
       for(int i=0; i <= (this.linhas - 1);i++){
          System.out.print("\n"+this.formataNumero(Integer.valueOf((i+1)).toString())+" | ");
          for(int j=0; j <= (this.colunas - 1); j++){
             if( (valTabuleiro[i][j]).equals("+") || (valTabuleiro[i][j]).equals("@") ){
                System.out.print(valTabuleiro[i][j]+"  ");
             }else{
               System.out.print("?  ");
             }
             
          }
          System.out.print("| "+this.formataNumero(Integer.valueOf((i+1)).toString()));
      }
       
       
       /**Imprime a barra da base *****************************************************/
       for(int i=0;i <= (this.colunas - 1);i++){
          if(i==0){
            System.out.print("\n   |-");
          }
          System.out.print("---");
          if(i== (this.colunas - 1)){
            System.out.print("|");
          }
       }
       /******************************************************************************/
       
       
       /** Imprime a numerera��o da base **********************************************/
       System.out.print("\n    ");
       for(int i=0;i <= (this.colunas - 1);i++){
          System.out.print(" "+this.formataNumero(Integer.valueOf((i+1)).toString()));
       }
       /******************************************************************************/
       
       System.out.println("");
   }
   
   /**
    * M�todo para formatar um n�mero
    *
    * @param String n N�mero da coluna ou da linha Ex.: 1
    * @return String saida N�mero formatado Ex.: 01
    */
   public String formataNumero(String n){
     String saida;
     
     if(n.length() == 1){
       saida = "0"+n;
     }else{
     	saida = n;
     	}
     return saida;
   }
}