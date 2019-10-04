package br.com.setebit.sgr.security.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import br.com.setebit.sgr.security.enums.PriorityEnum;
import br.com.setebit.sgr.security.enums.StatusEnum;

@Entity
public class Ticket implements Serializable {

	private static final long serialVersionUID = -8925918115492824551L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_Sequence")
	@SequenceGenerator(name = "ticket_Sequence", sequenceName = "TICKET_SEQ")
	@Column(name = "tic_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private Date date;

	private String title;

	private Integer number;

	private StatusEnum status;

	private PriorityEnum priority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "assi_id", nullable = false)
	private User assignedUser;

	private String description;

	private String image;

	@Transient
	private List<ChangeStatus> changes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public PriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<ChangeStatus> getChanges() {
		return changes;
	}

	public void setChanges(List<ChangeStatus> changes) {
		this.changes = changes;
	}

	public Ticket(Long id) {
		this.id = id;
	}

}
