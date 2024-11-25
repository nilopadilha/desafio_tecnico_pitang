package br.com.pitang.desafiobackend.services;


import br.com.pitang.desafiobackend.dto.CarResponseDTO;
import br.com.pitang.desafiobackend.exceptions.ResourceNotFoundException;
import br.com.pitang.desafiobackend.model.Car;
import br.com.pitang.desafiobackend.repositories.CarRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
    @Autowired
    private CarRepository repository;

    @Transactional(readOnly = true)
    public CarResponseDTO findById(Long id) {
        return new CarResponseDTO(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")));
    }

    @Transactional(readOnly = true)
    public Page<CarResponseDTO> findAll(Pageable pageable) {
        Page<Car> result = repository.findAll(pageable);
        return result.map(CarResponseDTO::new);
    }

    @Transactional
    public CarResponseDTO insert(Long userid, CarResponseDTO dto) {
        Car entity = new Car();
        passDtoToEntity(dto, entity);
        return new CarResponseDTO(repository.save(entity));
    }

    @Transactional
    public CarResponseDTO update(Long id, CarResponseDTO dto) {
        try {
            Car entity = repository.getReferenceById(id);
            passDtoToEntity(dto, entity);
            return new CarResponseDTO(repository.save(entity));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } else {
            repository.deleteById(id);
        }
    }

    private void passDtoToEntity(CarResponseDTO dto, Car entity) {
        entity.setCar_year(dto.getCar_Year());
        entity.setModel(dto.getModel());
        entity.setLicensePlate(dto.getLicensePlate());
        entity.setColor(dto.getColor());
        entity.setUser(dto.getUser());

    }
}
