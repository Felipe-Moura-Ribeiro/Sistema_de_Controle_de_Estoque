package controledeestoque;

import java.util.ArrayList;
import java.util.Scanner;

public class Filial {

    private String nome;
    ArrayList<Peca> Peças;

    public Filial(String nome) {
        this.nome = nome;
        this.Peças = new ArrayList<>();
    }
    
    public Filial(){
        this.Peças = new ArrayList();
    }

    public ArrayList<Peca> getPecas() {
        return Peças;
    }

    public void setPecas(ArrayList<Peca> peças) {
        this.Peças = peças;
    }

    public String getNome() {
        return nome;
    }

    public void addPeça(Peca c) {
        Peças.add(c);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void aumentaQtdDePecas(int tipo){        //Add 1 unidade para a peça cujo tipo é igual ao parâmetro
       for(int i = 0; i < this.Peças.size(); i++){
           if(this.Peças.get(i).getTipo() == tipo){
               this.Peças.get(i).setQuantidade(this.Peças.get(i).getQuantidade() + 1);
           }
       }
    }
    
    public void reduzQuantPecas(int tipo){          //Retira 1 unidade para a peça cujo tipo é igual ao parâmetro
       for(int i = 0; i < this.Peças.size(); i++){
           if(this.Peças.get(i).getTipo() == tipo){
               this.Peças.get(i).setQuantidade(this.Peças.get(i).getQuantidade() - 1);
           }
       }
    }
    
        public void aumentaQuantPecas(int tipo,int quantidadeAumenta){     //Aumenta a qtde da peça de acordo com o parâmetro
       for(int i = 0; i < this.Peças.size(); i++){
           if(this.Peças.get(i).getTipo() == tipo){
               this.Peças.get(i).setQuantidade(this.Peças.get(i).getQuantidade() + quantidadeAumenta);
           }
       }
    }
    
    public void reduzQuantPecas(int tipo, int quantidadeReduz){     ////Reduz a qtde da peça de acordo com o parâmetro
       for(int i = 0; i < this.Peças.size(); i++){
           if(this.Peças.get(i).getTipo() == tipo){
               this.Peças.get(i).setQuantidade(this.Peças.get(i).getQuantidade() - quantidadeReduz);
           }
       }
    }
    
    
    public void inserçãoPeca(Empresa e1,int tipo) {                //Insere a peça
        
        if (encontraIndicePeça(tipo) == -1) {
            this.Peças.add(Peca.pecas.get(encontraIndicePeçaBancoDeDados(tipo)));

        } else {
            System.out.println("Indice da Peça: " + encontraIndicePeça(tipo));
            this.Peças.get(encontraIndicePeça(tipo)).setQuantidade((Peças.get(encontraIndicePeça(tipo)).getQuantidade() + 1));
        }
 
    }

    public void listagemPeças(Filial f) {       //Lista as peças da filial f
        System.out.println("---- Peças de  " + f.getNome()+"----");
        // System.out.println("Pecas:");
        for (int i = 0; i < this.Peças.size(); i++) {
            System.out.println("");
            System.out.println(this.Peças.get(i).getNome() + " -  Tipo " + this.Peças.get(i).getTipo() + " -  Quantidade " + this.Peças.get(i).getQuantidade());

        }
    }

    public ArrayList<Peca> getPeças() {
        return Peças;
    }



        
    /*

    public void Retirada(int tipoEscolhido) {
        Scanner entrada = new Scanner(System.in);
        int qtdeRetirada;
        System.out.println("Qual a quantidade de peça deseja retirar?");
        qtdeRetirada = entrada.nextInt();

        for (int i = 0; i < Peças.size(); i++) {
            if (Peças.get(i).getTipo() == tipoEscolhido) {
                System.out.println("Nome da peça encontrado: " + Peças.get(i).getNome());
           //     Peças.get(i).RetirarQuantidade(Peças.get(i).getQuantidade(), qtdeRetirada);
            }

        }
    }
*/
    public Peca encontraPeça(int tipo) {
        System.out.println(" ");
        Peca encontrada = new Peca();
        for (int i = 0; i < Peças.size(); i++) {
            if (Peças.get(i).getNome().equals(nome)) {
                encontrada = Peças.get(i);
                System.out.println(Peças.get(i).getNome());
            }
        }
        return encontrada;
    }

    
    public int encontraIndicePeça(int tipo) {     //Encontra o índice da peça do ArrayList e retorna 
        System.out.println(" ");
        int indice = -1;
        Peca encontrada = new Peca();
        for (int i = 0; i < Peças.size(); i++) {
            if (Peças.get(i).getTipo() == tipo) {
                // encontrada=Peças.get(i);
                indice = i;
                System.out.println(Peças.get(i).getNome());
            }
        }
        return indice;
    }

    public int encontraIndicePeçaBancoDeDados(int tipo) {     //Encontra o índice da peça do Banco de Dados e retorna
        System.out.println(" ");        //Variável que retorna o indice da peça
        int indice = -1;
        Peca encontrada = new Peca();
        for (int i = 0; i < Peca.pecas.size(); i++) {
            if (Peca.pecas.get(i).getTipo() == tipo) {
                //encontrada=Peças.get(i);
                indice = i;
                System.out.println(Peca.pecas.get(i).getNome());
            }
        }
        return indice;
    }

    @Override
    public String toString() {
        return "Filial{" + "nome=" + nome;
    }
}
