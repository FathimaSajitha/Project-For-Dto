package com.app.service;

import java.util.List;

import com.app.entity.ProjectEntity;

public interface ProjectService {
	ProjectEntity saveProject(ProjectEntity projectEntity);
	List<ProjectEntity> getAllProject();
//	List<ProjectEntity> getAllProject(int id );
	ProjectEntity getById(Integer id);
	void deleteProjectById(Integer id);
	ProjectEntity updateProject(ProjectEntity projectEntity);
}
