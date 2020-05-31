package br.com.meiraonline.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NoticeTermination implements Serializable{

	private static final long serialVersionUID = -4054388127601192589L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long noticeTypeId;
	
	private Long noticeReasonId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date noticeDate;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date lastDay;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	
	private String noticeStatus;
	
	private Long noticeTypeWorkedId;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date cancelDate;
	
	private Long cancelNoticeReasonId;
	
	private String export;
	
	@MapsId
	@OneToOne(optional=false,fetch=FetchType.EAGER)
	@JoinColumn(name = "id")
	private Employee employee;

	public NoticeTermination() {
		super();
	}

	public NoticeTermination(Long noticeTypeId, Long noticeReasonId, Date noticeDate, Date lastDay, Date endDate,
			String noticeStatus, Long noticeTypeWorkedId, Date cancelDate, Long cancelNoticeReasonId, String export) {
		super();
		this.noticeTypeId = noticeTypeId;
		this.noticeReasonId = noticeReasonId;
		this.noticeDate = noticeDate;
		this.lastDay = lastDay;
		this.endDate = endDate;
		this.noticeStatus = noticeStatus;
		this.noticeTypeWorkedId = noticeTypeWorkedId;
		this.cancelDate = cancelDate;
		this.cancelNoticeReasonId = cancelNoticeReasonId;
		this.export = export;
	}

	public NoticeTermination(Long noticeTypeId, Long noticeReasonId, Date noticeDate, Date lastDay, Date endDate,
			String noticeStatus, Long noticeTypeWorkedId, Date cancelDate, Long cancelNoticeReasonId, String export,
			Employee employee) {
		super();
		this.noticeTypeId = noticeTypeId;
		this.noticeReasonId = noticeReasonId;
		this.noticeDate = noticeDate;
		this.lastDay = lastDay;
		this.endDate = endDate;
		this.noticeStatus = noticeStatus;
		this.noticeTypeWorkedId = noticeTypeWorkedId;
		this.cancelDate = cancelDate;
		this.cancelNoticeReasonId = cancelNoticeReasonId;
		this.export = export;
		this.employee = employee;
	}

	public NoticeTermination(Long id, Long noticeTypeId, Long noticeReasonId, Date noticeDate, Date lastDay,
			Date endDate, String noticeStatus, Long noticeTypeWorkedId, Date cancelDate, Long cancelNoticeReasonId,
			String export, Employee employee) {
		super();
		this.id = id;
		this.noticeTypeId = noticeTypeId;
		this.noticeReasonId = noticeReasonId;
		this.noticeDate = noticeDate;
		this.lastDay = lastDay;
		this.endDate = endDate;
		this.noticeStatus = noticeStatus;
		this.noticeTypeWorkedId = noticeTypeWorkedId;
		this.cancelDate = cancelDate;
		this.cancelNoticeReasonId = cancelNoticeReasonId;
		this.export = export;
		this.employee = employee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNoticeTypeId() {
		return noticeTypeId;
	}

	public void setNoticeTypeId(Long noticeTypeId) {
		this.noticeTypeId = noticeTypeId;
	}

	public Long getNoticeReasonId() {
		return noticeReasonId;
	}

	public void setNoticeReasonId(Long noticeReasonId) {
		this.noticeReasonId = noticeReasonId;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public Date getLastDay() {
		return lastDay;
	}

	public void setLastDay(Date lastDay) {
		this.lastDay = lastDay;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNoticeStatus() {
		return noticeStatus;
	}

	public void setNoticeStatus(String noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

	public Long getNoticeTypeWorkedId() {
		return noticeTypeWorkedId;
	}

	public void setNoticeTypeWorkedId(Long noticeTypeWorkedId) {
		this.noticeTypeWorkedId = noticeTypeWorkedId;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}

	public Long getCancelNoticeReasonId() {
		return cancelNoticeReasonId;
	}

	public void setCancelNoticeReasonId(Long cancelNoticeReasonId) {
		this.cancelNoticeReasonId = cancelNoticeReasonId;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeTermination other = (NoticeTermination) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NoticeTermination [id=" + id + ", noticeTypeId=" + noticeTypeId + ", noticeReasonId=" + noticeReasonId
				+ ", noticeDate=" + noticeDate + ", lastDay=" + lastDay + ", endDate=" + endDate + ", noticeStatus="
				+ noticeStatus + ", noticeTypeWorkedId=" + noticeTypeWorkedId + ", cancelDate=" + cancelDate
				+ ", cancelNoticeReasonId=" + cancelNoticeReasonId + ", export=" + export + ", employee=" + employee
				+ "]";
	}

}