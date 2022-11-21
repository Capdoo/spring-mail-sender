package com.example.app.controller;

import com.example.app.dto.EmailValuesDTO;
import com.example.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/send")
    public ResponseEntity<Object> sendEmail(){
        emailService.sendEmail();
        return new ResponseEntity<Object>("Correo enviado con exito", HttpStatus.OK);
    }

    @GetMapping("/send-html")
    public ResponseEntity<Object> sendEmailTemplate(@RequestBody EmailValuesDTO emailValuesDTO){
        emailService.sendEmailTemplate(emailValuesDTO);
        return new ResponseEntity<Object>("Correo con plantilla enviado con exito", HttpStatus.OK);
    }

}
