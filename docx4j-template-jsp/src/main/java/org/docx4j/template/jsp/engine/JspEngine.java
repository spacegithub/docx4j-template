/*
 * Copyright (c) 2010-2020, vindell (https://github.com/vindell).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.docx4j.template.jsp.engine;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @className	： JspEngine
 * @description	： TODO(描述这个类的作用)
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 * @date		： 2017年5月24日 下午10:25:50
 * @version 	V1.0
 */
public abstract class JspEngine {

	/**
     * 获取全局配置信息.
     * @return 配置信息
     */
    public abstract JspConfig getConfig();
    
	 /**
     * 使用用户指定的配置信息，创建 #{link JetEngine} 对象.
     *
     * @param config    配置信息
     * @return          模板引擎对象
     */
    public static JspEngine create(Properties config) {
        return new JspEngineImpl(new JspConfig(config));
    }
    

    /**
     * 获取模板对象.
     *
     * @param name  模板名称
     * @return      模板对象
     *
     * @throws ResourceNotFoundException 如果模板不存在，抛出该异常
     */
    public abstract JspTemplate getTemplate(HttpServletRequest request,HttpServletResponse response,String name) throws IOException;
    
    public abstract JspTemplate createTemplate(HttpServletRequest request,HttpServletResponse response,String name) throws IOException;
	
}
