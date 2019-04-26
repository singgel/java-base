package com.hks.eightsortingalgorithms.jUnitPerf;

import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @JUnitPerfTest
 Item	定义说明	Default值或说明
 @Rule	申明为JUnit 的Rule类
 JUnitPerfRule	JUnitPerf 测试规则类
 @JunitPerfTest	声明为性能测试方法
 threads	测试使用的线程数
 durationMs	测试持续时间
 warmUpMs	测试热身时间	热身时间的测试数据不会计算进最后的测试结果
 maxExecutionsPerSecond	方法执行的上限	RateLimiter，控制TPS上限

 使用@JUnitPerfTestRequirement 可以给性能测试设置期望值，这个annotation的属性有:
 属性	定义
 percentits	设置例如90%/95%/50% 响应时间的期望
 executionsPerSec	期望每秒执行测试(TPS)
 allowedErrorPercentage	允许错误比例
 minLatency	期望最小延时，如果实际最小延时超过这个数，则失败
 maxLatency	期望最大延时，如果实际最大延时超过这个，则失败
 meanLatency	期望中位数延时
 */
public class DemoServiceTest {
    @Rule
    public JUnitPerfRule perfTestRule = new JUnitPerfRule(new HtmlReportGenerator("perf/report.html"));

    RestTemplate restTemplate;
    @Before
    public void setupService(){
        this.restTemplate = new RestTemplate();
    }

    @Test
    @JUnitPerfTest(threads = 1000,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    @JUnitPerfTestRequirement(percentiles = "90:7,95:7,98:7,99:8", executionsPerSec = 2000, allowedErrorPercentage = 0.10f)
    public void getServiceId() {
        ResponseEntity result = restTemplate.getForEntity("https://blog.csdn.net/singgel/article/details/89397041",String.class,"");
        System.out.println(result);
        Assert.assertNotNull(result);
    }

    @Test
    @JUnitPerfTest(threads = 150,durationMs = 1200,warmUpMs = 100,maxExecutionsPerSecond = 110)
    public void getServiceId_withoutTestRequirement() {
        ResponseEntity result = restTemplate.getForEntity("http://rc.yiche.com/rc/v1/test",String.class,"");
        System.out.println(result);
        Assert.assertNotNull(result);
    }
}
