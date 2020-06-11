package br.com.meiraonline.resource;

import java.net.URI;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.meiraonline.domain.SickLeave;
import br.com.meiraonline.dto.MessageDTO;
import br.com.meiraonline.service.SickLeaveService;

@RestController
@RequestMapping(value = "/sickleaves")
public class SickLeaveResource {
	
	@Autowired
	private SickLeaveService sickLeaveService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Validated @RequestBody  SickLeave sickLeave, HttpServletResponse response){
		response.addHeader("access-control-expose-headers", "location");
		sickLeave = sickLeaveService.save(sickLeave);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
		path("/{id}").buildAndExpand(sickLeave.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SickLeave> find(@PathVariable Long id){
		SickLeave sickLeave = sickLeaveService.find(id);
		return ResponseEntity.ok().body(sickLeave);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/employee/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<Page<SickLeave>> find(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable Long employeeId){
		Page<SickLeave> sickLeaves = sickLeaveService.findAll(page, linesPerPage, orderBy, direction, employeeId);
		return ResponseEntity.ok(sickLeaves);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody SickLeave sickLeave, @PathVariable Long id){
		sickLeave.setId(id);
		this.sickLeaveService.update(sickLeave);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/export/{employeeId}", method=RequestMethod.PATCH)
	public ResponseEntity<MessageDTO> export(@PathVariable Long employeeId){
		int quantity = this.sickLeaveService.export(employeeId);
		MessageDTO message = new MessageDTO();
		message.setDate(new Date());
		if(quantity > 0) {
			message.setStatus("OK");
			message.setMessage("Found " + quantity + " and exports with success");
		}else {
			message.setStatus("NOK");
			message.setMessage("There is no Sick Leave for employee " + employeeId + ".");
		}
		return ResponseEntity.ok(message);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.sickLeaveService.delete(id);
		System.out.println("Excluindo o objeto " + id);
		return ResponseEntity.noContent().build();
	}

}
