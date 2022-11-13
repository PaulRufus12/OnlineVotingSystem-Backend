package org.society.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cooperative_society")
public class CooperativeSociety {
	@Id
	@Column(name = "society_id")
	private int societyId;
	@Column(name ="societyname")
	private String societyName;
	@Column(name = "headofsociety")
	private String headOfSociety;
	@Column(name = "village")
	private String village;
	@Column(name = "mandal")
	private String mandal;
	@Column(name = "district")
	private String district;
	@Column(name = "pincode")
	private String pincode;

	public CooperativeSociety() {}

	public CooperativeSociety(int societyId, String societyName, String headOfSociety, String village, String mandal,
			String district, String pincode) {

		this.societyId = societyId;
		this.societyName = societyName;
		this.headOfSociety = headOfSociety;
		this.village = village;
		this.mandal = mandal;
		this.district = district;
		this.pincode = pincode;
	}

	public int getSocietyId() {
		return societyId;
	}

	public void setSocietyId(int societyId) {
		this.societyId = societyId;
	}

	public String getSocietyName() {
		return societyName;
	}

	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	public String getHeadOfSociety() {
		return headOfSociety;
	}

	public void setHeadOfSociety(String headOfSociety) {
		this.headOfSociety = headOfSociety;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "CooperativeSociety [societyId=" + societyId + ", societyName=" + societyName + ", headOfSociety="
				+ headOfSociety + ", village=" + village + ", mandal=" + mandal + ", district=" + district
				+ ", pincode=" + pincode + "]";
	}


}
