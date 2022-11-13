package org.society.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Electionresult")
public class ElectionResult {
	@Id
	@Column(name = "resultid")
	private int id;
	
	@Column(name = "pollingdate")
	private Date pollingDate;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="candidate_id")
	NominatedCandidates candidate;

	@Column(name = " COOP_SOCIETYNAME")
	private String coop_SocietyName;
	@Column(name = "TOTALSOCIETYVOTES")
	private int totalSocietyVotes;
	@Column(name = "TOTALPOLLEDVOTES")
	private int totalPolledVotes;
	@Column(name = " TOTALPOLLINGPERCENTAGE")
	private float totalPollingPercentage;
	@Column(name = "TOTALCANDIDATEVOTES")
	private int totalCandidateVotes;
	@Column(name = "CANDIDATEVOTESPERCENTAGE")
	private float candidateVotesPercentage;
	@Column(name = "result")
	private String result;

	public ElectionResult() {}

	public ElectionResult(int id, Date pollingDate, NominatedCandidates candidate, String coop_SocietyName,
			int totalSocietyVotes, int totalPolledVotes, float totalPollingPercentage, int totalCandidateVotes,
			float candidateVotesPercentage, String result) {

		this.id = id;
		this.pollingDate = pollingDate;
		this.candidate = candidate;
		this.coop_SocietyName = coop_SocietyName;
		this.totalSocietyVotes = totalSocietyVotes;
		this.totalPolledVotes = totalPolledVotes;
		this.totalPollingPercentage = totalPollingPercentage;
		this.totalCandidateVotes = totalCandidateVotes;
		this.candidateVotesPercentage = candidateVotesPercentage;
		this.result = result;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPollingDate() {
		return pollingDate;
	}

	public void setPollingDate(Date pollingDate) {
		this.pollingDate = pollingDate;
	}

	public NominatedCandidates getCandidate() {
		return candidate;
	}

	public void setCandidate(NominatedCandidates candidate) {
		this.candidate = candidate;
	}

	public String getCoop_SocietyName() {
		return coop_SocietyName;
	}

	public void setCoop_SocietyName(String coop_SocietyName) {
		this.coop_SocietyName = coop_SocietyName;
	}

	public int getTotalSocietyVotes() {
		return totalSocietyVotes;
	}

	public void setTotalSocietyVotes(int totalSocietyVotes) {
		this.totalSocietyVotes = totalSocietyVotes;
	}

	public int getTotalPolledVotes() {
		return totalPolledVotes;
	}

	public void setTotalPolledVotes(int totalPolledVotes) {
		this.totalPolledVotes = totalPolledVotes;
	}

	public float getTotalPollingPercentage() {
		return totalPollingPercentage;
	}

	public void setTotalPollingPercentage(float totalPollingPercentage) {
		this.totalPollingPercentage = totalPollingPercentage;
	}

	public int getTotalCandidateVotes() {
		return totalCandidateVotes;
	}

	public void setTotalCandidateVotes(int totalCandidateVotes) {
		this.totalCandidateVotes = totalCandidateVotes;
	}

	public float getCandidateVotesPercentage() {
		return candidateVotesPercentage;
	}

	public void setCandidateVotesPercentage(float candidateVotesPercentage) {
		this.candidateVotesPercentage = candidateVotesPercentage;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ElectionResult [id=" + id + ", pollingDate=" + pollingDate + ", candidate=" + candidate
				+ ", coop_SocietyName=" + coop_SocietyName + ", totalSocietyVotes=" + totalSocietyVotes
				+ ", totalPolledVotes=" + totalPolledVotes + ", totalPollingPercentage=" + totalPollingPercentage
				+ ", totalCandidateVotes=" + totalCandidateVotes + ", candidateVotesPercentage="
				+ candidateVotesPercentage + ", result=" + result + "]";
	}


}
