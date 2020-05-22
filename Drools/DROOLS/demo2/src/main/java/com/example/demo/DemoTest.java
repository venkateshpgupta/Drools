package com.example.demo;


import java.io.IOException;
import java.net.URISyntaxException;

import org.drools.compiler.compiler.DroolsParserException;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;


public class DemoTest {

	public static void main(String[] args) throws DroolsParserException, IOException, URISyntaxException {
		DemoTest client = new DemoTest();
        client.execteRule();
	}

	public void execteRule() throws DroolsParserException, IOException, URISyntaxException{
		   
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("first-ksession-rule");
		
		PaymentOffer paymentOffer = new PaymentOffer();
		
		paymentOffer.setChannel("paytm");
				
		org.kie.api.runtime.rule.FactHandle factHandler;
		
		factHandler = kSession.insert(paymentOffer);
		kSession.fireAllRules(); 
		   
	       
	   } 
}
