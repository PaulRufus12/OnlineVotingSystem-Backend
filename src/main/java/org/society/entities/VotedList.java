package org.society.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name ="voted_list")
public class VotedList {

	@Id
	@Column(name="voteid")
	private int id;
	
	@Column(name = "polling_date_time")
	private Date pollingDateTime;


	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="society_id")
	private CooperativeSociety society;


	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id")
	private RegisteredSocietyVoters voter;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="candidate_id")
	private NominatedCandidates candidate;


	public VotedList() {}

	public VotedList(int id, Date pollingDateTime, CooperativeSociety society, RegisteredSocietyVoters voter,
			NominatedCandidates candidate) {

		this.id = id;
		this.pollingDateTime = pollingDateTime;
		this.society = society;
		this.voter = voter;
		this.candidate = candidate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPollingDateTime() {
		return pollingDateTime;
	}

	public void setPollingDateTime(Date pollingDateTime) {
		this.pollingDateTime = pollingDateTime;
	}

	public CooperativeSociety getSociety() {
		return society;
	}

	public void setSociety(CooperativeSociety society) {
		this.society = society;
	}

	public RegisteredSocietyVoters getVoter() {
		return voter;
	}

	public void setVoter(RegisteredSocietyVoters voter) {
		this.voter = voter;
	}

	public NominatedCandidates getCandidate() {
		return candidate;
	}

	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}



}
