package com.example.basic;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/consume", method = RequestMethod.GET)
    @ResponseBody
    public Object consumeThis() {
        return restTemplate.getForObject("http://localhost:8082/provider", ConsumerOfProvider.class);
    }
}
