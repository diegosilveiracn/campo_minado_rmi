/* 
 * CampoMinado.java
 * 
 * Created on 30 de setembro de 2005, 23:10
 */
   
 /*
  * Classe que cont�m atributos e m�todos que representam o jogo de campo minado
  *
  * @author Angelina Costa / Diego Silveira / Leones Filho / Orleans Mota
  */
public class CampoMinado{
   
   /** Tamanho do tabuleiro */
   private String tabuleiro[][];
   /** Quantidade de minas */
   private Integer numeroMinas;
   /** N�mero de linhas do tabuleiro */
   private Integer numeroLinhas;
   /** N�mero de colunas do tabuleiro */
   private Integer numeroColunas;
   
   /**
    * Construtor CampoMinado
    *
    * @param Integer lin Quantidade de linhas Ex.: 3
    * @param Integer col Quantidade de colunas Ex.: 2
    * @param Integer min Quantidade de minas Ex.: 4
    */
   public CampoMinado(Integer lin, Integer col, Integer min){
      this.tabuleiro     = new String [lin.intValue()] [col.intValue()];
      this.numeroMinas   = min;
      this.numeroLinhas  = lin;
      this.numeroColunas = col;
   
      /** 
       * Inficiando a matriz com "" 
       * (Evita erro de nullPointException)
       */
      for(int i=0;i< lin.intValue();i++){
        for(int j=0;j< col.intValue();j++){
           this.tabuleiro[i][j] = new String("");
        }
      }
   }
   
   /**
    * M�todo para minar o tabuleiro aleatoriamente
    *
    */
   public void minarCampos(){
       int m = 0;
       int i; /** Conta as linhas*/
       int j; /** Conta as colunas*/
       
       while(m <= numeroMinas.intValue()){
           i = (int) (Math.random() * numeroLinhas.intValue());	   
           j = (int) (Math.random() * numeroColunas.intValue());
           
           if(tabuleiro[i][j] != "*"){
              tabuleiro[i][j] = new String("*");
              m++;
           }
       }
   }
   
   /**
    * M�todo bean getCampo
    *
    * @param Integer lin Quantidade de linhas Ex.: 3
    * @param Integer col Quantidade de colunas Ex.: 2
    * @return String tabuleiro[i][j] Valor desse campo
    */
   public String getCampo(Integer lin, Integer col){
     return this.tabuleiro[lin.intValue() - 1][col.intValue() - 1];
   }
    
   /**
    * M�todo bean setCampo
    *
    * @param Integer lin Quantidade de linhas Ex.: 3
    * @param Integer col Quantidade de colunas Ex.: 2
    * @param String val Valor que o campo receber� Ex.: 
    */
   public void setCampo(Integer lin, Integer col, String val){
      this.tabuleiro[lin.intValue() - 1][col.intValue() - 1] = val;
   }
   
   /**
    * M�todo bean getTabuleirio
    *
    * @return String [][] tabuleiro Matriz com todas as jogadas
    */
   public String [][] getTabuleiro(){
      return this.tabuleiro;
   }
   
   /**
    * M�todo bean getNumeroLinhas
    *
    * @return Integer numeroLinhas N�mero de linhas do tabuleiro Ex.: 3
    */
    public Integer getNumeroLinhas(){
       return this.numeroLinhas;
    }
    
    /**
     * M�todo bean getNumeroColunas
     *
     * @return Integer numeroColunas N�mero de colunas do tabuleiro
     */
     public Integer getNumeroColunas(){
         return this.numeroColunas;
     }
     
     
     /**
      * M�todo para contar quantas minas j� foram desvendadas
      *
      * @return Integer quantidade
      */
     public Integer contaMinasDesvendadas(){
         Integer quantidade = 0;
         for(int i=0;i <= (this.numeroLinhas.intValue() - 1 ); i++){
            for(int j=0;j <= (this.numeroColunas.intValue() - 1 ); j++){
                if(tabuleiro[i][j].equals("@")){
                   quantidade = Integer.valueOf( quantidade.intValue() + 1 );
                }
            }
         }
         return quantidade;
     }
     
     
     /**
      * M�todo bean getNumeroMinas
      *
      * @return Integer numeroColunas Quantidade de minas Ex.: 3
      */
     public Integer getNumeroMinas(){
         return this.numeroMinas;
     }
}