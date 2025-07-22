package com.acc.soapclient.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class NamespaceFixInterceptor extends AbstractPhaseInterceptor<SoapMessage> {
    public NamespaceFixInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(SoapMessage message) {
        InputStream is = message.getContent(InputStream.class);
        if (is == null) return;

        try {
            String xml = new String(is.readAllBytes(), StandardCharsets.UTF_8);

            // Fix customerImage tag namespace
            xml = xml.replaceAll(
                    "(<customerImage)([^>]*?)((/?>))",
                    "$1$2 xmlns=\"http://dto.spi.customer.app.fcr.iflex.com\"$3"
            );

            // Fix status tag namespace
            xml = xml.replaceAll(
                    "(<status)([^>]*?)((/?>))",
                    "$1$2 xmlns=\"http://dto.entity.fcr.iflex.com\"$3"
            );

            // Fix versionTicket tag namespace if needed
            xml = xml.replaceAll(
                    "(<versionTicket)([^>]*?)((/?>))",
                    "$1$2 xmlns=\"http://dto.spi.customer.app.fcr.iflex.com\"$3"
            );

            message.setContent(InputStream.class, new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            throw new RuntimeException("Namespace fix failed", e);
        }
    }

}
