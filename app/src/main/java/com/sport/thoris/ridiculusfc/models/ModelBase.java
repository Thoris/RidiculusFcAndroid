package com.sport.thoris.ridiculusfc.models;

import com.j256.ormlite.field.DatabaseField;
import com.sport.thoris.ridiculusfc.interfaces.models.IEntidade;

import java.util.Date;

public class ModelBase implements IEntidade {

    @DatabaseField(columnName = IColumns.ID, generatedId = true, allowGeneratedIdInsert = true)
    public long id;
/*
    @DatabaseField(columnName = IColumns.MODIFIED_BY_FIELD)
    public String modifiedBy;

    @DatabaseField(columnName = IColumns.MODIFIED_DATE_FIELD)
    public Date modifiedDate;

    @DatabaseField(columnName = IColumns.CREATED_BY_FIELD)
    public String createdBy;

    @DatabaseField(columnName = IColumns.CREATED_DATE_FIELD)
    public Date createdDate;
*/


    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public interface IColumns
    {
        String ID = "id";
//        String MODIFIED_BY_FIELD = "modifiedBy";
//        String MODIFIED_DATE_FIELD = "modifiedDate";
//        String CREATED_BY_FIELD = "createdBy";
//        String CREATED_DATE_FIELD = "createdDate";
    }

}
