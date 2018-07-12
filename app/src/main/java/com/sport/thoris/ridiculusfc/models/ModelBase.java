package com.sport.thoris.ridiculusfc.models;

import com.j256.ormlite.field.DatabaseField;
import com.sport.thoris.ridiculusfc.interfaces.IEntidade;

public class ModelBase implements IEntidade {

    //@DatabaseField(id = true)
    @DatabaseField(columnName = IColumns.ID, generatedId = true, allowGeneratedIdInsert = true)
    public long id;

    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public interface IColumns
    {
        String ID = "id";
    }

}
