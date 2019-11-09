package br.uem.din.ppioo.forca;

import br.uem.din.ppioo.forca.JogoForca;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vini
 */
public class Main {

    public final static void limparConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao limpar console!\nErro: ".concat(ex.getMessage().trim()), "Falha ao limpar console", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        JogoForca jogoForca = new JogoForca();
        String[] conteudo = null;
        String palavraSorteada = null;

        int opcao = 1;

        while (opcao != 0) {

            leitor = new Scanner(System.in);
            System.out.println("\n--------------------OPÇÕES---------------------");
            System.out.println("(1) Escolha O Conteudo do Jogo da Forca"
                    + "\n(2) Sortear uma Palavra"
                    + "\n(3) Falar uma Letra"
                    + "\n(4) Tentar Acertar a Palavra Inteira"
                    + "\n(0) Sair do programa");
            System.out.println("-----------------------------------------------");
            System.out.print("Digite uma opção valida: ");

            try {
                opcao = leitor.nextInt();
            } catch (InputMismatchException E) {
                opcao = -1;
            }
            limparConsole();
            switch (opcao) {
                case 0:
                    System.out.println("Saindo do Programa");
                    System.exit(0);
                case 1:
                    conteudo = jogoForca.escolhaConteudo();
                    break;
                case 2:
                    palavraSorteada = jogoForca.sortearPalavra(conteudo);
                    break;
                case 3:
                    jogoForca.acertarLetra(palavraSorteada);
                    break;
                case 4:
                    jogoForca.acertarPalavra(palavraSorteada);
                    break;
                default:
                    System.out.println("ERRO: Opção inválida.");
                    break;
            }
        }
    }
}
