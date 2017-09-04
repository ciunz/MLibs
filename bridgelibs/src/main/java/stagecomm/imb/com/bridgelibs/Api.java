package stagecomm.imb.com.bridgelibs;

/**
 * Created by marcelsantoso.
 * <p>
 * 5/27/16
 */
public class Api {
    public static final String BASE_URL                 =  "http://mapp-content.indomegabyte.com/";
    public static final String BASE_URL_API             = BASE_URL + "appapi/";
    public static final String BASE_URL_IMAGE           = "http://mapp-content.indomegabyte.com/uploads/";
    // Account
    public static final String LOGIN                    = BASE_URL_API + "login_me";
    public static final String REGISTER                 = BASE_URL_API + "register_me";
    public static final String FORGOT_PASSWORD          = BASE_URL_API + "forgot_password";
    // App
    public static final String APP_ADD                  = BASE_URL_API + "add_app";
    public static final String APP_EDIT                 = BASE_URL_API + "edit_app_descr";
    public static final String APP_CONTENT_FEATURE      = BASE_URL_API + "get_content";
    public static final String APP_GET                  = BASE_URL_API + "get_app";
    // Device token
    public static final String REGISTER_DEVICE          = BASE_URL_API + "register_device";
    // Home
    public static final String HOME_SAVE                = BASE_URL_API + "save_urutan";
    public static final String HOME_ADD_CONTENT         = BASE_URL_API + "add_content";
    public static final String HOME_DELETE_CONTENT      = BASE_URL_API + "del_content";
    public static final String HOME_STYLE               = BASE_URL_API + "set_home_menu_style";
    public static final String HOME_UNHIDE              = BASE_URL_API + "unhide_content";
    // Content
    public static final String CONTENT_GET              = BASE_URL_API + "get_content_byid";
    public static final String CONTENT_HIDE             = BASE_URL_API + "hide_content";
    public static final String CONTENT_DELETE           = BASE_URL_API + "del_content";
    public static final String CONTENT_UNHIDE           = BASE_URL_API + "unhide_content";
    public static final String TYPE_A                   = BASE_URL_API + "get_content_typeA";
    public static final String TYPE_A_EDIT              = BASE_URL_API + "set_content_typeA";
    public static final String TYPE_A_DELETE            = BASE_URL_API + "delete_content_typeA";
    public static final String TYPE_A_UPLOAD_IMAGE      = BASE_URL_API + "save_carousel_typeA";
    public static final String TYPE_A_IMAGE_SAVE        = BASE_URL_API + "save_carousel_typeA";
    public static final String TYPE_B                   = BASE_URL_API + "get_content_typeB";
    public static final String TYPE_B_EDIT              = BASE_URL_API + "set_content_typeB";
    public static final String TYPE_B_ADDITEM           = BASE_URL_API + "add_content_typeA";
    public static final String TYPE_B_DELETE            = BASE_URL_API + "delete_content_typeB";
    public static final String TYPE_C                   = BASE_URL_API + "get_content_typeC";
    public static final String TYPE_C_ADDITEM           = BASE_URL_API + "add_content_typeB";
    public static final String TYPE_C_EDIT              = BASE_URL_API + "set_content_typeC";
    public static final String TYPE_C_DELETE            = BASE_URL_API + "deleteTypeCCat";
    public static final String TYPE_C_SAVE_ORDER        = BASE_URL_API + "updateTypeCCatOrder";
    public static final String CONTENT_REMOVE_ICON      = BASE_URL_API + "remove_content_icon";
    public static final String CONTENT_REMOVE_ICON_B    = BASE_URL_API + "remove_content_icon_typeB";
    // Themes
    public static final String THEMES                   = BASE_URL_API + "get_themes ";
    public static final String THEMES_SET               = BASE_URL_API + "change_selected_theme";
    // Store
    public static final String STORE                    = BASE_URL_API + "reloadStore";
    public static final String STORE_DETAILS            = BASE_URL_API + "openStore";
    public static final String STORE_ADD                = BASE_URL_API + "addStore";
    public static final String STORE_DELETE             = BASE_URL_API + "deleteStore";
    public static final String STORE_EDIT_PARENT        = BASE_URL_API + "edit_default_content";
    // Socmed
    public static final String SOCMED_SAVE              = BASE_URL_API + "save_socmed";
    // Contact us
    public static final String CONTACT_EDIT             = BASE_URL_API + "editContact";
    // FAQ
    public static final String FAQ_EDIT                 = BASE_URL_API + "editFAQ";
    // Pricelist
    public static final String PRICELIST_EDIT           = BASE_URL_API + "editPricelist";
    // Header
    public static final String HEADER_HOME_SET          = BASE_URL_API + "set_home_header";
    public static final String HEADER_HOME_DELETE_IMAGE = BASE_URL_API + "delete_home_carousel";
    public static final String HEADER_HOME_UPLOAD_IMAGE = BASE_URL_API + "save_home_carousel";
    // Payment
    public static final String PAYMENT_GET_PRICE        = BASE_URL_API + "get_product_byCodeName";
    public static final String PAYMENT_GET_AP_PAKET     = BASE_URL_API + "daftar_menu_pulsa";
    public static final String PAYMENT_GET_APPEAR_PAKET = BASE_URL_API + "get_appear_packages";
    public static final String PAYMENT_PAY              = BASE_URL_API + "appear_pay";
    public static final String PAYMENT_SUCCESS          = BASE_URL + "PaymentResults/success";
    public static final String PAYMENT_FAIL             = BASE_URL + "PaymentResults/failed";
    public static final String PAYMENT_ERROR            = BASE_URL + "PaymentResults/error";
    // Broadcast
    public static final String BC_GET                   = BASE_URL_API + "get_push_typeA";
    public static final String BC_DELETE                = BASE_URL_API + "delete_push";
    public static final String BC_UPDATE                = BASE_URL_API + "edit_push_notif_typeA";
    public static final String BC_REGISTER              = BASE_URL_API + "register_push_notif_typeA";
    // Publish
    public static final String PUBLISH                  = BASE_URL_API + "publish_from_draft";
    // Push notif
    public static final String REGISTER_DEVICE_BRIDGE   = BASE_URL_API + "register_device_bridge";
    // Closed group
    public static final String GROUP_SET                = BASE_URL_API + "edit_app_login";
    public static final String GROUP_LOGIN              = BASE_URL_API + "closed_login";
    public static final String GROUP_REGISTER           = BASE_URL_API + "closed_register";
    public static final String GROUP_UPDATE             = BASE_URL_API + "closed_update";
    public static final String GROUP_ACTIVATE_MEMBER    = BASE_URL_API + "closed_activate";
    public static final String GROUP_FORGOT             = BASE_URL_API + "closed_forgot_password";
    public static final String GROUP_GET                = BASE_URL_API + "closed_get_user";
    public static final String GROUP_CHANGE_PASS        = BASE_URL_API + "closed_update_password";
    // Trasnactions
    public static final String TRANSACTION_GET          = BASE_URL_API + "get_transactions";
    // App type
    public static final String APP_TYPE                 = BASE_URL_API + "get_app_type";
    // App info
    public static final String APP_INFO                 = BASE_URL_API + "get_app_info";
    // Agent
    public static final String AGENT_REGISTER           = BASE_URL_API + "ia_agent_registration";
    public static final String AGENT_REPORT_TEMPLATE    = BASE_URL_API + "ia_complaint_template";
    public static final String AGENT_REPORT_SUBMIT      = BASE_URL_API + "submit_complaint";
}
