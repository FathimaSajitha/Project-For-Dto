package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.ProjectEntity;
import com.app.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProjectEntity saveProject(ProjectEntity projectEntity) {
		return projectRepository.save(projectEntity);
	}

	@Override
	public List<ProjectEntity> getAllProject() {
		return projectRepository.findAll();
	}



	@Override
	public void deleteProjectById(Integer id) {
		projectRepository.delete(getById(id));
		
	}

	@Override
	public ProjectEntity updateProject(ProjectEntity projectEntity) {
		return projectRepository.save(projectEntity);
		
	}

	@Override
	public ProjectEntity getById(Integer id) {
		// TODO Auto-generated method stub
		return (ProjectEntity) projectRepository.findAll();
		
	}

//	@Override
//	public List<ProjectEntity> getAllProject(int id) {
//		// TODO Auto-generated method stub
//		return projectRepository.findAllById(id);
//	}

	

	
}
