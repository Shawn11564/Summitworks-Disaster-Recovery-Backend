package com.summitworks.disasterrecovery.models.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "object_data")
public class ObjectData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String code;
	private int hoursWorked;

	public ObjectData(String code, int hoursWorked) {
		this.code = code;
		this.hoursWorked = hoursWorked;
	}

}
