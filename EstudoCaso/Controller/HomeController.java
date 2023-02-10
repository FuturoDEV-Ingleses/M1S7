package PROJM1S7.EstudoCaso.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import PROJM1S7.EstudoCaso.Model.Autor;
import PROJM1S7.EstudoCaso.Model.Editora;
import PROJM1S7.EstudoCaso.Model.Genero;
import PROJM1S7.EstudoCaso.Model.Livro;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        Scanner ler = new Scanner(System.in);
        ArrayList<Autor> listaAutor = new ArrayList<>();
        ArrayList<Genero> listaGenero = new ArrayList<>();
        Editora minhaEditora = new Editora();

        //Criar 3 Autores - Simulação de Conexão ---------------------------
        try{
            
            int count = 0;
            do{
                //System.out.print("Dados do Autor\nNome:");
                //String recebeNome = ler.nextLine();
                //System.out.print("CPF:");
                //String recebeCPF = ler.nextLine();

                count++;

                Autor novoAutor = new Autor();
                novoAutor.id = count;
                novoAutor.nome = "Autor"+count;
                novoAutor.cpf = 5*count;

                System.out.println(novoAutor.exibeInformacao());

                listaAutor.add(novoAutor);

            }while(count < 3);
        }catch(Exception ex){
            System.out.println("Erro na Conexão com Autor");
        }
        //Criar 3 Autores - Simulação de Conexão --------------------------

        //Criar 2 Generos - Simulação de Conexão --------------------------

        try{
            
            int count = 0;
            do{
                //System.out.print("Dados do Genero do Livro\nNome:");
                //String recebeNome = ler.nextLine();

                count++;

                Genero novoGenero = new Genero();
                novoGenero.id = count;
                novoGenero.nome = "Genero"+count;

                listaGenero.add(novoGenero);

            }while(count < 2);
        }catch(Exception ex){
            System.out.println("Erro na Conexão com Genero");
        }
        //Criar 2 Generos - Simulação de Conexão --------------------------

        //Criar uma Editora - - Simulação de Conexão ----------------------
        try{
            
            minhaEditora.id = 1;
            System.out.print("Dados da Editora\nNome:");
            String receberNome = ler.nextLine();
            // receberNome = Livro Mais não criar a editora.
if(permiteEditora(receberNome)){
                    minhaEditora.nome = receberNome;
                    System.out.print("CNPJ:");
                    minhaEditora.cnpj = Long.parseLong(ler.nextLine());
                }
                else{
                    System.out.println("Nome duplicado!!!");
                }

            
            }catch(Exception ex){
            System.out.println("Erro na Conexão com Editora");
        }
        
        //Criar uma Editora - - Simulação de Conexão ----------------------

        //String receberCNPJ = ler.nextLine();
        //minhaEditora.cnpj = Long.parseLong(receberCNPJ);

        //Ternario
        //String teste = count > 1 || count == 2 ? 
        //"Mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm" : 
        //"aaaaaaaaaaaaaaaaaaaaaa6";

        //Criar 1 Livro
        Livro meuLivro = new Livro();
        meuLivro.id = 1;
        meuLivro.nome = "Livro Teste";
        meuLivro.paginas = 120;
        meuLivro.dataPublicacao = new Date(11/11/2022);
        meuLivro.traduzido = true;
        meuLivro.numEdicao = 23;
        meuLivro.autor = listaAutor.get(0);
        meuLivro.genero = listaGenero.get(0);
        meuLivro.editora = minhaEditora;

        if(permiteAdicionarLivro(meuLivro)){
            //Mandaria ele pro banco
        }


        ler.close();
        return "index";
    } 

    protected boolean permiteEditora(String pNome){
        if(pNome.equals("Livro Mais") || pNome.isEmpty()){
            return false;
        }
        return true;
    }

    protected boolean permiteAdicionarLivro(Livro pLivro){
        if(!pLivro.traduzido)
            return false;
        if(pLivro.paginas > 500)
            return false;


        return true;
    }
    
}
