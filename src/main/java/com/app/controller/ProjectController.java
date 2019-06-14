package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ProjectDTO;
import com.app.dtoMapper.ProjectDtoMapper;
import com.app.entity.ProjectEntity;
@RestController
public class ProjectController {
	@Autowired
//	public ProjectService projectService;
	
	public ProjectDtoMapper projectDtoMapper;
	
	@PostMapping("/saveProject")
	public HttpStatus createproject(@Valid @RequestBody ProjectDTO projectDTO ) {
		projectDtoMapper.saveProject(projectDTO);
		return HttpStatus.CREATED;
	}
	@GetMapping("/getAllProjects")
	public List<ProjectDTO> getAllProjects(){
		return projectDtoMapper.getAllProjects();
	}
	
	/*@GetMapping("getAllProjectsById/{id}")
	public ResponseEntity<ProjectDTO> getAllProjectsById(@PathVariable("id")Integer id){
		
		return new ResponseEntity<ProjectDTO>(HttpStatus.OK);
	}*/

//	@GetMapping("/getAllProjectsById/{id}")
//	public List<ProjectDTO> getAllProjectsById(@PathVariable("id") int id){
//		return projectDtoMapper.getAllProjectsById(id);
//	}
	
	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<ProjectEntity> deleteProject(@PathVariable("id") Integer id){
		projectDtoMapper.deleteProject(id);
		return new ResponseEntity<ProjectEntity>(HttpStatus.NO_CONTENT);
		
	}
	@PutMapping("/updateProject")
	public ResponseEntity<ProjectEntity>updateProject(@Valid @RequestBody ProjectEntity projectEntity){
		projectDtoMapper.updateProject(projectEntity);
		return new ResponseEntity<ProjectEntity>(projectEntity,HttpStatus.NO_CONTENT);
	}
}
