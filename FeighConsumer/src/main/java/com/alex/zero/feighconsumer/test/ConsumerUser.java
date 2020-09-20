package com.alex.zero.feighconsumer.test;

import com.alex.zero.providerapi.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider",/*fallback = ProviderBack.class*/ fallbackFactory = ProviderBackFactory.class)
public interface ConsumerUser extends UserApi {
}
