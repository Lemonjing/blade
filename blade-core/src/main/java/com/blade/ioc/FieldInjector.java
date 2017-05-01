/**
 * Copyright (c) 2016, biezhi 王爵 (biezhi.me@gmail.com)
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
package com.blade.ioc;

import com.blade.ioc.annotation.Injector;

import java.lang.reflect.Field;

/**
 * Bean Field Injector
 *
 * @author <a href="mailto:biezhi.me@gmail.com" target="_blank">biezhi</a>
 * @since 1.5
 */
public class FieldInjector implements Injector {

    private Ioc ioc;
    private Field field;

    public FieldInjector(Ioc ioc, Field field) {
        this.ioc = ioc;
        this.field = field;
    }

    @Override
    public void injection(Object bean) {
        try {
            Class<?> fieldType = field.getType();
            Object value = ioc.getBean(fieldType);
            if (value == null) {
                throw new IllegalStateException("Can't inject bean: " + fieldType.getName() + " for field: " + field);
            }
            field.setAccessible(true);
            field.set(bean, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}