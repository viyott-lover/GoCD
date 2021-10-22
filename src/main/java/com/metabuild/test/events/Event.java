package com.metabuild.test.events;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Event {
	
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime beginEnrollmentDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime closeEnrollmentDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime beginEventDateTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private LocalDateTime endEventDateTime;
	
	private String location;
	private int basePrice;
	private int maxPrice;
	private int limitOfEnrollment;
	private boolean offline;
	private boolean free;
	
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus = EventStatus.DRAFT;
	
}
