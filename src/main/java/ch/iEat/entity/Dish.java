package ch.iEat.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;


@Entity
public class Dish {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 1000)
	private String dishName;

	@Lob
	@Type(type = "org.hibernate.type.StringClobType")
	@Column(length = Integer.MAX_VALUE)
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User cook;
	
	@Lob
	@OneToMany(mappedBy = "dish", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	List<Ingredient> ingredients = new ArrayList<Ingredient>();
	
	@Lob
	@Column(name="DISH_IMAGES")
	@OneToMany(mappedBy = "dish", fetch=FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Image> images;
	
	@Column(name = "published_date")
	private Date publishedDate = new Date();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCook() {
		return cook;
	}

	public void setCook(User cook) {
		this.cook = cook;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public void addImage(Image image) {
		images.add(image);
		
	}
	
}
