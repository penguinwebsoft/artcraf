/**
 * 
 */
package com.crafart.service.businessobjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
public class ProductBO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7025783569311015416L;

	private long productId;

	private long categoryId;

	private String model;

	private String sku;

	private String upc;

	private String location;

	private String quantity;

	private String stockStatusId;

	private String image;

	private long sellerId;

	private long shipping;

	private float price;

	private int points;

	private long taxClassId;

	private Date dateAvailable;

	private String weight;

	private double height;

	private double length;

	private double width;

	private long weightClassId;

	private long lengthClassId;

	private double subtract;

	private double minimum;

	private String sortOrder;

	private int status;

	private int viewed;

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

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public long getShipping() {
		return shipping;
	}

	public void setShipping(long shipping) {
		this.shipping = shipping;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public long getTaxClassId() {
		return taxClassId;
	}

	public void setTaxClassId(long taxClassId) {
		this.taxClassId = taxClassId;
	}

	public Date getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(Date dateAvailable) {
		this.dateAvailable = dateAvailable;
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

	public long getWeightClassId() {
		return weightClassId;
	}

	public void setWeightClassId(long weightClassId) {
		this.weightClassId = weightClassId;
	}

	public long getLengthClassId() {
		return lengthClassId;
	}

	public void setLengthClassId(long lengthClassId) {
		this.lengthClassId = lengthClassId;
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

}
