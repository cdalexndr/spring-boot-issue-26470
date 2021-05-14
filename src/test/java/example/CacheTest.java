package example;

import static org.testng.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheType;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
@AutoConfigureCache(cacheProvider = CacheType.SIMPLE)
public class CacheTest extends AbstractTestNGSpringContextTests {

    @Autowired
    SomeService someService;

    @Test
    public void testCacheable() {
        someService.cacheableMethod(1);
        someService.cacheableMethod(1);
        assertEquals(someService.getCallCount(), 1);
    }

}
