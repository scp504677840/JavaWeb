package utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;

public class WebUtils {

    /**
     * 将请求转换为Bean
     *
     * @param request
     * @param beanClass
     * @param <T>
     * @return
     */
    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass) {
        try {
            T instance = beanClass.getConstructor().newInstance();

            Enumeration<String> parameterNames = request.getParameterNames();
            while (parameterNames.hasMoreElements()) {
                String name = parameterNames.nextElement();
                String value = request.getParameter(name);
                BeanUtils.setProperty(instance, name, value);
            }

            return instance;
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
