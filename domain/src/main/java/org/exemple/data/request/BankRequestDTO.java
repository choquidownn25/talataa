package org.exemple.data.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankRequestDTO {
    private int id;
    private String name;
    private String hashid;

}
