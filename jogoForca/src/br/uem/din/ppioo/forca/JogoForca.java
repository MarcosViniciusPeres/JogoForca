package br.uem.din.ppioo.forca;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vini
 */
public class JogoForca {
    Scanner leitor = new Scanner(System.in);
    int vida = 5;
    char[] vetorVerdadeiro = new char[10];
    int auxiliar = 0;
    int auxiliarEscolher = 0;
    List<String> vetorAuxiliar = new ArrayList();
    
    public String [] escolhaConteudo(){
        
        if(auxiliarEscolher == 0){
            auxiliarEscolher++;
            int variavelConteudo = 0;

            try {
               System.out.println("Digite [1] para escolher Animal ou Digite [2] para escolher Fruta \n");      
               variavelConteudo = leitor.nextInt();

            } catch (InputMismatchException E) {
                System.out.println("Por favor!!! Digite um valor Numérico Válido");
                return null;
            }
            
            if(variavelConteudo == 1 || variavelConteudo == 2){
                if(variavelConteudo == 1){
                    System.out.println("Conteudo Animal Foi Escolhido");
                    String[] vetorConteudo = {"leao", "macaco", "elefante", "girafa", "zebra", "hiena", "suricato", "javali", "baleia", "sucuri", "borboleta", "onça", "abelha", "anta", "boi", "cabra", "camundongo", "cachorro", "gato", "esponja", "enguia", "flamingo", "formiga", "gafanhoto", "galinha", "gnu", "harpia", "hamster", "iguana", "jararaca", "jacare", "lacraia", "morcego", "ostra", "ovelha", "panda", "pernilongo", "porco", "rinoceronte", "salamandra", "tamandua", "tartaruga", "urso", "vaca", "veado"};       
                    return vetorConteudo;
                }
                if(variavelConteudo == 2){
                    System.out.println("Conteudo Fruta Foi Escolhido");
                    String[] vetorConteudo = {"banana", "melancia", "laranja", "kiwi", "acerola", "abacate", "abacaxi", "Amora", "cacau", "pinha", "caju", "carambola", "jabuticaba", "figo", "framboesa", "goiaba", "groselha", "jaca", "limao", "mamao", "manga", "maracuja", "melao", "morango", "pera", "pessego", "pitanga", "pitaya", "roma", "tangerina", "uva"};
                    return vetorConteudo;
                } 
            }else{
                System.out.println("Por Favor Escolha Uma Das Opcoes Proposta.");      
            }
            return null;
        }else{
            System.out.println("Voce ja Escolheu um conteudo");
        }
        return null;   
    }  
    
    public String sortearPalavra(String[] conteudo){
        if(conteudo != null){
        
            String palavraEscolhida;
            
            Random gerador = new Random();
            
            palavraEscolhida = conteudo[gerador.nextInt(conteudo.length)];
            
            System.out.println("Sua Palavra Foi Sorteada com Sucesso. Bora Jogar ?");
            
            return palavraEscolhida;       
        }else{    
            System.out.println("Escolha um conteudo Primeiramente antes de sortear uma palavra.");     
        }
        return null;
    }  
    
    public void acertarPalavra(String palavra){     
        Scanner leitor = new Scanner(System.in);
        if(vida != 0){ 
            if(palavra != null){
                String palavraDigitada;

                System.out.println("Digite a Palavra a Ser Advinhada Sem Acentuação");
                palavraDigitada = leitor.next();
                
                palavraDigitada = palavraDigitada.toLowerCase();
                
                if(palavraDigitada.equals(palavra)){
                    System.out.println("Parabéns Você Venceu o Jogo Acertando a Palavra: " +palavra); 
                    System.exit(0);
                }else{
                    System.out.print("Palavra: ");
                    for(int i = 0; i < vetorVerdadeiro.length; i++){
                        System.out.print(vetorVerdadeiro[i]+" ");
                    }
                    
                    vida--;
                    System.out.println("Que pena Você Errou a Palavra a Ser Advinhada");
                    System.out.println("Agora Você Tem um Total de: "+vida+" Vidas");
                }
            }else{
                System.out.println("Sorteie uma Palavra Primeiramente para Tentar Acertar A palavra");

            }
       }else{
           System.out.println("Que pena suas Vidas Acabaram!! Recomece outro Jogo.");
           System.exit(0);
       }
    }  
    
    public void acertarLetra(String palavra){
        Scanner leitor = new Scanner(System.in);
        if(vida != 0){
            if(palavra != null){       
                if(vida == 0){
                       System.out.println("Suas vidas Chegaram em: "+vida);  
                       System.out.println("Você Perdeu O Jogo");
                       System.out.println("A palavra era: " +palavra);
                       System.exit(0);
                   }
                String letra;
                char [] vetorChar = palavra.toCharArray();
                 
                if(auxiliar < vetorChar.length){
                    for(int i = 0; i < vetorChar.length; i++){
                        vetorVerdadeiro[i] = '_';
                        auxiliar++;
                    }
                }
                System.out.println("Você tem: " +vida+" Vida(s)");                
                System.out.print("Escolha Uma Letra A Ser Adivinhada: ");
                letra = leitor.next();
                
                char letraChar = letra.charAt(0);
                
                for(int i = 0; i< vetorAuxiliar.size(); i++){
                    if(letra.equals(vetorAuxiliar.get(i))){
                        System.out.println("Você Já Usou Essa Letra, Por favor Escolha Outra");
                        return;
                    }
                }
                
                
                
                int contador = 0;
                
                
                for(int i = 0; i < vetorChar.length; i++){                
                    if(letraChar == vetorChar[i]){                  
                        vetorVerdadeiro[i] = letraChar;
                        contador++;
                        vetorAuxiliar.add(letra);
                    }     
                }
                
                for(int i = 0; i < vetorChar.length; i++){                
                    if(letraChar != vetorChar[i]){                               
                       vetorAuxiliar.add(letra);
                    }     
                }
                
                String str = new String(vetorVerdadeiro);
                
                if(palavra.equals(str.trim())){
                    System.out.println("Parabéns Voce Ganhou O Jogo!!!");
                    System.exit(0);
                }
                 
                if(contador == 0){
                    vida--;
                    System.out.println("Que Pena Nao Existe Essa Letra na Palavra.");
                    System.out.println("Agora Você Tem um Total de: "+vida+" Vidas");                   
                } 
                
                if(vida == 0){
                    System.out.println("Acabou Suas Vidas, Voce perdeu o jogo !!!");
                    System.out.println("A palavra era: " +palavra);
                    System.exit(0);
                }
                
                System.out.print("Palavra: ");
                for(int i = 0; i < vetorVerdadeiro.length; i++){
                    System.out.print(vetorVerdadeiro[i]+" ");
                }
            
            }else{
                System.out.println("Sorteie uma Palavra Primeiramente para tentar Acertar A palavra");
            }    
        }else{
            System.out.println("Que pena suas Vidas Acabaram!! Recomece outro Jogo.");
            System.exit(0);        
        }  
    }
    
}
