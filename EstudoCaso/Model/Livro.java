package PROJM1S7.EstudoCaso.Model;

import java.util.Date;

public class Livro {
    
    public int id;
    public String nome;
    public int paginas;
    public Date dataPublicacao;
    public boolean traduzido;
    public int numEdicao;
    //public int idAutor;
    public Autor autor;
    public Genero genero;
    public Editora editora;

}
