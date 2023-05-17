package org.exemple.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequestDTO {
    private int amount;
    private BankRequestDTO bankRequestDTO;
    private String origin;
    private String name;
    private String rut;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date date;
    private String hashid;
}
