package ecms.placement.portal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "academic_info")
public class AcademicInfo {

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(precision = 3, scale = 2)
	@NotNull
	private float ssc_aggr;

	@Column(precision = 3, scale = 2)
	@NotNull
	private float inter_aggr;
	
	@NotNull
	@Column(precision = 3, scale = 2)
	private float b11_aggr;
	
	@NotNull
	@Column(precision = 3, scale = 2)
	private float b12_aggr;
	
	@NotNull
	@Column(precision = 3, scale = 2)
	private float b21_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float b22_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float b31_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float b32_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float b41_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float b42_aggr;

	@NotNull
	@Column(precision = 3, scale = 2)
	private float total_aggr;

	public AcademicInfo() {
		// TODO Auto-generated constructor stub
	}

	public AcademicInfo(float ssc_aggr, float inter_aggr, float b11_aggr, float b12_aggr, float b21_aggr,
			float b22_aggr, float b31_aggr, float b32_aggr, float b41_aggr, float b42_aggr, float total_aggr) {
		this.ssc_aggr = ssc_aggr;
		this.inter_aggr = inter_aggr;
		this.b11_aggr = b11_aggr;
		this.b12_aggr = b12_aggr;
		this.b21_aggr = b21_aggr;
		this.b22_aggr = b22_aggr;
		this.b31_aggr = b31_aggr;
		this.b32_aggr = b32_aggr;
		this.b41_aggr = b41_aggr;
		this.b42_aggr = b42_aggr;
		this.total_aggr = total_aggr;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getSsc_aggr() {
		return ssc_aggr;
	}

	public void setSsc_aggr(float ssc_aggr) {
		this.ssc_aggr = ssc_aggr;
	}

	public float getInter_aggr() {
		return inter_aggr;
	}

	public void setInter_aggr(float inter_aggr) {
		this.inter_aggr = inter_aggr;
	}

	public float getB11_aggr() {
		return b11_aggr;
	}

	public void setB11_aggr(float b11_aggr) {
		this.b11_aggr = b11_aggr;
	}

	public float getB12_aggr() {
		return b12_aggr;
	}

	public void setB12_aggr(float b12_aggr) {
		this.b12_aggr = b12_aggr;
	}

	public float getB21_aggr() {
		return b21_aggr;
	}

	public void setB21_aggr(float b21_aggr) {
		this.b21_aggr = b21_aggr;
	}

	public float getB22_aggr() {
		return b22_aggr;
	}

	public void setB22_aggr(float b22_aggr) {
		this.b22_aggr = b22_aggr;
	}

	public float getB31_aggr() {
		return b31_aggr;
	}

	public void setB31_aggr(float b31_aggr) {
		this.b31_aggr = b31_aggr;
	}

	public float getB32_aggr() {
		return b32_aggr;
	}

	public void setB32_aggr(float b32_aggr) {
		this.b32_aggr = b32_aggr;
	}

	public float getB41_aggr() {
		return b41_aggr;
	}

	public void setB41_aggr(float b41_aggr) {
		this.b41_aggr = b41_aggr;
	}

	public float getB42_aggr() {
		return b42_aggr;
	}

	public void setB42_aggr(float b42_aggr) {
		this.b42_aggr = b42_aggr;
	}

	public float getTotal_aggr() {
		return total_aggr;
	}

	public void setTotal_aggr(float total_aggr) {
		this.total_aggr = total_aggr;
	}

}
