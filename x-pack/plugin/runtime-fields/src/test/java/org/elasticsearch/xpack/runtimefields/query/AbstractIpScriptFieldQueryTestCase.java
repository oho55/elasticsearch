/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */

package org.elasticsearch.xpack.runtimefields.query;

import org.apache.lucene.document.InetAddressPoint;
import org.apache.lucene.util.BytesRef;
import org.elasticsearch.xpack.runtimefields.IpScriptFieldScript;

import java.net.InetAddress;

import static org.mockito.Mockito.mock;

public abstract class AbstractIpScriptFieldQueryTestCase<T extends AbstractIpScriptFieldQuery> extends AbstractScriptFieldQueryTestCase<T> {

    protected final IpScriptFieldScript.LeafFactory leafFactory = mock(IpScriptFieldScript.LeafFactory.class);

    @Override
    public final void testVisit() {
        assertEmptyVisit();
    }

    protected static BytesRef encode(InetAddress addr) {
        return new BytesRef(InetAddressPoint.encode(addr));
    }
}
