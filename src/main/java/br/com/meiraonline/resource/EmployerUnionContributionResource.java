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

import br.com.meiraonline.domain.EmployerUnionContribution;
import br.com.meiraonline.dto.MessageDTO;
import br.com.meiraonline.service.EmployerUnionContributionService;

@RestController
@RequestMapping(value = "/employersunioncontribution")
public class EmployerUnionContributionResource {
	
	@Autowired
	private EmployerUnionContributionService employerUnionContributionService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@Validated @RequestBody EmployerUnionContribution employerUnionContribution, HttpServletResponse response){
		response.addHeader("access-control-expose-headers", "location");
		this.employerUnionContributionService.save(employerUnionContribution);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(employerUnionContribution.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployerUnionContribution> find(@PathVariable Long id){
		EmployerUnionContribution employerUnionContribution = this.employerUnionContributionService.find(id);
		return ResponseEntity.ok().body(employerUnionContribution);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/company/{companyId}", method = RequestMethod.GET)
	public ResponseEntity<Page<EmployerUnionContribution>> find(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<EmployerUnionContribution> employersUnionContribution = this.employerUnionContributionService.findAll(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(employersUnionContribution);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody EmployerUnionContribution employerUnionContribution, @PathVariable Long id){
		employerUnionContribution.setId(id);
		employerUnionContribution = this.employerUnionContributionService.update(employerUnionContribution);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/export/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<MessageDTO> export(@PathVariable Long id){
		EmployerUnionContribution employerUnionContribution = this.employerUnionContributionService.export(id);
		MessageDTO message = new MessageDTO();
		message.setDate(new Date());
		if(employerUnionContribution == null) {
			message.setStatus("NOK");
			message.setMessage("There is no Employer Union Contribution " + id + ".");
		}else {
			message.setStatus("OK");
			message.setMessage("Found " + employerUnionContribution.getId() + " and exported with success");
		}
		return ResponseEntity.ok(message);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.employerUnionContributionService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
