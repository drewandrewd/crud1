package com.example.openschool1.api;

import com.example.openschool1.model.Worker;
import com.example.openschool1.service.WorkerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class WorkerController {

    private WorkerService workerService;

    @PostMapping
    public Worker save(@RequestBody Worker worker) {
        return workerService.save(worker);
    }

    @GetMapping
    public Worker get(@RequestBody Long id) {
        return workerService.get(id);
    }

    @PostMapping
    public void delete(@RequestBody Long id) {
        workerService.delete(id);
    }
}
