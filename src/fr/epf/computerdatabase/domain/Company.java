package fr.epf.computerdatabase.domain;

import fr.epf.computerdatabase.domain.Computer.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name;
		
		public Company(){
			
		}
		
		@Override
		public String toString() {
			return "Company [id=" + id + ", name=" + name + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Company other = (Company) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		public Company(Long id, String name) {
			super();
			this.id = id;
			this.name = name;
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
		
		public static Builder builder(){
			return new Builder();
		}
		
		public static class Builder{
			private Company company;
			
			private Builder(){
				company = new Company();
			}
			
			public Builder id(Long id){
				company.id = id;
				return this;
			}
			public Builder name(String name){
				company.name = name;
				return this;
			}
			public Company build(){
				return company;
			}
		}

}
