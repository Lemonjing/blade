/**
 * Copyright (c) 2015, biezhi 王爵 (biezhi.me@gmail.com)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.blade.embedd;

import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * Jetty Server
 *
 * @author <a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since 1.6.6
 */
public interface EmbedServer {

    void startup(int port);

    void startup(int port, String contextPath);

    void startup(int port, String contextPath, String webRoot);

    void join();

    void addStatic(String... statics);

    void addServlet(Class<? extends Servlet> servlet, String pathSpec);

    void addFilter(Class<? extends Filter> filter, String pathSpec);

    void shutdown();

    void setWebRoot(String webRoot);

}
