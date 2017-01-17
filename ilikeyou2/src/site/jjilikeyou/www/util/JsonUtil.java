/**
 * Json工具类(很好的支持n层泛型和Date型)
 */
package site.jjilikeyou.www.util;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * @author huangxiaoliangyfx
 *
 */
public class JsonUtil {
	
	private static Gson gson = null;
	static {
		if (gson == null) {
			gson =  new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		}
	}

	private static final Logger logger = LoggerFactory
			.getLogger(JsonUtil.class);

	/** 空的 {@code JSON} 数据 - <code>"{}"</code>。 */
	public static final String EMPTY_JSON = "{}";

	/** 空的 {@code JSON} 数组(集合)数据 - {@code "[]"}。 */
	public static final String EMPTY_JSON_ARRAY = "[]";

	/** 默认的 {@code JSON} 日期/时间字段的格式化模式。 */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";// "yyyy-MM-dd HH:mm:ss SSS"
																			// 精确到毫秒

	/** 默认的 {@code JSON} 是否排除有 {@literal @Expose} 注解的字段。 */
	public static boolean EXCLUDE_FIELDS_WITHOUT_EXPOSE = false;

	/** {@code Google Gson} 的 {@literal @Since} 注解常用的版本号常量 - {@code 1.0}。 */
	public static final Double SINCE_VERSION_10 = 1.0d;

	/** {@code Google Gson} 的 {@literal @Since} 注解常用的版本号常量 - {@code 1.1}。 */
	public static final Double SINCE_VERSION_11 = 1.1d;

	/** {@code Google Gson} 的 {@literal @Since} 注解常用的版本号常量 - {@code 1.2}。 */
	public static final Double SINCE_VERSION_12 = 1.2d;


	/**
	 * 将给定的目标对象根据指定的条件参数转换成 {@code JSON} 格式的字符串。
	 * <p />
	 * <strong>该方法转换发生错误时，不会抛出任何异常。若发生错误时，曾通对象返回 <code>"{}"</code>； 集合或数组对象返回
	 * <code>"[]"</code> </strong>
	 * 
	 * @param target
	 *            目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @param isSerializeNulls
	 *            是否序列化 {@code null} 值字段。
	 * @param version
	 *            字段的版本号注解。
	 * @param datePattern
	 *            日期字段的格式化模式。
	 * @param excludesFieldsWithoutExpose
	 *            是否排除未标注 {@literal @Expose} 注解的字段。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Type targetType,
			boolean isSerializeNulls, Double version, String datePattern,
			boolean excludesFieldsWithoutExpose) {
		if (target == null) {
			return EMPTY_JSON;
		}

		GsonBuilder builder = new GsonBuilder();
		if (isSerializeNulls) {
			builder.serializeNulls();
		}

		if (version != null) {
			builder.setVersion(version.doubleValue());
		}

		if (isEmpty(datePattern)) {
			datePattern = DEFAULT_DATE_PATTERN;
		}

		builder.setDateFormat(datePattern);
		if (excludesFieldsWithoutExpose) {
			builder.excludeFieldsWithoutExposeAnnotation();
		}

		String result = "";

		Gson gson = builder.create();

		try {
			if (targetType != null) {
				result = gson.toJson(target, targetType);
			} else {
				result = gson.toJson(target);
			}
		} catch (Exception ex) {
			logger.error("目标对象 " + target.getClass().getName()
					+ " 转换 JSON 字符串时，发生异常!", ex);
			if (target instanceof Collection || target instanceof Iterator
					|| target instanceof Enumeration
					|| target.getClass().isArray()) {
				result = EMPTY_JSON_ARRAY;
			} else {
				result = EMPTY_JSON;
			}

		}

		return result;
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * <ul>
	 * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法会转换所有未标注或已标注 {@literal @Since} 的字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss SSS}；</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target) {
		return toJson(target, null, false, null, null,
				EXCLUDE_FIELDS_WITHOUT_EXPOSE);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * <ul>
	 * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法会转换所有未标注或已标注 {@literal @Since} 的字段；</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param datePattern
	 *            日期字段的格式化模式。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, String datePattern) {
		return toJson(target, null, false, null, datePattern,
				EXCLUDE_FIELDS_WITHOUT_EXPOSE);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * <ul>
	 * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param version
	 *            字段的版本号注解({@literal @Since})。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Double version) {
		return toJson(target, null, false, version, null,
				EXCLUDE_FIELDS_WITHOUT_EXPOSE);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * <ul>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法会转换所有未标注或已标注 {@literal @Since} 的字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param excludesFieldsWithoutExpose
	 *            是否排除未标注 {@literal @Expose} 注解的字段。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target,
			boolean excludesFieldsWithoutExpose) {
		return toJson(target, null, false, null, null,
				excludesFieldsWithoutExpose);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法只用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * <ul>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param version
	 *            字段的版本号注解({@literal @Since})。
	 * @param excludesFieldsWithoutExpose
	 *            是否排除未标注 {@literal @Expose} 注解的字段。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Double version,
			boolean excludesFieldsWithoutExpose) {
		return toJson(target, null, false, version, null,
				excludesFieldsWithoutExpose);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
	 * <ul>
	 * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法会转换所有未标注或已标注 {@literal @Since} 的字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Type targetType) {
		return toJson(target, targetType, false, null, null,
				EXCLUDE_FIELDS_WITHOUT_EXPOSE);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
	 * <ul>
	 * <li>该方法只会转换标有 {@literal @Expose} 注解的字段；</li>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @param version
	 *            字段的版本号注解({@literal @Since})。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Type targetType, Double version) {
		return toJson(target, targetType, false, version, null,
				EXCLUDE_FIELDS_WITHOUT_EXPOSE);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
	 * <ul>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法会转换所有未标注或已标注 {@literal @Since} 的字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @param excludesFieldsWithoutExpose
	 *            是否排除未标注 {@literal @Expose} 注解的字段。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Type targetType,
			boolean excludesFieldsWithoutExpose) {
		return toJson(target, targetType, false, null, null,
				excludesFieldsWithoutExpose);
	}

	/**
	 * 将给定的目标对象转换成 {@code JSON} 格式的字符串。<strong>此方法通常用来转换使用泛型的对象。</strong>
	 * <ul>
	 * <li>该方法不会转换 {@code null} 值字段；</li>
	 * <li>该方法转换时使用默认的 日期/时间 格式化模式 - {@code yyyy-MM-dd HH:mm:ss}</li>
	 * </ul>
	 * 
	 * @param target
	 *            要转换成 {@code JSON} 的目标对象。
	 * @param targetType
	 *            目标对象的类型。
	 * @param version
	 *            字段的版本号注解({@literal @Since})。
	 * @param excludesFieldsWithoutExpose
	 *            是否排除未标注 {@literal @Expose} 注解的字段。
	 * @return 目标对象的 {@code JSON} 格式的字符串。
	 */
	public static String toJson(Object target, Type targetType, Double version,
			boolean excludesFieldsWithoutExpose) {
		return toJson(target, targetType, false, version, null,
				excludesFieldsWithoutExpose);
	}

	/**
	 * 将给定的 {@code JSON} 字符串转换成指定的类型对象。
	 * 
	 * @param <T>
	 *            要转换的目标类型。
	 * @param json
	 *            给定的 {@code JSON} 字符串。
	 * @param token
	 *            {@code com.google.gson.reflect.TypeToken} 的类型指示类对象。
	 * @param datePattern
	 *            日期格式模式。
	 * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
	 */
	public static <T> T fromJson(String json, TypeToken<T> token,
			String datePattern) {
		if (isEmpty(json)) {
			return null;
		}

		GsonBuilder builder = new GsonBuilder();
		if (isEmpty(datePattern)) {
			datePattern = DEFAULT_DATE_PATTERN;
		}

		Gson gson = builder.create();

		try {
			return (T)gson.fromJson(json, token.getType());
		} catch (Exception ex) {
			logger.error(json + " 无法转换为 " + token.getRawType().getName()
					+ " 对象!", ex);
			return null;
		}
	}

	/**
	 * 将给定的 {@code JSON} 字符串转换成指定的类型对象。
	 * 
	 * @param <T>
	 *            要转换的目标类型。
	 * @param json
	 *            给定的 {@code JSON} 字符串。
	 * @param token
	 *            {@code com.google.gson.reflect.TypeToken} 的类型指示类对象。
	 * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
	 */
	public static <T> T fromJson(String json, TypeToken<T> token) {
		return fromJson(json, token, null);
	}

	/**
	 * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * 
	 * @param <T>
	 *            要转换的目标类型。
	 * @param json
	 *            给定的 {@code JSON} 字符串。
	 * @param clazz
	 *            要转换的目标类。
	 * @param datePattern
	 *            日期格式模式。
	 * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
	 */
	public static <T> T fromJson(String json, Class<T> clazz, String datePattern) {
		if (isEmpty(json)) {
			return null;
		}

		GsonBuilder builder = new GsonBuilder();
		if (isEmpty(datePattern)) {
			datePattern = DEFAULT_DATE_PATTERN;
		}

		Gson gson = builder.create();

		try {
			return gson.fromJson(json, clazz);
		} catch (Exception ex) {
			logger.error(json + " 无法转换为 " + clazz.getName() + " 对象!", ex);
			return null;
		}
	}

	/**
	 * 将给定的 {@code JSON} 字符串转换成指定的类型对象。<strong>此方法通常用来转换普通的 {@code JavaBean}
	 * 对象。</strong>
	 * 
	 * @param <T>
	 *            要转换的目标类型。
	 * @param json
	 *            给定的 {@code JSON} 字符串。
	 * @param clazz
	 *            要转换的目标类。
	 * @return 给定的 {@code JSON} 字符串表示的指定的类型对象。
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		return fromJson(json, clazz, null);
	}

	/**
	 * 判断json字符串是否为空
	 * 
	 * @param json
	 * @return
	 */
	private static boolean isEmpty(String json) {
		return json == null || json.trim().length() == 0;
	}
	
	/** 
     * 将json格式转换成list对象，并准确指定类型 
     * @param jsonStr 
     * @param type 
     * @return 
     */  
    public static List<?> jsonToList(String jsonStr, java.lang.reflect.Type type) {  
        List<?> objList = null;  
        if (gson != null) {  
            objList = gson.fromJson(jsonStr, type);  
        }  
        return objList;  
    }
	/**
	 * 
	* @Description: 返回标准邮件json串
	* @author liufangpu
	 */
    public static String getTestEmailJson(String action,String languages,String id,String mailtitle,String maildescription) {
    	return "{\"action\":"+"\""+action+"\""+",\"languages\":"+"\""+languages+"\""+",\"content\":{\"mailtitle\":{"+"\""+id+"\":"+"\""+mailtitle+"\"},"+"\"maildescription\":{"+"\""+id+"\":"+"\""+maildescription+"\""+"}}}";
	}
    public static String getSendChannelEamilJson(String channel,String id) {
    	//String url="http://google.com/xxx/oo/";
    	//url字段暂时为空
    	String url="";
    	return "{"+"\"mailtype\":\"channel\",\"channel\":"+"\""
    			 +channel+"\",\"mailtitle\":"+"\""
    			 +id+"\","+"\"maildescription\":"+"\""+id+"\","+"\"hyperlink\":"+"\""+url+"\""+"}";
	}
    public static String getSendSyetemEmailJson(String id) {
		//String url="http://google.com/xxx/oo/";
    	//url字段暂时为空
		String url="";
    	return "{"+"\"mailtype\":\"system\",\"mailtitle\":"+"\""
    			 +id+"\","+"\"maildescription\":"+"\""+id+"\","+"\"hyperlink\":"+"\""+url+"\""+"}";
	}
    public static boolean ContainsJson(String sendPostRequestByJava) {
    	String json1="respCode"+"\\"+"\""+":"+"200";
		if (sendPostRequestByJava.contains(json1)) {
			return true;
		}
		return false;
	}

	public static String getSendUidEamilJson(String uids, String propId,
			String propNum,String id) {
		//String url="http://google.com/xxx/oo/";
		//url字段暂时为空
		String url="";
		String uidS=null;
		String[] split=null;
		StringBuffer sbf=new StringBuffer();
		//去掉空格
		 uids = uids.replaceAll(" ", "");
		if (uids.contains("，")) {
			 uidS = uids.replaceAll("，", ",");
			  	split= uidS.split(",");
				
			}else{
				split = uids.split(",");
			}
		for (String uid : split) {
			if (!"".equals(uid)) {
				sbf.append("\""+uid+"\""+",");
			}
				
		}
		String uidJson = sbf.substring(0, sbf.length()-1);
		String json="{\"mailtype\":\"personal\",\"userid\":["+uidJson+"],\"mailtitle\":\""+id+"\",\"maildescription\":\""+id+"\",\"attachment\":{\""+propId+"\":\""+propNum+"\"},\"hyperlink\":\""+url+"\"}";
		return json;
	
	}
	
	public static void main(String[] args) {
		//String uids="\"uid\"";
		StringBuffer uidsBuffer=new StringBuffer();
		String uid="10000";
		uidsBuffer.append("\""+uid+"\""+",");
		uidsBuffer.append("\""+uid+"\""+",");
		uidsBuffer.append("\""+uid+"\""+",");
		uidsBuffer.append("\""+uid+"\""+",");
		String substring = uidsBuffer.substring(0, uidsBuffer.length()-1);
		System.out.println(uidsBuffer.length());
		System.out.println(substring);
		String json="{\"mailtype\":\"personal\",\"userid\":["+"12"+"],\"mailtitle\":\""+"122"+"\",\"maildescription\":\""+"122"+"\",\"attachment\":{\""+"1212"+"\":\""+"300"+"\"},\"hyperlink\":\""+""+"\"}";
		System.out.println(json);
	}
}