package com.crafart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crafart.service.businessobjects.AttributeBO;
import com.crafart.service.businessobjects.CategoryBO;

/**
 * @author Ambi
 * @version 1.0
 * 
 */
@Controller("menuController")
@RequestMapping("menu")
public class MenuController {

	private static final Logger log = Logger.getLogger(MenuController.class);

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

	@RequestMapping("/transactions")
	public ModelAndView showTransactions(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("transactions");
	}

	@RequestMapping("/addProduct")
	public ModelAndView showAddProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addProduct");
	}

	@RequestMapping("/productDetails")
	public ModelAndView showProductDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productDetails");
	}

	@RequestMapping("/orders")
	public ModelAndView showOrders(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orders");
	}

	@RequestMapping("/orderDetails")
	public ModelAndView showOrderDetails(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orderDetails");
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

	@RequestMapping("/editSeller")
	public ModelAndView showEditSeller(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editSeller");
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

	@RequestMapping("/addCategory")
	public ModelAndView showAddCategories(@ModelAttribute(value = "categoryBO") CategoryBO categoryBO) {

		ModelMap modelMap = new ModelMap();
		/*
		 * if (null != categoryBO && categoryBO.getCategoryId() > 0) {
		 * log.debug("attribute object is not null");
		 * categoryBO.setUpdate(true);
		 */
		modelMap.addAttribute("category", categoryBO);
		return new ModelAndView("addCategory", modelMap);
		/*
		 * } else { CategoryBO newCategoryBO = new CategoryBO();
		 * newCategoryBO.setUpdate(false); modelMap.addAttribute("category",
		 * newCategoryBO); return new ModelAndView("addCategory", modelMap); }
		 */
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

	@RequestMapping("/editCommission")
	public ModelAndView showEditCommission(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCommission");
	}

	@RequestMapping("/commissionList")
	public ModelAndView showCommissionList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("commissionList");
	}

	@RequestMapping("/subCategories")
	public ModelAndView showSubCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("subCategories");
	}

	@RequestMapping("/addSubCategories")
	public ModelAndView showAddSubCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addSubCategories");
	}

	@RequestMapping("/editSubCategories")
	public ModelAndView showEditSubCategories(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editSubCategories");
	}

	@RequestMapping("/sellerProduct")
	public ModelAndView showSellerProduct(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("sellerProduct");
	}

	@RequestMapping("/attributePage")
	public ModelAndView showAttributePage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("attributePage");
	}

	@RequestMapping(value = "/addAttribute", method = RequestMethod.GET)
	public ModelAndView showAddAttribute(@ModelAttribute(value = "attributeBO") AttributeBO attributeBO) {
		ModelMap modelMap = new ModelMap();
		if (null != attributeBO && attributeBO.getAttributeId() > 0) {
			log.debug("attribute object is not null");
			attributeBO.setUpdate(true);
			modelMap.addAttribute("attribute", attributeBO);
			return new ModelAndView("addAttribute", modelMap);
		} else {
			AttributeBO newAttributeBO = new AttributeBO();
			newAttributeBO.setUpdate(false);
			modelMap.addAttribute("attribute", newAttributeBO);
			return new ModelAndView("addAttribute", modelMap);
		}
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
		return new ModelAndView("editInformationPage");
	}

	@RequestMapping("/filterPage")
	public ModelAndView showFilterPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("filterPage");
	}

	@RequestMapping("/addFilterPage")
	public ModelAndView showAddFilterPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addFilterPage");
	}

	@RequestMapping("/editFilterPage")
	public ModelAndView showeditFilterPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editFilterPage");
	}

	@RequestMapping("/orderList")
	public ModelAndView showOrderList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orderList");
	}

	@RequestMapping("/addOrderList")
	public ModelAndView showAddOrderList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addOrderList");
	}

	@RequestMapping("/viewOrderList")
	public ModelAndView showViewOrderList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("viewOrderList");
	}

	@RequestMapping("/editOrderList")
	public ModelAndView showEditOrderList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editOrderList");
	}

	@RequestMapping("/customerList")
	public ModelAndView showCustomerList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerList");
	}

	@RequestMapping("/addCustomerList")
	public ModelAndView showAddCustomerList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addCustomerList");
	}

	@RequestMapping("/editCustomerList")
	public ModelAndView showEditCustomerList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCustomerList");
	}

	@RequestMapping("/customerListAddress")
	public ModelAndView showCustomerListAddress(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerListAddress");
	}

	@RequestMapping("/returnPage")
	public ModelAndView showReturnPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("returnPage");
	}

	@RequestMapping("/addReturnPage")
	public ModelAndView showAddReturnPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addReturnPage");
	}

	@RequestMapping("/editReturnPage")
	public ModelAndView showEditReturnPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editReturnPage");
	}

	@RequestMapping("/bannerPage")
	public ModelAndView showBannerPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("bannerPage");
	}

	@RequestMapping("/addBanner")
	public ModelAndView showAddBannerPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addBanner");
	}

	@RequestMapping("/editBanner")
	public ModelAndView showEditBanner(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editBanner");
	}

	@RequestMapping("/mailListPage")
	public ModelAndView showMailListPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("mailListPage");
	}

	@RequestMapping("/mailPage")
	public ModelAndView showMailPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("mailPage");
	}

	@RequestMapping("/mailEditPage")
	public ModelAndView showMailEditPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("mailEditPage");
	}

	@RequestMapping("/couponList")
	public ModelAndView showCouponList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("couponList");
	}

	@RequestMapping("/addCouponList")
	public ModelAndView showAddCouponList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addCouponList");
	}

	@RequestMapping("/editCouponList")
	public ModelAndView showeditCouponList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCouponList");
	}

	@RequestMapping("/currenciesPage")
	public ModelAndView showCurrenciesPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("currenciesPage");
	}

	@RequestMapping("/addCurrenciesPage")
	public ModelAndView showAddCurrenciesPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addCurrenciesPage");
	}

	@RequestMapping("/editCurrenciesPage")
	public ModelAndView showEditCurrenciesPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCurrenciesPage");
	}

	@RequestMapping("/orderStatus")
	public ModelAndView showOrderStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("orderStatus");
	}

	@RequestMapping("/addOrderStatus")
	public ModelAndView showAddOrderStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addOrderStatus");
	}

	@RequestMapping("/editOrderStatus")
	public ModelAndView showEditOrderStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editOrderStatus");
	}

	@RequestMapping("/returnStatus")
	public ModelAndView showReturnStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("returnStatus");
	}

	@RequestMapping("/addReturnStatus")
	public ModelAndView showAddReturnStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addReturnStatus");
	}

	@RequestMapping("/editReturnStatus")
	public ModelAndView showEditReturnStatus(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editReturnStatus");
	}

	@RequestMapping("/returnAction")
	public ModelAndView showReturnAction(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("returnAction");
	}

	@RequestMapping("/addReturnAction")
	public ModelAndView showAddReturnAction(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addReturnAction");
	}

	@RequestMapping("/editReturnAction")
	public ModelAndView showEditReturnAction(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editReturnAction");
	}

	@RequestMapping("/returnReason")
	public ModelAndView showReturnReason(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("returnReason");
	}

	@RequestMapping("/addReturnReason")
	public ModelAndView showAddReturnReason(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addReturnReason");
	}

	@RequestMapping("/editReturnReason")
	public ModelAndView showEditReturnReason(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editReturnReason");
	}

	@RequestMapping("/userGroupList")
	public ModelAndView showUserGroupList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("userGroupList");
	}

	@RequestMapping("/addUserGroup")
	public ModelAndView showAddUserGroup(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addUserGroup");
	}

	@RequestMapping("/editUserGroup")
	public ModelAndView showEditUserGroup(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editUserGroup");
	}

	@RequestMapping("/userListPage")
	public ModelAndView showUserListPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("userListPage");
	}

	@RequestMapping("/addUserList")
	public ModelAndView showAddUserList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addUserList");
	}

	@RequestMapping("/editUserList")
	public ModelAndView showEditUserList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editUserList");
	}

	@RequestMapping("/salesOrder")
	public ModelAndView showSalesOrder(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("salesOrder");
	}

	@RequestMapping("/taxOrder")
	public ModelAndView showTaxOrder(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("taxOrder");
	}

	@RequestMapping("/shippingReport")
	public ModelAndView showShippingReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("shippingReport");
	}

	@RequestMapping("/returnReport")
	public ModelAndView showReturnReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("returnReport");
	}

	@RequestMapping("/couponsReport")
	public ModelAndView showCouponsReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("couponsReport");
	}

	@RequestMapping("/productViewReport")
	public ModelAndView showProductViewReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productViewReport");
	}

	@RequestMapping("/productPurchaseReport")
	public ModelAndView showproductPurchaseReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("productPurchaseReport");
	}

	@RequestMapping("/customerOrderReport")
	public ModelAndView showCustomerOrderReport(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("customerOrderReport");
	}

	@RequestMapping("/editCustomerOrder")
	public ModelAndView showEditCustomerOrder(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editCustomerOrder");
	}

	@RequestMapping("/transactionPage")
	public ModelAndView showTransactionPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("transactionPage");
	}

	@RequestMapping("/paymentHistory")
	public ModelAndView showPaymentHistory(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("paymentHistory");
	}

	@RequestMapping("/bannerGroup")
	public ModelAndView showBannerGroup(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("bannerGroup");
	}

	@RequestMapping("/addBannerGroup")
	public ModelAndView showAddBannerGroup(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addBannerGroup");
	}

	@RequestMapping("/editBannerGroup")
	public ModelAndView showEditBannerGroup(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editBannerGroup");
	}

	@RequestMapping("/smsList")
	public ModelAndView showSmsList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("smsList");
	}

	@RequestMapping("/addSmsList")
	public ModelAndView showAddSmsList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addSmsList");
	}

	@RequestMapping("/editSmsList")
	public ModelAndView showEditSmsList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editSmsList");
	}

	@RequestMapping("/emailList")
	public ModelAndView showEmailList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("emailList");
	}

	@RequestMapping("/addEmailList")
	public ModelAndView showAddEmailList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("addEmailList");
	}

	@RequestMapping("/editEmailList")
	public ModelAndView showEditEmailList(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("editEmailList");
	}

	@RequestMapping("/cdnListPage")
	public ModelAndView showCdnListPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("cdnListPage");
	}

	@RequestMapping("/cloudfareEditPage")
	public ModelAndView showCloudfareEditPage(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("cloudfareEditPage");
	}
}
