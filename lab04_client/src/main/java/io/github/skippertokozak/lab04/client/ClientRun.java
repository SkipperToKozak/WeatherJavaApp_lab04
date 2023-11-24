package io.github.skippertokozak.lab04.client;

import io.github.skippertokozak.lab04.client.dao.WeatherDao;

public class ClientRun {
    private WeatherDao weatherDao;
    public void run(){

            weatherDao = new WeatherDao();
            weatherDao.checkIfUpToDate();
    }

    public WeatherDao getWeatherDao() {
        return weatherDao;
    }
}
