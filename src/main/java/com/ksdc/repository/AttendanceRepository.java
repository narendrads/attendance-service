package com.ksdc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksdc.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

	List<Attendance> findByStudentId(Integer studentId);

	List<Attendance> findByTeacherId(Integer teacherId);

}
