package com.sport.thoris.ridiculusfc.tempSample2;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thoris on 18/11/2017.
 */

public class test {


    /*

    private String testCRUD(){

        String result="";
        Cursor cursor = null;
        String[] columns = new String[] {GenericDAO.KEY_ID, Notes.COL_TITLE, Notes.COL_BODY};

        GenericDAO dao = GenericDAO.getInstance(this, Notes.DATABASE_NAME, Notes.TABLE_CREATE, Notes.DATABASE_TABLE, Notes.DATABASE_VERSION);

        if(dao != null){

            ContentValues values = new ContentValues();
            values.put(Notes.COL_TITLE, "aaa");
            values.put(Notes.COL_BODY, "bbb");
            dao.insert(Notes.DATABASE_TABLE, values);

            values = new ContentValues();
            values.put(Notes.COL_TITLE, "ccc");
            values.put(Notes.COL_BODY, "ddd");
            dao.insert(Notes.DATABASE_TABLE, values);

            cursor = dao.get(Notes.DATABASE_TABLE, columns);


            int idColumn = cursor.getColumnIndex(GenericDAO.KEY_ID);
            int titleColumn = cursor.getColumnIndex(Notes.COL_TITLE);
            int bodyColumn = cursor.getColumnIndex(Notes.COL_BODY);

            if(cursor != null){
                if(cursor.moveToFirst()){

                    int count = cursor.getCount();
                    result = "there are " + count + " records.";
                    List<Notes> list = new ArrayList<Notes>();

                    for(int i=0; i<count; i++){

                        int id = cursor.getInt(idColumn);
                        String title = cursor.getString(titleColumn);
                        String body = cursor.getString(bodyColumn);

                        Notes notes = new Notes();
                        notes.setId(id);
                        notes.setTitle(title);
                        notes.setBody(body);

                        list.add(notes);

                        result += " " + i + ": " + "id=" + id + ", title=" + title + ", body=" + body + ";";

                        cursor.moveToNext();
                    }
                }
            }

            result += " now update the second record.";

            values = new ContentValues();
            values.put(Notes.COL_TITLE, "eee");
            values.put(Notes.COL_BODY, "fff");
            dao.update(Notes.DATABASE_TABLE, 2, values);

            cursor.requery();
            cursor.close();

            result += " now delete first record.";

            dao.delete(Notes.DATABASE_TABLE, 1);

            result += " now delete all records.";

            dao.delete(Notes.DATABASE_TABLE);

            dao.close();
        }

        return result;
    }


*/
}
