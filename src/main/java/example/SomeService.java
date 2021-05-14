package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    private static final Logger log = LoggerFactory.getLogger(SomeService.class);

    protected int callCount = 0;

    public int getCallCount() {
        return callCount;
    }

    @Cacheable("testcache")
    public int cacheableMethod(int param) {
        ++callCount;
        return 1;
    }
}
