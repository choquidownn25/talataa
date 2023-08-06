package org.example.controller;

import org.exemple.data.response.BancoOrigenDTOResponse;
import org.exemple.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/recivedEmailImp")
    List<BancoOrigenDTOResponse> receiveEmailsHTMLBanco() throws MessagingException, IOException {

        return emailService.receiveEmailsHTMLBanco();
    }
}
