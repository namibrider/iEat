package ch.iMampf.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Image {
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "dish_id")
	private Dish dish;
		
	@Lob
    @Basic(fetch=FetchType.EAGER, optional=true)
    String imageAsString;
	
	
    public String getImageAsString() {
		return imageAsString;
	}

	public void setImageAsString(String imageAsString) {
		this.imageAsString = imageAsString;
	}

	@Transient
    private MultipartFile multipartFile;

    public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	} 


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}
	
}
