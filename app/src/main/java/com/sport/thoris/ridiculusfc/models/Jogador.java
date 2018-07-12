package com.sport.thoris.ridiculusfc.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = Jogador.ITable.TABLE_NAME)
public class Jogador implements Serializable, Comparable<Jogador>{

    @DatabaseField(columnName = IColumns.NOME_FIELD, unique = true, canBeNull = false)
    private String nome;

    @DatabaseField(columnName = IColumns.ATTR_CHUTE_FIELD, unique = false, canBeNull = true)
    private float chute;

    @DatabaseField(columnName = IColumns.ATTR_TECNICA_FIELD, unique = false, canBeNull = true)
    private float tecnica;

    @DatabaseField(columnName = IColumns.ATTR_VELOCIDADE_FIELD, unique = false, canBeNull = true)
    private float velocidade;

    @DatabaseField(columnName = IColumns.GOLEIRO_FIELD, unique = false, canBeNull = true)
    private Boolean goleiro;

    @DatabaseField(columnName = IColumns.POS_DEFESA_FIELD, unique = false, canBeNull = true)
    private float defesa;

    @DatabaseField(columnName = IColumns.POS_MEIOCAMPO_FIELD, unique = false, canBeNull = true)
    private float meioCampo;

    @DatabaseField(columnName = IColumns.POS_ATAQUE_FIELD, unique = false, canBeNull = true)
    private float ataque;

    @DatabaseField(columnName = IColumns.MENSALISTA_FIELD, unique = false, canBeNull = true)
    private Boolean mensalista;

    @DatabaseField(columnName = IColumns.ANO_NASCIMENTO_FIELD, unique = false, canBeNull = true)
    private int anoNascimento;



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome; }

    public float getChute() {
        return this.chute;
    }
    public void setChute(float chute) {
        this.chute = chute;
    }

    public float getTecnica() {
        return this.tecnica;
    }
    public void setTecnica(float tecnica) {
        this.tecnica = tecnica;
    }

    public float getVelocidade() {
        return this.velocidade;
    }
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }


    public float getDefesa() {
        return this.defesa;
    }
    public void setDefesa(float defesa) {
        this.defesa = defesa;
    }

    public float getMeioCampo() {
        return this.meioCampo;
    }
    public void setMeioCampo(float meioCampo) {
        this.meioCampo = meioCampo;
    }

    public float getAtaque() {
        return this.ataque;
    }
    public void setAtaque(float ataque) {
        this.ataque = ataque;
    }


    public Boolean getMensalista() {
        return this.mensalista;
    }
    public void setMensalista(Boolean mensalista) { this.mensalista = mensalista; }

    public Boolean getGoleiro() {
        return this.goleiro;
    }
    public void setGoleiro(Boolean goleiro) {
        this.goleiro = goleiro;
    }

    public int getAnoNascimento() {
        return this.anoNascimento;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public float getGeral() {

        return (chute + tecnica + velocidade) / 3f;
    }
    public void setGeral (float geral){

        chute = geral;
        tecnica = geral;
        velocidade = geral;
        ataque = geral;
        defesa = geral;
        meioCampo = geral;
    }


    public Jogador() {
        this.setNome("No name");
        this.setNome("");
        this.setAnoNascimento(0);

        this.setTecnica(0);
        this.setVelocidade(0);
        this.setAtaque(0);
        this.setChute(0);
        this.setDefesa(0);
        this.setMeioCampo(0);

        this.setMensalista(false);
        this.setGoleiro(false);

    }

    public Jogador(int id){
        this();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (this.nome == null ? 0 : this.nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;
        final Jogador other = (Jogador) obj;
        if (this.nome == null) {
            if (other.nome != null) return false;
        } else if (!this.nome.equals(other.nome)) return false;
        return true;
    }

    @Override
    public String toString() {
        return this.nome.toUpperCase();
    }

    @Override
    public int compareTo(final Jogador arg0) {
        return this.nome.compareTo(arg0.nome);
    }




    public interface IColumns
    {
        String ID = "id";
        String NOME_FIELD = "nome";
        String ATTR_CHUTE_FIELD = "chute";
        String ATTR_TECNICA_FIELD = "tecnica";
        String ATTR_VELOCIDADE_FIELD = "velocidade";
        String GOLEIRO_FIELD = "goleiro";
        String POS_DEFESA_FIELD = "defesa";
        String POS_MEIOCAMPO_FIELD = "meiocampo";
        String POS_ATAQUE_FIELD = "ataque";
        String MENSALISTA_FIELD = "mensalista";
        String ANO_NASCIMENTO_FIELD = "nascimento";
    }

    public interface ITable{
        String TABLE_NAME = "jogadores";
    }
}

