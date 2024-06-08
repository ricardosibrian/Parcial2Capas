package com.example.prepractica.services.implementation;

import com.example.prepractica.domain.dtos.CitaMedica.CreateCitaMedicaDTO;
import com.example.prepractica.domain.entities.CitaMedica;
import com.example.prepractica.domain.entities.User;
import com.example.prepractica.repositories.CitaMedicaRepository;
import com.example.prepractica.repositories.UserRepository;
import com.example.prepractica.services.CitaMedicaService;
import com.example.prepractica.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class CitaMedicaServiceImpl implements CitaMedicaService {

    private final CitaMedicaRepository citaMedicaRepository;

    public CitaMedicaServiceImpl(CitaMedicaRepository citaMedicaRepository) {
        this.citaMedicaRepository = citaMedicaRepository;
    }

    @Override
    public void CreateCitaMedica(CreateCitaMedicaDTO info, Date fechaHoraInicioMapped) {

        CitaMedica citaMedica = new CitaMedica();
        citaMedica.setFechaHoraInicio(fechaHoraInicioMapped);
        citaMedica.setDescripcion(info.getDescripcion());

        citaMedicaRepository.save(citaMedica);
    }

    @Override
    public CitaMedica GetCitaMedicaByUUID(UUID id) {
        return citaMedicaRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public Date validFechaHoraInicio(String fechaHoraInicio) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHoraInicio);
        } catch (ParseException ex) {
            return null;
        }
    }

    @Override
    public List<CitaMedica> getAllCitasMedicas() {
        return citaMedicaRepository.findAll();
    }
}
