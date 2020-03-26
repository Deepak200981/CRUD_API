package com.example.productcrud.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="product_db")
@EntityListeners(AuditingEntityListener.class)
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="manufacturer")
	private String mnf;
	@Column(name="serial_num")
	private String srl_num;
	@Column(name="brand_name")
	private String brand;
	@Column(name="weight")
	private String weight;
	@Column(name="cost")
	private int cost;
	@Column(name="exp_date")
	private String exp_dt;
	@Column(name="mnf_date")
	private String mnf_dt;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMnf() {
		return mnf;
	}
	public void setMnf(String mnf) {
		this.mnf = mnf;
	}
	public String getSrl_num() {
		return srl_num;
	}
	public void setSrl_num(String srl_num) {
		this.srl_num = srl_num;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getExp_dt() {
		return exp_dt;
	}
	public void setExp_dt(String exp_dt) {
		this.exp_dt = exp_dt;
	}
	public String getMnf_dt() {
		return mnf_dt;
	}
	public void setMnf_dt(String mnf_dt) {
		this.mnf_dt = mnf_dt;
	}
	
	@Override
	public String toString() {
		return "product_db{"+
				"id=" + id +
				", name='" + name + '\'' +
				", manufacturer='" + mnf + '\'' +
				", serial_num='" + srl_num + '\'' +
				", brand_name='" + brand + '\'' +
				", weight='" + weight + '\'' +
				", cost='" + cost+ '\'' +
				", exp_date='" + exp_dt + '\'' +
				", mnf_date='" + mnf_dt + '\'' +
				'}';
	}
	
}
