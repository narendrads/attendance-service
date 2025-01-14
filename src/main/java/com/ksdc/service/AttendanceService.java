package com.ksdc.service;

import java.util.List;

import com.ksdc.entity.Attendance;

public interface AttendanceService {

	Attendance markAttendance(Attendance attendance);

	List<Attendance> viewStudentAttendance(Integer id);

	List<Attendance>  viewTeacherAttendance(Integer id);

}
