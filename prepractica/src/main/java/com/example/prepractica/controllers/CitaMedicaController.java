package com.example.prepractica.controllers;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
import com.example.prepractica.domain.dtos.GeneralResponse;
import com.example.prepractica.domain.dtos.User.RegisterDTO;
import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.services.CitaMedicaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/citaMedica")
public class CitaMedicaController {

    private final CitaMedicaService citaMedicaService;

    public CitaMedicaController(CitaMedicaService citaMedicaService) {
        this.citaMedicaService = citaMedicaService;
    }

    @PostMapping("/create")
    public ResponseEntity<GeneralResponse> createCitaMedica (@RequestBody @Valid CreateCitaMedicaDTO info){

        Date fechaHoraInicioMapped = citaMedicaService.validFechaHoraInicio(info.getFechaHoraInicio());

        if (fechaHoraInicioMapped == null) {
            return GeneralResponse.getResponse(HttpStatus.BAD_REQUEST, "Invalid date format that must be yyyy-MM-dd");
        }

        citaMedicaService.CreateCitaMedica(info, fechaHoraInicioMapped);

        return GeneralResponse.getResponse(HttpStatus.OK, "Create Cita Medica successful");
    }

    @GetMapping("/getAll")
    public ResponseEntity<GeneralResponse> getAllCitasMedicas (){

        List<CitaMedica> citaMedica = citaMedicaService.getAllCitasMedicas();

        return GeneralResponse.getResponse(HttpStatus.OK, citaMedica);
    }

}
