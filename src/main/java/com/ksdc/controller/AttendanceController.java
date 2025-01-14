package com.ksdc.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ksdc.entity.Attendance;
import com.ksdc.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {
	 @Autowired
	    private AttendanceService attendanceService;

	    @PostMapping("/mark")
	    public ResponseEntity<Attendance> markAttendance(@RequestBody Attendance attendance) {
	        Attendance marked = attendanceService.markAttendance(attendance);
	        return ResponseEntity.ok(marked);
	    }
	    
	    @GetMapping("/view/student/{id}")
	    public ResponseEntity<List<Attendance>> viewStudentAttendance(@PathVariable Integer id) {
	        return ResponseEntity.ok(attendanceService.viewStudentAttendance(id));
	    }
	    
	    @GetMapping("/view/teacher/{id}")
	    public ResponseEntity<List<Attendance>> viewTeacherAttendance(@PathVariable Integer id) {
	        return ResponseEntity.ok(attendanceService.viewTeacherAttendance(id));
	    }

}
