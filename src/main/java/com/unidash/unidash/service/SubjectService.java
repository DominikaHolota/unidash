package com.unidash.unidash.service;

import com.unidash.unidash.entity.Subjects;
import com.unidash.unidash.repo.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void saveSubject(Subjects subject) {
        subjectRepository.save(subject);
    }

    public Subjects findByName(String name) {
        Subjects subject = subjectRepository.findByName(name);
        return subject;

    }

}
