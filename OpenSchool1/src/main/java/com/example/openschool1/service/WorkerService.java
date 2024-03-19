package com.example.openschool1.service;

import com.example.openschool1.model.Worker;
import com.example.openschool1.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    public Worker get(Long id) {

        return workerRepository.findById(id).get();
    }

    public void delete(Long id) {
        workerRepository.deleteById(id);
    }
}
