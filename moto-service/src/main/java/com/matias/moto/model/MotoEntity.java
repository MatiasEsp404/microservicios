package com.matias.moto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MOTO_ENTITY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MotoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String brand;
	@Column(nullable = false)
	private String model;
	@Column
	private Integer userId;
}
