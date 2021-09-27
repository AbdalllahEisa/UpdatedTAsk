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
        HashMap<String, Double> y = new HashMap<>();

        Set<Double> mapSet=new HashSet<>();
for(body t: getBodyJson(BodyDto)) {
    
    mapSet.add(t.getPrice());
}




        if (sec >= 0) {







            count++;







            max =Collections.max(mapSet);
            min=Collections.min(mapSet);
            Iterator<Double> looping = mapSet.iterator();

            count=   mapSet.stream().count();


            while(looping.hasNext()) {
                avg = looping.next() /count;
            }
        }




        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);



    }

    @GetMapping(" /statistics/{instrument_identifier}")
    @ResponseBody
    public ResponseEntity<stastics> stastticsidentifier(@PathVariable("instrument_identifier") String instrument) throws IOException {
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

        long count = 0;
        double avg = 0;
        double u = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        HashMap<String, Double> y = new HashMap<>();
        Set<Double> mapSet=new HashSet<>();



        for(body t: getBodyJson(BodyDto)) {
            mapSet.add(t.getPrice());
        }



        if (sec >= 0) {







            count++;







            max =Collections.max(mapSet);
            min=Collections.min(mapSet);
            Iterator<Double> looping = mapSet.iterator();

            count=   mapSet.stream().count();


            while(looping.hasNext()) {
                avg = looping.next() /count;
            }
        }




        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);



    }

}




