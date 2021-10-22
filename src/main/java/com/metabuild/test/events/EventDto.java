package com.metabuild.test.events;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
	
	// NotNull은 Null만 불가능 "", " "는 허용
	// NotEmpty는 Null과 ""가 불가능
	// NotBlank는 Null과 "", " "가 모두 불가능
	
	@NotEmpty
	private String name;
	@NotEmpty
	private String description;
	@NotNull
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime beginEnrollmentDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime closeEnrollmentDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime beginEventDateTIme;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime endEventDateTime;
	
	private String location;
	@Min(0)
	private int basePrice;
	private int maxPrice;
	private int limitOfEnrollment;
		
}
