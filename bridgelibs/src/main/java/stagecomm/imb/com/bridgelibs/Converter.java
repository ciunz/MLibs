package stagecomm.imb.com.bridgelibs;

import com.iapps.libs.helpers.BaseConstants;
import com.iapps.libs.helpers.BaseHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

import stagecomm.imb.com.bridgelibs.Bean.BImage;
import stagecomm.imb.com.bridgelibs.Bean.BeanA;
import stagecomm.imb.com.bridgelibs.Bean.BeanAContent;
import stagecomm.imb.com.bridgelibs.Bean.BeanAcc;
import stagecomm.imb.com.bridgelibs.Bean.BeanAgent;
import stagecomm.imb.com.bridgelibs.Bean.BeanAppType;
import stagecomm.imb.com.bridgelibs.Bean.BeanApps;
import stagecomm.imb.com.bridgelibs.Bean.BeanB;
import stagecomm.imb.com.bridgelibs.Bean.BeanBc;
import stagecomm.imb.com.bridgelibs.Bean.BeanContact;
import stagecomm.imb.com.bridgelibs.Bean.BeanD;
import stagecomm.imb.com.bridgelibs.Bean.BeanE;
import stagecomm.imb.com.bridgelibs.Bean.BeanFeature;
import stagecomm.imb.com.bridgelibs.Bean.BeanGroupUser;
import stagecomm.imb.com.bridgelibs.Bean.BeanInfo;
import stagecomm.imb.com.bridgelibs.Bean.BeanPaymentAp;
import stagecomm.imb.com.bridgelibs.Bean.BeanProduct;
import stagecomm.imb.com.bridgelibs.Bean.BeanReportTemplate;
import stagecomm.imb.com.bridgelibs.Bean.BeanSocmed;
import stagecomm.imb.com.bridgelibs.Bean.BeanStore;
import stagecomm.imb.com.bridgelibs.Bean.BeanTable;
import stagecomm.imb.com.bridgelibs.Bean.BeanTableItem;
import stagecomm.imb.com.bridgelibs.Bean.BeanThemes;
import stagecomm.imb.com.bridgelibs.Bean.BeanTransaction;

/**
 * Created by marcelsantoso.
 * <p/>
 * 5/27/16
 */
public class Converter {
    // ================================================================================
    // Account
    // ================================================================================
    public static BeanAcc toAcc(JSONObject j) {
        BeanAcc bean = new BeanAcc();

        try {
            bean.setId(Integer.parseInt(j.getString("id")));
            bean.setUsername(j.getString("username"));
            bean.setEmail(j.getString("email"));
            bean.setHash(j.getString("hash"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static BeanAgent toAgent(JSONObject j) {
        BeanAgent bean = new BeanAgent();
        try {
            bean.setId(Integer.parseInt(j.getString("admin_id")));
            bean.setUsername(j.getString("admin_username"));
            bean.setEmail(j.getString("admin_email"));
            bean.setPhone(j.getString("admin_phone"));
            bean.setName(j.getString("admin_nama_depan"));
            bean.setImg(j.getString("admin_foto"));
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }

        return bean;
    }

    // ================================================================================
    // Report
    // ================================================================================
    public static ArrayList<BeanReportTemplate> toReportTemplateArr(JSONArray jArr) {
        ArrayList<BeanReportTemplate> al = new ArrayList<>();
        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanReportTemplate bean = toReportTemplate(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static BeanReportTemplate toReportTemplate(JSONObject j) {
        BeanReportTemplate bean = new BeanReportTemplate();
        try {
            bean.setId(j.getString("c_id"));
            bean.setMessage(j.getString("c_msg"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return bean;
    }

    // ================================================================================
    // Apps details
    // ================================================================================
    public static ArrayList<BeanApps> toAppsArr(JSONArray jArr, boolean isProduction) {
        ArrayList<BeanApps> al = new ArrayList<>();
        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanApps bean = toApps(jArr.getJSONObject(i), isProduction);
                if (bean != null)
                    al.add(bean);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static BeanApps toApps(JSONObject j, boolean isProduction) {
        BeanApps bean = null;
        try {
            bean = new BeanApps();
            bean.setAppId(j.getString("app_id"));
            bean.setAppClientId(j.getString("app_client_id"));
            bean.setAppName(j.getString("app_name"));
            bean.setAppPushname(j.getString("app_pushname"));
            bean.setAppShortdes(j.getString("app_shortdes"));
            bean.setAppFulldes(j.getString("app_fulldes"));
            bean.setAppKeywords(j.getString("app_keywords"));
            bean.setAppIcon(j.getString("app_icon"));
            bean.setAppCreateDate(BaseHelper.parseDateTime(j.getString("app_create_date"), Constants.DATE_JSON_FULL));
            bean.setAppFeat(j.getString("app_feat"));
            bean.setAppActive(j.getString("app_active"));
            bean.setAppPulsa(j.getString("app_pulsa"));
            bean.setAppToken(j.getString("app_token"));
            bean.setAppAllowedIp(j.getString("app_allowed_ip"));
            bean.setAppApiAccessKey(j.getString("app_api_access_key"));
            bean.setAppType(j.getString("app_type"));
            bean.setAppContractStart(BaseHelper.parseDateTime(j.getString("app_contract_start"), Constants.DATE_JSON));
            bean.setAppGooglePlayLink(j.getString("app_google_play_link"));
            bean.setAppIosLink(j.getString("app_ios_link"));
            bean.setAppIosVersion(j.getString("app_ios_version"));
            bean.setAppCategory(j.getString("app_category"));
            bean.setAppFreeData(j.getString("app_free_data"));
            bean.setAppOrder(j.getString("app_order"));
            bean.setCarousel(j.optString("carousel_custom"));
            bean.setForceUpdate(j.getString("app_force_update").equalsIgnoreCase("1"));
            //            bean.setApPoint(Integer.parseInt(j.optString("app_ap")));

            if (!isProduction) {
                bean.setHeaderType(j.optString("home_header_style_draft"));
                bean.setAppGoogleVersion(j.getString("app_version_draft"));
                bean.setHomeType(j.optString("home_menu_style_draft"));
                bean.setEnableLogin(j.optString("app_login_draft").equalsIgnoreCase("1"));
            } else {
                bean.setHeaderType(j.optString("home_header_style"));
                bean.setAppGoogleVersion(j.getString("app_version"));
                bean.setHomeType(j.optString("home_menu_style"));
                bean.setEnableLogin(j.optString("app_login").equalsIgnoreCase("1"));
            }

            if (!BaseHelper.isEmpty(bean.getAppFeat()) && !bean.getAppFeat().startsWith("http://")) {
                bean.setAppFeat(Api.BASE_URL_IMAGE + bean.getAppFeat());
            }

            if (!BaseHelper.isEmpty(bean.getAppIcon()) && !bean.getAppIcon().startsWith("http://")) {
                bean.setAppIcon(Api.BASE_URL_IMAGE + bean.getAppIcon());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bean;
    }

    // ================================================================================
    // Themes
    // ================================================================================
    public static ArrayList<BeanThemes> toThemesArr(JSONArray jArr) {
        ArrayList<BeanThemes> al = new ArrayList<>();
        for (int i = 0; i < jArr.length(); i++) {
            try {

                BeanThemes bean = toThemes(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static BeanThemes toThemes(JSONObject j) {
        //Fast way untuk bypass hilangkan bought section 13.04.2017
        String group = j.optString("apptheme_group", "");
        if (BaseHelper.isEmpty(group) || group.toUpperCase().equals("Bought".toUpperCase()))
            return null;
        BeanThemes bean = new BeanThemes();
        try {
            bean.setId(Integer.parseInt(j.getString("apptheme_id")));
            bean.setName(j.getString("apptheme_name"));
            bean.setGroup(j.getString("apptheme_group").replace("Appear", "MAPP"));//130317 by pass appear jadi mapp
            bean.setHeader(j.getString("apptheme_header"));
            bean.setWarna1(j.getString("apptheme_warna1"));
            bean.setWarna2(j.getString("apptheme_warna2"));
            bean.setWarna3(j.getString("apptheme_warna3"));
            bean.setWarna4(j.getString("apptheme_warna4"));
            bean.setWarnaText(j.optString("apptheme_font"));
            bean.setActive(j.getString("apptheme_active").equalsIgnoreCase("1"));
            bean.setOrder(Integer.parseInt(j.getString("apptheme_order")));
            bean.setFree(j.getString("apptheme_isfree").equalsIgnoreCase("1"));
            bean.setPrice(j.getString("apptheme_price"));
            bean.setMinversion(Integer.parseInt(j.getString("apptheme_min_version")));
            bean.setBought(j.optInt("bought") == 1);
            bean.setEquiped(j.optInt("equiped") == 1);
            bean.setStyle(j.getString("apptheme_style"));
            bean.setWarnaGrid(j.getString("apptheme_grid"));
            bean.setInverse(j.getString("apptheme_inverse").equalsIgnoreCase("1"));

            if (!BaseHelper.isEmpty(bean.getPrice()) && !bean.getPrice().equalsIgnoreCase("0"))
                bean.setPrice(BaseHelper.formatRupiah(Double.parseDouble(bean.getPrice())));
            else
                bean.setPrice("FREE");

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    // ================================================================================
    // Stores
    // ================================================================================
    public static ArrayList<BeanStore> toStoreArr(JSONArray jArr) {
        ArrayList<BeanStore> al = new ArrayList<>();
        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanStore bean = toStore(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return al;
    }

    public static BeanStore toStore(JSONObject j) {
        BeanStore bean = new BeanStore();
        try {
            bean.setId(Integer.parseInt(j.getString("store_id")));
            bean.setName(j.getString("store_name"));
            bean.setAdditional(j.getString("store_descr"));
            bean.setEmail(j.optString("email"));
            bean.setPhone(j.optString("phone"));
            bean.setAddress(j.getString("address"));
            bean.setLatitude(j.getString("latitude"));
            bean.setLongitude(j.getString("longitude"));
            bean.setActive(j.getString("store_aktif").equals("1"));
            bean.setOpeningHour(j.optString("opening_hour"));
            bean.setContentId(Integer.parseInt(j.getString("store_content_id")));
            bean.setAppId(Integer.parseInt(j.getString("store_app_id")));

            JSONObject j2 = j.optJSONObject("store_inhalt");
            if (j2 != null) {
                bean.setWhatsapp(j2.optString("whatsapps"));
                bean.setLine(j2.optString("line"));
                bean.setTelegram(j2.optString("telegram"));
                bean.setBbm(j2.optString("bbm"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    // ================================================================================
    // Socmed
    // ================================================================================
    public static BeanSocmed toSocmed(JSONObject j) {
        BeanSocmed bean = new BeanSocmed();

        bean.setFb(j.optString("fb_id"));
        bean.setIg(j.optString("instagram_id"));
        bean.setTwitter(j.optString("twitter_id"));
        bean.setYoutube(j.optString("youtube_id"));

        return bean;
    }

    // ================================================================================
    // Contact us
    // ================================================================================
    public static BeanContact toContact(JSONObject j) {
        BeanContact bean = new BeanContact();

        bean.setPhone(j.optString("telp"));
        bean.setEmail(j.optString("email"));
        bean.setAddress(j.optString("address"));
        bean.setAdditional(j.optString("additional"));
        bean.setLatitude(j.optString("lat"));
        bean.setLongitude(j.optString("lng"));
        bean.setWhatsapp(j.optString("whatsapps"));
        bean.setLine(j.optString("line"));
        bean.setTelegram(j.optString("telegram"));
        bean.setBbm(j.optString("bbm"));

        return bean;
    }

    // ================================================================================
    // Features
    // ================================================================================
    public static ArrayList<BeanFeature> toFeatureArr(JSONArray jArr, ArrayList<BeanFeature> alFeatures) {
        ArrayList<BeanFeature> al = new ArrayList<>();

        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanFeature bean = toFeature(jArr.getJSONObject(i), alFeatures);
                if (bean != null) {
                    //                    bean.setPosition(i);
                    al.add(bean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static BeanFeature toFeature(JSONObject j, ArrayList<BeanFeature> alFeatures) {
        BeanFeature bean = null;
        try {
            int type = toTypeInt(j.getString("content_type"));
            bean = matchFeatureObject(type, alFeatures);

            if (bean == null)
                // Invalid object
                return null;

            bean.setHide(j.getString("content_hide").equalsIgnoreCase("1"));
            bean.setId(Integer.parseInt(j.getString("content_id")));
            bean.setAppId(Integer.parseInt(j.getString("content_app_id")));
            bean.setName(j.getString("content_name"));
            bean.setIconUrl(j.getString("content_icon"));
            bean.setInHalt(j.getString("content_inhalt"));
            bean.setContentFlag(j.optString("content_flag", ""));

            setDefaultIcon(bean);

            if (!BaseHelper.isEmpty(bean.getIconUrl()) && !bean.getIconUrl().startsWith("http://")) {
                bean.setIconUrl(Api.BASE_URL_IMAGE + bean.getIconUrl());
            }

            if (!bean.isHide())
                bean.setSelected(true);
            else {
                for (BeanFeature b : alFeatures) {
                    if (b.getType() == bean.getType()) {
                        b.setSelected(false);
                        b = bean;

                        return null;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bean;
    }

    public static void setDefaultIcon(BeanFeature bean) {
        String contentFlag = bean.getContentFlag();
        switch (bean.getType()) {
            case Constants.TYPE_ABOUT:
                bean.setResIconDefault(R.drawable.ic_about);
                break;
            case Constants.TYPE_SOCMED:
                bean.setResIconDefault(R.drawable.ic_socmed);
                break;
            case Constants.TYPE_PROMO:
                bean.setResIconDefault(R.drawable.ic_promo);
                break;
            case Constants.TYPE_PRODUCTLIST:
                bean.setResIconDefault(R.drawable.ic_product);
                break;
            case Constants.TYPE_PRICELIST:
                bean.setResIconDefault(R.drawable.ic_pricelist);
                break;
            case Constants.TYPE_FAQ:
                bean.setResIconDefault(R.drawable.ic_faq);
                break;
            case Constants.TYPE_STORELOCATOR:
                bean.setResIconDefault(R.drawable.ic_store);
                break;
            case Constants.TYPE_LATESTUPDATE:
                bean.setResIconDefault(R.drawable.ic_news);
                break;
            case Constants.TYPE_CONTACTUS:
                bean.setResIconDefault(R.drawable.ic_contactus);
                break;
            case Constants.TYPE_INBOX:
                bean.setResIconDefault(R.drawable.ic_inbox);
                break;
            case Constants.TYPE_A:
                bean.setResIconDefault(R.drawable.ic_file);
                break;
            case Constants.TYPE_B:
                if (BaseHelper.isEmpty(contentFlag))
                    bean.setResIconDefault(R.drawable.ic_list);
                else if (contentFlag.equals(Converter.toTypeString(Constants.TYPE_GALLERY)))
                    bean.setResIconDefault(R.drawable.ic_gallery);
                else if (contentFlag.equals(Converter.toTypeString(Constants.TYPE_VIDEO)))
                    bean.setResIconDefault(R.drawable.ic_video_2);
                else
                    bean.setResIconDefault(R.drawable.ic_list);
                break;
            case Constants.TYPE_C:
                if (BaseHelper.isEmpty(contentFlag))
                    bean.setResIconDefault(R.drawable.ic_product);
                else if (contentFlag.equals(Converter.toTypeString(Constants.TYPE_GALLERY)))
                    bean.setResIconDefault(R.drawable.ic_gallery);
                else if (contentFlag.equals(Converter.toTypeString(Constants.TYPE_VIDEO)))
                    bean.setResIconDefault(R.drawable.ic_video_2);
                else
                    bean.setResIconDefault(R.drawable.ic_product);
                break;
            default:
                bean.setResIconDefault(R.drawable.ic_icon_error);
        }
    }

    public static BeanFeature matchFeatureObject(int type, ArrayList<BeanFeature> alFeatures) {
        for (BeanFeature b : alFeatures) {
            if (b.getType() == Constants.TYPE_A || b.getType() == Constants.TYPE_B || b.getType() == Constants.TYPE_C) {
                return new BeanFeature().setType(type);
            } else if (b.getType() == Constants.TYPE_GALLERY) {
                return new BeanFeature().setType(type);
            } else if (b.getType() == type) {
                b.setSingleton(true);
                return b;
            }
        }

        return null;
    }

    public static String toTypeString(int type) {
        switch (type) {
            case Constants.TYPE_A:
                return "TypeA";

            case Constants.TYPE_B:
                return "TypeB";

            case Constants.TYPE_C:
                return "TypeC";

            case Constants.TYPE_SOCMED:
                return "TypeConnect";

            case Constants.TYPE_INBOX:
                return "TypeInbox";

            case Constants.TYPE_STORELOCATOR:
                return "TypeStoreLocator";

            case Constants.TYPE_ABOUT:
                return "TypeAbout";

            case Constants.TYPE_CONTACTUS:
                return "TypeContact";

            case Constants.TYPE_FAQ:
                return "TypeFAQ";

            case Constants.TYPE_PRICELIST:
                return "TypePricelist";

            case Constants.TYPE_PRODUCTLIST:
                return "TypeProduct";

            case Constants.TYPE_PROMO:
                return "TypePromo";

            case Constants.TYPE_LATESTUPDATE:
                return "TypeUpdate";

            case Constants.TYPE_GALLERY:
                return "TypeGallery";

            case Constants.TYPE_VIDEO:
                return "TypeVideo";

            default:
                return "";
        }
    }

    public static int toTypeInt(String type) {
        switch (type) {
            case "TypeA":
                return Constants.TYPE_A;

            case "TypeB":
                return Constants.TYPE_B;

            case "TypeC":
                return Constants.TYPE_C;

            case "TypeConnect":
                return Constants.TYPE_SOCMED;

            case "TypeInbox":
                return Constants.TYPE_INBOX;

            case "TypeStoreLocator":
                return Constants.TYPE_STORELOCATOR;

            case "TypeAbout":
                return Constants.TYPE_ABOUT;

            case "TypeContact":
                return Constants.TYPE_CONTACTUS;

            case "TypeFAQ":
                return Constants.TYPE_FAQ;

            case "TypePricelist":
                return Constants.TYPE_PRICELIST;

            case "TypeProduct":
                return Constants.TYPE_PRODUCTLIST;

            case "TypePromo":
                return Constants.TYPE_PROMO;

            case "TypeUpdate":
                return Constants.TYPE_LATESTUPDATE;

            case "TypeGallery":
                return Constants.TYPE_GALLERY;

            case "TypeVideo":
                return Constants.TYPE_VIDEO;

            default:
                return 0;
        }
    }

    // ================================================================================
    // Content
    // ================================================================================
    public static ArrayList<BeanA> toTypeAArr(JSONArray jArr) {
        ArrayList<BeanA> al = new ArrayList<>();

        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanA bean = toTypeA(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static BeanA toTypeA(JSONObject j) {
        BeanA bean = new BeanA();
        try {
            bean.setId(Integer.parseInt(j.getString("a_id")));
            bean.setName(j.optString("a_title"));
            bean.setDateUpdate(BaseHelper.parseDateTime(j.getString("a_update_date"), Constants.DATE_JSON_FULL));
            bean.setDatePost(BaseHelper.parseDateTime(j.getString("a_posting_date"), Constants.DATE_JSON_FULL));
            bean.setVideo(j.getString("a_video"));
            bean.setMap(j.getString("a_map"));
            bean.setPrice(j.getString("a_price"));
            bean.setHeaderType(j.optString("a_header_type"));
            if (j.has("a_hide"))
                bean.setHidden(j.getString("a_hide").equalsIgnoreCase("1"));

            // Carousel
            ArrayList<String> carousel = new ArrayList<>();
            JSONArray jCarousel = j.getJSONArray("carousel");
            for (int i = 0; i < jCarousel.length(); i++) {
                carousel.add(jCarousel.getString(i));
            }
            bean.setAlCarousel(carousel);

            // Tabs
            ArrayList<BeanAContent> contents = new ArrayList<>();
            JSONArray jMsg = j.getJSONArray("msg");
            for (int i = 0; i < jMsg.length(); i++) {
                JSONObject jo = jMsg.getJSONObject(i);
                BeanAContent b = new BeanAContent();
                b.setId(Integer.parseInt(jo.getString("id")));
                b.setTabTitle(jo.getString("tabtitle"));
                try {
                    b.setContentTitle(URLDecoder.decode(jo.getString("contenttitle"), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                try {
                    b.setContentText(URLDecoder.decode(jo.getString("contenttext"), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                contents.add(b);
            }
            bean.setAlContent(contents);

            // Actions
            JSONObject jAction = j.optJSONObject("action");
            if (jAction != null) {
                if (jAction.has("call")) {
                    JSONObject jCall = jAction.getJSONObject("call");
                    bean.setCall(jCall.getString("callbutton_active").equalsIgnoreCase("1"));
                    bean.setCall(jCall.getString("callbutton_number"));
                    bean.setCallText(jCall.getString("callbutton_text"));
                }

                if (jAction.has("email")) {
                    JSONObject jEmail = jAction.getJSONObject("email");
                    bean.setEmail(jEmail.getString("emailbutton_active").equalsIgnoreCase("1"));
                    bean.setEmail(jEmail.getString("emailbutton_mail"));
                    bean.setEmailText(jEmail.getString("emailbutton_text"));
                }

                if (jAction.has("share")) {
                    JSONObject jShare = jAction.getJSONObject("share");
                    bean.setShare(jShare.getString("sharebutton_active").equalsIgnoreCase("1"));
                    bean.setShareText(jShare.optString("sharebutton_text"));
                }

                if (jAction.has("price")) {
                    JSONObject jPrice = jAction.getJSONObject("price");
                    bean.setPrice(jPrice.getString("value"));
                    bean.setPrice(jPrice.getString("price_active").equalsIgnoreCase("1"));
                }

                if (jAction.has("url")) {
                    JSONObject jWebsite = jAction.getJSONObject("url");
                    bean.setWebsite(jWebsite.getString("urlbutton_url"));
                    bean.setWebsiteText(jWebsite.getString("urlbutton_text"));
                    bean.setWeb(jWebsite.getString("urlbutton_active").equalsIgnoreCase("1"));
                }

                if (jAction.has("map")) {
                    JSONObject jMap = jAction.optJSONObject("map");
                    bean.setMap(jMap.optString("mapbutton_latlng"));
                    bean.setMapText("mapbutton_text");
                    bean.setMap(jMap.optString("mapbutton_active", "0").equalsIgnoreCase("1"));
                }

                if (jAction.has("video")) {
                    JSONObject jMap = jAction.optJSONObject("video");
                    bean.setMap(jMap.optString("videobutton_url"));
                    bean.setMapText("videobutton_text");
                    bean.setMap(jMap.optString("videobutton_active", "0").equalsIgnoreCase("1"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
        return bean;
    }

    public static ArrayList<BImage> toTypeACarousel(JSONArray jArr) {
        ArrayList<BImage> al = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            al.add((BImage) new BImage().setId(i));
        }

        for (int i = 0; i < jArr.length(); i++) {
            if (i >= 6)
                break;

            try {
                String imgUrl = jArr.getString(i);
                al.get(i).setHasImage(true).setImgUrl(imgUrl);
                al.get(i).setStrId(imgUrl.substring(imgUrl.lastIndexOf("/") + 1));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    public static ArrayList<BeanFeature> toTypeB(JSONArray jArr) {
        ArrayList<BeanFeature> al = new ArrayList<>();
        try {
            for (int i = 0; i < jArr.length(); i++) {
                BeanA b = toTypeA(jArr.getJSONObject(i));
                if (b != null)
                    al.add(new BeanFeature().setName("Page").setId(b.getId()).setBeanA(b));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return al;
    }

    public static ArrayList<BeanFeature> toTypeC(JSONArray jArr) {
        ArrayList<BeanFeature> al = new ArrayList<>();
        try {
            for (int i = 0; i < jArr.length(); i++) {
                JSONObject j = jArr.getJSONObject(i);
                BeanFeature bParent = new BeanFeature();
                bParent.setId(Integer.parseInt(j.getString("id")));
                bParent.setName(j.getString("name"));
                bParent.setImgUrl(j.getString("pic"));

                BeanB b = new BeanB();
                b.setHide(j.getString("hide").equalsIgnoreCase("1"));
                //                b.setAl(Converter.toTypeB(j.getJSONArray("typeA")));

                bParent.setBeanB(b);
                al.add(bParent);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return al;
    }

    public static BeanD toTypeD(JSONObject j) {
        BeanD bean = new BeanD();
        try {
            bean.setTitle(j.getString("judul"));
            bean.setContent(j.getString("text"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static BeanE toTypeE(JSONObject j) {
        BeanE bean = new BeanE();
        try {
            bean.setTitle(j.optString("judul"));
            bean.setContent(j.optString("text"));

            // Table categories
            JSONArray jArr = new JSONArray(j.getString("table"));
            ArrayList<BeanTable> alTable = new ArrayList<>();
            for (int i = 0; i < jArr.length(); i++) {
                JSONObject jTable = jArr.getJSONObject(i);
                BeanTable b = new BeanTable();
                b.setId(Integer.parseInt(jTable.getString("id")));
                b.setName(jTable.getString("name"));
                b.setPosition(Integer.parseInt(jTable.getString("position")));

                // Table items
                ArrayList<BeanTableItem> alItem = new ArrayList<>();
                JSONArray jArrItem = jTable.getJSONArray("items");
                for (int k = 0; k < jArrItem.length(); k++) {
                    JSONObject jItem = jArrItem.getJSONObject(k);
                    BeanTableItem item = new BeanTableItem();

                    item.setId(Integer.parseInt(jItem.getString("id")));
                    item.setName(jItem.getString("name"));
                    item.setPosition(Integer.parseInt(jItem.getString("position")));
                    item.setValue(jItem.getString("value"));

                    alItem.add(item);
                }

                b.setAl(alItem);
                alTable.add(b);
            }

            bean.setAlTable(alTable);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static String toTypeEJson(ArrayList<BeanTable> alTable) {
        try {
            if (alTable != null) {
                JSONArray tables = new JSONArray();
                for (int i = 0; i < alTable.size(); i++) {
                    BeanTable bTable = alTable.get(i);

                    JSONObject jTable = new JSONObject();
                    jTable.put("id", bTable.getId());
                    jTable.put("name", bTable.getName());
                    jTable.put("position", bTable.getPosition());

                    JSONArray items = new JSONArray();
                    if (bTable.getAl() != null)
                        for (int j = 0; j < bTable.getAl().size(); j++) {
                            BeanTableItem bItem = bTable.getAl().get(j);

                            JSONObject jItem = new JSONObject();
                            jItem.put("id", bItem.getId());
                            jItem.put("name", bItem.getName());
                            jItem.put("position", bItem.getPosition());
                            jItem.put("value", bItem.getValue());

                            items.put(jItem);
                        }

                    jTable.put("items", items);
                    tables.put(jTable);
                }

                return tables.toString();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static BeanBc toBc(JSONObject j) {
        BeanBc bean = new BeanBc();
        try {
            bean.setId(j.getString("camp_id"));
            bean.setClientId(j.getString("camp_client_id"));
            bean.setAppId(j.getString("camp_app_id"));
            bean.setDate(BaseHelper.parseDateTime(j.getString("camp_start"), BaseConstants.DATE_JSON));
            bean.setTime(BaseHelper.parseDateTime(j.getString("camp_hour"), "H"));
            bean.setName(j.getString("camp_name"));
            bean.setTitle(j.getString("camp_title"));
            bean.setImg(j.getString("camp_img"));
            bean.setMsg(j.getString("camp_msg"));
            bean.setUrl(j.getString("camp_url"));
            bean.setActive(j.getString("camp_active").equals("1"));
            if (j.has("app_pulsa"))
                bean.setApPoint(Integer.parseInt(j.getString("app_pulsa")));
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }

        return bean;
    }

    public static ArrayList<BeanPaymentAp> toPaymentApArr(JSONArray jArr) {
        ArrayList<BeanPaymentAp> al = new ArrayList<>();
        try {
            for (int i = 0; i < jArr.length(); i++) {
                BeanPaymentAp bean = toPaymentAp(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return al;
    }

    public static BeanPaymentAp toPaymentAp(JSONObject j) {
        BeanPaymentAp bean = new BeanPaymentAp();
        try {
            bean.setId(j.getString("paket_id"));
            bean.setName(j.getString("paket_name"));
            bean.setPrice(Double.parseDouble(j.getString("paket_price")));
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }

        return bean;
    }

    // ================================================================================
    // Payment
    // ================================================================================
    public static BeanProduct toProduct(JSONObject j) {
        BeanProduct bean = new BeanProduct();
        try {
            bean.setId(Integer.parseInt(j.getString("paket_id")));
            bean.setName(j.getString("paket_name"));
            bean.setDescription(j.getString("paket_descr"));
            bean.setPrice(j.getString("paket_price_no_agent"));
            bean.setPriceDiscount(j.getString("paket_price"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }

    // ================================================================================
    // Closed group
    // ================================================================================
    public static BeanGroupUser toGroupUser(JSONObject j) {
        BeanGroupUser bean = new BeanGroupUser();
        try {
            bean.setId(j.getString("macc_id"));
            bean.setAppId(j.getString("macc_app_id"));
            bean.setEmail(j.getString("macc_email"));
            bean.setName(j.getString("macc_full_name"));
            bean.setDob(BaseHelper.dateFromJson(j.getString("macc_dob")));
            bean.setMale(j.getString("macc_gender").equals("M"));
            bean.setImgUrl(j.getString("macc_pic"));
            bean.setStatus(j.getString("macc_active"));
            bean.setPoints(j.getString("macc_points"));
            bean.setPhone(j.getString("macc_phone"));

            if (!BaseHelper.isEmpty(bean.getImgUrl()) && bean.getImgUrl().startsWith("/uploads"))
                bean.setImgUrl(Api.BASE_URL.substring(0, Api.BASE_URL.length() - 1) + bean.getImgUrl());
            else if (!BaseHelper.isEmpty(bean.getImgUrl()))
                bean.setImgUrl(Api.BASE_URL_IMAGE + bean.getImgUrl());

        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }

        return bean;
    }

    public static ArrayList<BeanGroupUser> toGroupUserArr(JSONArray jArr) {
        ArrayList<BeanGroupUser> al = new ArrayList<>();

        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanGroupUser bean = toGroupUser(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    // ================================================================================
    // Transactions
    // ================================================================================
    public static BeanTransaction toTransactions(JSONObject j) {
        BeanTransaction bean = new BeanTransaction();
        try {
            bean.setId(j.getString("order_id"));
            bean.setValue(j.getString("order_value"));
            bean.setStatus(j.getString("order_status"));
            bean.setName(j.getString("app_name"));
            bean.setPaket(j.getString("paket_name"));
            bean.setType(j.getString("type"));
            bean.setDate(BaseHelper.dateFromJsonFull(j.getString("order_date")));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return bean;
    }

    public static ArrayList<BeanTransaction> toTransactionsArr(JSONArray jArr) {
        ArrayList<BeanTransaction> al = new ArrayList<>();

        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanTransaction bean = toTransactions(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }

    // ================================================================================
    // App Type
    // ================================================================================
    public static BeanAppType toAppType(JSONObject j) {
        BeanAppType bean = new BeanAppType();
        try {
            bean.setId(j.getString("apptype_id"));
            bean.setName(j.getString("apptype_name"));
            bean.setDescription(j.getString("apptype_description"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static ArrayList<BeanAppType> toAppTypeArr(JSONArray jArr) {
        ArrayList<BeanAppType> al = new ArrayList<>();
        al.add(new BeanAppType().setName("None").setDescription("None").setId("0"));
        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanAppType bean = toAppType(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return al;
    }

    // ================================================================================
    // App Info
    // ================================================================================
    public static BeanInfo toInfo(JSONObject j) {
        BeanInfo bean = new BeanInfo();
        try {
            bean.setId(j.getString("info_id"));
            bean.setUrl(j.getString("info_text"));
        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
        return bean;
    }

    public static ArrayList<BeanInfo> toInfoArr(JSONArray jArr) {
        ArrayList<BeanInfo> al = new ArrayList<>();
        for (int i = 0; i < jArr.length(); i++) {
            try {
                BeanInfo bean = toInfo(jArr.getJSONObject(i));
                if (bean != null)
                    al.add(bean);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return al;
    }
}
