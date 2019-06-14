package com.app.entity;



import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema="project", name="project")
public class ProjectEntity   implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
		
	    @Column(name="project_id")
		private int projectId;
	    
	    @Column(name="project_name")
		private String projectName;
	    
	    @Column(name="project_type")
	    private String projectType;
	     
	    @Column(name="start_date")
		private Date startDate;
	    
	    @Column(name="end_date")
		private Date endDate;
	    
	    @Column(name="duration")
		private String duration;
	    
	    @Column(name="status")
		private String status;

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getProjectType() {
			return projectType;
		}

		public void setProjectType(String projectType) {
			this.projectType = projectType;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}


	
}
