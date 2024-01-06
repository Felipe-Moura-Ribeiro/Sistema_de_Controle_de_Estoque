package controledeestoque;
import java.util.Scanner;   //Felipe Moura Ribeiro e Juliana da Silva Leite

public class ControledeEstoque {

    public static void main(String[] args) {
        
       Scanner entrada = new Scanner(System.in);
        Filial f1 = new Filial("Filial_Teste");
        Peca p1 = new Peca();
        Empresa e1 = new Empresa("Empresa1");
        
        int sair=0; //variável que controla se a escolha é sair ou não        
        do{
        System.out.println("Controle de Estoque");
        System.out.println(" 1- Cadastro de Peça");
        System.out.println(" 2- Cadastro de Filial");
        System.out.println(" 3- Inserção:");
        System.out.println(" 4- Retirada:");
        System.out.println(" 5- Transferência");
        System.out.println(" 6- Listagem");
        System.out.println(" 7- Sair");
        
        
        int escolha = entrada.nextInt();

        switch (escolha) {
            
            case 1:
               Peca.CadastraPeca();
               sair=0;
                break;

            case 2:
               e1.CadastraFilial(e1);
                sair=0;
                break;
 
            case 3:
                e1.Insercao(e1);
                sair=0;
                break;
            
            case 4:
                e1.Retirada(e1);
                sair=0;
                break;
            
            case 5:               
                e1.Transferência(e1);
                sair=0;
                break;
            
            case 6:
                e1.listagemfiliais();             
                sair=0;
                break;
                
            case 7:
                sair=1;
        }
        }while(sair==0);
    }
        
    }
    
