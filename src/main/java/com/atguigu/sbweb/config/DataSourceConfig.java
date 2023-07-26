package com.atguigu.sbweb.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @description: TODO 类描述
 * @Author guanqing
 * @Date 2023/7/25 20:29
 **/
// @Configuration
public class DataSourceConfig {

    // 默认的自动配置是判断容器中没有才会配置@ConditionalOnMissingBean(DataSource.class)
    // @ConfigurationProperties("spring.datasource")
    // @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();

        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(1);
        statFilter.setLogSlowSql(true);

        /**
         * 5. 怎么打开Druid的监控统计功能
         * https://github.com/alibaba/druid/wiki/配置_StatFilter
         */
        druidDataSource.setFilters("wall");
        druidDataSource.setProxyFilters(Arrays.asList(statFilter));
        return druidDataSource;
    }

    /**
     * 配置 druid的监控页功能 https://github.com/alibaba/druid/wiki/配置_StatViewServlet配置
     * @Author guanqing
     * @Date 2023/7/25 21:02
     **/
    // @Bean
    public ServletRegistrationBean statViewServlet(){
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","druid");

        return servletRegistrationBean;
    }

    /**
     * WebStatFilter 用于采集web-jdbc关联监控的数据。
     * https://github.com/alibaba/druid/wiki/配置_配置WebStatFilter
     * @return
     */
    // @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        WebStatFilter webStatFilter = new WebStatFilter();
        /** 对session进行监控 */
        webStatFilter.setSessionStatEnable(true);

        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean =
                new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
}
