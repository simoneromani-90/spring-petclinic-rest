package org.springframework.samples.petclinic.rest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.mapper.OwnerMapper;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.rest.dto.OwnerDto;
import org.springframework.samples.petclinic.rest.dto.OwnerFieldsDto;
import org.springframework.samples.petclinic.service.ClinicService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class OwnerRestControllerTest {

    private final ClinicService clinicService = mock(ClinicService.class);
    private final OwnerMapper ownerMapper = mock(OwnerMapper.class);
    private final OwnerRestController ownerRestController =
        new OwnerRestController(clinicService, ownerMapper, null, null);

    @Test
    void updateOwner_shouldReturnNotFound_whenOwnerDoesNotExist() {
        int ownerId = 1;
        OwnerFieldsDto fieldsDto = new OwnerFieldsDto();

        when(clinicService.findOwnerById(ownerId)).thenReturn(null);

        ResponseEntity<OwnerDto> response = ownerRestController.updateOwner(ownerId, fieldsDto);

        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(clinicService, never()).saveOwner(any());
    }

    @Test
    void verify_removal_owner() {
        OwnerFieldsDto fieldsDto = new OwnerFieldsDto();
        Owner owner = new Owner();
        owner.setId(1);

        when(ownerMapper.toOwner(fieldsDto)).thenReturn(owner);

        ownerRestController.addOwner(fieldsDto);

        verify(clinicService).saveOwner(owner);
    }
}
