package com.example.openschool1.service;

import com.example.openschool1.model.Worker;
import com.example.openschool1.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(@Qualifier("workerRepository") WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

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
