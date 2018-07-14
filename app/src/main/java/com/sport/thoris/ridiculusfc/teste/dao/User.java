package com.sport.thoris.ridiculusfc.teste.dao;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "User")
public class User {
    @DatabaseField(generatedId = true) private int id;
    @DatabaseField private String name;
    @DatabaseField private int sort;
    @ForeignCollectionField
    private ForeignCollection<Group> groups;

    public User() {}

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getSort() {
        return sort;
    }
}