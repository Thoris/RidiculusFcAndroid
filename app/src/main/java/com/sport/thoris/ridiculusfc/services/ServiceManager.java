package com.sport.thoris.ridiculusfc.services;

import android.content.Context;
import com.sport.thoris.ridiculusfc.dao.DatabaseManager;

public class ServiceManager {

    public static void init(Context ctx) {
        DatabaseManager.init(ctx);
    }

}
