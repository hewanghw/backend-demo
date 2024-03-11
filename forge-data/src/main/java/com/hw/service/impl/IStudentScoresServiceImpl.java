package com.hw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hw.entity.StudentScores;
import com.hw.mapper.StudentScoresMapper;
import com.hw.service.IStudentScoresService;
import org.springframework.stereotype.Service;

@Service
public class IStudentScoresServiceImpl extends ServiceImpl<StudentScoresMapper, StudentScores> implements IStudentScoresService {
}
