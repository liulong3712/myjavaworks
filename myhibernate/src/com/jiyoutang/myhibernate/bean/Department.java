package com.jiyoutang.myhibernate.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;
	
	@OneToOne
	@JoinColumn(name="line_manager_id")
	private Employee lineManager;
	
	@OneToMany(mappedBy="department")
	private Set<Employee> employees = new HashSet<Employee>();
}
