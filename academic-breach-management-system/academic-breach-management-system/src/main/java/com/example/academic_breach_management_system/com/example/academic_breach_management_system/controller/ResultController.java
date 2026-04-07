package com.example.academic_breach_management_system.controller;

import com.example.academic_breach_management_system.entity.Result;
import com.example.academic_breach_management_system.repository.ResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "*")
public class ResultController {

    @Autowired
    private ResultRepository resultRepository;

    // Get results by semester
    @GetMapping("/{semester}")
    public List<Result> getResultsBySemester(@PathVariable int semester) {
        return resultRepository.findBySemester(semester);
    }

    // Get all results
    @GetMapping
    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }

    // Add new result
    @PostMapping
    public Result addResult(@RequestBody Result result) {
        return resultRepository.save(result);
    }

    // Update result
    @PutMapping("/{id}")
    public Result updateResult(@PathVariable Long id, @RequestBody Result updatedResult) {

        Result result = resultRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        result.setSubject(updatedResult.getSubject());
        result.setInternalMarks(updatedResult.getInternalMarks());
        result.setExternalMarks(updatedResult.getExternalMarks());
        result.setGrade(updatedResult.getGrade());
        result.setStatus(updatedResult.getStatus());
        result.setSemester(updatedResult.getSemester());

        return resultRepository.save(result);
    }

    // Delete result
    @DeleteMapping("/{id}")
    public String deleteResult(@PathVariable Long id) {

        resultRepository.deleteById(id);

        return "Result deleted successfully";
    }
}