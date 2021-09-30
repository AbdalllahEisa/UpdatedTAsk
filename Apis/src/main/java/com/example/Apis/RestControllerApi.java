package com.example.Apis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class RestControllerApi {
    private body[] getBodyJson(String jsonBodyDTO) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return new ObjectMapper()
                .setDateFormat(simpleDateFormat)
                .readValue(jsonBodyDTO, body[].class);
    }

    @RequestMapping("/ticks")
    @Cacheable(value = "ticks")

    public Object getBodyDto()
            throws IOException {
        String BodyDto = "[{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 1.333,\n" +
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
                "}]";

        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();

        double r = 0;
        if (sec >= 0) {


            return getBodyJson(BodyDto)[0].getPrice();
        } else {


            return new ResponseEntity<body>(HttpStatus.UNPROCESSABLE_ENTITY);


        }

    }


    @GetMapping("/statistics")

    @ResponseBody
    @Cacheable(value = "statistics")
    public ResponseEntity<stastics> stasttics() throws IOException {
        String BodyDto = "[{\n" +
                "\n" +
                "\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 1.333,\n" +
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
                "}]";
        double r = 0;
        long count = 0;
        double avg = 0;
        double u = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();


        HashMap<Integer, body> y = new HashMap<>();


        body b1= getBodyJson(BodyDto)[0];

        body b2= getBodyJson(BodyDto)[1];

        y.put(1,b1);
        y.put(2,b2);





        if (sec >= 0) {








if( y.get(1).getPrice()>y.get(2).getPrice()) {
    max=y.get(1).getPrice();
    min=y.get(2).getPrice();
        }else{

    max=y.get(2).getPrice();
    min=y.get(1).getPrice();

}
            for (Map.Entry<Integer, body> set :
                    y.entrySet()) {
          count++;

            }


avg=(y.get(1).getPrice()+y.get(2).getPrice())/count;




        }




        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);



    }

    @GetMapping("/statistics/{instrument_identifier}")
    @ResponseBody
    public ResponseEntity<body> stastticsidentifier(@PathVariable("instrument_identifier") int instrument) throws IOException {
        String BodyDto = "[{\n" +
                "\n" +
                "\n" +
                "  \"id\": 1,\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 1.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "},{\n" +
                "\n" +
                "\n" +
                "  \"id\": 2,\n" +
                "  \"instrument\": \"EURUSD\",\n" +
                "  \"price\": 2.333,\n" +
                "  \"timestamp\": 1478192204000\n" +
                "\n" +
                "\n" +
                "}]";
        body b=null;
        long count = 0;
        double avg = 0;
        double u = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        HashMap<Integer, body> y = new HashMap<>();


        body b1= getBodyJson(BodyDto)[0];

        body b2= getBodyJson(BodyDto)[1];

        y.put(1,b1);
        y.put(2,b2);

        if (sec >= 0) {





b= y.get(instrument);











        }




        return new ResponseEntity<body>(b, HttpStatus.OK);



    }

}




