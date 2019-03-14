package com.xiao.controllers;

import com.xiao.bean.Episode;
import com.xiao.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl-Xiao 2019-03-06
 */
@RestController
@Slf4j
public class ApiController {
    @Autowired
    ApiService apiService;

    @RequestMapping(value = "/api/sohu/{vid}",method = {RequestMethod.GET,RequestMethod.POST})
    public Episode getVidRealUrlIndex(@PathVariable("vid") String vid) {
        return apiService.getInfo(vid);
    }





}
