package com.example.Apis;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class RestControllerApi {

    HashMap<Integer,List<body>> m = new HashMap<>();
    private HashMap<Integer,List<body>> getBodyJson() throws IOException {
       String Testtime="04-11-2021 06:55:33";

     List<body>bodyList=new ArrayList<>();
        Timestamp time=Timestamp.valueOf(str);
      body b1=  new body(1,time,1.253,"USD");
      body b2= new body(2,time,2.253,"EUR");
        bodyList.add(b1);
        bodyList.add(b2);
      m.put(1,bodyList);

        return m;
    }


    @RequestMapping("/ticks")
    @Cacheable(value = "ticks")

    public ResponseEntity<List<body>> getBodyDto()
            throws IOException {
        LocalDateTime timing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();


        if (sec >= 0) {


           return new ResponseEntity<List<body>>(getBodyJson().get(1),HttpStatus.ACCEPTED);
        } else {



            return new ResponseEntity<List<body>>(HttpStatus.UNPROCESSABLE_ENTITY);


        }

    }


    @GetMapping("/statistics")
    @ResponseBody
    @Cacheable(value = "statistics")
    public ResponseEntity<stastics> stasttics() throws IOException {

        
        long count = 0;
        double avg = 0;
        
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();


        if (sec >= 0) {

            List<Double>stasticsList= new ArrayList<>();
            stasticsList.add(getBodyJson().get(1).get(0).getPrice());
            stasticsList.add(getBodyJson().get(1).get(1).getPrice());

            max=Collections.max(stasticsList);
            min=Collections.min(stasticsList);
            count=  stasticsList.stream().count();
           avg=(getBodyJson().get(1).get(0).getPrice()+getBodyJson().get(1).get(1).getPrice())/count;




        }

        return new ResponseEntity<stastics>(new stastics(count, avg, max, min), HttpStatus.OK);



    }

    @GetMapping("/statistics/{instrument_identifier}")
    @ResponseBody
    public ResponseEntity<List<Double>> stastticsidentifier(@PathVariable("instrument_identifier") int instrument) throws IOException {

        List<Double> priceList=new ArrayList<>();
        long count = 0;
        double avg = 0;
        double max = 0;
        double min = 0;
        LocalDateTime timeing = LocalDateTime.now();
        long sec = 60 - timeing.getSecond();
        HashMap<Integer, body> mapBody = new HashMap<>();



mapBody.put(1,getBodyDto().getBody().get(0));


        mapBody.put(2,getBodyDto().getBody().get(1));

        if (sec >= 0) {

priceList.add( mapBody.get(instrument).getPrice());



        }


        return new ResponseEntity<List<Double>>(priceList, HttpStatus.OK);



    }

}








