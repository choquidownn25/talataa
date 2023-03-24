package org.exemple.data.response;

import lombok.*;
import org.exemple.data.CarteleraDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CarteleraDtoResponse {
    private List<CarteleraDTO> listCarteleraDTO;
    private Message message;
}
