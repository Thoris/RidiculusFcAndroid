package com.sport.thoris.ridiculusfc.tempSample;

import com.j256.ormlite.field.DatabaseField;

public class MeuBean implements IEntidade{

    @DatabaseField(id = true)
    public Long id;

    @DatabaseField
    public String nome;
}