package vttp.ssf.assessment.eventmanagement.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //create an instance of the log
    private Logger logger = Logger.getLogger(AppConfig.class.getName());
    
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;

    @Value("${spring.redis.username}")
    private String redisUser;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.database")
    private Integer redisDatabase;


    @Bean("myredis") //Utils.BEAN_REDDIS
    public RedisTemplate <String, String> createRedisConnection() {
        // create a redis configuration 
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort);
        config.setDatabase(redisDatabase);
        // only set the username and password if they aren't already set
        if("NOT_SET".equals(redisUser.trim())) {
            config.setUsername(redisUser);
            config.setPassword(redisPassword);
        }


        // DONT print out password cos is sensitive info, just do boolean to check if its been set
        logger.log(Level.INFO, "Using Redis database %d".formatted(redisPort));
        logger.log(Level.INFO, "Using Redis password is set: %b".formatted(redisPassword != "NOT_SET"));
        
        JedisClientConfiguration jedisClient = JedisClientConfiguration
            .builder().build();
        JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        jedisFac.afterPropertiesSet();

        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisFac);
        
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());

        return template;
    }
}
