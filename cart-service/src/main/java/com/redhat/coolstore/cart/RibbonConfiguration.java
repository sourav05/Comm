package com.redhat.coolstore.cart;

import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

public class RibbonConfiguration {

	@Bean
    public IRule ribbonRule(IClientConfig config) {
        return new WeightedResponseTimeRule();
    }
	
	/*public IClientConfig clientConfig(){
		return new ClientConfigurableImpl<Configurable<C>>(new configura)
	}*/
}
