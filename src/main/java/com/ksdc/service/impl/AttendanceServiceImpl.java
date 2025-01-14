package com.ksdc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksdc.dto.User;
import com.ksdc.entity.Attendance;
import com.ksdc.repository.AttendanceRepository;
import com.ksdc.service.AttendanceService;
import com.ksdc.service.UserFeignClient;
@Service
public class AttendanceServiceImpl implements AttendanceService {
	@Autowired
    private AttendanceRepository attendanceRepository;
    
	@Autowired
    private UserFeignClient userFeignClient;
	
    public Attendance markAttendance(Attendance attendance) {
    	// Fetch student and teacher details from UserService
        User student = userFeignClient.getUserById(attendance.getStudentId());
        User teacher = userFeignClient.getUserById(attendance.getTeacherId());

        if (student == null || teacher == null) {
            throw new RuntimeException("Invalid student or teacher ID");
        }
        
        boolean isStudentValid = userFeignClient.validateUser(student);
        boolean isTeacherValid = userFeignClient.validateUser(teacher);

        if (!isStudentValid || !isTeacherValid) {
            throw new RuntimeException("Invalid student or teacher ID or roles");
        }

        // Enrich Attendance with user details
        attendance.setStudentId(student.getUserId());
        attendance.setTeacherId(teacher.getUserId());
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> viewStudentAttendance(Integer studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }

	@Override
	public List<Attendance> viewTeacherAttendance(Integer teacherId) {
		return attendanceRepository.findByTeacherId(teacherId);
	}
}
