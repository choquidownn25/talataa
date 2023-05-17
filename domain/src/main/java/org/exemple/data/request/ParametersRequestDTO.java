package org.exemple.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.exemple.data.InvoiceType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParametersRequestDTO {
    private InvoiceType invoiceType;
    private String invoice_id;
    private String merchant;
    private double amount;
    private String description;
    private String rut;
    private Date date;
    private String email;
    private String endpoint;
}
