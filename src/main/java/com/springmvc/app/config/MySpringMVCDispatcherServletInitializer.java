package com.springmvc.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


// zamena web.xml cherez omplement WebApplicationInitializer
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }
// vse zaprosy ot pozlovatelya idut na dispatcher servlet
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
