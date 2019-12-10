/*
 * Copyright 2019 Uppsala University Library
 *
 * This file is part of Cora.
 *
 *     Cora is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Cora is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Cora.  If not, see <http://www.gnu.org/licenses/>.
 */
package se.uu.ub.cora.javaclient;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import se.uu.ub.cora.clientdata.converter.javatojson.DataToJsonConverterFactory;
import se.uu.ub.cora.clientdata.converter.jsontojava.JsonToDataConverterFactory;
import se.uu.ub.cora.javaclient.apptoken.AppTokenClientFactory;
import se.uu.ub.cora.javaclient.doubles.AppTokenClientFactorySpy;
import se.uu.ub.cora.javaclient.doubles.RestClientFactorySpy;
import se.uu.ub.cora.javaclient.rest.RestClientFactory;

public class CoraClientDependenciesTest {

	@Test
	public void testDependencies() {
		AppTokenClientFactory appTokenClientFactory = new AppTokenClientFactorySpy();
		RestClientFactory restClientFactory = new RestClientFactorySpy();
		DataToJsonConverterFactory dataToJsonConverterFactory = new DataToJsonConverterFactorySpy();
		JsonToDataConverterFactory jsonToDataConverterFactory = new JsonToDataConverterFactorySpy();
		String userId = "someUserId";
		String appToken = "someApptoken";
		CoraClientDependencies dependencies = new CoraClientDependencies(appTokenClientFactory,
				restClientFactory, dataToJsonConverterFactory, jsonToDataConverterFactory, userId,
				appToken);

		assertEquals(dependencies.appTokenClientFactory, appTokenClientFactory);
		assertEquals(dependencies.restClientFactory, restClientFactory);
		assertEquals(dependencies.dataToJsonConverterFactory, dataToJsonConverterFactory);
		assertEquals(dependencies.jsonToDataConverterFactory, jsonToDataConverterFactory);
		assertEquals(dependencies.userId, userId);
		assertEquals(dependencies.appToken, appToken);
	}
}
