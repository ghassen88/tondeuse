package com.tondeuse.service;

import com.tondeuse.model.Lawn;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class MowerServiceTest {

    @Mock
    private Lawn lawn;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(lawn.getMaxX()).thenReturn(5);
        when(lawn.getMaxY()).thenReturn(5);
    }

    @Test
    public void testDeployMower() {
        MowerService mowerService = new MowerService();
        mowerService.deployMower(1, 2, 'N', "GAGAGAGAA", lawn);
        assertEquals(1, mowerService.getFinalPositions().size());
        assertEquals("1 3 N", mowerService.getFinalPositions().get(0));
    }


}