package com.robosh.ejournal.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class TeacherService {
//
//    private final TeacherRepository teacherRepository;
//    private final PasswordGenerator passwordGenerator;
//    private final ModelMapper modelMapper;
//    private final TeacherMapper teacherMapper;
//
//    public TeacherDto save(SaveTeacherDto dto) {
//        Teacher teacher = teacherMapper.fromSaveTeacherDtoToTeacher(dto);
//        teacher.setPassword(passwordGenerator.generateRandomPassword());
//
//        ValidatorProcessor.validate(teacher);
//
//        teacher = teacherRepository.save(teacher);
//        log.info("Teacher saved");
//        return teacherMapper.fromTeacherToTeacherDto(teacher);
//    }
//
//    public TeacherDto findById(Long id) {
//        return teacherMapper.fromTeacherToTeacherDto(findTeacherById(id));
//    }
//
//    public List<TeacherDto> findAllBySchoolId(Long id, int page, int size) {
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Teacher> paged = teacherRepository.findAllBySchoolId(id, pageable);
//        return teacherMapper.fromTeachersToTeachersDto(paged.getContent());
//    }
//
//
//    public TeacherDto updateTeacher(SaveTeacherDto dto) {
//        Teacher currentTeacher = findTeacherById(dto.getId());
//        Teacher updateTeacher = teacherMapper.fromSaveTeacherDtoToTeacher(dto);
//
//        modelMapper.map(updateTeacher, currentTeacher);
//        ValidatorProcessor.validate(currentTeacher);
//
//        currentTeacher = teacherRepository.save(currentTeacher);
//        log.info("teacher updated");
//        return teacherMapper.fromTeacherToTeacherDto(currentTeacher);
//    }
//
//    private Teacher findTeacherById(Long id) {
//        return teacherRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Teacher", "id", id));
//    }
}
