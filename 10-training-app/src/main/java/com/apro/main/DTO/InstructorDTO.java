package com.apro.main.DTO;

import com.apro.main.entity.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor


public class InstructorDTO {
	
	private int instructorId;

	private String instructorName;
	
	private String email;

	private String qualification;
	
	public static Instructor toInstructorMapper(InstructorDTO instructorDTO) {
		Instructor instructor = new Instructor();
		instructor.setInstructorId(instructorDTO.getInstructorId());
		instructor.setEmail(instructorDTO.getEmail());
		instructor.setInstructorName(instructorDTO.getInstructorName());
		instructor.setQualification(instructorDTO.getQualification());
		return instructor;
	}
	
	public static InstructorDTO toInstructorDTOMapper(Instructor instructor) {
		InstructorDTO instructorDTO = new InstructorDTO();
		instructorDTO.setEmail(instructor.getEmail());
		instructorDTO.setInstructorId(instructor.getInstructorId());
		instructorDTO.setInstructorName(instructor.getInstructorName());
		instructorDTO.setQualification(instructor.getQualification());
		return instructorDTO;
	}
}
