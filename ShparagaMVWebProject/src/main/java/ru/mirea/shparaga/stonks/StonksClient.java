package ru.mirea.shparaga.stonks;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;

public class StonksClient {

    public static void main(String[] args) {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://www.cbr.ru")
                .addConverterFactory(JacksonConverterFactory.create(new XmlMapper()))
                .build();

        StonksService stonksService = client.create(StonksService.class);
        try {
            LocalDate birthDate = LocalDate.of(2004, 1, 6); // Дата рождения
            String formattedDate = birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            Response<DailyCurs> response = stonksService
                    .getDailyCurs(formattedDate).execute();

            DailyCurs dailyCurs = response.body();

            Optional<Valute> maxValute = dailyCurs.getValutes().stream()
                    .filter(valute -> !valute.getName().equals("СДР (специальные права заимствования)"))
                    .max(Comparator.comparingDouble(Valute::getValue));

            DatabaseService databaseService = new DatabaseServiceImpl();
            if (maxValute.isPresent()) {
                System.out.println("Максимальная валюта на " + birthDate + ": " + maxValute.get());

                Valute mv = maxValute.get();
                String fio = "шпарагамв";
                databaseService.saveMaxValuteOfDate(fio, mv, birthDate);

                Valute valute = databaseService.getValuteOfDate(birthDate);
                System.out.println("Записанная в базу валюта: " + valute);
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
