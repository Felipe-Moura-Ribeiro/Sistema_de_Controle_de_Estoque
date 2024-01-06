package controledeestoque;
import java.util.ArrayList;
import java.util.Scanner;


public class Peca {

    private int tipo;
    private String nome;
    private int quantidade;
    public static ArrayList <Peca> pecas = new ArrayList<>();

    public void setQuantidade(int quantidade) { //Muda a quantidade da peça
        this.quantidade = quantidade;
    }
    
    public void setTipo(int tipo) {     //Muda o tipo da peça
        this.tipo = tipo;
    }

    public void setNome(String nome) {  //Muda o nome da peça
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    
    
    public Peca() {    
    }

    public static void CadastraPeca() {                     //Cadastra a peça e adiciona no Banco de dados pecas
        Scanner entrada = new Scanner(System.in);
        Peca p = new Peca();
        System.out.println("Peça:");
        System.out.println("Nome: ");
        p.nome = entrada.nextLine();
        System.out.println("Tipo: ");
        p.tipo = entrada.nextInt();
     //   if (verificaTipoDaPeca(p) != -1){
            
        System.out.println("Quantidade: ");
        p.quantidade = entrada.nextInt();
        pecas.add(p);
     //   }else{
       //     System.out.println("Tipo já existente! ");
        }
        
    
    
    public static int verificaTipoDaPeca(Peca p) {    //Verifica se o tipo já existe
        
        int tipo = -1;
        for (int i = 0; i < Peca.pecas.size(); i++) {
            if (p.getTipo() == Peca.pecas.get(i).getTipo()) {
                tipo = Peca.pecas.get(i).getTipo();
            }
        }
        
        return tipo;
    }
    
   @Override 
    public String toString() {
        return "Peça :  " + "nome=" + this.nome + ", tipo=" + this.tipo + ", quantidade=" + this.quantidade;
    }
}
