package PROJM1S7.EstudoCaso.Model;

public class Autor {
    public int id;
    public String nome;
    public long cpf;


    public String exibeInformacao(){
        return "ID: "+ id + "\nNOME: " + nome + "\nCPF: " + cpf;
    }

}
