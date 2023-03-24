package com.example.test;

import org.example.adapters.EstadoJpaAdapter;
import org.example.entity.Estado;
import org.example.repository.EstadoRepository;
import org.exemple.data.EstadoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EstadoUnitTest {
    @Mock
    EstadoRepository estadoRepository;
    @InjectMocks
    EstadoJpaAdapter orderService;
    @Test
    public void testGetOrdersList() {
        Estado order1 = new Estado(1, "Madre Bella");
        Estado order2 = new Estado(2, "Maria gloria madre bella");
        Estado order3 = new Estado(1, "Madre ");
        when(estadoRepository.findAll()).thenReturn(Arrays.asList(order1, order2, order3));
        List<EstadoDTO> orderList = orderService.getEstados();
        assertEquals(orderList.size(), 2);
        assertEquals(orderList.get(0).getDescripcion(), "Madre Bella");
        assertEquals(orderList.get(1).getDescripcion(), "Maria gloria madre bella");

    }
}
