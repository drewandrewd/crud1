package com.example.openschool1.api;

import com.example.openschool1.model.Worker;
import com.example.openschool1.repository.WorkerRepository;
import com.example.openschool1.service.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class WorkerController {

    private final WorkerService workerService;
    private final WorkerRepository workerRepository;

    public WorkerController(@Qualifier("workerService") WorkerService workerService, WorkerRepository workerRepository) {
        this.workerService = workerService;
        this.workerRepository = workerRepository;
    }

    @PostMapping
    public Worker save(@RequestBody Worker worker) {
        return workerService.save(worker);
    }

    @GetMapping("/{id}")
    public Worker get(@PathVariable Long id) {
        log.info("Get all workers {}", workerRepository.findAll());
        return workerService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workerService.delete(id);
    }
}
