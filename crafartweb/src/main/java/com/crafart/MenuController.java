package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ambi
 * @version 1.0
 * 
 */
@Controller("menuController")
@RequestMapping("menu")
public class MenuController { 

	@RequestMapping("/dashboard")
	public ModelAndView showHomePage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("dashboard");
	} 

	@RequestMapping("/staticWebPage")
	public ModelAndView showStaticWebPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("staticWebPage");
	}

	@RequestMapping("/productList")
	public ModelAndView showProductList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productList");
	}

	@RequestMapping("/cartSection")
	public ModelAndView showcartSection(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("cartSection");
	}
	
	@RequestMapping("/checkoutSection")
	public ModelAndView showcheckoutSection(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("checkoutSection");
	}


	@RequestMapping("/customerPanel")
	public ModelAndView showcustomerPanel(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerPanel");
	}

	@RequestMapping("/thirdPartyLogin")
	public ModelAndView showThirdPartyLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("thirdPartyLogin");
	}

	@RequestMapping("/myAccount")
	public ModelAndView showMyAccount(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("myAccount");
	}

	@RequestMapping("/bankDetails")
	public ModelAndView showbankDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("bankDetails");
	}

	@RequestMapping("/shipping")
	public ModelAndView showshipping(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("shipping");
	}

	@RequestMapping("/taxInformation")
	public ModelAndView showtaxInformation(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("taxInformation");
	}

	@RequestMapping("/product")
	public ModelAndView showProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("product");
	}

	@RequestMapping("/addProduct")
	public ModelAndView showAddProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addProduct");
	}

	@RequestMapping("/productDetails")
	public ModelAndView showproductDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productDetails");
	}

	@RequestMapping("/orders") 
	public ModelAndView showOrders(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orders");
	}

	@RequestMapping("/orderDetails")
	public ModelAndView showorderDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orderDetails");
	}

	@RequestMapping("/transactions")
	public ModelAndView showTransactions(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("transactions");
	}

	@RequestMapping("/reportView")
	public ModelAndView showReportView(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("reportView");
	}

	@RequestMapping("/reportPurchase")
	public ModelAndView showReportPurchase(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("reportPurchase");
	}
 
	@RequestMapping("/sellerLogin")
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("sellerLogin");
	}

	@RequestMapping("/customerHome")
	public ModelAndView showHome(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerHome");
	}

	@RequestMapping("/registration")
	public ModelAndView showRegistration(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("registration");
	}

	@RequestMapping("/customerLogin")
	public ModelAndView showCustomerLogIn(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerLogin");
	}

	@RequestMapping("/trackOrder")
	public ModelAndView showTrackOrder(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("trackOrder");
	}
	
	@RequestMapping("/trackId")
	public ModelAndView showTrackId(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("trackId");
	}
	
	@RequestMapping("/trackPage")
	public ModelAndView showTrackPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("trackPage");
	}
	   
	@RequestMapping("/sellerLoginHeader")
	public ModelAndView showSellerLoginHeader(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("sellerLoginHeader");
	}
    
	@RequestMapping("/adminPanel")
	public ModelAndView showAdminPanel(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("adminPanel");
	}
	
	@RequestMapping("/adminLayout")
	public ModelAndView showAdminLayout(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("adminLayout");
	}
	
	@RequestMapping("/adminHeader")
	public ModelAndView showAdminHeader(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("adminHeader");
	}
	
	@RequestMapping("/adminMenu")
	public ModelAndView showAdminMenu(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("adminMenu");
	}
	
	@RequestMapping("/adminFooter")
	public ModelAndView showAdminFooter(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("adminFooter");
	}
	
	@RequestMapping("/uploadProducts")
	public ModelAndView showUploadProducts(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("uploadProducts");
	}
	
	@RequestMapping("/manageSellers")
	public ModelAndView showManageSellers(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("manageSellers");
	}
	
	@RequestMapping("/addNewSeller")
	public ModelAndView showAddNewSeller(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addNewSeller");
	}

	@RequestMapping("/viewSellers")
	public ModelAndView showViewSellers(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("viewSellers");
	}
	
	@RequestMapping("/manageCouriers")
	public ModelAndView showManageCouriers(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("manageCouriers");
	}
	
	@RequestMapping("/addNewCouriers")
	public ModelAndView showAddNewCouriers(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addNewCouriers");
	}
     
	@RequestMapping("/editCouriers")
	public ModelAndView showEditCouriers(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCouriers");
	}
	
	@RequestMapping("/categories")
	public ModelAndView showCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("categories");
	}
	
	@RequestMapping("/categoriesNextPage")
	public ModelAndView showCategoriesNextPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("categoriesNextPage");
	}
	
	@RequestMapping("/addCategories")
	public ModelAndView showAddCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addCategories");
	}
	
	@RequestMapping("/editCategories")
	public ModelAndView showEditCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCategories");
	}
	@RequestMapping("/productPage")
	public ModelAndView showProductPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productPage");
	}
	@RequestMapping("/productNextPage")
	public ModelAndView showProductNextPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productNextPage");
	}

	@RequestMapping("/addProductPage")
	public ModelAndView showAddProductPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addProductPage");
	}
	
	@RequestMapping("/editProduct")
	public ModelAndView showEditProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editProduct");
	}
	
	@RequestMapping("/commissionPage")
	public ModelAndView showCommissionPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("commissionPage");
	}
	
	@RequestMapping("/commissionList")
	public ModelAndView showCommissionList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("commissionList");
	}
	
	@RequestMapping("/editCommission")
	public ModelAndView showEditCommission(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCommission");
	}
    
	@RequestMapping("/subCategories")
	public ModelAndView showSubCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("subCategories");
	}
    
	@RequestMapping("/addSubCategories")
	public ModelAndView showAddSubCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addSubCategories");
	}

	@RequestMapping("/sellerProduct")
	public ModelAndView showSellerProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("sellerProduct");
	}
	
	@RequestMapping("/attributePage")
	public ModelAndView showAttributePage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("attributePage");
	}
	
	@RequestMapping("/addAttribute")
	public ModelAndView showAddAttribute(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addAttribute");
	}
     
	@RequestMapping("/editAttribute")
	public ModelAndView showeditAttribute(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editAttribute");
	}
	
	@RequestMapping("/taxDetails")
	public ModelAndView showTaxDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("taxDetails");
	}

	@RequestMapping("/addTaxDetails")
	public ModelAndView showAddTaxDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addTaxDetails");
	}

	@RequestMapping("/editTaxDetails")
	public ModelAndView showEditTaxDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editTaxDetails");
	}
	
	@RequestMapping("/lengthDetails")
	public ModelAndView showLengthDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("lengthDetails");
	}

	@RequestMapping("/addLengthDetails")
	public ModelAndView showAddLengthDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addLengthDetails");
	}

	@RequestMapping("/editLengthDetails")
	public ModelAndView showEditLengthDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editLengthDetails");
	}

	@RequestMapping("/geoZone")
	public ModelAndView showGeo_Zone(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("geoZone");
	}
    
	@RequestMapping("/addGeoZone")
	public ModelAndView showAddGeo_Zone(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addGeoZone");
	}
	
	@RequestMapping("/editGeoZone")
	public ModelAndView showeditGeo_Zone(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editGeoZone");
	}

	@RequestMapping("/informationPage")
	public ModelAndView showInformationPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("informationPage");
	}
	
	@RequestMapping("/addInformationPage")
	public ModelAndView showAddInformationPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addInformationPage");
	}

	@RequestMapping("/editInformationPage")
	public ModelAndView showEditInformationPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("EditInformationPage");
	}
}