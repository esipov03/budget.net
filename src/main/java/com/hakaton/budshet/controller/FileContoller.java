package com.hakaton.budshet.controller;

import com.hakaton.budshet.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileContoller {

    @Autowired
    private ProcessService processService;


    public FileContoller(ProcessService processService){
        this.processService=processService;
    }

    @RequestMapping(value = "upload")
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {

                byte[] bytes = file.getBytes();

                String fileText = new String(bytes);

                return processService.createProcess(fileText);


            } catch (Exception e) {
                return "Вам не удалось загрузить файл => " +  e.getMessage();
            }
        } else {
            return "Файл пуст";
        }
    }


    }

