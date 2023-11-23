package io.github.skippertokozak.lab04.client;

import io.github.skippertokozak.lab04.client.dao.WeatherDao;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        WeatherDao weatherDao = new WeatherDao();
            weatherDao.checkIfUpToDate();
    }
}
