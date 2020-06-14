package br.com.meiraonline.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployerUnionContribution implements Serializable{
	
	private static final long serialVersionUID = 468618323099052602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String employerUnion;

	private String contributionType;
	
	private Double contributionAmount;
	
	private String export;

	public EmployerUnionContribution() {
		super();
	}

	public EmployerUnionContribution(String name, String employerUnion, String contributionType,
			Double contributionAmount, String export) {
		super();
		this.name = name;
		this.employerUnion = employerUnion;
		this.contributionType = contributionType;
		this.contributionAmount = contributionAmount;
		this.export = export;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployerUnion() {
		return employerUnion;
	}

	public void setEmployerUnion(String employerUnion) {
		this.employerUnion = employerUnion;
	}

	public String getContributionType() {
		return contributionType;
	}

	public void setContributionType(String contributionType) {
		this.contributionType = contributionType;
	}

	public Double getContributionAmount() {
		return contributionAmount;
	}

	public void setContributionAmount(Double contributionAmount) {
		this.contributionAmount = contributionAmount;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployerUnionContribution other = (EmployerUnionContribution) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
