
package vn.iotstar.Model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

@AllArgsConstructor
public class LectureModel {

	private Long id;

	private String name;
	private Date dateofbirth;
	private String address;
	private String image;
	private String email;
	
	private int idhoidong;
	
	private boolean isactive;
	
	private Boolean isEdit = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdhoidong() {
		return idhoidong;
	}

	public void setIdhoidong(int idhoidong) {
		this.idhoidong = idhoidong;
	}

	public boolean isIs_active() {
		return isactive;
	}

	public void setIs_active(boolean is_active) {
		this.isactive = is_active;
	}

	public Boolean getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(Boolean isEdit) {
		this.isEdit = isEdit;
	}

	public LectureModel(Long id, String name, Date dateofbirth, String address, String image, String email,
			int idhoidong, boolean is_active) {
		super();
		this.id = id;
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.address = address;
		this.image = image;
		this.email = email;
		this.idhoidong = idhoidong;
		this.isactive = is_active;
	}

	public LectureModel() {
		super();
	}

}
