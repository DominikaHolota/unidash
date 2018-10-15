package com.unidash.unidash.service;

import com.unidash.unidash.entity.Grades;
import com.unidash.unidash.entity.Notices;
import com.unidash.unidash.repo.GradeRepository;
import com.unidash.unidash.repo.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gradeService")
public class GradeService {

    private GradeRepository gradeRepository;


    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void saveGrade(Grades grade) {
        gradeRepository.save(grade);
    }
}
