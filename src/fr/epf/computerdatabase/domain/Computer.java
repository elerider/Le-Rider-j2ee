package fr.epf.computerdatabase.domain;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

@Entity
@Table(name="computer")
public class Computer {
	
	@Id
	@Column(name="id",nullable=false)
	@GeneratedValue
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name ;
	
	@Column(name="introduced")
	private Date introduced;
	
	@Column(name="discontinued")
	private Date discontinued;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="company_id",nullable=true)
	 @Fetch(FetchMode.JOIN)
	private Company company;
	
	public Computer(){
		
	}
	
	public Computer(Long id, String name, Date introduced,
			Date discontinued, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.introduced = introduced;
		this.discontinued = discontinued;
		this.company = company;
	}
	
	
	public Date getDiscontinued() {
		return discontinued;
	}

	@Override
	public String toString() {
		return "Computer [id=" + id + ", name=" + name + ", introduced="
				+ introduced + ", discontinued=" + discontinued
				+ ", companyId=" + company + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((discontinued == null) ? 0 : discontinued.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((introduced == null) ? 0 : introduced.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Computer other = (Computer) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (discontinued == null) {
			if (other.discontinued != null)
				return false;
		} else if (!discontinued.equals(other.discontinued))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (introduced == null) {
			if (other.introduced != null)
				return false;
		} else if (!introduced.equals(other.introduced))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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
	public Date getIntroduced() {
		return introduced;
	}
	public void setIntroduced(Date introduced) {
		this.introduced = introduced;
	}
	public Date isDiscontinued() {
		return discontinued;
	}
	public void setDiscontinued(Date discontinued) {
		this.discontinued = discontinued;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public static Builder builder(){
		return new Builder();
	}
	
	public static class Builder{
		
		private Computer computer;
		
		public Builder(){
			computer = new Computer();
		}
		
		public Builder id(Long id){
			computer.id = id;
			return this;
		}
		
		public Builder name(String name){
			computer.name = name;
			return this;
		}
		
		public Builder discontinued(Date discontinued){
			computer.discontinued = discontinued;
			return this;
		}
		
		public Builder introduced(Date introduced){
			computer.introduced = introduced;
			return this;
		}
		
		public Builder company(Company company){
			computer.company = company;
			return this;
		}

		public Computer build() {
			// TODO Auto-generated method stub
			return computer;
		}
	}
	
	
}
