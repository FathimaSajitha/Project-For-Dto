package com.app.dtoMapper;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ProjectDTO;
import com.app.entity.ProjectEntity;
import com.app.service.ProjectService;



@Service
public class ProjectDtoMapper {
	
	@Autowired
	public ProjectService projectService;
	
	ModelMapper modelMapper = new ModelMapper();
	
	PropertyMap<ProjectDTO, ProjectEntity> projectMap = new PropertyMap<ProjectDTO, ProjectEntity>() {
		protected void configure() {
			map().setProjectName(source.getProjectName());
			map().setProjectType(source.getProjectType());
			map().setStartDate(source.getStartDate());
			map().setEndDate(source.getEndDate());
			map().setDuration(source.getDuration());
			map().setStatus(source.getStatus());
			

		}
	};
	
	@SuppressWarnings("unused")
	private ProjectDtoMapper EntityToDTO(ProjectEntity projectEntity) {
		ProjectDtoMapper projectDTO = modelMapper.map(projectEntity, ProjectDtoMapper.class);
		return projectDTO;
	}
	
	
	public ProjectEntity saveProject(ProjectDTO projectDTO) {
		TypeMap<ProjectDTO, ProjectEntity> typeMap = modelMapper.getTypeMap(ProjectDTO.class, ProjectEntity.class );
		if(typeMap==null) {
			modelMapper.addMappings(projectMap);
		}
		
		ProjectEntity projectEntity = modelMapper.map(projectDTO, ProjectEntity.class);
		return projectService.saveProject(projectEntity);
	}
	public List<ProjectDTO> getAllProjects(){
		List<ProjectEntity> projectEntity=projectService.getAllProject();
		Type listType =new TypeToken<List<ProjectDTO>>() {}.getType();
		List<ProjectDTO> getpr= new ModelMapper().map(projectEntity, listType);
		return getpr;
	}
	
	public List<ProjectDTO> getAllProjectsById(int id){
		List<ProjectEntity> projectEntity=projectService.getAllProject();
		Type listType =new TypeToken<List<ProjectDTO>>() {}.getType();
		List<ProjectDTO> getpr= new ModelMapper().map(projectEntity, listType);
		return getpr;
	}
	public ProjectDTO deleteProject(int projectId) {
		projectService.deleteProjectById(projectId);
		return null;
	}
	public void updateProject(ProjectEntity projectEntity2) {
		ProjectEntity projectEntity = modelMapper.map(projectEntity2, ProjectEntity.class);
		EntityToDTO(projectService.updateProject(projectEntity));
	}


//	public ProjectDtoMapper getById(Integer id) {
//		return EntityToDTO(projectService.getById(id));
//	}

}
