package com.example.Apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestControllerApi {
    private body getBodyJson(String jsonBodyDTO) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return new ObjectMapper()
                .setDateFormat(simpleDateFormat)
                .readValue(jsonBodyDTO, body.class);
    }

    @RequestMapping("/ticks")
    @Cacheable(value = "ticks")
    public Object getBodyDto()
            throws IOException {
        String BodyDto = "{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "},{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "}";

        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        body i = new body(getBodyJson(BodyDto).getTimestamp(), getBodyJson(BodyDto).getPrice(), getBodyJson(BodyDto).getInstrument());

        double r = 0;
        if (sec >= 0) {


            return i.getPrice();
        } else {


            return new ResponseEntity<body>(HttpStatus.UNPROCESSABLE_ENTITY);


        }

    }


    @GetMapping("/statistics")

    @ResponseBody
    @Cacheable(value = "statistics")
    public ResponseEntity<stastics> stasttics() throws IOException {
        String BodyDto = "{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "},{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "}";
        double r = 0;
        int count = 0;
        double avg = 0;
        double u = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        HashMap<String, body> y = new HashMap<>();
        y.put("body", getBodyJson(BodyDto));
        body i = new body(getBodyJson(BodyDto).getTimestamp(), getBodyJson(BodyDto).getPrice(), getBodyJson(BodyDto).getInstrument());

        if (sec >= 0) {


            y.put("body", getBodyJson(BodyDto));


            for (Map.Entry h : y.entrySet()) {

                count++;
                u += i.getPrice();

            }
            avg = u / count;

            for (int j = 0; j < y.size(); j++) {
                if (y.get(0).getPrice() > y.get((j - 1) + 1).getPrice()) {
                    max = y.get(0).getPrice();

                } else {
                    max = y.get((j - 1) + 1).getPrice();

                }
            }


            for (int j = 0; j < y.size(); j++) {
                if (y.get(0).getPrice() > y.get((j - 1) + 1).getPrice()) {
                    min = y.get((j - 1) + 1).getPrice();

                } else {

                    min = y.get(0).getPrice();

                }
            }

        }

        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);


    }

    @GetMapping(" /statistics/{instrument_identifier}")
    @ResponseBody
    public ResponseEntity<stastics> stastticsidentifier(@PathVariable("instrument_identifier") String instrument) throws IOException {
        String BodyDto = "{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "},{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "}";
        double r = 0;
        int count = 0;
        double avg = 0;
        double u = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        HashMap<String, body> y = new HashMap<>();
        body i = new body(getBodyJson(BodyDto).getTimestamp(), getBodyJson(BodyDto).getPrice(), getBodyJson(BodyDto).getInstrument());
        y.put("body", getBodyJson(BodyDto));


        if (sec >= 0) {


            for (Map.Entry h : y.entrySet()) {

                count++;
                u += i.getPrice();

            }
            avg = u / count;

            for (int j = 0; j < y.size(); j++) {
                if (y.get(0).getPrice() > y.get((j - 1) + 1).getPrice()) {
                    max = y.get(0).getPrice();

                } else {
                    max = y.get((j - 1) + 1).getPrice();

                }
            }


            for (int j = 0; j < y.size(); j++) {
                if (y.get(0).getPrice() > y.get((j - 1) + 1).getPrice()) {
                    min = y.get((j - 1) + 1).getPrice();

                } else {

                    min = y.get(0).getPrice();

                }
            }

        }
        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);


    }

}




