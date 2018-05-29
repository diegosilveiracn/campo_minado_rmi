/* 
 * EchoServer.java
 * 
 * Created on 29 de setembro de 2005, 23:10
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
/*
 * Classe que contém os métodos que serão utilizados pelo servidor
 *
 * @author Angelina Costa / Diego Silveira / Leones Filho / Orleans Mota
 */
public class EchoServer{
    
    
    /**
     * Método Main()
     *
     */
    public static void main(String[] args){
       try{
          
          CampoMinado cMinado = new CampoMinado(3,3,2);
          cMinado.minarCampos();
          
          Integer linhaJogada;
          Integer colunaJogada;
          
          ServerSocket server = new ServerSocket(5555);
          System.out.println("Servidor ativo"+server);
          
          Socket socket = server.accept();
          System.out.println("Ligação aceita:"+socket);
          
          PrintStream out = new PrintStream(socket.getOutputStream());
          
          BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
          
           /** Informa ao cliente o número de linhas e colunas ***/
           out.println(cMinado.getNumeroLinhas());
           out.println(cMinado.getNumeroColunas());
           /******************************************************/
       
          
           /**
            * Envia a matriz para montar o tabuleiro
            */ 
          for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
               out.println(cMinado.getCampo(i,j));
            }
          }
          
          while(true) {

             linhaJogada  = Integer.valueOf(in.readLine());
             colunaJogada = Integer.valueOf(in.readLine());
          
             if( cMinado.getCampo(linhaJogada,colunaJogada).equals("*")){
                    /** 
                     * Marca @ na matriz, conforme linha e coluna para informar que
                     * alguém pisou na mina 
                     */
                    cMinado.setCampo(linhaJogada,colunaJogada,"@"); 
                    /** Informa que a pessoa encontrou uma mina e que está fora do jodo*/
                    out.println("1"); 
             }else if( cMinado.getCampo(linhaJogada,colunaJogada).equals("") ){
                      /** 
                       * Marca + na matriz, conforme linha e coluna para informar que
                       * alguém não pisou na mina 
                       */
                       cMinado.setCampo(linhaJogada,colunaJogada,"+"); 
                       /** Informa que a pessoa não encontrou uma mina e que está continuará o jodo*/
                       out.println("2");
                   }
          
          
            /**
             * Envia a matriz para montar o tabuleiro
             */ 
            for(int i=1;i<=3;i++){
               for(int j=1;j<=3;j++){
                  out.println(cMinado.getCampo(i,j));
               }
            }
          }
       }catch(IOException e){
       
       }
       
    }
}