/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.profiling;

public class GetFlameGraphActionIT extends ProfilingTestCase {
    public void testGetStackTracesUnfiltered() throws Exception {
        GetStackTracesRequest request = new GetStackTracesRequest(10, 1.0d, 1.0d, null, null, null, null, null, null, null, null);
        GetFlamegraphResponse response = client().execute(GetFlamegraphAction.INSTANCE, request).get();
        // only spot-check top level properties - detailed tests are done in unit tests
        assertEquals(297, response.getSize());
        assertEquals(1.0d, response.getSamplingRate(), 0.001d);
        assertEquals(60, response.getSelfCPU());
        assertEquals(1956, response.getTotalCPU());
        assertEquals(40, response.getTotalSamples());
    }
}
