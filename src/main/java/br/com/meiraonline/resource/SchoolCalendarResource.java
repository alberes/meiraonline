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

import br.com.meiraonline.domain.SchoolCalendar;
import br.com.meiraonline.dto.MessageDTO;
import br.com.meiraonline.service.SchoolCalendarService;

@RestController
@RequestMapping(value = "/schoolCalendars")
public class SchoolCalendarResource {
	
	@Autowired
	private SchoolCalendarService schoolCalendarService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SchoolCalendar> insert(@Validated @RequestBody SchoolCalendar schoolCalendar, HttpServletResponse response){
		response.addHeader("access-control-expose-headers", "location");
		schoolCalendar = this.schoolCalendarService.insert(schoolCalendar);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(schoolCalendar.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<SchoolCalendar> find(@PathVariable Long id){
		SchoolCalendar schoolCalendar = schoolCalendarService.find(id);
		return ResponseEntity.ok().body(schoolCalendar);
	}
		
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<SchoolCalendar>> find(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<SchoolCalendar> schoolCalendars = schoolCalendarService.findAll(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok(schoolCalendars);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Validated @RequestBody SchoolCalendar schoolCalendar, @PathVariable Long id){
		schoolCalendar.setId(id);
		this.schoolCalendarService.update(schoolCalendar);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/export/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<MessageDTO> export(@PathVariable Long id){
		SchoolCalendar schoolCalendar = this.schoolCalendarService.export(id);
		MessageDTO message = new MessageDTO();
		message.setDate(new Date());
		if(schoolCalendar == null) {
			message.setStatus("NOK");
			message.setMessage("There is no Sick Leave for employee " + id + ".");
		}else {
			message.setStatus("OK");
			message.setMessage("Found " + schoolCalendar.getId() + " and exported with success");
		}
		return ResponseEntity.ok(message);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		this.schoolCalendarService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
