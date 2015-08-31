CREATE SEQUENCE seq_account
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by account.account_id;
 CREATE SEQUENCE seq_address
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by address.address_id;
 CREATE SEQUENCE seq_attributegroupdesc
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by attribute_group_desc.attribute_group_id;
 CREATE SEQUENCE seq_category
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by category.category_id;
 CREATE SEQUENCE seq_commission
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by commission.commission_id;
  CREATE SEQUENCE seq_contact
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by contact.contact_id;
CREATE SEQUENCE seq_courier
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by courier.courier_id;
  CREATE SEQUENCE seq_currency
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by currency.currency_id;
  CREATE SEQUENCE seq_customer
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by customer.customer_id;
  CREATE SEQUENCE seq_geozone
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by geo_zone.geo_zone_id;
  CREATE SEQUENCE seq_invoice
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by invoice.invoice_id;
  CREATE SEQUENCE seq_lengthclass
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by length_class.length_class_id;
 CREATE SEQUENCE seq_order
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by crafart_order.order_id;
   CREATE SEQUENCE seq_productattribute
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_attribute.attribute_id;
  
  CREATE SEQUENCE seq_productdiscount
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_discount.product_discount_id;
  
  CREATE SEQUENCE seq_productimage
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_image.product_image_id;
  
  CREATE SEQUENCE seq_rating
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_rating.product_rating_id;
  
  CREATE SEQUENCE seq_review
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_review.product_review_id;
  
  CREATE SEQUENCE seq_product
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product.product_id;
  
  CREATE SEQUENCE seq_productshipping
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_shipping.product_shipping_id;
  
  CREATE SEQUENCE seq_productspecial
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_special.product_special_id;
  
  
  CREATE SEQUENCE seq_productdesc
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_description.product_description_id;
  
  CREATE SEQUENCE seq_seller
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by seller.seller_id;
 
 CREATE SEQUENCE seq_seo
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by seo.seo_id;
  
  CREATE SEQUENCE seq_attribute
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 48520
  CACHE 20;
ALTER TABLE seq_attribute
  OWNER TO attribute.attribute_id;
  
  CREATE SEQUENCE seq_store
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by store.store_id;
 
 CREATE SEQUENCE seq_taxclass
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by tax_class.tax_class_id;
 
 
 CREATE SEQUENCE seq_taxrule
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by tax_rule.tax_rule_id;
  
  
  CREATE SEQUENCE seq_user_contact
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by user_contact. user_contact_id;
  
  
  CREATE SEQUENCE seq_user_group
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by user_group. user_group_id;
  
  
  CREATE SEQUENCE seq_user
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by crafart_user.user_id;
  
  
  CREATE SEQUENCE seq_weightclass
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by weight_class.weight_class_id;
 
CREATE SEQUENCE seq_taxrate
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by tax_rate.tax_rate_id	;
  
  
  CREATE SEQUENCE seq_order_status
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by order_status.order_status_id;
  
  
  
   CREATE SEQUENCE seq_information
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by information.information_id;
  
  CREATE SEQUENCE seq_banner
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by banner.banner_id;
 
 CREATE SEQUENCE seq_banner_group
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
 owned by banner_group.banner_group_id;
 CREATE SEQUENCE seq_discount
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 91
  CACHE 1;
  owned by discount.discount_id;