package com.klu.studentlearningtracer.service;

import com.klu.studentlearningtracer.model.Assessment;
import com.klu.studentlearningtracer.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    @Autowired
    private AssessmentRepository assessmentRepository;

    // Fetch all assessments
    public List<Assessment> getAllAssessments() {
        return assessmentRepository.findAll();
    }

    // Fetch an assessment by ID
    public Optional<Assessment> getAssessmentById(Long id) {
        return assessmentRepository.findById(id);
    }

    // Save a new or updated assessment
    public void saveAssessment(Assessment assessment) {
        assessmentRepository.save(assessment);
    }

    // Delete an assessment by ID
    public void deleteAssessment(Long id) {
        assessmentRepository.deleteById(id);
    }

    // Update the assessment details by ID
    public Assessment updateAssessment(Long id, Assessment updatedAssessment) {
        Optional<Assessment> existingAssessment = assessmentRepository.findById(id);
        if (existingAssessment.isPresent()) {
            Assessment assessment = existingAssessment.get();
            assessment.setName(updatedAssessment.getName());
            assessment.setDueDate(updatedAssessment.getDueDate());
            return assessmentRepository.save(assessment);
        } else {
            throw new RuntimeException("Assessment not found with ID: " + id);
        }
    }
}
