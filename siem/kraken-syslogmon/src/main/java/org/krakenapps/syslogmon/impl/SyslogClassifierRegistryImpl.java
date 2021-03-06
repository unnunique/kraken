/*
 * Copyright 2011 Future Systems
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krakenapps.syslogmon.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;
import org.krakenapps.syslogmon.SyslogClassifier;
import org.krakenapps.syslogmon.SyslogClassifierRegistry;

@Component(name = "syslog-classifier-registry")
@Provides
public class SyslogClassifierRegistryImpl implements SyslogClassifierRegistry {

	private ConcurrentMap<String, SyslogClassifier> classifiers;

	public SyslogClassifierRegistryImpl() {
		classifiers = new ConcurrentHashMap<String, SyslogClassifier>();
	}

	@Override
	public Collection<String> getClassifierNames() {
		return Collections.unmodifiableCollection(classifiers.keySet());
	}

	@Override
	public SyslogClassifier getClassifier(String name) {
		return classifiers.get(name);
	}

	@Override
	public void register(String name, SyslogClassifier classifier) {
		SyslogClassifier old = classifiers.putIfAbsent(name, classifier);
		if (old != null)
			throw new IllegalStateException("duplicated classifier name: " + name);
	}

	@Override
	public void unregister(String name) {
		classifiers.remove(name);
	}

}
