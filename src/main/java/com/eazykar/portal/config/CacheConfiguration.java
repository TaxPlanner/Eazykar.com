package com.eazykar.portal.config;

import java.time.Duration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.jhipster.config.JHipsterProperties;
import io.github.jhipster.config.jcache.BeanClassLoaderAwareJCacheRegionFactory;

@Configuration
@EnableCaching
public class CacheConfiguration {

    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        BeanClassLoaderAwareJCacheRegionFactory.setBeanClassLoader(this.getClass().getClassLoader());
        JHipsterProperties.Cache.Ehcache ehcache =
            jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            cm.createCache(com.eazykar.portal.repository.UserRepository.USERS_BY_LOGIN_CACHE, jcacheConfiguration);
            cm.createCache(com.eazykar.portal.repository.UserRepository.USERS_BY_EMAIL_CACHE, jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.User.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.Authority.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.User.class.getName() + ".authorities", jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.UserProfile.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.EntityAuditEvent.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.ItrApplication.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.Plan.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.UserPlan.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.Address.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.KeyInformation.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.Document.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.SalaryInformation.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.OtherIncome.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.HouseProperty.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.CapitalGain.class.getName(), jcacheConfiguration);
            cm.createCache(com.eazykar.portal.domain.Deduction.class.getName(), jcacheConfiguration);
            // jhipster-needle-ehcache-add-entry
        };
    }
}
