/*
 * Hibernate Search, full-text search for your domain model
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.search.elasticsearch.client.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;

import io.searchbox.core.search.sort.Sort;

/**
 * Implementation of a sort with arbitrary keys and values for Jest.
 * <p>This is useful for providing a way for users to use sort features
 * that are not otherwise implemented in Hibernate Search.
 *
 * @author Yoann Rodiere
 */
public class ArbitrarySort extends Sort {

	private String fieldName;

	private JsonElement sortDescription;

	public ArbitrarySort(String fieldName, JsonElement sortDescription) {
		super( fieldName );
		this.fieldName = fieldName;
		this.sortDescription = sortDescription;
	}

	@Override
	public Map<String, Object> toMap() {
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put( fieldName, sortDescription );
		return rootMap;
	}

}
