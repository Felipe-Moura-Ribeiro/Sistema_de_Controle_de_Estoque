package controledeestoque;
import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {

    private String nome;
    private ArrayList<Filial> Filiais;

    public Empresa(String nome) {
        this.nome = nome;
        this.Filiais = new ArrayList();
    }

    public Empresa() {
        this.Filiais = new ArrayList<>();

    }

    public ArrayList<Filial> getFiliais() {
        return Filiais;
    }

    public void addFilial(Filial filiais) {
        this.Filiais.add(filiais);
    }

    public void CadastraFilial(Empresa e1) {    //Cadastra filial
        Scanner entrada = new Scanner(System.in);

        System.out.println("Filial");
        System.out.println("Nome: ");
        Filial f = new Filial(entrada.nextLine());
        if (verificaNomeFiliais(e1, f)) {
            System.out.println("Já existe esta filial");
        } else {
            Filiais.add(f);
        }
    }

    public static boolean verificaNomeFiliais(Empresa e, Filial f) {  //Verifica se já existe o nome digitado das filiais
        for (int i = 0; i < e.getFiliais().size(); i++) {
            if (f.getNome().equals(e.getFiliais().get(i).getNome())) {
                return true;
            }
        }
        return false;
    }

    public void Insercao(Empresa e1) {
        Scanner entrada = new Scanner(System.in);
        Filial FilialAuxiliar = new Filial(); // Filial temporária para armazenar as informações
        Peca PeçaAuxiliar = new Peca();       // Peça temporária para armazenar as informações
        System.out.println("Qual filial deseja inserir a peça? ");
        FilialAuxiliar.setNome(entrada.nextLine());
        if (encontraIndiceFilial(FilialAuxiliar.getNome(),e1) == -1) {
            System.out.println("Filial Nao encontrada");
        } else {
            System.out.println("Qual tipo de peça deseja inserir a filial? ");
            PeçaAuxiliar.setTipo(entrada.nextInt());
            if (PeçaAuxiliar.verificaTipoDaPeca(PeçaAuxiliar) != -1) {
                Filiais.get(encontraIndiceFilial(FilialAuxiliar.getNome(),e1)).inserçãoPeca(e1,PeçaAuxiliar.getTipo());
            } else {
                System.out.println("Essa peça não existe! ");
            }

        }
    }

    public void listagemfiliais() {
        System.out.println("============  Filiais  ==========");
        for (int i = 0; i < Filiais.size(); i++) {
            Filiais.get(i).listagemPeças(Filiais.get(i));
        }
        System.out.println("================================");
    }


    public static void Retirada(Empresa e1) {        //Retira as peças
        Scanner entrada = new Scanner(System.in);
        Filial FilialAuxiliar = new Filial();       // Filial temporária para armazenar as informações da filial (Nome)
        Peca PeçaAuxiliar = new Peca();             // Peça temporária para armazenar as informações da peça (Tipo)
        int qtdeRetirada;                           // Variável que controla a quantidade recebida pelo teclado
        System.out.println("Qual tipo de peça deseja retirar?");
        PeçaAuxiliar.setTipo(entrada.nextInt());
        System.out.println("Qual filial deseja retirar a peça: " + PeçaAuxiliar.getNome() + "?");
        FilialAuxiliar.setNome(entrada.nextLine());
        System.out.println("Qual a quantidade de peça deseja retirar?");
        qtdeRetirada = entrada.nextInt();
        e1.getFiliais().get(encontraIndiceFilial(FilialAuxiliar.getNome(),e1)).reduzQuantPecas(PeçaAuxiliar.getTipo(), qtdeRetirada);

    }

    public void Transferência(Empresa e1) { //Filial origem é de onde as peças irão ser retiradas e a destino é pra onde elas vão
        Scanner entrada = new Scanner(System.in);
        int tipoEscolhido;
        Peca PeçaAuxiliar = new Peca();  //Peça a qual será transferida da origem para o destino
        Filial origem = new Filial();     //Filial da qual a peça vai ser retirada
        Filial destino = new Filial();    //Filial da qual a peça vai ser colocada
        System.out.println("De qual filial deseja transferir?");
        origem.setNome(entrada.nextLine());

        if (e1.encontraIndiceFilial(origem.getNome(),e1) == -1) {    //If para verificar se existe a Filial escrita
            System.out.println("NAO EXISTE ESSA FILIAL!");
        } else {
            System.out.println("Para qual filial deseja transferir?");
            destino.setNome(entrada.nextLine());
            if (e1.encontraIndiceFilial(destino.getNome(),e1) == -1) {  //If para verificar se existe a Filial escrita
                System.out.println("Não existe essa filial!");
            } else {
                System.out.println("Qual tipo de peça deseja transferir?");
                tipoEscolhido = entrada.nextInt();
                System.out.println("Qual a quantidade de peça deseja transferir?");
                int qtde = entrada.nextInt();
                e1.getFiliais().get(encontraIndiceFilial(origem.getNome(),e1)).reduzQuantPecas(PeçaAuxiliar.getTipo(), qtde);   //Retira a quantidade da peça da origem
                e1.getFiliais().get(encontraIndiceFilial(destino.getNome(),e1)).aumentaQuantPecas(PeçaAuxiliar.getTipo(), qtde);    //Adiciona a quantidade na peça do destino       
            }

        }
    }

    public Filial encontraFilial(String nome) {
        System.out.println(" ");
        Filial encontrada = new Filial("");
        for (int i = 0; i < Filiais.size(); i++) {
            if (Filiais.get(i).getNome().equals(nome)) {
                encontrada = Filiais.get(i);
                System.out.println(Filiais.get(i).getNome());
            }
        }
        return encontrada;
    }

    public static int encontraIndiceFilial(String nome,Empresa e1) {
        System.out.println(" ");
        int indice = -1;
        Filial encontrada = new Filial("");
        for (int i = 0; i < e1.Filiais.size(); i++) {
            if (e1.Filiais.get(i).getNome().equals(nome)) {
                encontrada = e1.Filiais.get(i);
                indice = i;
                System.out.println(e1.Filiais.get(i).getNome());
            }
        }
        return indice;
    }
}
