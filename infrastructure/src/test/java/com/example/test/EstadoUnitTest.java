package com.example.test;

import org.example.adapters.EstadoJpaAdapter;
import org.example.entity.Estado;
import org.example.repository.EstadoRepository;
import org.exemple.data.EstadoDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class EstadoUnitTest {
    @Mock
    EstadoRepository estadoRepository;
    @InjectMocks
    EstadoJpaAdapter estadoJpaAdapter;
    @Test
    public void testGetEstadosList() {
        Estado estado1 = new Estado(1, "Madre Bella");
        Estado estado2 = new Estado(2, "Maria gloria madre bella");

        when(estadoRepository.findAll()).thenReturn(Arrays.asList(estado1, estado2));
        List<EstadoDTO> estadoList = estadoJpaAdapter.getEstados();
        assertEquals(estadoList.size(), 2);
        assertEquals(estadoList.get(0).getDescripcion(), "Madre Bella");
        assertEquals(estadoList.get(1).getDescripcion(), "Maria gloria madre bella");

    }
    @Test
    public void testGetEstadoById() {
        Estado estado = new Estado(1, "Madre Bella");
        when(estadoRepository.findById(1)).thenReturn(Optional.of(estado));
        EstadoDTO estadoById = estadoJpaAdapter.getEstadoDTOById(1);
        assertNotEquals(estadoById, null);
        assertEquals(estadoById.getDescripcion(), "Madre Bella");
        assertEquals(estadoById.getId(), 1);
    }

    @Test
    public void testCreateEstado() {
        EstadoDTO estado = new EstadoDTO(1, "Madre Bella");
        Estado estados = new Estado(1, "Madre Bella");
        estadoJpaAdapter.addEstado(estado);
        verify(estadoRepository, times(1)).save(estados);
        ArgumentCaptor<Estado> estadoArgumentCaptor = ArgumentCaptor.forClass(Estado.class);
        verify(estadoRepository).save(estadoArgumentCaptor.capture());
        Estado estadoCreated = estadoArgumentCaptor.getValue();
        assertNotNull(estadoCreated.getId());
        assertEquals("Madre Bella", estadoCreated.getDescripcion());
    }
}
