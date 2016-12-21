package rafael.couto.com.monitoriaseletortimes;

import java.io.Serializable;

/**
 * Created by root on 17/12/16.
 */
public class Cliente implements Serializable{
    private String nome;
    private int idade;
    private String estCivil;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(String estCivil) {
        this.estCivil = estCivil;
    }

    @Override
    public String toString() {
        return "Nome: "+nome
                +"\nIdade: "+idade
                +"\nEst. Cívil: "+estCivil;
    }
}
