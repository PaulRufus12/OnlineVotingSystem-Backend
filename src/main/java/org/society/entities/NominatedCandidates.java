package org.society.entities;

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
@Table(name = "nominated_candidates")
public class NominatedCandidates {
	@Id
	@Column(name = "candidate_id")
	private int candidateId;

	@Column(name = "nomination_form_no")
	private String nominationFormNo;


	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id")
	RegisteredSocietyVoters society_Voter;

	public NominatedCandidates() {}

	public NominatedCandidates(int candidateId, String nominationFormNo,RegisteredSocietyVoters society_Voter) {

		this.candidateId = candidateId;
		this.nominationFormNo = nominationFormNo;
		this.society_Voter = society_Voter;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getNominationFormNo() {
		return nominationFormNo;
	}

	public void setNominationFormNo(String nominationFormNo) {
		this.nominationFormNo = nominationFormNo;
	}

	public RegisteredSocietyVoters getSociety_Voter() {
		return society_Voter;
	}

	public void setSociety_Voter(RegisteredSocietyVoters society_Voter) {
		this.society_Voter = society_Voter;
	}

	@Override
	public String toString() {
		return "NominatedCandidates [candidateId=" + candidateId + ", nominationFormNo=" + nominationFormNo
				+ ", society_Voter=" + society_Voter + "]";
	}


}
