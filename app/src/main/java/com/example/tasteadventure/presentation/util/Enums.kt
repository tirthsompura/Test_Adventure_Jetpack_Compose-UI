package com.example.tasteadventure.presentation.util

enum class BottomSheetType {
    NONE, PRODUCTFILTER, VENDORPRODUCTSFILTER,
    countryCode,
    gender,
    shoeSize,
    shoeSizeType,stateSeller, citySeller,
    city, state, camera,orderStatus,sku, offerReceivedSortBy, verifyOtp,forgotPassword, contactUsType, frontIdCamera, backIdCamera,promoCode
}


enum class CameraPermissionStatus { NoPermission, PermissionGranted, PermissionDenied }

enum class HeaderActionType(val value: String) {
    NOTIFICATION("Notification"),
    PRODUCTSLIST("ProductsList"),
    FILTER("Filter"),
    PRODUCTDETAILS("ProductDetails"),
    MYADDRESS("MyAddress"),
   PRODUCTMANAGEMENT("product_management"),
    VENDORREVIEW(""),
    NOTIFICATIONWITHCLEAR("NotificationWithClear"),
   INVENTORYMANAGEMENT("inventory_management"),

}

enum class ProfileTileType(val value: String) {
    MYORDER("my_order"),
    MYOFFERS("my_offers"),
    MYBIDS("my_bids"),
    CHANGEPASSWORD("change_password"),
    PUSHNOTIFICATION("push_notifications"),
    MYADDRESSES("my_addresses"),
    PAYMENTOPTIONS("payment_options"),
    HELPSUPPORT("help_support"),
    LOGOUT("logout"),
    DELETEACCOUNT("delete_account")
}

enum class HelpSupportTileType(val value: String) {
    FREQUENTLYASKQUE("frequently_ask_que"),
    CONTACTUS("contact_us"),
    PRIVACYPOLICY("privacy_policy_enum"),
    TERMSOFSERVICE("terms_of_service_enum"),

}

enum class ProfileBottomSheetType {
    NONE, LOGOUT, DELETEACCOUNT , DELETEPRODUCT , UPDATEPRODUCT, DECLINEOFFER, ACCEPTOFFER,COUNTEROFFER,CAMERA,EDITSTORECONFIRMATION,
    stateSeller, citySeller,
}

enum class ProductsListType(val value: String, val apiKey :String) {
    WISHLIST("wishlist","wishlist"),
    BRANDLISTPRODUCTS("products",""),
    TRENDING("trending_products","trending"),
    AUCTIONPRODUCTS("products","auction"),
    MOSTPOPULARPRODUCTS("products","popular"),
    SEARCHPRODUCTS("default",""),
    STOREINVANTORY("default",""),
    VENDORPRODUCTLIST("default",""),
    VENDORSLIST("","")

}

enum class MyOrderListType(val value: String) {
    ORDERDETAILS("order_details"),
    TRACKORDER("track_order"),
    PAYMENTSUCCESSROOT("track_order"),
    CANCEL("cancel"),
}

enum class OrderStatus(val value: String){
    PENDING("pending"),COMPLETE("completed"),CANCEL("cancelled"),
}
enum class IsMyBidStatus(var value: String){
    INITIAL("ongoing"),WON("won"),LOST("lost")
}

enum class FilterType(val value: String) {
    FILTERTYPECATEGORIES("type"),
    CATEGORIES("categories"),
    BRANDS("brands"),
    VENDORS("vendors"),
    GENDER("gender"),
    SIZETYPE("size_type"),
    SIZENO("size_no"),
    PRICERANGE("price_range"),
    QUANTITY("quantity")
}

enum class OfferStatusType(val value: String) {
    INITIAL("initial"),
    ACCEPTED("accepted"),
    REJECTED("rejected"),
    PENDING("pending"),
    EXPIRED("expired"),
    BUYEROFFER("buyerOffered"),
    VENDOROFFER("vendorOffered"),
}

enum class BottomBarMenuType(val value: String){
    DEFAULT("default"),CART("cart"),HOME("home")
}


enum class SellProductManagementType(val value: String) {
    PRODUCTMANAGEMENT("product_management"),
    INVENTORYMANAGEMENT("inventory_management"),
    ORDERMANAGEMENT("order_management"),
    BIDSMANAGEMENT("bids_management"),
    STOREMANAGEMENT("store_management"),
    PAYMENTMANAGEMENT("payment_management"),
    OFFEREDMANAGEMENT("offered_management"),
}

enum class OrderManagementType(val value: String) {
    ONGOING("on_going"),
    DELIVERED("delivered"),
    CANCELLED("cancelled"),
}

//ORDERPLACED("placed"),
//ORDERSHIPPEDTOAUTHENTICATOR("order_shipped_to_authenticator"),
//ITEMINSPECTED("item_inspected"),
//ORDERAUTHENTICATED("order_authenticated"),
//ORDERSHIPPED("order_shipped"),
//ORDERRECEIVED("order_received")
enum class OrderOnGoingStatusType(val value: String, val label:String) {
    ORDERPLACED("placed", "Order placed"),
    ORDERSHIPPEDTOAUTHENTICATOR("authenticator","Order shipped to authenticator",),
    ITEMINSPECTED("inspected", "Your item is being inspected"),
    ORDERAUTHENTICATED("authenticated","Order authenticated"),
    ORDERSHIPPED("shipped","Order shipped"),
    ORDERRECEIVED("received", "Order received")
}

enum class BidsManagementStatusType(var value: String) {
    ONGOING("on_going"),
    COMPLETED("completed"),
    UPCOMING("upcoming"),
}

enum class StoreManagementTileType(val value: String) {
    TOTALPRODUCTS("total_products_label"),
    AUCTIONEDPRODUCTS("auctioned_products"),
    TOTALORDERS("total_orders"),
    TOTALSOLDPRODUCTS("total_sold_products"),
    FREQUENTLYASKQUE("frequently_ask_que"),
    CONTACTUS("contact_us"),
    PRIVACYPOLICY("privacy_policy_enum"),
    TERMSOFSERVICE("terms_of_service_enum"),
}

enum class ProductManagementStatusType(var value: String) {
    PENDING("pending"),
    REJECTED("rejected"),
    APPROVED("approved"),
    ACTIVE("active"),
}

enum class OfferedReceivedType(val value: String) {
    ONGOING("ongoing"),
    ACCEPTED("accept"),
    CANCELLED("cancel"),
    PENDING("pending"),
    PENDINGWITHBUTTON("pending_with_button"),
    ACCEPTEDBUYER("accepted_buyer"),
    ACCEPTEDME("accepted_me"),
    REJECTED("rejected"),
    EXPIRED("expired"),
}

enum class AuctionProductFilterBottomSheetType(val value: String) {
    BIDINCREMENT("bid_increment"),
//    DAY("day"),
    STARTTIME("hours"),
    ENDTIME("hours"),
//    MINUTES("minutes"),
}

enum class AuctionSizeAndType(val value: String) {
    SIZETYPE("size_type"),
    SIZENO("size_no"),
}
enum class CancelOrderType {
    CONFIRMATION,
    SELECTREASON,
}


enum class VendorStatusType {
    APPROVED,
    REJECTED,
    PENDING,
    INITIAL
}