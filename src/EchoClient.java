/* 
 * EchoServer.java
 * 
 * Created on 29 de setembro de 2005, 23:35
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.IOException;

import java.net.Socket;
/*
 * Classe que contém os métodos que serão utilizados pelo cliente
 *
 * @author Angelina Costa / Diego Silveira / Leones Filho / Orleans Mota
 */
public class EchoClient{
    
    
    /**
     * Método main()
     *
     */
    public static void main(String[] ags){
                
        String hostName = new String("localhost");
        Integer port    = new Integer("5555");
        
        /** Tamanho da linha e coluna para montar tabuleiro*/
        Integer linhas;
        Integer colunas;
        
        String [][] tabuleiro;
        
        
        try{
           Socket socket = new Socket(hostName, port.intValue());
           System.out.println("Socket = " + socket);
      
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      
           PrintStream out =  new PrintStream(socket.getOutputStream());
      
           BufferedReader userInput = new BufferedReader( new InputStreamReader(System.in));
                        
            
            /** Lendo o tamanha de linhas e colunas para monta o tabuleiro*/
            linhas  = Integer.valueOf(in.readLine());
            colunas = Integer.valueOf(in.readLine());
            
            System.out.println("");
            System.out.println(">>>> Campo Minado <<<<");
            System.out.println("");
            
            tabuleiro = new String[linhas.intValue()][colunas.intValue()];

            
            Tabuleiro tab = new Tabuleiro(linhas,colunas);
                    
           /**
            * Recebe a matriz para montar o tabuleiro
            */             
           for(int i=0;i<=2;i++){
              for(int j=0;j<=2;j++){
                 tabuleiro[i][j] = in.readLine();
              }
           }
            
           tab.imprimirTabuleiro(tabuleiro); 
           
           while (true) {
              System.out.print("\nInforme o número da linha:");
              out.println(userInput.readLine());
              System.out.print("\nInforme o número da coluna:");
              out.println(userInput.readLine());
              
              /** Lendo o resultado da jogada */
              if(in.readLine().equals("1")){
                 System.out.println("Mina encontrada. Fim do jogo!");
                 break;
              } 
                            
              /**
               * Recebe a matriz para montar o tabuleiro
               */             
              for(int i=0;i<=2;i++){
                 for(int j=0;j<=2;j++){
                    tabuleiro[i][j] = in.readLine();
                 }
              }
              
              tab.imprimirTabuleiro(tabuleiro);
              System.out.println("");
           }
         
        }catch(IOException e){
        	System.out.println(e);
        }   
    }
    
    
}