package org.example.controller;

import org.exemple.data.ProductoDto;
import org.exemple.data.request.LoginRequest;
import org.exemple.data.request.ParametersRequestDTO;
import org.exemple.data.response.ProductoDtoResponse;
import org.exemple.utils.OutlookEmailSender;
import org.exemple.utils.XOAuthEmailSender;
import org.exemple.utils.XOauthEmailReceiver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class TransferController {

    @PostMapping("/loguin")
    public ResponseEntity<?> loguinLinkify(@RequestBody LoginRequest loginRequest) {
        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json(loginRequest);
        Response response = client.target("https://app.linkify.cl/api/login")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        if (response != null)
            return  new ResponseEntity<>(response, HttpStatus.OK);
        else
            return   new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @PostMapping("/payments")
    public ResponseEntity<?> payments(@RequestBody ParametersRequestDTO parametersRequestDTO) throws ParseException {
        // Display a date in day, month, year format
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String today = formatter.format(parametersRequestDTO.getDate());
        System.out.println("Today : " + today);
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(today);
        System.out.println(today+"\t"+date1);
        //Date fechaPayment= new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(parametersRequestDTO.getDate()));
        parametersRequestDTO.setDate(date1);
        Client client = ClientBuilder.newClient();
        // Assuming you have a ParametersRequestDTO object called requestDto
        String requestBody = parametersRequestDTO.toString();
        Entity<String> entitys = Entity.entity(requestBody, MediaType.TEXT_PLAIN);

        //Entity<String> payload = Entity.text("");
        Response response = client.target("https://app.linkify.cl/api/payments")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .post(entitys);
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        if (response != null)
            return  new ResponseEntity<>(response, HttpStatus.OK);
        else
            return   new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/transfer")
    public ResponseEntity<?> getTransfer(@PathVariable String from, @PathVariable String to) {
        Client client = ClientBuilder.newClient();
        //Entity payload = Entity.json(loginRequest);
        Response response = client.target("https://app.linkify.cl/api/transfers")
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Authorization", "Bearer JWT -  Reemplazando JWT con el token obtenido en la autenticación.")
                .get();
        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
        if (response != null)
            return  new ResponseEntity<>(response, HttpStatus.OK);
        else
            return   new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }

    //XOAuthEmailSender
    @GetMapping("/email")
    public void sendEmail() {
        XOAuthEmailSender.xOAuthEmailSender();
    }
    @GetMapping("/receiver")
    public void xOauthEmailReceiver() throws Exception {
        OutlookEmailSender.outlookEmailSender() ;
        XOauthEmailReceiver.EmailReceiverMain();
        XOauthEmailReceiver.mainEmailReceiver();
        XOauthEmailReceiver.xOauthEmailReceiver();
    }
}
