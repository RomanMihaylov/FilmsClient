package com.example.roma.filmsclient.data.source.local;

import com.example.roma.filmsclient.data.source.DataSource;


public class LocalSource implements DataSource {

    private static LocalSource INSTANCE;
    private LocalRoomDAO dao;

    private LocalSource(LocalRoomDAO dao) {
        this.dao = dao;
    }

    public static LocalSource getInstance(LocalRoomDAO dao) {
        if (INSTANCE == null)
            INSTANCE = new LocalSource(dao);
        return INSTANCE;
    }
    @Override
    public void save() {

    }
}
