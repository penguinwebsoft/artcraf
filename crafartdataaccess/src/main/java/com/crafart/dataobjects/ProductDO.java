/**
 * 
 */
package com.crafart.dataobjects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * product entity are maped to product table in crafart database productid is
 * primary key which is generated by sequenceGenerator
 * 
 * @author Karthi
 * 
 */
@Entity
@Table(name = "PRODUCT")
public class ProductDO implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8602862203824151879L;

	@Id
	@Column(name = "product_Id")
	@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
	private long productId;

	@Column(name = "category_Id")
	private long categoryId;

	@Column(name = "model")
	private String model;

	@Column(name = "sku")
	private String sku;

	@Column(name = "upc")
	private String upc;

	@Column(name = "location")
	private String location;

	@Column(name = "quantity")
	private String quantity;

	@Column(name = "stock_Status_Id")
	private String stockStatusId;

	@Column(name = "image")
	private String image;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "SELLER_PRODUCT", joinColumns = { @JoinColumn(name = "PRODUCT_ID") }, inverseJoinColumns = { @JoinColumn(name = "SELLER_ID") })
	private List<SellerDO> sellerDOs = new ArrayList<>();

	@Column(name = "shipping")
	private long shipping;

	@Column(name = "price")
	private float price;

	@Column(name = "points")
	private int points;

	@Column(name = "date_Available")
	private String dateAvailable;

	@Column(name = "weight")
	private String weight;

	@Column(name = "height")
	private double height;

	@Column(name = "length")
	private double length;

	@Column(name = "width")
	private double width;

	@OneToOne
	@JoinColumn(name = "weight_class_id", nullable = false)
	private WeightClassDO weightClassDO;

	@Column(name = "subtract")
	private double subtract;

	@Column(name = "minimum")
	private double minimum;

	@Column(name = "sort_Order")
	private String sortOrder;

	@Column(name = "status")
	private int status;

	@Column(name = "viewed")
	private int viewed;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "productDO", cascade = CascadeType.ALL)
	private List<ProductAttributeDO> productAttributeDOs = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "productDO", cascade = CascadeType.ALL)
	private List<ProductDiscountDO> productDiscountDOs = new ArrayList<>();

	public List<ProductDiscountDO> getProductDiscountDOs() {
		return productDiscountDOs;
	}

	public void setProductDiscountDOs(List<ProductDiscountDO> productDiscountDOs) {
		this.productDiscountDOs = productDiscountDOs;
	}

	public List<ProductAttributeDO> getProductAttributeDOs() {
		return productAttributeDOs;
	}

	public void setProductAttributeDOs(List<ProductAttributeDO> productAttributeDOs) {
		this.productAttributeDOs = productAttributeDOs;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStockStatusId() {
		return stockStatusId;
	}

	public void setStockStatusId(String stockStatusId) {
		this.stockStatusId = stockStatusId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<SellerDO> getSellerDOs() {
		return sellerDOs;
	}

	public void setSellerDOs(List<SellerDO> sellerDOs) {
		this.sellerDOs = sellerDOs;
	}

	public long getShipping() {
		return shipping;
	}

	public void setShipping(long shipping) {
		this.shipping = shipping;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getSubtract() {
		return subtract;
	}

	public void setSubtract(double subtract) {
		this.subtract = subtract;
	}

	public double getMinimum() {
		return minimum;
	}

	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getViewed() {
		return viewed;
	}

	public void setViewed(int viewed) {
		this.viewed = viewed;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public WeightClassDO getWeightClassDO() {
		return weightClassDO;
	}

	public void setWeightClassDO(WeightClassDO weightClassDO) {
		this.weightClassDO = weightClassDO;
	}

	public String getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(String dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

}
