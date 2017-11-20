package com.sport.thoris.ridiculusfc.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by thoris on 17/11/2017.
 */

@DatabaseTable(tableName = "persons")
public class Jogador {

    private static final long serialVersionUID = 1L;

    @DatabaseField(columnName = IColumns.ID, generatedId = true, allowGeneratedIdInsert = true)
    private int id;

    @DatabaseField(columnName = IColumns.NOME_FIELD, unique = true, canBeNull = false)
    private String nome;

    @DatabaseField(columnName = IColumns.APELIDO_FIELD, unique = true, canBeNull = false)
    private String apelido;

    @DatabaseField(columnName = IColumns.ATTR_CHUTE_FIELD, unique = false, canBeNull = true)
    private int chute;

    @DatabaseField(columnName = IColumns.ATTR_PASSE_FIELD, unique = false, canBeNull = true)
    private int passe;

    @DatabaseField(columnName = IColumns.ATTR_TECNICA_FIELD, unique = false, canBeNull = true)
    private int tecnica;

    @DatabaseField(columnName = IColumns.ATTR_VELOCIDADE_FIELD, unique = false, canBeNull = true)
    private int velocidade;

    @DatabaseField(columnName = IColumns.ATTR_CABECEIO_FIELD, unique = false, canBeNull = true)
    private int cabeceio;


    @DatabaseField(columnName = IColumns.POS_GOLEIRO_FIELD, unique = false, canBeNull = true)
    private int goleiro;

    @DatabaseField(columnName = IColumns.POS_DEFESA_FIELD, unique = false, canBeNull = true)
    private int defesa;

    @DatabaseField(columnName = IColumns.POS_MEIOCAMPO_FIELD, unique = false, canBeNull = true)
    private int meioCampo;

    @DatabaseField(columnName = IColumns.POS_ATAQUE_FIELD, unique = false, canBeNull = true)
    private int ataque;

    @DatabaseField(columnName = IColumns.MENSALISTA_FIELD, unique = false, canBeNull = true)
    private Boolean mensalista;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }


    public int getChute() {
        return this.chute;
    }
    public void setChute(int chute) {
        this.chute = chute;
    }

    public int getPasse() {
        return this.passe;
    }
    public void setPasse(int passe) {
        this.passe = passe;
    }

    public int getTecnica() {
        return this.tecnica;
    }
    public void setTecnica(int tecnica) {
        this.tecnica = tecnica;
    }

    public int getVelocidade() {
        return this.velocidade;
    }
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getCabeceio() {
        return this.cabeceio;
    }
    public void setCabeceio(int cabeceio) {
        this.cabeceio = cabeceio;
    }


    public int getGoleiro() {
        return this.goleiro;
    }
    public void setGoleiro(int goleiro) {
        this.goleiro = goleiro;
    }

    public int getDefesa() {
        return this.defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getMeioCampo() {
        return this.meioCampo;
    }
    public void setMeioCampo(int meioCampo) {
        this.meioCampo = meioCampo;
    }

    public int getAtaque() {
        return this.ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public Boolean getMensalista() {
        return this.mensalista;
    }
    public void setMensalista(Boolean mensalista) { this.mensalista = mensalista; }


    public Jogador() {
        this.setNome("");
        this.setApelido("");
    }

    public Jogador(String nome, String apelido) {
        this.setNome(nome);
        this.setApelido(apelido);
    }



    public interface IColumns
    {
        String ID = "id";
        String NOME_FIELD = "nome";
        String APELIDO_FIELD = "apelido";
        String ATTR_CHUTE_FIELD = "chute";
        String ATTR_PASSE_FIELD = "passe";
        String ATTR_TECNICA_FIELD = "tecnica";
        String ATTR_VELOCIDADE_FIELD = "velocidade";
        String ATTR_CABECEIO_FIELD = "cabeceio";
        String POS_GOLEIRO_FIELD = "goleiro";
        String POS_DEFESA_FIELD = "defesa";
        String POS_MEIOCAMPO_FIELD = "meiocampo";
        String POS_ATAQUE_FIELD = "ataque";
        String MENSALISTA_FIELD = "mensalista";
    }



/*
    @Override
    public String toString() {
        return nome + " (" + apelido + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jogador other = (Jogador) obj;
        if (id != other.id)
            return false;
        return true;
    }
    */

}
