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

import br.com.meiraonline.domain.PreliminaryRegistration;
import br.com.meiraonline.dto.MessageDTO;
import br.com.meiraonline.service.PreliminaryRegistrationService;

@RestController
@RequestMapping(value = "/preliminaryregistrations")
public class PreliminaryRegistrationResource {
	
	@Autowired
	private PreliminaryRegistrationService preliminaryRegistrationService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PreliminaryRegistration> save(@Validated @RequestBody PreliminaryRegistration preliminaryRegistration, HttpServletResponse response){
		response.addHeader("access-control-expose-headers", "location");
		preliminaryRegistration = this.preliminaryRegistrationService.save(preliminaryRegistration);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(preliminaryRegistration.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<PreliminaryRegistration> find(@PathVariable Long id){
		PreliminaryRegistration preliminaryRegistration = this.preliminaryRegistrationService.find(id);
		return ResponseEntity.ok(preliminaryRegistration);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PreliminaryRegistration>> find(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<PreliminaryRegistration> preliminaryRegistrations = this.preliminaryRegistrationService.findAll(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(preliminaryRegistrations);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody PreliminaryRegistration preliminaryRegistration, @PathVariable Long id){
		preliminaryRegistration.setId(id);
		this.preliminaryRegistrationService.update(preliminaryRegistration);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/export/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<MessageDTO> export(@PathVariable Long id){
		PreliminaryRegistration preliminaryRegistration = this.preliminaryRegistrationService.export(id);
		MessageDTO message = new MessageDTO();
		message.setDate(new Date());
		if(preliminaryRegistration == null) {
			message.setStatus("NOK");
			message.setMessage("There is no Preliminary Registration for employee " + id + ".");
		}else {
			message.setStatus("OK");
			message.setMessage("Found " + preliminaryRegistration.getId() + " and exported with success");
		}
		return ResponseEntity.ok(message);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.preliminaryRegistrationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
