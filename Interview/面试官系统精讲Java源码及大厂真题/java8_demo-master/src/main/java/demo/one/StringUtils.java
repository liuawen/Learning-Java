package demo.one;

/**
 * StringUtils
 * author  wenhe
 * date 2019/7/28
 */
public class StringUtils {

  public static final String upperName(String name) {
    name = name.substring(0, 1).toUpperCase() + name.substring(1);
    return name;
  }

  public static final String lownerName(String name) {
    name = name.substring(0, 1).toLowerCase() + name.substring(1);
    return name;
  }


}
