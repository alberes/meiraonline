package br.com.meiraonline.resource;

import java.net.URI;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.meiraonline.domain.NoticeTermination;
import br.com.meiraonline.service.NoticeTerminationService;

@RestController
@RequestMapping(value = "/terminationotices")
public class NoticeTerminationResource {
	
	@Autowired
	private NoticeTerminationService noticeTerminationService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Validated @RequestBody NoticeTermination noticeTermination, HttpServletResponse response){
		response.addHeader("access-control-expose-headers", "location");
		noticeTermination = this.noticeTerminationService.insert(noticeTermination);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(noticeTermination.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<NoticeTermination> find(@PathVariable Long id){
		NoticeTermination noticeTermination = noticeTerminationService.find(id);
		return ResponseEntity.ok().body(noticeTermination);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/employee/{employeeId}", method=RequestMethod.GET)
	public ResponseEntity<NoticeTermination> findByEmployee(@PathVariable Long employeeId){
		NoticeTermination noticeTermination = noticeTerminationService.findByEmployee(employeeId);
		return ResponseEntity.ok().body(noticeTermination);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody NoticeTermination noticeTermination, @PathVariable Long id){
		noticeTermination.setId(id);
		this.noticeTerminationService.update(noticeTermination);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="{id}", method=RequestMethod.PATCH)
	public ResponseEntity<Void> export(@Validated @RequestBody Map<String, Object> noticeTerminationBody, @PathVariable Long id){
		NoticeTermination noticeTermination = new NoticeTermination();
		noticeTermination.setId(id);
		noticeTermination.setExport((String)noticeTerminationBody.get("export"));
		this.noticeTerminationService.export(noticeTermination);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.noticeTerminationService.delete(id);
		return ResponseEntity.noContent().build();
	}
}